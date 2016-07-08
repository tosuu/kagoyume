package kagoyume;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class UserDataBeans implements Serializable{
    private String name;
    private int year;
    private int month;
    private int day;
    private String tell;
    private int type ;
    private String comment;
    
    public UserDataBeans(){
        this.name = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.tell = "";
        this.type = 0;
        this.comment= "";
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        //空文字(未入力)の場合空文字をセット
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }

    public int getYear() {
        return year;
    }
    public void setYear(String year) {
        //初期選択状態の場合0をセット
        if(year.equals("")){
            this.year = 0;
        }else{
            this.year = Integer.parseInt(year);
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(String month) {
        if(month.equals("")){
            this.month = 0;
        }else{
            this.month = Integer.parseInt(month);
        }
    }

    public int getDay() {
        return day;
    }
    public void setDay(String day) {
        if(day.equals("")){
            this.day = 0;
        }else{
            this.day = Integer.parseInt(day);
        }
    }

    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        if(tell.trim().length()==0){
            this.tell = "";
        }else{
            this.tell = tell;
        }
    }

    public int getType() {
        return type;
    }
    public void setType(String type) {
        if(type == null){
            this.type = 0;
        }else{
            this.type = Integer.parseInt(type);
        }

    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        if(comment.trim().length()==0){
            this.comment = "";
        }else{
            this.comment = comment;
        }
    }
    
    // monthが10より小さければ、数字の前に0を追加
    // 文字列に変換
    public String parseMonth(int month) {
        String p_month = "";
        if (this.month < 10) {
            p_month = String.valueOf(month);
            p_month = "0" + p_month;
        } else {
            p_month = String.valueOf(month);
        }
        return p_month;
    }
    
    // dayが10より小さければ、数字の前に0を追加
    // 文字列に変換
    public String parseDay(int day) {
        String p_day = "";
        if (this.day < 10) {
            p_day = String.valueOf(day);
            p_day = "0" + p_day;
        } else {
            p_day = String.valueOf(day);
        }
        return p_day;
    }

    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        
        return chkList;
    }
    
    // UserDataBeansの各パラメータをDTOにセット
    public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        if(this.year != 0 || this.month != 0 || this.day != 0){
            Calendar birthday = Calendar.getInstance();
            if(this.month == 0 || this.day == 0){
                birthday.set(this.year,0,1);
            }else{
                birthday.set(this.year,(this.month)-1,this.day);
            }
            udd.setBirthday(birthday.getTime());
        }else{
            udd.setBirthday(null);
        }
        udd.setTell(this.tell);
        udd.setType(this.type);
        udd.setComment(this.comment);
    }
    
    // DTOの各パラメータをUserDataBeansにセット
    public void DTO2UDMapping(UserDataDTO udd) {
        this.name = udd.getName();
        this.year = Integer.parseInt(udd.getBirthday().toString().substring(0,4));
        this.month = Integer.parseInt(udd.getBirthday().toString().substring(5,7));
        this.day = Integer.parseInt(udd.getBirthday().toString().substring(8));
        this.tell = udd.getTell();
        this.type = udd.getType();
        this.comment = udd.getComment();
        
    }
    
}
