package com.lisl.pay.app.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/10.
 */
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private String defaultFailureUrl;
    private boolean forwardToDestination = false;
    private boolean allowSessionCreation = true;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public MyAuthenticationFailureHandler() {
        super();
    }

    public MyAuthenticationFailureHandler(String defaultFailureUrl) {
        super(defaultFailureUrl);
        this.setDefaultFailureUrl(defaultFailureUrl);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (this.defaultFailureUrl == null) {
            this.logger.debug("No failure URL set, sending 401 Unauthorized error");
            response.sendError(401, "Authentication Failed: " + exception.getMessage());
        } else {
            this.saveException(request, exception);

        }
        if (this.forwardToDestination) {
            this.logger.debug("Forwarding to " + this.defaultFailureUrl);
            request.getRequestDispatcher(this.defaultFailureUrl).forward(request, response);
        } else {
            request.setAttribute("msg", exception.getMessage());
            this.logger.debug("Redirecting to " + this.defaultFailureUrl);
            //response.sendRedirect(this.defaultFailureUrl);
            this.redirectStrategy.sendRedirect(request, response, this.defaultFailureUrl);
        }

    }

    @Override
    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }
}
