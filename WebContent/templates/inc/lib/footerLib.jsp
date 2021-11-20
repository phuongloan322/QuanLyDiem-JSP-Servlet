<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

   <!-- jQuery -->
<%-- <script src="<%=request.getContextPath()%>/templates/plugins/jquery/jquery.min.js"></script> --%>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/templates/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/templates/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/templates/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/templates/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<%-- <script src="<%=request.getContextPath()%>/templates/plugins/jqvmap/jquery.vmap.min.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/templates/plugins/jqvmap/maps/jquery.vmap.usa.js"></script> --%>
<!-- jQuery Knob Chart -->
<script src="<%=request.getContextPath()%>/templates/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/templates/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/templates/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/templates/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/templates/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/templates/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/templates/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/templates/dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<%=request.getContextPath()%>/templates/dist/js/pages/dashboard.js"></script>