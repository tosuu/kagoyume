<%@page import="kagoyume.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% boolean errorflg = JumsHelper.getInstance().chkError(request.getAttribute("error")); %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kagoyume Top</title>
</head>
<body>
    <% if (errorflg) { %>
        <font size=6 color="red"><%= JumsHelper.getInstance().getEmptyError(request.getAttribute("error").toString()) %></font>
    <% } %>
    <h1>かごゆめトップ</h1><br>
    <h3>ショッピングサイトを使っている時、こんな経験ありませんか？</h3>
    <h3>「あれいいな」「これいいな」「あっ、関連商品のこれもいい」「20%オフセールだって！？　買わなきゃ！」・・・</h3>
    <h3>そしていざ『買い物かご』を開いたとき、その合計金額に<span font="bold">愕然</span>とします。</h3>
    <h3>「こんなに買ってたのか・・・しょうがない。いくつか減らそう・・・」</h3>    
    <h3>仕方がありません。無駄遣いは厳禁です。でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？ <br>できればお金の事なんか考えずに好きなだけ買い物がしたい・・・。</h3>
    <h3>このサービスは、そんなフラストレションを解消するために生まれた『金銭取引が絶対に発生しない』<br>『いくらでも、どんなものでも購入できる(気分になれる)』『ECサイト』です</h3><br>
    
    <form action="Search" method="GET">
        検索:
        <input type="text" name="name" value="">
        <br><br>
        <input type="submit" name="btnSubmit" value="送信">
    </form><br>
</body>
</html>
