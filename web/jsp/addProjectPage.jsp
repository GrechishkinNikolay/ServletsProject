<%--
  Created by IntelliJ IDEA.
  User: kolay
  Date: 15.02.2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Adding project</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<header>
    <h1>Adding project</h1>
    <p>You are logged in as ${user.firstName} ${user.lastName}</p>
</header>
<main>
    <table>
        <tr>
            <td>
                <form name="addProjectForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="AddProject">
                    <input type="hidden" name="communityId" value="${communityId}">
                    Project name:<br/>
                    <input type="text" name="projectName" value=""/><br>
                    Project description:<br/>
                    <textarea name="projectDescription" value=""></textarea><br>
                    <input type="submit" value="Add project">
                </form>
            </td>
        </tr>
    </table>
</main>
<nav>
    <a href="controller?command=home">Home</a>
    <a href="controller?command=communities" class="active">Communities</a>
    <a href="controller?command=exit">Exit</a>
</nav>
</body>
</html>