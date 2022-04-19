package ua.goit;

import ua.goit.controller.PetStoreController;
import ua.goit.view.Console;
import ua.goit.view.View;

public class Application {

    public static void main(String[] args) {

        View view = new Console();
        PetStoreController controller = new PetStoreController(view);
        controller.run();
    }
}
