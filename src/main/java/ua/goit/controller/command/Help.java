package ua.goit.controller.command;

import ua.goit.view.View;

import static ua.goit.controller.command.Commands.*;

public class Help implements Command {
    private final View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(HELP.getName());
    }

    @Override
    public void process() {
        view.write("Enter " + CREATE_ORDER.getName() + " to place an order for a pet (work)");
        view.write("Enter " + GET_ORDER_BY_ID.getName() + " to find an order by ID (work)");
        view.write("Enter " + DELETE_ORDER_BY_ID.getName() + " to delete an order by ID (work)");
        view.write("Enter " + CREATE_PET.getName() + " to add a new pet to the store");
        view.write("Enter " + UPDATE_PET.getName() + " to update a pet");
        view.write("Enter " + GET_PET_BY_STATUS.getName() + " to find pets by status");
        view.write("Enter " + GET_PET_BY_ID.getName() + " to find a pet by ID");
        view.write("Enter " + DELETE_PET_BY_ID.getName() + " to delete a pet by ID");
        view.write("Enter " + CREATE_USER_WITH_LIST.getName() + " to create list of users");
        view.write("Enter " + GET_USER_BY_USERNAME.getName() + " to get user by user name");
        view.write("Enter " + UPDATE_USER.getName() + " to update user");
        view.write("Enter " + DELETE_USER.getName() + " to delete user");
        view.write("Enter " + LOGIN_USER.getName() + " to lod user into the system");
        view.write("Enter " + LOGOUT_USER.getName() + " to log out current logged in user session");
        view.write("Enter " + CREATE_USER.getName() + " to create user");
        view.write("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        view.write("Enter " + HELP.getName() + " to see available commands (work)");
        view.write("Enter " + EXIT.getName() + " to exit (work)");
    }
}
