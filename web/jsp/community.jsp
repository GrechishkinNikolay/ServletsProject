<%--
  Created by IntelliJ IDEA.
  User: kolay
  Date: 15.02.2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>${community.name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<header>
    <h1>${community.name}</h1>
    <c:if test="${userGroupName == 'admin' || userGroupName == 'moderator'}">
        <form name="CommunityMembersPageForm" method="POST" action="controller">
            <input type="hidden" name="command" value="CommunityMembersPage">
            <input type="hidden" name="communityId" value="${community.id}">
            <input type="submit" value="Members">
        </form>
    </c:if>
    <p>You are logged in as ${user.firstName} ${user.lastName}</p>
</header>
<main>
    <h1>List of projects</h1>
    <table>
        <tr>
            <th><h2>Project</h2></th>
        </tr>
        <c:if test="${userGroupName == 'admin'}">
            <tr>
                <td>
                    <a href='controller?command=addProjectPage&communityId=${community.id}'><c:out
                            value="Add project"/></a>
                </td>
            </tr>
        </c:if>
        <c:forEach items="${community.projects}" var="project">
            <tr>
                <td>
                    <h3><c:out value="${project.name}"/></h3>
                    <c:out value="Description: ${project.description}"/>
                    <h3>Tasks:</h3>
                    <ul>
                        <c:if test="${userGroupName == 'admin'}">
                            <a href='controller?command=addTaskPage&projectId=${project.id}&communityId=${community.id}'><c:out value="Add task"/></a>
                        </c:if>
                        <c:forEach items="${project.tasks}" var="task">
                            <li>
                                <c:out value="${task.text}  (Performers number - ${task.performersNumber}):"/>
                            </li>
                            <c:forEach items="${performersByTasksId[task.id]}" var="performer">
                                <p>${performer.firstName} ${performer.lastName}</p>
                            </c:forEach>
                            <c:if test="${task.performersNumber > fn:length(performersByTasksId[task.id])}">
                                <form method="POST" action="controller">
                                    <input type="hidden" name="taskId" value="${task.id}"/>
                                    <button name="command" value="getToWork">Get to work</button>
                                </form>
                            </c:if>
                        </c:forEach>
                    </ul>
                    <c:forEach items="${project.comments}" var="comment">
                        <c:if test="${userGroupName == 'moderator'}">
                            <form method="POST" action="controller">
                                <input type="hidden" name="commentId" value="${comment.id}"/>
                                <button name="command" value="DeleteComment">Delete comment</button>
                                <span>${comment.dateTime} ${comment.text}</span>
                            </form>
                        </c:if>
                    </c:forEach>
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