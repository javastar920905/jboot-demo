package javastar920905.service.impl;

import io.jboot.aop.annotation.Bean;
import javastar920905.service.UserService;

/**
 * @author ouzhx  on ${date}
 */
@Bean
public class UserServiceImpl implements UserService {
    @Override
    public String hello(String text) {
        return "CategoryServiceImpl say hello " + text;
    }

}
