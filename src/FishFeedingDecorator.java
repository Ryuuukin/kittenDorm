public abstract class FishFeedingDecorator implements FeedingStrategy {
    private FeedingStrategy decoratedStrategy;

    public FishFeedingDecorator(FeedingStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    @Override
    public void feedCat(Cat cat) {
        decoratedStrategy.feedCat(cat);
        System.out.println("Feeding " + getCharacter() + " food " + cat.getName());
    }

    @Override
    public String getCharacter() {
        return "fish-" + decoratedStrategy.getCharacter();
    }
}