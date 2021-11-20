<%@page import="models.Diem"%>
<%@page import="models.TheLoai"%>
<%@page import="models.TinChi"%>
<%@page import="models.MonHoc"%>
<%@page import="models.GiangVien"%>
<%@page import="models.NamHoc"%>
<%@page import="models.hocky"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/templates/inc/header.jsp" %>

  <!-- Main Sidebar Container -->
  <%@include file="/templates/inc/menu.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 nhapdiem"><b>Nhập điểm</b></h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/quanlydiem">Trang chủ</a></li>
              <li class="breadcrumb-item active">Nhập điểm</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
	<hr class="nhap">
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
      <%
		if(!"".equals(request.getParameter("msg"))){
			String msg = request.getParameter("msg");
			if("OK".equals(msg)){
				%>
					<div class="alert alert-success" role="alert">
						 Xử lý thành công..!
					</div>
				<%
			}
		}
	%>
	<%
		if(!"".equals(request.getParameter("msg"))){
			String msg = request.getParameter("msg");
			if("ERROR".equals(msg)){
				%>
					<div class="alert alert-success" role="alert">
						 Xử lý thất bại..!
					</div>
				<%
			}
		}
	%>
      	<form class="form-inline" method="post" action="<%=request.getContextPath()%>/inScore" enctype="multipart/form-data">
      		
      		<div class="container">
      			<div class="row">
		      		<div class="col-sm-6">
			      		<div class="col-mb-12">
			      			<h3>Thông tin chung</h3><br>
			      		</div>
					    <div class="col-sm-12">
					    	<%
		      			if(request.getAttribute("hockyList") != null){
		      				List<hocky> hockyList = (List<hocky>) request.getAttribute("hockyList");
		      				if(hockyList.size() > 0){
		      					%>
		      			<div class="form-group mx-sm-3 mb-4">
		      				<label>Học kỳ:&nbsp;</label>
						    <select class="form-control" id="hocky" name="maHocKy">
						    <%
						    	for(hocky objhk: hockyList){
						    		%>
						    	<option value="<%=objhk.getMaHK()%>"><%=objhk.getTenHK()%></option>
						    		<%
						    	}
						    %>
						    </select>
						  </div>
		      					<%
		      				}
		      			}
		      		%>
		      		<%
		      			if(request.getAttribute("namhocList") != null){
		      				List<NamHoc> namhocList = (List<NamHoc>) request.getAttribute("namhocList");
		      				if(namhocList.size() > 0){
		      					%>
		      			<div class="form-group mx-sm-3 mb-4">
		      				<label>Năm học:&nbsp;</label>
						    <select class="form-control" id="namhoc" name="maNamHoc">
						    <%
						    	for(NamHoc objNH : namhocList){
						    		%>
						    	<option value="<%=objNH.getMaNH()%>"><%=objNH.getTenNH() %></option>
						    		<%
						    	}
						    %>
						    </select>
						  </div>
		      					<%
		      				}
		      			}
		      		%>
		      		<%
		      			if(request.getAttribute("giangvienList") != null){
		      				List<GiangVien> giangvienList = (List<GiangVien>)request.getAttribute("giangvienList");
		      				if(giangvienList.size() > 0){
		      					%>
		      			<div class="form-group mx-sm-3 mb-4">
		      				<label>Giảng viên:&nbsp;</label>
						    <select class="form-control" id="giangvien" name="maGiangVien">
						    <%
						    for(GiangVien objGV : giangvienList){
						    	%>
						    <option value="<%=objGV.getMaGV()%>"><%=objGV.getTenGV()%></option>
						    	<%
						    }
						    %>
						    </select>
						  </div>
		      					<%
		      				}
		      			}
		      		%>
					    </div>
					  </div>
					 <div class="col-sm-6">
					 	<div class="col-mb-12">
					 		<h3>Thông tin môn học</h3><br>
					 	</div>
					 	
					 	<div class="col-sm-12">
					 		 <%
		      			if(request.getAttribute("monhocList") != null){
		      				List<MonHoc> monhocList = (List<MonHoc>)request.getAttribute("monhocList");
		      				if(monhocList.size() > 0){
		      					%>
		      			<div class="form-group mx-sm-3 mb-4">
		      				<label>Môn học:&nbsp;</label>
						    <select class="form-control" id="monhoc" name="maMonHoc">
						    <%
						    	for(MonHoc objMH: monhocList){
						    		%>
						    	<option value="<%=objMH.getMaMH()%>"><%=objMH.getTenMH()%></option>
						    		<%
						    	}
						    %>
						    </select>
						  </div>
		      					<%
		      				}
		      			}
		      		%>
		      		<%
		      			if(request.getAttribute("tinchiList") != null){
		      				List<TinChi> tinchiList = (List<TinChi>) request.getAttribute("tinchiList");
		      				if(tinchiList.size() > 0){
		      					%>
		      			<div class="form-group mx-sm-3 mb-4">
		      			<label>Số tín chỉ:&nbsp;</label>
						    <select class="form-control" id="hocky" name="maTinChi">
						    <%
						    	for(TinChi objTC: tinchiList){
						    		%>
						    	<option value="<%=objTC.getMaTC()%>"><%=objTC.getSoTC()%></option>
						    		<%
						    	}
						    %>
						    </select>
						  </div>
		      					<%
		      				}
		      			}
		      		%>
		      		<%
		      			if(request.getAttribute("theloaiList") != null){
		      				List<TheLoai> theloaiList = (List<TheLoai>) request.getAttribute("theloaiList");
		      				if(theloaiList.size() > 0){
		      					%>
		      			<div class="form-group mx-sm-3 mb-4">
		      				<label>Thể loại:&nbsp;</label>
						    <select class="form-control" id="namhoc" name="maTheLoai">
						    <%
						    	for(TheLoai objTL : theloaiList){
						    		%>
						    	<option value="<%=objTL.getMaTL()%>"><%=objTL.getTenTL() %></option>
						    		<%
						    	}
						    %>
						    </select>
						  </div>
		      					<%
		      				}
		      			}
		      		%>
					 	</div>
					  </div>
			  <div class="form-group mb-12" style="margin-left:17px">
			  	<div class="form-group mx-sm-3 mb-2">
				    <input type="file" name="fileExcel">
				  </div>
				  <div class="form-group mx-sm-3 mb-2">
				    <button type="submit" class="btn btn-primary">Nhập điểm</button>
				  </div>
			  </div>
			  </div>
      		</div>
        
        </form>
			      	
      </div><!-- /.container-fluid -->
    </section>
    <!-- Hiển thị bảng -->
    <section class="content">
    	<br>
      <div class="container-fluid">
		<table class="table table-bordered" id="datatable">
		  <thead class="thead-CCFFFF">
		    <tr class="list-header">
		      <th scope="col">STT</th>
		      <th scope="col">Mã sinh viên</th>
		      <th scope="col">Tên sinh viên</th>
		      <th scope="col">Mã môn học</th>
		      <th scope="col">Số tín chỉ</th>
		      <th scope="col">Điểm CC</th>
		      <th scope="col">Điểm KT</th>
		      <th scope="col">Điểm thi</th>
		      <th scope="col">Tổng điểm</th>
		      <th scope="col">Điểm chữ</th>
		      <th scope="col">Hệ 4</th>
		      <th scope="col">Mã giáo viên</th>
		      <th scope="col">Mã học kỳ</th>
		      <th scope="col">Mã Năm học</th>
		    </tr>
		  </thead>
		  <tbody>
		  <%
		  if(request.getAttribute("diemList") != null){
			  List<Diem> diemList = (List<Diem>) request.getAttribute("diemList");
			  if(diemList.size() > 0){
				  int i = 0;
				  for(Diem diem : diemList){
					  i++;
								  %>
						<tr class="tr-hover">
					      <td><%=i%></td>
					      <td><%=diem.getSinhVien().getMaSV()%></td>
					      <td><%=diem.getSinhVien().getTenSV()%></td>
					      <td><%=diem.getMonHoc().getMaMH()%></td>
					      <td><%=diem.getTinChi().getSoTC()%></td>
					      <td><%=diem.getDiem1()%></td>
					      <td><%=diem.getDiem2()%></td>
					      <td><%=diem.getDiem3()%></td>
					      <td><%=diem.getTongDiem()%></td>
					      
					      <%
					      	float dtb = diem.getTongDiem();
					      	float heso = 0;
					      	String hechu = null;
					      	if(dtb < 4) {
					      		hechu = "F" ;
					      	}
					      	else if(dtb>=4 && dtb<5.5) {
					      		heso = 1;
					      		hechu = "D";
					      	}
					      	else if(dtb>=5.5 && dtb<7) {
					      		heso = 2;
					      		hechu = "C";
					      	}
					      	else if(dtb>=7 && dtb<8.5) {
					      		heso = 3;
					      		hechu = "B";
					      	}
					      	else if(dtb >= 8.5) {
					      		heso = 4;
					      		hechu = "A";
					      	}
					      %>
					      <td><%=hechu %></td>
					      <td><%=heso %></td>
					      <td><%=diem.getGiangVien().getMaGV()%></td>
					      <td><%=diem.getHocky().getMaHK()%></td>
					      <td><%=diem.getNamHoc().getTenNH()%></td>
					    </tr>
					  <%
				  }
			  }
		  }
		  %>
		  </tbody>
		</table>      	
      </div>
    </section>
    
    <!-- /.content -->
  </div>
 <script type="text/javascript">
  $(document).ready(function(){
	  $("form").submit(function(event){
		  event.preventDefault();
		  var formData = new FormData(this);
		  $.ajax({
			  url:"input",
			  type: "post",
			  data: formData,
			  success: function(data){
				  var row = data;
				  for(i = 0;i < row.length;i++){
					  var column = row[i];
					  var eachrow = "<tr>";
					  for(j = 0; j < column.lenght;j++){
						  eachrow = eachrow+"<td>" + column[j]+ "</td>";
					  }
					  eachrow = eachrow + "</td>";
					  $('#tbody').append(eachrow);
				  }
			  },
			  cache:false,
			  contentType: false,
			  processData: false
		  })
	  })
  }
</script>
  <!-- /.content-wrapper -->
  <%@include file="/templates/inc/footer.jsp" %>

    