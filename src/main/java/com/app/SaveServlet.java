package com.app;   
import java.io.IOException;     
import java.io.PrintWriter;     

import javax.servlet.ServletException;      
import javax.servlet.annotation.WebServlet;     
import javax.servlet.http.HttpServlet;      
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;      
@WebServlet("/SaveServlet")    
public class SaveServlet extends HttpServlet {     
	
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)     
     throws ServletException, IOException {     
    response.setContentType("text/html");   
    PrintWriter out=response.getWriter();   
    String id1=request.getParameter("id1");      
    String name1=request.getParameter("name1");      
    String age1=request.getParameter("age1");    
    String course1=request.getParameter("course1");      
    String city1=request.getParameter("city1");      
        
    stu e1=new stu();   
    e1.setId1(id1); 
    e1.setName1(name1);     
    e1.setAge1(age1);   
    e1.setCourse1(course1);     
    e1.setCity1(city1);     
        
    int status=stuDao.save(e1);     
    if(status>0){   
        out.print("<p>Record saved successfully!</p>");     
        request.getRequestDispatcher("student.html").include(request, response);    
    }else{      
        out.println("Sorry! unable to save record");    
    }   
        
    out.close();    
}   

}  
