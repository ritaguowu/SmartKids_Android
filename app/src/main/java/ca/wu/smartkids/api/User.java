package ca.wu.smartkids.api;

public class User {
    private String _id;
    private String user_name;
    private String email;
    private String password;
    private String image;
    private String parentId;

    public User(String _id, String user_name, String email, String password, String image, String parentId) {
        this._id = _id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.image = image;
        this.parentId = parentId;
    }

    public String get_id() {
        return _id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public String getParentId() {
        return parentId;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
