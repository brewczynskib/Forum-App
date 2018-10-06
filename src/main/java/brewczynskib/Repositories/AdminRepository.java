package brewczynskib.Repositories;

import brewczynskib.Domain.Admin;
import brewczynskib.Domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    @Query("SELECT e from User e")
    List<User> findAllUsers();

    Admin findAdminByLogin(String login);


}
