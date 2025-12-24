public interface TierUpgradeRuleRepository
        extends JpaRepository<TierUpgradeRule, Long> {

    List<TierUpgradeRule> findByActiveTrue();

    Optional<TierUpgradeRule> findByFromTierAndToTier(
            String fromTier,
            String toTier
    );
}
