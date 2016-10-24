<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:header/>
<tags:topbar/>
<aside class="ls-sidebar">
    <a class="ls-btn-primary ls-btn-block ls-btn-lg"
       href="ftp://unlockmydoor.ddns.net:21541"><fmt:message
            key="access.ftp"/></a>
</aside>
<main class="ls-main">
    <div class="container-fluid">
        <tags:messages/>
        <h4>
            <br> É um trabalho de conclusão de semestre apresentada à FIAP
            para obtenção do fechamento do terceiro ano letivo do curso
            bacharelado de sistemas de informação.<br> <br> O produto: <br>
            Criamos um aplicativo mobile que se conecta com um aparelho “Unlock My
            Door”, pensando na comodidade do nosso cliente final e pensando nas
            dificuldades do dia a dia para diversos tipos de pessoas, desde
            esquecer a chave da porta, até ter dificuldade na abertura da mesma.<br>
            <br> A tecnologia vem facilitando a vida das pessoas, inclusive
            em suas atividades mais simples, porém nem sempre a um custo
            acessível, por isso tivemos a ideia de tornar a automação de portas
            mais acessível e simples de usar e implementar. Pensamos em
            implementar um aplicativo, pois a maioria das pessoas tem smartphones
            e isso vai fazer com que nossos clientes tenham sempre o mecanismo de
            abertura das portas à mão, e mais pessoas de sua casa podem sintonizar
            seus aplicativos nas portas escolhidas, tudo por autorização do
            administrador do sistema, que vai cadastrar os usuários no site web. <br>
            O fato de tirarmos o controle remoto que é convencional na maioria das
            automatizações, é que acaba deixando o projeto com um custo mais
            acessível, e sem tirar a qualidade do produto.<br> <br>
            Atualmente a quantidade de acidentes domésticos é cada vez maior. São
            homens, mulheres e jovens que precisam se manter atentos a possíveis
            acidentes com as portas batendo por causa do vento, com um portador de
            deficiência que possui dificuldade em se equilibrar para abrir as
            portas ou até mesmo em alcançar a maçaneta. Então partindo desse
            princípio a equipe buscou desenvolver um dispositivo que automatize
            portas. <br> <br>
        </h4>
        <c:if test="${not empty newsList}">
            <h1>
                <fmt:message key="lastest.news"/>
            </h1>
            <c:forEach items="${newsList}" var="news" varStatus="index">
                <div data-ls-module="collapse" data-target="#${index.index}"
                     class="ls-collapse ">
                    <a href="#" class="ls-collapse-header">
                        <h3 class="ls-collapse-title">${news.title}-
                                ${news.formattedDate} (${news.author.name})</h3>
                    </a>
                    <div class="ls-collapse-body" id="${index.index}">
                        <p>${news.content}</p>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <table class="ls-table">
            <thead>
            <tr>
                <th><fmt:message key="id"/></th>
                <th><fmt:message key="descricao"/></th>
                <th><fmt:message key="quantidade"/></th>
                <th><fmt:message key="quantidade.disponivel"/></th>
                <th><fmt:message key="investir"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pkgs}" var="pkg">
                <tr>
                    <td>${pkg.id}</td>
                    <td>${pkg.descricao}</td>
                    <td>${pkg.quantidade}</td>
                    <td>${pkg.quantidadeDisponivel}</td>
                    <c:if test="${pkg.quantidadeCompras lt pkg.quantidade}">
                        <td><fmt:message key="disponivel"/></td>
                    </c:if>
                    <c:if test="${pkg.quantidadeCompras ge pkg.quantidade}">
                        <td><fmt:message key="esgotado"/></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h1>
            <fmt:message key="new.user.investor"/>
        </h1>
        <form action="/user/save/investor" method="post" class="ls-form row" id="invest_form">
            <fieldset>
                <label class="ls-label col-md-12"> <input type="hidden"
                                                          name="user.accessLevel" value="INVESTIDOR"> <b
                        class="ls-label-text"><fmt:message key="name"/></b> <input
                        type="text" name="user.name"
                        placeholder='<fmt:message key="name" />'>
                </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="login"/></b> <input type="text" name="user.login"
                                             placeholder='<fmt:message key="login" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="password"/></b> <input type="password" name="user.password"
                                                placeholder='<fmt:message key="password" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.cpf"/></b> <input type="text" name="user.cpf"
                                                  placeholder='<fmt:message key="select.cpf" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.rg"/></b> <input type="text" name="user.rg"
                                                 placeholder='<fmt:message key="select.rg" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.phone"/></b> <input type="text" name="user.phone"
                                                    placeholder='<fmt:message key="select.phone" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.faixaInvestimento"/></b> <input type="text"
                                                                name="user.faixaInvestimento"
                                                                placeholder='<fmt:message key="select.faixaInvestimento" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.tempoInvestimento"/></b> <input type="text"
                                                                name="user.tempoInvestimento"
                                                                placeholder='<fmt:message key="select.tempoInvestimento" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.participacao"/></b> <input type="text"
                                                           name="user.participacao"
                                                           placeholder='<fmt:message key="select.participacao" />'>
            </label>
                <label class="ls-label col-md-12">
                    <b class="ls-label-text"><fmt:message key="invest.packages"/></b>
                    <c:forEach items="${pkgs}" var="pkg" varStatus="index">
                        <label class="ls-label-text">
                            <input type="hidden" id="${index.index}" name="user.quantidadePackage[${index.index}].investPackage.quantidadeCompras" value="${pkg.quantidadeCompras}">
                            <input type="hidden" name="user.quantidadePackage[${index.index}].investPackage.quantidade" value="${pkg.quantidade}">
                            <input type="hidden" name="user.quantidadePackage[${index.index}].investPackage.valor" value="${pkg.valor}">
                            <input type="hidden" name="user.quantidadePackage[${index.index}].investPackage.descricao" value="${pkg.descricao}">
                            <input type="checkbox" class="ck_pkg" name="user.quantidadePackage[${index.index}].investPackage.id" value="${pkg.id}" ${pkg.quantidadeDisponivel == 0 ? 'disabled' : ''}  data-input-id="${index.index}">
                            ${pkg.descricao}<br>
                            <b class="ls-label-text"><fmt:message key="quantidade.disponivel.pkg"/></b>
                            <div class="ls-custom-select">
                                <select class="ls-select" id="select_${index.index}" name="user.quantidadePackage[${index.index}].quantidade">
                                   <c:forEach begin="0" end="${pkg.quantidadeDisponivel}" var="qtd">
                                       <option value="${qtd}">${qtd}</option>
                                   </c:forEach>
                                </select>
                            </div>
                        </label>
                    </c:forEach>
                </label>
            </fieldset>
            <div class="ls-actions-btn">
                <button type="submit" class="ls-btn">
                    <fmt:message key="investir"/>
                </button>
                <button type="reset" class="ls-btn">
                    <fmt:message key="clear"/>
                </button>
            </div>
        </form>
        <h1>
            <fmt:message key="new.user.client"/>
        </h1>
        <form action="/user/save/client" method="post" class="ls-form row">
            <fieldset>
                <label class="ls-label col-md-12"> <input type="hidden"
                                                          name="user.accessLevel" value="COMPRADOR"> <b
                        class="ls-label-text"><fmt:message key="name"/></b> <input
                        type="text" name="user.name"
                        placeholder='<fmt:message key="name" />'>
                </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="login"/></b> <input type="text" name="user.login"
                                             placeholder='<fmt:message key="login" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="password"/></b> <input type="password" name="user.password"
                                                placeholder='<fmt:message key="password" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.cpf"/></b> <input type="text" name="user.cpf"
                                                  placeholder='<fmt:message key="select.cpf" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.rg"/></b> <input type="text" name="user.rg"
                                                 placeholder='<fmt:message key="select.rg" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.phone"/></b> <input type="text" name="user.phone"
                                                    placeholder='<fmt:message key="select.phone" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.profissao"/></b> <input type="text"
                                                        name="user.profissao"
                                                        placeholder='<fmt:message key="select.profissao" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.estadoCivil"/></b> <input type="text"
                                                          name="user.estadoCivil"
                                                          placeholder='<fmt:message key="select.estadoCivil" />'>
            </label> <label class="ls-label col-md-12"> <b class="ls-label-text"><fmt:message
                    key="select.faixaSalarial"/></b> <input type="text"
                                                            name="user.faixaSalarial"
                                                            placeholder='<fmt:message key="select.faixaSalarial" />'>
            </label>
            </fieldset>
            <div class="ls-actions-btn">
                <button type="submit" class="ls-btn">
                    <fmt:message key="save"/>
                </button>
                <button type="reset" class="ls-btn">
                    <fmt:message key="clear"/>
                </button>
            </div>
        </form>
    </div>
</main>
<tags:footer/>