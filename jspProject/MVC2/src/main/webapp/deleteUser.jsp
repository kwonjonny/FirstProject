<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Delete User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Delete User</h2>
        <form action="deleteUser" method="post">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" name="id" required>
            </div>
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    </div>
</body>
</html>
