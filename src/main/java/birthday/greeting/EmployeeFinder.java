package birthday.greeting;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;

public class EmployeeFinder {

  public List<Employee> find(List<Employee> employees, LocalDate birthday) {
    return employees.stream()
        .filter(employee -> isBirthday(birthday, employee))
        .collect(toList());
  }

  private boolean isBirthday(LocalDate birthday, Employee employee) {
    return employee.getBirthday().getMonth().equals(birthday.getMonth())
        && employee.getBirthday().getDayOfMonth() == (birthday.getDayOfMonth());
  }
}
