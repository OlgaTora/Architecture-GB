package lesson1.store;

import lesson1.store.inmemorymodel.CustomService1;
import lesson1.store.inmemorymodel.CustomService2;
import lesson1.store.inmemorymodel.CustomService3;
import lesson1.store.inmemorymodel.ModelStore;

public class Program {

    public static void main(String[] args) {

        CustomService1 observer1 = new CustomService1();
        CustomService2 observer2 = new CustomService2();
        CustomService3 observer3 = new CustomService3();


        ModelStore modelStore = new ModelStore();
        modelStore.registerModelChanger(observer1);
        modelStore.registerModelChanger(observer2);
        modelStore.registerModelChanger(observer3);


    }

}
