import java.util.HashMap;
import java.util.Map;

import chicken.Chicken;
import chicken.Cock;
import chicken.Hen;
import transport.Bus;
import transport.Driving;
import transport.Plane;
import transport.Train;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(
                "Hello, World!\n Buying a hundred poultry items with an initial budget of 100!"
                        + new PoultryMethods().buyAHundredPoultry());
        System.out.println(
                "Optimal mode of transport for Xiaoming: \n" + new TransportMethods().determineModeOfTransport());

    }
}

class TransportMethods {
    Bus bus = new Bus();
    Train train = new Train();
    Plane plane = new Plane();
    Driving driving = new Driving();

    String determineModeOfTransport() {
        String modeOfTransport = "";
        if (500 - train.getPrice() == 0) {
            modeOfTransport = train.getClass().getSimpleName();
        } else if (500 - plane.getPrice() == 0) {
            modeOfTransport = plane.getClass().getSimpleName();
        } else if (500 - bus.getPrice() == 0) {
            modeOfTransport = bus.getClass().getSimpleName();
        } else if (500 - driving.getPrice() == 0) {
            modeOfTransport = driving.getClass().getSimpleName();
        }
        return modeOfTransport;
    }
}

class PoultryMethods {

    String buyAHundredPoultry() {
        Double budget = 100.0;
        String cartString = "";
        Cock cock = new Cock();
        Chicken chicken = new Chicken();
        Hen hen = new Hen();

        Map cart = new HashMap();
        cart.put(chicken, Double.parseDouble("60.0"));
        cart.put(hen, Double.parseDouble("10.0"));
        cart.put(cock, Double.parseDouble("10.0"));

        budget -= ((double) cart.get(cock)) * cock.getPrice();
        budget -= ((double) cart.get(chicken)) * chicken.getPrice();
        budget -= ((double) cart.get(hen)) * hen.getPrice();

        cartString += " \n\t\t1. Item: " + cock.getClass().getSimpleName() + " Amount: " + cart.get(cock) + "\n";
        cartString += " \n\t\t2. Item: " + hen.getClass().getSimpleName() + " Amount: " + cart.get(hen) + "\n";
        cartString += " \n\t\t3. Item: " + chicken.getClass().getSimpleName() + " Amount: " + cart.get(chicken) + "\n";
        cartString += " \n\t\tBudget: " + budget.intValue() + "\n";

        return cartString;
    }
}
