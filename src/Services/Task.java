package Services;

import Database.TaskStore;

public class Task {
    private TaskStore taskStore;
    private int taskNumber;
    private String processTask;
    private String process;
    private String description;
    private String email;
    private String link;
    private boolean status;

    public Task(){
        taskStore=new TaskStore();
    }
    public insert(){
        taskStore.insert();
    }
    public void exists(Task k){
        taskStore.exists(k);
    }
}
