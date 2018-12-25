package tabian.com.retrofitjson.model;

import retrofit2.http.Field;

public class User {
     String email,password,firstName,phoneNo,lastName;

    public User(String email, String password, String firstName, String phoneNo, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.phoneNo = phoneNo;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
