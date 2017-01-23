<html>
<head>
    <title>Update Customer</title>
</head>
<body>
<%@ include file="header.jsp" %>

<c:if test="${not empty msg}">
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong>${msg}</strong>
    </div>
</c:if>

<form:form class="form-horizontal" action='${updateUrl}' method="POST" commandName="customer">
    <form:input type="hidden" path="id"/>
    <div class="form-group">
        <label class="control-label col-sm-3"> First Name:</label>
        <div class="col-sm-5">
            <form:input required="required" class="form-control" placeholder="First Name" type="text" path="firstName"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3"> Last Name:</label>
        <div class="col-sm-5">
            <form:input required="required" class="form-control" placeholder="Last Name" type="text" path="lastName"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3">Department:</label>
        <div class="col-sm-5">
            <form:select class="form-control" path="department">
                <form:options items="${departments}" itemValue="id" itemLabel="id"/>
            </form:select>
        </div>
    </div>
    <spring:url value="/customer/${customer.id}" var="updateUrl"/>
    <button class="btn btn-primary center-block" type="submit" value="Save">Update</button>
</form:form>
</body>
</html>
