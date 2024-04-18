<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h1>Enter category details</h1>
    <form:form method="post" modelAttribute="category">
        <fieldset class="mb-3">
            <form:label path="categoryName">Category Name</form:label>
            <form:input type="text" path="categoryName" required="required" class="form-control"/>
            <form:errors path="categoryName" cssClass="text-warning"/>
        </fieldset>
        

        <input type="submit" class="btn btn-success" value="Add category"/>
    </form:form>
</div>
