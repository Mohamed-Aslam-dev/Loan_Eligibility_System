<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Loan Full Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <style>
      body {
        background: radial-gradient(
          #f5f7fa,
          #c3cfe2
        ); /* soft matching background */
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        padding: 20px;
      }

      .section-box {
        background: #fff;
        border: 1px solid #dee2e6;
        border-radius: 10px;
        padding: 20px;
        margin-bottom: 20px;
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
      }

      .section-title {
        font-size: 20px;
        font-weight: 600;
        margin-bottom: 15px;
        color: #0056b3;
      }

      pre {
        background-color: #f1f5ff;
        padding: 12px;
        border-radius: 8px;
        font-size: 14px;
        line-height: 1.5;
        overflow-x: auto;
      }

      .btn-back {
        position: fixed;
        top: 20px;
        left: 20px;
        background-color: #6c757d;
        border: none;
        color: white;
        border-radius: 5px;
        padding: 8px 16px;
      }

      .btn-back:hover {
        background-color: #5a6268;
      }

      .loan-card {
        background: linear-gradient(
          to right,
          #e0eafc,
          #cfdef3
        ); /* light blue gradient */
        color: #333;
        padding: 20px;
        border-radius: 12px;
        margin-bottom: 20px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s ease;
      }

      .loan-card h5 {
        font-weight: bold;
        font-size: 1.2rem;
        margin-bottom: 15px;
        color: #3b3b3b;
      }

      .loan-card .section-icon {
        margin-right: 8px;
        color: #007bff;
      }

      .loan-card .loan-detail {
        background-color: #f3f6fa;
        border-radius: 10px;
        padding: 12px 20px;
        font-size: 1rem;
        margin-bottom: 10px;
        color: #333;
      }

      .loan-card .loan-detail strong {
        color: #555;
      }

      .page-title {
        font-weight: 700;
        text-align: center;
        margin-top: 30px;
        font-size: 2rem;
        color: #343a40;
        text-shadow: 1px 1px #ccc;
      }

      .loan-card:hover {
        box-shadow: 0 6px 12px rgba(58, 58, 142, 0.15);
        background-color: #f5f7ff;
        transform: translateY(-4px);
      }

      .section-icon {
        color: #3a3a8e;
        margin-right: 10px;
        transition: color 0.3s ease, transform 0.3s ease;
      }

      .loan-card:hover .section-icon {
        color: #5b7cfa;
        transform: scale(1.2) rotate(5deg);
      }

      .animated-icon {
        animation: pulse 1.5s infinite;
      }

      @keyframes pulse {
        0% {
          transform: scale(1);
        }
        50% {
          transform: scale(1.1);
        }
        100% {
          transform: scale(1);
        }
      }
    </style>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
  </head>
  <body class="p-3">
    <div class="container">
      <button
        class="btn btn-secondary back-btn"
        onclick="window.location.href='dashboard'"
      >
        ← Back
      </button>
      <h2 class="page-title">
        Customer Loan Details <span id="loanId"></span>
      </h2>
      <div class="loan-card hover-card">
        <h5>
          <i class="bi bi-person-fill section-icon animated-icon"></i>Customer
          Details
        </h5>
        <div class="loan-detail">
          <strong>Full Name:</strong> ${loanData.fullName}
        </div>
        <div class="loan-detail">
          <strong>Mobile Number:</strong> ${loanData.mobileNumber}
        </div>
      </div>

      <div class="loan-card hover-card">
        <h5>
          <i class="bi bi-house-fill section-icon animated-icon"></i>Home
          Details
        </h5>
        <div class="loan-detail">
          <strong>Land Owner Name:</strong> ${loanData.landOwnerName}
        </div>
      </div>

      <div class="loan-card hover-card">
        <h5>
          <i class="bi bi-cash-coin section-icon animated-icon"></i>Loan Info
        </h5>
        <div class="loan-detail">
          <strong>Cibil Score:</strong> ${loanData.cibilScore}
        </div>
        <div class="loan-detail">
          <strong>Loan Reference ID:</strong> ${loanData.loanReferenceId}
        </div>
        <div class="loan-detail">
          <strong>Loan Status:</strong> ${loanData.loanStatus}
        </div>
      </div>
      <div class="loan-card hover-card">
        <h5><i class="bi bi-bank section-icon animated-icon"></i>Bank Info</h5>
        <div class="loan-detail">
          <strong>Bank Name:</strong> ${loanData.bankName}
        </div>
      </div>

      <div class="loan-card hover-card">
        <h5>
          <i class="bi bi-file-earmark-text section-icon animated-icon"></i
          >Document Info
        </h5>
        <div class="loan-detail"><strong></strong> Loading....</div>
      </div>
      <div class="loan-card hover-card">
        <h5>
          <i class="bi bi-terminal section-icon animated-icon"></i>Agent
          Commands
        </h5>
        <ul id="agentComments" class="list-group"></ul>
      </div>
      <div class="text-center my-3">
        <button id="approveBtn" class="btn btn-success mx-2">Approve</button>
        <button id="rejectBtn" class="btn btn-danger mx-2">Reject</button>
      </div>
    </div>
	  <input type="hidden" id="loanRefID" value="${loanData.loanReferenceId}">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 

<script>
$(document).ready(function () {
    var loanRefID = $("#loanRefID").val();

    $("#approveBtn").click(function () {
        $.ajax({
            url: '/admin/' + loanRefID + '/approve',
            type: 'POST',
            success: function () {
                window.location.href = '/admin/approved'; // ✅ redirect manually
            },
            error: function () {
                alert('Error approving loan.');
            }
        });
    });

    $("#rejectBtn").click(function () {
        $.ajax({
            url: '/admin/' + loanRefID + '/reject',
            type: 'POST',
            success: function () {
                window.location.href = '/admin/rejected'; // ✅ redirect manually
            },
            error: function () {
                alert('Error rejecting loan.');
            }
        });
    });
});
</script>

  </body>
</html>
