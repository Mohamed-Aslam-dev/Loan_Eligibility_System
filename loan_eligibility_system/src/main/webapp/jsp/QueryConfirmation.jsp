<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Query Submitted</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background-color: #f2f6fc;
            font-family: 'Segoe UI', sans-serif;
        }

        .card {
            border-radius: 2rem;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            margin-top: 100px;
        }

        .card-header {
            border-top-left-radius: 2rem;
            border-top-right-radius: 2rem;
            background: linear-gradient(to right, #28a745, #218838);
            color: #fff;
        }

        .card-body {
            text-align: center;
        }

        .success-icon {
            font-size: 3rem;
            color: #28a745;
        }

        .token-box {
            margin-top: 20px;
            background: #e6f9ec;
            border-left: 5px solid #28a745;
            padding: 10px;
            border-radius: 0.5rem;
            font-weight: 500;
            color: #155724;
        }

        /* Dark Mode Support */
        body.dark-mode {
            background-color: #121212;
            color: #f1f1f1;
        }

        body.dark-mode .card {
            background-color: #1e1e2f;
            color: #f1f1f1;
        }

        body.dark-mode .card-header {
            background: linear-gradient(to right, #28a745, #218838);
        }

        body.dark-mode .token-box {
            background-color: #2d4831;
            color: #d4edda;
            border-color: #28a745;
        }

        .theme-toggle {
            position: absolute;
            top: 20px;
            right: 30px;
            cursor: pointer;
            font-size: 1.5rem;
            color: #28a745;
        }

        body.dark-mode .theme-toggle {
            color: #fff;
        }
    </style>
</head>
<body>

    <!-- Dark Mode Toggle -->
    <i class="bi bi-moon-fill theme-toggle" onclick="toggleTheme()"></i>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card text-center">
                    <div class="card-header">
                        <h4 class="mb-0"><i class="bi bi-check-circle-fill me-2"></i>Query Submitted Successfully</h4>
                    </div>
                    <div class="card-body">
                        <p class="success-icon"><i class="bi bi-patch-check-fill"></i></p>
                        <p>Thank you for reaching out. Your query has been received and will be addressed shortly.</p>

                        <c:if test="${not empty tokenId}">
                            <div class="token-box">
                                <p>Your Reference Token ID:</p>
                                <h5>${tokenId}</h5>
                            </div>
                        </c:if>

                        <a href="/" class="btn btn-success mt-4">
                            <i class="bi bi-house-door-fill me-1"></i>Back to Home
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function toggleTheme() {
            document.body.classList.toggle("dark-mode");
        }
    </script>

</body>
</html>
