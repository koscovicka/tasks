package com.caffe;

import com.caffe.task.Machine;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class CaffeApplication implements CommandLineRunner {

    private final Machine coffeMachine;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CaffeApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 5; i++) {
            coffeMachine.pickFromMenu();
            coffeMachine.insertPayment();
            coffeMachine.exchange();
        }
    }

}
