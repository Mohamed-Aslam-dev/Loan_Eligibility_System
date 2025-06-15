<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Documents</title>
    <link rel="stylesheet" href="/CSS/HomeLoan/Documents.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

     <div class="document-container">
        <div class="document-card">
            <h2 class="text-center mb-4">Upload Required Documents</h2>

            <form:form method="post" modelAttribute="loanApplyDocumentsDTO"
                       action="/homeloan/submit-documents"
                       enctype="multipart/form-data">

                <div class="form-group">
                    <label>Aadhar Front</label>
                    <input type="file" name="aadharFrontFile" accept=".jpg,.jpeg,.png,.pdf" required />
                </div>

                <div class="form-group">
                    <label>Aadhar Back</label>
                    <input type="file" name="aadharBackFile" accept=".jpg,.jpeg,.png,.pdf" required />
                </div>

                <div class="form-group">
                    <label>PAN Card</label>
                    <input type="file" name="panCardFile" accept=".jpg,.jpeg,.png,.pdf" required />
                </div>

                <div class="form-group">
                    <label>Property Proof</label>
                    <input type="file" name="propertyProofFile" accept=".jpg,.jpeg,.png,.pdf" required />
                </div>

                <div class="form-group">
                    <label>Passport Size Photo</label>
                    <input type="file" name="passportSizePhoto" accept=".jpg,.jpeg,.png,.pdf" required />
                </div>

                <div class="text-center">
                    <button type="submit" class="submit-btn">Submit & Get OTP</button>
                </div>
            </form:form>
        </div>
    </div>

    <script src="/JS/HomeLoan/Documents.js"></script>

</body>
</html>