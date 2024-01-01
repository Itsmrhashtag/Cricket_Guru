function submitForm(event) {
    event.preventDefault();
    console.log("0-0-0-0--0----------------");
        // Get values from input fields
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        // Your logic for handling the form submission
        // For instance, you can use these values to perform an AJAX request
        // Here's a basic example using fetch to perform a POST request
        fetch('http://localhost:8080/oauth/token?grant_type=password&username=' + username + '&password=' + password + '&scope=write', {
            method: 'POST',
            headers: {
                'Authorization': 'Basic aGFzaHRhZzoxMjM0'
                // Add other necessary headers here if required
            }
            // You might need to handle the response accordingly
        }).then(response => {
            if (response.ok) {
                    // Status code is within the 200-299 range
                    console.log('Login successful');
                    showMessage("Login successful");
                    // You can perform actions for successful login here
                } else if (response.status === 400) {
                    console.error('Bad request');
                    // Handle bad request (e.g., incorrect username/password)
                } else {
                    console.error('Error:', response.status);
                    // Handle other status codes if needed
                }
        }).catch(error => {
            // Handle error
            console.error('Error:', error);
            showMessage("Error: " + error.message);
        });
    }

    function showMessage(message) {
        // Replace this with your logic to display the message to the user
        alert(message);
    }