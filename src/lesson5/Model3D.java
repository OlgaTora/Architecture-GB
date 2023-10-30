package lesson5;

import java.util.ArrayList;
import java.util.Collection;

public class Model3D implements Entity {
    {
        id = ++counter;
    }
    //region Constructor

    public Model3D(String modelName, Collection<Texture> textures) {
        this.modelName = modelName;
        this.textures = textures;
    }

    public Model3D() {
    }
    //endregion
    //region Properties

    public Collection<Texture> getTextures() {
        if (textures == null) {
            textures = new ArrayList<>();
        }
        return textures;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("3DModel %s, #%s", modelName, id);
    }

    //endregion
    //region Fields
    private static int counter = 10000;
    private int id;
    String modelName;
    private Collection<Texture> textures;
    //endregion
}
