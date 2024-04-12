<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insights</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-5">My Insights Page(from h2 console)</h1>
    <div class="mt-3">
        <p class="lead">Minimum Expense: ${minExpense}</p>
        <p class="lead">Maximum Expense: ${maxExpense}</p>
    </div>
</div>

<!-- Bootstrap JavaScript (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
