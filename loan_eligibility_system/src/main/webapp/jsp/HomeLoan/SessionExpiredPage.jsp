<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Expired</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
      rel="stylesheet"
    /> 
    <style>
        body {
            background: #f4dfd0;
            font-family: 'Poppins', sans-serif;
        }
    </style>
</head>
<body>

    <body class="bg-light d-flex justify-content-center align-items-center" style="height:100vh;">
    <div class="card text-center shadow p-4" style="max-width: 500px;">
        <div class="card-body">
            <h4 class="text-danger">⚠️ Session Expired</h4>
            <p class="mt-3 text-muted">${errorMessage}</p>
            <a href="/" class="btn btn-primary mt-3">Start Loan Application Again</a>
        </div>
    </div>

</body>
</html>