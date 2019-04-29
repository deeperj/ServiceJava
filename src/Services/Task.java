package Services;

import Database.TaskStore;

public class Task {
    private TaskStore taskStore;
    private int taskNumber;
    private String taskName;
    private String taskDescription;

    public TaskStore getTaskStore() {
        return taskStore;
    }

    public void setTaskStore(TaskStore taskStore) {
        this.taskStore = taskStore;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Task(){
        taskStore=new TaskStore();
    }

    public boolean insert(){
        if(!taskStore.exists(this))
            return taskStore.insert(this);
        return false;
    }
}
