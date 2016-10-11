<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tags:header/>
<tags:topbar/>
<tags:sidebar/>
<main class="ls-main">
    <div class="container-fluid">
        <h1 class="ls-title-intro ls-ico-user">
            <fmt:message key="new.user"/>
        </h1>
        <tags:messages/>
        <form action="/user/save" method="post" class="ls-form"
              data-ls-module="form">
            <fieldset>
                <label class="ls-label"> <input type="hidden" name="user.id"
                                                value="${user.id}"> <b class="ls-label-text"><fmt:message
                        key="name"/></b> <input type="text" name="user.name"
                                                placeholder='<fmt:message key="name"/>' value="${user.name}"
                                                required>
                </label> <label class="ls-label"> <b class="ls-label-text"><fmt:message
                    key="username"/></b> <input type="text" name="user.login"
                                                placeholder='<fmt:message key="username"/>' value="${user.login}"
                                                required>
            </label> <label class="ls-label"> <b class="ls-label-text"><fmt:message
                    key="password"/></b> <input type="password" name="user.password"
                                                placeholder='<fmt:message key="password"/>'
                                                required>
                <input type="hidden" name="user.accessLevel" value="ADMINISTRADOR">
            </label>
            </fieldset>
            <div class="ls-actions-btn">
                <button type="submit" class="ls-btn">
                    <fmt:message key="save"/>
                </button>
                <button type="reset" class="ls-btn-danger">
                    <fmt:message key="clear"/>
                </button>
            </div>
        </form>
    </div>
</main>
<tags:footer/>
