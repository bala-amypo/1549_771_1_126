@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channel;

    @ManyToOne
    private CustomerProfile customer;

    public String getChannel() {
        return channel;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }
}
