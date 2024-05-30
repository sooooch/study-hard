<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">



</head>
<body>
	<div class="container-fluid">
		<c:set var="pageTitle" value="Post Modify" />
		<%-- scope의 기본값은 page --%>
		<%@ include file="../fragments/header.jspf"%>


		<main>
			<div class="mt-2 card">
				<div class="card-header">
					<h2>포스트 수정 페이지</h2>
				</div>
				<div class="card-body">
					<form id="modifyForm">
						<div class="mt-2">
							<label for="id" class="form-label">번호</label> <input name="id" id="id"
								class="form-control" type="text" value="${post.id}" readonly />
						</div>
						<div class="mt-2">
							<label for="title" class="form-label">제목</label> <input
								name="title" id="title" class="form-control" type="text"
								value="${post.title}" />
						</div>
						<div class="mt-2">
							<label for="content" class="form-label">내용</label>
							<textarea name="content" id="content" class="form-control" rows="5">${post.content}</textarea>
						</div>
						<div class="mt-2 d-none"> <!-- 있는데 안 보임 -->
							<label for="author" class="form-label">작성자</label> <input
								 id="author" class="form-control" type="text"
								value="${post.author}" readonly />
						</div>
					</form>
				</div>
				<div class="card-footer">
					<button id="btnDelete" class="btn btn-outline-danger">삭제</button>
					<button id="btnUpdate" class="btn btn-outline-success">수정완료</button>
				</div>
			</div>
		</main>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
		
	<script src="../js/post_modify.js">
	
	</script>
</body>
</html>
