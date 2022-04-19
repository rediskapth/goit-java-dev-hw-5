package ua.goit.controller;

import ua.goit.controller.command.*;
import ua.goit.exception.ExitException;
import ua.goit.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetStoreController {
    private final View view;
    private final List<Command> commands;

    public PetStoreController(View view) {
        this.view = view;
        this.commands = new ArrayList<>(Arrays.asList(new Help(view),
                new Exit(view),
                new CreateOrder(view),
                new GetOrderById(view),
                new DeleteOrderById(view)
                ));
    }

    public void run() {
        view.write("Welcome to Pet Store");
        executeCommand();
    }

    private void executeCommand() {
        try {
            while (true) {
                view.write("Please, enter help to see available commands:");
                String input = view.read();
                boolean isIncorrectCommand = true;
                for (Command command : commands) {
                    if (command.canProcess(input)) {
                        command.process();
                        isIncorrectCommand = false;
                    }
                }
                if (isIncorrectCommand) {
                    view.write("Incorrect command. Please, try again.");
                }
            }
        } catch (ExitException e) {
            view.write("Good Bye!");
        }
    }
}
