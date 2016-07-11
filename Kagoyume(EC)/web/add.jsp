<%-- 
    Document   : add.jsp
    Created on : 2016/07/05, 10:49:04
    Author     : yoshi
--%>
<%@page import="java.util.HashMap"%>
<%@page import="kagoyume.SearchDataBeans"%>
<%@page import="kagoyume.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    // セッションのcartオブジェクトがカートに追加された商品情報を管理する
    HashMap<String, SearchDataBeans> cart = (HashMap<String, SearchDataBeans>)session.getAttribute("cart");
    String code = (String)request.getAttribute("code");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>カートに追加しました</h1>
        
        <table border=1>
            <tr>
                <th>画像</th>
                <th>商品名</th>
                <th>値段</th>
            </tr>
            <tr>
                <th width="250"><img src="<%= cart.get(code).getImage()%>"></th>
                <th><a href="Item?id=<%= cart.get(code).getCode()%>"><%= cart.get(code).getName() %></a></th>
                <th><%= cart.get(code).getPrice()%>円</th>
            </tr>
        </table> <br>
        
        <a href="<%= response.encodeURL("Cart") %>">カートを確認</a><br>
        <a href="<%= response.encodeURL("top.jsp") %>">トップに戻る</a>
        <%@ include file="footer.jsp"%>
    </body>
</html>
