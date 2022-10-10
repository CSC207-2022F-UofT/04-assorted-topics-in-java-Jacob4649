import java.util.List;

/**
 * {@link Trader} that only trades {@link Driveable}s
 */
class DrivableTrader extends Trader<Drivable> {

    /**
     * Construct a {@link DriveableTrader}, giving them the
     * given inventory, wishlist, and money.
     *
     * @param inventory Objects in this {@link DrivableTrader}'s inventory
     * @param wishlist  Objects in this {@link DrivableTrader}'s wishlist
     * @param money     The {@link Driveable}'s money
     */
    public DrivableTrader(List<Drivable> inventory,
                                List<Drivable> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Construct a {@link DrivableTrader}, giving them the
     * given money and an empty wishlist and inventory.
     *
     * @param money     The Trader's money
     */
    public DrivableTrader(int money) {
        super(money);
    }

    @Override
    public int getSellingPrice(Drivable item) {
        if (item instanceof Tradable) {
            return super.getSellingPrice(item) + item.getMaxSpeed();
        }
        return Tradable.MISSING_PRICE;
    }

}
