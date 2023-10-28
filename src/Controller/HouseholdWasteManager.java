/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



/**
 *
 * @author DELL
 */
public class HouseholdWasteManager {
    private int total = 0, time = 0 , count = 0;
    private static final double costLabor = 120000, costDump = 57000;
    
    public double calculateTheCost(int[] garbageAtStations) { 
        if (garbageAtStations != null) {
            calculate(garbageAtStations);
        } 
        double hour = (double) time / 60;
        return hour * costLabor + count *costDump;
    }
    
    public void calculate(int[] garbageAtStations) {
        
        for ( int i = 0; i < garbageAtStations.length ;i++) {
            if (total + garbageAtStations[i] > 10000) {
                time = time + 30;
                count++;
                total = 0;
            }
            total = total + garbageAtStations[i];
            time = time + 8;
        } 
        if (total > 0) {
            time = time + 30;
            count++;
            total = 0;
        }
    }
    public static void main(String[] args) {
        HouseholdWasteManager hm = new HouseholdWasteManager();
        int[] garbageAtStations = {1765, 2808, 952, 4206, 3102, 3902, 1292, 3985, 8324, 1928, 4426, 397, 3277};
        double totalCost = hm.calculateTheCost(garbageAtStations);
        System.out.println("The total cost is "+ totalCost + " VND");
    }
     
    
}
