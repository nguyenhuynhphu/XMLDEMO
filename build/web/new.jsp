<%-- 
    Document   : new
    Created on : Nov 1, 2020, 12:58:32 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert</h1>
        <form action="ManagerServlet" method="POST"> <br>
            ID: <input type="text" name="txtID"/><br>
            Password: <input type="text" name="txtPassword"/><br>
            Name: <input type="text" name="txtName"/><br>
            Gender: <input type="text" name="txtGender"/><br>
            Yob: <input type="text" name="txtYob"/><br>
            Course1: <input type="text" name="course1"/><br>
            Mark1: <input type="text" name="mark1"/>
            Course2: <input type="text" name="course2"/><br>
            Mark2: <input type="text" name="mark2"/>
            Course3: <input type="text" name="course3"/><br>
            Mark3: <input type="text" name="mark3"/>
            <input type="submit" value="insert" name="btAction"/>
        </form>
    </body>
</html>
