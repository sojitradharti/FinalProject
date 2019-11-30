<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
<style>
    body { background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAaCAYAAACpSkzOAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAALEgAACxIB0t1+/AAAABZ0RVh0Q3JlYXRpb24gVGltZQAxMC8yOS8xMiKqq3kAAAAcdEVYdFNvZnR3YXJlAEFkb2JlIEZpcmV3b3JrcyBDUzVxteM2AAABHklEQVRIib2Vyw6EIAxFW5idr///Qx9sfG3pLEyJ3tAwi5EmBqRo7vHawiEEERHS6x7MTMxMVv6+z3tPMUYSkfTM/R0fEaG2bbMv+Gc4nZzn+dN4HAcREa3r+hi3bcuu68jLskhVIlW073tWaYlQ9+F9IpqmSfq+fwskhdO/AwmUTJXrOuaRQNeRkOd5lq7rXmS5InmERKoER/QMvUAPlZDHcZRhGN4CSeGY+aHMqgcks5RrHv/eeh455x5KrMq2yHQdibDO6ncG/KZWL7M8xDyS1/MIO0NJqdULLS81X6/X6aR0nqBSJcPeZnlZrzN477NKURn2Nus8sjzmEII0TfMiyxUuxphVWjpJkbx0btUnshRihVv70Bv8ItXq6Asoi/ZiCbU6YgAAAABJRU5ErkJggg==);}
     
     
#sidebar {
        margin-right: 10%;
	width: 220px;
	position: fixed;
	top: 0;
	left: 0;
	height: 100vh;
	z-index: 999;
	background: #007BBD;
	color: #fff;
}

h1{
	margin: 5%;
        margin-left:5%;
	font-family: 'Brush Script MT',cursive;
}

.active{
	height: 60px;
	background-color: #007BBB !important;
	border: none;
}
</style>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<nav id="sidebar">
	<div class="sidebar-header">
		<h1 class="text-center">Connecteam</h1>
	</div>
	<br/><br/>
	<div class="list-group text-center">
		<b>
			<c:if test="${sessionScope.user == null}">
                            <a href="${contextPath}/dashboard/login" class="list-group-item list-group-item-action active">Login &#10148;</a> <br>
				<a href="${contextPath}/dashboard/register" class="list-group-item list-group-item-action active">Register &#10148;</a>
			</c:if>
			<c:if test="${sessionScope.user.roleName == 'ADMIN'}">
				<a href="./graph" class="list-group-item list-group-item-action active">Task Graph &#10148;</a> <br>
                                <a href="./graph" class="list-group-item list-group-item-action active">Leave Graph &#10148;</a> <br>
				<a href="${contextPath}/dashboard/logout" class="list-group-item list-group-item-action active">Logout</a>
			</c:if>
			<c:if test="${sessionScope.user.roleName == 'EMPLOYEE'}">
                                <a href="./profile" class="list-group-item list-group-item-action active">Profile &#10148;</a> <br>
				<a href="${contextPath}/employee/leaverequest" class="list-group-item list-group-item-action active">Leave Request&#10148;</a> <br>
				<a href="${contextPath}/employee/managetask" class="list-group-item list-group-item-action active">Task Manager &#10148;</a> <br>
                                <a href="./connect" class="list-group-item list-group-item-action active">connect &#10148;</a> <br>
                                <a href="${contextPath}/dashboard/logout" class="list-group-item list-group-item-action active">Logout &#10148;</a> <br>
			</c:if>
			<c:if test="${sessionScope.user.roleName == 'TEAMLEADER'}">
				 <a href="./profile" class="list-group-item list-group-item-action active">Manage Leave &#10148;</a> <br>
				<a href="${contextPath}/teamleader/assigntask" class="list-group-item list-group-item-action active">Assign Task &#10148;</a> <br>
				<a href="./task" class="list-group-item list-group-item-action active">Task Graph &#10148;</a> <br>
                                <a href="./connect" class="list-group-item list-group-item-action active">Leave Graph &#10148;</a> <br>
				<a href="${contextPath}/dashboard/logout" class="list-group-item list-group-item-action active">Logout &#10148;</a> <br>
			</c:if>
		</b>
	</div>
	</nav>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

</body>
</html>