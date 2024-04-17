<%@ taglib prefix="cd" uri="http://java.sun.com/jstl/core" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">


    <h1>Your reminders are</h1>

    <table class="table">
        <thead>
        <tr>
            <th>Reason</th>
            <th>Target Date</th>
            <!-- <th>Is done?</th> -->
        </tr>

        </thead>
        <tbody>
        <cd:forEach items="${categories}" var="category">
            <tr>
                <td>${category.categoryName}</td>
                <td>${category.categoryId}</td>
<%--                <td><a href="delete-todo?id=${todo.id}" class ="btn btn-warning">Delete</a></td>--%>
<%--                <td><a href="update-todo?id=${todo.id}" class ="btn btn-success">Update</a></td>--%>
            </tr>
        </cd:forEach>
        </tbody>
    </table>
<%--    <a href="add-todo" class="btn btn-success">Add ToDo</a>--%>
<%--    <%@ include file="common/footer.jspf" %>--%>
