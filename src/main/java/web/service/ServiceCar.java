package web.service;

import web.model.Car;

import java.util.List;

public class ServiceCar {
    public static List<Car> getCars(List<Car> cars, int count) {
        return cars.subList(0, count);
    }
}
