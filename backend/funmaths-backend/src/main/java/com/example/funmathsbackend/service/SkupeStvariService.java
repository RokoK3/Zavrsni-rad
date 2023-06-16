package com.example.funmathsbackend.service;
import com.example.funmathsbackend.model.SkupeStvari;
import com.example.funmathsbackend.repository.SkupeStvariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SkupeStvariService {
    @Autowired
    private SkupeStvariRepository skupeStvariRepository;

    public SkupeStvari getRandomExpensiveItem() {
        List<SkupeStvari> allItems = skupeStvariRepository.findAll();
        if (allItems.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return allItems.get(random.nextInt(allItems.size()));
    }
}