package KvizVezba.KvizDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KvizRepository extends JpaRepository<Pitanje, Long> {
}
