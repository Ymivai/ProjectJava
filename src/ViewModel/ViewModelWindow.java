package ViewModel;

import Model.Calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewModelWindow {
    private JPanel panel1;
    private JList list1;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField2;
    private JButton computeButton;
    private JButton closeButton;
    private JButton eraseButton;
    private ArrayList<Calc> Numbers;
    private DefaultListModel ListNumbers;


    public ViewModelWindow()
    {
        /*
        Кнопка подсчета всех вариаций числа в степени от First и до Second и проверки условий
        */
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ConvertModel(textField1.getText(), textField2.getText(), textField3.getText())){
                    Numbers = new ArrayList<Calc>();
                    ListNumbers = new DefaultListModel();
                    if(Long.parseLong(textField1.getText()) <= Long.parseLong(textField3.getText())){
                        for (long i = Long.parseLong(textField1.getText()); i < Long.parseLong(textField3.getText()) + 1; i++)
                            Numbers.add(new Calc(i, Long.parseLong(textField2.getText())));
                        for(Calc number: Numbers)
                            ListNumbers.addElement(number.GetModel());

                        list1.setModel(ListNumbers);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Первая степень не может быть больше второго");
                }
                else
                    JOptionPane.showMessageDialog(null, "Текстовые поля пустие или имеют не верный формат");

            }
        });
        closeButton.addActionListener(new ActionListener() {    //Кнопка закрытия приложения
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        eraseButton.addActionListener(new ActionListener() {        //Кнопка для очистки полей кроме списка
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Window");
        frame.setContentPane(new ViewModelWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static boolean ConvertModel(String txt1, String txt2, String txt3){      //Метод для проверки возможности конвертации
        try {
            Long.parseLong(txt1);
            Long.parseLong(txt2);
            Long.parseLong(txt3);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
