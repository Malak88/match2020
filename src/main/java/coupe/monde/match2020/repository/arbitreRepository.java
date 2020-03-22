package coupe.monde.match2020.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coupe.monde.match2020.entities.Arbitre;

@Repository
public interface arbitreRepository extends JpaRepository<Arbitre,Long>{

}
