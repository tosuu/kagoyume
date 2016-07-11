<%-- 
    Document   : buyconfirm
    Created on : 2016/06/20, 13:16:40
    Author     : yoshi
--%>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@page import ="java.util.*"%>
<%@page import="kagoyume.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    HashMap<String,SearchDataBeans> cart = (HashMap<String,SearchDataBeans>)hs.getAttribute("cart");
    int sum = 0;
    JumsHelper jh = new JumsHelper();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入確認 -かごいっぱいのゆめ</title>
    </head>
    <body>
        <%
            if(cart!=null){
                for(String key : cart.keySet()){
        %>
                <%=cart.get(key).getName()%> <%=cart.get(key).getPrice()%>円<br>
                小計:<%=cart.get(key).getPrice()%>円<br><br>   
        <%
                sum += (Integer.parseInt(cart.get(key).getPrice()));
                }
            }
        %>
            合計<%=sum%>円  
            <form action ="BuyComplete" method ="POST">
                <% for(int i = 1; i<=3; i++){ %>
                    <input type="radio" name="type" value="<%=i%>">
                    <%=jh.sendType(i)%>
                <%}%>
                <input type="hidden" name="sum" value="<%=sum%>">
                <input type="submit" value="上記の内容で購入する">
            <form action ="Cart" method ="POST">
                <input type="submit" value="カートに戻る">
            </form>
    </body>
</html>