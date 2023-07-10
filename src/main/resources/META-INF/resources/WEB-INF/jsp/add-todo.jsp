<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <%@ include file="common/head.jspf" %>
    <body>
        <%@include file="common/navbar.jspf" %>
        <main class="container">
            <h1>Add new todo</h1>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" name="description" required="required" path="description"/>
                    <form:errors class="text-danger" path="description"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="date" name="targetDate" required="required" path="targetDate"/>
                    <form:errors class="text-danger" path="targetDate"/>
                </fieldset>

                <form:input type="hidden" name="done" value="false" path="done"/>
                <form:input type="hidden" name="id" path="id"/>
                <input type="submit" class="btn btn-success" value="Add" />
            </form:form>
        </main>
        <%@include file="common/scripts.jspf" %>
    </body>
</html>