<%-- 
    Document   : game
    Created on : Jan 25, 2017, 9:40:06 AM
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
        <h1>High or Low?</h1>
        <h2>${player.name} : $${player.roll}</h2>
        <br>
        <h2>${numToShow}</h2>
        <h2>${message}</h2>
        
            <form action="Servlet" method="get">
                <input type="hidden" name="action" value="gamble">
<!--                <input type="hidden" name="money" value="${player.roll}">
                <input type="hidden" name="name" value="${player.name}">
                <input type="hidden" name="prevNumber" value="${numToShow}">-->
                
                <label>high: </label>
                <input type="radio" name="choice" value="high" checked="checked" /> <br>
                <label>low: </label>
                <input type="radio" name="choice" value="low" checked="checked" /> <br>
            <input type="submit" value="go" />
        </form>
    </body>
</html>
