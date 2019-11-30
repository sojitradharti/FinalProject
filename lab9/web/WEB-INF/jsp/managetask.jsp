<%-- 
    Document   : managetask
    Created on : Nov 29, 2019, 11:10:31 AM
    Author     : sojit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Task</title>
         <style>
            .wrapper{
                    margin-left: 45%;
                }
                .middle
                {
                 
                    margin-left:20%;
                    margin-right:20%;
                }
                .myCards{                   
                     
                     margin-left:20%;
                }
                .myCard{
                    width:40%;
                    float: left;
                    margin-top:2%;
                    margin-left:5%;
                }
         </style>
    </head>
    <body>
       <jsp:include page="sidebar.jsp"></jsp:include>
       <c:set var="ContextPath" value="${pageContext.request.contextPath}"></c:set>
        <div class="wrapper">
            <h1>Task Manager</h1>
        </div>
        <div class="myCards">
       <c:forEach items="${requestScope.taskList}" var="task">
           
         <div class="myCard">
       <div class="card text-center">
            <div class="card-header">
              Task ${task.task_id}
            </div>
            <div class="card-body">
              <h5 class="card-title">${task.taskName}</h5>
              <p class="card-text">${task.description}</p>
              <c:if test="${task.status=='COMPLETED'}">
         
              <a href="#" class="btn btn-secondary">Completed</a>
              </c:if>
             <c:if test="${task.status=='ONGOING'}">
              <a href="./fetchTask?paramTask=${task.task_id}" class="btn btn-success">On Going</a>
              </c:if>
                 <c:if test="${task.status=='PENDING'}">
              <a href="./fetchTask?paramTask=${task.task_id}" class="btn btn-info">Pending</a>
              </c:if>
            </div>
            <div class="card-footer text-muted">
              2 days ago
            </div>
      </div>
           </div>
               
      </c:forEach>
        
              </div>
    </body>
</html>
