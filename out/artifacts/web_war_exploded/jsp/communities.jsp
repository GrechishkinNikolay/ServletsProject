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
    <title>Communities</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
    <body>
        <header>
            <h1>Communities</h1>
            <p>You are logged in as ${user.firstName} ${user.lastName}</p>
        </header>
        <main>
            <h1>List of communities</h1>
            <table>
                <tr>
                    <th>Community</th>
                </tr>
                <tr>
                    <td>
                        <a href="controller?command=addCommunityPage">Add community</a>
                    </td>
                </tr>
                <c:forEach items="${communities}" var="community">
                    <tr>
                        <td>
                            <a href='controller?command=community&communityId=${community.id}'><c:out value="${community.name}"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </main>
        <nav>
            <a href="controller?command=home">Home</a>
            <a href="controller?command=communities" class="active">Communities</a>
            <a href="controller?command=exit">Exit</a>
        </nav>
    </body>
</html>