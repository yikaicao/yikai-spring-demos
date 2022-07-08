package root.service;

import root.dao.CarDaoImpl;
import root.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl {
    final CarDaoImpl carDao;

    public CarServiceImpl(CarDaoImpl carDao) {
        this.carDao = carDao;
    }

    public List<Car> findCarList() {
        return carDao.findCarList();
    }
}
