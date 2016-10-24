<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:header/>
<tags:topbar/>
<tags:sidebar/>
<main class="ls-main">
    <div class="container-fluid">
        <h1 class="ls-title-intro ls-ico-dashboard">
            <fmt:message key="dashboard"/>
        </h1>
        <tags:messages/>
        <c:if test="${userSession.user.admin}">
            <div class="ls-box-filter">
                <form action="" class="ls-form ls-form-inline ls-float-left">
                    <label class="ls-label col-md-8 col-sm-8"> <b
                            class="ls-label-text"><fmt:message key="filter.value"/></b> <input type="text" name="value"
                                                                                               value="${param.value}"
                                                                                               placeholder="<fmt:message key="filter.value"/>">
                    </label>
                    <div class="ls-actions-btn">
                        <button class="ls-btn" type="submit">
                            <fmt:message key="filter"/>
                        </button>
                    </div>
                </form>

            </div>
            <table class="ls-table">
                <thead>
                <tr>
                    <th><fmt:message key="id"/></th>
                    <th><fmt:message key="name"/></th>
                    <th><fmt:message key="total"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>
                                ${user.subTotalf}<br>
                            <c:forEach items="${user.quantidadePackage}" var="p">
                                ${p.investPackage.descricao} (${p.valor}) * ${p.quantidade} = ${p.totalf}<br>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td>${total}</td>
                </tr>
                </tbody>
            </table>
        </c:if>
    </div>
</main>
<tags:footer/>
