package Logica;

import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("deprecation")
public class Analizador {
	private HttpPost request;
	private HttpClient httpclient;
	private JSONObject Obj;

	public Analizador(){
		httpclient = new DefaultHttpClient();
		
	    try
	    {
	        URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/vision/v1.0/analyze");
	        builder.setParameter("visualFeatures", "Description,Tags");
	        builder.setParameter("language", "en");
	        URI uri = builder.build();
	        request = new HttpPost(uri);
	
	        // Request headers - replace this example key with your valid subscription key.
	        request.setHeader("Content-Type", "application/json");
	        request.setHeader("Ocp-Apim-Subscription-Key", "8aeae71ad6e6445c8e66cc69c280b126");
	    }
	    catch (Exception e)
		{
	    	System.out.println(e.getMessage());
		}  
	}
	
	
	public void Analizar(String Url){
	    try
	    {
	        // Request body. Replace the example URL with the URL for the JPEG image of a celebrity.
	        StringEntity reqEntity = new StringEntity("{\"url\":\""+Url+"\"}");
	        request.setEntity(reqEntity);
	        HttpResponse response = httpclient.execute(request);
	        HttpEntity entity = response.getEntity();
	        if (entity != null)
	        {
	        	Obj = new JSONObject(EntityUtils.toString(entity));
	        }
	    }
	    catch (Exception e)
	    {
	        System.out.println(e.getMessage());
	    }
	}
	
	
	public String Descripcion() throws JSONException{
		JSONObject Description = Obj.getJSONObject("description");
    	JSONArray Array = Description.getJSONArray("captions");
    	String Text = Array.getJSONObject(0).getString("text");
    	return Text;
	}
	
	
	public ArrayList<String> Tags() throws JSONException{
		ArrayList<String> Tags = new ArrayList<String>();
		JSONArray Arr = Obj.getJSONArray("tags");
    	for (int i = 0; i < 3; i++)
    	{
    		Tags.add(Arr.getJSONObject(i).getString("name"));
    	}
    	return Tags;
	}
}
