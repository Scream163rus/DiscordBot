package ru.zagrebin.diploma.service;

import org.springframework.stereotype.Service;
import ru.zagrebin.diploma.repository.BunkerRepo;

@Service
public class ServiceBunker {
    private BunkerRepo bunkerRepo;
    public ServiceBunker(BunkerRepo bunkerRepo){
        this.bunkerRepo = bunkerRepo;
    }
    public String initBunkerCard(){
        return String.format("Описание катастрофы: %s, \n Описание бункера: %s",getRandomCatastrophe(),getRandomBunkerDescription());
    }
    public String initPlayerCard() {
        return String.format("Профессия: %s \nБиологическая характеристика: %s \nЗдоровье: %s " +
                        "\n Багаж: %s \nДоп навык: %s \nХобби: %s \nЧеловеческое качество: %s \nФобия: %s \nСпец условия: %s",
                getRandomProfessions(),getRandomBiologicalCharacteristics(),getRandomHealth(),getRandomBaggage(),
                getRandomAdditionalSkills(),getRandomHobby(),getRandomHumanQuality(), getRandomPhobia(),
                getRandomSpecialConditions());

    }
    public String getRandomBunkerDescription(){
        return bunkerRepo.findAllDescriptionsBunker().iterator().next();

    }
    public String getRandomCatastrophe(){
        return bunkerRepo.findAllCatastrophe().iterator().next();
    }
    public String getRandomBaggage(){
        return bunkerRepo.findAllBaggage().iterator().next();
    }
    public String getRandomAdditionalSkills(){
        return bunkerRepo.findAllAdditionalSkills().iterator().next();
    }
    public String getRandomBiologicalCharacteristics(){
        return bunkerRepo.findAllBiologicalCharacteristics().iterator().next();
    }
    public String getRandomHealth(){
        return bunkerRepo.findAllHealth().iterator().next();
    }
    public String getRandomHobby(){
        return bunkerRepo.findAllHobby().iterator().next();
    }
    public String getRandomHumanQuality(){
        return bunkerRepo.findAllHumanQuality().iterator().next();

    }
    public String getRandomPhobia(){
        return bunkerRepo.findAllPhobia().iterator().next();
    }
    public String getRandomProfessions(){
        return bunkerRepo.findAllProfessions().iterator().next();

    }
    public String getRandomSpecialConditions(){
        return bunkerRepo.findAllSpecialConditions().iterator().next();
    }


}
