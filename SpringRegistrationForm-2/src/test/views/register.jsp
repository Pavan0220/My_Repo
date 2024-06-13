<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1>
    <form action="registration" method="post">
     <label>Name:</label>
      <input type="text" name="name"  required /> <br><br> 
       <label>Email:</label>
       <input type="email" name="email"  required /> <br><br>  
       <label>Password:</label>
        <input type="password" name="password"  required /> <br><br> 
        <label>Date of Birth:</label>
         <input type="date" name="dob"  required /> <br><br> 
        <label>Gender:</label>
          <input type="radio" id="male" name="gender" value="Male" required>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female" required>
        <label for="female">Female</label><br><br> 
            
            <label>Location:</label>
            <select name="location">
                <option value="Banglore">Banglore</option>
                <option value="Tumkur">Tumkur</option>
                <option value="Hassan">Hassan</option>
                <option value="Mysore">Mysore</option>
                <option value="Koppa">Koppa</option>
            </select> <br><br> 
            <input type="submit" value="submit">
</form>
</body>
</html>