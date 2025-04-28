// Abstract class defining the template method
abstract class Beverage {
    // Template method - defines the algorithm for preparing a beverage
    public final void prepareRecipe() {
        boilWater();
        brew();              // abstract step to brew or steep
        pourInCup();
        addCondiments();     // abstract step to add condiments
    }

    // Common steps with default implementations:
    private void boilWater() {
        System.out.println("Boiling water");
    }
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps that will be supplied by subclasses:
    protected abstract void brew();
    protected abstract void addCondiments();
}

// Concrete subclass for Tea
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }
    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete subclass for Coffee
class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }
    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Using the Template Method
public class CafeApp {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();
        System.out.println("Making tea...");
        tea.prepareRecipe();      // will execute steps, some handled by Tea
        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();   // will execute steps, some handled by Coffee
    }
}
