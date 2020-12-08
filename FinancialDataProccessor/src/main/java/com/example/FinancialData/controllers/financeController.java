package com.example.FinancialData.controllers;

import com.example.FinancialData.models.FinanceRecord;
import com.example.FinancialData.services.financeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class financeController {
  @Autowired
  private financeService service;

  @PostMapping
  public FinanceRecord addRecord(@RequestBody FinanceRecord record){
    service.addRecord(record);
    return record;
  }
}
