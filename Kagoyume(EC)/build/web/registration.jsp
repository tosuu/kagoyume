<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.JumsHelper"
        import="kagoyume.UserData" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData ud = null;
    boolean reinput = false;
    // 戻るボタンからフォームされた場合
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud"); 
   }
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="Registrationconfirm" method="POST">
        ユーザー名:
        <input type="text" name="name" value="<% if(reinput){out.print(ud.getName());}%>"><br>
        パスワード: 
        <input type="text" name="password" value="<% if(reinput){out.print(ud.getPassword());}%>"><br>
        メールアドレス: 
        <input type="text" name="mail" value="<% if(reinput){out.print(ud.getMail());}%>"><br>
        住所:
        <input type="text" name="address" value="<% if(reinput){out.print(ud.getAddress());}%>"><br>
       
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=jh.top()%>
    </body>
</html>
