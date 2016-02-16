<%--
  Created by IntelliJ IDEA.
  User: Memo
  Date: 2/6/16
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import ="Connection.Register"%>

<%
    String n = request.getParameter("firstname");
    String l = request.getParameter("lastname");
    String e = request.getParameter("email");
    String u = request.getParameter("username");
    String p = request.getParameter("password");
    String s = request.getParameter("sex");

    System.out.println("**DEBUG**");
    System.out.println("First: " + n);
    System.out.println("Last: " + l);
    System.out.println("Email: " + e);
    System.out.println("Username: " + u);
    System.out.println("Password: " + p);
    System.out.println("Sex: " + s);


    try{
        Register user = new Register();
        boolean valid = user.doRegistration(n,l,e,u,p,s);

        if (valid){
            response.sendRedirect("home.html");
            System.out.println("DEBUG: VALID REGISTRATION");
        }else{
            System.out.println("DEBUG: INVALID REGISTRATION");
        }
    }
    catch (Exception ex){
        ex.printStackTrace();
    }


%>