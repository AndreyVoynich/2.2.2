package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("nissan", "x-trail", "orange"));
        cars.add(new Car("mitsubishi", "asx", "gray"));
        cars.add(new Car("ford", "kuga", "green"));
        cars.add(new Car("hyundai", "santa fe", "white"));
        cars.add(new Car("toyota", "rav 4", "brown"));
    }

    @Override
    public List<Car> getCars(int countCar) {
        if (countCar > 5) {
            return cars.subList(0, cars.size());
        } else {
            return cars.subList(0, countCar);
        }
    }

}
