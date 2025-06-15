<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home Loan - Loan Info</title>
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
      href="<%=request.getContextPath()%>/CSS/HomeLoan/HomeloanIncomeForm.css"
    />
    <style>
      .card-container {
        margin: 60px auto;
      }
    </style>
  </head>
  <body>
    <div class="card-container slide-in">
      <div class="step-progress d-flex justify-content-center">
        <div class="step done-step">1</div>
        <div class="step done-step">2</div>
        <div class="step done-step">3</div>
        <div class="step active-step">4</div>
      </div>

      <h4 class="mb-4 text-center text-primary fw-bold">
        Step 4 of 4: Loan Information
      </h4>

      <form:form
        method="POST"
        modelAttribute="loanApplyLoanDTO"
        action="/homeloan/apply/loan"
      >
        <div class="mb-3">
          <label for="loanAmount" class="form-label"
            >Expected Loan Amount (₹)</label
          >
          <form:input
            path="loanAmount"
            type="number"
            class="form-control"
            id="loanAmount"
            required="true"
          />
          <form:errors path="loanAmount" cssClass="text-danger small" />
        </div>
        <div class="mb-3">
          <label for="tenure" class="form-label">Tenure (Months)</label>
          <form:input
            path="tenure"
            type="number"
            class="form-control"
            id="tenure"
            required="true"
          />
          <form:errors path="tenure" cssClass="text-danger small" />
        </div>
        <div class="mb-3">
          <label for="bankAccountNumber" class="form-label"
            >Bank Account Number</label
          >
          <form:input
            path="bankAccountNumber"
            type="tel"
            class="form-control"
            id="bankAccountNumber"
            required="true"
          />
          <form:errors path="bankAccountNumber" cssClass="text-danger small" />
        </div>
        <div class="row g-3 mb-3">
          <div class="col-md-6">
            <label for="bankIFSCcode" class="form-label">Bank IFSC Code</label>
            <form:input
              path="bankIFSCcode"
              type="text"
              class="form-control"
              id="bankIFSCcode"
              required="true"
            />
            <form:errors path="bankIFSCcode" cssClass="text-danger small" />
          </div>
          <div class="col-md-6">
            <label for="bankName" class="form-label">Bank Name</label>
            <form:input
              path="bankName"
              type="text"
              class="form-control"
              id="bankName"
              required="true"
            />
            <form:errors path="bankName" cssClass="text-danger small" />
          </div>
        </div>

        <div class="d-flex justify-content-between mt-4">
          <a href="/homeloan/home" class="btn btn-secondary">← Previous</a>
          <button type="submit" class="btn btn-warning">Next →</button>
        </div>
      </form:form>
    </div>
    <script>
      // Prevent back button after submission
      history.pushState(null, null, location.href);
      window.onpopstate = function () {
        history.go(1); // disables back
      };
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/JS/HomeLoan/HomeloanHomeForm.js"></script>
  </body>
</html>
