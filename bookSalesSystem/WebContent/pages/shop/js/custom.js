function getCatelogry() {
	$.ajax({
				type : "GET",
				url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getCategory",
				success : function(data) {
					console.log("success" + data);
					alert("data=" + data);
				},
				error : function(e) {
					console.log("failed" + JSON.stringify(e));
				}
			});
}

function getAllBooks() {
	$.ajax({

				type : "GET",
				url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getAllBooks",
				success : function(data) {
					console.log("[getAllBooks]data=" + JSON.stringify(data));
					alert("[getAllBooks]data=" + JSON.stringify(data));
				},
				error : function(e) {
					console.log("[getAllBooks]failed" + JSON.stringify(e));
				}
			});
}
