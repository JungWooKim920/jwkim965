package com.fullstack2.board.controller;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fullstack2.board.dto.UploadResultDTO;

import net.coobird.thumbnailator.Thumbnailator;


/*
 * 파일 업로드는 mulpart 라는 http 전송 시 속성을 이용합니다.
 * 그리고 모든 파일은 전송 시 post 로 전송이 되어집니다.
 * 때문에 서버에서는 post 로 매핑하고, 서블릿의 multipart 도메인의 API 를 
 * 이용 처리합니다.
 */
@RestController
public class UploadController {

	@Value("${com.fullstack2.board.path}")
	private String uploadPath;
	
	
	
	@PostMapping("/uploadajax")
	//MultipartFile 객체가 업로드를 수행하는 클래스입니다.
	//하나 이상의 파일을 요청 시엔 이 값을 배열로 담을 수 있도록 배열로 파람을 처리합니다.
	public ResponseEntity<List<UploadResultDTO>> uploadFile(@RequestParam("upFiles") MultipartFile[] uploadFiles) {
		
		//이미지 업로드 결과, 즉 서버에 업로드된 이미지 패스 등이 담긴 DTO List
		List<UploadResultDTO> resultDTOs = new ArrayList<>();
		
		for(MultipartFile upFile : uploadFiles) {
			
			
			//서버에서 MultiPartFile 의 메서드를 이용해서 파일의 타입을 알아낼 수 있습니다.
			//이미인지 여부를 확인해 볼게요.
			if(upFile.getContentType().startsWith("image") == false) {
				System.err.println("이미지 파일이 아닙니다...");
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			
			
			
			
			//파일의 경로 조심...항상 확인해야 함...브라우저 마다 경로를 보낼 때 차이가 남
			String orgName = upFile.getOriginalFilename();
			
			String fileName = orgName.substring(orgName.lastIndexOf("\\") + 1);
			System.err.println("파일이름 : " + fileName);
			
			String folderPath = makeFolder();
			
			
			//Java.util UUID API 를 이용해서 파일이름은 Uid 로 변경할게요
			String uuid = UUID.randomUUID().toString();
			
			String saveName = uploadPath + File.separator
					+ folderPath + File.separator + uuid + "_" +fileName;
			
			Path path = Paths.get(saveName);//Paths...입니다.
			
			try {
				//원본 파일저장 실행...
				upFile.transferTo(path);
				
				//썸네일이미지 생성 시작...이미지 이름을 먼저 생성할게요.
				//썸네일명은 소문자 s 를 줘서 구분을 시킵니다.
				String thumbSaveNm = uploadPath + File.separator + folderPath
						+File.separator + "s_" + uuid + fileName;
				//썸네일 이미지를 가진 File 객체 생성
				File thumbFile = new File(thumbSaveNm);
				
				//썸네일 생성 API 를 이용해서 생성합니다.
				//Thubmnailator.creatXXXXXXX 를 이용해서 생성합니다. 무지 쉬움..
			Thumbnailator.createThumbnail(path.toFile(),thumbFile, 100, 150);
				
				
				//이미지 업로드 완료 후 응답을 DTO List 로 보냅니다.
				resultDTOs.add(new UploadResultDTO(fileName, uuid, folderPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//End of for..
		
		return new ResponseEntity<>(resultDTOs,HttpStatus.OK);
	}
	//사용자에게 이미지가 업로드 완성된 후 되돌려준 img 경로에 대한 요청이 올 때 처리할 
	//메서드 정의함.
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileName) {
		ResponseEntity<byte[]> result = null;
		
		try {
			//링크에 실려온 이미지 경로를 이용, 스트림을 통해 읽고, 보내기
			String srcFileName = URLDecoder.decode(fileName, "utf-8");
			File file = new File(uploadPath + File.separator + srcFileName);
			
			//사용자에게 보내줄 데이터가 binary 라는 걸 헤더에 세팅을 해야
			//브라우저가 이에 맞춘 랜더링을 합니다...따라서 header setting
			HttpHeaders headers = new HttpHeaders();
			
			//mimeType 처리..
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers,HttpStatus.OK);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	
	
	
	
	
	//업로드 날짜별로 업로드되는 폴더를 생성하는 메서드입니다.
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		String folderPath = str.replace("/", File.separator);
		
		File uploadPathFolder = new File(uploadPath,folderPath);
		
		if(uploadPathFolder.exists() == false) {
			//이거 반드시 mkdirs() 로 하세요.
			uploadPathFolder.mkdirs();
		}
		
		return folderPath;
	}
	
	
	
}

































