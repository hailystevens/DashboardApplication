package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.DataEntry;
import com.hailybelle.dashboard.services.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class DataEntryController {

    @Autowired
    private DataEntryService dataEntryService;

    @GetMapping("/data")
    public String showDataEntryForm(Model model) {
        model.addAttribute("dataEntry", new DataEntry());
        return "data_entry";
    }

    @PostMapping("/data")
    public String saveDataEntry(@ModelAttribute DataEntry dataEntry, Principal principal) {
        dataEntry.setUserId(principal.getName());
        dataEntryService.saveDataEntry(dataEntry);
        return "redirect:/dashboard";
    }
}


