<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All User Queries</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #e3f2fd, #ffffff);
        }
        .query-card {
            border-radius: 1rem;
            background-color: #f9f9f9;
            box-shadow: 0 0 15px rgba(0,0,0,0.08);
            transition: transform 0.3s ease;
        }
        .query-card:hover {
            transform: scale(1.01);
        }
        .query-icon {
            font-size: 1.6rem;
            color: #0d6efd;
        }
        .card-header {
            background: #0d6efd;
            color: white;
            border-top-left-radius: 1rem;
            border-top-right-radius: 1rem;
        }
        .badge-pending {
            background-color: #ffc107;
        }
        .badge-responded {
            background-color: #28a745;
        }
        .filter-input {
            max-width: 400px;
            margin: 0 auto 2rem auto;
        }
    </style>
    <script>
        function filterQueries() {
            const input = document.getElementById("querySearch").value.toLowerCase();
            const cards = document.getElementsByClassName("query-card");

            for (let card of cards) {
                const content = card.innerText.toLowerCase();
                card.parentElement.style.display = content.includes(input) ? "block" : "none";
            }
        }

        function replyToQuery(userEmail) {
            alert("Replying to: " + userEmail);
            // You can open a modal or redirect to a reply form here
        }
    </script>
</head>
<body>
<div class="container py-5">
    <h2 class="text-center mb-4 text-primary"><i class="bi bi-chat-left-text-fill me-2"></i>All User Queries</h2>

    <div class="filter-input text-center">
        <input type="text" class="form-control" id="querySearch" placeholder="Search by name, email or subject..." onkeyup="filterQueries()" />
    </div>

    <c:if test="${empty queryList}">
        <div class="alert alert-warning text-center">No queries found.</div>
    </c:if>

    <div class="row">
        <c:forEach var="query" items="${queryList}">
            <div class="col-md-6 mb-4">
                <div class="card query-card">
                    <div class="card-header d-flex justify-content-between align-items-center">
                        <div>
                            <i class="bi bi-person-circle query-icon me-2"></i>
                            <strong>${query.userName}</strong><br/>
                            <small>${query.email}</small>
                        </div>
                        <span class="badge 
                            <c:choose>
                                <c:when test="${query.queryStatus.name() == 'RESPONDED'}">badge-responded</c:when>
                                <c:otherwise>badge-pending</c:otherwise>
                            </c:choose>">
                            ${query.queryStatus}
                        </span>
                    </div>
                    <div class="card-body">
                        <p><strong>📝 Subject:</strong> ${query.queryType}</p>
                        <p><strong>📩 Message:</strong> ${query.message}</p>
                        <p class="text-muted"><i class="bi bi-calendar-event"></i> ${query.queryRaisedDateAndTime}</p>
                        <button class="btn btn-outline-primary btn-sm" onclick="replyToQuery('${query.email}')">
                            <i class="bi bi-reply-fill"></i> Reply
                        </button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
