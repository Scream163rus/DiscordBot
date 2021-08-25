package ru.zagrebin.diploma.service;

import org.springframework.stereotype.Service;
import ru.zagrebin.diploma.models.Mafia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MafiaService {
    List<String> role = new ArrayList<>();
    private Random rnd;
    public MafiaService(){
        this.rnd = new Random();
    }
    public void InitMassRole(int numberPeople){
        if((numberPeople == 8)||(numberPeople == 9)){
            while (role.size() != numberPeople - 4) {
                role.add(Mafia.INNOCENT.getTranslation());
            }
            role.add(Mafia.MAFIA.getTranslation());
            role.add(Mafia.DONMAFIA.getTranslation());
            role.add(Mafia.COMMISSAR.getTranslation());
            role.add(Mafia.DOCTOR.getTranslation());
        }
        if((numberPeople == 10)||(numberPeople == 11)){
            while (role.size() != numberPeople - 5) {
                role.add(Mafia.INNOCENT.getTranslation());
            }
            role.add(Mafia.MAFIA.getTranslation());
            role.add(Mafia.MAFIA.getTranslation());
            role.add(Mafia.DONMAFIA.getTranslation());
            role.add(Mafia.COMMISSAR.getTranslation());
            role.add(Mafia.DOCTOR.getTranslation());
        }
        if(numberPeople >= 12){
            while (role.size() != numberPeople - 6) {
                role.add(Mafia.INNOCENT.getTranslation());
            }
            role.add(Mafia.MAFIA.getTranslation());
            role.add(Mafia.MAFIA.getTranslation());
            role.add(Mafia.DONMAFIA.getTranslation());
            role.add(Mafia.COMMISSAR.getTranslation());
            role.add(Mafia.DOCTOR.getTranslation());
        }
    }
    public String randomRoleMafia(){
        String rolePeople;
        if(role.size() != 0){
           rolePeople = role.get(rnd.nextInt(role.size() - 1));
           role.remove(rolePeople);
           return rolePeople;
        }
        return "Роли закончились";
    }

}
