public class KittenDorm {
    private static KittenDorm instance;
    private FeedingStrategy feedingStrategy;

    private KittenDorm() {
        // Private constructor to prevent direct instantiation
    }

    public static KittenDorm getInstance() {
        if (instance == null) {
            instance = new KittenDorm();
        }
        return instance;
    }

    public void setFeedingStrategy(FeedingStrategy strategy) {
        this.feedingStrategy = strategy;
    }

    public void feedCat(Cat cat) {
        if (feedingStrategy != null) {
            feedingStrategy.feedCat(cat);
        }
    }
}
