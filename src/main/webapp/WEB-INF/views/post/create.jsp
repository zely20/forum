<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
    <title>Edit Post</title>
</head>
<body>
   <div class="container mt-3">
       <form name='login' action="<c:url value='/save'/>" method='POST'>
           <h2>Topic title</h2>
       <td><input type="text" name="name"></td>
           <h3>Message</h3>
           <p><textarea rows="10" cols="45" name="description"></textarea></p>
       <td colspan='2'><input name="submit" type="submit" value="submit" class="btn btn-primary"/></td>
       </form>
   </div>
</body>
</html>
