package ru.zagrebin.diploma.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bunker",schema = "public")
public class Bunker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String catastrophe,descriptionsBunker,baggage,health,
            biologicalCharacteristics,hobby,humanQuality,
            phobia,additionalSkills,specialConditions,professions;
}