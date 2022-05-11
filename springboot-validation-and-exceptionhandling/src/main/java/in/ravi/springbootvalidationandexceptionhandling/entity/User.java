package in.ravi.springbootvalidationandexceptionhandling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TBL")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    private String email;
    private String phone;
    private String gender;
    private int age;
}
