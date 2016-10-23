<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:header/>
<tags:topbar/>
<tags:sidebar/>
<main class="ls-main">
    <div class="container-fluid">
        <h1 class="ls-title-intro ls-ico-envelope"><fmt:message key="investPackage.list"/></h1>
        <tags:messages/>
        <table class="ls-table">
            <thead>
            <tr>
                <th><fmt:message key="descricao"/></th>
                <th><fmt:message key="actions"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${investPackageList}" var="investPackage">
                <tr>
                    <td>${investPackage.descricao}</td>
                    <td>
                        <a href="/packages/${investPackage.id}"><i class="ls-ico-pencil"></i></a>
                        <a href="/packages/remove/${investPackage.id}"><i class="ls-ico-remove"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
<tags:footer/>
