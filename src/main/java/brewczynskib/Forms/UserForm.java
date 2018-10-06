package brewczynskib.Forms;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@Repository
public class UserForm {
    @NotBlank
    private String login;
    @NotBlank
    private String password;


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
}
