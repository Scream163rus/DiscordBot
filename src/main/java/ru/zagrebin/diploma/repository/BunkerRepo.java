package ru.zagrebin.diploma.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zagrebin.diploma.models.Bunker;
import java.util.ArrayList;

@Repository
public interface BunkerRepo extends CrudRepository<Bunker, Long>{
    @Query("select baggage from Bunker")
    ArrayList<String> findAllBaggage();
    @Query(value = "select additionalSkills from Bunker")
   ArrayList<String> findAllAdditionalSkills();
    @Query(value ="select biologicalCharacteristics from Bunker")
   ArrayList<String> findAllBiologicalCharacteristics();
    @Query(value ="select catastrophe from Bunker")
    ArrayList<String> findAllCatastrophe();
    @Query(value ="select descriptionsBunker from Bunker")
    ArrayList<String> findAllDescriptionsBunker();
    @Query(value ="select health from Bunker")
    ArrayList<String> findAllHealth();
    @Query(value = "select hobby from Bunker")
    ArrayList<String> findAllHobby();
    @Query(value ="select humanQuality from Bunker")
    ArrayList<String> findAllHumanQuality();
    @Query(value = "select phobia from Bunker")
    ArrayList<String> findAllPhobia();
    @Query(value ="select professions from Bunker")
    ArrayList<String> findAllProfessions();
    @Query(value ="select specialConditions from Bunker")
    ArrayList<String> findAllSpecialConditions();
}
