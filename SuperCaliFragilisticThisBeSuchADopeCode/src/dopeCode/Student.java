package dopeCode;

import java.util.ArrayList;

public class Student {
	private String name;
	private TimeSlot [] time;
	private  ArrayList<Courses> courseList = new ArrayList<Courses>();
	
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
	
	public  void addCourse(Courses course){
		if(!this.courseList.contains(course)){
			this.courseList.add(course);
		}
	}
	
	public int getCourseCount (){
		return this.courseList.size();
	}
	
	
}