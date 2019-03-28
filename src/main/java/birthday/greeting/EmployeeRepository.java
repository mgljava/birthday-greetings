package birthday.greeting;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class EmployeeRepository {

  public List<Employee> getEmployees() {

    try {
      String content = FileUtils.readFileToString(new File("d:/source.txt"), "UTF-8");
      final String[] records = content.split("\n");
      return Arrays.stream(records)
          .skip(1)
          .map(line -> line.split(","))
          .map(this::getEmployee)
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  private Employee getEmployee(String[] line) {
    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    final LocalDate birthday = LocalDate.parse(line[2], dateTimeFormatter);
    return new Employee(line[0], line[1], birthday, line[3]);
  }


  public static void main(String[] args) {
    final List<Employee> employees = new EmployeeRepository().getEmployees();
    employees.forEach(System.out::println);
  }
}