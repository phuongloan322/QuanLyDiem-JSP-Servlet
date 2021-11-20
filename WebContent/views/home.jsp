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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
   
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/asset/css/style3.css">
</head>
<body>
	<div id="home">
		<div class="container1">
	        <div class="row title1">
	            <div class="col1a">
	                <h1>TRƯỜNG ĐẠI HỌC KHOA HỌC - ĐẠI HỌC HUẾ</h1>
	            </div>
	            <div class="col2a">
	            <%
	            	Calendar c = Calendar.getInstance();
	            	int thu = c.get(Calendar.DAY_OF_WEEK);
	            	int ngay = c.get(Calendar.DAY_OF_MONTH);
	            	int thang = c.get(Calendar.MONTH) + 1;
	            	int nam = c.get(Calendar.YEAR);
	            %>
	                <p>Thứ <%=thu %>, ngày <%=ngay %> tháng <%=thang %> năm <%=nam %></p>
	            </div>
	        </div>
	        
	        <div class="row">
	            <div id="header">
	                <div class="logo">
	                    <div id="toggle">
	                        <i class="fas fa-bars"></i>
	                    </div>
	                     <img src="https://student.husc.edu.vn/images/logo.png" width="112" height="33">
	                </div>
	                
	                <nav>
	                    <ul id="main-menu">
	                        
	                        <li  class="active">
	                            <a href="">Hỗ trợ hoạt động học tập</a>
	                        </li>
	                        <li>
	                            <a href="">Học tập - Lệ phí</a>
	                        </li>
	                        
	                    </ul>
	                </nav>
	            </div>
	        </div>
	        
	        <div class="row">
	            <div class="col-xs-12 changeTotal">
	                <a href="" class="change">
	                    <b>
	                        <i class="fas fa-graduation-cap"></i>
	                        Khóa 42(2018-2022)
	                    </b>
	                    <b>
	                        <i class="fas fa-book"></i>
	                        Công nghệ phần mềm
	                    </b>
	                    <b>
	                        <i class="fas fa-calendar-alt"></i>
	                        Học kỳ 1, năm học: 2021 - 2022
	                    </b>
	                </a>
	            </div>
	        </div>
    	</div>
    	
	    <div class="content">
	        <div class="left">
	            <div class="information">
	                <h5>${userInfor.name }</h5>
	                <p>
	                    <img src="<%=request.getContextPath()%>/templates/asset/img/people.png" alt="">
	                    <a href="">Lý lịch cá nhân</a>
	                </p>
	                <p>
	                    <img src="<%=request.getContextPath()%>/templates/asset/img/key.png" alt="">
	                    <a href="">Đổi mật khẩu</a>
	                </p>
	                <p>
	                    <img src="<%=request.getContextPath()%>/templates/asset/img/logout.png" alt="">
	                    <a href="<%=request.getContextPath()%>/login">Đăng xuất</a>
	                </p>
	            </div>
	            <div class="ChucNang">
	                <h5>CÁC CHỨC NĂNG CHUNG</h5>
	                <p>
	                    <img src="<%=request.getContextPath()%>/templates/asset/img/book.png" alt="">
	                    <a href="">Tin tức - Thông báo</a>
	                </p>
	                <p>
	                    <img src="<%=request.getContextPath()%>/templates/asset/img/calendar.png" alt="">
	                    <a href="">Thời khóa biểu học tập</a>
	                </p>
	                <p>
	                    <img src="<%=request.getContextPath()%>/templates/asset/img/message.png" alt="">
	                    <a href="">Tin nhắn</a>
	                </p>
	                <p id="btnMail">
	                    <img src="<%=request.getContextPath()%>/templates/asset/img/Mail_Icon.png" alt="">
	                    <a href="#">Thư điện tử</a>
	                </p>
	                <p id="btnDiem">
	                    <i class="fas fa-tasks"></i>
	                    <a href="<%=request.getContextPath()%>/quanlydiem">Quản lý điểm</a>
	                </p>
	            </div>
	            <div class="TinTuc">
	                <h5>TIN TỨC - THÔNG BÁO</h5>
	                <ul>
	                    <li>
	                        <img src="<%=request.getContextPath()%>/templates/asset/img/next.png" alt="">
	                        <a href="">Kế hoạch tổ chức Tuần sinh hoạt công dân - Học sinh, sinh viên đợt 1 năm học 2021 - 2022 dành cho sinh viên năm thứ Nhất (K45) </a>
	                    </li>
	                    <li>
	                        <img src="<%=request.getContextPath()%>/templates/asset/img/next.png" alt="">
	                        <a href="">Kế hoạch tổ chức Tuần sinh hoạt công dân - Học sinh, sinh viên đợt 1 năm học 2021 - 2022 dành cho sinh viên năm thứ Nhất (K45) </a>
	                    </li>
	                    <li>
	                        <img src="<%=request.getContextPath()%>/templates/asset/img/next.png" alt="">
	                        <a href="">Quyết định về việc công nhận tốt nghiệp đại học hệ chính quy đợt 2 (bổ sung) năm 2021  </a>
	                    </li>
	                   <li>
	                        <img src="<%=request.getContextPath()%>/templates/asset/img/next.png" alt="">
	                        <a href="">Kế hoạch tổ chức Tuần sinh hoạt công dân - Học sinh, sinh viên đợt 1 năm học 2021 - 2022 dành cho sinh viên năm thứ Nhất (K45) </a>
	                    </li>
	                    <li>
	                        <img src="<%=request.getContextPath()%>/templates/asset/img/next.png" alt="">
	                        <a href="">Quyết định về việc công nhận tốt nghiệp đại học hệ chính quy đợt 2 (bổ sung) năm 2021  </a>
	                    </li>
	                    <li>
	                        <img src="<%=request.getContextPath()%>/templates/asset/img/next.png" alt="">
	                        <a href="">Kế hoạch tổ chức Tuần sinh hoạt công dân - Học sinh, sinh viên đợt 1 năm học 2021 - 2022 dành cho sinh viên năm thứ Nhất (K45) </a>
	                    </li>
	                    <li>
	                        <img src="<%=request.getContextPath()%>/templates/asset/img/next.png" alt="">
	                        <a href="">Kế hoạch tổ chức Tuần sinh hoạt công dân - Học sinh, sinh viên đợt 1 năm học 2021 - 2022 dành cho sinh viên năm thứ Nhất (K45) </a>
	                    </li>
	                    
	                </ul>
	            </div>
	        </div>
	        <div class="right">
	            <h3>THÔNG BÁO</h3>
	            <div class="list">
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Đăng ký xét hỗ trợ khó khăn do dịch bệnh Covid - 19</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Sinh viên có khó khăn do dịch bệnh Covid - 19 khai báo theo link đính kèm đề Nhà trường gửi Bộ Giáo dục và Đào tạo xem xét hỗ trợ
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Hướng dẫn sinh viên năm thứ Nhất (K45) sử dụng Google Meet tham gia lớp học trực tuyến và sử dụng Trang thông tin đào tạo đại học</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Đăng ký xét hỗ trợ khó khăn do dịch bệnh Covid - 19</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Sinh viên có khó khăn do dịch bệnh Covid - 19 khai báo theo link đính kèm đề Nhà trường gửi Bộ Giáo dục và Đào tạo xem xét hỗ trợ
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Hướng dẫn sinh viên năm thứ Nhất (K45) sử dụng Google Meet tham gia lớp học trực tuyến và sử dụng Trang thông tin đào tạo đại học</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Hướng dẫn sinh viên năm thứ Nhất (K45) sử dụng Google Meet tham gia lớp học trực tuyến và sử dụng Trang thông tin đào tạo đại học</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Sinh viên có khó khăn do dịch bệnh Covid - 19 khai báo theo link đính kèm đề Nhà trường gửi Bộ Giáo dục và Đào tạo xem xét hỗ trợ
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Đăng ký xét hỗ trợ khó khăn do dịch bệnh Covid - 19</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Thông báo số 933/TB-ĐHKH ngày 27/08/2021 của Hiệu trưởng về việc tổ chức đào tạo theo hình thức trực tuyến học kỳ 1, năm học 2021-2022</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Sinh viên có khó khăn do dịch bệnh Covid - 19 khai báo theo link đính kèm đề Nhà trường gửi Bộ Giáo dục và Đào tạo xem xét hỗ trợ
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Hướng dẫn sinh viên năm thứ Nhất (K45) sử dụng Google Meet tham gia lớp học trực tuyến và sử dụng Trang thông tin đào tạo đại học</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Đăng ký xét hỗ trợ khó khăn do dịch bệnh Covid - 19</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Đăng ký xét hỗ trợ khó khăn do dịch bệnh Covid - 19</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Đăng ký xét hỗ trợ khó khăn do dịch bệnh Covid - 19</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	                <div class="newsList">
	                    <p class="contentNews">
	                        <a href="">Đăng ký xét hỗ trợ khó khăn do dịch bệnh Covid - 19</a>
	                        <small>[10/09/2021 15:56]</small>
	                    </p>
	                    <p>
	                        Quỹ học bổng Kết nối là quỹ khuyến học phi lợi nhuận do Công ty CP Đầu tư và Phát triển Dự án AIO thành lập, quản lý đồng thời được CLB XTTM và ĐT DNT Việt Nam bảo trợ và kết nối doanh nhân, doanh nghiệp. Quỹ được thành lập với cam kết giúp đỡ các em sinh viên ưu tú có hoàn cảnh đặc biệt khó khăn theo đuổi được ước mơ trọn vẹn cho con đường học vấn và giúp nâng cao năng lực cạnh tranh của các em, đồng thời đào tạo nhân tài, nhân lực cho cộng đồng.
	                    </p>
	                </div>
	            </div>
	        </div>
	     </div>
	  </div>
	  
	  <!-- mail -->
	  <div class="mail modal" id="myModal">
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
			                                    <div class="close">
			                                        <img src="<%=request.getContextPath()%>/templates/asset/img/icons8-delete-48 (1).png" alt="" >
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
    <!-- Modal -->
    <script type="text/javascript">
    	var modal = document.getElementById("myModal");
    	var btnMail = document.getElementById("btnMail");
    	var span = document.getElementsByClassName("close")[0];
    	var home = document.getElementById("home");
    	btnMail.onclick = function() {
    		  modal.style.display = "block";
    		  home.style.opacity = "0.5";
    	}
    	span.onclick = function() {
    		  modal.style.display = "none";
    		  home.style.opacity = "1";
    	}
    </script>
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