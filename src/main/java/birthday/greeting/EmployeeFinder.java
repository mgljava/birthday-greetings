package birthday.greeting;

import static java.util.stream.Collectors.toList;

import com.google.common.collect.ImmutableList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFinder {

  private List<Employee> getEmployees() {
    return ImmutableList.of(
        new Employee("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com"),
        new Employee("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com"),
        new Employee("mgl", "ming", LocalDate.of(2000, 2, 29), "ming.mgl@foobat.com")
    );
  }

  private boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0)
        || (year % 400 == 0 && year % 3200 != 0);
  }

  public List<Employee> find(LocalDate birthday) {
    List<Employee> employees = getEmployees();
    List<Employee> collect = new ArrayList<>();

    if (!isLeapYear(birthday.getYear())) {
      collect = employees.stream()
          .filter(employee -> birthdayIs2of29(employee)
              && isLeapYearBirthday(birthday, employee))
          .collect(toList());
    }

    collect.addAll(employees.stream()
        .filter(employee -> isBirthday(birthday, employee))
        .collect(toList()));
    return collect;
  }

  private boolean isLeapYearBirthday(LocalDate birthday, Employee employee) {
    return birthdayIs2of29(employee)
        && birthday.getMonth().getValue() == 2
        && birthday.getDayOfMonth() == 28;
  }

  private boolean birthdayIs2of29(Employee employee) {
    return employee.getBirthday().getMonth().getValue() == 2
        && employee.getBirthday().getDayOfMonth() == 29;
  }

  private boolean isBirthday(LocalDate birthday, Employee employee) {
    return employee.getBirthday().getMonth().equals(birthday.getMonth())
        && employee.getBirthday().getDayOfMonth() == (birthday.getDayOfMonth());
  }
}
