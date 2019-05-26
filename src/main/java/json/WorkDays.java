package json;

import org.json.JSONArray;

/**
 * Class WorkDays that starts the program.
 * 
 * @author Per Sundberg
 *
 */
public class WorkDays {

	public static void main(String[] args) {
		String yearMonth = "1904";
		JSONDateData parser = new JSONDateData();
		JSONArray jsonArray = parser.getJSONdaysArray(yearMonth);

		int numberOfWorkingdays = 0;
		for (int i = 0; i < jsonArray.length(); i++) {
			String notWorkingDay = jsonArray.getJSONObject(i).getString("arbetsfri dag");
			if (notWorkingDay.equals("Nej")) {
				numberOfWorkingdays++;
			}
		}
		System.out.println("Number of working days for year "
		+yearMonth.substring(0, 2) + " month " + yearMonth.substring(3, 4)+
		" are " + numberOfWorkingdays+".");
	}
}
