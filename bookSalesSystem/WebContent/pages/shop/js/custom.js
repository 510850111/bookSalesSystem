function getCatelogry() {
	var catelogry = document.getElementById("isol").getElementsByTagName("ul")[0];
	var catelogryHTMLCode = "";
	$.ajax({
				type : "GET",
				url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getCategory",
				success : function(data) {
					data = eval(data);
					for (var i = 0; i < data.length; i++) {
						catelogryHTMLCode += "<li><a href='#'>" + data[i].categoryName+ "</a></li>";
					}
					catelogry.innerHTML = catelogryHTMLCode;

				},
				error : function(e) {
					console.log("failed" + JSON.stringify(e));
				}
			});

}

function getAllBooks() {
	var bookList = document.getElementById("urunliste");
	var bookListHTMLCode = "";
	$.ajax({
				type : "GET",
				url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getAllBooks",
				success : function(data) {
					data = eval(data);
					for(var i = 0 ; i< data.length ; i++){
						bookListHTMLCode += "<div class='urunliste'><div class='urun'>";
						bookListHTMLCode += "<a href='#' class = 'uResim'><img src='pages/shop/img/uresim.png' alt=''/></a>";
						bookListHTMLCode += "<a href='#' class='uBaslik'>" + data[i].bookName + "</a>";
						bookListHTMLCode += "<a href='Details.html' class='uAbaslik'>" + data[i].categoryName + "</a>";
						bookListHTMLCode += "<p>" + data[i]._abstract + "</p>";
						bookListHTMLCode += "<span>" +data[i].price+ "￥</span>";
						bookListHTMLCode += "<a href='#' class='incele'></a><a href='#' class='sepeteat'></a>";
						bookListHTMLCode += "</div></div></div>"
					}
					bookList.innerHTML = bookListHTMLCode;
				},
				error : function(e) {
					console.log("[getAllBooks]failed" + JSON.stringify(e));
				}
			});
}
