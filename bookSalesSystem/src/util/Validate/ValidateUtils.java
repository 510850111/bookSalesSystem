package util.Validate;

/**
 * Created by Oscar on 2017/5/25.
 */
public class ValidateUtils {
    /**
     * 验证数据是否为空
     * @param data 要执行验证的数据
     * @return 数据为空,返回false,数据不为空,返回true
     */
    public static boolean validateEmpty(String data){
        if (data == null || "".equals(data) ){
            return false;
        }
        return true;
    }
}
