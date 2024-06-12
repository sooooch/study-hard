<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>spring2</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<c:set var="pageTitle" value="Post Create" />
		<%@ include file="../fragments/header.jspf"%>

		<main>
			<form method="post" action="${newPostPage}">
				<div class="mt-2">
					<input class="form-control" type="text" name="title" placeholder="제목을 적으시오" required autofocus />
				</div>
				<div class="mt-2">
					<textarea class="form-control" rows="10" name="content" placeholder="내용을 적으시오" required></textarea>
				</div>
				<div class="mt-2 ">
					<input class="form-control" type="text" name="author" value="${signedInUser}" required />
				</div>
				<div class="mt-2">
					<input class="form-control btn btn-success" type="submit" value="저장" />
				</div>
			</form>

		</main>

	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>