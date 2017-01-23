<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" >
    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
</head>
<body>

<spring:url value="/customers" var="urlAllCustomers" />
<spring:url value="/customers/new" var="urlNewCustomer" />

<nav class="navbar navbar-inverse">
    <div class="container">
        <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="glyphicon glyphicon-chevron-down"></span>
        </a>
    </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href=${urlAllCustomers}>All Customers</a></li>
                <li><a href=${urlNewCustomer}>New Customer</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>