public class Put implements Holding {

    private double strikePrice;
    private double premium;
    private boolean Buy;

    Put(double strikePrice, double premium, boolean Buy) {
        this.strikePrice = strikePrice;
        this.premium = premium;
        this.Buy = Buy;
    }

    public double end(double stockPrice) {
        if (stockPrice <= strikePrice) {
            double valuereturn = (strikePrice - stockPrice) * 100 - premium;
            if (Buy) {
                return valuereturn;
            } else {
                return -valuereturn;
            }
        } else {
            if (Buy) {
                return -premium;
            } else {
                return premium;
            }
        }
    }
}
