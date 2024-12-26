package org.HW8;


import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Приклад ініціалізації та використання класів
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
        owner.setCars(List.of(car));

        System.out.println("Owner: " + owner.getName());
        System.out.println("Car: " + owner.getCars().get(0).getModel());
        System.out.println("License: " + owner.getDriveLicense().getSeries());
    }
}

@Entity
class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @Enumerated(EnumType.STRING)
    private CarType type;

    private int power;
    private double price;
    private int year;

    // Getters and setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

enum CarType {
    SEDAN,
    SUV,
    TRUCK,
    COUPE
}

@Entity
class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "owner_id")
    private List<Car> cars;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drive_license_id", referencedColumnName = "id")
    private DriveLicense driveLicense;

    // Getters and setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public DriveLicense getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(DriveLicense driveLicense) {
        this.driveLicense = driveLicense;
    }
}

@Entity
class DriveLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String series;

    // Getters and setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
