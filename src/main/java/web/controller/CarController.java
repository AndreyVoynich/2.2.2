package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("nissan", "x-trail", "orange"));
        cars.add(new Car("mitsubishi", "asx", "gray"));
        cars.add(new Car("ford", "kuga", "green"));
        cars.add(new Car("hyundai", "santa fe", "white"));
        cars.add(new Car("toyota", "rav 4", "brown"));

        int countCars = new CarService().countCar(cars);

        model.addAttribute("cars", cars.subList(0, (count instanceof Integer && count > 0 &&
        count < countCars)? count : countCars));
        return "cars/cars";
    }

}
