const faqData = [
  {
    question: "Home loan interest rate enna?",
    answer:
      "Home loan interest rate varies from bank to bank. Currently it is around 7% per annum.",
  },
  {
    question: "Loan apply panna minimum age enna?",
    answer: "Minimum age to apply for loan is 21 years.",
  },
  {
    question: "What is a gold loan?",
    answer:
      "A gold loan is a secured loan where you pledge your gold ornaments as collateral to get cash.",
  },
  {
    question: "What is the interest rate for gold loans?",
    answer:
      "Interest rates usually range from 7% to 15%, depending on the lender and loan amount.",
  },
  {
    question: "How much loan can I get against my gold?",
    answer: "Usually up to 75-90% of the gold’s market value.",
  },
  {
    question: "How long is the repayment period for a gold loan?",
    answer: "Repayment tenures typically range from 3 months to 3 years.",
  },
  {
    question: "What happens if I don't repay the gold loan?",
    answer:
      "The lender can auction your gold to recover the loan amount after a grace period",
  },
];

const faqContainer = document.getElementById("faqAccordion");

faqData.forEach((faq, index) => {
  const item = document.createElement("div");
  item.className = "accordion-item";

  item.innerHTML = `
    <h2 class="accordion-header" id="heading${index}">
      <button class="accordion-button ${index !== 0 ? 'collapsed' : ''}" type="button" 
        data-bs-toggle="collapse" data-bs-target="#collapse${index}" 
        aria-expanded="${index === 0 ? 'true' : 'false'}" 
        aria-controls="collapse${index}">
        <span class="me-2 icon" id="icon${index}">➕</span> ${faq.question}
      </button>
    </h2>
    <div id="collapse${index}" class="accordion-collapse collapse ${index === 0 ? 'show' : ''}" 
         aria-labelledby="heading${index}" data-bs-parent="#faqAccordion">
      <div class="accordion-body">${faq.answer}</div>
    </div>
  `;
  faqContainer.appendChild(item);
});

// Change icon on expand/collapse
faqData.forEach((_, index) => {
  const collapseEl = document.getElementById(`collapse${index}`);
  collapseEl.addEventListener("show.bs.collapse", () => {
    document.getElementById(`icon${index}`).textContent = "➖";
  });
  collapseEl.addEventListener("hide.bs.collapse", () => {
    document.getElementById(`icon${index}`).textContent = "➕";
  });
});

document.getElementById('faqSearch').addEventListener('input', function () {
  const searchText = this.value.toLowerCase();
  const items = document.querySelectorAll('.accordion-item');

  faqData.forEach((faq, index) => {
    const match = faq.question.toLowerCase().includes(searchText) || faq.answer.toLowerCase().includes(searchText);
    items[index].style.display = match ? 'block' : 'none';
  });
});