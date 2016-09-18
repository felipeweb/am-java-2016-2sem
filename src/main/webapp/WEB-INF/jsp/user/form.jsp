<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:header/>
<tags:topbar/>
<tags:sidebar/>
<main class="ls-main">
    <div class="container-fluid">
        <h1 class="ls-title-intro ls-ico-user"><fmt:message key="new.user"/></h1>
        <tags:messages/>
        <form method="post" action="/user/save" >
        	<input type="hidden" name="user.id">
        	<input type="text" name="user.name" value="${user.name}">
        	<input type="text" name="user.login">
        	<input type="text" name="user.password">
        	<select name="user.accessLevel"></select>
        </form>
    </div>
</main>
<tags:footer/>
