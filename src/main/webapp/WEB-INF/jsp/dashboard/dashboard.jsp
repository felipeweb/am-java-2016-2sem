<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:header />
<tags:topbar />
<tags:sidebar />
<main class="ls-main">
<div class="container-fluid">
	<h1 class="ls-title-intro ls-ico-dashboard">
		<fmt:message key="dashboard" />
	</h1>
	<tags:messages />
	<tags:filterbar />
	<table class="ls-table">
		<thead>
			<tr>
				<th><fmt:message key="id" /></th>
				<th><fmt:message key="name" /></th>
				<th><fmt:message key="login" /></th>
				<th><fmt:message key="accessLevel" /></th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.login}</td>
					<td>${user.accessLevel}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</main>
<tags:footer />
