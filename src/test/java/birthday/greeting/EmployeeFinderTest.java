package birthday.greeting;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

public class EmployeeFinderTest {

  @Test
  public void should_find_employees_by_birthday() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 10);

    // when
    List<Employee> employeeList = new EmployeeFinder().find(birthday);

    // then
    assertThat(employeeList).isNotEmpty();
  }

  @Test
  public void should_not_find_employees_when_today_is_not_birthday() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 20);

    // when
    final List<Employee> employees = new EmployeeFinder().find(birthday);

    // then
    assertThat(employees).isEmpty();
  }
}
