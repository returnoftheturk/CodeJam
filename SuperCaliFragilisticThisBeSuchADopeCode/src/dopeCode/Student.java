package dopeCode;

import java.util.ArrayList;

public class Student {
	private String name;
	private TimeSlot [] time;
	
	public Student(String name, TimeSlot [] time){
		this.name = name;
		this.time = time;
		
	}
	
	public TimeSlot[] getStudentAvailability(){
		return time;
	}
	
	public String toString(){
		String formattedString = name;
		for (int i = 0; i<time.length; i++){
			formattedString += " " + time[i].toString();
		}
		return formattedString;
	}
	
}