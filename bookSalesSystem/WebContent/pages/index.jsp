
<html>
<title>HelloWorld!</title>
<body id="body">
	<script src="assets/js/jquery-1.10.2.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/jquery.metisMenu.js"></script>
	<script>
				$.ajax({
					type : "GET",
					url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getCategory",
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