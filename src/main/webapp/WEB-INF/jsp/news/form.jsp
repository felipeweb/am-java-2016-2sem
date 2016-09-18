<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:header/>
<tags:topbar/>
<tags:sidebar/>
<main class="ls-main">
    <div class="container-fluid">
        <h1 class="ls-title-intro ls-ico-envelope"><fmt:message key="new.news"/></h1>
        <tags:messages/>
        <form action="/news/save" method="post" class="ls-form" data-ls-module="form">
            <fieldset>
                <label class="ls-label">
                    <input type="hidden" name="news.id" value="${news.id}">
                    <b class="ls-label-text"><fmt:message key="title"/></b>
                    <input type="text" name="news.title" placeholder='<fmt:message key="title"/>' value="${news.title}" required >
                </label>
                <label class="ls-label">
                    <input type="hidden" name="news.author.id" value="${news.author.id}">
                    <b class="ls-label-text"><fmt:message key="author"/></b>
                    <input type="text" name="news.author.name" placeholder='<fmt:message key="author"/>' value="${userSession.user.name}" required >
                </label>
                <label class="ls-label">
                    <b class="ls-label-text"><fmt:message key="content"/></b>
                    <textarea name="news.content" placeholder='<fmt:message key="content"/>' required >${news.content}</textarea>
                </label>
            </fieldset>
            <div class="ls-actions-btn">
                <button type="submit" class="ls-btn"><fmt:message key="save"/></button>
                <button type="reset" class="ls-btn-danger"><fmt:message key="clear"/></button>
            </div>
        </form>
    </div>
</main>
<tags:footer/>
