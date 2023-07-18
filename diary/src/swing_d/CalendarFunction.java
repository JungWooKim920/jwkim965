package swing_d;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class CalendarFunction {
	
	JLabel[] labels;
	Calendar cal = new GregorianCalendar();
	int year, month;
	
	public CalendarFunction() {
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
	}
	
	public void setLabel(JLabel[] labels) {
		this.labels = labels;
	}
	
	//Label - > 0000년 00월 문자열 리턴
	public String getCalText(){
		return year + "년 " + " " + month + " 월";
	}
	
	
	//라벨의 날짜 출력
	public void calSet() {
		cal.set(year, month -1, 1);
		
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		
		//요일 수 1일시작, 배열 0부터
		firstDay--;
		
		for(int i = 1; i < cal.getActualMaximum(cal.DATE); i++) {
			labels[6 + firstDay+ i].setText(String.valueOf(i));
		}
	}
	
	
	//새로운 년월 출력
	public void allInit(int gap) {
		//라벨 지우기
		for(int i = 7; i < labels.length; i++) {
			labels[i].setText("");
		}
		month += gap;
		if(month <= 0) {
			year --;
			month = 12;
		}else if(month >= 13){
			year++;
			month = 1;
		}
		calSet();
	}
}
