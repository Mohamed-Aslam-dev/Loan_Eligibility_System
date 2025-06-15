<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>OTP Verification</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet" />
    <style>
        body {
            background: #f4dfd0;
            font-family: 'Poppins', sans-serif;
        }
        .otp-card {
            max-width: 400px;
            margin: 180px auto;
            border: 1px solid #ddd;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.1);
        }
        .otp-card .card-header {
            background-color: #0d6efd;
            color: white;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
        }
        .form-label {
            font-weight: 500;
        }
        .error-msg {
            color: red;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
    <div class="card otp-card">
        <div class="card-header text-center">
            <h5>OTP Verification</h5>
        </div>
        <div class="card-body">
            <form method="post" action="/homeloan/verify-otp">
                <div class="mb-3">
                    <label for="otp" class="form-label">OTP sent to your email</label>
                    <input type="text" name="otp" id="otp" class="form-control" required />
                    <c:if test="${not empty errorMessage}">
                        <div class="error-msg mt-1">${errorMessage}</div>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-success w-100">Verify</button>
            </form>
        </div>
    </div>
</body>
</html>