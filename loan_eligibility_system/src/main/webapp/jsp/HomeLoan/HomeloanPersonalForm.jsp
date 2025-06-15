<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>HomeLoan Personal Form</title>
    <link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/CSS/HomeLoan/HomeLoanPersonalForm.css"
    />
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
  </head>
  <body>
    <div class="card-container">
      <div class="step-progress d-flex justify-content-center">
        <div class="step active-step">1</div>
        <div class="step">2</div>
        <div class="step">3</div>
        <div class="step">4</div>
      </div>

      <h4 class="mb-4 text-center text-primary fw-bold">Step 1 of 4: Personal Information</h4>

      <form:form
        id="personalForm"
        method="POST"
        modelAttribute="loanApplyPersonalDTO"
        action="/homeloan/apply/personal"
      >
        <div class="mb-3">
          <label for="fullName" class="form-label">Full Name</label>
          <form:input
            path="fullName"
            id="fullName"
            class="form-control"
            placeholder="Enter full name"
            required="true"
          />
          <form:errors path="fullName" cssClass="text-danger small" />
        </div>

        <div class="row g-3 mb-3">
          <div class="col-md-6">
            <label for="email" class="form-label">Email</label>
            <form:input
              path="mailId"
              id="email"
              class="form-control"
              placeholder="Enter email"
              required="true"
            />
            <form:errors path="mailId" cssClass="text-danger small" />
          </div>
          <div class="col-md-6">
            <label for="mobile" class="form-label">Mobile Number</label>
            <form:input
              path="mobileNumber"
              id="mobile"
              class="form-control"
              placeholder="Enter mobile number"
              required="true"
            />
            <form:errors path="mobileNumber" cssClass="text-danger small" />
          </div>
        </div>
		
		<div class="row g-3 mb-3">
        <div class="col-md-6">
          <label class="form-label">Gender</label>
          <form:select path="gender" class="form-select" required="true">
            <form:option value="" label="Select gender" />
            <form:option value="MALE" label="Male" />
            <form:option value="FEMALE" label="Female" />
            <form:option value="OTHER" label="Other" />
          </form:select>
        </div>

        <!-- Date of Birth -->
        <div class="col-md-6">
          <label for="dob" class="form-label">Date of Birth</label>
          <form:input
            path="dateOfBirth"
            type="date"
            id="dob"
            class="form-control"
            required="true"
          />
        </div>
		</div>

		<div class="row g-3 mb-3">
        <div class="col-md-6">
          <label class="form-label">Marital Status</label>
          <form:select path="martialStatus" class="form-select" required="true">
            <form:options items="${martialStatuses}" />
          </form:select>
        </div>

        <div class="col-md-6">
          <label for="pan" class="form-label">PAN Number</label>
          <form:input
            path="panNumber"
            id="pan"
            class="form-control"
            placeholder="Enter PAN number"
            required="true"
          />
          <form:errors path="panNumber" cssClass="text-danger small" />
        </div>
		</div>

        <div class="mb-3">
          <label for="aadhar" class="form-label">Aadhar Number</label>
          <form:input
            path="aadharNumber"
            id="aadhar"
            class="form-control"
            placeholder="Enter Aadhar number"
            required="true"
          />
          <form:errors path="aadharNumber" cssClass="text-danger small" />
        </div>

        <div class="d-flex justify-content-between mt-4">
          <button type="button" class="btn btn-secondary">← Previous</button>
          <button type="submit" class="btn btn-warning">Next →</button>
        </div>
      </form:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="<%=request.getContextPath()%>/JS/HomeLoan/HomeLoanPersonalForm.js"></script>
  </body>
</html>
