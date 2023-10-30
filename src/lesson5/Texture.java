package lesson5;

public class Texture implements Entity {
    {
        id = ++counter;
    }
    //region Constructor

    public Texture(String textureName) {
        this.textureName = textureName;
    }

    public Texture() {
    }


    //endregion
    //region Properties
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture %s, #%s", textureName, id);
    }

    //endregion
    //region Fields
    private static int counter = 50000;
    private String textureName;
    private int id;

    //endregion
}
