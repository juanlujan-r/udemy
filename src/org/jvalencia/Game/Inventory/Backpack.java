package org.jvalencia.Game.Inventory;

import java.util.ArrayList;
import java.util.List;

public class Backpack<T extends Item & Usable>{
 private List<T> contents;

 public Backpack(){
  this.contents = new ArrayList<>();
 }
 public void add (T item){
  this.contents.add(item);
  System.out.println("Stored: " + item.getName() + ".");
 }

 public void checkBackpack(){
  System.out.println("-------Backpack Content:-------");
  for (T item: contents){
   System.out.println("- " + item.getName() +  ": ");
   item.inspect();
  }
 }
 public void useAll(){
  System.out.println("-------¡¡¡¡¡¡¡¡Using Everything!!!!!!!!!-------");
  for (T item: contents){
   System.out.println(item.use());
  }
 }

}

