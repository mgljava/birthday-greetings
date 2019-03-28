package birthday.greeting;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class EmployeeFinderTest {

  @Test
  public void should_find_employees_by_birthday() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 10);
    List<Employee> employeesList = Lists.list(
        new Employee(LocalDate.of(2018, 10, 10)),
        new Employee(LocalDate.of(2017, 10, 10)));
    // when
    List<Employee> employeeList = new EmployeeFinder().find(employeesList, birthday);

    // then
    assertThat(employeeList).isNotEmpty();
  }

  @Test
  public void should_not_find_employees_when_given_date_is_not_birthday() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 20);
    List<Employee> employeesList = Lists.list(
        new Employee(LocalDate.of(2018, 10, 10)),
        new Employee(LocalDate.of(2017, 10, 22)));

    // when
    final List<Employee> employees = new EmployeeFinder().find(employeesList, birthday);

    // then
    assertThat(employees).isEmpty();
  }
}
