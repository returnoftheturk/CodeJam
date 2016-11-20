package dopeCode;

import java.util.ArrayList;

public class Student {
	private String name;
	private TimeSlot[] time;
	private int idNumber;
	private ArrayList<Courses> courseList1 = new ArrayList<Courses>();
	private ArrayList<Courses> courseList2 = new ArrayList<Courses>();

	public Student(String name, TimeSlot[] time) {
		this.name = name;
		this.time = time;

	}

	public TimeSlot[] getStudentAvailability() {
		return time;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		String formattedString = name;
		for (int i = 0; i < time.length; i++) {
			formattedString += " " + time[i].toString();
		}
		return formattedString;
	}

	public void addCourse1(Courses course) {
		if (!this.courseList1.contains(course) && !this.courseList2.contains(course)
				&& course.getSection1StudentCount() < 20) {
			this.courseList1.add(course);
		}
	}

	public void addCourse2(Courses course) {
		if (!this.courseList2.contains(course) && !this.courseList1.contains(course)
				&& course.getSection2StudentCount() < 20) {
			this.courseList2.add(course);
		}
	}

	public int getCourseCount() {
		return this.courseList1.size() + this.courseList2.size();
	}

	public String toStringCourseList() {
		String formattedString = "";
		for (int i = 0; i < courseList1.size(); i++) {
			formattedString += courseList1.get(i).getName() + " - " + "1\n";
		}
		for (int i = 0; i < courseList2.size(); i++) {
			formattedString += courseList2.get(i).getName() + " - " + "2\n";
		}
		return formattedString;
	}

	public boolean hasDuplicates() {
		boolean hasDup = false;
		for (int i = 0; i < courseList1.size(); i++) {
			String temp = courseList1.get(i).getName();

			for (int j = 0; j < courseList2.size(); j++) {
				if (temp.equals(courseList2.get(j).getName())) {
					return true;
				}
			}
		}

		return hasDup;
	}

	public int getTotalHoursAvailable() {
		int totalHours = 0;
		for (int i = 0; i < time.length; i++) {
			totalHours += time[i].getEndTimeInt();
			totalHours -= time[i].getStartTimeInt();
		}
		return totalHours;
	}

	public void setIdNumber(int id) {
		this.idNumber = id;
	}

	public int getIdNumber() {
		return this.idNumber;
	}

	public String formattedToString() {
		String formattedText = "";
		for (int i = 0; i < courseList1.size(); i++) {
			if (courseList1.get(i).getTime1().getStartTimeInt() < 7
					&& courseList1.get(i).getTime1().getEndTimeInt() < 7) {
				String name = courseList1.get(i).getName();
				String day = courseList1.get(i).getTime1().getDay().toUpperCase();
				String temp = "AM";
				String startTime = courseList1.get(i).getTime1().getStartTimeFormatted().replace(":", "");
				String endTime = courseList1.get(i).getTime1().getEndTimeFormatted().replace(":", "");
				formattedText += name + "-" + day + "-" + temp + startTime + "-" + temp + endTime;

			} else if (courseList1.get(i).getTime1().getStartTimeInt() > 6
					&& courseList1.get(i).getTime1().getEndTimeInt() > 6) {
				String name = courseList1.get(i).getName();
				String day = courseList1.get(i).getTime1().getDay().toUpperCase();
				String temp = "PM";
				String startTime = courseList1.get(i).getTime1().getStartTimeFormatted().replace("pm", "").replace(":",
						"");
				String endTime = courseList1.get(i).getTime1().getEndTimeFormatted().replace("pm", "").replace(":", "");
				formattedText += name + "-" + day + "-" + temp + startTime + "-" + temp + endTime;

			} else if (courseList1.get(i).getTime1().getStartTimeInt() < 7
					&& courseList1.get(i).getTime1().getEndTimeInt() > 6) {
				String name = courseList1.get(i).getName();
				String day = courseList1.get(i).getTime1().getDay().toUpperCase();
				String temp1 = "AM";
				String temp2 = "PM";
				String startTime = courseList1.get(i).getTime1().getStartTimeFormatted().replace(":", "");
				String endTime = courseList1.get(i).getTime1().getEndTimeFormatted().replace("pm", "").replace(":", "");
				formattedText += name + "-" + day + "-" + temp1 + startTime + "-" + temp2 + endTime;

			}
			formattedText += ",";
		}
		for (int i = 0; i < courseList2.size(); i++) {
			if (courseList2.get(i).getTime2().getStartTimeInt() < 7
					&& courseList2.get(i).getTime2().getEndTimeInt() < 7) {
				String name = courseList2.get(i).getName();
				String day = courseList2.get(i).getTime2().getDay().toUpperCase();
				String temp = "AM";
				String startTime = courseList2.get(i).getTime2().getStartTimeFormatted().replace(":", "");
				String endTime = courseList2.get(i).getTime2().getEndTimeFormatted().replace(":", "");
				formattedText += name + "-" + day + "-" + temp + startTime + "-" + temp + endTime;

			} else if (courseList2.get(i).getTime2().getStartTimeInt() > 6
					&& courseList2.get(i).getTime2().getEndTimeInt() > 6) {
				String name = courseList2.get(i).getName();
				String day = courseList2.get(i).getTime2().getDay().toUpperCase();
				String temp = "PM";
				String startTime = courseList2.get(i).getTime2().getStartTimeFormatted().replace("pm", "").replace(":",
						"");
				String endTime = courseList2.get(i).getTime2().getEndTimeFormatted().replace("pm", "").replace(":", "");
				formattedText += name + "-" + day + "-" + temp + startTime + "-" + temp + endTime;

			} else if (courseList2.get(i).getTime2().getStartTimeInt() < 7
					&& courseList2.get(i).getTime2().getEndTimeInt() > 6) {
				String name = courseList2.get(i).getName();
				String day = courseList2.get(i).getTime2().getDay().toUpperCase();
				String temp1 = "AM";
				String temp2 = "PM";
				String startTime = courseList2.get(i).getTime2().getStartTimeFormatted().replace(":", "");
				String endTime = courseList2.get(i).getTime2().getEndTimeFormatted().replace("pm", "").replace(":", "");
				formattedText += name + "-" + day + "-" + temp1 + startTime + "-" + temp2 + endTime;

			}
			if(i!=courseList2.size()-1)
				formattedText += ",";
		}
		
		return formattedText;
	}

}