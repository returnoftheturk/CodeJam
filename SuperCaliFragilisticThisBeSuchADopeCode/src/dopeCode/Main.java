package dopeCode;

public class Main {
	public static Courses[] courses = new Courses[10];
	public static Student[] students = new Student[80];

	public static void main(String args[]) {
		students = PopulateStudents.getDataFromStudentsJson();
		courses = PopulateCourses.getDataFromCoursesJson();

		int totalCoursesTaken = 0;

		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < courses.length; j++) {
				for (int k = i; k < students.length; k++) {
					if (students[k].getCourseCount() < 5) {
						for (int l = j; l < courses.length; l++) {
							if (checkAvailability1(students[k], courses[l])) {
							} else if (checkAvailability2(students[k], courses[l])) {
							}
							if (l==courses.length-1 && j!=0){
								l=0;
							}
							if (l==j-1 && j!=0){
								break;
							}
						}
					}
					if (k==students.length-1 && i!=0){
						k=0;
					}
					if (k==i-1 && i!=0){
						break;
					}
					
					
					totalCoursesTaken += students[k].getCourseCount();
				
				
				}
				
//				for (int i = 0; i < 10; i++) {
//					System.out.println("\n Course: " + courses[i] + " " + courses[i].toStringStudentList());
//				}
				System.out.println(totalCoursesTaken);
				totalCoursesTaken = 0;
			
			
			}
		}
	}

	public static boolean checkAvailability1(Student student, Courses course) {
		TimeSlot[] studentAvailability = student.getStudentAvailability();
		TimeSlot courseTime = course.getTime1();
		for (int i = 0; i < studentAvailability.length; i++) {
			if (studentAvailability[i].getDay().equals(courseTime.getDay())) {
				if (studentAvailability[i].getStartTimeInt() <= courseTime.getEndTimeInt()
						&& studentAvailability[i].getEndTimeInt() >= courseTime.getEndTimeInt()) {
					if (student.getCourseCount() < 5 && course.getSection2StudentCount() < 20) {
						studentAvailability[i].setStartTime(courseTime.getEndTime());
						student.addCourse1(course);
						course.addStudentSection1(student);
						// updates start time. might need to also check end
						// time.
						// possible bug
						// student is available for this class at this time
						return true;
					}
				}

			}

		}
		return false;
	}

	public static boolean checkAvailability2(Student student, Courses course) {
		TimeSlot[] studentAvailability = student.getStudentAvailability();
		TimeSlot courseTime = course.getTime2();

		for (int i = 0; i < studentAvailability.length; i++) {
			if (studentAvailability[i].getDay().equals(courseTime.getDay())) {
				if (studentAvailability[i].getStartTimeInt() <= courseTime.getEndTimeInt()
						&& studentAvailability[i].getEndTimeInt() >= courseTime.getEndTimeInt()) {
					if (student.getCourseCount() < 5 && course.getSection2StudentCount() < 20) {
						studentAvailability[i].setStartTime(courseTime.getEndTime());
						student.addCourse2(course);
						course.addStudentSection2(student);
						// updates start time. might need to also check end
						// time.
						// possible bug
						// student is available for this class at this time
						return true;
					}

				}

			}

		}
		return false;
	}

}