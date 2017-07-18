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

/*
<div id="arama">
<form action="#" method="POST">
	<input type="text"/>
	<button type="Submit"></button>
</form>
</div>
*/
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
/*
<div class="isag-1">
<div class="isag-1-1">
	<img src="img/3.jpg">
</div>
<div class="isag-1-2">
	<span>我的昵称<br />
	我的電話<br />
	我的地址<br />
           <a href="#">修改地址请点击此处</a></span>
</div>
</div> */

function getPersonInfomation(){
	var personInformation=document.getElementById("isag-1");
	var personInformationHTMLCode="";
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/UserServlet/personInformation",
		success : function(data) {
			data=eval(data);
			console.log(JSON.stringify(data));
			for(var i = 0; i < data.length; i++){
				personInformationHTMLCode +="<div class='isag-1-1'>";
				personInformationHTMLCode +="<img src='"+ data[i].uid+"'></div>";
				personInformationHTMLCode +="<div class='isag-1-2'>"+ data[i].username +"";
				personInformationHTMLCode +="<span>"+ data[i].phoneNumber +"</span>";
				personInformationHTMLCode +="<span>"+ data[i].address +"</span></div>";
			}
			personInformation.innerHTML = personInformationHTMLCode;
		},
		error : function(e) {
			console.log("[getPersonInfomation]failed" + JSON.stringify(e));
		}
	});
	
}

function shopCart(){
	var shopCartFirstItemName = document.getElementById("isag");
	var shopCartHTMLCode = shopCartFirstItemName.innerHTML;
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/shopCartServlet/getShopCart",
		success : function(data) {
			data = eval(data);
			console.log("获取成功！数据如下："+JSON.stringify(data));
//			console.log(shopCartHTMLCode);
			for (var i = 0; i < data.length; i++) {
				
				shopCartHTMLCode += "<div class='isag-3'><div class='isag-3-1'>";
				shopCartHTMLCode += "<img src='http://localhost:8080/bookSalesSystem/pages/shop/img/uresim.png'>";
				shopCartHTMLCode += "<span>" + data[i].sid+ "</span></div>";
				shopCartHTMLCode += "<div class='isag-3-2'>"+ data[i].isPurchase + "</div>";
				shopCartHTMLCode +="<div class='isag-3-3'>"+ data[i].isOrder + "</div>";
				shopCartHTMLCode +="<div class='isag-3-4'>"+ data[i].price + "</div></div>";
				console.log(shopCartHTMLCode);
			}
			console.log(shopCartHTMLCode);
			shopCartFirstItemName.innerHTML = shopCartHTMLCode;
		},
		error : function(e) {
			console.log("[shopCart]failed" + JSON.stringify(e));
		}
	});
	
}
/*
<div class="isag-1-2">
<span>图书名称:一本正经的小黄书<br />
类别：值得深究哦<br />
生产厂家：翔翔公司<br />
上架时间：2016-7-7<br />
配送服务：sfoa;jasovnaso;hpaijg;dhdgdfhdgdp<br />
附送：一支晨光笔<br /></span>
</div>
*/
function bookDetails(){
	var Details= document.getElementById();
	var DetailsHTMLCode = Details.innerHTML;
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/bookSalesSystem/pages/shopCartServlet/getbookDetails",
		success : function(data) {
			data = eval(data);
			console.log(JSON.stringify(data));
			for(var i = 0; i < data.length; i++) {
				DetailsHTMLCode +="<div class='isag-1-2'>";
				DetailsHTMLCode +="<span>"+ data[i].bookName +"<br/>"
				DetailsHTMLCode +=""+ data[i].price +"<br/>";
				DetailsHTMLCode +=""+ data[i].author +"<br/>";
				DetailsHTMLCode +=""+ data[i].salesNumber +"<br/>";
				DetailsHTMLCode +=""+ data[i].score +"<br/>";
				DetailsHTMLCode +=""+ data[i].abstract +"<br/>"
				DetailsHTMLCode +=""+ data[i].detail +"<br/>";
				DetailsHTMLCode +=""+ data[i].surplus +"<br/></span></div>";
				
			}
			Details.innerHTML = DetailsHTMLCode;
		},
		error : function(e) {
			console.log("[bookDetails]failed" + JSON.stringify(e));
		}
		
	});
}





