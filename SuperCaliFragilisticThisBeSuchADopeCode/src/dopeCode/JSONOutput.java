package dopeCode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONObject;

public class JSONOutput {
	public static Student[] students = new Student[80];
	public static Courses[] courses = new Courses[10];

	public JSONOutput(Student[] student, Courses[] course) {
		JSONOutput.students = student;
		JSONOutput.courses = course;
	}

	public static String convertToJson() throws IOException {
		String formattedJson = "";

		JSONObject jsonMainCourses = new JSONObject();
		JSONObject jsonMainStudents = new JSONObject();
		JSONObject jsonMainMain = new JSONObject();

		for (int i = 0; i < courses.length; i++) { // for each class

			JSONObject jsonSection1 = new JSONObject();
			JSONObject jsonSection2 = new JSONObject();
			JSONObject jsonClass = new JSONObject();

			for (int k = 0; k < courses[i].getSection1StudentCount(); k++) {

				JSONObject jsonStudent = new JSONObject();
				jsonStudent.put("id", Integer.toString(courses[i].section1StudentList.get(k).getIdNumber()));
				jsonStudent.put("name", courses[i].section1StudentList.get(k).getName());

				jsonSection1.put("student" + Integer.toString(k+1), jsonStudent);
			}

			for (int k = 0; k < courses[i].getSection2StudentCount(); k++) {

				JSONObject jsonStudent = new JSONObject();
				jsonStudent.put("id", Integer.toString(courses[i].section2StudentList.get(k).getIdNumber()));
				jsonStudent.put("name", courses[i].section2StudentList.get(k).getName());

				jsonSection2.put("student" + Integer.toString(k+1), jsonStudent);
			}

			jsonClass.put(courses[i].getTime1().toStringJsonSectionName(), jsonSection1);
			jsonClass.put(courses[i].getTime2().toStringJsonSectionName(), jsonSection2);

			jsonMainCourses.put(courses[i].getName(), jsonClass);

		}
		
				
		for (int i = 0; i<students.length; i++){
			JSONObject jsonStudent = new JSONObject();
			jsonStudent.put("id", students[i].getIdNumber());
			jsonStudent.put("name", students[i].getName());
			jsonStudent.put("classesTaken", students[i].formattedToString());
			
			jsonMainStudents.put("student"+Integer.toString(i+1), jsonStudent);
			
		}

		jsonMainMain.put("students", jsonMainStudents);
		jsonMainMain.put("classes", jsonMainCourses);
		System.out.println(jsonMainMain);
		
		FileWriter file = new FileWriter ("Data/json.json");
		
		
		try {
			file.write(jsonMainMain.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
		
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			file.flush();
			file.close();
		}
		
		return formattedJson;
	}
}
