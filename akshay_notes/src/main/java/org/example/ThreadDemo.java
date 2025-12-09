package org.example;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread myDownload=new DownloadThread();
        myDownload.start();
        try {
            myDownload.join();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted "+e.getMessage());
        }

    }
}

class DownloadThread extends Thread{
    public void run(){
        System.out.println("Download Started");
        for(int i=1;i<=5;i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i * 2 + "0% completed ....");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Donwload completed");
    }
}