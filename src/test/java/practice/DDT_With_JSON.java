package practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDT_With_JSON {

	public static void main(String[] args) throws IOException, ParseException {
         /*Read data from JSON*/
		
		//Open the docuemnet in java read format
		FileReader fr = new FileReader(".\\src\\test\\resources\\data.json");
		//Parse the json object
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(fr);
        JSONObject jsonObj = (JSONObject)obj;
		
		//read the key and fetch the value
		String jsonValue=(String) jsonObj.get("name");
		
		System.out.println(jsonValue);
		
	}

}
