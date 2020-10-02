import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
public class DataForm extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{


		 //variables
          HashMap<String, String> dataMap= new HashMap<>();
         
		response.setContentType("text/Html");
		PrintWriter out= response.getWriter();

		String country= request.getParameter("country_name");

		//Api Call
		dataMap=CountryWiseData.staticsDataCall(country);

		String title= "Country-Wise Data";
		String docType="<!doctype html public \"-//w3c//dtd htlm 4.0"+"transitional//en\">\n";
		out.println(docType+
			"<htlm>\n" +
			"<head>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
"    <meta name=\"author\" content=\"colorlib.com\">\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Poppins\" rel=\"stylesheet\" />\n" +
"    <link href=\"css/main.css\" rel=\"stylesheet\" />\n" +
"	  <title>"+ title +"</title></head>\n"+
			"<body>\n"+
			"<div class=\"s003\">"+
			"<h1 align= \"center\">"+ title +"</h1>\n" +
			"<ul>\n"+
			"<li><b>Country </b>:"
		+ request.getParameter("country_name") +"\n"+
			"<li><b>New Cases</b>:"
		+ dataMap.get("new") +"\n"+
			"<li><b>Active Cases</b>:"
		+ dataMap.get("active") +"\n"+
			"<li><b>Recovered Cases</b>:"
		+ dataMap.get("recovered") +"\n"+
			"<li><b>Total Cases</b>:"
		+ dataMap.get("total") +"\n"+
			"<li><b>Total Deaths</b>:"
		+ dataMap.get("deathstotal") +"\n"+
			"<li><b>Total Tests</b>:"
		+ dataMap.get("teststotal") +"\n"+
			"</ul>\n"+

"<div class=\"arrow arrow--top\">\n" +
"    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"270.11\" height=\"649.9\" overflow=\"visible\">\n" +
"      <style>\n" +
"        .geo-arrow {\n" +
"          fill: none;\n" +
"          stroke: #fff;\n" +
"          stroke-width: 2;\n" +
"          stroke-miterlimit: 10\n" +
"        }\n" +
"      </style>\n" +
"      <g class=\"item-to bounce-1\">\n" +
"        <path class=\"geo-arrow draw-in\" d=\"M135.06 142.564L267.995 275.5 135.06 408.434 2.125 275.499z\" />\n" +
"      </g>\n" +
"      <circle class=\"geo-arrow item-to bounce-2\" cx=\"194.65\" cy=\"69.54\" r=\"7.96\" />\n" +
"      <circle class=\"geo-arrow draw-in\" cx=\"194.65\" cy=\"39.5\" r=\"7.96\" />\n" +
"      <circle class=\"geo-arrow item-to bounce-3\" cx=\"194.65\" cy=\"9.46\" r=\"7.96\" />\n" +
"      <g class=\"geo-arrow item-to bounce-2\">\n" +
"        <path class=\"st0 draw-in\" d=\"M181.21 619.5l13.27 27 13.27-27zM194.48 644.5v-552\" />\n" +
"      </g>\n" +
"    </svg>\n" +
"  </div>\n" +
"  <div class=\"arrow arrow--bottom\">\n" +
"    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"31.35\" height=\"649.9\" overflow=\"visible\">\n" +
"      <style>\n" +
"        .geo-arrow {\n" +
"          fill: none;\n" +
"          stroke: #fff;\n" +
"          stroke-width: 2;\n" +
"          stroke-miterlimit: 10\n" +
"        }\n" +
"      </style>\n" +
"      <g class=\"item-to bounce-1\">\n" +
"        <circle class=\"geo-arrow item-to bounce-3\" cx=\"15.5\" cy=\"580.36\" r=\"7.96\" />\n" +
"        <circle class=\"geo-arrow draw-in\" cx=\"15.5\" cy=\"610.4\" r=\"7.96\" />\n" +
"        <circle class=\"geo-arrow item-to bounce-2\" cx=\"15.5\" cy=\"640.44\" r=\"7.96\" />\n" +
"        <g class=\"item-to bounce-2\">\n" +
"          <path class=\"geo-arrow draw-in\" d=\"M28.94 30.4l-13.26-27-13.27 27zM15.68 5.4v552\" />\n" +
"        </g>\n" +
"      </g>\n" +
"    </svg>\n" +
"  </div>\n" +
			"</div>\n"+
			"</body>"+
			"</html>");
		}
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	doGet(request, response);
	}
}


