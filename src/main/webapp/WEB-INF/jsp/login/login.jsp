<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:header />

<div class="ls-login-parent">
	<div class="ls-login-inner">
		<div class="ls-login-container">
			<div class="ls-login-box">
				<h1 class="ls-login-logo">Login</h1>
				<form role="form" class="ls-form ls-login-form" action="#">
					<fieldset>

						<label class="ls-label"> <b
							class="ls-label-text ls-hidden-accessible">Usuário</b> <input
							class="ls-login-bg-user ls-field-lg" type="text"
							placeholder="Usuário" required autofocus>
						</label> <label class="ls-label"> <b
							class="ls-label-text ls-hidden-accessible">Senha</b>
							<div class="ls-prefix-group">
								<input id="password_field"
									class="ls-login-bg-password ls-field-lg" type="password"
									placeholder="Senha" required> <a
									class="ls-label-text-prefix ls-toggle-pass ls-ico-eye"
									data-toggle-class="ls-ico-eye, ls-ico-eye-blocked"
									data-target="#password_field" href="#"></a>
							</div>
						</label>

						<p>
							<a class="ls-login-forgot" href="forgot-password">Esqueci minha senha</a>
						</p>

						<input type="submit" value="Entrar"
							class="ls-btn-primary ls-btn-block ls-btn-lg">
						<p class="ls-txt-center ls-login-signup">
							Não possui um usuário? <a href="#">Cadastre-se agora</a>
						</p>

					</fieldset>
				</form>
			</div>

		</div>
	</div>
</div>

<tags:footer />