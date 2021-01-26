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

    public static void changeColorViaAbosluteValue (ColorCode cc, int value)
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

    public static void changeColorViaRelativeValue (ColorCode cc, int value)
    {

    }

    public static int getRed()
    {

    }

    public static int getGreen()
    {

    }

    public static int getBlue()
    {

    }

    public static String getHex()
    {

    }

    public static void main(String[] args) {

    }

}
