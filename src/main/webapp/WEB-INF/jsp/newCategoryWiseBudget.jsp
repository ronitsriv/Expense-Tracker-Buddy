<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h1>Enter budget details</h1>
    <form:form method="post" modelAttribute="budget" action="add-categorywiseBudgets">

        <fieldset class="mb-3">
            <form:label path="catWiseid">Category ID</form:label>
            <form:input path="catWiseid" required="required" class="form-control"/>
            <form:errors path="catWiseid" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="budget">Budget</form:label>
            <form:input path="budget" required="required" class="form-control"/>
            <form:errors path="budget" cssClass="text-warning"/>
        </fieldset>

        <input type="submit" class="btn btn-success" value="Add Budget"/>
    </form:form>
</div>
