package pl.olejarz.firstapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarApi {
    private CarRent carRent;

    @Autowired
    public CarApi(CarRent carRent) {
        this.carRent = carRent;
    }

    @GetMapping("sayHello")
    public String sayHello(@RequestParam String name){
        return "Hello "+name;
    }

    @GetMapping("/getCars")
    public List<Car> getCars() {
        return carRent.getCarList();

    }

    @PostMapping("/addCar")
    public boolean addCar(@RequestBody Car car){
    return carRent.addCar(car);

    }

    @DeleteMapping("/deleteCar")
    public boolean deleteCar (@RequestBody Car car)
    {
        return carRent.deleteCar(car);
    }

}
