package com.lab6;

import lab6.App;

import lab6.Supervisor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    @DisplayName("CORRECT STATE CHECK. IT WAS THE DIFFICULTIES TESTS IN MY LIFE")
    public void correctStateCheck1() throws InterruptedException {
        App app = new App("Madagaskar", 1000);
        Supervisor supervisor = new Supervisor(app);
        supervisor.start();
        supervisor.join();
        Assertions.assertEquals(App.StateOfTask.STOPPING, app.getState());
    }
    @Test
    public void correctStateCheck2() throws InterruptedException {
        App app = new App("Madagaskar", 1000);
        Supervisor supervisor = new Supervisor(app);
        supervisor.start();
        supervisor.join();
        Assertions.assertEquals(App.StateOfTask.STOPPING, app.getState());
    }
    @Test
    public void correctStateCheck3() throws InterruptedException {
        App app = new App("Madagaskar", 1000);
        Supervisor supervisor = new Supervisor(app);
        supervisor.start();
        supervisor.join();
        Assertions.assertEquals(App.StateOfTask.STOPPING, app.getState());
    }
    @Test
    public void correctStateCheck4() throws InterruptedException {
        App app = new App("Madagaskar", 1000);
        Supervisor supervisor = new Supervisor(app);
        supervisor.start();
        supervisor.join();
        Assertions.assertEquals(App.StateOfTask.STOPPING, app.getState());
    }
    @Test
    public void correctStateCheck5() throws InterruptedException {
        App app = new App("Madagaskar", 1000);
        Supervisor supervisor = new Supervisor(app);
        supervisor.start();
        supervisor.join();
        Assertions.assertEquals(App.StateOfTask.STOPPING, app.getState());
    }
}
