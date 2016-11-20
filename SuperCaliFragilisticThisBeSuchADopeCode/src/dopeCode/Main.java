package dopeCode;

import org.json.simple.parser.ParseException;

public class Main {
	public static Courses[] courses = new Courses[10];
	public static Student[] students = new Student[80];

	public static void main(String args[]) {
		students = PopulateStudents.getDataFromStudentsJson();
		courses = PopulateCourses.getDataFromCoursesJson();
	}

}
