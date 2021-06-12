package main;

public class Manager extends Employee{
    public Manager(int ID, CallCenter callCenter) {
        super(Rank.MANAGER, ID, callCenter);
    }
}
