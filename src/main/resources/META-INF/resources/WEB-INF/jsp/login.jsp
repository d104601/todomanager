<html>
    <%@ include file="common/head.jspf" %>
    <body>
        <%@ include file="common/navbar.jspf" %>
        <main class="container">
            <h1>Login</h1>
            <pre>${errorMessage}</pre>
            <form method="post">
                Username: <input type="text" name="username" />
                Password: <input type="password" name="password" />
                <input type="submit" value="Sign in" />
            </form>
        </main>

        <%@ include file="common/scripts.jspf" %>
    </body>
</html>