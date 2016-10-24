<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:header/>
<tags:topbar/>
<tags:sidebar/>
<main class="ls-main">
    <div class="container-fluid">
        <h1 class="ls-title-intro ls-ico-envelope"><fmt:message key="new.investPackage"/></h1>
        <tags:messages/>
        <form action="/packages/save" method="post" class="ls-form" data-ls-module="form">
            <fieldset>
                <label class="ls-label">
                    <input type="hidden" name="investPackage.id" value="${investPackage.id}">
                    <b class="ls-label-text"><fmt:message key="descricao"/></b>
                    <input type="text" name="investPackage.descricao" placeholder='<fmt:message key="descricao"/>' value="${investPackage.descricao}" required >
                </label>
                <label class="ls-label">
                    <b class="ls-label-text"><fmt:message key="quantidade"/></b>
                    <input type="text" name="investPackage.quantidade" placeholder='<fmt:message key="quantidade"/>' value="${investPackage.quantidade}" required >
                </label>
                <label class="ls-label">
                    <b class="ls-label-text"><fmt:message key="quantidade.compras"/></b>
                    <input type="text" name="investPackage.quantidadeCompras" placeholder='<fmt:message key="quantidade.compras"/>' value="${investPackage.quantidadeCompras == null ? '0' : investPackage.quantidadeCompras}" required >
                </label>
                <label class="ls-label">
                    <b class="ls-label-text"><fmt:message key="valor"/></b>
                    <input type="text" name="investPackage.valor" placeholder='<fmt:message key="valor"/>' value="${investPackage.valor}" required >
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
