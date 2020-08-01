package finalproject.config;

import finalproject.interceptors.StatsInterceptor;
import finalproject.interceptors.TitleInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

    private final StatsInterceptor statsInterceptor;
    private final TitleInterceptor titleInterceptor;

    public WebConfig(StatsInterceptor statsInterceptor, TitleInterceptor titleInterceptor) {
        this.statsInterceptor = statsInterceptor;
        this.titleInterceptor = titleInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statsInterceptor);
        registry.addInterceptor(titleInterceptor);
    }


}
