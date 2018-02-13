<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">메뉴</li>
        <!-- li 클래스에 active가 있었다.-->
        <li class ="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>회원관리</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
 
             <li class="active"><a href="/admin/member/memberList.jsp"><i class="fa fa-circle-o"></i> 회원리스트</a></li>
            <li><a href="/admin/member/memberGrade.jsp"><i class="fa fa-circle-o"></i> 등급조정</a></li>
            <li><a href="/admin/member/memberOut.jsp"><i class="fa fa-circle-o"></i> 회원탈퇴</a></li>


          </ul>
        </li>
       </ul>