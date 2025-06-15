<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Live Gold Rate</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #fff8e1, #fffde7);
        }
        .card {
            border: none;
            border-radius: 1rem;
            background: #fffbe6;
        }
        .table th {
            background-color: #ffcc00 !important;
            color: #000;
        }
        .gold-title {
            font-weight: bold;
            background: -webkit-linear-gradient(#b8860b, #ffcc00);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            font-size: 2rem;
        }
        .price-td {
            font-weight: bold;
            color: #28a745;
        }
        .fade-in {
            animation: fadeIn 1s ease-in;
        }
        @keyframes fadeIn {
            0% { opacity: 0; transform: translateY(-10px); }
            100% { opacity: 1; transform: translateY(0); }
        }
        .back-btn {
            background-color: #ffcc00;
            color: #000;
            font-weight: 500;
            border: none;
            border-radius: 8px;
            padding: 6px 16px;
            transition: all 0.3s ease;
        }
        .back-btn:hover {
            background-color: #e6b800;
            color: #fff;
        }
    </style>
</head>
<body class="bg-light fade-in">

    <div class="container mt-5">
        <div class="card shadow-lg p-4">
            <h2 class="text-center mb-4 gold-title">Live Gold Price per Gram</h2>

            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>

            <!-- 🔙 Back Button -->
            <div class="mb-3">
                <button onclick="history.back()" class="back-btn">
                    ← Back
                </button>
            </div>

            <div class="row mb-3 text-center">
                <div class="col-md-4">
                    <p><strong>📍 Location:</strong> ${location}</p>
                </div>
                <div class="col-md-4">
                    <p><strong>💱 Currency:</strong> ${currency}</p>
                </div>
                <div class="col-md-4">
                    <p><strong>⏱ Timestamp:</strong> ${timestamp}</p>
                </div>
            </div>

            <table class="table table-bordered table-hover mt-3 text-center">
                <thead>
                    <tr>
                        <th>Karat</th>
                        <th>Price (INR)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${rates}">
                        <tr>
                            <td>${entry.key}</td>
                            <td class="price-td">₹ ${entry.value}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
