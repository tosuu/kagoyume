package kagoyume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String topURL = "top.jsp";
    private final String cartURL = "Cart";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String top(){
        return "<a href=\""+topURL+"\">トップへ戻る</a>";
    }
    
    public String cart() {
        return "<a href=\""+cartURL+"\">カートを見る</a>";
    }
    
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("item")){
                    output += "商品名";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    public String chkUserInfo(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("password")){
                    output += "パスワード";
                }
                if(val.equals("mail")){
                    output += "メールアドレス";
                }
                if(val.equals("address")){
                    output += "住所";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    public String showError(String error){
        String output = "";
        if (error == "" || error == "null") {
            output += "商品名が未入力です";
            return output;
        } else {
            return error;
        }
    }
    
    public boolean chkError(Object error){
        if (error != null) {
            boolean errorflg = true;
            return errorflg;
        } else {
            boolean errorflg = false;
            return errorflg;
        }
    }
    
    public String getEmptyError(String error) {
        if (error != null) {
            return error;
        } else {
            return "";
        }
    }
    
    public String sendType(int i){
        String message = "";
        switch(i){
            case 1:
                message += "ヤマト運輸";
                break;
            case 2:
                message += "佐川急便";
                break;
            case 3:
                message += "クロネコヤマト";
                break;
        }
        return message;
    } 
}
