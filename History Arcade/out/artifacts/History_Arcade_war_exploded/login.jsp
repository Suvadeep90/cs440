<%--
  Created by IntelliJ IDEA.
  User: Memo
  Date: 2/7/16
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.lang.*"%>
<%@ page import ="Connection.Login"%>

<%
    boolean valid;
    String user = request.getParameter("username");
    String pwd = request.getParameter("password");


    try{
        Login loginDAO = new Login(user, pwd);

        valid = loginDAO.validate();

        if (valid){
            response.sendRedirect("/home.html");
            System.out.println("DEBUG: VALID REGISTRATION");
        }else{
            System.out.println("DEBUG: INVALID REGISTRATION");
        }
        /*
        else
        {
            out.print("<p style=\"color:red\">Sorry username or password error</p>");
            RequestDispatcher rd=request.getRequestDispatcher("/testlogin.html");
            rd.include(request,response);
        }
        */
    }
    catch(Exception ex){
        //System.out.printf(ex);
    }

%>