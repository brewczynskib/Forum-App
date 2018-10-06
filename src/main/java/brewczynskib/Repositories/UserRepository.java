package brewczynskib.Repositories;

import brewczynskib.Domain.User;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByLogin(String login);
    User findByLoginAndPassword(String login, String Password);
    User findByPassword(String password);
    @Override
    Iterable<User> findAll();
}
