<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class="container">
        <div class="row title">
            <div class="col1 col-xs-8">
                <h1>TRƯỜNG ĐẠI HỌC KHOA HỌC - ĐẠI HỌC HUẾ</h1>
            </div>
            <div class="col2 col-xs-4">
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
            <!-- <div class="col-xs-12 menuTab">
                <div class="logo">
                    <img src="/img/logo.png" alt="" width="112" height="33">
                </div>
                <div class="menu-main">
                    <ul>
                        <li class="dropdown1">
                            <a href="">Hỗ trợ hoạt động học tập</a>
                            <i class="fas fa-caret-down"></i>
                        </li>
                        <li class="dropdown2">
                            <a href="">Học tập - Lệ phí</a>
                            <i class="fas fa-caret-down"></i>
                        </li>
                    </ul>
                </div>
            </div> -->
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