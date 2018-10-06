package brewczynskib.Repositories;

import brewczynskib.Domain.Forum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ForumRepository extends CrudRepository<Forum, Long> {


    Forum findForumBySubject(String subject);
    @Query("SELECT e from Forum e")
    List<Forum> findAllForums();

}
