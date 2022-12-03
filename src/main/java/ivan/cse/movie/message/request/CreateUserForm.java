package ivan.cse.movie.message.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


public class CreateUserForm {

    @NotBlank
    public String username;

    @NotBlank
    public String email;

    @NotBlank
    public Long mobileNo;

    @NotBlank
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
