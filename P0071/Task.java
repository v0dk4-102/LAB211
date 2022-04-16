/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0071;

/**
 *
 * @author DELL
 */
public class Task {
    private int taskID;
    private String taskTypeID;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int taskID, String taskTypeID, String requirementName, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.taskID = taskID;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        double time = planTo -planFrom;
        String workingTime = String.format("%.1f", time);
        String result = String.format("%-7d%-20s%-12s%-15s%-7s%-15s%-15s", taskID, requirementName, taskTypeID, date, workingTime, assignee, reviewer );
        return result;
    }
    
    
}
