package com.hailybelle.dashboard.repositories;

import com.hailybelle.dashboard.models.DataEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataEntryRepository extends JpaRepository<DataEntry, Long> {
    List<DataEntry> findByUserId(String userId);
}

