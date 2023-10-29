package lesson5;

import java.util.ArrayList;

public class Editor3D implements UILayer {


    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    /**
     * Полностью пересобираем внутренние компоненты системы (новый проект)
     */
    private void initialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }


    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void saveProject() {
        System.out.println("Изменения успешно сохранены.");
        database.save();
    }

    @Override
    public void showProjectSettings() {
        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");
    }

    @Override
    public void printAllModels() {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        // Предусловие
        checkProjectFile();

        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);

    }

    @Override
    public void renderModel(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);

    }

    @Override
    public void addNewModel(Model3D model) {
        // Предусловие
        checkProjectFile();
    }

    @Override
    public void addNewTexture(Texture texture) {
        // Предусловие
        checkProjectFile();
    }

    @Override
    public void removeModel(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");

    }

    @Override
    public void removeTexture(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        if (i < 0 || i > textures.size() - 1)
            throw new RuntimeException("Номер текстуры указан некорректно.");
    }

    private void checkProjectFile() {
        if (projectFile == null)
            throw new RuntimeException("Файл проекта не определен.");
    }


}
