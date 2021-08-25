package ru.zagrebin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zagrebin.diploma.repository.BunkerRepo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Random;

@Service
public class ServiceBunker {
    private BunkerRepo bunkerRepo;
    private ArrayList<String> baggage;
    private ArrayList<String> additionalSkills;
    private ArrayList<String> biologicalCharacteristics;
    private ArrayList<String> catastrophe;
    private ArrayList<String> descriptionsBunker;
    private ArrayList<String> health;
    private ArrayList<String> hobby;
    private ArrayList<String> humanQuality;
    private ArrayList<String> phobia;
    private ArrayList<String> professions;
    private ArrayList<String> specialConditions;
    private Random rnd;
    public ServiceBunker(BunkerRepo bunkerRepo){
        this.rnd = new Random();
        this.bunkerRepo = bunkerRepo;
    }
    @PostConstruct
    public void postConstructorServiceBunker(){
    ArrayList<String> baggage = bunkerRepo.findAllBaggage();
    ArrayList<String> additionalSkills  = bunkerRepo.findAllAdditionalSkills();
    ArrayList<String> biologicalCharacteristics = bunkerRepo.findAllBiologicalCharacteristics();
    ArrayList<String> catastrophe = bunkerRepo.findAllCatastrophe();
    ArrayList<String> descriptionsBunker = bunkerRepo.findAllDescriptionsBunker();
    ArrayList<String> health = bunkerRepo.findAllHealth();
    ArrayList<String> hobby = bunkerRepo.findAllHobby();
    ArrayList<String> humanQuality = bunkerRepo.findAllHumanQuality();
    ArrayList<String> phobia = bunkerRepo.findAllPhobia();
    ArrayList<String> professions = bunkerRepo.findAllProfessions();
    ArrayList<String> specialConditions = bunkerRepo.findAllSpecialConditions();
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
        String str = descriptionsBunker.get(rnd.nextInt(descriptionsBunker.size()));
        descriptionsBunker.remove(str);
        return str;

    }
    public String getRandomCatastrophe(){
            String str = catastrophe.get(rnd.nextInt(catastrophe.size()));
            catastrophe.remove(str);
            return str;

    }
    public String getRandomBaggage(){
        String str = baggage.get(rnd.nextInt(baggage.size()));
        baggage.remove(str);
        return str;
    }
    public String getRandomAdditionalSkills(){
        String str = additionalSkills.get(rnd.nextInt(additionalSkills.size()));
        additionalSkills.remove(str);
        return str;
    }
    public String getRandomBiologicalCharacteristics(){
        String str = biologicalCharacteristics.get(rnd.nextInt(biologicalCharacteristics.size()));
        biologicalCharacteristics.remove(str);
        return str;
    }
    public String getRandomHealth(){
       String str = health.get(rnd.nextInt(health.size()));
       health.remove(str);
        return str;
    }
    public String getRandomHobby(){
        String str = hobby.get(rnd.nextInt(hobby.size()));
        hobby.remove(str);
        return str;
    }
    public String getRandomHumanQuality(){
        String str = humanQuality.get(rnd.nextInt(humanQuality.size()));
        humanQuality.remove(str);
        return str;
    }
    public String getRandomPhobia(){
        String str = phobia.get(rnd.nextInt(phobia.size()));
        phobia.remove(str);
        return str;
    }
    public String getRandomProfessions(){
        String str = professions.get(rnd.nextInt(professions.size()));
        professions.remove(str);
        return str;
    }
    public String getRandomSpecialConditions(){
        String str = specialConditions.get(rnd.nextInt(specialConditions.size()));
        specialConditions.remove(str);
        return str;
    }


}
