import java.util.ArrayList;
import java.util.List;

public class KittenDorm {
    private static KittenDorm instance;
    private List<Cat> cats = new ArrayList<>();
    private FeedingStrategy feedingStrategy;

    private KittenDorm() {
        // Private constructor to enforce Singleton pattern
    }

    public static KittenDorm getInstance() {
        if (instance == null) {
            instance = new KittenDorm();
        }
        return instance;
    }

    public void setFeedingStrategy(FeedingStrategy feedingStrategy) {
        this.feedingStrategy = feedingStrategy;
    }

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public void feedCat(Cat cat) {
        if (feedingStrategy != null) {
            feedingStrategy.feedCat(cat);
        } else {
            System.out.println("No feeding strategy set for " + cat.getName());
        }
    }
}
