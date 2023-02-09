public interface Button {
    void paint();
}

public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}

public interface Checkbox {
    void paint();
}

public class MacOSCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}

public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

private static Application configureApplication() {
    Application app;
    GUIFactory factory;
    String osName = System.getProperty("os.name").toLowerCase();
    if (osName.contains("mac")) {
        factory = new MacOSFactory();
    } else {
        factory = new WindowsFactory();
    }
    app = new Application(factory);
    return app;
}

public static void main(String[] args) {
    Application app = configureApplication();
    app.paint();
}
}