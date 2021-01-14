package com.example.FinancialData.helpers;

import com.example.FinancialData.models.FinanceRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {

  public static List<FinanceRecord> csvImport(MultipartFile file) throws IOException {
    String[] headers = { "step", "type", "amount", "nameOrig", "oldBalanceOrg", "nameDest", "newBalanceOrig", "oldBalanceDest", "newBalanceDest", "isFraud" };

    Reader reader = new InputStreamReader(file.getInputStream());

    Iterable<CSVRecord> csvRecords =CSVFormat.DEFAULT
            .withHeader(headers)
            .withFirstRecordAsHeader()
            .parse(reader);

    List<FinanceRecord> records = new ArrayList<>();

    for (CSVRecord csvRecord : csvRecords) {
        FinanceRecord record = new FinanceRecord(
                Integer.parseInt(csvRecord.get("step")),
                csvRecord.get("type"),
                Double.parseDouble(csvRecord.get("amount")),
                csvRecord.get("nameOrig"),
                Double.parseDouble(csvRecord.get("oldBalanceOrg")),
                csvRecord.get("nameDest"),
                Double.parseDouble(csvRecord.get("newBalanceOrig")),
                Double.parseDouble(csvRecord.get("oldBalanceDest")),
                Double.parseDouble(csvRecord.get("newBalanceDest")),
                Integer.parseInt(csvRecord.get("isFraud"))
        );
        records.add(record);
      }
    return records;

  }


}
