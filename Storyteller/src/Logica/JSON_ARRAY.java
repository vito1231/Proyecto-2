package Logica;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import InterfazGrafica.Slide;
public class JSON_ARRAY {
	private Object Obj;
	
	public JSON_ARRAY(String File) throws JSONException, IOException, ParseException, InterruptedException {
		super();
		JSONParser Parser = new JSONParser();
		Obj = Parser.parse(new FileReader(File));
	}
	
	
	public ArrayList<String> ObtenerURLs(){
		JSONObject JObj = (JSONObject) Obj;
		@SuppressWarnings("unchecked")
		ArrayList<String> Array = (ArrayList<String>) JObj.get("photos");
		return Array;
	}	
}