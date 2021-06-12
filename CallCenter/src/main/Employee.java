package main;

abstract class Employee {
    protected Rank rank;
    private int id;
    private boolean availability;
    protected CallCenter callCenter;

    public Employee(Rank rank, int ID, CallCenter callCenter){
        this.rank = rank;
        this.id = ID;
        this.availability = true;
        this.callCenter = callCenter;
    }

    public void setAvailable() {
        availability = true;
    }

    public void setUnavailable(){
        availability = false;
    }

    public boolean isAvail(){
        return availability;
    }

    public void receiveCall(Call call){
        if (call.canHandle()) {
            call.completed();
            setAvailable();
        } else {
            escalateCall(call);
        }
    }

    public void escalateCall(Call call) {
        if (rank != Rank.DIRECTOR) {
            call.incrementRank();
            callCenter.dispatchCall(call);
        } else {
            System.out.println("Error. Unable to escalate anymore");
        }
    }
}
