package top.karlo.quiz.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述：
 *      登陆校验通过跳转地址
 * @author Karlo
 * @date 2019/1/7 16:50
 */
public class RedirectAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String forwardUrl;

    public RedirectAuthenticationSuccessHandler(String forwardUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(forwardUrl), "'" + forwardUrl + "' is not a valid forward URL");
        this.forwardUrl = forwardUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect(forwardUrl);
    }
}
