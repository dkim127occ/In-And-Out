package edu.orangecoastcollege.cs273.dkim127.inandout;

/**
 * Static representation of the price associated with each menu item.
 */
public enum Menu
{
    DOUBLE_DOUBLE (3.60),
    CHEESEBURGER (2.15),
    FRENCH_FRIES (1.65),
    SHAKES (2.20),
    DRINK_SMALL (1.45),
    DRINK_MEDIUM (1.55),
    DRINK_LARGE (1.75);

    private final double price;

    /**
     * Constructor for each enumerable.
     * @param price The menu price for this particular item
     */
    Menu(double price) { this.price = price; }

    /**
     * Returns the menu price of this item.
     * @return The menu price
     */
    double getPrice() { return price; }
}
