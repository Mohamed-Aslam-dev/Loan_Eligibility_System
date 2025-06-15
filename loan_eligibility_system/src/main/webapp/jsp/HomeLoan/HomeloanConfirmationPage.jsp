<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Loan Application Status</title>
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
    <link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/CSS/HomeLoan/HomeloanSuccess.css"
    />
  </head>
  <body>
    <div class="card p-4 text-center">
      <div class="mb-4">
        <i class="bi bi-check-circle-fill status-icon success-icon"></i>
      </div>
      <h3 class="mb-3 text-success">Loan Application Successful!</h3>
      <p><strong>Loan Reference ID:</strong> ${response.loanId}</p>
      <p><strong>CIBIL Score:</strong> ${response.cibilScore}</p>
      <p>
        <strong>Status:</strong>
        <span class="badge bg-primary">${response.loanStatus}</span>
      </p>
      <p class="applied-date"><em>Applied on: ${response.appliedDate}</em></p>
      <div class="mt-4">
        <a href="/" class="btn btn-outline-success">Go to Home</a>
      </div>
    </div>

    <!-- Bootstrap Icons CDN -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
