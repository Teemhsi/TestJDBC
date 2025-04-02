package it.polimi.tiw.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class ConnectionTester extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
final String DB_URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
final String USER = "root";
final String PASS = "root";
String result = "Connection worked";
try {
Class.forName("com.mysql.cj.jdbc.Driver");
DriverManager.getConnection(DB_URL, USER, PASS);
System.out.println("connection is working, url is: " + DB_URL);
} catch (Exception e) {
result = "Connection failed";
e.printStackTrace();
}
response.setContentType("text/plain");
PrintWriter out = response.getWriter();
out.println(result);
out.close();
}
}
