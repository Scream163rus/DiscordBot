package ru.zagrebin.diploma.models;

public enum Mafia {
    MAFIA("Мафия"), DONMAFIA("Дон мафии"),DOCTOR("Доктор"),
    INNOCENT("Мирный житель"), COMMISSAR("Коммисар");
    private String translation;
    Mafia(String translation){
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}