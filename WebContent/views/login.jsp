<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/asset/css/style1.css">
    <link rel="stylesheet"  href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <title>Đăng nhập trang tín chỉ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body style="background: url(<%=request.getContextPath()%>/templates/asset/img/Login_bg_lg.png)">		<!-- ok -->
    <div class="signin">
        <div class="col-xs-8 ">
            <div class="row">
                <div class=" col1">
                    <div class="logo">
                        <a href="https://ums.husc.edu.vn/">
                            <img src="<%=request.getContextPath()%>/templates/asset/img/Logo-ko-nen.png" alt="" width="112" height="112">
                        </a>
                    </div>
                    <div class="image">
                        <img src="<%=request.getContextPath()%>/templates/asset/img/login.png" alt=""width="80%" height="80%">
                    </div>
                </div>
                <div class=" col2">
                    <form  class="form-signin" method="post" action="<%=request.getContextPath()%>/login">
                        <img src="<%=request.getContextPath()%>/templates/asset/img/logo-small.png" alt="">
                        <h2 class="form-singin-heading">
                            Sinh viên
                        </h2>
                        <div class="form-group">
                            <label for="loginID">
                                Mã sinh viên:
                            </label>  <br>
                            <input type="text" name="loginID" id="loginID" placeholder="Mã sinh viên"  autofocus value="${ loginID }">
                            <!-- required autofocus value> -->
                        </div>
                        <div class="form-group">
                            <label for="password">
                                Mật khẩu:
                            </label><br>
                            <input type="password" name="password" id="password" placeholder="Mật khẩu" value="${ pass }" >
                        </div>
                        
                        <p class="error">${ error }</p>
                        <%-- <%=request.getAttribute("error")%> --%>
                        
                        <button class="btn-signin" type="submit">
                            Đăng nhập
                        </button>
                       	<div class="dky">
                       		<a href="<%=request.getContextPath()%>/signup" class="dki" align="center">Tạo tài khoản mới</a>
                       	</div>
                     </form>  
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="row">
            <p>
                <i class="far fa-copyright"></i>
                Bản quyền: <a href="https://ums.husc.edu.vn/" class="a">Trường Đại học Khoa học - Đại học Huế</a>
            </p>
            <p>
                <i class="fas fa-home"></i>
                77 Nguyễn Huệ, Thành phố Huế, Tỉnh Thừa Thiên Huế, Việt Nam
            </p>
            <p>
                <i class="fas fa-mobile-alt"></i>
                Điện thoại: (84) 0234.3823290 – Fax: (84) 0234.3824901
            </p>
        </div>
    </footer>
</body>

</html>