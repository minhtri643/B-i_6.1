<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="main.css" type="text/css" />
  </head>
  <body>
    <h2>Your information</h2>
  
    <form id="announcementForm" action="emailList" method="post">
      <input type="hidden" name="action" value="add">

      <label>First Name</label>
      <input type="text" name="firstName" required><br>

      <label>Last Name</label>
      <input type="text" name="lastName" required><br>

      <label>Email</label>
      <input type="email" name="email" required><br>

      <span id="errorMessage" style="color: red; display: none;">Please select at least one option for announcements before submitting.</span><br>
      <button type="submit">Submit</button>
    </form>

    <jsp:include page="footer.jsp" />
  </body>
</html>
