package com.shinhan.myapp.filter;
import com.shinhan.myapp.vo.MemberDTO;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@WebFilter("*.do")
public class LoginCheckFilter extends HttpFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //요청수행하기 전
        HttpServletRequest req = (HttpServletRequest) request;

        //요청의 주소를 얻어보기
        String contextPath = req.getServletContext().getContextPath();
        String uri = req.getRequestURI();
        log.info("contextPath: " + contextPath);
        uri = uri.substring(contextPath.length());
        log.info("요청 주소 얻어보기: " + uri);

        //요청주소가 로그인이면 요청대로 수행하고 로그인이 아니면 로그인한건지 체크
        if (!uri.equals("/auth/login.do") && !uri.startsWith("/rest")) {
            HttpSession session = req.getSession();
            MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
            if (member == null) {
                log.info("로그인 안함");
                HttpServletResponse res = (HttpServletResponse) response;
                log.info(contextPath + "/auth/login.do");
                res.sendRedirect(contextPath + "/auth/login.do"); // 리다이렉트 수행
                return;
            }

        }
        chain.doFilter(request, response);
        //요청수행후... 응답전
    }
}
