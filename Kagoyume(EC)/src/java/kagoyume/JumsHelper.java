package kagoyume;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String topURL = "top.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String top(){
        return "<a href=\""+topURL+"\">トップへ戻る</a>";
    }
    

//    public String chkinput(ArrayList<String> chkList){
//        String output = "";
//        for(String val : chkList){
//                if(val.equals("item")){
//                    output += "商品名";
//                }
//                output +="が未記入です<br>";
//            }
//        return output;
//    }
    
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
}
