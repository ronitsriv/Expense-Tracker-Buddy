<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Your categories are</h1>

    <table class="table">
        <!-- Table header -->
        <thead>
            <tr>
                <th>Category Name</th>
                <th>Category ID</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over categories -->
            <c:forEach var="categ" items="${category}">
                <tr>
                    <td>${categ.categoryName}</td>
                    <td>${categ.categoryId}</td>
                    <!-- Delete button -->
                    <td><a href="delete-category?id=${categ.categoryId}" class="btn btn-warning">Delete</a></td>
                    <!-- Update button -->
                    <td><a href="update-category?id=${categ.categoryId}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- Add Category button -->
    <a href="add-category" class="btn btn-success">Add Category</a>
</div>
