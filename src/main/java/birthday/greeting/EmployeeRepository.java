package birthday.greeting;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class EmployeeRepository {

  public List<Employee> getEmployees() {
    final String[] records = readFileAsString().split("\n");
    return Arrays.stream(records)
        .skip(1)
        .map(line -> line.split(","))
        .map(this::toEmployee)
        .collect(Collectors.toList());

  }

  private String readFileAsString() {
    try {
      return FileUtils.readFileToString(new File("d:/source.txt"), "UTF-8");
    } catch (IOException e) {
      return "";
    }
  }

  private Employee toEmployee(String[] line) {
    final LocalDate birthday = LocalDate.parse(line[2], ofPattern("yyyy/MM/dd"));
    return new Employee(line[0], line[1], birthday, line[3]);
  }
}