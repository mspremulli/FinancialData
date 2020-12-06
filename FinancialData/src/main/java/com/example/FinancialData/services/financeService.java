package com.example.FinancialData.services;

import com.example.FinancialData.models.FinanceRecord;
import com.example.FinancialData.repositories.financeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class financeService {
  @Autowired
  private financeRepository repository;

  public void addRecord(FinanceRecord record){
    repository.save(record);
  }
}
