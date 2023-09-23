<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

<title>Add new user</title>

</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form method="POST" action='UserController1' name="frmAddUser">
       User Id : <input type="text" name="userid" /> <br><br>
       First name : <input type="text" name="fname" /> <br><br>
       Last name : <input type="text" name="lname" /> <br><br>
       Email : <input type="text" name="email" /><br><br>
         <input   type="submit" value="Submit" />
    </form>
</body>
</html>