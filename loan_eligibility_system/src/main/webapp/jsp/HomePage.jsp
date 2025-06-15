<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Money Maven</title>
<link rel="icon" href="/Media/landmark-solid.ico" />
<link rel="stylesheet" type="text/css" href="/CSS/HomePageStyle.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="top-bar">
		<div class="left-logo ps-2">
			<strong>Money Maven</strong>
		</div>
		<div class="right-icons pe-3">
			<a href="mailto:moneymaven.loans@gmail.com"
				class="text-decoration-none text-dark"> <i
				class="bi bi-envelope-arrow-up"></i> moneymaven.loans@gmail.com
			</a> <i class="bi bi-telephone"> 1800 1080</i> <i
				class="bi bi-moon-fill theme-toggle" onclick="toggleTheme()"></i> <i
				class="bi bi-person-circle" style="cursor: pointer;"
				onclick="askUserType()"></i>
			<button class="btn btn-light btn-sm ms-2">Login</button>
		</div>
	</div>

	<ul class="nav nav-tabs px-3">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" role="button" data-bs-toggle="dropdown"
			aria-expanded="false"> APPLY LOANS </a>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="/jsp/HomeLoan/HomeLoan.jsp">HOME
						LOAN</a></li>
				<li><a class="dropdown-item" href="#">PERSONAL LOAN</a></li>
				<li><a class="dropdown-item" href="#">PROPERTY LOAN</a></li>
				<li><a class="dropdown-item" href="#">GOLD LOAN</a></li>
				<li><a class="dropdown-item" href="#">EDUCATION LOAN</a></li>
				<li><hr class="dropdown-divider" /></li>
				<li><a class="dropdown-item" href="#">Something else here</a></li>
			</ul></li>
		<li class="nav-item"><a class="nav-link" href="#">EMI
				CALCULATOR</a></li>
		<li class="nav-item"><a class="nav-link" href="#">ELIGIBILITY</a></li>
		<li class="nav-item"><a class="nav-link" href="/gold/live">CURRENT GOLD
				RATES</a></li>
		<li class="nav-item"><a class="nav-link" href="#faqAccordion">FAQs</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="/queries/anyQuery">ANY QUERIES</a>
		</li>
	</ul>

	<div class="container my-5">
		<div class="row g-4 align-items-center">
			<div class="col-md-6">
				<div class="highlight-title">Secure Loans up to ₹50 Lakhs</div>
				<ul class="loan-highlights list-unstyled mt-4">
					<li>✅ Minimal documentation</li>
					<li>✅ Flexible tenure up to 72 months</li>
					<li>✅ Loan amount of up to ₹50 lakh</li>
					<li>✅ Online application and disbursement</li>
					<li>✅ Attractive interest rates starting @ 10.85%</li>
				</ul>
				<button class="apply-btn mt-3" onclick="showLoanOptions()">
					APPLY NOW</button>
			</div>

			<div class="col-md-6">
				<div class="calculator-box">
					<h5 class="mb-3">Personal Loan EMI Calculator</h5>
					<div class="mb-3">
						<label>Enter Loan Amount</label> <input type="number"
							class="form-control" id="amount" value="500000" />
					</div>

					<div class="amount-buttons">
						<button class="btn btn-outline-secondary btn-sm"
							onclick="setAmount(100000)">1L</button>
						<button class="btn btn-outline-secondary btn-sm"
							onclick="setAmount(500000)">5L</button>
						<button class="btn btn-outline-secondary btn-sm"
							onclick="setAmount(1000000)">10L</button>
						<button class="btn btn-outline-secondary btn-sm"
							onclick="setAmount(2000000)">20L</button>
						<button class="btn btn-outline-secondary btn-sm"
							onclick="setAmount(5000000)">50L</button>
					</div>

					<div class="mt-4">
						<label>Illustrative Interest Rate (p.a)</label> <input
							type="number" class="form-control" id="rate" value="10.85" />
					</div>

					<div class="mt-4">
						<label>Duration (Months)</label> <input type="range"
							class="form-range" min="12" max="72" step="12" id="duration"
							value="36" />
						<p>
							<span id="durationValue">36</span> Months
						</p>
					</div>

					<div class="result-box mt-3">
						<p>
							<strong>Monthly EMI:</strong> ₹<span id="emi">0</span>
						</p>
						<p>
							<strong>Total Interest Payable:</strong> ₹<span id="interest">0</span>
						</p>
						<p>
							<strong>Total Amount Payable:</strong> ₹<span id="total">0</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="popup-select" id="loanPopup">
		<h5 class="mb-3">Choose Loan Type</h5>
		<ul class="list-group">
			<li class="list-group-item" onclick="selectLoanType('Home Loan')">
				🏡 Home Loan</li>
			<li class="list-group-item" onclick="selectLoanType('Property Loan')">
				🏢 Property Loan</li>
			<li class="list-group-item" onclick="selectLoanType('Personal Loan')">
				👤 Personal Loan</li>
			<li class="list-group-item" onclick="selectLoanType('Gold Loan')">
				💰 Gold Loan</li>
			<li class="list-group-item"
				onclick="selectLoanType('Education Loan')">🎓 Education Loan</li>
		</ul>
		<button class="btn btn-danger mt-3" onclick="hideLoanOptions()">
			Close</button>
	</div>
	<!-- Chatbot Panel -->
<div id="chatbot-panel"
     style="position: fixed; bottom: 90px; right: 20px; width: 350px; height: 480px; background: #fff; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.2); display: none; flex-direction: column; z-index: 1000; overflow: hidden;">
  <iframe src="/ask-question" style="width:100%; height:100%; border:none;"></iframe>
</div>
 
<!-- Floating Chatbot Button -->
<div id="chatbot-button"
     style="position: fixed; bottom: 20px; right: 20px; background-color: #ff6600; color: white; font-size: 24px; border-radius: 50%; padding: 15px 18px; cursor: pointer; z-index: 1001; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);">
  💬
</div>


	<section id="faqpage">
		<div class="container mt-5">
			<h2 class="text-center mb-4">Frequently Asked Questions</h2>
			<div class="accordion" id="faqAccordion">
				<input type="text" id="faqSearch" class="form-control mb-4"
					placeholder="Search FAQs..." />
			</div>
		</div>
	</section>


	<script>
  const button = document.getElementById("chatbot-button");
  const panel = document.getElementById("chatbot-panel");

  button.addEventListener("click", () => {
    panel.style.display = panel.style.display === "none" ? "flex" : "none";
  });
</script>

	<!-- Bootstrap 5 JS Bundle (includes Popper.js) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/HomePage.js"></script>
	<script src="/JS/FAQ.js"></script>
</body>
</html>
