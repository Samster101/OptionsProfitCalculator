public class BuyShare implements Holding {
    private double buyPrice;
    private double quantity;
    BuyShare(double buyPrice, double quantity) {
        this.buyPrice = buyPrice;
        this.quantity = quantity;
    }
    public double end(double endPrice) {
        return (endPrice - buyPrice) * quantity;
    }
}
