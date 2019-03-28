package birthday.greeting;

import java.time.LocalDate;

public class Employee {

  private LocalDate birthday;

  public Employee(LocalDate birthday) {
    this.birthday = birthday;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }
}
