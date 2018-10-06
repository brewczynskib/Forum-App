package brewczynskib.Forms;

import org.springframework.stereotype.Repository;
import javax.validation.constraints.NotBlank;

@Repository
public class ChangePasswordForm {

    @NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
