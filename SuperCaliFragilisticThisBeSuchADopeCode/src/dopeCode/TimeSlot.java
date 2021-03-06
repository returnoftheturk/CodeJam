package dopeCode;

import java.sql.Time;

public class TimeSlot {
	public String day;
	public String startTime;
	public String endTime;
	public int startTimeInt;
	public int endTimeInt;
	public Boolean[] availability = new Boolean[18];

	public TimeSlot(String day, String startTime, String endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startTimeInt = convertTimeToInt(startTime); 
		this.endTimeInt = convertTimeToInt(endTime); 

	}

	public String getDay() {
		return this.day;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	
	public int getStartTimeInt(){
		return this.startTimeInt;
	}
	
	public int getEndTimeInt(){
		return this.endTimeInt;
	}

	public String toString() {
		return "\nDay: " + day + "-Start Time: " + startTime + "-End Time: " + endTime;
	}

	public void setStartTime(String newStartTime) {
		this.startTime = newStartTime;
		this.startTimeInt = convertTimeToInt(newStartTime);
		
	}

	public void setEndTime(String newEndTime) {
		this.endTime = newEndTime;
		this.endTimeInt = convertTimeToInt(newEndTime);
	}

	public int convertTimeToInt(String inputTime) {
		switch (inputTime) {
		case "08:00am":
			return 0;
		case "08:30am":
			return 1;
		case "09:00am":
			return 2;
		case "09:30am":
			return 3;
		case "10:00am":
			return 4;
		case "10:30am":
			return 5;
		case "11:00am":
			return 6;
		case "11:30am":
			return 7;
		case "12:00pm":
			return 8;
		case "12:30pm":
			return 9;
		case "01:00pm":
			return 10;
		case "01:30pm":
			return 11;
		case "02:00pm":
			return 12;
		case "02:30pm":
			return 13;
		case "03:00pm":
			return 14;
		case "03:30pm":
			return 15;
		case "04:00pm":
			return 16;
		case "04:30pm":
			return 17;
		case "05:00pm":
			return 18;
		default:
			return 19;

		}
	}
	
	public String toStringJsonSectionName(){
		String formattedString = "";
		String upperCaseName = day.toUpperCase();
		formattedString+= upperCaseName + "-" + convertTimeToString(startTime) + "-" + convertTimeToString(endTime);
		return formattedString;
	}
	
	public String convertTimeToString(String inputTime) {
		switch (inputTime) {
		case "08:00am":
			return "AM0800";
		case "08:30am":
			return "AM0830";
		case "09:00am":
			return "AM0900";
		case "09:30am":
			return "AM0930";
		case "10:00am":
			return "AM1000";
		case "10:30am":
			return "AM1030";
		case "11:00am":
			return "AM1100";
		case "11:30am":
			return "AM1130";
		case "12:00pm":
			return "PM1200";
		case "12:30pm":
			return "PM1230";
		case "01:00pm":
			return "PM0100";
		case "01:30pm":
			return "PM0130";
		case "02:00pm":
			return "PM0200";
		case "02:30pm":
			return "PM0230";
		case "03:00pm":
			return "PM0300";
		case "03:30pm":
			return "PM0330";
		case "04:00pm":
			return "PM0400";
		case "04:30pm":
			return "PM0430";
		case "05:00pm":
			return "PM0500";
		default:
			return "";

		}
	}
	
	public String getStartTimeFormatted(){
		String formattedOutPut="";
		
		
		formattedOutPut= startTime.replaceFirst("pm", "");	
		formattedOutPut= startTime.replaceFirst("am","");

		
		return formattedOutPut;
		
	}
	public String getEndTimeFormatted(){
		String formattedOutPut="";
		
		formattedOutPut= endTime.replaceFirst("pm", "");
		formattedOutPut= endTime.replaceFirst("am", "");

		

		return formattedOutPut;
	}
}
