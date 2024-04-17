<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h1>Enter category details</h1>
    <form:form method="post" modelAttribute="row">
        <fieldset class="mb-3">
            <form:label path="reason">Reason</form:label>
            <form:input type="text" path="reason" required="required" class="form-control"/>
            <form:errors path="reason" cssClass="text-warning"/>
        </fieldset>


        <fieldset class="mb-3">
            <form:label path="amount">Amount</form:label>
            <form:input type="text" path="amount" required="required" class="form-control"/>
            <form:errors path="amount" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="categoryId">Category ID</form:label>
            <form:input type="text" path="categoryId" required="required" class="form-control"/>
            <form:errors path="categoryId" cssClass="text-warning"/>
        </fieldset>

        <input type="submit" class="btn btn-success" value="Add Category"/>
    </form:form>
</div>
