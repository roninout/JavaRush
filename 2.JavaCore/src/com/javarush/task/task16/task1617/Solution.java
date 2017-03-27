package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 7;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        clock.start();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            String out = "";
            int oldValue = countSeconds;
            try
            {
                while (!isInterrupted())
                {
                    out += countSeconds + " ";
                    System.out.println(out);
                    countSeconds--;
                    Thread.sleep(1000);
                    if (countSeconds < 1)
                    {
                        if (oldValue > 3) this.interrupt();
                        System.out.print(out + "Марш!");
                        break;
                    }
                }
            }
            catch (InterruptedException e){
                System.out.print(out + "Прервано!");
            }
        }
    }
}
