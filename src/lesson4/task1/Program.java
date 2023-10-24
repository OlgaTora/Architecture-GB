package lesson4.task1;

public class Program {

    public static void main(String[] args) {
        FactoryProvider factoryProvider = new FactoryProvider();
        DealerProvider dealerProvider = new DealerProvider(factoryProvider);

        try{
            ComponentInfo componentInfo = dealerProvider.getComponent(901000);
            if (componentInfo != null){
                System.out.println(componentInfo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
