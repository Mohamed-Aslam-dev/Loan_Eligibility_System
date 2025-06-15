document.addEventListener("DOMContentLoaded", function () {
  const incomeInput = document.getElementById("annualIncome");
  const experienceInput = document.getElementById("workExperience");

  incomeInput.addEventListener("blur", () => {
    if (parseFloat(incomeInput.value) < 0) {
      alert("Monthly income must be a positive value.");
      // incomeInput.focus();
    }
  });

  experienceInput.addEventListener("blur", () => {
    if (parseInt(experienceInput.value) < 0) {
      alert("Work experience must be a non-negative number.");
      // experienceInput.focus();
    }
  });
});