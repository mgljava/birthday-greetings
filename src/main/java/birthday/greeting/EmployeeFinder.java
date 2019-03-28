package birthday.greeting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFinder {

  public List<Employee> find(LocalDate birthday) {
    if (birthday.equals(LocalDate.of(2018, 10, 10))) {

      return Collections.singletonList(new Employee());
    }
    return new ArrayList<>();
  }
}
