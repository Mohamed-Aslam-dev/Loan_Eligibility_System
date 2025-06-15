<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Loan Chatbot</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5;
            padding-top: 50px;
        }
        #chatContainer {
            background-color: #ffffff;
            border-radius: 15px;
            padding: 30px;
            max-width: 700px;
            height: 600px;
            margin: auto;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            display: flex;
            flex-direction: column;
        }
        #messages {
            flex-grow: 1;
            overflow-y: auto;
            margin-bottom: 20px;
            border: 1px solid #dee2e6;
            padding: 15px;
            border-radius: 10px;
            background-color: #f8f9fa;
        }
        .message {
            margin: 10px 0;
            padding: 10px;
            border-radius: 8px;
            max-width: 80%;
        }
        .user-message {
            background-color: #e2f0ff;
            align-self: flex-end;
            text-align: right;
        }
        .bot-message {
            background-color: #d4edda;
            align-self: flex-start;
            text-align: left;
        }
    </style>
</head>
<body>

<div id="chatContainer">
    <h3 class="text-center mb-4">💬 Loan Chatbot - Ask your Questions</h3>

    <div id="messages" class="d-flex flex-column"></div>

    <div class="input-group">
        <input type="text" id="userInput" class="form-control" placeholder="Ask your Questions..."
               onkeydown="if(event.key === 'Enter') sendMessage();" />
        <button class="btn btn-primary" onclick="sendMessage()">Send</button>
    </div>
</div>

<script>
    async function sendMessage() {
        const input = document.getElementById("userInput");
        const msg = input.value.trim();
        if (!msg) return;

        const messagesDiv = document.getElementById("messages");

        // Display user's message
        const userMsg = document.createElement("div");
        userMsg.className = "message user-message align-self-end";
        userMsg.textContent = msg;
        messagesDiv.appendChild(userMsg);

        input.value = "";

        try {
            const res = await fetch("/api/chat", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ prompt: msg })
            });

            const reply = await res.text();

            const botMsg = document.createElement("div");
            botMsg.className = "message bot-message align-self-start";
            botMsg.textContent = reply;
            messagesDiv.appendChild(botMsg);

            messagesDiv.scrollTop = messagesDiv.scrollHeight;

        } catch (error) {
            const errMsg = document.createElement("div");
            errMsg.className = "message bot-message text-danger";
            errMsg.textContent = "⚠️ Server error. Please try again.";
            messagesDiv.appendChild(errMsg);
        }
    }
</script>

</body>
</html>


