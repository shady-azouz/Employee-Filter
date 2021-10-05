import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("ASE", "Shady Azouz", "01229339212"),
                new Employee("ASE", "Youssef Refaat", "01228899932"),
                new Employee("ASE", "Mohamed Adel", "01090211579"),
                new Employee("SE", "Yomna Yousry", "01010613249"),
                new Employee("SE", "Youssef Farahat", "01282125242"),
                new Employee("SE", "Mohamed Kadry", "01202081029"),
                new Employee("SE", "Ahmed Yousry", "01000801913"),
                new Employee("CTO", "Mohamed Nour", "01111111111")
        );

        Map<String, List<Employee>> output = employees.stream().collect(Collectors.groupingBy(employee -> employee.getTitle()));

        System.out.println(printMap(output));
    }

    private static String printMap(Map<String, List<Employee>> map) {
        String output = "";
        for (var entry : map.entrySet()) {
            if (entry.getValue().size() > 1)
                output += entry.getKey() + '\n';
            else
                output += "Unique Title: " + entry.getKey() + '\n';
            output += "Count: " + entry.getValue().size() + '\n';
            for (var employee : entry.getValue()) {
                output += employee.toString() + '\n';
            }
            output += '\n';
        }
        return output;
    }
}
