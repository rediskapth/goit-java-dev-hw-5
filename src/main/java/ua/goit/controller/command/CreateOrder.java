package ua.goit.controller.command;

import ua.goit.httpUtils.StoreHttpUtil;
import ua.goit.model.Order;
import ua.goit.model.OrderStatus;
import ua.goit.view.View;

import java.time.LocalDateTime;

import static ua.goit.controller.command.Commands.CREATE_ORDER;

public class CreateOrder implements Command {
    private View view;

    public static LocalDateTime date = LocalDateTime.now();
    public static String dateNow = date.toString();

    public CreateOrder(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(CREATE_ORDER.getName());
    }

    @Override
    public void process() {
        view.write("Enter pet id:");
        long petId = 0;
        while (true) {
            try {
                petId = Long.parseLong(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Please, enter correct number:");
            }
        }
        view.write("Enter quantity:");
        int quantity = 0;
        while (true) {
            try {
                quantity = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Please, enter correct number:");
            }
        }
        String shipDate = dateNow;
        OrderStatus status = OrderStatus.PLACED;
        boolean complete = true;

        Order order = new Order(petId, quantity, shipDate, status, complete);
        StoreHttpUtil.createOrder(order);
        view.write("Order created.");
    }
}
