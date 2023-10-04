public class Cat {
    private String name;
    private int age;
    private String status; // Added status field

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.status = "hungry"; // Initialize as hungry
    }

    // Getters and setters for name, age, and status
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Other methods to update status
    public void makeCatFull() {
        this.status = "full";
    }

    public boolean isKitten() {
        return age >= 1 && age <= 3;
    }
}
