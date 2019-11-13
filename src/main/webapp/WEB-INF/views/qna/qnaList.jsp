<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../layout/bootstrap.jsp" />
<body>
	<c:import url="../layout/nav.jsp" />
	<div class="container" class="col-sm-2">
		<form id="frm" action="qnaList" class="col-sm-2">
		<input type="hidden" id="curPage" value="1" name="curPage">
			<select class="form-control" id="sel1" name="kind" class="col-sm-2" style="float: left" >
				<option id="kt" value="kt">Title</option>
				<option id="kc" value="kc">Contents</option>
				<option id="kw" value="kw">Writer</option>
			</select>
			<input type="text" class="form-control" placeholder="Search" name="search" class="col-sm-2" style="float: left" value="${pager.search}">
     		 <div class="input-group-btn">
        	<button class="btn btn-default" type="submit" style="float: left"><i class="glyphicon glyphicon-search" style="float: left"></i></button>
      	  </div>
		</form>
	</div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th class="col-lg-1" style="text-align: center;">NUM</th>
					<th class="col-lg-5" style="text-align: center;">TITLE</th>
					<th class="col-lg-2" style="text-align: center;">WRITER</th>
					<th class="col-lg-2" style="text-align: center;">DATE</th>
					<th class="col-lg-2" style="text-align: center;">HIT</th>
				</tr>

			</thead>
			<tbody>

				<c:forEach items="${List}" var="dto">
					<tr>
						<td style="text-align: center;">${dto.num}</td>
						<td style="text-align: left;">
						<c:forEach begin="1" end="${dto.depth}">&nbsp;&nbsp;&nbsp;</c:forEach>
						<c:if test="${dto.depth gt 0}">&nbsp;↳</c:if>
						<a href="qnaSelect?num=${dto.num}">${dto.title}</a></td>
						<td style="text-align: center;">${dto.writer}</td>
						<td style="text-align: center;">${dto.reg_date}</td>
						<td style="text-align: center;">${dto.hit}</td>
					</tr>
				</c:forEach>



			</tbody>

		</table>
		<div style="margin: auto;">
			 <ul class="pagination">
			 <c:if test="${pager.curBlock gt 1}">
				 <li><span id="${pager.startNum-1}" class="list" >이전</span></li>
			 </c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><span id="${i}" class="list">${i}</span></li>
			</c:forEach>
			<c:if test="${pager.curBlock ne pager.totalBlock}">
				<li><span id="${pager.lastNum+1}" class="list" >다음</span></li>
			</c:if>
			
			
			
			</ul>
		</div>
	<a href="qnaWrite" class="btn btn-primary"
				style="float: right;">INSERT</a>

	</div>
	
	<script type="text/javascript">
		var kind = '${pager.kind}';
		if(kind ==''){
			kind='kt';
		}
		$("#"+kind).prop("selected", true);
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"))
			$("#frm").submit();
		});
	</script>
</body>
</html>