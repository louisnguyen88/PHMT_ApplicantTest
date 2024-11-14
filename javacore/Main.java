package javacore;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaintenanceTask task1 = new MaintenanceTask("Inspect bolts", 2, "Engineer", 5.0, 1);
        MaintenanceTask task2 = new MaintenanceTask("Replace filter", 1, "Technician", 2.0, 2);

        List<MaintenanceTask> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        MaintenanceAction action = new MaintenanceAction("Engine Maintenance", MaintenanceType.SERVICE, 200, tasks);

        System.out.println(action);
    }
}


