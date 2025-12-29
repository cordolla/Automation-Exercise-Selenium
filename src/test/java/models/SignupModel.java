package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignupModel {
    private String password;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String day;
    private String month;
    private String year;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;
}
