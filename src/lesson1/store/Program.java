package lesson1.store;

import lesson1.store.inmemorymodel.CustomService1;
import lesson1.store.inmemorymodel.CustomService2;
import lesson1.store.inmemorymodel.CustomService3;
import lesson1.store.inmemorymodel.ModelStore;
import lesson1.store.modelelements.*;

import java.util.ArrayList;
import java.util.Collection;

public class Program {

    public static void main(String[] args) {
        Texture texture1 = new Texture("texture 1");
        Texture texture2 = new Texture("texture 2");
        Point3D points1 = new Point3D(1,1,1);
        Point3D points2 = new Point3D(2,2,2);
        Point3D points3 = new Point3D(3,3,3);
        Poligon poligon = new Poligon();
        Flash flash = new Flash(points1, "green", 100.0);
        Camera camera = new Camera(points2);
        Scene scene = new Scene();

        CustomService1 observer1 = new CustomService1();
        CustomService2 observer2 = new CustomService2();
        CustomService3 observer3 = new CustomService3();

        ModelStore modelStore = new ModelStore();
        modelStore.registerModelChanger(observer1);
        modelStore.registerModelChanger(observer2);
        modelStore.registerModelChanger(observer3);
    }

}
