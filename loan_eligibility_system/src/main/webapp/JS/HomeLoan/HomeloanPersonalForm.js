document.addEventListener("DOMContentLoaded", function () {
  // PAN Format Validation (e.g., ABCDE1234F)
  const panInput = document.querySelector('input[name="pan"]');
  panInput.addEventListener("input", () => {
    panInput.value = panInput.value.toUpperCase();
  });

  panInput.addEventListener("blur", () => {
    const panRegex = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/;
    if (!panRegex.test(panInput.value)) {
      alert("Invalid PAN format. Please use format: ABCDE1234F");
      panInput.focus();
    }
  });

  // Aadhar Format Validation (12 digits)
  const aadharInput = document.querySelector('input[name="aadhar"]');
  aadharInput.addEventListener("blur", () => {
    const aadharRegex = /^\d{12}$/;
    if (!aadharRegex.test(aadharInput.value)) {
      alert("Aadhar must be a 12-digit number.");
      aadharInput.focus();
    }
  });

  // Mobile Number Validation (10 digits)
  const mobileInput = document.querySelector('input[name="mobile"]');
  mobileInput.addEventListener("blur", () => {
    const mobileRegex = /^[6-9]\d{9}$/;
    if (!mobileRegex.test(mobileInput.value)) {
      alert("Enter a valid 10-digit Indian mobile number.");
      mobileInput.focus();
    }
  });

  // DOB: Ensure user is above 18 years
  const dobInput = document.querySelector('input[name="dob"]');
  dobInput.addEventListener("blur", () => {
    const enteredDate = new Date(dobInput.value);
    const today = new Date();
    const age = today.getFullYear() - enteredDate.getFullYear();
    if (age < 18) {
      alert("You must be at least 18 years old to apply.");
      dobInput.focus();
    }
  });
});
