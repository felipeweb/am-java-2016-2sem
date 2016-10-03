<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="ls-sidebar">
	<div class="ls-sidebar-inner">
		<nav class="ls-menu">
			<ul>
				<c:if test="${userSession.user.admin}">
					<li><a href="/dashboard" class="ls-ico-dashboard"
						title="Dashboard"><fmt:message key="dashboard" /></a></li>
					<li><a href="/user/form" class="ls-ico-user" title="Dashboard"><fmt:message
								key="new.user" /></a></li>
					<li><a href="/users" class="ls-ico-user" title="Dashboard"><fmt:message
								key="user.list" /></a></li>
					<li><a href="/news/form" class="ls-ico-envelope"
						title="Dashboard"><fmt:message key="new.news" /></a></li>
					<li><a href="/news" class="ls-ico-envelope" title="Dashboard"><fmt:message
								key="news.list" /></a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</aside>