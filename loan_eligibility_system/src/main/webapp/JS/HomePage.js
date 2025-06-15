const amountEl = document.getElementById("amount");
const rateEl = document.getElementById("rate");
const durationEl = document.getElementById("duration");
const durationVal = document.getElementById("durationValue");
const emiEl = document.getElementById("emi");
const interestEl = document.getElementById("interest");
const totalEl = document.getElementById("total");

function calculateEMI() {
  const P = parseFloat(amountEl.value);
  const annualRate = parseFloat(rateEl.value);
  const N = parseInt(durationEl.value);
  const R = annualRate / 12 / 100;
  const EMI = (P * R * Math.pow(1 + R, N)) / (Math.pow(1 + R, N) - 1);
  const totalPayment = EMI * N;
  const totalInterest = totalPayment - P;
  emiEl.textContent = EMI.toFixed(0);
  interestEl.textContent = totalInterest.toFixed(0);
  totalEl.textContent = totalPayment.toFixed(0);
}

function setAmount(value) {
  amountEl.value = value;
  calculateEMI();
}

amountEl.addEventListener("input", calculateEMI);
rateEl.addEventListener("input", calculateEMI);
durationEl.addEventListener("input", () => {
  durationVal.textContent = durationEl.value;
  calculateEMI();
});

window.onload = calculateEMI;

function toggleTheme() {
  console.log("Toggle called");
  document.body.classList.toggle("dark-theme");
}

function showLoanOptions() {
  document.getElementById("loanPopup").classList.add("show");
}

function hideLoanOptions() {
  document.getElementById("loanPopup").classList.remove("show");
}

function selectLoanType(type) {
  alert("You selected: " + type);
  hideLoanOptions();
}

function askUserType() {
  const isAdmin = confirm("Neenga admin ah? OK press pannunga admin ku, Cancel pannina user ku pogum.");
  
  if (isAdmin) {
    const username = prompt("Please enter admin username:");
    const password = prompt("Please enter admin password:");

    // Hardcoded check – you can replace with backend validation later
    if (username === "admin" && password === "admin123") {
      window.location.href = '/admin';  // ✅ correct credentials
    } else {
      alert("Wrong username or password. You will be redirected to user page.");
      window.location.href = '/';  // ❌ wrong credentials
    }
  } else {
    window.location.href = '/';  // user route
  }
}
