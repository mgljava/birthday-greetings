package birthday.greeting;

import static java.time.Month.FEBRUARY;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;

public class EmployeeFinder {

  private final EmployeeRepository employeeRepository;

  public EmployeeFinder(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }


  public List<Employee> find(LocalDate birthday) {
    return employeeRepository.getEmployees().stream()
        .filter(employee -> isSatisfied(birthday, employee))
        .collect(toList());
  }

  private boolean isSatisfied(final LocalDate date, final Employee employee) {
    return (employee.getBirthday().getMonth().equals(date.getMonth())
        && employee.getBirthday().getDayOfMonth() == date.getDayOfMonth())
        || (date.getMonth().equals(FEBRUARY)
        && date.getDayOfMonth() == 28
        && employee.getBirthday().isLeapYear()
        && employee.getBirthday().getDayOfMonth() == 29);
  }
}
