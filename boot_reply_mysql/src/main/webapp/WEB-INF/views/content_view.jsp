<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<form method="post" action="modify">
			<input type="hidden" name="boardNo" value="${content_view.boardNo}">
			<tr>
				<td>번호</td>
				<td>
					${content_view.boardNo}
				</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>
					${content_view.boardHit}
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
<%-- 					${content_view.boardName} --%>
					<input type="text" name="boardName" value="${content_view.boardName}">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
<%-- 					${content_view.boardTitle} --%>
					<input type="text" name="boardTitle" value="${content_view.boardTitle}">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
<%-- 					${content_view.boardContent} --%>
					<input type="text" name="boardContent" value="${content_view.boardContent}">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					&nbsp;&nbsp;<a href="list">목록보기</a>
					&nbsp;&nbsp;<a href="delete?boardNo=${content_view.boardNo}">삭제</a>
				</td>
			</tr>
		</form>
	</table>

<div>
	<input type="text" id="commentContent" placeholder="댓글을 입력하세요">
	<input type="text" id="commentWriter" placeholder="작성자">
	<button onclick="commentWrite()">댓글 작성</button>
</div>
</body>
<script>
	const commentWrite = () => {
		const commentContent = document.getElementById("commentContent").value;
		const commentWriter = document.getElementById("commentWriter").value;
		const boardNo = ${content_view.boardNo};

		if (commentContent === "" || commentWriter === "") {
			alert("댓글 내용과 작성자를 입력하세요.");
			return;
		}
		if (commentContent.length > 200) {
			alert("댓글은 200자 이내로 작성해주세요.");
			return;
		}
		fetch('commentWrite', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				boardNo: boardNo,
				commentContent: commentContent,
				commentWriter: commentWriter
			})
		})
		.then(response => response.json())
		.then(data => {
			if (data.success) {
				alert("댓글이 작성되었습니다.");
				location.reload();
			} else {
				alert("댓글 작성에 실패했습니다.");
			}
		})
		.catch(error => console.error('Error:', error));
	};}
</script>
</html>













