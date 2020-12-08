package com.example.FinancialData.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FinanceRecord {

  @Id
  @GeneratedValue
  private long id;

  private int step;
  private  String  type;
  private double amount;
  private  String nameOrig;
  private double oldBalanceOrg;
  private double newBalanceOrig;
  private double oldBalanceDest;
  private double newBalanceDest;
  private  String nameDest;
  private int isFraud ;

  public FinanceRecord() {
  }

  public FinanceRecord(long id,
                       int step,
                       String type,
                       double amount,
                       String nameOrig,
                       double oldBalanceOrg,
                       double newBalanceOrig,
                       double oldBalanceDest,
                       double newBalanceDest,
                       String nameDest,
                       int isFraud) {
    this.id = id;
    this.step = step;
    this.type = type;
    this.amount = amount;
    this.nameOrig = nameOrig;
    this.oldBalanceOrg = oldBalanceOrg;
    this.newBalanceOrig = newBalanceOrig;
    this.newBalanceDest = newBalanceDest;
    this. oldBalanceDest = oldBalanceDest;
    this.nameDest = nameDest;
    this.isFraud = isFraud;
  }

  public long getId() {
    return id;
  }

  public int getStep() {
    return step;
  }

  public String getType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }

  public String getNameOrig() {
    return nameOrig;
  }

  public double getOldBalanceOrg() {
    return oldBalanceOrg;
  }

  public double getNewBalanceOrig() {
    return newBalanceOrig;
  }

  public double getOldBalanceDest() {
    return oldBalanceDest;
  }

  public double getNewBalanceDest() {
    return newBalanceDest;
  }

  public String getNameDest() {
    return nameDest;
  }

  public int getIsFraud() {
    return isFraud;
  }
}
