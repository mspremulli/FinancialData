package com.example.FinancialData.helpers;

import com.example.FinancialData.models.FinanceRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {

  public static List<FinanceRecord> fileSplitter(MultipartFile file, int numOfRows) throws IOException {
    int numOfFiles = (int) Math.sqrt(numOfRows);
    ArrayList<String> fileText = new ArrayList<>();

    Reader reader = new InputStreamReader(file.getInputStream());

    BufferedReader br = new BufferedReader(reader);
    String header = br.readLine();
    int counter = 0;
    StringBuilder tempFile = new StringBuilder();

    String line = "";
    while ((line = br.readLine()) != null) {
     if(counter < numOfFiles){
       tempFile.append(line).append("\n");
      counter++;
     }
     else{
       fileText.add(tempFile.toString());
       counter = 0;
       tempFile = new StringBuilder();
     }
    }
    if(!tempFile.toString().equals("")) fileText.add(tempFile.toString());

    ArrayList<FinanceRecord> recordsList = new ArrayList<>();
//    String header = "step,type,amount,nameOrig,oldBalanceOrg,newBalanceOrig,nameDest,oldBalanceDest,newBalanceDest,isFraud \n";
    for (String text : fileText ) {
//      recordsList.addAll(csvImport(new File(header + "\n" + text)));
    }
    recordsList.addAll(csvImport(new File(header + "\n" + fileText.get(0))));
    return recordsList;
  }

  public static List<FinanceRecord> csvImport(File file) throws IOException {
    String[] headers = { "step", "type", "amount", "nameOrig", "oldBalanceOrg", "newBalanceOrig", "nameDest", "oldBalanceDest", "newBalanceDest", "isFraud", "isFlaggedFraud" };

    Reader reader = new InputStreamReader(new FileInputStream(file));

    Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT
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
