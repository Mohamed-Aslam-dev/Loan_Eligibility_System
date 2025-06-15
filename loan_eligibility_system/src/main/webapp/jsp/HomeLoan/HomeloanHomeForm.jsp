<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home Loan - Home Info</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/HomeLoan/HomeloanIncomeForm.css" />
  <style>
    .card-container {
      margin: 80px auto;
    }
  </style>
  </head>
  <body>
    <div class="card-container slide-in">
      <div class="step-progress d-flex justify-content-center">
        <div class="step done-step">1</div>
        <div class="step done-step">2</div>
        <div class="step active-step">3</div>
        <div class="step">4</div>
      </div>

      <h4 class="mb-4 text-center text-primary fw-bold">
        Step 3 of 4: Home Information
      </h4>

      <form:form
        method="POST"
        modelAttribute="loanApplyHomeDTO"
        action="/homeloan/apply/home"
      >
          <div class="mb-3">
            <label for="estimatedConstructionCost" class="form-label"
              >Estimated Construction Cost (₹)</label
            >
            <form:input
              path="estimatedConstructionCost"
              type="number"
              class="form-control"
              id="estimatedConstructionCost"
              required="true"
            />
            <form:errors path="estimatedConstructionCost" cssClass="text-danger small" />
          </div>
          <div class="mb-3">
            <label for="propertyLocation" class="form-label"
              >Property Location</label
            >
            <form:input
              path="propertyLocation"
              type="text"
              class="form-control"
              id="propertyLocation"
              required="true"
            />
            <form:errors path="propertyLocation" cssClass="text-danger small" />
          </div>
          <div class="mb-3">
            <label for="landOwnerName" class="form-label"
              >Land Owner Name</label
            >
            <form:input
              path="landOwnerName"
              type="text"
              class="form-control"
              id="landOwnerName"
              required="true"
            />
            <form:errors path="landOwnerName" cssClass="text-danger small" />
          </div>

        <div class="d-flex justify-content-between mt-4">
          <a href="/homeloan/income" class="btn btn-secondary">← Previous</a>
          <button type="submit" class="btn btn-warning">Next →</button>
        </div>
      </form:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/JS/HomeLoan/HomeloanHomeForm.js"></script>
  </body>
</html>
