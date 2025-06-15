document.addEventListener("DOMContentLoaded", function () {
  const incomeInput = document.getElementById("estimatedConstructionCost");


  incomeInput.addEventListener("blur", () => {
    if (parseFloat(incomeInput.value) < 0) {
      alert("Monthly income must be a positive value.");
      // incomeInput.focus();
    }
  });
});