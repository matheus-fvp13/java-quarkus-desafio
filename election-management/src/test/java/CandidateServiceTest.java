import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Optional;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import domain.Candidate;
import domain.CandidateRepository;
import domain.CandidateService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class CandidateServiceTest {

    @Inject
    CandidateService candidateService;

    @InjectMock
    CandidateRepository repository;

    @Test
    void save(){
        Candidate candidate = Instancio.create(Candidate.class);

        candidateService.save(candidate);

        verify(repository).save(candidate);
        verifyNoMoreInteractions(repository);

    }

    @Test
    void findAll() {
        candidateService.findAll();
    }
}
