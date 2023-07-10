<html>
    <%@include file="common/head.jspf" %>
    <body>
        <%@include file="common/navbar.jspf" %>
        <main class="container">
            <h1>Welcome ${username}</h1>
            <a href="/todo-list">Manage your todos</a>
        </main>

        <%@include file="common/scripts.jspf" %>
    </body>
</html>