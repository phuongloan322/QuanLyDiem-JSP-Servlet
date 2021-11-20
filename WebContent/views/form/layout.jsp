<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/asset/css/style2.css">
    <title>Sinh viên -Trường Đại học Khoa học Huế - Tin tức - Thông báo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
</head>
<body>
    <!-- header -->
    <%@include file="/views/form/header.jsp" %>
    
    <div class="content">
        <div class="left">
            <%@include file="/views/form/left.jsp" %>
        </div>
        <div class="right">
            <!-- body -->            
        </div>
    </div>
    
    <footer>

    </footer>

    <script>
        $(document).ready(function() {
            $('#toggle').click(function() {
                $('nav').slideToggle();
            });
        })
    </script>
</body>
</html>