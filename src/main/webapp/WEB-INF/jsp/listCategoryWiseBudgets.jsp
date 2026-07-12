<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Budget Details</h1>
    <table class="table">
        <thead>
            <tr>
                <th>Category ID</th>
                <th>Budget</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="budget" items="${budgets}">
                <tr>
                    <td>${budget.catWiseid}</td>
                    <td>${budget.budget}</td>
                    <td><a href="delete-budget?id=${budget.catWiseid}" class="btn btn-warning">Delete</a></td>
                    <td><a href="update-budget?id=${budget.catWiseid}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-categorywiseBudgets" class="btn btn-success">Add Budget</a>
</div>
<%@ include file="common/footer.jspf" %>
