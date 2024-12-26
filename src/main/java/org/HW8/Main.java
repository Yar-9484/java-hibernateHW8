package org.HW8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація об'єктів
        Car car = new Car();
        car.setModel("Toyota");
        car.setType(CarType.SEDAN);
        car.setPower(150);
        car.setPrice(20000.0);
        car.setYear(2022);

        DriveLicense license = new DriveLicense();
        license.setSeries("AB123456");

        Owner owner = new Owner();
        owner.setName("John Doe");
        owner.setDriveLicense(license);

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        owner.setCars(cars);

        // Виведення інформації
        System.out.println("Owner: " + owner.getName());
        System.out.println("Car: " + owner.getCars().get(0).getModel());
        System.out.println("License: " + owner.getDriveLicense().getSeries());
    }
}
