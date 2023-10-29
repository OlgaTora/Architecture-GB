package lesson5;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();

    void addModel(Model3D model);

    void removeModel(Model3D model);

    void addTexture(Texture texture);

    void removeTexture(Texture texture);
    Model3D getModel(int i);
    Texture getTexture(int i);

}
