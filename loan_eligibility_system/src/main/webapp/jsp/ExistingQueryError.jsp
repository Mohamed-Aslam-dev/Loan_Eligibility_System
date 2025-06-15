<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Query Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center" style="height: 100vh;">
    <div class="card p-5 shadow-sm" style="max-width: 500px; width: 100%;">
        <h3 class="text-danger mb-3">Oops!</h3>
        <p>${errorMessage}</p>
        <a href="/queries/anyQuery" class="btn btn-primary mt-3">Back to Query Form</a>
    </div>
</body>
</html>
