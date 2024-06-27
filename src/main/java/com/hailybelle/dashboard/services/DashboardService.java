package com.hailybelle.dashboard.services;

import com.hailybelle.dashboard.models.Dashboard;
import com.hailybelle.dashboard.repositories.DashboardRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public Dashboard save(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    public Dashboard findById(Long id) {
        return dashboardRepository.findById(id).orElse(null);
    }

    public List<Dashboard> findAll() {
        return dashboardRepository.findAll();
    }

    public void deleteById(Long id) {
        dashboardRepository.deleteById(id);
    }

    public void processCsvFile(MultipartFile file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(br);
            for (CSVRecord record : records) {
                System.out.println(record);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to process CSV file", e);
        }
    }

    public void retrieveDataFromDatabase(String dbConnection) {
        try (Connection connection = DriverManager.getConnection(dbConnection)) {
            String query = "SELECT * FROM mydb";
            try (Statement stmt = connection.createStatement()) {
                System.out.println("Connected to the database and retrieved data.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    public void processManualData(String manualData) {
        System.out.println("Manual data: " + manualData);
    }
}
