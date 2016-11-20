package dopeCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static Courses[] courses = new Courses[10];
	public static Student[] students = new Student[80];
	public static ArrayList<Integer> randomStudentArrayList = new ArrayList<Integer>();
	public static ArrayList<Integer> randomClassArrayList = new ArrayList<Integer>();

	public static void main(String args[]) {
		students = PopulateStudents.getDataFromStudentsJson();
		courses = PopulateCourses.getDataFromCoursesJson();

		int totalCoursesTaken = 0;

		populateRandomStudentArrayList();
		populateRandomClassArrayList();

		shuffleArrayList();

		int maxValue = 0;

		for (int j = 0; j < 1000; j++) {
			students = PopulateStudents.getDataFromStudentsJson();
			courses = PopulateCourses.getDataFromCoursesJson();

			for (int i = 0; i < 10; i++) {
				sortStudentsByHours();
				if (i % 2 == 0)
					shuffleArrayList();
				for (int k = 0; k < students.length; k++) {
					if (students[k].getCourseCount() < 5) {
						for (int l = 0; l < courses.length; l++) {
							if (checkAvailability1(students[randomStudentArrayList.get(k)],
									courses[randomClassArrayList.get(l)])) {
							} else if (checkAvailability2(students[randomStudentArrayList.get(k)],
									courses[randomClassArrayList.get(l)])) {
							}

							if (courses[l].getSection1StudentCount() > 20
									|| courses[l].getSection2StudentCount() > 20) {
								System.out.println("FUCK");
							}
						}

					}
					totalCoursesTaken += students[k].getCourseCount();
					if (students[k].hasDuplicates()) {
						System.out.println(students[k].toStringCourseList());
					}
				}
				if (totalCoursesTaken > maxValue) {
					maxValue = totalCoursesTaken;
					JSONOutput.students = students;
					JSONOutput.courses = courses;
				}
				totalCoursesTaken = 0;
				
			}
			
		}
		
		System.out.println("Max Value is: " + maxValue);

		try {
			JSONOutput.convertToJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					if (student.getCourseCount() < 5 && course.getSection1StudentCount() < 20) {
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

	public static void populateRandomStudentArrayList() {
		for (int i = 0; i < 80; i++) {
			randomStudentArrayList.add(i);
		}

	}

	public static void populateRandomClassArrayList() {
		for (int i = 0; i < 10; i++) {
			randomClassArrayList.add(i);
		}

	}

	public static void shuffleArrayList() {
		Collections.shuffle(randomStudentArrayList);
		Collections.shuffle(randomClassArrayList);
		// System.out.println(randomArrayList);
	}

	public static void sortStudentsByHours() {
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].getTotalHoursAvailable() < students[j].getTotalHoursAvailable()) {
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
	}

}
