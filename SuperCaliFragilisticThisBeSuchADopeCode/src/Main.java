
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Main {
	public static void main(String args[]) {
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("/McGill/codejam/Junior_Team30/classes.json"));
			System.out.println(obj.toString());
			JSONObject classes = (JSONObject) obj;
//			JSONArray classesArray = (JSONArray) classes.get("classes");
			JSONObject classesObject = (JSONObject) classes.get("classes");
			System.out.println(classesObject);
			String coursename="";
			System.out.println(classesObject.size());
			for (int i = 1; i < classesObject.size(); i++) {
				int courseNumber = 100 + i;
				JSONObject course = (JSONObject) classesObject.get(Integer.toString(courseNumber));
				System.out.println(course);
				JSONObject times = (JSONObject) course.get("times");
				JSONObject time1 = (JSONObject) times.get("time1");
				JSONObject time2 = (JSONObject) times.get("time2");
				String day = (String) time1.get("day");
				System.out.println(day);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String getDataFromJson() {
		

		// int numTrailers = trailersArray.length();
		String youtubePath = "";
		// String trailerDescJson = "";
		//
		// for (int i = 0; i <numTrailers ; i++) {
		// JSONObject trailer = trailersArray.getJSONObject(i);
		// youtubePath = trailer.getString("key");
		// trailerDescJson = trailer.getString("name");
		// mDescList.add(trailerDescJson);
		// mTrailerAdapter.setArrayLists(trailerDescJson, youtubePath);
		// }

		return youtubePath;
	}

}
