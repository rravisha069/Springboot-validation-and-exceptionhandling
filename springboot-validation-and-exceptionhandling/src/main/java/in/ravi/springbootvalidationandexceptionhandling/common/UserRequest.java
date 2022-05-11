package in.ravi.springbootvalidationandexceptionhandling.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")//builder pattern
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "User name should be null")
    private String userName;
    @Email(message = "Please add valid Email")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String phone;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
}
