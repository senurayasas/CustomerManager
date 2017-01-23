<html>

<body>
<%@ include file="header.jsp" %>

<c:set var="deleteUrl" value="customers/delete"/>

<c:if test="${not empty msg}">
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong>${msg}</strong>
    </div>
    <c:set var="deleteUrl" value="delete"/>
</c:if>

<div class="row">
    <div class="col-sm-6">
        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Department</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.department.id}</td>
                    <td>
                        <spring:url value="/customers/${customer.id}" var="updateUrl"/>
                        <button id="invokesToastMessage" class="btn btn-primary" onclick="location.href='${updateUrl}'">
                            Update
                        </button>
                    </td>
                    <form:form action='${deleteUrl}' method="POST" commandName="customer">
                        <input type="hidden" name="id" value="${customer.id}"/>
                        <input type="hidden" name="firstName" value="${customer.firstName}"/>
                        <input type="hidden" name="lastName" value="${customer.lastName}"/>
                        <td>
                            <button class="btn btn-danger" type="submit" value="Delete">Delete</button>
                        </td>
                    </form:form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>