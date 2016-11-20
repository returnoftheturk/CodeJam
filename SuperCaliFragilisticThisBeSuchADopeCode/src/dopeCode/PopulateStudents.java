package dopeCode;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PopulateStudents {
	
	public static Student[] students = new Student[80];

	public static Student[] getDataFromStudentsJson() {
		JSONParser parser = new JSONParser();

		try {
			Object obj1 = parser.parse(new FileReader("Data/studentsByAvailability.json"));
			JSONObject studentList = (JSONObject) obj1;

			for (int i = 1; i <= 80; i++) {
				JSONArray studentArray = (JSONArray) studentList.get(Integer.toString(i));
				String studentName = (String) studentArray.get(0);

				JSONObject studentAvail = (JSONObject) studentArray.get(1);

				TimeSlot[] studentTimes = new TimeSlot[studentAvail.size()];
				for (int j = 0; j < studentAvail.size(); j++) {
					JSONObject availabilityi = (JSONObject) studentAvail.get("avail" + Integer.toString(j + 1));

					studentTimes[j] = new TimeSlot((String) availabilityi.get("day"), (String) availabilityi.get("start"),
							(String) availabilityi.get("end"));

				}
				students[i - 1] = new Student(studentName, studentTimes);
				students[i - 1].setIdNumber(i);
				
				
//				System.out.println(students[i - 1].toString());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

}
