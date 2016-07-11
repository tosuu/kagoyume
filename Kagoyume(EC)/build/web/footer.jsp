<%-- 
    Document   : footer
    Created on : 2016/07/10, 2:42:51
    Author     : yoshi
--%>
<%@page import="kagoyume.UserData"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%  
    UserData userdata = new UserData();
    if(session.getAttribute("userdata") != null) {
        userdata = (UserData)session.getAttribute("userdata");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if(userdata.getUserID() == 0) { %>
    <a href="<%= response.encodeURL("Login") %>">ログイン</a>
<% } else { %>
    ようこそ<a href="Mydata"><%= userdata.getName() %></a>さん<br><br>
    <a href="<%= response.encodeURL("Logout")%>">ログアウト</a>
<% } %>
    
    
