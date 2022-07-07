import config.BeansConfig;
import entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserServiceImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        UserServiceImpl service = context.getBean(UserServiceImpl.class);

        List<User> userList = service.findUserList();

        userList.forEach(aUser -> System.out.println(aUser.getName() + "," + aUser.getAge()));
    }
}
