

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String emailid=request.getParameter("emailid");
		String country=request.getParameter("country");
		String gender=request.getParameter("gender");
		//jdbc code to connect with database
		try {
			class.forName("com.mysqljdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testDemo,");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into t values("+id+",'"+name+"'"+emailid+"'"+country+"'"+gender+")");
			out.print("your record has been successfully inserted");
		
			
			/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
