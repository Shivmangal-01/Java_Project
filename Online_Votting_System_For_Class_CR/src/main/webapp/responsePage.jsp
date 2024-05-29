<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response Page</title>
      <script type="text/javascript" src="time1.js"></script>
</head>
<body>
    <h1><%= request.getAttribute("message") %></h1>
    
    <script type="text/javascript">
       displayMessage();
    </script>
	 
</body>
</html>