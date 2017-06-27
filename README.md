# bookSalesSystem
这是小学期的图书销售系统项目

关键字段:

  book:
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
    getAllBooks() 
    
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
          
        
    getBooksBySplite(int index,int num);//根据index和splite返回书籍
    
      返回:map/list
      
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
    
    getCategory();//获取分类
    
        返回list
        
          (String)  categoryName;
          
    
    getAD();
    
        返回list
        
          (String)    img(url);
          
          (String)    url(url);
          
    getHotBooks();
    
        返回list
        
            (int)     bid;
            
            (String)  bookName;
            
            (int)     price;
            
            (string)  img(url);
            
            (String)  abstract;
            
    shopCart(int num);
    
        参数:num = 1;
        
        返回:
        
            (int)     bid;
            
            (String)  bookName;
            
            (int)     price;
            
    logout();
     
    search(String keyWord);
    
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
