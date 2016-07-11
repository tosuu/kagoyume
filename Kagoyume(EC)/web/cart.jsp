<%-- 
    Document   : cart
    Created on : 2016/06/20, 10:47:56
    Author     : Yoshi
--%>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@page import ="java.util.*"%>
<%@page import="kagoyume.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession hs = request.getSession();
    HashMap<String,SearchDataBeans> cart = (HashMap<String,SearchDataBeans>)hs.getAttribute("cart");
    int sum = 0;
    
    UserData userdata = new UserData();
    if(session.getAttribute("userdata") != null) {
        userdata = (UserData)session.getAttribute("userdata");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>買い物かご -かごいっぱいのゆめ</title>
    </head>
    <body>
        <% if(userdata.getUserID() == 0) { %>
            <a href="<%= response.encodeURL("Login") %>">ログイン</a>
        <% } else { %>
            <%
                if(cart!=null){
                for(String key: cart.keySet()){

            %>
            <a href = "Item?code=<%=cart.get(key).getCode()%>">
                <%=cart.get(key).getName()%>
            </a>
                <%=cart.get(key).getPrice()%>円<br>
                    <img src="<%=cart.get(key).getImage()%>"><br>
                小計:<%=cart.get(key).getPrice()%>円<br>
                <form action ="Deletecart" method ="POST">
                    <input type="submit" name="delete" value="削除">
                </form><br>
            <%        
                    sum += (Integer.parseInt(cart.get(key).getPrice()));        
               }
            %>
                合計<%=sum%>円
                <form action ="<%= response.encodeURL("BuyConfirm")%>" method ="POST">
                    <input type="submit" name="buy" value="購入する">
                </form>
            <%    
                }else{
                    out.print("カートには何も入っていません");
                }
            }
        %>
        
        <a href="<%= response.encodeURL("top.jsp") %>">トップに戻る</a>
    </body>
</html>