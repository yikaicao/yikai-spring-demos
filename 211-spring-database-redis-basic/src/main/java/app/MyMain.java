package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMain {
    public static void main(String[] args) {
        SpringApplication.run(MyMain.class, args);
        System.out.println("redis demo started");
    }

}
