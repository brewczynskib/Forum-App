package brewczynskib.Domain;

import javax.persistence.*;

@Entity
public class Forum {


    @Id
    @GeneratedValue
    private Long Id;

    private String text;
    private String subject;
    //
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user + "\n"
                +
                subject
                + "\n"+
                text+"\n";
    }
}

