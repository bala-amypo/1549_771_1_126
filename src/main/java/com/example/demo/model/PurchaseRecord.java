@Entity
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    private CustomerProfile customer;

    public double getAmount() {
        return amount;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }
}
