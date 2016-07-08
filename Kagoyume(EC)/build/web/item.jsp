<%-- 
    Document   : item.jsp
    Created on : 2016/07/05, 10:48:37
    Author     : yoshi
--%>
<%@page import="kagoyume.JumsHelper"
        import="kagoyume.SearchDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
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
        <table border=1>
            <tr>
                <th>画像</th>
                <th>商品名</th>
                <th>値段</th>
                <th>説明</th>
                <th>レビュー</th>
                <th>カート</th>
            </tr>
            <tr>
                <td><img src="<%= usd.getImage()%>"></td>
                <td width="250"><a href="Item?id=<%= usd.getCode()%>"><%= usd.getName()%></td>
                <td><%= usd.getPrice()%>円</td>
                <td><%= usd.getDescrition()%></td>
                <td><%= usd.getRate()%></td>
                <td width="90"><a href="Add?id=<%= usd.getCode()%>">カートに追加</td>
            </tr>
        </table> <br>
        <%=jh.top()%>
    </body>
</html>
