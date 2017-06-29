# bookSalesSystem
这是小学期的图书销售系统项目

关键字段:

#  book:
  
    (int)     bid;
    
    (String)  bookName;
    
    (int)     price;
    
    (string)  img(url);
    
    (String)  author;
    
    (int)     salesNumber;
    
    (String)  score;
    
    (String)  abstract;
    
    (String)  detail;
    
    (int)     surplus;
    
    (String)  categoryName;
    
  category:
  
    (String)  categoryName;

前端接口:

#    getAllBooks() 
    
      返回:list
      
          (int)     bid;
          
          (String)  bookName;
          
          (int)     price;
          
          (string)  img(url);
          
          (String)  author;
          
          (int)     salesNumber;
          
          (String)  score;
          
          (String)  abstract;
          
          (int)     surplus;
          
          (String)  categoryName;
          
        
#    getBooksBySplite(int index,int num);//根据index和splite返回书籍
    
      返回:
      
       map/list
      
          (int)     bid;
          
          (String)  bookName;
          
          (int)     price;
          
          (string)  img(url);
          
          (String)  author;
          
          (int)     salesNumber;
          
          (String)  score;
          
          (String)  abstract;
          
          (int)     surplus;
          
          (String)  categoryName;
    
#    getCategory();//获取分类
    
        返回list
        
          (String)  categoryName;
          
    
#    getAD();
    
        返回list
        
          (String)    img(url);
          
          (String)    url(url);
          
#    getHotBooks();
    
        返回list
        
            (int)     bid;
            
            (String)  bookName;
            
            (int)     price;
            
            (string)  img(url);
            
            (String)  abstract;
            
#    shopCart(int num);
    
        参数:num = 1;
        
        返回:
        
            (int)     bid;
            
            (String)  bookName;
            
            (int)     price;
            
    logout();
     
#    search(String keyWord);
    
        参数 : keyWord
        
        返回:list
        
          type:book / category
          
            book:
            
              (int)     bid;
              
              (String)  bookName;
              
              (int)     price;
              
              (string)  img(url);
              
              (String)  abstract;
              
            category:
            
                (String)  categoryName;
                
                (String)  url;
                
      
#      login(String userName , String password);

	参数 :	username	

	参数 :	password(需要加密) 

	加密方式:RSA(userName + password)

	返回:

		status	: true / false		

		url
		
#    register(String userName,String password,String phoneNumber);
	
	参数 :	username	

	参数 :	password(需要加密) 

	参数 :	phoneNumber

	加密方式:RSA(userName + password)

	返回:

		status	: true / false		

		url
    
#    validMessage(String phoneNumber,String validCode);
	
	参数 :	phoneNumber

	参数 :	validCode(一般是4-6位短信验证码) 
	
	返回 : 

		status : true / false


#    changePassword(String userName,oldPassword,newPassword);

	参数 :	userName(邮箱/手机号)
	
	参数 :	oldPassword(需要加密) 

	参数 :	newPassword(需要加密) 

	加密方式:RSA(userName + password)

	返回 :	
		
		status : true / false

		url

   
