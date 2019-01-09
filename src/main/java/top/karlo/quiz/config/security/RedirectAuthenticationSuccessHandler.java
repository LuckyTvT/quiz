package top.karlo.quiz.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2019/1/7 20:41
 * @since 1.0.0
 */

public class RedirectAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String forwardUrl;

    public RedirectAuthenticationSuccessHandler(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect(forwardUrl);
    }
}
