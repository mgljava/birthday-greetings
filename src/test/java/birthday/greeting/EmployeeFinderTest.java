package birthday.greeting;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFinderTest {

  private EmployeeRepository employeeRepository;

  @Before
  public void setUp() {
    employeeRepository = mock(EmployeeRepository.class);
    when(employeeRepository.getEmployees()).thenReturn(ImmutableList.of(
        new Employee("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com"),
        new Employee("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com"),
        new Employee("mgl", "ming", LocalDate.of(2000, 2, 29), "ming.mgl@foobat.com")
    ));
  }

  @Test
  public void should_find_employees_by_birthday() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 8);

    // when
    List<Employee> employeeList = new EmployeeFinder(employeeRepository).find(birthday);

    // then
    assertThat(employeeList).isNotEmpty();
  }

  @Test
  public void should_not_find_employees_when_birthday_is_not_given_date() {
    // given
    LocalDate birthday = LocalDate.of(2018, 10, 20);

    // when
    final List<Employee> employees = new EmployeeFinder(employeeRepository).find(birthday);

    // then
    assertThat(employees).isEmpty();
  }

  @Test
  public void should_find_employees_when_birthday_is_2_moth_29_and_year_is_not_leap_year() {
    // given
    LocalDate birthday = LocalDate.of(2013, 2, 28);

    // when
    final List<Employee> employees = new EmployeeFinder(employeeRepository).find(birthday);

    // then
    assertThat(employees.size()).isEqualTo(1);
  }
}
