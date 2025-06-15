<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loan Management Reports</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <style>
        body {
            background: #f8f9fa;
            padding: 2rem;
            min-height: 100vh;
            color: #212529;
            transition: background 0.5s ease, color 0.5s ease;
        }
        body.dark-mode {
            background: #121212;
            color: #e0e0e0;
        }
        .btn-report {
            margin-right: 10px;
            margin-bottom: 20px;
        }
        #chartsContainer {
            max-width: 1200px;
            margin: auto;
            display: flex;
            gap: 30px;
            justify-content: center;
            flex-wrap: wrap;
        }
        .chart-box {
            background: white;
            padding: 25px 20px 20px 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgb(0 0 0 / 0.1);
            flex: 1 1 320px;
            min-width: 320px;
            height: 400px;
            display: flex;
            flex-direction: column;
            transition: background 0.5s ease, color 0.5s ease;
        }
        body.dark-mode .chart-box {
            background: #1e1e1e;
            color: #e0e0e0;
            box-shadow: 0 0 12px rgba(255, 255, 255, 0.15);
        }
        .chart-box h5 {
            text-align: center;
            margin-bottom: 20px;
            font-weight: 600;
            font-size: 1.2rem;
        }
        canvas {
            flex-grow: 1;
            width: 100% !important;
            height: 300px !important;
        }
        #exportButtons {
            text-align: center;
            margin-bottom: 20px;
        }
        #toggleDarkMode {
            position: fixed;
            top: 15px;
            left: 15px;
            z-index: 1050;
        }
    </style>
</head>
<body>

<button class="btn btn-secondary" id="toggleDarkMode">Toggle Dark Mode</button>

<h2 class="text-center mb-4">Loan Management Reports</h2>

<a href="/admin/dashboard" class="btn btn-outline-primary mt-3">
      ← Back to Dashboard
    </a>

<div class="text-center mb-3">
    <button class="btn btn-primary btn-report" id="btnAnnual">Annual</button>
    <button class="btn btn-primary btn-report" id="btnMonthly">Monthly</button>
    <button class="btn btn-primary btn-report" id="btnDaily">Daily</button>
</div>

<div id="exportButtons" class="mb-4 text-center">
    <button class="btn btn-success mr-3" id="exportCSV">Export CSV</button>
    <button class="btn btn-danger" id="exportPDF">Export PDF</button>
</div>

<div id="chartsContainer">
    <div class="chart-box">
        <h5>Total Amount Received (₹)</h5>
        <canvas id="chartReceived"></canvas>
    </div>
    <div class="chart-box">
        <h5>Total Amount Distributed (₹)</h5>
        <canvas id="chartDistributed"></canvas>
    </div>
    <div class="chart-box">
        <h5>Total Pending Amount (₹)</h5>
        <canvas id="chartPending"></canvas>
    </div>
    <div class="chart-box">
        <h5>Loan Distribution (Pie Chart)</h5>
        <canvas id="chartPie"></canvas>
    </div>
</div>

<script>
    const ctxReceived = document.getElementById('chartReceived').getContext('2d');
    const ctxDistributed = document.getElementById('chartDistributed').getContext('2d');
    const ctxPending = document.getElementById('chartPending').getContext('2d');
    const ctxPie = document.getElementById('chartPie').getContext('2d');

    const dataSets = {
        annual: {
            labels: ['2019', '2020', '2021', '2022', '2023', '2024'],
            received: [1200000, 1500000, 1700000, 1400000, 1900000, 2100000],
            distributed: [1000000, 1300000, 1600000, 1200000, 1800000, 2000000],
            pending: [200000, 200000, 100000, 200000, 100000, 100000]
        },
        monthly: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            received: [100000, 120000, 130000, 110000, 150000, 170000, 160000, 140000, 130000, 160000, 180000, 200000],
            distributed: [90000, 110000, 120000, 100000, 140000, 160000, 150000, 130000, 120000, 150000, 170000, 190000],
            pending: [10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
        },
        daily: {
            labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            received: [20000, 25000, 22000, 26000, 28000, 15000, 17000],
            distributed: [18000, 23000, 20000, 24000, 26000, 13000, 15000],
            pending: [2000, 2000, 2000, 2000, 2000, 2000, 2000]
        }
    };

    const pieData = {
        labels: ['Education', 'Home', 'Personal', 'Business'],
        datasets: [{
            label: 'Loan Distribution',
            data: [25, 35, 20, 20],
            backgroundColor: ['#007bff', '#28a745', '#ffc107', '#dc3545']
        }]
    };

    let chartReceived, chartDistributed, chartPending, chartPie;

    function createBarChart(ctx, labels, data, label, color1, color2) {
        const gradient = ctx.createLinearGradient(0, 0, 0, 400);
        gradient.addColorStop(0, color1);
        gradient.addColorStop(1, color2);

        return new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: label,
                    data: data,
                    backgroundColor: gradient,
                    borderColor: color2,
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }

    function updateCharts(period) {
        const dataset = dataSets[period];

        if (chartReceived) chartReceived.destroy();
        if (chartDistributed) chartDistributed.destroy();
        if (chartPending) chartPending.destroy();

        chartReceived = createBarChart(ctxReceived, dataset.labels, dataset.received, 'Received', '#4e73df', '#224abe');
        chartDistributed = createBarChart(ctxDistributed, dataset.labels, dataset.distributed, 'Distributed', '#1cc88a', '#158b6c');
        chartPending = createBarChart(ctxPending, dataset.labels, dataset.pending, 'Pending', '#f6c23e', '#dda20a');
    }

    function renderPieChart() {
        if (chartPie) chartPie.destroy();

        chartPie = new Chart(ctxPie, {
            type: 'pie',
            data: pieData,
            options: {
                responsive: true,
                maintainAspectRatio: false
            }
        });
    }

    document.getElementById('btnAnnual').onclick = () => updateCharts('annual');
    document.getElementById('btnMonthly').onclick = () => updateCharts('monthly');
    document.getElementById('btnDaily').onclick = () => updateCharts('daily');

    document.getElementById('toggleDarkMode').onclick = () => {
        document.body.classList.toggle('dark-mode');
    };

    document.getElementById('exportPDF').onclick = () => {
        html2canvas(document.getElementById('chartsContainer')).then(canvas => {
            const { jsPDF } = window.jspdf;
            const pdf = new jsPDF();
            const imgData = canvas.toDataURL('image/png');
            pdf.addImage(imgData, 'PNG', 10, 10, 190, 0);
            pdf.save('Loan_Report.pdf');
        });
    };

    document.getElementById('exportCSV').onclick = () => {
        let csvContent = "data:text/csv;charset=utf-8,Period,Received,Distributed,Pending\n";
        const dataset = dataSets[currentPeriod];
        for (let i = 0; i < dataset.labels.length; i++) {
            csvContent += `${dataset.labels[i]},${dataset.received[i]},${dataset.distributed[i]},${dataset.pending[i]}\n`;
        }
        const encodedUri = encodeURI(csvContent);
        const link = document.createElement("a");
        link.setAttribute("href", encodedUri);
        link.setAttribute("download", "Loan_Report.csv");
        document.body.appendChild(link);
        link.click();
    };

    // Initial load
    let currentPeriod = 'annual';
    updateCharts(currentPeriod);
    renderPieChart();
</script>
</body>
</html>
