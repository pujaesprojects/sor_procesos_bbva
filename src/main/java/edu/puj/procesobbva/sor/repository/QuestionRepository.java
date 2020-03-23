package edu.puj.procesobbva.sor.repository;

import edu.puj.procesobbva.sor.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
