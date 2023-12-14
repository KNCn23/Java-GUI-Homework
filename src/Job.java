// Abstract class for generic job
public abstract class Job {
    private String title;
    private String description;

    // Constructor for Job
    public Job(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Title getter and setter
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // Description getter and setter
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}


