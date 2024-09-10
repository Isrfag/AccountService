package com.accountmicroservice.account.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("prod")
public class SimpleFilter implements Filter{

    private List<String> ipPermitidas = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        ipPermitidas.add("192.168.1.100");
        ipPermitidas.add("0:0:0:0:0:0:0:1");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String ipRequest = servletRequest.getRemoteAddr();
        //Permitimos solo las IPs seleccionadas
        if (ipPermitidas.contains(ipRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            logger.error("No se permite la IP: "+ipRequest);
            HttpServletResponse respuesta = (HttpServletResponse) servletResponse;
            respuesta.sendError(HttpServletResponse.SC_FORBIDDEN, "No se permite la IP utilizada");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
