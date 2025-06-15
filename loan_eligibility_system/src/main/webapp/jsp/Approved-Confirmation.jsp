<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Loan Approved</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #b9fbc0, #a3f7bf);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .card {
            border-radius: 20px;
            padding: 40px;
            text-align: center;
            background-color: white;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            max-width: 500px;
        }
        .icon {
            font-size: 60px;
            color: green;
        }
    </style>
</head>
<body>
    <div class="card">
        <div class="icon">✅</div>
        <h2 class="mt-3">Loan Approved!</h2>
        <p>The applicant's loan has been successfully approved.</p>
        <a href="/admin/dashboard" class="btn btn-success mt-3">Back to Dashboard</a>
    </div>
</body>
</html>
