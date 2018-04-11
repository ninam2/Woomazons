package de.asideas.texx.service;

import de.asideas.texx.data.LabelRepository;
import de.asideas.texx.data.ShopRepository;
import de.asideas.texx.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RepositoryService {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private ShopRepository shopRepository;

    public List<String> getAllLabelNames() {
        List<String> labelNames = new ArrayList<>();
        Iterator<Label> all = labelRepository.findAll().iterator();
        while (all.hasNext()) {
            labelNames.add(all.next().getName());

        }
        return labelNames;
    }
}
