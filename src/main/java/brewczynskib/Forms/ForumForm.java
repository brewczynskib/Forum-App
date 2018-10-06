package brewczynskib.Forms;

import org.springframework.stereotype.Repository;

@Repository
public class ForumForm {

    private String text;
    private String subject;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
