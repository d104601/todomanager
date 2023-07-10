<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <%@ include file="common/head.jspf" %>
    <body>
        <header>
            <%@include file="common/navbar.jspf" %>
        </header>
        <main class="container">
            <h1>Your todos</h1>
            <table class="table">
                <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">UPDATE</a></td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add new</a>
        </main>


        <%@include file="common/scripts.jspf" %>
    </body>
</html>