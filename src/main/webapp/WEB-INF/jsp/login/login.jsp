<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:header/>

<div class="ls-login-parent">
    <div class="ls-login-inner">
        <div class="ls-login-container">
            <div class="ls-login-box">
                <h1 class="ls-login-logo"><fmt:message key="login"/></h1>
                <form role="form" class="ls-form ls-login-form" method="post" action="/login">
                    <tags:messages/>
                    <fieldset>

                        <label class="ls-label"> <b
                                class="ls-label-text ls-hidden-accessible"><fmt:message key="username"/></b> <input
                                class="ls-login-bg-user ls-field-lg" name="login" type="text"
                                placeholder='<fmt:message key="username"/>' autofocus>
                        </label> <label class="ls-label"> <b
                            class="ls-label-text ls-hidden-accessible"><fmt:message key="password"/></b>
                        <input class="ls-login-bg-password ls-field-lg" name="password" type="password"
                               placeholder="<fmt:message key="password"/>">
                    </label>

                        <p>
                            <a class="ls-login-forgot" href="#"><fmt:message key="forgot.password"/></a>
                        </p>

                        <button type="submit" class="ls-btn-primary ls-btn-block ls-btn-lg"><fmt:message key="signin"/></button>

                    </fieldset>
                </form>
            </div>

        </div>
    </div>
</div>

<tags:footer/>