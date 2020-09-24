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
    <title>Adding task</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<header>
    <h1>Adding task</h1>
    <p>You are logged in as ${user.firstName} ${user.lastName}</p>
</header>
<main>
    <table>
        <tr>
            <td>
                <form name="addTaskForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="AddTask">
                    <input type="hidden" name="communityId" value="${communityId}">
                    <input type="hidden" name="projectId" value="${projectId}">
                    Performers number:<br/>
                    <input type="text" name="performersNumber" value=""/><br>
                    Enter the text of the task:<br/>
                    <textarea name="taskText" value=""></textarea><br>
                    <input type="submit" value="Add task">
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