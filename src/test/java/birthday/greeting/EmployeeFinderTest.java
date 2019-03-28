package birthday.greeting;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

public class EmployeeFinderTest {

  @Test
  public void should_find_employees_by_birthday() {
    // given
    LocalDate birthday = LocalDate.now();

    // when
    List<Employee> employeeList = new EmployeeFinder().find(birthday);

    // then
    assertThat(employeeList).isNotEmpty();
  }
}
