import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserServiceImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("daos.xml", "services.xml", "aspects.xml");

        UserServiceImpl service = context.getBean("userService", UserServiceImpl.class);

        List<User> userList = service.findUserList();

        userList.forEach(aUser -> System.out.println(aUser.getName() + "," + aUser.getAge()));
    }
}
