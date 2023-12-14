import javax.swing.ImageIcon;

public class UserProfile {
    private String name;
    private String email;
    private ImageIcon profilePhoto;

    // UserProfile constructor
    public UserProfile(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Name getter and setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Email getter and setter
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Profile photo getter and setter
    public ImageIcon getProfilePhoto() { return profilePhoto; }
    public void setProfilePhoto(ImageIcon profilePhoto) { this.profilePhoto = profilePhoto; }
}
