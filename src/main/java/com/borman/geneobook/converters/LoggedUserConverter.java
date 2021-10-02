//package com.borman.geneobook.converters;
//
//import com.borman.geneobook.entity.User;
//import com.borman.geneobook.repository.LoggedUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class LoggedUserConverter implements Converter<String, User> {
//
//    @Autowired
//    public LoggedUserRepository loggedUserRepository;
//
//    @Override
//    public User convert(String s) {
//        return loggedUserRepository.findById(Long.parseLong(s)).orElse(new User());
//    }
//}
