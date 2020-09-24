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
    <title>Community members</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<header>
    <h1>Community members</h1>
    <p>You are logged in as ${user.firstName} ${user.lastName}</p>
</header>
<main>
    <h1>List of members</h1>
    <form name="AddMembersToCommunityForm" method="POST" action="controller">
        <table>
            <c:forEach items="${allUsers}" var="systemUser">
                <tr>
                    <td>
                        <select name="${systemUser.id}">
                            <c:forEach items="${userGroups}" var="userGroup">
                                <option value="${userGroup.id}">${userGroup.name}</option>
                            </c:forEach>
                        </select>
                        <label for="${systemUser.id}"> ${systemUser.firstName} ${systemUser.lastName}</label><br>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" name="command" value="AddMembersToCommunity">
        <input type="hidden" name="communityId" value="${communityId}">
        <input type="submit" value="Apply the changes">
    </form>
</main>
<nav>
    <a href="controller?command=home">Home</a>
    <a href="controller?command=communities" class="active">Communities</a>
    <a href="controller?command=exit">Exit</a>
</nav>
</body>
</html>