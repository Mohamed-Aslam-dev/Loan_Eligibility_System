<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Quick Query Form</title>

<!-- Bootstrap CSS & Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<style>
body {
	background: #fdfaf6;
	font-family: 'Segoe UI', sans-serif;
	transition: background 0.4s, color 0.4s;
}

.card {
	border-radius: 1.5rem;
	box-shadow: 0 6px 24px rgba(0, 0, 0, 0.1);
	border: none;
}

.card-header {
	border-radius: 1.5rem 1.5rem 0 0;
	background: linear-gradient(to right, #4facfe, #00f2fe);
	color: white;
	padding: 1rem 2rem;
	text-align: center;
}

.form-label {
	font-weight: 600;
	color: #333;
}

.form-control,
.form-select {
	border-radius: 0.5rem;
	transition: all 0.3s ease-in-out;
}

.form-control:focus,
.form-select:focus,
textarea:focus {
	border-color: #4facfe;
	box-shadow: 0 0 0 0.2rem rgba(79, 172, 254, 0.25);
}

.form-icon {
	position: absolute;
	left: 15px;
	top: 50%;
	transform: translateY(-50%);
	color: #6c757d;
}

.input-group {
	position: relative;
}

.input-group .form-control {
	padding-left: 2.5rem;
}

.btn-gradient {
	background: linear-gradient(to right, #0052D4, #4364F7, #6FB1FC);
	border: none;
	color: white;
	border-radius: 2rem;
	padding: 0.6rem 2rem;
	font-weight: 500;
	transition: background 0.3s;
}

.btn-gradient:hover {
	background: linear-gradient(to right, #4364F7, #6FB1FC, #0052D4);
}

.dark-mode {
	background-color: #121212 !important;
	color: #f1f1f1;
}

.dark-mode .card {
	background-color: #1e1e2f;
	color: #fff;
}

.dark-mode .form-control,
.dark-mode .form-select,
.dark-mode textarea {
	background-color: #2c2c3c;
	color: #fff;
	border-color: #555;
}

.theme-toggle {
	position: fixed;
	top: 20px;
	right: 30px;
	cursor: pointer;
	font-size: 1.8rem;
	z-index: 999;
	color: #0052D4;
}

.dark-mode .theme-toggle {
	color: #fff;
}
body.dark-mode ::placeholder {
  color: #bbb;
  opacity: 0.8;
}

body.dark-mode .form-control,
body.dark-mode .form-select,
body.dark-mode textarea {
  background-color: #2a2a3b !important;
  color: #fff !important;
  border-color: #555 !important;
}
</style>
</head>
<body>

<i class="bi bi-brightness-high theme-toggle" onclick="toggleTheme()"></i>

<div class="container mt-5">
	<div class="card shadow-lg">
		<div class="card-header">
			<h4><i class="bi bi-question-circle me-2"></i>Submit Your Query</h4>
		</div>
		<div class="card-body p-4">
			<form:form modelAttribute="anyQueries" id="queryForm" method="POST" action="/queries/add">
				
				<div class="mb-4 input-group">
					<i class="bi bi-person form-icon"></i>
					<form:input path="userName" id="queryName" cssClass="form-control" placeholder="Your Name" />
					<form:errors path="userName" cssClass="text-danger small" />
				</div>
				
				<div class="mb-4 input-group">
					<i class="bi bi-envelope form-icon"></i>
					<form:input path="email" id="queryEmail" cssClass="form-control" placeholder="example@gmail.com" />
					<form:errors path="email" cssClass="text-danger small" />
				</div>

				<div class="mb-4 input-group">
					<i class="bi bi-ui-checks form-icon"></i>
					<form:select path="queryType" id="queryType" cssClass="form-select">
						<option disabled selected value="">Choose Query Type...</option>
						<form:options items="${QueriesType}" />
					</form:select>
					<form:errors path="queryType" cssClass="text-danger small" />
				</div>

				<div class="mb-4">
					<label class="form-label">Your Message</label>
					<form:textarea path="message" rows="4" cssClass="form-control" placeholder="Type your query here..." />
					<form:errors path="message" cssClass="text-danger small" />
				</div>

				<div class="text-end">
					<button type="submit" class="btn btn-gradient">
						<i class="bi bi-send me-2"></i>Submit
					</button>
				</div>

			</form:form>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
	function toggleTheme() {
		document.body.classList.toggle('dark-mode');
	}
</script>

</body>
</html>
