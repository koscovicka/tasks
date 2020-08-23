package com.caffe.task;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Scanner;

@Service
public class Machine {

    private final Calculator calculator;
    private final Double[] menu;
    private double menuPrice;
    private String insertedPayment;

    public Machine() {
        this.menu = new Double[10];
        menu[0] = 2d;
        menu[1] = 2.22;
        menu[2] = 0.02;
        menu[3] = 1.49;
        menu[4] = 1.99;
        menu[5] = 0.99;
        menu[6] = 3.33;
        menu[7] = 1.01;
        menu[8] = 0.11;
        menu[9] = 0.77;
        calculator = new Calculator();
    }

    public void pickFromMenu() {
        final int menuIndex = new Random().nextInt(10);
        menuPrice = menu[menuIndex];
        System.out.println("\nYou should pay: " + menuPrice + " because you choose menu number: " + menuIndex + ". Great choice!");
    }

    public void insertPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPlease insert your payment: ");
        insertedPayment = sc.nextLine();
    }

    public void exchange() {

        if (!isValid(insertedPayment)) {
            System.out.println("We are very sorry you did not receive your drink. More luck next time :) ");
            return;
        }

        double payment = Double.parseDouble(insertedPayment);

        if (payment < menuPrice) {
            System.out.println("You do not insert enough money, so you can not receive your drink.");
            return;
        }

        if (payment == menuPrice) {
            System.out.println("Thank you for using our caffe machine. \nHave a nice day with your drink :)");
            return;
        }

        System.out.println("Your change: ");

        calculator.calculateExchange(menuPrice, payment);

        System.out.println("\nThank you for using our caffe machine. \nHave a nice day with your drink :)");

    }

    private boolean isValid(String insertedPayment) {
        double payment;
        try {
            payment = Double.parseDouble(insertedPayment);
        } catch (NumberFormatException e) {
            System.out.println("Insert double value of your payment, please!");
            return false;
        } catch (NullPointerException e) {
            System.out.println("We are not able to load your payment. Are you sure that you don't use fake money? :D");
            return false;
        }
        if (payment < 0) {
            System.out.println("Caffe machine is not a bank !!! Insert positive value, please :P");
            return false;
        }
        return true;
    }

}
