package lesson5;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Data Access Layer
 */
public class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;

    }

    /**
     * Добавить сущность в проект
     *
     * @param entity
     */
    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    /**
     * Удалить сущность из проекта
     *
     * @param entity
     */
    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    /**
     * Получить список всех текстур
     *
     * @return
     */
    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                models.add((Texture) entity);
            }
        }
        return models;
    }

    /**
     * Получить список всех моделей
     *
     * @return
     */
    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    @Override
    public Texture getTexture(int i) {
        Collection<Texture> textures = getAllTextures();
        Texture resTexture = null;
        for (Texture texture : textures) {
            if (i == texture.getId()) {
                resTexture = texture;
            }
        }return resTexture;
    }

    @Override
    public Model3D getModel(int i) {
        Collection<Model3D> models = getAllModels();
        Model3D resModel = null;
        for (Model3D model : models) {
            if (i == model.getId()) {
                System.out.println(model.getId());
                resModel = model;
            }
        }return resModel;
    }
}
