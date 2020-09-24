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
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
    <body>
    <header>
        <h1>Home</h1>
        <p>You are logged in as ${user.firstName} ${user.lastName}</p>
    </header>
        <main>
            <h1>List of tasks</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Task</th>
                    <th>Performers number</th>
                    <th></th>
                </tr>
                <c:forEach items="${user.tasks}" var="task">
                    <tr>
                        <td>
                            <c:out value="${task.id}" />
                        </td>
                        <td>
                            <c:out value="${task.text}" />
                        </td>
                        <td>
                            <c:out value="${task.performersNumber}" />
                        </td>
                        <td>
                            <form method="POST" action="controller">
                                <input type="hidden" name="taskId" value="${task.id}"/>
                                <button name="command" value="deleteTask">Delete task</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </main>
        <nav>
            <a href="controller?command=home" class="active">Home</a>
            <a href="controller?command=communities">Communities</a>
            <a href="controller?command=exit">Exit</a>
        </nav>
    </body>
</html>