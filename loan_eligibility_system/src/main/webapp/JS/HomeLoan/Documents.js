$(document).ready(function () {
    $("form").on("submit", function () {
        $("button[type='submit']").prop("disabled", true).text("Uploading...");
    });
});