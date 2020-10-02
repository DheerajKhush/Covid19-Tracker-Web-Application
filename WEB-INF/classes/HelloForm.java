import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class HelloForm extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
		{

	
		 //ApiCall.countriesDataCall();
        // String data= ApiCall.staticsDataCall();
//list of countries
		List<String> countriesList=new ArrayList<>();  
        countriesList= CountriesCall.countriesDataCall();


		  //html Page Generate
		response.setContentType("text/Html");
		PrintWriter out= response.getWriter();
		String title= "Covid Tracker";
		String docType="<!doctype html public \"-//w3c//dtd htlm 4.0"+"transitional//en\">\n";
		out.println(docType+
"<html>\n" +
"  <head>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
"    <meta name=\"author\" content=\"colorlib.com\">\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Poppins\" rel=\"stylesheet\" />\n" +
"    <link href=\"css/main.css\" rel=\"stylesheet\" />\n" +
"  </head>\n" +
"  <body>\n" +


"    <div class=\"s003\">\n" +
"      <form action=\"\\CovidTrackerApp/result\" method=\"POST\">\n" +
"	<h1 class=\"covidH1\">Online\n" +
"		Covid-19 Tracker </h1>"+
"	<h2 class=\"covidH2\">Online\n" +
"		Covid-19 Tracker to keep you \n" +
"		updated with hourly changing data\n" +
"<span style=\"color: #EBAB86\">*corona</span><span style=\"color: #BFB0F4\">virus*</span>\n"+
"		</h2>"+


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

"        <div class=\"inner-form\">\n" +
"          <div class=\"input-field second-wrap\">\n" +
"            <div class=\"input-select\">\n" +
"              <select data-trigger=\"\" name=\"country_name\">\n" +
"                <option placeholder=\"\">Select Country</option>");
		
//	list iterate
 Iterator iterator= countriesList.iterator();
          while (iterator.hasNext()) {

               //System.out.println(iterator.next()); 
			  // out.println("<li><b>Country<b>:"+
				//   iterator.next()+"\n");
				out.println("<option>"+iterator.next() +"</option>");
          }
		  out.println("</select>\n" +
"            </div>\n" +
"          </div>\n" +
"          \n" +
"          <div class=\"input-field third-wrap\">\n" +
"            <button class=\"btn-search\" type=\"submit\" value=\"Submit\">\n" +
"              <svg class=\"svg-inline--fa fa-search fa-w-16\" aria-hidden=\"true\" data-prefix=\"fas\" data-icon=\"search\" role=\"img\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 512 512\">\n" +
"                <path fill=\"currentColor\" d=\"M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z\"></path>\n" +
"              </svg>\n" +
"            </button>\n" +
"          </div>\n" +
"        </div>\n" +
"      </form>\n" +
"    </div>\n" +
"    <script src=\"js/extention/choices.js\"></script>\n" +
"    <script>\n" +
"      const choices = new Choices('[data-trigger]',\n" +
"      {\n" +
"        searchEnabled: false,\n" +
"        itemSelectText: '',\n" +
"      });\n" +
"\n" +
"    </script>\n" +
"  </body><!-- This templates was made by Colorlib (https://colorlib.com) -->\n" +
"</html>");




		}



public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
try{
	doGet(request, response);
}
catch(IndexOutOfBoundsException ex)
{
RequestDispatcher rd= request.getRequestDispatcher("/ErrorPage.html");
rd.forward(request,response);
}
	}
}


