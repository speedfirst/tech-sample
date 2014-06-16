<%--
  Created by IntelliJ IDEA.
  User: jiankuan
  Date: 6/16/14
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC Sample</title>
</head>
<body>
    <h1>Spring MVC Sample</h1>
    <dl>
        <dt>/greeting</dt>
        <dd>get the default greeting view (JSP)</dd>
        <dt>/greeting?name="&lt;your name&gt;"</dt>
        <dd>get the greeting view with your name (JSP)</dd>
        <dt>/rest</dt>
        <dd>get the json result of Hello object</dd>
        <dt>/rest?name="&lt;your name&gt;"</dt>
        <dd>get the json result of Hello object containing your name</dd>
    </dl>
    <p><small>Note. You can use "Accept:application/xml" or "Accept:application/json" to control which kind of rest result you get.</small></p>
</body>
</html>
