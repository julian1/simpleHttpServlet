package com.hmkcode;


// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


import javax.servlet.annotation.WebServlet;

// Extend HttpServlet class
@WebServlet(name="myServlet",value = {"/whoot"})
public class MyServlet extends HttpServlet {
 
  private String message;

  @Override
  public void init() throws ServletException
  {
      // Do required initialization
      message = "Hello World";

        System.out.println( " whoot MyServlet init " ); 
  }

  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException {
    try { 
        System.out.println( "get!!");

        // Set response content type
        response.setContentType("text/html");
        OutputStream os = response.getOutputStream();//.flush();
        PrintWriter pw = new PrintWriter( os ); 
        
        System.out.println( "OutputStream is " + os);

        while(true) { 
/*
            // Actual logic goes here.
            PrintWriter out = response.getWriter();
            out.println("<h1>" + message + "</h1>");
            out.flush();
//            Thread.sleep(1000);
*/
            // fucking hell, we don't get an exception... on disconnection

            pw.println("<h1>" + message + "</h1>");
/*
            pw.flush();
            // we have to call flush on both the streams, or we'll never get an exception...
            os.flush();

            or just response.flushBuffer() with something in the buffer...
*/
            response.flushBuffer();         
        }
    } catch( Exception e ) {
        System.out.println( "ooops " + e.getMessage() );
        throw new ServletException( "oops " + e );  
    }
    }
  
  @Override
  public void destroy()
  {
      // do nothing.

        System.out.println( " whoot MyServlet destroy " ); 
  }
}

