public class BasicFeedingStrategy implements FeedingStrategy {
    @Override
    public void feedCat(Cat cat) {
        if ("hungry".equals(cat.getStatus())) {
            System.out.println("Feeding basic food to " + cat.getName());
            cat.makeCatFull();
        } else {
            System.out.println(cat.getName() + " is not hungry.");
        }
    }
}
