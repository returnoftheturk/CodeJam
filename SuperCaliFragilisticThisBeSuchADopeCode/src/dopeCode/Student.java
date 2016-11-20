package dopeCode;

import java.util.ArrayList;

public class Student {
	ArrayList<Availabilities> avails = new ArrayList<Availabilities>();
	ArrayList<Courses> registeredCourses = new ArrayList<Courses>();
	double mondayAvail;
	double tuesdayAvail;
	double wednesdayAvail;
	double thursdayAvail;
	double fridayAvail;
	double saturdayAvail;
	double sundayAvail;
	private String name;
	private Time [] time;
	
	public Student(String name, Time [] time){
		this.name = name;
		this.time = time;
		
	}
	
	public String toString(){
		String formattedString = name;
		for (int i = 0; i<time.length; i++){
			formattedString += " " + time[i].toString();
		}
		return formattedString;
	}
	
}