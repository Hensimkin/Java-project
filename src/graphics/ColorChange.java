package graphics;

import animal.*;
import mobility.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ColorChange extends JDialog implements ActionListener
{
    ColoredDecorator t;
    private JComboBox allAniaml;
    private JComboBox colors2;
    private JButton ok;
    private String type;
    private Animal animal;
    private int lionc=1,bearc=1,elephantc=1,giraffec=1,turtlec=1;
    private String f;
    private int i2;
    private ZooPanel1 zoo;


    public ColorChange(ZooPanel1 zoo)
    {
        String colors[]={"Natural","Blue","Red"};
        this.setLayout(new GridLayout(3,1));
        this.setSize(400,150);
        this.setVisible(true);
        this.setTitle("Animal Color");
        String[]animals=new String[zoo.getI()];
        Object ob;
        for (int i=0;i<zoo.getI();i++)
        {
            ob=ZooPanel1.array.get(i);
            if(ob instanceof Lion)
            {
                animals[i]=((Lion) ob).getName();
            }
            if(ob instanceof Bear)
            {
                animals[i]=((Bear) ob).getName();
            }
            if(ob instanceof Elephant)
            {
                animals[i]=((Elephant) ob).getName();
            }
            if(ob instanceof Giraffe)
            {
                animals[i]=((Giraffe) ob).getName();
            }
            if(ob instanceof Turtle)
            {
                animals[i]=((Turtle) ob).getName();
            }
        }
        JLabel labelAnimal=new JLabel("select animal");
        this.add(labelAnimal);
        allAniaml=new JComboBox(animals);
        allAniaml.addActionListener(this);
        this.add(allAniaml);
        JLabel coloranimal=new JLabel("Select animal color");
        this.add(coloranimal);
        colors2=new JComboBox(colors);
        colors2.addActionListener(this);
        this.add(colors2);
        JLabel finish=new JLabel("Press to finish");
        this.add(finish);
        ok=new JButton("Accept");
        this.add(ok);
        ok.addActionListener(this);
        this.zoo=zoo;
    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==ok)
        {
            String temp;
            type=(String)allAniaml.getSelectedItem();
            f=(String) colors2.getSelectedItem();
            for(int i=0;i<zoo.getI();i++)
            {
                if(Objects.equals(ZooPanel1.array.get(i).getName(), type))
                {
                    t=new ColoredDecorator(ZooPanel1.array.get(i));
                    t.setColor(f);
                    t.loadColor(ZooPanel1.array.get(i).gettype());
                    this.dispose();
                    break;
                }
            }
        }
    }
}
