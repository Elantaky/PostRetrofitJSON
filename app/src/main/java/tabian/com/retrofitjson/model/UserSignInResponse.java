package tabian.com.retrofitjson.model;

public class UserSignInResponse {
    String email,firstName,phoneNo,lastName,success,aid;

    public UserSignInResponse(String email, String firstName, String phoneNo, String lastName, String success, String aid) {
        this.email = email;
        this.firstName = firstName;
        this.phoneNo = phoneNo;
        this.lastName = lastName;
        this.success = success;
        this.aid = aid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
