<%-- 
    Document   : add.jsp
    Created on : 2016/07/05, 10:49:04
    Author     : yoshi
--%>
<%@page import="kagoyume.SearchDataBeans"%>
<%@page import="kagoyume.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    // cartがnullですねーw
    SearchDataBeans cart = (SearchDataBeans)session.getAttribute("cart");
    SearchDataBeans usd = (SearchDataBeans)session.getAttribute("usd");
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
                <td><img src="<%= usd.getImage()%>"></td>
                <td width="250"><a href="Item?id=<%//= cart.getCode()%>"><%//= cart.getName()%></td>
                <td><%//= usd.getPrice()%>円</td>
            </tr>
        </table> <br>
        
        <%= jh.top() %>
    </body>
</html>
