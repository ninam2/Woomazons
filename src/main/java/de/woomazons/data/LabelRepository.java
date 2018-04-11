package de.woomazons.data;


import de.woomazons.model.Label;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LabelRepository extends CrudRepository<Label, Long> {

    List<Label> findByName(String name);

}
