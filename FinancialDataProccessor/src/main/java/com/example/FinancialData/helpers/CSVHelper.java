package com.example.FinancialData.helpers;

import com.example.FinancialData.models.FinanceRecord;
import org.apache.commons.csv.CSVParser;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class CSVHelper {

  public static List<FinanceRecord> csvImport(InputStream in) {
    String[] headers = { "step", "type", "amount", "nameOrig", "oldBalanceOrg", "nameDest", "newBalanceOrig", "oldBalanceDest", "newBalanceDest", "isFraud" };

    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(in));
         CSVParser csvParser = new CSVParser(fileReader  //, CSVFormat.POSTGRESQL_CSV.withFirstRecordAsHeader())
                 , CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase())
         ) {

      List<FinanceRecord> records = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      //todo use mutlithreading
      for (CSVRecord csvRecord : csvRecords) {
        FinanceRecord record = new FinanceRecord(
                Integer.parseInt(csvRecord.get("step")),
                csvRecord.get("type"),
                Integer.parseInt(csvRecord.get("amount")),
                csvRecord.get("nameOrig"),
                Integer.parseInt(csvRecord.get("oldBalanceOrg")),
                csvRecord.get("nameDest"),
                Integer.parseInt(csvRecord.get("newBalanceOrig")),
                Integer.parseInt(csvRecord.get("oldBalanceDest")),
                Integer.parseInt(csvRecord.get("newBalanceDest")),
                Integer.parseInt(csvRecord.get("isFraud"))

        );
        records.add(record);
      }

      return records;

    } catch (IOException e) {
      throw new RuntimeException("Failed to import file: " + e.getMessage());
    }
  }


}
