<%-- 
    Document   : assigntask
    Created on : Nov 27, 2019, 3:45:22 PM
    Author     : sojit
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<link rel="stylesheet" href="/resources/css/register.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css"/>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <style>
            .wrapper{
                    margin-left: 45%;
                }
                .middle
                {
                 
                    margin-left:20%;
                    margin-right:20%;
                }
         </style>
    </head>
    <body>
        <jsp:include page="sidebar.jsp"></jsp:include>
       <c:set var="ContextPath" value="${pageContext.request.contextPath}"></c:set>
        <div class="wrapper">
            <h1>Assign Tasks</h1>
        </div>
        <div class="middle">
            <div class="container">
                
        <form:form action="${ContextPath}/teamleader/assigntask" method="Post" commandName="task">
            <div class="form-group">
                <label>Select Employee</label>
                <select name="empId" class="form-control">
                    <c:forEach items="${requestScope.empList}" var="emp">
                        <option value="${emp.id}">${emp.fname}</option>
                        
                    </c:forEach>
                <select>
                
            </div>
            <div class="form-group">
                    <label>Task name</label>
                    <form:input required="" type="text" height="4" class="form-control" path="taskName"
                                placeholder=""></form:input>
                <form:errors path="taskName" />
              </div>
             <div class="form-group">
                 <label>Description</label</br>
                 
                   <form:textarea  rows="3" cols="20" path="description" />
                    <form:errors path="description" />
                 
            </div>
            <div class="form-group">
                    <label>Start Date</label>
                   <form:input path="startdate" type="date" class="form-control"
							/>
                  
                   
                    
            </div>
              <div class="form-group">
                    <label>End Date</label>
                   <form:input path="enddate" type="date" class="form-control"/>
                   
                   
            
            </div>
            <div class="form-group">
                <input type="submit" value="Save"  class="btn btn-primary"></input>
            </div>
            
      </form:form>
        </div>
        </div>
        
        </body>
</html>
