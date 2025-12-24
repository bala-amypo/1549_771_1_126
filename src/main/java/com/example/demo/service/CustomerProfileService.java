public interface CustomerProfileService {

    CustomerProfile create(CustomerProfile profile);

    CustomerProfile getById(Long id);

    List<CustomerProfile> getAll();

    CustomerProfile updateStatus(Long id, boolean active);
}
