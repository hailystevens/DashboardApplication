package com.hailybelle.dashboard.services;

import com.hailybelle.dashboard.models.Dashboard;
import com.hailybelle.dashboard.repositories.DashboardRepository;
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

    // Process CSV file
    public void processCsvFile(MultipartFile file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Process each line of the CSV file
                System.out.println(line); // Replace with actual processing logic
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to process CSV file", e);
        }
    }

    // Retrieve data from database
    public void retrieveDataFromDatabase(String dbConnection) {
        try (Connection connection = DriverManager.getConnection(dbConnection)) {
            String query = "SELECT * FROM your_table"; // Modify this query as needed
            try (Statement stmt = connection.createStatement()) {
                // Execute query and process the result set
                // ResultSet rs = stmt.executeQuery(query);
                // while (rs.next()) {
                //     // Process each row of data
                // }
                System.out.println("Connected to the database and retrieved data."); // Replace with actual processing logic
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }
}
