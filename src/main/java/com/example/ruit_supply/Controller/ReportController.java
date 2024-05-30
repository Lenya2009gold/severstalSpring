package com.example.ruit_supply.Controller;

import com.example.ruit_supply.Entity.Delivery;
import com.example.ruit_supply.Entity.ReportEntry;
import com.example.ruit_supply.Service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping
    public List<ReportEntry> generateReport(@RequestParam("startDate") String startDate
    ,@RequestParam("endDate") String endDate)
    {
        LocalDate strat=LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return reportService.generateReport(strat,end);
    }
}
