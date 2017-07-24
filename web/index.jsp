<%-- 
    Document   : index
    Created on : Jan 25, 2017, 9:43:16 AM
    Author     : fssco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Servlet" method="get">
            <input type="hidden" name="action" value="start">
            <label>Name:</label><br>
            <input type="text" name="name" value="" /><br>
            <label>Bank Roll:</label><br>
            <input type="text" name="money" value="" /><br>
            <input type="submit" value="go" />
        </form>
    </body>
</html>
