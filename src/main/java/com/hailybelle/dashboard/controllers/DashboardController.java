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
        return "create-dashboard";
    }

    @PostMapping("/process")
    public String processDashboard(
            @RequestParam("dashboardTitle") String title,
            @RequestParam("dataSource") String dataSource,
            @RequestParam("componentTitle") String componentTitle,
            Model model) {
        Dashboard dashboard = new Dashboard();
        dashboard.setTitle(title);
        dashboard.setDataSource(dataSource);
        dashboard.setComponentTitle(componentTitle);

        dashboardService.save(dashboard);
        model.addAttribute("dashboard", dashboard);

        return "redirect:/dashboard/configure?id=" + dashboard.getId();
    }

    @GetMapping("/configure")
    public String configureDashboard(@RequestParam("id") Long id, Model model) {
        Dashboard dashboard = dashboardService.findById(id);
        model.addAttribute("dashboard", dashboard);
        return "create-dashboard"; // Updated to use create-dashboard.html
    }

    @PostMapping("/upload-csv")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id, Model model) {
        // Logic to handle CSV file upload
        // Parse the file and save data as needed

        Dashboard dashboard = dashboardService.findById(id);
        // Assuming you add data from CSV to the dashboard here
        model.addAttribute("dashboard", dashboard);
        return "redirect:/dashboard/configure?id=" + id;
    }
}

