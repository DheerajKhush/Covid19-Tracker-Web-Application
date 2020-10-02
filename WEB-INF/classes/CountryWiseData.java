import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.HashMap;
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
public class CountryWiseData {
     
     
     // specific countries statics
     public static HashMap staticsDataCall(String country_name){
          
          //variables
          HashMap<String, String> dataMap= new HashMap<>();
          
          // api call for countries available
         OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
	.url("https://covid-193.p.rapidapi.com/statistics?country="+country_name)
	.get()
	.addHeader("x-rapidapi-host", "covid-193.p.rapidapi.com")
	.addHeader("x-rapidapi-key", "af4a92b72bmshece02652aae480fp14a3c4jsnea3fa79a71f5")
	.build();



          try {
               Response response = client.newCall(request).execute();
               System.out.println("Result"+ response.body());
               String resStr = response.body().string();    
               System.out.println(resStr);
               // json data for statics
               JSONParser jsonParser = new JSONParser();
               
               Object obj=null;
               try {
                    obj = jsonParser.parse(resStr);
               } catch (ParseException ex) {
                    Logger.getLogger(CountryWiseData.class.getName()).log(Level.SEVERE, null, ex);
               }
                JSONObject jsonObject = (JSONObject)obj;
               JSONArray array=(JSONArray)jsonObject.get("response");

                       JSONObject jSONObject=(JSONObject)array.get(0);
                       System.out.println(jSONObject);
                       {// cases data
                        JSONObject casesJSONObject =(JSONObject)jSONObject.get("cases");
                       // new cases
                        String newCases="No Records Found";
                        if(casesJSONObject.get("new")!=null)
                         newCases=casesJSONObject.get("new").toString();
                         dataMap.put("new", newCases);
                         System.out.println("new Cases in India :"+ newCases);
                          //active cases
                         String activeCases="No Records Found";
                         if(casesJSONObject.get("active")!=null)
                         activeCases=casesJSONObject.get("active").toString();
                         System.out.println("Active Cases in India :"+ activeCases);
                          dataMap.put("active", activeCases);
                         //recovered cases
                          String recoveredCases="No Records Found";
                          if(casesJSONObject.get("recovered")!=null);
                          recoveredCases=casesJSONObject.get("recovered").toString();

                         System.out.println("recovered Cases in India :"+ recoveredCases);
                          dataMap.put("recovered", recoveredCases);
                        //Total cases
                           String totalCases="No Records Found";

                           if(casesJSONObject.get("total")!=null)
                          totalCases=casesJSONObject.get("total").toString();

                         System.out.println("Total Cases in India :"+ totalCases);
                          dataMap.put("total", totalCases);
                       }
                       {
                            //death data
                            JSONObject deathJSONObject =(JSONObject)jSONObject.get("deaths");
                        // total death
							// total death
                        String totalDeaths="No Records Found";
                        if(deathJSONObject.get("total")!=null)
                          totalDeaths=deathJSONObject.get("total").toString();
                         System.out.println("Total Deaths in India :"+ totalDeaths);
                          dataMap.put("deathstotal", totalDeaths);
                       }
                       {
                            //tests data
                            JSONObject deathJSONObject =(JSONObject)jSONObject.get("tests");
                        // total tests
						 // total tests
                         String totaltests="No Records Found";
                         if(deathJSONObject.get("total")!=null)
                         totaltests=deathJSONObject.get("total").toString();
                         System.out.println("Total tests :"+ totaltests);
                          dataMap.put("teststotal", totaltests);
                       
                       }

               
          } catch (IOException ex) {
               Logger.getLogger(CountryWiseData.class.getName()).log(Level.SEVERE, null, ex);
          }
          return dataMap;
     }

}
