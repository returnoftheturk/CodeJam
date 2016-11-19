package dopeCode;

public class Time {
	public String day;
	public String startTime;
	public String endTime;
	
	public Time(String day, String startTime, String endTime){
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getDay(){
		return this.day;
	}
	
	public String getStartTime(){
		return this.startTime;
	}
	
	public String getEndTime(){
		return this.endTime;
	}
	
	public String toString(){
		return "\nDay: " + day + "-Start Time: " + startTime + "-End Time: " + endTime;
	}
}
