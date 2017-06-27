<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path ;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>${msg}</title>
</head>
<body>
<script type="text/javascript">
  	window.alert("${msg}") ;

    window.location = "<%=basePath%>${url}" ;
</script>
</body>
</html>
