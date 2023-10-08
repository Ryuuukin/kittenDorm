public class BasicFeedingStrategy implements FeedingStrategy {
    private String character;

    public BasicFeedingStrategy(String character) {
        this.character = character;
    }
    @Override
    public void feedCat(Cat cat) {
        if ("hungry".equals(cat.getStatus())) {
            System.out.println("Feeding basic" + character + " food to " + cat.getName());
            cat.makeCatFull();
        } else {
            System.out.println(cat.getName() + " is not hungry.");
        }
    }
    @Override
    public String getCharacter() {
        return character;
    }
}
