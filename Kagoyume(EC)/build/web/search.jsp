<%@page import="kagoyume.SearchDataBeans"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="kagoyume.Api"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.UserDataBeans" %>
<%@page import="kagoyume.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    SearchDataBeans sdb = (SearchDataBeans)session.getAttribute("sdb");
    ArrayList<SearchDataBeans> itemData = (ArrayList<SearchDataBeans>)session.getAttribute("itemData");
    
//    boolean backflg = false;
//    UserDataBeans userdata = null;
//    if(request.getParameter("back") != null && request.getParameter("back").equals("BACK")){
//        backflg = true;
//        userdata = (UserDataBeans)session.getAttribute("udb"); 
//   }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        検索キーワード: <%= sdb.getName() %>
        検索結果数: <%= itemData.size() %>
        <br><br>
            <table border=1>
                <tr>
                    <th>画像</th>
                    <th>商品名</th>
                    <th>値段</th>
                </tr>
                <tr>
                    <% for (int i = 0; i < itemData.size(); i++) {%>
                        <td><img src="<%= itemData.get(i).getImage()%>"></td>
                        <td width="250"><a href="Item?code=<%= itemData.get(i).getCode()%>"><%= itemData.get(i).getName()%></td>
                        <td><%= itemData.get(i).getPrice()%>円</td>
                </tr>
                <%}%>
                </table> <br>
        <br>
        <%=jh.top()%>
    </body>
</html>
