package birthday.greeting;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

public class EmployeeFinderTest {

  @Test
  public void should_find_employees_by_birthday() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 8);

    // when
    List<Employee> employeeList = new EmployeeFinder().find(birthday);

    // then
    assertThat(employeeList).isNotEmpty();
  }

  @Test
  public void should_not_find_employees_when_birthday_is_not_given_date() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 20);

    // when
    final List<Employee> employees = new EmployeeFinder().find(birthday);

    // then
    assertThat(employees).isEmpty();
  }

  @Test
  public void should_find_employees_when_birthday_is_2_moth_29_and_year_is_not_leap_year() {
    // given
    LocalDate birthday = LocalDate.of(2013, 2, 28);

    // when
    final List<Employee> employees = new EmployeeFinder().find(birthday);

    // then
    assertThat(employees.size()).isEqualTo(1);
  }
}
