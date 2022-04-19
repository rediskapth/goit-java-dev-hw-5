package ua.goit.controller.command;

public enum Commands {
    CREATE_ORDER("createOrder"),
    GET_ORDER_BY_ID("getOrderById"),
    DELETE_ORDER_BY_ID("deleteOrderById"),
    CREATE_PET("createPet"),
    UPDATE_PET("updatePet"),
    GET_PET_BY_STATUS("getPetByStatus"),
    GET_PET_BY_ID("getPetById"),
    DELETE_PET_BY_ID("deletePetById"),
    CREATE_USER_WITH_LIST("createUserWithList"),
    GET_USER_BY_USERNAME("getUserByUsername"),
    UPDATE_USER("updateUser"),
    DELETE_USER("deleteUser"),
    LOGIN_USER("loginUser"),
    LOGOUT_USER("logoutUser"),
    CREATE_USER("createUser"),
    HELP("help"),
    EXIT("exit");

    private String name;

    Commands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
