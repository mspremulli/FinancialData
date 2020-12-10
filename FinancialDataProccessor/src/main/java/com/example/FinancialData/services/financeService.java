package com.example.FinancialData.services;

import com.example.FinancialData.helpers.CSVHelper;
import com.example.FinancialData.models.FinanceRecord;
import com.example.FinancialData.repositories.financeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class financeService {
  @Autowired
  private financeRepository repository;

  public void importCVS(MultipartFile file){
    try {
      List<FinanceRecord> records = CSVHelper.csvImport(file.getInputStream());
      repository.saveAll(records);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<FinanceRecord> getAllRecords() {
    return repository.findAll();
  }

  public void addRecord(FinanceRecord record){
    repository.save(record);
  }

  public void deleteAll(){
    repository.deleteAll();
  }


}
