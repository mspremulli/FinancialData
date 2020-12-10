package com.example.FinancialData.repositories;

import com.example.FinancialData.models.FinanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface financeRepository extends JpaRepository<FinanceRecord, Long> {
}
