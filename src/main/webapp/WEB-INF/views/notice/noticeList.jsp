<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../layout/bootstrap.jsp" />
<body>
<c:import url="../layout/nav.jsp" />
	<div class="container">
		<table class="table">
			<thead>
				<tr><th class ="col-lg-1" style="text-align: center;">NUM</th><th class ="col-lg-5" style="text-align: center;">TITLE</th><th class ="col-lg-2" style="text-align: center;">WRITER</th><th class ="col-lg-2" style="text-align: center;">DATE</th><th class ="col-lg-2" style="text-align: center;">HIT</th></tr>
				
			</thead>
			<tbody>
			
				<c:forEach items="${List}" var="dto">
				<tr>
					<td style="text-align: center;">${dto.num}</td>
					<td style="text-align: center;"><a href="noticeSelect.notice?num=${dto.num}">${dto.title}</a></td>
					<td style=" text-align: center; ">${dto.writer}</td>
					<td style=" text-align: center; ">${dto.reg_date}</td>
					<td style=" text-align: center; ">${dto.hit}</td>
				</tr>
				</c:forEach>
					
				
			
			</tbody>
			
		</table>
		<div style="margin: auto;">
			 <ul class="pagination">
			 <c:if test="${pager.curBlock gt 1}">
				 <li><a href="noticeList?curPage=${pager.startNum-1}">이전</a></li>
			 </c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="noticeList?curPage=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock ne pager.totalBlock}">
				<li><a href="noticeList?curPage=${pager.lastNum+1}">다음</a></li>
			</c:if>
			
			
			</ul>
		</div>
				<!-- session member, memberDTO -->
				<c:if test="${empty sessionScope.member}">
					<a href = "noticeWrite.notice" class = "btn btn-primary" style="float: right;">INSERT</a>
				</c:if>
				<c:choose>
					<c:when test=""></c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				
				
	</div>
</body>
</html>