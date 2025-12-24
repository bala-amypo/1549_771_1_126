import java.util.List;

public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {

    List<TierUpgradeRule> findByActiveTrue();

    TierUpgradeRule findByFromTierAndToTier(String fromTier, String toTier);
}
