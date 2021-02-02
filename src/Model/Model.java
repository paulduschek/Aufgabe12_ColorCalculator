/**
 * @author Paul Duschek
 * @version 1.0, 21.1.2021
 */

package Model;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Model {

    //Variable Definitions

    private static ModularCounter red = new ModularCounter(0,256);
    private static ModularCounter green = new ModularCounter(0,256);
    private static ModularCounter blue = new ModularCounter(0,256);

    /*public Model(ModularCounter r, ModularCounter g, ModularCounter b)  Konstruktor vorhanden, wegen des UML Models jedoch nicht verwendet
    {
        this.red = r;
        this.green = g;
        this.blue = b;
    }*/

    public static void changeColorViaAbsoluteValue(ColorCode cc, int value)        //für changeColorViaAbsoluteValue habe ich nur eine Methode mit dem Wrt int value geschrieben, da ich dies für sinnvoller gehalten habe
    {
        switch (cc)
        {
            case RED:
                red.reset();        //red is set to zero
                red.inc(value);
                break;

            case GREEN:
                green.reset();      //green is set to zero
                green.inc(value);
                break;

            case BLUE:
                blue.reset();       //blue is set to zero
                blue.inc(value);
                break;
        }
    }

    public static void changeColorViaRelativeValue (ColorCode cc, String value)         //auch hier habe ich trotz der Angabe im UML Diagramm nur eine Methode geschreiben jedoch mit einem String value keinem int
    {
        if (value.equals("+10"))
        {
            switch (cc)
            {
                case RED:
                    red.inc(10);        //red increased by 10
                    break;

                case GREEN:
                    green.inc(10);
                    break;

                case BLUE:
                    blue.inc(10);
                    break;
            }
        }
        else
        {
            switch (cc)
            {
                case RED:
                    red.dec(10);    //red decreased by 10
                    break;

                case GREEN:
                    green.dec(10);
                    break;

                case BLUE:
                    blue.dec(10);
                    break;
            }
        }
    }

    public static int getRed()
    {
        return red.getValue();
    }

    public static int getGreen()
    {
        return green.getValue();
    }

    public static int getBlue()
    {
        return blue.getValue();
    }

    public static String getHex()
    {
        String hashtag = "#";
        String rValue = Integer.toHexString(getRed());
        String gValue = Integer.toHexString(getGreen());
        String bValue = Integer.toHexString(getBlue());

        if(rValue.length() == 1)
        {
            rValue = "0" + rValue;
        }
        if(gValue.length() == 1)
        {
            gValue = "0" + gValue;
        }
        if(bValue.length() == 1)
        {
            bValue = "0" + bValue;
        }
        hashtag += rValue;
        hashtag += gValue;
        hashtag += bValue;

        return hashtag;
    }

    public static void loadFromFile()
    {
        try
        {
            FileReader fr = new FileReader("color.txt");
            BufferedReader br = new BufferedReader(fr);

            if(br.readLine().equals("Color File Format 1.0"))
            {
                changeColorViaAbsoluteValue(ColorCode.RED, Integer.parseInt(br.readLine()));
                changeColorViaAbsoluteValue(ColorCode.GREEN, Integer.parseInt(br.readLine()));
                changeColorViaAbsoluteValue(ColorCode.BLUE, Integer.parseInt(br.readLine()));
            }
            br.close();
        }
        catch (Exception ex)
        {
            System.out.printf("Error: %s%n",ex.getMessage());
        }
    }

    public static void saveToFile()
    {
        try
        {
            FileWriter fw = new FileWriter("color.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Color File Format 1.0");
            bw.write(System.lineSeparator());
            bw.write(getRed());
            bw.write(System.lineSeparator());
            bw.write(getGreen());
            bw.write(System.lineSeparator());
            bw.write(getBlue());

            bw.close();
        }
        catch (Exception ex)
        {
            System.out.printf("Error: %s%n",ex.getMessage());
        }
    }

    public static void main(String[] args) {
        //Variable Definition
        boolean isRunning = true;

        //Scanner Definition
        Scanner sc = new Scanner(System.in);

        while (isRunning == true)
        {
            System.out.printf("1: Print color value %n2: set color for red, green or blue %n3: + or - value 10 for red, green or blue %nType something other to Quit%n");
            int selection = sc.nextInt();
            switch (selection)
            {
                case 1:
                    System.out.println(getHex());

                case 2:
                    System.out.println("Type a value for red, green and blue between 0 and 255");
                    System.out.println("Value for Red:");
                    int scannerRed = sc.nextInt();
                    if (scannerRed >= 0) {
                        changeColorViaAbsoluteValue(ColorCode.RED, scannerRed);
                    }
                    System.out.println("Value for Green:");
                    int scannerGreen = sc.nextInt();
                    if(scannerGreen >= 0)
                    {
                        changeColorViaAbsoluteValue(ColorCode.GREEN, scannerGreen);
                    }
                    System.out.println("Value for Blue:");
                    int scannerBlue = sc.nextInt();
                    if(scannerBlue >= 0)
                    {
                        changeColorViaAbsoluteValue(ColorCode.BLUE, scannerBlue);
                    }
                    System.out.printf("Hexvalue: %s %n",getHex());
                    break;

                case 3:
                    System.out.println("Which value should be changed? r for Red, g for Green, b for Blue");
                    String c = sc.next();
                    System.out.println("Should the value be incremented or decremented? +10 or -10");
                    String txt = sc.next();

                    if(c.contains("r"))
                    {
                        changeColorViaRelativeValue(ColorCode.RED, txt);
                    }
                    else if(c.contains("g"))
                    {
                        changeColorViaRelativeValue(ColorCode.GREEN, txt);
                    }
                    else
                    {
                        changeColorViaRelativeValue(ColorCode.BLUE, txt);
                    }

                    System.out.printf("Hexvalue: %s %n",getHex());
                    break;

                default:
                    isRunning = false;
            }
        }
    }

}
