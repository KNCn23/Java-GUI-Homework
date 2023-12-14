public class TechJob extends Job {
    private String techStack;

    // Constructor for TechJob
    public TechJob(String title, String description, String techStack) {
        super(title, description);
        this.techStack = techStack;
    }

    // TechStack getter and setter
    public String getTechStack() { return techStack; }
    public void setTechStack(String techStack) { this.techStack = techStack; }
}