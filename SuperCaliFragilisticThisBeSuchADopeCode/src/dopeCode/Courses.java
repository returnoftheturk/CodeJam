package dopeCode;

public class Courses {
	private final String name;
	private final Time time1, time2;
	
	public Courses(String name, Time time1, Time time2){
		this.name = name;
		this.time1 = time1;
		this.time2 = time2;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Time getTime1(){
		return this.time1;
	}
	
	public Time getTime2(){
		return this.time2;
	}

}
