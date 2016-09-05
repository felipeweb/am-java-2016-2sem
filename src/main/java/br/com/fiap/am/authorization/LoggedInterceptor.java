package br.com.fiap.am.authorization;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fiap.am.controller.LoginController;
import br.com.fiap.am.model.UserSession;

import javax.inject.Inject;

/**
 * Created by felipeweb on 04/09/16.
 */
@Intercepts
public class LoggedInterceptor implements Interceptor {
    private final Result result;
    private final Validator validator;
    private final UserSession session;

    /**
     * @deprecated CDI eyes only
     */
    protected LoggedInterceptor() {
        this(null, null, null);
    }

    @Inject
    public LoggedInterceptor(Result result, Validator validator, UserSession session) {
        this.result = result;
        this.validator = validator;
        this.session = session;
    }

    @Override
    public void intercept(InterceptorStack interceptorStack, ControllerMethod controllerMethod, Object o) throws InterceptionException {
        if (session.isLogged()) {
            interceptorStack.next(controllerMethod, o);
        } else {
            validator.add(new I18nMessage("Warn", "must.logged", Severity.WARN));
            result.forwardTo(LoginController.class).login();
        }
    }

    @Override
    public boolean accepts(ControllerMethod controllerMethod) {
        return !controllerMethod.containsAnnotation(Public.class);
    }
}
