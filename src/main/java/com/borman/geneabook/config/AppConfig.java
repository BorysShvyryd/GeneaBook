package com.borman.geneabook.config;

import com.borman.geneabook.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@Configuration
@ComponentScan("com.borman")
@EnableJpaRepositories(basePackages = "com.borman.geneabook.repository")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    @Value("${spring.mail.host}")
    private String SMTP_SERVER;

    @Value("${spring.mail.port}")
    private String SMTP_Port;

    @Value("${spring.mail.username}")
    private String SMTP_AUTH_USER;

    @Value("${spring.mail.password}")
    private String SMTP_AUTH_PWD;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String SMTP_AUTH_PROPERTIES;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String SMTP_STARTTLS_PROPERTIES;

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(SMTP_SERVER);
        mailSender.setPort(Integer.parseInt(SMTP_Port));

        mailSender.setUsername(SMTP_AUTH_USER);
        mailSender.setPassword(SMTP_AUTH_PWD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", SMTP_AUTH_PROPERTIES);
        props.put("mail.smtp.starttls.enable", SMTP_STARTTLS_PROPERTIES);
        props.put("mail.debug", "true");

        return mailSender;
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

}
