package com.caffe.task;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class Calculator implements Calculator_IF {

    @Override
    public void calculateExchange(double menuPrice, double payment) {

        double change = Math.round((payment - menuPrice) * 100.0) / 100.0;
        System.out.println("You will get back: " + change + " EUR.");

        if (change >= 2) {
            int coinCount = (int) (change / 2);
            System.out.println("2 EUR coin count: " + coinCount);
            change = Math.round((change % 2) * 100.0) / 100.0;
        }

        if (change >= 1) {
            int coinCount = (int) (change / 1);
            System.out.println("1 EUR coin count: " + coinCount);
            change = Math.round((change % 1) * 100.0) / 100.0;
        }

        if (change >= 0.5) {
            int coinCount = (int) (change / 0.5);
            System.out.println("50 CENT coin count: " + coinCount);
            change = Math.round((change % 0.5) * 100.0) / 100.0;
        }

        if (change >= 0.2) {
            int coinCount = (int) (change / 0.2);
            System.out.println("20 CENT coin count: " + coinCount);
            change = Math.round((change % 0.2) * 100.0) / 100.0;
        }

        if (change >= 0.1) {
            int coinCount = (int) (change / 0.1);
            System.out.println("10 CENT coin count: " + coinCount);
            change = Math.round((change % 0.1) * 100.0) / 100.0;
        }

        if (change >= 0.05) {
            int coinCount = (int) (change / 0.05);
            System.out.println("5 CENT coin count: " + coinCount);
            change = Math.round((change % 0.05) * 100.0) / 100.0;
        }

        if (change >= 0.02) {
            int coinCount = (int) (change / 0.02);
            System.out.println("2 CENT coin count: " + coinCount);
            change = Math.round((change % 0.02) * 100.0) / 100.0;
        }

        if (change >= 0.01) {
            int coinCount = (int) (change / 0.01);
            System.out.println("1 CENT coin count: " + coinCount);
        }
    }
}
