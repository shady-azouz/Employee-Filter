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

        Map<String, List<Employee>> output = employees.stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(Employee::getTitle),
                        (Map<String, List<Employee>> map) -> {
                            String outputString = "";
                            for (var entry : map.entrySet()) {
                                boolean flag = entry.getValue().size() > 1;
                                if (flag)
                                    outputString += entry.getKey() + '\n';
                                else
                                    outputString += "Unique Title: " + entry.getKey() + '\n';

                                if(flag)
                                    outputString += "Count: " + entry.getValue().size() + '\n';

                                for (var employee : entry.getValue()) {
                                    outputString += employee.toString() + '\n';
                                }
                                outputString += '\n';
                            }
                            System.out.println(outputString);
                            return map;
                }));
    }
}
