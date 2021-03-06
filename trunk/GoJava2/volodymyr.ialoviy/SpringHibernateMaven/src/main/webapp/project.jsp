<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Kickstarter project</title>
<style><%@include file='/defoult.css' %></style>
</head>
<body>
<div class="center" >
<div class="center2" >

	<h1>Project from category with name - ${project.category.name}</h1>
	<div class="CSSTableGenerator" >
	<table>
		<tr>
			<td>NAME</td>
			<td>VALUE</td>
		</tr>
		<tr>
			<td>project name:</td>
			<td>${project.name}</td>
		</tr>
		<tr>
			<td>short description:</td>
			<td>${project.shortDescription}</td>
		</tr>
		<tr>
			<td>full description:</td>
			<td>${project.fullDescription}</td>
		</tr>
		<tr>
			<td>foto:</td>
			<td>${project.foto}</td>
		</tr>
		<tr>
			<td>link:</td>
			<td>${project.link}</td>
		</tr>
		<tr>
			<td>how much needed:</td>
			<td>${project.howMuchNeeded}</td>
		</tr>
		<tr>
			<td>how much collected:</td>
			<td>${project.howMuchCollected}</td>
		</tr>
		<tr>
			<td>how much remaining;</td>
			<td>${project.howMuchRemaining}</td>
		</tr>
		<tr>
			<td>days to go:</td>
			<td>${project.dateClose}</td>
		</tr>
	</table>
	</div>
	
	<p>If you want return to <a class="button" href="${ctx}/projects/${project.idCategory}">projects</a></p>
	<p>If you want to <a class="button" href="${ctx}/donate/${project.id}">invest to the project</a></p>

	<h3><c:out value="${message}" /></h3>
	
	<h1>Questions and answers for this project with name - ${project.name}</h1>
	
	<div class="CSSTableGenerator" >
	<table>
		<tr>
			<td>QUESTION</td>
			<td>ANSWER</td>
			<td>DELETE QUESTION</td>
			<td>ADD ANSWER</td>
		</tr>
		<tr>
			<c:forEach items="${questions}" var="question">
				<tr>
					<td>${question.question}</td>
					<td>${question.answer}</td>
					<td><a href="${ctx}/question/${question.id}/${question.idProject}?delete">delete this question</a></td>
					<td><a href="${ctx}/question/${question.id}?addanswer">add answer to this question</a></td>
				</tr>
			</c:forEach>
	</table>
	</div>
	<p>Have a question? If the info above doesn't help, you can <a class="button" href="${ctx}/question/${project.id}?add">ask the project creator directly</a></p>

</div>
</div>
</body>
</html>
