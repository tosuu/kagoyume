<%@page import="kagoyume.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>
<%-- 
    Document   : jdbc_advance
    Created on : 2016/06/22, 14:03:45
    Author     : yoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ログイン画面</h1>
         <form action="<%= response.encodeURL("./LoginCheck")%>" method="post">
            <%if (request.getAttribute("error") != null){out.println(request.getAttribute("error"));}%><br><br>
            <h3>名前：</h3><input type="text" name="name" size="60" style="border: 1px solid; padding: 3px;"> <br><br>
            <h3>PASSWORD：</h3><input type="text" name="password" size="60" style="border: 1px solid; padding: 3px;"> <br><br> 
            <input type="submit" name="btnSubmit" value="ログイン"  ><br><br>
            <button type="button"><a href="registration">新規登録</a></button>
         </form><br>
         <%= jh.top() %><br>
        <%= jh.cart() %>
    </body>
</html>
