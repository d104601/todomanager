<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Todos</title>
</head>
<body>
<main class="container">
    <h1>Update todo</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" name="description" required="required" path="description" value="${todo.description}"/>
            <form:errors class="text-danger" path="description"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="date" name="targetDate" required="required" path="targetDate" value="${todo.targetDate}"/>
            <form:errors class="text-danger" path="targetDate"/>
        </fieldset>
        <form:input type="hidden" name="done" value="false" path="done"/>
        <form:input type="hidden" name="id" path="id" value="${todo.id}"/>
        <input type="submit" class="btn btn-success" value="Update" />
    </form:form>
</main>

<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    $('#datepicker').datepicker({
        format: 'mm/dd/yyyy',
        startDate: '-3d'
    });
</script>
</body>
</html>