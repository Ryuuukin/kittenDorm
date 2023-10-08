import java.util.*;

public class Main {
    private static KittenDorm kittenDorm = KittenDorm.getInstance();
    private static List<Cat> cats = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                changeCatStatusToHungry();
            }
        }, 0, 60 * 1000);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a kitten");
            System.out.println("2. Feed a cat");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addKitten(scanner);
                    break;
                case 2:
                    feedCat(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addKitten(Scanner scanner) {
        System.out.print("Enter the kitten's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the kitten's age (must be >= 0): ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (age < 0) {
            System.out.println("Age cannot be less than 0. Kitten not added.");
        } else {
            // Randomly select a character for the kitten
            String[] characters = {"chicken-eater", "meat-eater", "fish-eater"};
            String character = characters[new Random().nextInt(characters.length)];

            Cat kitten = new Cat(name, age, character); // Pass the character to the Cat constructor
            cats.add(kitten);
            kittenDorm.addCat(kitten);
            System.out.println(name + " is added as a kitten with a character of " + character + ".");
        }
    }

    private static void changeCatStatusToHungry() {
        for (Cat cat : cats) {
            cat.setStatus("hungry");
            System.out.println(cat.getName() + " is hungry! Give some food!");
        }
    }

    private static void feedCat(Scanner scanner) {
        System.out.print("Enter the cat's name: ");
        String name = scanner.nextLine();

        Cat catToFeed = findCatByName(name);
        if (catToFeed == null) {
            System.out.println("Cat with name " + name + " not found.");
            return;
        }

        String character = catToFeed.getCharacter();

        System.out.print("Choose feeding strategy (For cats/For kittens): ");
        String strategyChoice = scanner.nextLine();

        if (catToFeed.isKitten() && strategyChoice.equalsIgnoreCase("For cats")) {
            System.out.println(name + " cannot eat basic food because it is a kitten.");
        } else if (!catToFeed.isKitten() && strategyChoice.equalsIgnoreCase("For kittens")) {
            System.out.println(name + " cannot eat kittens' food because it is an adult cat.");
        } else {
            kittenDorm.setFeedingStrategy(strategyChoice.equalsIgnoreCase("For kittens") ? new KittensFeedingStrategy(character) : new BasicFeedingStrategy(character));
            kittenDorm.feedCat(catToFeed);
        }
    }

    private static Cat findCatByName(String name) {
        for (Cat cat : cats) {
            if (cat.getName().equalsIgnoreCase(name)) {
                return cat;
            }
        }
        return null;
    }
}
