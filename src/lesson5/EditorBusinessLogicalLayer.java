package lesson5;

import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess){
        this.databaseAccess = databaseAccess;
    }



    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model: getAllModels()) {
            processRender(model);
        }
    }

    @Override
    public void addModel(String modelName, Collection<Texture> texture) {
        Model3D newModel = new Model3D(modelName, texture);
        databaseAccess.addEntity(newModel);
    }

    @Override
    public void removeModel(Model3D model) {
        databaseAccess.removeEntity(model);
    }

    @Override
    public void addTexture(String textureName) {
        Texture newTexture = new Texture(textureName);
        databaseAccess.addEntity(newTexture);
    }

    @Override
    public void removeTexture(Texture texture) {
        databaseAccess.removeEntity(texture);
    }

    @Override
    public Model3D getModel(int i) {
        return databaseAccess.getModel(i);
    }

    @Override
    public Texture getTexture(int i) {
        return databaseAccess.getTexture(i);
    }

    private Random random = new Random();

    private void processRender(Model3D model){
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
