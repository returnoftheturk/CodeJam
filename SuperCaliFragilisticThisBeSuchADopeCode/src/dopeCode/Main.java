package dopeCode;

import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Main {
	public static Courses [] courses = new Courses[10];
	public static Student [] students = new Student[80];
	
	public static void main(String args[]) {
		getDataFromStudentsJson();
	}
	
	public static void getDataFromCoursesJson(){
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("/McGill/codejam/Junior_Team30/classes.json"));
//			System.out.println(obj.toString());
			JSONObject classes = (JSONObject) obj;
			
			JSONObject classesObject = (JSONObject) classes.get("classes");
//			System.out.println(classesObject);

//			System.out.println(classesObject.size());
			for (int i = 1; i <= classesObject.size(); i++) {
				String name, day1, start1, end1, day2, start2, end2;
				int courseNumber = 100 + i;
				
				JSONObject courseObject = (JSONObject) classesObject.get(Integer.toString(courseNumber));
//				System.out.println(courseObject);
				
				name = (String) courseObject.get("name");
				
				JSONObject times = (JSONObject) courseObject.get("times");
				
				JSONObject timeObject1 = (JSONObject) times.get("time1");
				day1 = (String) timeObject1.get("day");
				start1 = (String) timeObject1.get("start");
				end1 = (String) timeObject1.get("end");
				
				JSONObject timeObject2 = (JSONObject) times.get("time2");
				day2 = (String) timeObject2.get("day");
				start2 = (String) timeObject2.get("start");
				end2 = (String) timeObject2.get("end");
				
				Time time1 = new Time (day1, start1, end1);
				Time time2 = new Time (day2, start2, end2);
				
//				System.out.println(time1.toString());
//				System.out.println(time2.toString());
				
				courses[i-1] = new Courses(name, time1, time2);
				System.out.println(courses[i-1].toString());
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void getDataFromStudentsJson(){
		JSONParser parser = new JSONParser();

		try {
			Object obj1 = parser.parse(new FileReader("/McGill/codejam/Junior_Team30/studentsByAvailability.json"));
			JSONObject studentList = (JSONObject) obj1;
			
			for (int i = 1; i<=80; i++){
				JSONArray studentArray = (JSONArray) studentList.get(Integer.toString(i)); 
				String studentName = (String) studentArray.get(0);
				
				JSONObject studentAvail = (JSONObject) studentArray.get(1);
				
				Time [] studentTimes = new Time [studentAvail.size()];
				for (int j = 0; j<studentAvail.size(); j++){
					JSONObject availabilityi = (JSONObject) studentAvail.get("avail"+Integer.toString(j+1));

					studentTimes[j] = new Time ((String)availabilityi.get("day"), (String)availabilityi.get("start"), (String)availabilityi.get("end"));
					
				}
				students[i-1] = new Student (studentName, studentTimes);
				System.out.println(students[i-1].toString());
				
				
				
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}



}
