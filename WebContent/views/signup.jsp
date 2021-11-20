<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/asset/css/signup.css">
    <title>Đăng ký trang tín chỉ</title>
</head>
<body style="background: url(<%=request.getContextPath()%>/templates/asset/img/Login_bg_lg.png)">

<div class="signup">
    <div class="logo_k_nen">
        <img src="<%=request.getContextPath()%>/templates/asset/img/Logo-ko-nen.png" alt="" width="112" height="112">
    </div>
    
    <div class="row">
        <div class="col-xs-6 col-sm-5  well well-sm">
            <legend><a href="http://www.jquery2dotnet.com"><img src="<%=request.getContextPath()%>/templates/asset/img/logo-small.png" width="30px"></a> Đăng ký trang tín chỉ</legend>
            <form action="<%=request.getContextPath()%>/signup" method="post" class="form" role="form ">
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <input class="form-control" name="name" placeholder="Họ" type="text"
                        required autofocus />
                </div>
                <div class="col-xs-6 col-md-6">
                    <input class="form-control" name="lastname" placeholder="Tên" type="text" required />
                </div>
            </div>
            <input class="form-control" name="loginID" placeholder="Mã sinh viên" type="text" />
            <p class="error">${ trungma }</p>
            <input class="form-control" name="password" placeholder="Mật khẩu" type="password" />
            <input class="form-control" name="re-password" placeholder="Nhập lại mật khẩu" type="password" />
            <input class="form-control" name="address" placeholder="Quê quán" type="text" />
            <label for="">
                Ngày sinh</label>
            <div class="row">
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Day">Ngày</option>
                        <option value="Day">1</option>
                        <option value="Day">2</option>
                        <option value="Day">3</option>
                    </select>
                </div>
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Month">Tháng</option>
                        <option value="Month">1</option>
                        <option value="Month">2</option>
                        <option value="Month">3</option>
                    </select>
                </div>
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Year">Năm</option>
                        <option value="Year">1</option>
                        <option value="Year">2</option>
                        <option value="Year">3</option>
                    </select>
                </div>
            </div>
            <div>
            	<label for="">
	                Ngày sinh </label><br>
	            <label class="radio-inline"> 
	                <input type="radio" name="gender" id="inlineCheckbox1" value="male" />
	                Nam
	            </label>
	            <label class="radio-inline">
	                <input type="radio" name="gender" id="inlineCheckbox2" value="female" />
	                Nữ
	            </label>
            </div>
            <br />
            
            <br />
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Đăng ký
            </button>
            </form>
            <a href="<%=request.getContextPath()%>/login"" class="dnhap">Bạn đã có tài khoản?</a>
        </div>
    </div>
</div>
</body>
</html>