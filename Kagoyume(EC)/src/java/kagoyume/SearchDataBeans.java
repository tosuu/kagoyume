/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.util.ArrayList;

/**
 *
 * @author yoshi
 */
public class SearchDataBeans {
    private String name;
    private String price;
    private String code;
    private String image;
    private String description;
    private String rate;
    
    public SearchDataBeans(){
        this.name = "";
        this.price = "";
        this.code = "";
        this.image = "";
        this.description = "";
        this.rate = "";
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getDescrition() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        
        return chkList;
    }
}
