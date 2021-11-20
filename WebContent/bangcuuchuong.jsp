<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<% String tamnhap= request.getParameter("txtnhap"); %>
		<table class="table">  
			 <tr> 	
		       		<th scope="row">
		       		Nhập số cần tính bảng cửu chương
		       		<form action="" method="post">
		       			<input type="number" name="txtnhap" value="<%=(tamnhap == null ? "1" : tamnhap)%>">
		       			<input type="submit" name="btnxuat" value="Xuất">
		       		</form>
		     </tr>
		     <% 
		     	System.out.print(tamnhap);
		    	if(tamnhap != null){	 
		    		int a  = Integer.parseInt(tamnhap); 
		    		if(request.getParameter("btnxuat") !=null){
				for(int i=1;i<=10;i++){ %>
				       <tr>
					       	<td >
					       	<%=a%>x<%=i%> = <%=a*i%> 
					       	</td>
				       	</tr>
				       	<%} %>
				<%} %>
			<%} %> 
		</table>
	</body>
</html>