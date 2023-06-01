$(document).ready(function () {
    // Add a listener for the form submission
    $('#chat-form').on('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        var message = $('#message').val(); // Get the message content from the textarea

        // Send the message to the server using AJAX
        $.ajax({
            type: 'POST',
            url: '/chat/send',
            data: { content: message },
            success: function (response) {
                // Handle the success response if needed
                console.log('Message sent successfully');
            },
            error: function (error) {
                // Handle the error response if needed
                console.error('Error sending message');
            }
        });

        // Clear the textarea after sending the message
        $('#message').val('');
    });
});