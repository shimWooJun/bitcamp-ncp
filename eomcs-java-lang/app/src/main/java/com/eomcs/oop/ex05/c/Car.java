package com.eomcs.oop.ex05.c;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  public boolean sunloof;
  public boolean auto;
  public boolean accel;

  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


