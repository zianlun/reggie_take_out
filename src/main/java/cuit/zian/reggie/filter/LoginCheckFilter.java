package cuit.zian.reggie.filter;

import com.alibaba.fastjson.JSON;
import cuit.zian.reggie.common.BaseContext;
import cuit.zian.reggie.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    /*
     * 1.获取请求uri
     * 2.判断请求是否需要处理
     * 3.不需要处理，放行
     * 4.未登录返回登录页面
     * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        log.info("LoginCheckFilter正在工作...");
        //1.获取请求uri
        String uri = request.getRequestURI();
        //2.判断请求是否需要处理
        String[] urls = new String[]{
                "/employee/login",
                "/backend/**",
                "/front/**"
        };
        if (checkPath(urls, uri)) {
            //3.不需要处理，放行
            log.info("{} 地址放行", uri);
            filterChain.doFilter(request, response);
        } else {
            log.info("else----:  {} 的线程号为： {}", uri,Thread.currentThread());
            //4.判断是否登录
            if(request.getSession().getAttribute("employeeId") != null){
                Long id = (Long)request.getSession().getAttribute("employeeId");
                log.info("用户: {} 正在操作", id);
                log.info("{} 的线程号为： {}", uri,Thread.currentThread());
                BaseContext.setCurrentId(id);
                filterChain.doFilter(request, response);
            }else{
                //未登录，通过输出流向客户端响应数据
                log.info("{}地址因为没有登录，被拦截", uri);
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Cache-Control", "no-cache");
                response.setContentType("application/json;charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(JSON.toJSONString(Result.unauthorized("UNLOGIN")));
                return ;
            }
        }
    }
    public boolean checkPath(String[] urls, String uri){
        for (String url : urls) {
            if (PATH_MATCHER.match(url, uri)) {
                return true;
            }
        }
        return false;
    }

}
