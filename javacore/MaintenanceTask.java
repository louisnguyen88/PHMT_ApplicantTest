package javacore;

import java.util.UUID;

/**
 * Represents an individual task within a maintenance action.
 */
public class MaintenanceTask {
    private final String taskId;
    private final String name;
    private final int duration; // Duration in hours
    private final String personnelType;
    private final double hourlyRate;
    private final int numberOfPersonnel;

    /**
     * Constructor to create a MaintenanceTask instance.
     *
     * @param name             the name of the task
     * @param duration         duration in hours to complete the task
     * @param personnelType    type of personnel needed to complete the task
     * @param hourlyRate       hourly rate for personnel performing the task
     * @param numberOfPersonnel number of personnel required for the task
     */
    public MaintenanceTask(String name, int duration, String personnelType, double hourlyRate, int numberOfPersonnel) {
        this.taskId = UUID.randomUUID().toString(); // Unique identifier
        this.name = name;
        this.duration = duration;
        this.personnelType = personnelType;
        this.hourlyRate = hourlyRate;
        this.numberOfPersonnel = numberOfPersonnel;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getNumberOfPersonnel() {
        return numberOfPersonnel;
    }

    /**
     * Provides a string representation of the MaintenanceTask.
     */
    @Override
    public String toString() {
        return "MaintenanceTask{" +
                "taskId='" + taskId + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", personnelType='" + personnelType + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", numberOfPersonnel=" + numberOfPersonnel +
                '}';
    }
}
