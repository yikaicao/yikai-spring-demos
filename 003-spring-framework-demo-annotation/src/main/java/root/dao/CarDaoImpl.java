package root.dao;

import root.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CarDaoImpl {
    public List<Car> findCarList()  {
        return Collections.singletonList(new Car("BMW", 30));
    }

}
