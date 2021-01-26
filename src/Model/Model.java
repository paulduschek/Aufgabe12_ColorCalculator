/**
 * @author Paul Duschek
 * @version 1.0, 21.1.2021
 */

package Model;

public class Model {

    //Variable Definitions

    private ModularCounter red = new ModularCounter(0,256);
    private ModularCounter green = new ModularCounter(0,256);
    private ModularCounter blue = new ModularCounter(0,256);

    public Model(ModularCounter r, ModularCounter g, ModularCounter b)
    {
        this.red = r;
        this.green = g;
        this.blue = b;
    }


}
