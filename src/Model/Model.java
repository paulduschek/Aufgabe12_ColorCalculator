/**
 * @author Paul Duschek
 * @version 1.0, 21.1.2021
 */

package Model;

public class Model {

    //Variable Definitions

    private static ModularCounter red = new ModularCounter(0,256);
    private static ModularCounter green = new ModularCounter(0,256);
    private static ModularCounter blue = new ModularCounter(0,256);

    public Model(ModularCounter r, ModularCounter g, ModularCounter b)
    {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public static void changeColorViaAbosluteValue (ColorCode cc, int value)        //nur eine Methode Kommentar
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

    public static void changeColorViaRelativeValue (ColorCode cc, String value)
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
            rValue = rValue + "0";
        }
        if(gValue.length() == 1)
        {
            gValue = gValue + "0";
        }
        if(bValue.length() == 1)
        {
            bValue = bValue + "0";
        }
        hashtag += rValue;
        hashtag += gValue;
        hashtag += bValue;

        return hashtag;
    }

    public static void main(String[] args) {

    }

}
