<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:header/>
<tags:topbar/>
<main class="ls-main">
	<div class="container-fluid">
		<tags:messages/>
		<p>
			É um trabalho de conclusão de semestre apresentada à FIAP para obtenção do fechamento do terceiro ano letivo do curso bacharelado de sistemas de informação.<br>
			O produto:<br>
			Criamos um aplicativo mobile que se conecta com um aparelho “Unlock My Door”, pensando na comodidade do nosso cliente final e pensando nas dificuldades do dia a dia para diversos tipos de pessoas, desde esquecer a chave da porta, até ter dificuldade na abertura da mesma.<br>
			A tecnologia vem facilitando a vida das pessoas, inclusive em suas atividades mais simples, porém nem sempre a um custo acessível, por isso tivemos a ideia de tornar a automação de portas mais acessível e simples de usar e implementar. Pensamos em implementar um aplicativo, pois a maioria das pessoas tem smartphones e isso vai fazer com que nossos clientes tenham sempre o mecanismo de abertura das portas à mão, e mais pessoas de sua casa podem sintonizar seus aplicativos nas portas escolhidas, tudo por autorização do administrador do sistema, que vai cadastrar os usuários no site web.
			O fato de tirarmos o controle remoto que é convencional na maioria das automatizações, é que acaba deixando o projeto com um custo mais acessível, e sem tirar a qualidade do produto.<br>
			Atualmente a quantidade de acidentes domésticos é cada vez maior. São homens, mulheres e jovens que precisam se manter atentos a possíveis acidentes com as portas batendo por causa do vento, com um portador de deficiência que possui dificuldade em se equilibrar para abrir as portas ou até mesmo em alcançar a maçaneta. Então partindo desse princípio a equipe buscou desenvolver um dispositivo que automatize portas.
		</p>
		<c:if test="${not empty newsList}">
			<h1><fmt:message key="lastest.news"/></h1>
			<c:forEach items="${newsList}" var="news" varStatus="index">
				<div data-ls-module="collapse" data-target="#${index}" class="ls-collapse ">
					<a href="#" class="ls-collapse-header">
						<h3 class="ls-collapse-title">${news.title} - ${news.formattedDate}</h3>
					</a>
					<div class="ls-collapse-body" id="${index}">
						<p>
							${news.content}
						</p>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
</main>
<tags:footer/>