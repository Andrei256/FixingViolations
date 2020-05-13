package com.myproject;


import com.myproject.services.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class MainMenu {

    private final IOService ioService;
    private final DriverService driverService;
    private final CarService carService;
    private final FoulService foulService;
    private final FixationService fixationService;

    public MainMenu() {
        this.ioService = new IOService();
        this.driverService = new DriverService();
        this.carService = new CarService();
        this.foulService = new FoulService();
        this.fixationService = new FixationService();
    }

    public void start() {

        String mainInput = "";
        do {
            ioService.printMainMenu();
            try {
                mainInput = ioService.getInputString();
                switch (mainInput) {
                    case "1":
                        Date date = fixationService.setDate();
                        System.out.println("Введите регистационный номер автомобиля");
                        String carNumber = ioService.getInputString();
                        int carId = carService.getIdByCarNumber(carNumber);
                        System.out.println("Введите наименование нарушения");
                        String nameFoul = ioService.getInputString();
                        int foulId = foulService.getIdByNameFoul(nameFoul);
                        fixationService.addNewFixation(date, carId, foulId);
                        break;
                    case "2":
                        System.out.println("Введите имя водителя");
                        String name = ioService.getInputString();
                        System.out.println("Введите фамилию водителя");
                        String surname = ioService.getInputString();
                        System.out.println("Введите номер водительского удостоверения");
                        int certificate = ioService.getInputInt();
                        System.out.println("Введите последние 9 цифр номера телефона");
                        int phoneNumber = ioService.getInputInt();
                        driverService.addNewDriver(name, surname, certificate, phoneNumber);
                        break;
                    case "3":
                        System.out.println("Введите модель автомобиля");
                        String model = ioService.getInputString();
                        System.out.println("Введите введите регистрацинный номер автомобиля");
                        String number = ioService.getInputString();
                        System.out.println("Введите номер водительского удостоверения");
                        int certificateCheck = ioService.getInputInt();
                        int driverId = driverService.getIdByCertificate(certificateCheck);
                        carService.addNewCar(model, number, driverId);
                        break;
                    case "4":
                        System.out.println("Введите наименование нарушения");
                        String nameFoulNew = ioService.getInputString();
                        foulService.addNewFoul(nameFoulNew);
                        break;
                    case "5":
                        fixationService.printAllFixationData();
                        break;
                    case "6":
                        System.out.println("Введите регистрационный номер атомобиля");
                        String carNumberDel = ioService.getInputString();
                        int carIdDel = carService.getIdByCarNumber(carNumberDel);
                        fixationService.deleteFixation(carIdDel);
                        break;
                    case "e":
                        break;
                    default:
                        System.err.println("Неправильный ввод");
                }

            } catch (NoSuchElementException e) {
                System.err.println("There is no such item: " + e.getMessage());
            } catch (IOException | SQLException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while(!mainInput.equals("e"));
    }
}
