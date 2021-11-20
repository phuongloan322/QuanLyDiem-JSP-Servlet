<%@page import="models.SinhVien"%>
<%@page import="models.Lop"%>
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
            <h1 class="m-0">Sinh viên</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/quanlydiem">Trang chủ</a></li>
              <li class="breadcrumb-item active">Sinh viên</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

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
	<%-- <%
		if(request.getSession().getAttribute("lopList") != null){
			List<Lop> lopList = (List<Lop>) request.getSession().getAttribute("lopList"); 
	%> --%>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalThem">Thêm</button>
	
	
	<table class="table table-bordered" id="datatable">
	  <thead class="thead-CCFFFF">
	    <tr class="list-header">
	      <th scope="col">#</th>
	      <th scope="col">Mã Sinh viên</th>
	      <th scope="col">Tên Sinh viên</th>
	      <th scope="col">Địa chỉ</th>
	      <th scope="col">Số điện thoại</th>
	      <th scope="col">Email</th>
	      <th scope="col">Lớp</th>
	      <th scope="col">Chức năng</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  if(request.getSession().getAttribute("sinhvienList") != null){
		  List<SinhVien> sinhvienList = (List<SinhVien>) request.getSession().getAttribute("sinhvienList");
		  if(sinhvienList.size() > 0){
			  int i = 0;
			  for(SinhVien sv : sinhvienList){
				  i++;
				  %>
				  <form action="" method="POST" >
					<tr class="tr-hover edit">
				      <th scope="row"><input style="width: 10px" type="checkbox" name="vehicle1" value="Bike"></th>
				      <td ><input value="<%=sv.getMaSV() %>" name="<%=i%>ma" disabled="false"></td> 
				      <td ><input style="width: 100%" value="<%=sv.getTenSV() %>" name="<%=i%>a"></td>
				      <td ><input style="width: 80px" value="<%=sv.getDiachi() %>"  name="<%=i%>b"></td>
				      <td ><input style="width: 80px"value="<%=sv.getSdt() %>"  name="<%=i%>c"></td>
				      <td ><input style="width: 105%" value="<%=sv.getEmail() %>"  name="<%=i%>d"></td>
				      <td ><input value="<%=sv.getLop().getTenLop() %>" name="<%=i%>e" disabled="false">
				      </td>
				     <td>
						 <button formaction="<%=request.getContextPath()+"/sinhvien?kt=edit&id="+i+"&msv="+sv.getMaSV()+"&mLop="+sv.getLop().getMaLop()%>" class="btn-edit"><i class="fas fa-edit"></i></button>
						 <button formaction="<%=request.getContextPath()+"/sinhvien?kt=delete&id="+i+"&msv="+sv.getMaSV()+"&mLop="+sv.getLop().getMaLop()%>" class="btn-delete"><i class="fas fa-trash"></i></button> 
						<%
						
						%>
				     </td>
				    </tr>
				    </form>
				  <%
			  }
		  }
	  }
	  %>
	  </tbody>
	</table>
	
			      	
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    <!-- Modal -->
<div class="modal fade" id="modalThem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thêm sinh viên</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action ="<%=request.getContextPath()%>/sinhvien?kt=add" method="post">
        
        	<div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Mã sinh viên</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="maSV">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Tên sinh viên</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="tenSV">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Địa chỉ</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="diachi">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Số điện thoại</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="sdt">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Email</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="email">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Lớp</label>
			    
			    <%
			    	if(request.getSession().getAttribute("lopList") != null){
			    		List<Lop> lopList = (List<Lop>) request.getSession().getAttribute("lopList");
			    		if(lopList.size() > 0){
			    			%>
			    <select class="form-control" id="exampleFormControlSelect1" name="malop">
			    <%
			    	for(Lop objLop : lopList){
			    		%>
			    	<option value="<%=objLop.getMaLop()%>"><%=objLop.getTenLop()%></option>
			    		<%
			    	}
			    %>
			    </select>
			    			<%
			    		}
			    	}
			    %>
			  </div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Thoát</button>
		        <button type="submit" class="btn btn-primary">Thêm</button>
		      </div>        
        </form>
      </div>
    </div>
  </div>
</div>
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

    