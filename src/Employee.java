public class Employee {
    String title;
    String name;
    String mobile;

    public Employee(String title, String name, String mobile) {
        this.title = title;
        this.name = name;
        this.mobile = mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "name: " + name + " - mobile: " + mobile;
    }
}
