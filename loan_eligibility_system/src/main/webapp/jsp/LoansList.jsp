<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${statusLabel} Loans</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
</head>
<body class="p-3">
    <div class="container">
        <h2 class="mb-4 text-primary">📋 ${statusLabel} Loan Applications</h2>

        <!-- 🔙 Back Button -->
        <a href="/admin/dashboard" class="btn btn-secondary mb-3">← Back to Dashboard</a>

        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Loan Ref ID</th>
                    <th>Name</th>
                    <th>Mobile</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${loans}" var="loan">
                    <tr>
                        <td>${loan.loanReferenceId}</td>
                        <td>${loan.personalData.fullName}</td>
                        <td>${loan.personalData.mobileNumber}</td>
                        <td>
                            <a href="/admin/fetchLoanData?loanId=${loan.loanReferenceId}" class="btn btn-sm btn-primary">View</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
