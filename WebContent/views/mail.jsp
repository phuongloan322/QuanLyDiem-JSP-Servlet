<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/asset/css/style3.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Thư mới</title>
</head>
<body>
    <div class="mail">
        <div class="mailNew">
            <div class="mail-title">
                <table>
                    <tbody>
                        <tr>
                            <td class="td1">
                                <p>Thư mới</p>
                            </td>
                            <td class="td2">
                                <div class="td2-right">
                                    <div>
                                        <img src="<%=request.getContextPath()%>/templates/asset/img/icons8-horizontal-line-24 (1).png" alt="">
                                    </div>
                                    <div>
                                        <img src="<%=request.getContextPath()%>/templates/asset/img/icons8-enlarge-24.png" alt="">
                                    </div>
                                    <div>
                                        <img src="<%=request.getContextPath()%>/templates/asset/img/icons8-delete-48 (1).png" alt="">
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="mail-content">
                        <div class="to-mail">
                            <div>
                                <div class="nguoinhan">
                                    Người nhận
                                </div>
                                 <div class="den">
                                         <div class="d1">Đến</div>
                                         <div>
                                             <!-- <textarea name="text" id="tomail" cols="41" rows="20"></textarea> -->
                                             <input type="email" required autofocus value>
                                         </div>
                                         <div class="d1">
                                            <a href="">Cc</a>
                                            <a href="">Bcc</a>
                                         </div>
                                 </div>
                            </div>
                        </div>
                        <div class="from-mail">
                            <div>
                                <input type="text" class="chude" placeholder="Chủ đề">
                            </div>
                        </div>
                        <div class="noidung">
                            <div>
                                <textarea name="text" id="noidung" cols="30" rows="17"></textarea>
                            </div>
                        </div>
                </table>
                <div class="send-mail">
                    <div class="vien">
                        <div class="btn">
                            <button type="submit">Gửi</button>
                        </div>
                        <div class="icon">
                            <i class="fas fa-caret-down"></i>
                        </div>
                    </div>           
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $(".nguoinhan").click(function(){
                $(this).css({'visibility':'hidden'});
                $(".den").css({'visibility':'visible'});
                $(".den input").focus();
            });
           $(".mail-title").click(function(){
                $(".nguoinhan").css({'visibility':'visible'});
                $(".den").css({'visibility':'hidden'});
            });
        });
       
    </script>
</body>
</html>