package javacore;

import java.util.List;
import java.util.UUID;

/**
 * Represents a maintenance action that can be performed on a component.
 */
public class MaintenanceAction {
    private final String actionId;
    private final String name;
    private final MaintenanceType maintenanceType;
    private final int meanTimeBetweenMaintenance; // MTBM in hours
    private final List<MaintenanceTask> maintenanceTasks;

    /**
     * Constructor to create a MaintenanceAction instance.
     *
     * @param name                     the name of the maintenance action
     * @param maintenanceType          the type of maintenance action
     * @param meanTimeBetweenMaintenance the average time in hours between maintenance actions
     * @param maintenanceTasks         list of maintenance tasks associated with this action
     */
    public MaintenanceAction(String name, MaintenanceType maintenanceType, int meanTimeBetweenMaintenance, List<MaintenanceTask> maintenanceTasks) {
        this.actionId = UUID.randomUUID().toString(); // Unique identifier
        this.name = name;
        this.maintenanceType = maintenanceType;
        this.meanTimeBetweenMaintenance = meanTimeBetweenMaintenance;
        this.maintenanceTasks = maintenanceTasks;
    }

    // Getters
    public String getActionId() {
        return actionId;
    }

    public String getName() {
        return name;
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public int getMeanTimeBetweenMaintenance() {
        return meanTimeBetweenMaintenance;
    }

    public List<MaintenanceTask> getMaintenanceTasks() {
        return maintenanceTasks;
    }

    // Method to add a new task to the Maintenance Action
    public void addTask(MaintenanceTask task) {
        maintenanceTasks.add(task);
    }

    /**
     * Provides a string representation of the MaintenanceAction.
     */
    @Override
    public String toString() {
        return "MaintenanceAction{" +
                "actionId='" + actionId + '\'' +
                ", name='" + name + '\'' +
                ", maintenanceType=" + maintenanceType +
                ", meanTimeBetweenMaintenance=" + meanTimeBetweenMaintenance +
                ", maintenanceTasks=" + maintenanceTasks +
                '}';
    }
}
