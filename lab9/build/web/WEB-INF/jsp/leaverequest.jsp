<%-- 
    Document   : leaverequest
    Created on : Nov 29, 2019, 1:29:08 PM
    Author     : sojit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Request</title>
        <style>
             .wrapper{
                    margin-left: 45%;
                }
               
        </style>
    </head>
    <body>
        <jsp:include page="sidebar.jsp"></jsp:include>
       <c:set var="ContextPath" value="${pageContext.request.contextPath}"></c:set>
        <div class="wrapper">
            <h1>Leave Request</h1>
        </div>
    </body>
</html>
