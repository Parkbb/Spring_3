
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/point/pointList.jsp">PointList</a></li>
          <li><a href="${pageContext.request.contextPath}/point/pointInsert.jsp">PointInsert</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="${pageContext.request.contextPath}/notice/noticeList">NOTICE</a></li>
      <li><a href="${pageContext.request.contextPath}/qna/qnaList">QNA</a></li>

    </ul>
    <ul class="nav navbar-nav navbar-right">
    	
      <li><a href="${pageContext.request.contextPath}/member/memberMypage.jsp"><span class="glyphicon glyphicon-user"></span> My Page</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberLoginout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      
      <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     
    </ul>
  </div>
</nav>
	<div>
		<h1></h1>
	</div>