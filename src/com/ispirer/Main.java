package com.ispirer;

import com.ispirer.utils.Counter;
import com.ispirer.utils.ListUsr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {

        //Localization
        Locale localeEn = Locale.US;
        Locale localeRu = new Locale("ru");
        ResourceBundle rbEn = ResourceBundle.getBundle("com/ispirer/locale", localeEn);

        //Instances
        JFrame frame = new JFrame();
        JLabel labelMessage = new JLabel();
        JLabel labelCounter = new JLabel();
        JLabel labelCounterAmount = new JLabel();
        JLabel labelList = new JLabel();
        JLabel labelListAmount = new JLabel();
        JButton buttonMessage = new JButton();
        JButton buttonEnglish = new JButton();
        JButton buttonRussian = new JButton();
        JButton buttonCounter = new JButton();
        JButton buttonListAdd = new JButton();

        ListUsr list = new ListUsr();

        //Frame
        frame.setVisible(true);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setTitle("Ispirer test");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setLayout(null);

        //Message label
        labelMessage.setText(rbEn.getString("lang.popup_message"));
        labelMessage.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelMessage.setHorizontalAlignment(JLabel.LEFT);
        labelMessage.setVerticalAlignment(JLabel.TOP);
        labelMessage.setBounds(20, 30,500, 200);
        frame.add(labelMessage);

        //Message button
        final String[] popupMessage = {rbEn.getString("lang.alert")};
        buttonMessage.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, popupMessage[0]);
            }
        });
        buttonMessage.setText(rbEn.getString("lang.button_message"));
        buttonMessage.setBounds(20, 70, 100, 30 );
        frame.add(buttonMessage);

        //Button Russian
        buttonRussian.setBounds(880, 30, 60, 20 );
        buttonRussian.setText(rbEn.getString("lang.ru"));
        frame.add(buttonRussian);

        buttonRussian.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               Locale.setDefault(localeRu);
               ResourceBundle rbRu = ResourceBundle.getBundle("com/ispirer/locale", localeRu);

               labelMessage.setText(rbRu.getString("lang.popup_message"));
               labelCounter.setText(rbRu.getString("lang.label_counter"));
               labelList.setText(rbRu.getString("lang.label_list"));
               buttonMessage.setText(rbRu.getString("lang.button_message"));
               buttonCounter.setText(rbRu.getString("lang.button_message"));
               buttonListAdd.setText(rbRu.getString("lang.button_message"));
               buttonRussian.setText(rbRu.getString("lang.ru"));
               buttonEnglish.setText(rbRu.getString("lang.en"));
               popupMessage[0] = rbRu.getString("lang.alert");
            }
        });

        //Button English
        buttonEnglish.setBounds(800, 30, 60, 20 );
        buttonEnglish.setText(rbEn.getString("lang.en"));
        frame.add(buttonEnglish);

        buttonEnglish.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Locale.setDefault(localeEn);
                ResourceBundle rbRu = ResourceBundle.getBundle("com/ispirer/locale", localeEn);


                labelMessage.setText(rbEn.getString("lang.popup_message"));
                labelCounter.setText(rbEn.getString("lang.label_counter"));
                labelList.setText(rbEn.getString("lang.label_list"));
                buttonMessage.setText(rbEn.getString("lang.button_message"));
                buttonCounter.setText(rbEn.getString("lang.button_message"));
                buttonRussian.setText(rbEn.getString("lang.ru"));
                buttonEnglish.setText(rbEn.getString("lang.en"));
                buttonListAdd.setText(rbEn.getString("lang.button_message"));
                popupMessage[0] = rbEn.getString("lang.alert");
            }
        });

        //Counter
        //Counter label
        labelCounter.setText(rbEn.getString("lang.label_counter"));
        labelCounter.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelCounter.setHorizontalAlignment(JLabel.LEFT);
        labelCounter.setVerticalAlignment(JLabel.TOP);
        labelCounter.setBounds(20, 200,500, 200);
        frame.add(labelCounter);

        //Counter amount label

        labelCounterAmount.setText(Integer.toString(Counter.getCount()));
        labelCounterAmount.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelCounterAmount.setHorizontalAlignment(JLabel.LEFT);
        labelCounterAmount.setVerticalAlignment(JLabel.TOP);
        labelCounterAmount.setBounds(600, 200,500, 200);
        frame.add(labelCounterAmount);

        //Counter button
        buttonCounter.setText(rbEn.getString("lang.button_message"));
        buttonCounter.setBounds(20, 240, 100, 30 );
        frame.add(buttonCounter);

        buttonCounter.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(new Counter());
                labelCounterAmount.setText(Integer.toString(Counter.getCount()));
            }
        });


        //ListUsr
        //ListUsr label
        labelList.setText(rbEn.getString("lang.label_counter") + " " + list.capacityChanged());
        labelList.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelList.setHorizontalAlignment(JLabel.LEFT);
        labelList.setVerticalAlignment(JLabel.TOP);
        labelList.setBounds(20, 400,500, 200);
        frame.add(labelList);

        //ListUsr list
        labelListAmount.setText(Integer.toString(list.getSize()));
        labelListAmount.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelListAmount.setHorizontalAlignment(JLabel.LEFT);
        labelListAmount.setVerticalAlignment(JLabel.TOP);
        labelListAmount.setBounds(600, 400,500, 200);
        frame.add(labelListAmount);

        //ListUsr Add button
        buttonListAdd.setText(rbEn.getString("lang.button_message"));
        buttonListAdd.setBounds(20, 440, 100, 30 );
        frame.add(buttonListAdd);

        buttonListAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) { ;
                labelListAmount.setText(String.valueOf(list.getSize()) + " " + list.capacityChanged());
            }
        });
    }


}
