package lesson5;

public interface UILayer {

    void openProject(String fileName);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);
    void addNewModel(String modelName, int i);
    void addNewTexture(String textureName);
    void removeModel(int i);
    void removeTexture(int i);

}
