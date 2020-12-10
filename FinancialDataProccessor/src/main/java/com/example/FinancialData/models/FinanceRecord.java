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
  private String type;
  private double amount;
  private String nameOrig;
  private double oldBalanceOrg;
  private String nameDest;
  private double newBalanceOrig;
  private double oldBalanceDest;
  private double newBalanceDest;
  private int isFraud ;

  public FinanceRecord(int step,
                       String type,
                       double amount,
                       String nameOrig,
                       double oldBalanceOrg,
                       String nameDest,
                       double newBalanceOrig,
                       double oldBalanceDest,
                       double newBalanceDest,
                       int isFraud) {
    this.step = step;
    this.type = type;
    this.amount = amount;
    this.nameOrig = nameOrig;
    this.oldBalanceOrg = oldBalanceOrg;
    this.nameDest = nameDest;
    this.newBalanceOrig = newBalanceOrig;
    this.oldBalanceDest = oldBalanceDest;
    this.newBalanceDest = newBalanceDest;
    this.isFraud = isFraud;
  }

  public FinanceRecord() {
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

  public void setId(long id) {
    this.id = id;
  }

  public void setStep(int step) {
    this.step = step;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setNameOrig(String nameOrig) {
    this.nameOrig = nameOrig;
  }

  public void setOldBalanceOrg(double oldBalanceOrg) {
    this.oldBalanceOrg = oldBalanceOrg;
  }

  public void setNewBalanceOrig(double newBalanceOrig) {
    this.newBalanceOrig = newBalanceOrig;
  }

  public void setOldBalanceDest(double oldBalanceDest) {
    this.oldBalanceDest = oldBalanceDest;
  }

  public void setNewBalanceDest(double newBalanceDest) {
    this.newBalanceDest = newBalanceDest;
  }

  public void setNameDest(String nameDest) {
    this.nameDest = nameDest;
  }

  public void setIsFraud(int isFraud) {
    this.isFraud = isFraud;
  }
}
