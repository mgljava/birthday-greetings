package birthday.greeting;

import java.time.LocalDate;

public class Employee {

  private String lastName;
  private String firstName;
  private LocalDate birthday;
  private String email;

  public Employee(String lastName, String firstName, LocalDate birthday, String email) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.birthday = birthday;
    this.email = email;
  }

  public LocalDate getBirthday() {
    return this.birthday;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", birthday=" + birthday +
        ", email='" + email + '\'' +
        '}';
  }
}
