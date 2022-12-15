package com.it_academy.catalogOnlinerTests;

import org.testng.annotations.Test;

public class ParallelExecutionExampleTest {

    @Test
    public void testOne() {
        try {
            System.out.println("Test 1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTwo() {
        try {
            System.out.println("Test 2");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
