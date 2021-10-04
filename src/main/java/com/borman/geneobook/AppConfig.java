package com.borman.geneobook;

import com.borman.geneobook.service.UserDetailsServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@ComponentScan("com.borman")
@EnableJpaRepositories(basePackages = "com.borman.geneobook.repository")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

//    public Set<Converter> getConverters() {
//        Set<Converter> converters = new HashSet<>();
//        converters.add((Converter) new LoggedUserConverter());
//        return converters;
//    }
//
//    @Bean(name = "conversionService")
//    public ConversionService getConversionService() {
//        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
//        factory.setConverters(getConverters());
//        factory.afterPropertiesSet();
//        return factory.getObject();
//    }

    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("pl","PL"));
//        localeResolver.setDefaultLocale(new Locale("en","EN"));
        localeResolver.setDefaultLocale(new Locale("uk", "UA"));
        return localeResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:validationMessages",
                "classpath:/messages/login");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
        lvfb.setValidationMessageSource(messageSource());
        return lvfb;
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl();
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login/user-logging");
//        registry.addViewController("/403").setViewName("login/403");
//    }
}
