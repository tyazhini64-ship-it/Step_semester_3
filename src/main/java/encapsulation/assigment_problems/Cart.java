public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price >= 0 && this.itemCount < this.prices.length) {
            this.prices[this.itemCount] = price;
            this.itemCount++;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < this.itemCount; i++) {
            total += this.prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public String getCartId() {
        return this.cartId;
    }
}