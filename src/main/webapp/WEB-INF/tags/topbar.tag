<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="ls-topbar ">

    <!-- Barra de Notificações -->
    <div class="ls-notification-topbar">
        <!-- Dropdown com detalhes da conta de usuário -->
        <c:if test="${userSession.logged}">
            <div data-ls-module="dropdown" class="ls-dropdown ls-user-account">
                <a href="#" class="ls-ico-user">
                        ${userSession.user.name}
                </a>

                <nav class="ls-dropdown-nav ls-user-menu">
                    <ul>
                        <li><a href="/dashboard"><fmt:message key="dashboard"/> </a></li>
                        <li><a href="/logout"><fmt:message key="sair"/> </a></li>
                    </ul>
                </nav>
            </div>
        </c:if>
        <c:if test="${not userSession.logged}">
            <div class="ls-user-account">
                <a href="/login" class="ls-ico-user">
                    <fmt:message key="signin"/>
                </a>
            </div>
        </c:if>
    </div>
    <span class="ls-show-sidebar ls-ico-menu"></span>

    <!-- Nome do produto/marca com sidebar -->
    <h1 class="ls-brand-name">
        <a href="/">
            Unlock My Door
        </a>
    </h1>

    <!-- Nome do produto/marca sem sidebar quando for o pre-painel -->
</div>
