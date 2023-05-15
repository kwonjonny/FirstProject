<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
        }

        .btn {
            margin-top: 10px;
        }

        form {
            display: inline-block;
        }

        .warning-message {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Main</h2>

    <div id="warningMessage" class="alert alert-warning" style="display:none;"></div>

    <div>
        <form action="/list" method="get">
            <button type="submit" class="btn btn-primary">List User</button>
        </form>
        <a href="/create" class="btn btn-primary">Create User</a>
        <a href="/update" class="btn btn-primary">Update User</a>

        <form action="/delete" method="post">
            <button type="submit" class="btn btn-primary">delete User</button>
        </form>

        <a href="/login" class="btn btn-primary">login</a>

        <form action="/logout" method="post">
            <button type="submit" class="btn btn-primary">logout</button>
        </form>
    </div>
</div>

<script>
    // Check if the warning message exists in the DOM
    const warningMessage = document.getElementById('warningMessage');
    if (warningMessage) {
        const warningText = '${warning}'; // Replace with the actual warning message value from the server
        if (warningText) {
            warningMessage.innerText = warningText;
            warningMessage.style.display = 'block';
        }
    }
</script>

</body>
</html>
