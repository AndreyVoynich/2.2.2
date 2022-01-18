package web.service;

import web.model.Car;

import java.util.List;

public class CarService {
    public int countCar(List<Car> list) {
        return list.size();
    }
}
