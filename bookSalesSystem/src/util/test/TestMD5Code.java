package util.test;

import util.MD5Code;

/**
 * Created by Oscar on 2017/5/25.
 */
public class TestMD5Code {
    public static void main(String[] args){
        System.out.println(new MD5Code().getMD5ofStr("adminadmin"));
    }
    
    public String getMD5Code() {
    	MD5Code md5Code = new MD5Code();
    	String code = md5Code.getMD5ofStr("adminadmin");
		return code;
    	
		
	}
}
