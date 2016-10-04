<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="ls-box-filter">
	<form action="" class="ls-form ls-form-inline ls-float-left">
		<label class="ls-label col-md-8 col-sm-8"> <b
			class="ls-label-text"><fmt:message key="filter.column"/></b>
			<div class="ls-custom-select">
				<select name="column" class="ls-select">
					<option value="*" ${param.column == "*" ? "selected" : ""}><fmt:message key="select.all"/></option>
					<option value="name" ${param.column == "name" ? "selected" : ""}><fmt:message key="select.name"/></option>
					<option value="CPF" ${param.column == "CPF" ? "selected" : ""}><fmt:message key="select.cpf"/></option>
					<option value="phone" ${param.column == "phone" ? "selected" : ""}><fmt:message key="select.phone"/></option>
					<option value="faixaInvestimento" ${param.column == "faixaInvestimento" ? "selected" : ""}><fmt:message key="select.faixaInvestimento"/></option>
					<option value="tempoInvestimento" ${param.column == "tempoInvestimento" ? "selected" : ""}><fmt:message key="select.tempoInvestimento"/></option>
					<option value="participacao" ${param.column == "participacao" ? "selected" : ""}><fmt:message key="select.participacao"/></option>
				</select>
			</div>
		</label> <label class="ls-label col-md-8 col-sm-8"> <b
			class="ls-label-text"><fmt:message key="filter.value"/></b> <input type="text" name="value" value="${param.value}"
			placeholder="<fmt:message key="filter.value"/>">
		</label>
		<div class="ls-actions-btn">
			<button class="ls-btn" type="submit">
				<fmt:message key="filter" />
			</button>
		</div>
	</form>

</div>