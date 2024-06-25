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

    @GetMapping("/create")
    public String showCreateDashboardForm(Model model) {
        model.addAttribute("dashboard", new Dashboard());
        return "create_dashboard";
    }

    @PostMapping("/process")
    public String processDashboard(
            @RequestParam("dashboardTitle") String title,
            @RequestParam("dataSource") String dataSource,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "dbConnection", required = false) String dbConnection,
            @RequestParam("componentTitle") String componentTitle,
            @RequestParam("theme") String theme,
            @RequestParam("showGrid") boolean showGrid,
            @RequestParam("refreshInterval") int refreshInterval,
            Model model) {
        Dashboard dashboard = new Dashboard();
        dashboard.setTitle(title);
        dashboard.setDataSource(dataSource);
        dashboard.setComponentTitle(componentTitle);
        dashboard.setTheme(theme);
        dashboard.setShowGrid(showGrid);
        dashboard.setRefreshInterval(refreshInterval);

        if ("csv".equals(dataSource) && file != null) {
            // Process CSV file
            dashboardService.processCsvFile(file);
        } else if ("database".equals(dataSource) && dbConnection != null) {
            // Process database connection
            dashboardService.retrieveDataFromDatabase(dbConnection);
        } else {
            model.addAttribute("error", "Invalid data source or missing file/connection string");
            return "create_dashboard";
        }

        dashboardService.save(dashboard);
        model.addAttribute("dashboard", dashboard);

        return "redirect:/dashboard/configure?id=" + dashboard.getId();
    }

    @GetMapping("/configure")
    public String configureDashboard(@RequestParam("id") Long id, Model model) {
        Dashboard dashboard = dashboardService.findById(id);
        model.addAttribute("dashboard", dashboard);
        return "dashboard";
    }

    @PostMapping("/upload-csv")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        // Logic to handle CSV file upload
        return "redirect:/dashboard/configure";
    }

    @PostMapping("/generate-dashboard")
    public String generateDashboard(@RequestParam("id") Long id, Model model) {
        Dashboard dashboard = dashboardService.findById(id);
        model.addAttribute("dashboard", dashboard);
        return "dashboard";
    }

    @GetMapping("/preview-dashboard")
    public String previewDashboard(@RequestParam("id") Long id, Model model) {
        Dashboard dashboard = dashboardService.findById(id);
        model.addAttribute("dashboard", dashboard);
        return "dashboard";
    }

    @GetMapping("/download-dashboard")
    public String downloadDashboard(@RequestParam("id") Long id, Model model) {
        Dashboard dashboard = dashboardService.findById(id);
        model.addAttribute("dashboard", dashboard);
        return "dashboard";
    }
}


