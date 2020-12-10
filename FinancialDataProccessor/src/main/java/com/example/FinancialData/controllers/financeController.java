package com.example.FinancialData.controllers;

import com.example.FinancialData.services.financeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class financeController {
  @Autowired
  private financeService service;

  @PostMapping("/upload")
  public void uploadFile(@RequestParam("file") MultipartFile file) {
    service.importCVS(file);
  }
}
