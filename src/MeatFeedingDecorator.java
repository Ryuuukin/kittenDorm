public abstract class MeatFeedingDecorator implements FeedingStrategy {
    private FeedingStrategy decoratedStrategy;

    public MeatFeedingDecorator(FeedingStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    @Override
    public void feedCat(Cat cat) {
        decoratedStrategy.feedCat(cat);
        System.out.println("Feeding " + getCharacter() + " food " + cat.getName());
    }

    @Override
    public String getCharacter() {
        return "meat-" + decoratedStrategy.getCharacter();
    }
}
