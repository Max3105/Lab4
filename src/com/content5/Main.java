package com.content5;
import javax.swing.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
public class Main {

    public static void main(String[] args) {
      //  if(args.length==0) {
          //  System.out.println("Ошибка, потому что нет координат");
          //  System.exit(-1);
       // }
        // Зарезервировать места в массиве коэффициентов столько, сколько аргументов командной строки

        Double[] arguments = new Double[args.length];
        int i= 0;
        try{
            // Перебрать аргументы, пытаясь преобразовать их в Double
            for(String arg: args) {
                arguments[i++] = Double.parseDouble(arg);
            }
        }
        catch(NumberFormatException x) {
            // Если преобразование невозможно -сообщить об ошибке и завершиться
            System.out.println("Ошибка преобразования строки '"+ args[i] + "' в число типа Double");
            System.exit(-2);
        }
        i = 0;
        try{
            DataOutputStream out = new DataOutputStream(new FileOutputStream("Data1.bin"));

            for (i = 0;i < arguments.length;i++){
                out.writeDouble(arguments[i]);
                double y = arguments[i];
                out.writeDouble(y);
            }
        }
        catch (Exception ex){

        }

        // Создать и показать экземпляр главного окна приложения
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}