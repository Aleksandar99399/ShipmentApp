package finalproject.interceptors;

import finalproject.interceptors.service.StatService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class StatsInterceptor implements HandlerInterceptor {

    private final StatService statService;

    public StatsInterceptor(StatService statService) {
        this.statService = statService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        statService.increaseRequestCount();
        return true;
    }
}