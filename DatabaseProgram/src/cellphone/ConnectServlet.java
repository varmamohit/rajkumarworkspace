package cellphone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ConnectServlet  extends HttpServlet
{
   public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
   {
	   
	      try
	      {
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      
	      
	      String username = request.getParameter("username");
	      System.out.println("!!!!!!!!!!!!!!!!!!!!");
	      String branch = request.getParameter("branch");
	      String address = request.getParameter("address");
	      
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	      PreparedStatement pst =  conn.prepareStatement("insert into voot(username,branch,address)values(?,?,?)");
	     pst.setString(1, username);
	     pst.setString(2, branch);
	     pst.setString(3, address);
	     int i = pst.executeUpdate();
	     
	     if(i==1)
	     {
	    	 System.out.println("running");
	     }
	     else
	     {
	    	 System.out.println("not running");
	     }
	      }catch (Exception e) {
			e.printStackTrace();
		}
	      
	      
   }
}
