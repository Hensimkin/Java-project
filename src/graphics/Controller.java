package graphics;

import animal.*;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Controller extends Thread implements Observer ,Runnable
{
    private ZooPanel1 zoo;
    public Controller(ZooPanel1 zoo)
    {
        this.zoo=zoo;
    }
    @Override
    public synchronized void update(Observable o, Object arg)
    {
        notify();
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (this)
            {
                try
                {
                    System.out.println("waiting");
                    wait();
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.zoo.getZoo().manageZoo();
        }
    }


    public synchronized void not()
    {
        this.notify();
    }
}
