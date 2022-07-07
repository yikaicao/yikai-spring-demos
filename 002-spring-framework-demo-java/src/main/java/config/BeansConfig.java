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

    @Bean("aUserDao")
    public UserDaoImpl userDao() {
        return new UserDaoImpl();
    }

    @Bean("userService")
    public UserServiceImpl userService() {
        UserServiceImpl userService =  new UserServiceImpl();
        userService.setUserDao(userDao());
        return userService;
    }

    @Bean("logAspect")
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
