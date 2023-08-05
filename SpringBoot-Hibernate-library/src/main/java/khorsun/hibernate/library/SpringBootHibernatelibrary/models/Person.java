package khorsun.hibernate.library.SpringBootHibernatelibrary.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "year_of_birth")
   // @Min(value = 1900,message = "Year should be greater then 1900")
    private int yearOfBirth;
     @NotEmpty(message = "Login should not be empty")
   //  @Size(min = 2, max = 30, message = "Login should be between 2 and 30 characters")
  //   @Pattern(regexp = "\\w{0,30}", message ="Invalid login type")
    @Column(name = "login")
    private String login;
    @NotEmpty(message = "Password should not be empty")
   // @Size(min = 2, max = 100, message = "Password should be between 2 and 30 characters")
  //  @Pattern(regexp = "\\w{0,100}", message ="Invalid password type")
    @Column(name = "password")
    private String password;
    @Column(name ="role")
    private String role;
    @OneToMany(mappedBy = "person")
    private List<Book> book;


    public Person() {
    }

    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
