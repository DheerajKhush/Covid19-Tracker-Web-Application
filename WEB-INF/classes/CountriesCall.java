import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author user
 */
public class CountriesCall {
     
     //countries
     public static List countriesDataCall(){
          //variables  
        List<String> listCountriList= new ArrayList<>();
           
          // api call for countries available
          OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
	.url("https://covid-193.p.rapidapi.com/countries")
	.get()
	.addHeader("x-rapidapi-host", "covid-193.p.rapidapi.com")
	.addHeader("x-rapidapi-key", "af4a92b72bmshece02652aae480fp14a3c4jsnea3fa79a71f5")
	.build();

          try {
               Response response = client.newCall(request).execute();
               System.out.println("Result"+ response.body());
               String resStr = response.body().string();    
               System.out.println(resStr);
               // json data for countries
               JSONParser jsonParser = new JSONParser();
               
               Object obj=null;
               try {
                    obj = jsonParser.parse(resStr);
               } catch (ParseException ex) {
                    Logger.getLogger(CountriesCall.class.getName()).log(Level.SEVERE, null, ex);
               }
                JSONObject jsonObject = (JSONObject)obj;
               JSONArray array=(JSONArray)jsonObject.get("response");
               for(int i=0;i<array.size();i++){
                       String st=(String)array.get(i);
                       System.out.println(st);
                      
                       listCountriList.add(st);
                           
               
               }
               
          } catch (IOException ex) {
               Logger.getLogger(CountriesCall.class.getName()).log(Level.SEVERE, null, ex);
          }
          return listCountriList;
     }
     
     
}
