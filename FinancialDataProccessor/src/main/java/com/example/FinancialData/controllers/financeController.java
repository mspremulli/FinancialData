package com.example.FinancialData.controllers;

import com.example.FinancialData.models.FinanceRecord;
import com.example.FinancialData.services.financeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class financeController {
  @Autowired
  private financeService service;

  @PostMapping("/upload")
  public List<FinanceRecord> uploadFile(@RequestParam("file") MultipartFile file) {
    return service.importCVS(file);
  }

  @GetMapping("/getAll")
  public Object getAllFiles(){
    return service.getAllRecords();
  }

  @DeleteMapping("/deleteAll")
  public void deleteAll(){
    service.deleteAll();
  }

}

//493535015
//10485760