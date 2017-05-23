package Logica;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JSON_ARRAY {
	

	public JSON_ARRAY() throws JSONException, IOException, ParseException {
		super();
		
		JSONParser parser = new JSONParser();
		
			 Object b = parser.parse(new FileReader("album.json"));
			 JSONObject c = (JSONObject) b;
			 @SuppressWarnings("unchecked")
			ArrayList<String> a= (ArrayList<String>) c.get("photos");
			 for(String i : a){
				 System.out.println(i);
			 }
	}
		
	
public static void main(String[] args) throws JSONException, IOException, ParseException {
	
	
	@SuppressWarnings("unused")
	JSON_ARRAY he= new JSON_ARRAY();
}



}
