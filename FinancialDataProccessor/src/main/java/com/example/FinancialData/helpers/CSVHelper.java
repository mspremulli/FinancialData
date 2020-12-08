package com.example.FinancialData.helpers;

import com.example.FinancialData.models.FinanceRecord;
import org.apache.commons.csv.CSVParser;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class CSVHelper {
//  public static String TYPE = "text/csv";
//  static String[] headers = { "Id", "Title", "Description", "Published" };

//  public static boolean hasCSVFormat(MultipartFile file) {
//
//    if (!TYPE.equals(file.getContentType())) {
//      return false;
//    }
//
//    return true;
//  }

  public static List<FinanceRecord> csvImport(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
         CSVParser csvParser = new CSVParser(fileReader,
                 CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
         ) {

      List<FinanceRecord> records = new ArrayList<FinanceRecord>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      //todo use mutlithreading
      for (CSVRecord csvRecord : csvRecords) {
        FinanceRecord record = new FinanceRecord();
        records.add(record);
      }

      return records;

    } catch (IOException e) {
      throw new RuntimeException("failed to parse CSV file: " + e.getMessage());
    }
  }


}
