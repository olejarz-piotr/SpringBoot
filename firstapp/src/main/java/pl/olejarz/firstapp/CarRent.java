package pl.olejarz.firstapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarRent {

   private List<Car>carList;

    public CarRent() {
        this.carList =new ArrayList<>();
        carList.add(new Car("BMW", "E90"));
        carList.add(new Car("BMW", "E60"));
        carList.add(new Car("BMW", "E24"));

    }

    public boolean deleteCar(Car car){
        carList.remove(car);
        return true;
    }

    public boolean addCar(Car car){
        carList.add(car);
        return true;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
