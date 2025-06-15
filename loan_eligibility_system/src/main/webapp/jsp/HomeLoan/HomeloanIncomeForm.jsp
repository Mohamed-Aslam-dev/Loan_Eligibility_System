<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Home Loan - Income Info</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/HomeLoan/HomeloanIncomeForm.css" />
</head>
<body>
  <div class="card-container slide-in">
    <div class="step-progress d-flex justify-content-center">
      <div class="step done-step">1</div>
      <div class="step active-step">2</div>
      <div class="step">3</div>
      <div class="step">4</div>
    </div>

    <h4 class="mb-4 text-center text-primary fw-bold">Step 2 of 4: Income Information</h4>

    <form:form method="POST" modelAttribute="loanApplyIncomeDTO" action="/homeloan/apply/income">
      <div class="mb-3">
        <label for="employmentType" class="form-label">Employment Type</label>
        <form:select path="employmentType" class="form-select" id="employmentType" required="true">
          <form:options items="${employmentTypes}" />
        </form:select>
        <form:errors path="employmentType" cssClass="text-danger small" />
      </div>

      <div class="row g-3 mb-3">
        <div class="col-md-6">
          <label for="annualIncome" class="form-label">Annual Income (₹)</label>
          <form:input path="annualIncome" type="number" class="form-control" id="annualIncome" required="true" />
          <form:errors path="annualIncome" cssClass="text-danger small" />
        </div>
        <div class="col-md-6">
          <label for="workExperience" class="form-label">Total Work Experience (Years)</label>
          <form:input path="yearsOfExperience" type="number" class="form-control" id="workExperience" required="true" />
          <form:errors path="yearsOfExperience" cssClass="text-danger small" />
        </div>
      </div>

      <div class="d-flex justify-content-between mt-4">
        <a href="/homeloan/personal" class="btn btn-secondary">← Previous</a>
        <button type="submit" class="btn btn-warning">Next →</button>
      </div>
    </form:form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="<%=request.getContextPath()%>/JS/HomeLoan/HomeloanIncomeForm.js"></script>
</body>
</html>