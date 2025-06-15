function submitHomeLoan() {
  const agree = document.getElementById("agree").checked;

  if (agree) {
    // alert("✅ Thank you for agreeing. Your request is being processed.");
    redirectFormPage();
  } else {
    alert("⚠️ Please select an option.");
  }
}

function closeHomeLoan() {
  window.location.href = "/jsp/HomePage.jsp"; 
}
function redirectFormPage(){
   window.location.href = "/homeloan/personal"
}
