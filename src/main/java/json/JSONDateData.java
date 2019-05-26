package json;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONDateData {

	JSONArray JSONdaysArray;

	/**
	 * Constructor
	 */
	public JSONDateData() {
	}

	/**
	 * Method getUrl that fetches Json from web and return data.
	 * 
	 * @param yearMonth
	 * @return
	 */
	URL getUrl(String yearMonth) {
		URL data = null;
		try {
			data = new URL(
					"https://api.dryg.net/dagar/v2.1/20" + yearMonth.substring(0, 2)
					+ "/" + yearMonth.substring(3, 4));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Method getTokener that get token from url-data.
	 * 
	 * Inparameter: url Return value: tokener
	 */
	JSONTokener getTokener(URL url) {
		JSONTokener tokener = null;
		try {
			tokener = new JSONTokener(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tokener;
	}

	/**
	 * Method that convert tokener data to JSONArray.
	 * 
	 * @param tokener
	 * @return
	 */
	JSONArray createJSONArray(JSONTokener tokener) {
		JSONObject obj = new JSONObject(tokener);
		JSONArray daysArray = obj.getJSONArray("dagar");
		return daysArray;
	}

	/**
	 * Method that displays and JSONDateArray, optional
	 * 
	 * @param jsonArray
	 */
	void displayJSONDateArray(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.length(); i++) {
			System.out.println(jsonArray.getJSONObject(i));
		}
	}

	/**
	 * Method to get JSON data from an API and return the data as an array.
	 * 
	 * @param yearMonth
	 * @return JSON array with day data
	 */
	public JSONArray getJSONdaysArray(String yearMonth) {
		URL url = getUrl(yearMonth);
		JSONTokener tokener = getTokener(url);
		JSONArray JSONDateArray = createJSONArray(tokener);
		// displayJSONDateArray(JSONDateArray);
		return JSONDateArray;
	}

}
