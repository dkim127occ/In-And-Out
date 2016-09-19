package edu.orangecoastcollege.cs273.dkim127.inandout;


import java.util.HashMap;
import java.util.Map;

public class Order
{
    private static final double TAX = 0.08;


    /**
     * Key-value mapping of menu item and number of orders placed.
     */
    private Map<Menu, Integer> orderCount = new HashMap<Menu, Integer>()
    {{
        put(Menu.DOUBLE_DOUBLE, 0);
        put(Menu.CHEESEBURGER, 0);
        put(Menu.FRENCH_FRIES, 0);
        put(Menu.SHAKES, 0);
        put(Menu.DRINK_SMALL, 0);
        put(Menu.DRINK_MEDIUM, 0);
        put(Menu.DRINK_LARGE, 0);
    }};

    /**
     * Adds the specified amount of orders to the specified menu item.
     * @param menu Desired menu item to order
     * @param count Number of orders
     */
    public void setOrderCount(Menu menu, int count)
    {
        orderCount.put(menu, count);
    }

    /**
     * Returns the number of orders placed for the specified menu item.
     * @param menu Menu item to look for
     * @return The number of orders placed
     */
    public int getOrderCount(Menu menu)
    {
        return orderCount.get(menu);
    }

    public int getTotalOrderCount()
    {
        int total = 0;
        for (Map.Entry<Menu, Integer> order: orderCount.entrySet())
        {
            total += order.getValue();
        }
        return total;
    }

    /**
     * Returns the price for the specified menu item.
     * @param menu Menu item to look for.
     * @return Running total for the menu item.
     */
    public double getOrderPrice(Menu menu)
    {
        return orderCount.get(menu) * menu.getPrice();
    }

    /**
     * Returns the subtotal of the entire order before tax.
     * @return The subtotal owed for the order
     */
    public double getSubTotal()
    {
        double subtotal = 0;
        for(Map.Entry<Menu, Integer> order : orderCount.entrySet())
        {
            subtotal += order.getValue() * order.getKey().getPrice();
        }
        return subtotal;
    }

    /**
     * Returns the grand total of the entire order after tax.
     * @return The total amount owed for the order
     */
    public double getTotal()
    {
        return getSubTotal() + getTax();
    }

    /**
     * Returns the tax amount for the current order.
     * @return The tax amount owed
     */
    public double getTax()
    {
        return getSubTotal() * TAX;
    }

    /**
     * Resets all order count to zero
     */
    public void reset()
    {
        for (Menu menu : orderCount.keySet())
        {
            orderCount.put(menu, 0);
        }
    }



}
