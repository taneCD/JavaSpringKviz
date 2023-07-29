package KvizVezba.KvizDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KvizService {
    private final KvizRepository kvizRepository;

    @Autowired
    public KvizService(KvizRepository kvizRepository) {
        this.kvizRepository = kvizRepository;
    }
    public List<PitanjeBaza> getPitanja(){
        return kvizRepository.findAll();
    }
}
