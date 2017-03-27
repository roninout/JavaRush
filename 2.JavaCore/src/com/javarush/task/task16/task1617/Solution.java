package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 5;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try
            {
                while (countSeconds > 0)
                {
                    Thread.sleep(1000);
                    System.out.print(countSeconds-- + " ");
                }
                System.out.println("Марш!");
            }
            catch (InterruptedException e)
            {
                while (countSeconds > 0)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.print(countSeconds-- + " ");
                }
                System.out.print("Прервано!");
            }
        }
    }
}
