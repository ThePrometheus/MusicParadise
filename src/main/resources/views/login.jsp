<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login With Database Application</h2>
<form:form method="post" action="login" >
    <table>
        <tr>
            <td>Login ID</td>
            <td><input type="text" name="login" id="log_id" path="log_id" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" id="password" path="password" /></td>
        </tr>
    </table>

    <button class="btn btn-primary"type="submit">Login</button>
    <a href="newuser">New User</a>
</form:form>
</body>