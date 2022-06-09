package graphics;


import animal.Animal;
import graphics.ZooPanel1;
import meat.Meat;
import plants.Plant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Memento
{
    private ArrayList<Animal> array = new ArrayList<Animal>();
    private Queue<Animal> queue=new LinkedList<Animal>();
    private Plant plant;
    private Meat meat;
    private Animal animal;

    public Memento(Queue<Animal> queue,Plant plant,Meat meat) throws CloneNotSupportedException {
        if(ZooPanel1.array.size()!=0)
        {
            for(int i=0;i<ZooPanel1.array.size();i++)
            {
                this.animal= (Animal) ZooPanel1.array.get(i).clone();
                this.array.add(this.animal);
            }
        }
        if(queue.size()!=0)
        {
            for(int i=0;i<queue.size();i++)
            {
                this.animal= (Animal) queue.poll().clone();
                this.queue.add(this.animal);
                queue.add(this.animal);
            }
        }
        if(plant!=null)
        {
            this.plant= (Plant) plant.clone();
        }
        if(meat!=null)
        {
            this.meat= (Meat) meat.clone();
        }
    }

    public ArrayList<Animal> getAnimals()
    {
        return this.array;
    }


    public Queue<Animal>getQueue()
    {
        return this.queue;
    }

    public Plant getPlant()
    {
        return this.plant;
    }

    public Meat getMeat()
    {
        return this.meat;
    }


}