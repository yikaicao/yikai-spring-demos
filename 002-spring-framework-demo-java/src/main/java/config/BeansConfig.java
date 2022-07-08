package config;

import aspect.LogAspect;
import dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import service.UserServiceImpl;

@EnableAspectJAutoProxy
@Configuration
public class BeansConfig {

    @Bean("aUserDao-could-be-any-name")
    public UserDaoImpl userDao() {
        return new UserDaoImpl();
    }

    @Bean("userService-could-be-any-name")
    public UserServiceImpl userService() {
        UserServiceImpl userService =  new UserServiceImpl();
        userService.setUserDao(userDao());
        return userService;
    }

    @Bean("logAspect-could-be-any-name")
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
