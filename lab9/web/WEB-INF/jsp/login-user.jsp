
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
    <c:set var="ContextPath" value="${pageContext.request.contextPath}"></c:set>
<jsp:include page="sidebar.jsp"></jsp:include>
	<div class="container">
           
		<hr>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header"> 
					<h4 class="card-title mt-2">Login</h4>
                                        </header>
                                     <form id="login-form" class="form" action="${ContextPath}/dashboard/login" method="post">
							
                                                        <article class="card-body"> 
							<div class="form-group">
								<c:if test="${requestScope.login_error!= null}">
									<div class="alert alert-danger">${requestScope.login_error}</div>
								</c:if>
								<label for="email_id" class="text-info">Email ID:</label><br>
								<input type="name" name="email_id" id="email_id"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" id="password"
									class="form-control" required>
							</div>
							<br />
							<div class="form-group">

								<input type="submit" name="submit"
									class="btn btn-primary btn-block" value="Submit">

							</div>

						
                                
                                </form>
                                                        <div class="border-top card-body text-center">
							Not a User? <a href="./register">Register</a>
						</div>
                                 </div>
						
                                                        
                                </div>
                                 </div>
                         </div>
                   </div>


</body>

</html>
