package dopeCode;

public class Main {
	public static Courses[] courses = new Courses[10];
	public static Student[] students = new Student[80];

	public static void main(String args[]) {
		students = PopulateStudents.getDataFromStudentsJson();
		courses = PopulateCourses.getDataFromCoursesJson();
		
//		for (int i = 0; i<courses.length; i++){
//			System.out.println(courses[i].getTime2().getStartTimeInt());
//			
//		}
		int totalCoursesTaken = 0;
		
//		for (int i = 0; i<students.length; i++){
//			for (int j = 0; j<courses.length; j++){
				for(int k=0; k<students.length;k++){
					if(students[k].getCourseCount()<5){
						for(int l=0; l<courses.length;l++){
							if (checkAvailability1(students[k], courses[l])){
//								checkAvailability1(students[k], courses[l]);
//								System.out.println("Section1");
							} else if (checkAvailability2(students[k], courses[l])){
//								checkAvailability2(students[k], courses[l]);
//								System.out.println("Section2");	
							}
//							System.out.println(courses[l].getSection1StudentCount());
//							System.out.println(courses[l].getSection2StudentCount());
						}
						System.out.println("\n Student: " + k + " " + students[k].toStringCourseList());
					}
					totalCoursesTaken+=students[k].getCourseCount();
//					System.out.println(students[k].getCourseCount());
				}
//				System.out.println(totalCoursesTaken);
				totalCoursesTaken = 0;
//			}
//		}
	}
	
	public static boolean checkAvailability1(Student student, Courses course){
		TimeSlot[] studentAvailability = student.getStudentAvailability();
		TimeSlot courseTime = course.getTime1();
//		System.out.println("Entered Method");
		for (int i = 0; i<studentAvailability.length; i++){
			if (studentAvailability[i].getDay().equals(courseTime.getDay())){
//				System.out.println("First If Statement");
				if(studentAvailability[i].getStartTimeInt()<= courseTime.getEndTimeInt()&& 
						studentAvailability[i].getEndTimeInt()>=courseTime.getEndTimeInt()){
					if(student.getCourseCount()<5 && course.getSection2StudentCount()<20){
						studentAvailability[i].setStartTime(courseTime.getEndTime());
						student.addCourse1(course);
						course.addStudentSection1(student);
						//updates start time.  might need to also check end time.
						//possible bug
						// student is available for this class at this time 
						return true;
					}
				}
				
			}
			
		}
		return false;
	}
	
	public static boolean checkAvailability2(Student student, Courses course){
		TimeSlot[] studentAvailability = student.getStudentAvailability();
		TimeSlot courseTime = course.getTime2();
		
		for (int i = 0; i<studentAvailability.length; i++){
			if (studentAvailability[i].getDay().equals(courseTime.getDay())){
				if(studentAvailability[i].getStartTimeInt()<= courseTime.getEndTimeInt()&& 
						studentAvailability[i].getEndTimeInt()>=courseTime.getEndTimeInt()){
					if(student.getCourseCount()<5 && course.getSection2StudentCount()<20){
						studentAvailability[i].setStartTime(courseTime.getEndTime());
						student.addCourse2(course);
						course.addStudentSection2(student);
						//updates start time.  might need to also check end time.
						//possible bug
						// student is available for this class at this time 
						return true;
					}
					
				}
				
			}
			
		}
		return false;
	}

}
