<%@ taglib prefix="c" uri="http://127.0.0.1:8080/c %>
<html>
<title>HelloWorld!</title>
<body id="body">
	<c:forEach items="${data}" var="book">
    	alert("\"${book.bid}\"" + "\"${book.bookName}\"");
</c:forEach>
	<script src="assets/js/jquery-1.10.2.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/jquery.metisMenu.js"></script>
	<script>
				$.ajax({
					type : "GET",
					url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getAllBooks",
					success : function(data) {
						console.log("success" + data);
						alert("data" + data);
						document.write(data);
					},
					error : function(e) {
						console.log("failed" + JSON.stringify(e));
					}
				})
	</script>
</body>
</html>