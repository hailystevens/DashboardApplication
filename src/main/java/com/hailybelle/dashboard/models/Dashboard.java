package com.hailybelle.dashboard.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String dataSource;
    private String componentTitle;
    private String theme; // From DashboardConfiguration
    private boolean showGrid; // From DashboardConfiguration
    private int refreshInterval; // From DashboardConfiguration

    // Default constructor
    public Dashboard() {
    }

    // Constructor with parameters
    public Dashboard(String title, String content, String dataSource, String componentTitle, String theme, boolean showGrid, int refreshInterval) {
        this.title = title;
        this.content = content;
        this.dataSource = dataSource;
        this.componentTitle = componentTitle;
        this.theme = theme;
        this.showGrid = showGrid;
        this.refreshInterval = refreshInterval;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getComponentTitle() {
        return componentTitle;
    }

    public void setComponentTitle(String componentTitle) {
        this.componentTitle = componentTitle;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isShowGrid() {
        return showGrid;
    }

    public void setShowGrid(boolean showGrid) {
        this.showGrid = showGrid;
    }

    public int getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }
}

