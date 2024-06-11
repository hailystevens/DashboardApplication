package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.Dashboard;
import com.hailybelle.dashboard.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardComponentController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/create-dashboard")
    public String createDashboardForm(Model model) {
        return "create_dashboard"; // Make sure this corresponds to your create_dashboard.html
    }

    @PostMapping("/process-dashboard")
    public String processDashboard(@RequestParam("dashboardTitle") String title,
                                   @RequestParam("dataSource") String dataSource,
                                   Model model) {
        Dashboard dashboard = new Dashboard();
        dashboard.setTitle(title);

        // Handle different data sources
        switch (dataSource) {
            case "csv":
                dashboard.setDataSource("CSV Upload");
                break;
            case "bigquery":
                dashboard.setDataSource("Google BigQuery");
                break;
            case "scratch":
                dashboard.setDataSource("Start from Scratch");
                break;
            default:
                dashboard.setDataSource("Unknown");
        }

        dashboardService.save(dashboard);
        model.addAttribute("dashboard", dashboard);

        return "redirect:/configure-dashboard"; // Redirect to the next configuration page
    }
}


