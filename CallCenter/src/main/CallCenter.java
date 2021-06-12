package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallCenter {

    int numRespondents = 20;
    int numManagers = 5;
    int numDirectors = 2;

    List<List<Employee>> employees = new ArrayList<>();
    List<Queue<Call>> callQueues = new ArrayList<>();

    public CallCenter(int respondents, int managers, int directors) {
        for (int i = 0; i < 3; i++) {
            List<Employee> respondentList = new ArrayList<>();
            for (int j = 1; j <= respondents; j++) {
                respondentList.add(new Respondent(j+1000, this));
            }
            employees.add(respondentList);
            callQueues.add(new LinkedList<>());
            List<Employee> managersList = new ArrayList<>();
            for (int j = 1; j <= managers; j++) {
                managersList.add(new Manager(j+100, this));
            }
            employees.add(managersList);
            callQueues.add(new LinkedList<>());

            List<Employee> directorsList = new ArrayList<>();
            for (int j = 1; j <= directors; j++) {
                directorsList.add(new Director(j, this));
            }
            employees.add(directorsList);
            callQueues.add(new LinkedList<>());
        }
    }

    public List<Employee> getEmployeeListFromRank(Rank rank){
        if (rank == Rank.RESPONDENT) return employees.get(0);
        if (rank == Rank.MANAGER) return employees.get(1);
        if (rank == Rank.DIRECTOR) return employees.get(2);
        return null;
    }

    public Queue<Call> getCallQueueFromRank(Rank rank){
        if (rank == Rank.RESPONDENT) return callQueues.get(0);
        if (rank == Rank.MANAGER) return callQueues.get(1);
        if (rank == Rank.DIRECTOR) return callQueues.get(2);
        return null;
    }

    public Employee getEmployeeForCall(Call call){
        List<Employee> rankingEmployees = getEmployeeListFromRank(call.getRank());
        for (Employee employee: rankingEmployees){
            if (employee.isAvail()){
                return employee;
            }
        }
        return null;
    }

    public boolean dispatchCall(Call call){
        Employee emp = getEmployeeForCall(call);
        if (emp != null){
            emp.setUnavailable();
            emp.receiveCall(call);
        } else {
            Queue<Call> callQueue = getCallQueueFromRank(call.getRank());
            callQueue.offer(call);
        }
        return false;
    }

    public boolean assignCall(Employee emp){
        Queue<Call> callQueue = getCallQueueFromRank(emp.rank);
        Call call = callQueue.poll();
        if (call != null){
            emp.receiveCall(call);
        } else {
            System.out.println("No more call in queue for " + emp.rank);
        }
        return false;
    }
}

