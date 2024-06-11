package com.hailybelle.dashboard.services;

import com.hailybelle.dashboard.models.DataEntry;
import com.hailybelle.dashboard.repositories.DataEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataEntryService {

    @Autowired
    private DataEntryRepository dataEntryRepository;

    public List<DataEntry> findByUserId(String userId) {
        return dataEntryRepository.findByUserId(userId);
    }

    public void saveDataEntry(DataEntry dataEntry) {
        dataEntryRepository.save(dataEntry);
    }
}


