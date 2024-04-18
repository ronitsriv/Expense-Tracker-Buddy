<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Your reminders are</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Reason</th>
            <th>Is done?</th>
            <th>Amount</th>
            <th>Due Date</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="categoryWise" items="${budgets}">
            <tr>
                <td>${categoryWise.reason}</td>
                <td>${categoryWise.done}</td>
                <td>${categoryWise.amount}</td>
                <td>${categoryWise.categoryDate}</td>
                <td><a href="delete-category?id=${category.categoryId}" class ="btn btn-warning">Delete</a></td>
                <td><a href="update-category?id=${category.categoryId}" class="btn btn-success">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-category" class="btn btn-success">Add Category</a>
</div>
<%@ include file="common/footer.jspf" %>
