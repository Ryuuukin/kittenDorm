public abstract class ChickenFeedingDecorator implements FeedingStrategy {
    private FeedingStrategy decoratedStrategy;

    public ChickenFeedingDecorator(FeedingStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    @Override
    public void feedCat(Cat cat) {
        decoratedStrategy.feedCat(cat);
        System.out.println("Feeding " + getCharacter() + " food " + cat.getName());
    }

    @Override
    public String getCharacter() {
        return "chicken-" + decoratedStrategy.getCharacter();
    }
}
