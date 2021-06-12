package main;

public class Director extends Employee{
    public Director(int ID, CallCenter callCenter) {
        super(Rank.DIRECTOR, ID, callCenter);
    }
}
