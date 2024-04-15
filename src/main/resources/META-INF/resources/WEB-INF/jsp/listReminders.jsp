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
            <th>Due Date</th>
<%--            <th>Delete</th>--%>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reminder" items="${row}">
            <tr>
                <td>${reminder.reason}</td>
                <td>${reminder.done}</td>
                <td>${reminder.reminderDate}</td>
                <td><a href="/delete-reminder/${reminder.reminderId}" class="btn btn-warning">Delete</a></td>
                <td><a href="update-reminder?id=${reminder.reminderId}" class="btn btn-success">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-reminder" class="btn btn-success">Add Reminder</a>
</div>
<%@ include file="common/footer.jspf" %>
