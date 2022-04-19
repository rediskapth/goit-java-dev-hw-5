package ua.goit.controller.command;

import ua.goit.httpUtils.StoreHttpUtil;
import ua.goit.view.View;

import static ua.goit.controller.command.Commands.GET_ORDER_BY_ID;

public class GetOrderById implements Command {
    private View view;

    public GetOrderById(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(GET_ORDER_BY_ID.getName());
    }

    @Override
    public void process() {
        view.write("Enter order id:");
        long orderId = 0;
        while (true) {
            try {
                orderId = Long.parseLong(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Please, enter correct number:");
            }
        }
        StoreHttpUtil.getOrderById(orderId);
    }
}
