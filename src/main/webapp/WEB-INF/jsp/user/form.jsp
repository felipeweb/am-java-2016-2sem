<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:header/>
<div class="ls-topbar ">

    <!-- Barra de Notificações -->
    <div class="ls-notification-topbar">
        <!-- Dropdown com detalhes da conta de usuário -->
        <div data-ls-module="dropdown" class="ls-dropdown ls-user-account">
            <a href="#" class="ls-ico-user">
                <img src="/locawebstyle/assets/images/locastyle/avatar-example.jpg" alt="" />
                <span class="ls-name">João Kennedy</span>
                (johnkennedy)
            </a>

            <nav class="ls-dropdown-nav ls-user-menu">
                <ul>
                    <li><a href="#">Meus dados</a></li>
                    <li><a href="#">Faturas</a></li>
                    <li><a href="#">Planos</a></li>
                    <li><a href="#">Sair</a></li>
                </ul>
            </nav>
        </div>
    </div>

    <span class="ls-show-sidebar ls-ico-menu"></span>
    
    <!-- Nome do produto/marca com sidebar -->
    <h1 class="ls-brand-name">
        <a href="../home" class="ls-ico-earth">
            <small>Uma descrição ou outro nome</small>
            O nome do Produto
        </a>
    </h1>

    <!-- Nome do produto/marca sem sidebar quando for o pre-painel  -->
</div>


<aside class="ls-sidebar">

    <div class="ls-sidebar-inner">
        <nav class="ls-menu">
            <ul>
                <li><a href="/locawebstyle/documentacao/exemplos/painel1/home" class="ls-ico-dashboard" title="Dashboard">Dashboard</a></li>
                <li><a href="/locawebstyle/documentacao/exemplos/painel1/clients" class="ls-ico-users" title="Clientes">Clientes</a></li>
                <li><a href="/locawebstyle/documentacao/exemplos/painel1/stats" class="ls-ico-stats" title="Relatórios da revenda">Relatórios da revenda</a></li>
                <li>
                    <a href="#" class="ls-ico-cog" title="Configurações">Configurações</a>
                    <ul>
                        <li><a href="/locawebstyle/documentacao/exemplos/painel1/config-domain">Domínios da Revenda</a></li>
                        <li><a href="/locawebstyle/documentacao/exemplos/painel1/config-email">E-mail de Remetente</a></li>
                        <li><a href="/locawebstyle/documentacao/exemplos/painel1/config-aspect">Aparência</a></li>
                        <li><a href="/locawebstyle/documentacao/exemplos/painel1/config-answer">Atendimento</a></li>
                        <li><a href="/locawebstyle/documentacao/exemplos/painel1/config-api">Chave de acesso para API</a></li>
                    </ul>
                </li>
            </ul>
        </nav>


    </div>
</aside>


<main class="ls-main ">
    <div class="container-fluid">
        <h1 class="ls-title-intro ls-ico-home">Página inicial</h1>

        <p>Este é nosso boilerplate com a estrutura inicial de um projeto. Você pode <a href="http://locaweb.github.io/locawebstyle/documentacao/exemplos/">ver exemplos completos neste link</a>.</p>
        <p>Confira nossa <a href="http://locaweb.github.io/locawebstyle/documentacao/componentes/">documentação com os componentes</a> que você usar aqui.</p>
        <hr>
        <h6 class="ls-title-5">English disclaimer</h6>
        <p>This is your boilerplate with start structure. You can see <a href="http://locaweb.github.io/locawebstyle/documentacao/exemplos/">completed examples here</a>.</p>
        <p>Check out the docs to <a href="http://locaweb.github.io/locawebstyle/documentacao/componentes/">see the components that you can use</a>.</p>

    </div>
</main>
<tags:footer/>
