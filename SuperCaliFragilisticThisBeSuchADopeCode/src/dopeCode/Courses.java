package dopeCode;

import java.util.ArrayList;

public class Courses {
	private final String name;
	private final TimeSlot time1, time2;
	ArrayList<Student> section1StudentList = new ArrayList<Student>();
	ArrayList<Student> section2StudentList = new ArrayList<Student>();
	
	public Courses(String name, TimeSlot time1, TimeSlot time2){
		this.name = name;
		this.time1 = time1;
		this.time2 = time2;
	}
	
	public String getName(){
		return this.name;
	}
	
	public TimeSlot getTime1(){
		return this.time1;
	}
	
	public TimeSlot getTime2(){
		return this.time2;
	}
	
	public String toString(){
		return "Name: " + name + "\nTime 1: " + time1.toString() + "\nTime 2: " + time2.toString();
	}
	
	public void addStudentSection1(Student student){
		if(!this.section1StudentList.contains(student) && this.section1StudentList.size()<20){
			this.section1StudentList.add(student);
		}
	}
	public void addStudentSection2(Student student){
		if(!this.section2StudentList.contains(student) && this.section2StudentList.size()<20){
			this.section2StudentList.add(student);
		}
	}
	public int getSection1StudentCount(){
		return this.section1StudentList.size();
	}
	public int getSection2StudentCount(){
		return this.section2StudentList.size();
	}
	
	public String toStringStudentList(){
		String formattedString = "";
		for (int i = 0; i < section1StudentList.size(); i++){
			formattedString+= section1StudentList.get(i).getName() + " - " + "1\n";
		}
		for (int i = 0; i < section2StudentList.size(); i++){
			formattedString+= section2StudentList.get(i).getName() + " - " + "2\n";
		}
		return formattedString;
	}
	

}