package de.asideas.texx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "label_id")
    private List<Label> labels = new ArrayList<>();

    public Shop(String name, List<Label> labels) {
        this.name = name;
        this.labels = labels;
    }
}
