package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.Dashboard;
import com.hailybelle.dashboard.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @PostMapping("/process")
    public String processDashboard(
            @RequestParam("dashboardTitle") String title,
            @RequestParam("dataSource") String dataSource,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "dbConnection", required = false) String dbConnection,
            @RequestParam("theme") String theme,
            @RequestParam(value = "manualData", required = false) String manualData,
            Model model) {
        Dashboard dashboard = new Dashboard();
        dashboard.setTitle(title);
        dashboard.setDataSource(dataSource);
        dashboard.setTheme(theme);

        if ("csv".equals(dataSource) && file != null) {
            // Process CSV file
            dashboardService.processCsvFile(file);
        } else if ("database".equals(dataSource) && dbConnection != null) {
            // Process database connection
            dashboardService.retrieveDataFromDatabase(dbConnection);
        } else if ("manual".equals(dataSource) && manualData != null) {
            // Process manual data
            dashboardService.processManualData(manualData);
        } else {
            model.addAttribute("error", "Invalid data source or missing file/connection string");
            return "create_dashboard";
        }

        dashboardService.save(dashboard);
        model.addAttribute("dashboard", dashboard);

        return "redirect:/dashboard/view?id=" + dashboard.getId();
    }

    @GetMapping("/view")
    public String viewDashboard(@RequestParam("id") Long id, Model model) {
        Dashboard dashboard = dashboardService.findById(id);
        model.addAttribute("dashboard", dashboard);
        return "dashboard";
    }
}
