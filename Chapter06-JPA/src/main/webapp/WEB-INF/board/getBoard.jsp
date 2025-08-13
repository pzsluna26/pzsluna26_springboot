<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="/css/style.css" rel="stylesheet" type="text/css">
	<title>글 상세</title>
</head>
<body>
	<div class="container1" align="center">
		<h3>게시글 상세</h3>
		<hr>
		<form action="updateBoard" method="post">
		<input name="seq" type="hidden" value="${board.seq}"/>
		<table>
			<tr>
				<td bgcolor="skyblue" width="70">제목</td>
				<td align="left">
					<input name="title" type="text" value="${board.title}"/>
				</td>
			</tr>		
			<tr>
				<td bgcolor="skyblue">작성자</td>
				<td align="left">${board.writer}</td>
			</tr>
			<tr>
				<td bgcolor="skyblue">내용</td>
				<td align="left">
					<textarea name="content" cols="40" rows="10" autofocus>${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<td bgcolor="skyblue">등록일</td>
				<td align="left">
					<fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd"/>
					
				</td>
			</tr>
			<tr>
				<td bgcolor="skyblue">조회수</td>
				<td align="left">${board.cnt}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="글 수정"/></td>
			</tr>
		</table> 
		</form>
		<hr>
		<a href="insertBoard">글등록</a>>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard?seq=${board.seq}">글삭제</a>>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList">글목록</a>
	</div>
</body>
</html>