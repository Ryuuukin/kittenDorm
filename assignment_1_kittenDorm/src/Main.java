import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        KittenDorm kittenDorm = KittenDorm.getInstance();
        Cat cat1 = new Cat("Whiskers", 2);
        Cat cat2 = new Cat("Mittens", 4);

        FeedingStrategy basicStrategy = new BasicFeedingStrategy();
        FeedingStrategy kittensStrategy = new KittensFeedingStrategy();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cat1.setStatus("hungry");
                kittenDorm.setFeedingStrategy(cat1.isKitten() ? kittensStrategy : basicStrategy);
                kittenDorm.feedCat(cat1);


                cat2.setStatus("hungry");
                kittenDorm.setFeedingStrategy(cat2.isKitten() ? kittensStrategy : basicStrategy);
                kittenDorm.feedCat(cat2);
            }
        }, 0, 60 * 1000);
    }
}
