public class KittensFeedingStrategy implements FeedingStrategy {
    private String character;

    public KittensFeedingStrategy(String character) {
        this.character = character;
    }
    @Override
    public void feedCat(Cat cat) {
        if ("hungry".equals(cat.getStatus())) {
            if (cat.isKitten()) {
                System.out.println("Feeding kittens " + character + " food to " + cat.getName());
                cat.makeCatFull();
            } else {
                System.out.println("Cannot feed adult cat " + cat.getName() + " kittens food.");
            }
        } else {
            System.out.println(cat.getName() + " is not hungry.");
        }
    }
    @Override
    public String getCharacter() {
        return character;
    }
}







