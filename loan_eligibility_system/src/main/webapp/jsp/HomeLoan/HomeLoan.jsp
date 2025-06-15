<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home Loan T&C</title>
    <link rel="icon" href="/Media/house-solid.ico">
    <!-- Bootstrap & Fonts -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
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

    <!-- Your CSS -->
    <!-- <link rel="stylesheet" href="/HomeLoan/HomeLoan.css" /> -->
    <link
      rel="stylesheet"
      href="<%= request.getContextPath() %>/CSS/HomeLoan/HomeLoan.css"
    />

  </head>
  <body>
    <div id="homeLoanPopup" class="home-loan-box show">
      <h4>🏠 Welcome to Home Loan Section</h4>
      <p>Please go through the criteria and accept the terms to continue.</p>

      <h6>Eligibility Criteria:</h6>
      <ul>
        <li>✔️ Applicant must be between 21 and 60 years</li>
        <li>✔️ Minimum salary: ₹25,000/month</li>
        <li>✔️ Valid ID & address proof required</li>
      </ul>

      <h6 class="mt-3">Do you agree to the following?</h6>
      <div>
        <input type="checkbox" id="agree" name="terms" value="agree" />
        <label for="agree">I agree to the Terms and Conditions</label><br />
      </div>
      <div class="button-group">
        <button class="btn btn-success mt-3" onclick="submitHomeLoan()">
          Submit
        </button>
        <button class="btn btn-danger mt-2" id="close-btn" onclick="closeHomeLoan()">
          Close
        </button>
      </div>
    </div>
    
    <script src="<%= request.getContextPath() %>/JS/HomeLoan/HomeLoan.js"></script>
  </body>
</html>
