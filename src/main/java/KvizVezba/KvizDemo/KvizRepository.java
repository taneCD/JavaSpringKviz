package KvizVezba.KvizDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KvizRepository extends JpaRepository<Pitanje, Long> {
    @Query("SELECT s FROM KvizTable s WHERE s.id =?1")
    Optional<Pitanje>findStudentByEmail(String email);
}
