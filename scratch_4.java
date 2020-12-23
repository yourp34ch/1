package com.company;

import java.util.Calendar;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int choose=0;
        int mYear;
        int mPrice;
        Scanner in = new Scanner(System.in);

        Car[] carlist = new Car[]{
                new Car(1, "BMW", 1994, "black", 2300, 869735),  // 1st car
                new Car(2, "AUDI", 2002, "yellow", 4000, 869736), // 2nd car
                new Car(3, "Volvo", 1999, "green", 3300, 869737), // etc...
                new Car(4, "TOYOTA", 2002, "purple", 5000, 869738),
                new Car(5, "Ferrari", 2005, "red", 10000, 869739),
                new Car(6, "Ford", 1967, "yellow", 8800, 869739),
                new Car(7, "Aston Martin", 2009, "black", 18000, 869740),
                new Car(8, "Lada", 2013, "white", 1800, 869741),
                new Car(9, "Dodge", 2009, "white", 6700, 869742),
                new Car(10, "Mitsubishi", 2008, "red", 3200, 869743),
                new Car(11, "Volkswagen", 2016, "grey", 9000, 869744),
                new Car(12, "Lexus", 2014, "blue", 11000, 869745),
                new Car(13, "Mercedes-Benz", 2016, "black", 22000, 869746),
                new Car(14, "Jaguar", 2015, "grey", 24000, 869747),
                new Car(15, "Lamborghini", 2016, "silver", 30000, 869748)
        };

        System.out.println("\t\t\tMenu");
        System.out.println("1. All cars");
        System.out.println("2. Cars that in use more then n years");
        System.out.println("3. Cars of some period price of which is more then");
        System.out.println("4. Exit");
        while (choose!=4) {
            choose = in.nextInt();
            switch (choose) {

                case 1:
                    System.out.println("id\tbrand\tyear\tcolor\tprice\tregister number");
                    for (int i = 0; i < carlist.length; i++) {
                        System.out.println(carlist[i].toString());
                    }
                    break;

                case 2:
                    System.out.println("Enter the the period in years u are looking for");
                    mYear = in.nextInt();
                    for (int i = 0; i < carlist.length; i++) {
                        if (Calendar.YEAR - carlist[i].getYear() >= mYear) {
                            System.out.println(carlist[i].toString());
                        } else System.out.println("Nothing found");
                    }
                    break;

                case 3:
                    System.out.println("Enter the model year");
                    mYear=in.nextInt();
                    System.out.println("Enter the price");
                    mPrice = in.nextInt();
                    for (int i=0;i<carlist.length;i++){
                        if (carlist[i].getYear()==mYear && carlist[i].getPrice()>mPrice)
                            System.out.println(carlist[i].toString());
                        else System.out.println("No car found");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

class Car {
    int id;
    String brand;
    int year;
    String color;
    int price;
    int registerNumber;

    public Car(int id, String brand, int year, String color, int price, int registerNumber) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registerNumber = registerNumber;
    }

    public int getId() { return id; }

    public void setId(short id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Override
    public String toString() {
        return  id + '\t'
                + brand + '\t' +
                + year + '\t'
                + color + '\t' +
                + price + '\t' +
                registerNumber;
    }
}