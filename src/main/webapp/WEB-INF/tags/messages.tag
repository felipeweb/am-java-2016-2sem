<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty vmessages.errors}">
    <div class="ls-alert-danger ls-dismissable">
        <span data-ls-module="dismiss" class="ls-dismiss">&times;</span>
        <c:forEach items="${vmessages.errors}" var="error">
            <strong>${error.category}</strong> ${error.message} <br>
        </c:forEach>
    </div>
</c:if>
<c:if test="${not empty vmessages.info}">
    <div class="ls-alert-info ls-dismissable">
        <span data-ls-module="dismiss" class="ls-dismiss">&times;</span>
        <c:forEach items="${vmessages.info}" var="info">
            <strong>${info.category}</strong> ${info.message} <br>
        </c:forEach>
    </div>
</c:if>
<c:if test="${not empty vmessages.warnings}">
    <div class="ls-alert-warning ls-dismissable">
        <span data-ls-module="dismiss" class="ls-dismiss">&times;</span>
        <c:forEach items="${vmessages.warnings}" var="warn">
            <strong>${warn.category}</strong> ${warn.message} <br>
        </c:forEach>
    </div>
</c:if>
<c:if test="${not empty vmessages.success}">
    <div class="ls-alert-success ls-dismissable">
        <span data-ls-module="dismiss" class="ls-dismiss">&times;</span>
        <c:forEach items="${vmessages.success}" var="success">
            <strong>${success.category}</strong> ${success.message} <br>
        </c:forEach>
    </div>
</c:if>