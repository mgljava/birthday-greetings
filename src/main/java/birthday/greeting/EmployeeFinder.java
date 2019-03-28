package birthday.greeting;

import static java.util.stream.Collectors.toList;

import com.google.common.collect.ImmutableList;
import java.time.LocalDate;
import java.util.List;

public class EmployeeFinder {

  public List<Employee> find(LocalDate birthday) {
    List<Employee> employees = getEmployees();
    return employees.stream()
        .filter(employee -> isBirthday(birthday, employee))
        .collect(toList());
  }

  private List<Employee> getEmployees() {
    return ImmutableList.of(
        new Employee("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com"),
        new Employee("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com")
    );
  }

  private boolean isBirthday(LocalDate birthday, Employee employee) {
    return employee.getBirthday().getMonth().equals(birthday.getMonth())
        && employee.getBirthday().getDayOfMonth() == (birthday.getDayOfMonth());
  }
}
