package com.borman.geneobook.converters;

import com.borman.geneobook.entity.LoggedUser;
import com.borman.geneobook.repository.LoggedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class LoggedUserConverter implements Converter<String, LoggedUser> {

    @Autowired
    public LoggedUserRepository loggedUserRepository;

    @Override
    public LoggedUser convert(String s) {
        return loggedUserRepository.findById(Long.parseLong(s)).orElse(new LoggedUser());
    }
}
