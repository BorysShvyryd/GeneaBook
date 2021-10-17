package com.borman.geneabook.service;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocaleService {

    public Locale getLocale() {
        return Locale.getDefault();
    }

    public void setLocale(Locale locale) {
        Locale.setDefault(locale);
    }
}
