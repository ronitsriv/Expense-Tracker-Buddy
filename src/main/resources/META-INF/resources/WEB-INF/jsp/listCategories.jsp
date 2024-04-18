<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Your categories are</h1>

    <table class="table">
        <thead>
        <tr>
            <th>Reason</th>
            <th>Target Date</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="categ" items="${category}">
            <tr>
                <td>${categ.categoryName}</td>
                <td>${categ.categoryId}</td>
                    <%-- Check if there are reminders or amounts associated with this category --%>
                    <%-- Display a warning message if there are dependencies --%>
                <c:if test="${categ.reminderCount > 0 || categ.amountCount > 0}">
                    <td colspan="2">
                        <span class="text-danger">Warning: Deleting this category will affect existing reminders or amounts!</span>
                    </td>
                </c:if>
                    <%-- If no dependencies, provide delete and update links --%>
                <c:if test="${categ.reminderCount == 0 && categ.amountCount == 0}">
                    <td><a href="delete-category?id=${categ.categoryId}" class="btn btn-warning">Delete</a></td>
                    <td><a href="update-category?id=${categ.categoryId}" class="btn btn-success">Update</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%-- Display a warning message if there are dependencies for any category --%>
    <c:if test="${hasDependencies}">
        <div class="alert alert-warning" role="alert">
            Warning: Some categories have existing dependencies. Deleting them may affect other records.
        </div>
    </c:if>
</div>

<%@ include file="common/footer.jspf" %>
