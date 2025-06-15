<%@ page contentType="text/html;charset=UTF-8" language="java"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Loan Admin Dashboard</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <style>
      body {
        font-family: "Segoe UI", sans-serif;
        transition: background 0.3s, color 0.3s;
      }

      .sidebar {
        height: 100vh;
        background: linear-gradient(to bottom right, #1e3c72, #2a5298);
        padding-top: 20px;
        position: fixed;
        width: 250px;
        color: white;
      }

      .sidebar a {
        color: white;
        text-decoration: none;
        display: block;
        padding: 12px 20px;
        font-weight: 500;
      }

      .sidebar a:hover {
        background-color: rgba(255, 255, 255, 0.1);
      }

      .content {
        margin-left: 260px;
        padding: 30px;
      }

      .card {
        border-radius: 1rem;
      }

      .chart-container {
        position: relative;
        height: 400px;
      }

      body.dark-mode {
        background-color: #121212;
        color: #ffffff;
      }

      .dark-mode .sidebar {
        background: linear-gradient(to bottom right, #0d1117, #161b22);
      }

      .dark-mode .card {
        background-color: #1e1e2f;
        color: white;
      }

      .dark-mode .modal-content {
        background-color: #1e1e2f;
        color: white;
      }

      .toggle-btn {
        position: absolute;
        right: 30px;
        top: 30px;
      }
      h5 > a {
        text-decoration: none;
        color: white;
      }
    </style>
  </head>
  <body>
    <!-- Sidebar -->
    <div class="sidebar">
      <h4 class="text-center mb-4">Admin Dashboard</h4>
      <a href="/admin/dashboard"><i class="bi bi-house"></i> Dashboard</a>
      <a href="/admin/reports"><i class="bi bi-graph-up"></i> Reports</a>
      <a href="#"><i class="bi bi-cash-stack"></i> EMIs</a>
      <a href="#" data-bs-toggle="modal" data-bs-target="#emiModal"
        ><i class="bi bi-calculator"></i> EMI Calculator</a
      >
      <a href="/admin/getQueries" class="nav-link">
    <i class="bi bi-chat-left-text me-2"></i> User Queries
</a>
    </div>

    <!-- Dark Mode Toggle -->
    <button class="btn btn-outline-secondary toggle-btn" onclick="toggleMode()">
      <i id="modeIcon" class="bi bi-moon-fill"></i>
    </button>

    <!-- Main Content -->
    <div class="content">
      <h2 class="mb-4">Welcome, Admin</h2>

      <!-- Dashboard Cards -->
      <div class="row mb-4">
        <div class="col-md-3">
          <div class="card text-white bg-primary">
            <div class="card-body">
              <h5><a href="#">Total Users</a></h5>
              <p class="fs-4">${totalUsers}</p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card text-white bg-success">
            <div class="card-body">
              <h5><a href="/admin/loan-list/approved">Approved Loans</a></h5>
              <p class="fs-4">${approvedLoans}</p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card text-white bg-warning">
            <div class="card-body">
              <h5><a href="/admin/loan-list/pending">Pending Loans</a></h5>
              <p class="fs-4">${pendingLoans}</p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card text-white bg-danger">
            <div class="card-body">
              <h5><a href="/admin/loan-list/rejected">Rejected Loans</a></h5>
              <p class="fs-4">${rejectedLoans}</p>
            </div>
          </div>
        </div>
      </div>

      <!-- Loan ID Fetch -->
      <div class="card mb-4">
        <div class="card-body">
          <h5 class="card-title">Fetch User by Loan ID</h5>
          <div class="input-group mb-3">
            <div class="input-group mb-3">
              <input
                type="text"
                id="loanIdInput"
                class="form-control"
                placeholder="Enter Loan ID"
                required
              />
              <button class="btn btn-outline-primary" onclick="fetchLoanData()">
                Fetch
              </button>
            </div>
          </div>
          <div id="userDetails"></div>
        </div>
      </div>

      <!-- Charts -->
      <div class="row g-4 mb-5">
        <div class="col-md-6">
          <div class="card shadow-sm">
            <div class="card-header">
              <strong
                ><i class="bi bi-pie-chart-fill"></i> Loan Status
                Distribution</strong
              >
            </div>
            <div class="card-body">
              <canvas id="loanStatusChart" height="250"></canvas>
            </div>
          </div>
        </div>

        <div class="col-md-6">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Monthly Repayments</h5>
              <div class="chart-container">
                <canvas id="emiChart"></canvas>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- FAQ Section -->
      <div class="card mb-4">
        <div class="card-body">
          <h5 class="card-title">FAQs</h5>

          <!-- Add FAQ Inputs -->
          <div class="mt-4">
            <h6>Add New FAQ</h6>
            <div class="mb-3">
              <input
                type="text"
                id="faqQuestion"
                class="form-control"
                placeholder="Enter Question"
              />
            </div>
            <div class="mb-3">
              <input
                type="text"
                id="faqAnswer"
                class="form-control"
                placeholder="Enter Answer"
              />
            </div>
            <button class="btn btn-primary" onclick="addFaq()">Add FAQ</button>
          </div>
        </div>
      </div>
    </div>

    <!-- EMI Calculator Modal -->
    <div class="modal fade" id="emiModal" tabindex="-1">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content p-3">
          <div class="modal-header">
            <h5 class="modal-title">EMI Calculator</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
            ></button>
          </div>
          <div class="modal-body">
            <form id="emiForm">
              <div class="mb-3">
                <label>Loan Amount</label
                ><input
                  type="number"
                  class="form-control"
                  id="loanAmount"
                  required
                />
              </div>
              <div class="mb-3">
                <label>Interest Rate (%)</label
                ><input
                  type="number"
                  class="form-control"
                  id="interestRate"
                  required
                />
              </div>
              <div class="mb-3">
                <label>Loan Tenure (months)</label
                ><input
                  type="number"
                  class="form-control"
                  id="loanTenure"
                  required
                />
              </div>
              <div class="mb-3">
                <label>EMI</label
                ><input
                  type="text"
                  class="form-control"
                  id="emiResult"
                  readonly
                />
              </div>
              <button
                type="button"
                class="btn btn-primary w-100"
                onclick="calculateEMI()"
              >
                Calculate
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
      // Dark Mode Toggle
      function toggleMode() {
        document.body.classList.toggle("dark-mode");
        const icon = document.getElementById("modeIcon");
        icon.classList.toggle("bi-moon-fill");
        icon.classList.toggle("bi-sun-fill");
      }

      // Loan Status Pie Chart
      const approvedCount = parseInt("${approvedLoans}");
      const pendingCount = parseInt("${pendingLoans}");
      const rejectedCount = parseInt("${rejectedLoans}");
      const loanStatusCtx = document
        .getElementById("loanStatusChart")
        .getContext("2d");
      const loanStatusChart = new Chart(loanStatusCtx, {
        type: "pie",
        data: {
          labels: ["Approved", "Pending", "Rejected"],
          datasets: [
            {
              label: "Loan Status",
              data: [approvedCount, pendingCount, rejectedCount],
              backgroundColor: ["#198754", "#ffc107", "#dc3545"],
              hoverOffset: 10,
            },
          ],
        },
        options: {
          responsive: true,
          plugins: { legend: { position: "bottom" } },
        },
      });

      // Dummy EMI Bar Chart
      const emiChart = new Chart(
        document.getElementById("emiChart").getContext("2d"),
        {
          type: "bar",
          data: {
            labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"],
            datasets: [
              {
                label: "Monthly EMI (₹)",
                data: [100, 200, 300, 150, 100, 5500],
                backgroundColor: "#0d6efd",
              },
            ],
          },
          options: {
            responsive: true,
            plugins: { legend: { display: false } },
            scales: { y: { beginAtZero: true } },
          },
        }
      );

      // EMI Calculation
      function calculateEMI() {
        const P = parseFloat(document.getElementById("loanAmount").value);
        const R =
          parseFloat(document.getElementById("interestRate").value) / 100 / 12;
        const N = parseFloat(document.getElementById("loanTenure").value);
        if (P && R && N) {
          const emi = (P * R * Math.pow(1 + R, N)) / (Math.pow(1 + R, N) - 1);
          const monthlyEmi = emi.toFixed(2);
          document.getElementById("emiResult").value = "₹" + monthlyEmi;
        } else {
          alert("Please fill in all fields.");
        }
      }

      // Loan ID Fetch
      function fetchUserDetails() {
        /* const loanId = document.getElementById("loanIdInput").value.trim();
              	const userDetailsDiv = document.getElementById("userDetails");
              	const dummyData = {
              		"L001": { name: "Aslam", amount: "₹1,00,000", status: "Approved" },
              		"L002": { name: "Sheriff", amount: "₹50,000", status: "Pending" }
              	};
              	const data = dummyData[loanId];
              	if (!loanId) {
              		userDetailsDiv.innerHTML = `<p class="text-danger">Please enter a Loan ID.</p>`;
              	} else if (data) {
              		userDetailsDiv.innerHTML = `
              			<div class="border rounded p-3 bg-light">
              				<p><strong>Name:</strong> ${data.name}</p>
              				<p><strong>Amount:</strong> ${data.amount}</p>
              				<p><strong>Status:</strong> ${data.status}</p>
              			</div>`;
              	} else {
              		userDetailsDiv.innerHTML = `<p class="text-danger">No data found for Loan ID ${loanId}.</p>`;
              	} */
        //window.location.href = '/admin/fetchLoanId';
      }
      /* function fetchUser() {
                     const loanId = document.getElementById('loanIdInput').value.trim();
                     if (loanId) {
                         window.location.href = `/admin/getLoanData/${loanId}`;
                     }
                 } */

      function fetchLoanData() {
        const loanIdValue = document.getElementById("loanIdInput").value.trim();
        if (loanIdValue) {
          window.location.href =
            "/admin/fetchLoanData?loanId=" + encodeURIComponent(loanIdValue);
        } else {
          alert("Please enter a valid Loan ID.");
        }
      }

      // Add FAQ
      function addFaq() {
        const question = document.getElementById("faqQuestion").value.trim();
        const answer = document.getElementById("faqAnswer").value.trim();

        if (!question || !answer) {
          alert("Please fill both Question and Answer.");
          return;
        }

        const faqList = document.getElementById("faqList");

        // Create new FAQ elements safely without innerHTML
        const qPara = document.createElement("p");
        const strong = document.createElement("strong");
        strong.textContent = `Q: ${question}`;
        qPara.appendChild(strong);

        const aPara = document.createElement("p");
        aPara.textContent = answer;

        faqList.appendChild(qPara);
        faqList.appendChild(aPara);

        // Clear inputs
        document.getElementById("faqQuestion").value = "";
        document.getElementById("faqAnswer").value = "";
      }
    </script>
  </body>
</html>
