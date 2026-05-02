public class Transaction {
    private int id;
    private String type;
    private double amount;
    private String category;

    public Transaction(int id, String type, double amount, String category) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(String category) { this.category = category; }
}