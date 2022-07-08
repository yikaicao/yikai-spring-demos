import root.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import root.service.CarServiceImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("root");

        CarServiceImpl carService = applicationContext.getBean(CarServiceImpl.class);

        List<Car> returnedList = carService.findCarList();

        returnedList.forEach(car -> System.out.println(car.getBrand() + "," + car.getPrice()));
    }
}
