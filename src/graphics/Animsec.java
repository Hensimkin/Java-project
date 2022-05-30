package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animsec extends JFrame implements ActionListener
{
    JButton carnivore;
    JButton herbivore;
    JButton omnivore;

    ZooPanel1 zoo;
    ZooFrame frame;
    Animsec(ZooPanel1 zoo,ZooFrame frame)
    {
        this.zoo=zoo;
        this.frame=frame;
        JLabel help=new JLabel();
        ImageIcon icon=new ImageIcon("about.jpeg");
        help.setIcon(icon);
        help.setBounds(150,25,200,100);
        this.setLayout(null);
        this.setSize(400,250);
        this.setVisible(true);
        this.setTitle("Animal Type");
        carnivore=new JButton("Carnivore");
        carnivore.setBounds(10,150,100,40);
        carnivore.addActionListener(this);
        this.add(carnivore);
        herbivore=new JButton("Herbivore");
        herbivore.setBounds(130,150,100,40);
        herbivore.addActionListener(this);
        this.add(herbivore);
        omnivore=new JButton("Omnivore");
        omnivore.setBounds(250,150,100,40);
        omnivore.addActionListener(this);
        this.add(omnivore);
        this.add(help);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==carnivore)
        {
            //frame.setType1("carnivore");
            //String s="carnivore";
            new AddAnimalDialog(zoo, frame,"carnivore");
            dispose();
        }

        if(e.getSource()==herbivore)
        {
            //frame.setType1("herbivore");
            new AddAnimalDialog(zoo, frame,"herbivore");
            dispose();
        }
        if(e.getSource()==omnivore)
        {
            //frame.setType1("omnivore");
            new AddAnimalDialog(zoo, frame,"omnivore");
            dispose();
        }
    }
}
