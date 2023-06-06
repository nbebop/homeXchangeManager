$(document).ready(function() {
    // Function to retrieve chat messages
    function retrieveChatMessages() {
        var receiverName = "user8"; // Replace with the appropriate receiver name

        $.get("/chat/message/" + receiverName, function(messages) {
            var chatMessagesElement = $("#chat-messages");
            chatMessagesElement.empty(); // Clear existing chat messages

            // Append each message to the chat messages element
            messages.forEach(function(message) {
                var messageElement = $("<div>").text(message.content);
                chatMessagesElement.append(messageElement);
            });
        });
    }

    // Call the retrieveChatMessages function initially to load existing chat messages
    retrieveChatMessages();

});