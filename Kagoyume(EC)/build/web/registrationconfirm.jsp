<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="kagoyume.JumsHelper"
        import="kagoyume.UserData" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
    ArrayList<String> chkList = ud.chkproperties();
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(chkList.size()==0){ %>
        <h1>登録確認</h1>
        ユーザー名:<%= ud.getName()%><br>
        パスワード:<%= ud.getPassword()%><br>
        メールアドレス:<%= ud.getMail()%><br>
        住所:<%= ud.getAddress()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="<%= response.encodeURL("RegistrationComplete")%>" method="POST">
            <% request.setAttribute("userdata", ud); %>
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <form action="registration" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="no" value="いいえ">
        </form><br>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkUserInfo(chkList) %><br>
        <form action="registration" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="back" value="新規登録画面に戻る">
        </form>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
        </form><br>
        <%=jh.top()%>
    </body>
</html>
