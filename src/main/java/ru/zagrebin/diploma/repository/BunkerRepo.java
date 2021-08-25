package ru.zagrebin.diploma.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zagrebin.diploma.models.Bunker;
import java.util.ArrayList;
import java.util.HashSet;

@Repository
public interface BunkerRepo extends CrudRepository<Bunker, Long>{
    @Query("select baggage from Bunker")
    HashSet<String> findAllBaggage();
    @Query(value = "select additionalSkills from Bunker")
    HashSet<String> findAllAdditionalSkills();
    @Query(value ="select biologicalCharacteristics from Bunker")
    HashSet<String>findAllBiologicalCharacteristics();
    @Query(value ="select catastrophe from Bunker")
    HashSet<String> findAllCatastrophe();
    @Query(value ="select descriptionsBunker from Bunker")
    HashSet<String> findAllDescriptionsBunker();
    @Query(value ="select health from Bunker")
    HashSet<String> findAllHealth();
    @Query(value = "select hobby from Bunker")
    HashSet<String> findAllHobby();
    @Query(value ="select humanQuality from Bunker")
    HashSet<String> findAllHumanQuality();
    @Query(value = "select phobia from Bunker")
    HashSet<String> findAllPhobia();
    @Query(value ="select professions from Bunker")
    HashSet<String> findAllProfessions();
    @Query(value ="select specialConditions from Bunker")
    HashSet<String> findAllSpecialConditions();
}
