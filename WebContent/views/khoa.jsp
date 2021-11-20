<%@page import="models.Khoa"%>
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
            <h1 class="m-0">Khoa</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/quanlydiem">Trang chủ</a></li>
              <li class="breadcrumb-item active">Khoa</li>
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
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalThem">Thêm</button>
	<table class="table table-bordered" id="datatable">
	  <thead class="thead-CCFFFF">
	    <tr class="list-header">
	      <th scope="col">#</th>
	      <th scope="col">Mã Khoa</th>
	      <th scope="col">Khoa</th>
	      <th scope="col">Liên Hệ</th>
	      <th scope="col">Chức năng</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  if(request.getSession().getAttribute("khoaList") != null){
		  List<Khoa> khoaList = (List<Khoa>) request.getSession().getAttribute("khoaList");
		  if(khoaList.size() > 0){
			  for(Khoa k : khoaList){
				  %>
		<tr class="tr-hover">
	      <th scope="row"><input type="checkbox" name="vehicle1" value="Bike"></th>
	      <td><%=k.getMaKhoa()%></td>
	      <td><%=k.getTenKhoa()%></td>
	      <td><%=k.getLienheKhoa()%></td>
	     <td>
	    	<%-- <button type="button" class="btn btn-warning suaMenu" data-toggle="modal" data-target="#exampleModalSua">
				<a href="<%=request.getContextPath()%>/menu/edit?id=">Cập nhật</a>
			</button>
	     	<button xoaMenu="" type="button" class="btn btn-danger">Xóa</button> --%>
	     </td>
	    </tr>
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
        <h5 class="modal-title" id="exampleModalLabel">Thêm Khoa</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action ="<%=request.getContextPath()%>/khoa" method="post">
        	<div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Mã Khoa</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="maKhoa">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">khoa</label>
			    <input type="text" class="form-contro4l-file col-sm-8" id="exampleFormControlFile1" name="tenKhoa">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Liên Hệ</label>
			    <textarea id="w3review" name="lienheKhoa" rows="4" cols="50"></textarea>
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

    