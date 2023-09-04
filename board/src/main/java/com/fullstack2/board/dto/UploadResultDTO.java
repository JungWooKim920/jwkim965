package com.fullstack2.board.dto;


import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResultDTO {

	//서버의 폴더에 저장된 이미지의 경로 및 이름을 얻어내서 사용자에게
	//img src 의 값으로 지정될 경로를 되돌려 줍니다.
	
	private String fileName;
	private String uuid;
	private String folderPath;
	
	public String getImageURL() {
		try {
			//웹 상에서 문자열이 파라미터로 넘어가거나 할 때, 특히 한글은 URLEncoding 을 해주지 않으면
			//데이터가 깨질 수 있음..따라서 Encoding 후 리턴함
			return URLEncoder.encode(folderPath + "/" + uuid + "_" + fileName, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
}
