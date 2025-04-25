<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.div_page ul{
			display: flex;
			list-style: none;
		}
	</style>
</head>
<body>
	<table width="500" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
<!-- 		조회결과 -->
<!-- 		list : 모델객체에서 보낸 이름 -->
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.boardNo}</td>
				<td>${dto.boardName}</td>
				<td>
<%-- 					${dto.boardTitle} --%>
<!-- 			content_view : 컨트롤러단 호출 -->
<%--					<a href="content_view?boardNo=${dto.boardNo}">${dto.boardTitle}</a>--%>
					<a class="move_link" href="${dto.boardNo}">${dto.boardTitle}</a>
				</td>
				<td>${dto.boardDate}</td>
				<td>${dto.boardHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			<!-- 			write_view : 컨트롤러단 호출 -->
				<a href="write_view">글작성</a>
			</td>
		</tr>
	</table>

	<h3>${pageMaker}</h3>
	<div class="div_page">
		<ul>
			<c:if test="${pageMaker.prev}">
				<!-- <li>[Previous]</li> -->
				 <li class="paginate_button">
					<a href="${pageMaker.startPage - 1}">
						[Previous]
					</a>
				 </li>
			</c:if>

			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<!-- <li>[${num}]</li> -->
				<!-- <li ${pageMaker.cri.pageNum == num ? "style='color: red'":""}>[${num}]</li> -->
				<li class="paginate_button" ${pageMaker.cri.pageNum == num ? "style='color: red'":""}>
					<a href="${num}">
						[${num}]
					</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next}">
				<!-- <li>[Next]</li> -->
				<li class="paginate_button">
					<a href="${pageMaker.endPage + 1}">
						[Next]
					</a>
				 </li>
			</c:if>
		</ul>
	</div>
<%-- get 방식으로 url을 통해 원하는 페이지로 바로 넘어 갈 수 있음	--%>
	<form id="actionForm" action="list" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">

	</form>
</body>
</html>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
	var actionForm = $("#actionForm");
	//	페이지번호 처리
	$(".paginate_button a").on("click", function (e) {
		e.preventDefault();
		console.log("click~!!!");
		console.log("@# href=>"+$(this).attr("href"));
		// 페이지 번호를 들고 감
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();

	});//end of paginate_button click

	//게시글 처리
	$(".move_link").on("click",function(e){
		e.preventDefault();
		console.log("move_link click~!!!");
		console.log("@# href=>"+$(this).attr("href"));

		var targetBno = $(this).attr("href");
		// content_view?boardNo={dto.boardNo}를 actionfrom으로 처리
		actionForm.append("<input type='hidden' name='boardNo' value='"+targetBno+"'>");
		// controller에 있는 content_view로 이동
		actionForm.attr("action","content_view").submit();
	});
	// //버그 처리
	// actionForm.attr("action","list").submit();

</script>
<%--버그 처리--%>
	<script>
		window.onpageshow = function(event) {
		if (event.persisted || (window.performance && window.performance.navigation.type == 2)) {
			// event.persisted : 페이지가 캐시에서 로드된 경우
			// window.performance.navigation.type == 2 : 뒤로가기롤 통해 페이지에 접근했는지
			// 뒤로가기로 페이지 진입시 새로고침
			window.location.reload();
	}
	};
</script>
