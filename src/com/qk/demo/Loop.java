package com.qk.demo;

import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Loop {
    
    public static void main(String[] args) throws IOException, InterruptedException {
            
            int j = 0;
            
            for (int i = 1; i > j; i++) {
                JUnitCore junit = new JUnitCore();
                Result resultone = junit.run(TataMotorsConnectDemo.class);
                Thread.sleep(10000);
                /*Result resultwo = junit.run(KotakBankMobileAndroidTwo.class);
                Thread.sleep(10000);*/
                /*Result resultthree = junit.run(BTPNBankSinayaMobileBillPaymentandTopup.class);
                Thread.sleep(5000);
                Result resultfour = junit.run(BTPNBankSinayaMobileTransfertoBTPN.class);
                Thread.sleep(5000);*/
                /*Result resultfive = junit.run(KotakBankViewManageBiller2.class);
                Thread.sleep(5000);
                Result resultsix = junit.run(KotakBankTermDepositCalculator.class);
                Thread.sleep(5000);
                /*Result resultseven = junit.run(KotakBankViewManageBiller2.class);
                Thread.sleep(5000);*/
                for (Failure failure : resultone.getFailures()) {
                      System.out.println(failure.toString());
                    }
                /*for (Failure failure : resultwo.getFailures()) {
                      System.out.println(failure.toString());
                    }*/
//                for (Failure failure : resultthree.getFailures()) {
//                      System.out.println(failure.toString());
//                    }
//                for (Failure failure : resultfour.getFailures()) {
//                      System.out.println(failure.toString());
//                    }
                /*for (Failure failure : resultfive.getFailures()) {
                      System.out.println(failure.toString());
                    }
                for (Failure failure : resultsix.getFailures()) {
                      System.out.println(failure.toString());
                    }
                /*for (Failure failure : resultseven.getFailures()) {
                      System.out.println(failure.toString());
                    }*/
                try {Thread.sleep(5000);}
                catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                }
            
    }
}