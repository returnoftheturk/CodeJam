package dopeCode;

public class Courses {
	private final String name;
	private final TimeSlot time1, time2;
	
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

}
