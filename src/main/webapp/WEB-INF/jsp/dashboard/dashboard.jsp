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
	<c:if test="${userSession.user.admin}">
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
					<td>${user.accessLevel.name}</td>
					<td>
						<a href="#" data-ls-module="modal" data-target="#${user.id}"><fmt:message key="see.details"/></a>
						<div class="ls-modal" id="${user.id}">
							<div class="ls-modal-box">
								<div class="ls-modal-header">
									<button data-dismiss="modal">&times;</button>
									<h4 class="ls-modal-title">${user.name} - ${user.accessLevel}</h4>
								</div>
								<div class="ls-modal-body">
									<form action="" class="ls-form ls-form-text ls-form-disable" data-ls-module="form">
										<label class="ls-label">
											<b class="ls-label-text"><fmt:message key="id" /></b>
											<input type="text" value="${user.id}">
										</label>
										<label class="ls-label">
											<b class="ls-label-text"><fmt:message key="name" /></b>
											<input type="text" value="${user.name}">
										</label>
										<label class="ls-label">
											<b class="ls-label-text"><fmt:message key="login" /></b>
											<input type="text" value="${user.login}">
										</label>
										<label class="ls-label">
											<b class="ls-label-text"><fmt:message key="accessLevel" /></b>
											<input type="text" value="${user.accessLevel.name}">
										</label>
										<c:if test="${user.accessLevel eq 'INVESTIDOR'}">
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.rg" /></b>
												<input type="text" value="${user.rg}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.cpf" /></b>
												<input type="text" value="${user.cpf}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.phone" /></b>
												<input type="text" value="${user.phone}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.faixaInvestimento" /></b>
												<input type="text" value="${user.faixaInvestimento}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.tempoInvestimento" /></b>
												<input type="text" value="${user.tempoInvestimento}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.participacao" /></b>
												<input type="text" value="${user.participacao}">
											</label>
										</c:if>
										<c:if test="${user.accessLevel eq 'COMPRADOR'}">
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.rg" /></b>
												<input type="text" value="${user.rg}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.cpf" /></b>
												<input type="text" value="${user.cpf}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.phone" /></b>
												<input type="text" value="${user.phone}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.profissao" /></b>
												<input type="text" value="${user.profissao}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.estadoCivil" /></b>
												<input type="text" value="${user.estadoCivil}">
											</label>
											<label class="ls-label">
												<b class="ls-label-text"><fmt:message key="select.faixaSalarial" /></b>
												<input type="text" value="${user.faixaSalarial}">
											</label>
										</c:if>
									</form>
								</div>
							</div>
						</div><!-- /.modal -->
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>
</main>
<tags:footer />
