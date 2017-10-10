package com.colorfulword.smallbluewhale.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Configuration

public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/accountlist").setViewName("accountlist");
        registry.addViewController("/addaccount").setViewName("addaccount");
        registry.addViewController("/studentlist").setViewName("studentlist");
        registry.addViewController("/addstudent").setViewName("addstudent");
        registry.addViewController("/dormitorylist").setViewName("dormitorylist");
        registry.addViewController("/adddormitory").setViewName("adddormitory");
        registry.addViewController("/dormitoryrepair").setViewName("dormitoryrepair");
        registry.addViewController("/feedback").setViewName("feedback");
        registry.addViewController("/articlelist").setViewName("articlelist");
        registry.addViewController("/addarticle").setViewName("addarticle");
        registry.addViewController("/messagelist").setViewName("messagelist");
        registry.addViewController("/addmessage").setViewName("addmessage");
        registry.addViewController("/activitylist").setViewName("activitylist");
        registry.addViewController("/addactivity").setViewName("addactivity");
        registry.addViewController("/staffmienlist").setViewName("staffmienlist");
        registry.addViewController("/addstaffmien").setViewName("addstaffmien");
        registry.addViewController("/campuslist").setViewName("campuslist");
        registry.addViewController("/addcampus").setViewName("addcampus");
        registry.addViewController("/sitenavigationlist").setViewName("sitenavigationlist");
        registry.addViewController("/addsitenavigation").setViewName("addsitenavigation");
        registry.addViewController("/truth_or_darelist").setViewName("truth_or_darelist");
        registry.addViewController("/addtruth_or_dare").setViewName("addtruth_or_dare");
        registry.addViewController("/studyinfolist").setViewName("studyinfolist");
        registry.addViewController("/addstudyinfo").setViewName("addstudyinfo");
        registry.addViewController("/updatefeesback").setViewName("updatefeesback");
        registry.addViewController("/updaterepair").setViewName("updaterepair");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);

        converters.add(fastConverter);
    }
}
