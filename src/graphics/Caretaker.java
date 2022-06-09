package graphics;

import animal.Animal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Caretaker
{
    private ArrayList<Memento> mementos= new ArrayList<>();

    private ZooPanel1 zoo;
    private Queue<Animal> queue2=new LinkedList<Animal>();

    public Caretaker(ZooPanel1 zoo)
    {
        this.zoo=zoo;
    }

    public void save(Memento saved)
    {
        if(mementos.size()<3)
        {
            this.mementos.add(saved);
        }
        else
        {
            this.mementos.remove(0);
            this.mementos.add(saved);
        }
    }

    public Memento restore()
    {
        return this.mementos.remove(this.mementos.size()-1);
    }


    public void restorestate() throws CloneNotSupportedException
    {
        Animal a;
        for(int i = 0; i<ZooPanel1.array.size(); i++)
        {
            ZooPanel1.array.get(i).setFlag(false);
        }
        for(int i = 0; i<zoo.retque().size(); i++)
        {
            a= (Animal) zoo.retque().poll();
            a.setFlag(false);
            zoo.queue.add(a);
        }

        if (mementos.get(0).getAnimals().size()!=0)
        {
            for (int i = 0; i < ZooPanel1.array.size(); i++)
            {
                ZooPanel1.array.get(i).setFlag(false);
            }
            ZooPanel1.array.removeAll(ZooPanel1.array);
            int size=mementos.get(0).getAnimals().size();
            for(int i=0;i<size;i++)
            {
                ZooPanel1.array.add((Animal) mementos.get(0).getAnimals().get(i).clone());
                zoo.updatetrd(ZooPanel1.array.get(i));
            }
            zoo.setI(ZooPanel1.array.size());
            //ZooPanel1.array.addAll(mementos.get(0).getAnimals());

        }
        if(this.mementos.get(0).getQueue().size()!=0)
        {
            for (int i = 0; i < zoo.queue.size(); i++)
            {
                zoo.queue.poll().setFlag(false);
            }
            while(!this.mementos.get(0).getQueue().isEmpty())
            {
                a=this.mementos.get(0).getQueue().poll();
                zoo.queue.add(a);
                zoo.updatetrd(a);
            }
        }


        if (this.mementos.get(0).getMeat()!=null)
        {
            zoo.setPlant(null);
            zoo.meat=mementos.get(0).getMeat();
            //zoo.repaint();
        }
        if (this.mementos.get(0).getPlant()!=null)
        {
            zoo.meat=null;
            zoo.setPlant(mementos.get(0).getPlant());
            //zoo.repaint();
        }
        zoo.repaint();
    }
}
