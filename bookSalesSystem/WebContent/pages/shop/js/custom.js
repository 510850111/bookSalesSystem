function getCatelogry() {
	var catelogry = document.getElementById("isol").getElementsByTagName("ul")[0];
	var catelogryHTMLCode = "";
	$.ajax({
				type : "GET",
				url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getCategory",
				success : function(data) {
					data = eval(data);
					for (var i = 0; i < data.length; i++) {
						catelogryHTMLCode += "<li><a href='#'>"
								+ data[i].categoryName + "</a></li>";
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
					// alert(JSON.stringify(data));
					for (var i = 0; i < data.length; i++) {
						bookListHTMLCode += "<div class='urunliste'><div class='urun'>";
						bookListHTMLCode += "<a href='#' class = 'uResim'><img src='pages/shop/img/uresim.png' alt=''/></a>";
						bookListHTMLCode += "<a href='#' class='uBaslik'>"
								+ data[i].bookName + "</a>";
						bookListHTMLCode += "<a href='Details.html' class='uAbaslik'>"
								+ data[i].categoryName + "</a>";
						bookListHTMLCode += "<p>" + data[i]._abstract + "</p>";
						bookListHTMLCode += "<span>" + data[i].price
								+ "￥</span>";
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

function getAD() {
	var AD = document.getElementById("manset").getElementsByTagName("ul")[0];
	var ADHTMLCode = "";
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getAD",
		success : function(data) {
			data = eval(data);
			for (var i = 0; i < data.length; i++) {
				ADHTMLCode += "<li><a href='#'><img src=" + data[i].img
						+ " alt = '' /> </a></li>";
			}
			AD.innnerHTML = ADHTMLCode;
		},
		error : function(e) {
			console.log("[getAD]failed" + JSON.stringify(e));
		}
	});

}

function getHotBooks(){
	var hotBooksUL = document.getElementById("hotBooks").getElementsByTagName("ul")[0];
	var hotBooksHTMLCode = "";
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/BookServlet/getHotBooks",
		success : function(data) {
			data = eval(data);
			if(data != null){
				for (var i = 0; i < data.length; i++) {
					hotBooksHTMLCode += "<li><a href='#'><img src=" + data[i].img +" alt = '' /> </a>";
					hotBooksHTMLCode += "<a href='#'>" + data[i].bookName + "</a>";
					hotBooksHTMLCode += "<p>" + data[i]._abstract +"</p>";
					hotBooksHTMLCode += "<span>" + data[i].price + "￥</span></li>";
				}
				hotBooks.innerHTML = hotBooksHTMLCode;
			}
		},
		error : function(e) {
			console.log("[getHotBooks]failed" + JSON.stringify(e));
		}
	});
}


function getShopCart(num){
	var shopCartFirstItemName = document.getElementById("sepet").getElementsByTagName("strong")[0];
	var shopCartHTMLCode = "";
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/shopCartServlet/getShopCart",
//		data:{"num":num},
		success : function(data) {
			data = eval(data);
			for (var i = 0; i < data.length; i++) {
				shopCartHTMLCode +=  "<strong>" + data[i].bookName + "<i>￥" + data[i].price + "</i></strong>";
			}
			shopCartFirstItemName.innerHTML = shopCartHTMLCode;
		},
		error : function(e) {
			console.log("[getshopCart]failed" + JSON.stringify(e));
		}
	});
}

function register(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	var phoneNumber = document.getElementById("phoneNumber").value;
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/bookSalesSystem/pages/UserServlet/register",
		data:{
			"userName" : userName,
			"password" : password,
			"phoneNumber" : phoneNumber
		},
		success:function(data){
			data = eval(data)
//			alert(JSON.stringify(data));
			if(data[0].status == false){
				alert("注册失败!");
			}else{
				alert("注册成功!");
				window.history.back(-1); 
				
			}
		}
	});
}


function login(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	
	console.log("userName:" + userName + " password:" + password);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/bookSalesSystem/pages/UserServlet/login",
		data:{
			"userName" : userName,
			"password" : password
		},
		success:function(data){
			data = eval(data)
//			alert(JSON.stringify(data));
			if(data[0].status == false){
				alert("用户名与密码不匹配!");
			}else{
				alert("登陆成功!");
				window.history.back(-1); 
				
			}
		}
	})
}

function logout(){
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/UserServlet/logout",
		success : function(data) {
			
		},
		error : function(e) {
			console.log("[logout]failed" + JSON.stringify(e));
		}
	});
}

function changePassword(){
	var userName = document.getElementById("userName").value;
	var oldPassword = document.getElementById("oldPassword").value;
	var newPassword = document.getElementById("newPassword").value;
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/bookSalesSystem/pages/UserServlet/changePassword",
		data:{
			"userName" : userName,
			"oldPassword" : oldPassword,
			"newPassword" : newPassword
		},
		success:function(data){
			data = eval(data)
//			alert(JSON.stringify(data));
			if(data[0].status == false){
				alert("用户名与密码不匹配!");
			}else{
				alert("修改成功!");
				window.history.back(-1); 
				
			}
		}
	})
}

function search(keyWord){
	var searchBookListDiv = document.getElementById("searchDiv");
	var searchBookListHTMLCode = "";
	$ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/CategoryServlet/search",
		data:{
			"keyWord" : keyWord
		},
		success : function(data){
			data = eval(data);
			for(var i = 0; i<data.length;i++){
				searchBookListHTMLCode += "<div class='urun'><a href='#' class='uResim'><img src=" + data[i].img  + "alt='' /></a> ";
				searchBookListHTMLCode += "<a href='#' class='uBaslik'>" + data[i].bookName +  "</a> ";
				searchBookListHTMLCode += "<a href='#'  class='uAbaslik'>" + data[i].categoryName +"</a>";
				searchBookListHTMLCode += "<p>" +data[i]._abstract +"</p>";
				bookListHTMLCode += "<span>" + data[i].price+ "￥</span>";
				bookListHTMLCode += "<a href='#' class='incele'></a><a href='#' class='sepeteat'></a></div>";
			}
			searchBookListDiv.innerHTML = searchBookListHTMLCode;
		},
		error : function(e) {
			console.log("[search]failed" + JSON.stringify(e));
		}
		
	});
	
	
}



function getPersonInfomation(){
	
}






