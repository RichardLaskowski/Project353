/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author IT353S843
 */
public class StudentBean implements Serializable{
    
    private String dateOfBirth;
     
    private Integer height;
     
    private Integer weight;
     
    private String street;
     
    private String city;
    
    private String country;
     
    private String postalCode;
     
    private String phoneNo;
     
    private String schoolName;
 
    private String endYear;
    
    private Integer SAT;
    
    private Integer PSAT;
    
    private Integer ACT;
    
    private String certification;
    
    private String hobbies;
    
    private String essayOfChoice;
    
    private String universitiesOfChoice;
    
    private String majorsOfChoice;

    public StudentBean(String dateOfBirth, Integer height, Integer weight, String street, String city, 
            String country, String postalCode, String phoneNo, String schoolName, String endYear, Integer SAT,
            Integer PSAT, Integer ACT, String certification, String hobbies, String essayOfChoice, 
            String universitiesOfChoice, String majorsOfChoice) {
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNo = phoneNo;
        this.schoolName = schoolName;
        this.endYear = endYear;
        this.SAT = SAT;
        this.PSAT = PSAT;
        this.ACT = ACT;
        this.certification = certification;
        this.hobbies = hobbies;
        this.essayOfChoice = essayOfChoice;
        this.universitiesOfChoice = universitiesOfChoice;
        this.majorsOfChoice = majorsOfChoice;
        
    }

    public StudentBean() {
    }
    

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the schoolName
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName the schoolName to set
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return the endYear
     */
    public String getEndYear() {
        return endYear;
    }

    /**
     * @param endYear the endYear to set
     */
    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    /**
     * @return the SAT
     */
    public Integer getSAT() {
        return SAT;
    }

    /**
     * @param SAT the SAT to set
     */
    public void setSAT(Integer SAT) {
        this.SAT = SAT;
    }

    /**
     * @return the PSAT
     */
    public Integer getPSAT() {
        return PSAT;
    }

    /**
     * @param PSAT the PSAT to set
     */
    public void setPSAT(Integer PSAT) {
        this.PSAT = PSAT;
    }

    /**
     * @return the ACT
     */
    public Integer getACT() {
        return ACT;
    }

    /**
     * @param ACT the ACT to set
     */
    public void setACT(Integer ACT) {
        this.ACT = ACT;
    }

    /**
     * @return the certification
     */
    public String getCertification() {
        return certification;
    }

    /**
     * @param certification the certification to set
     */
    public void setCertification(String certification) {
        this.certification = certification;
    }

    /**
     * @return the hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @return the essayOfChoice
     */
    public String getEssayOfChoice() {
        return essayOfChoice;
    }

    /**
     * @param essayOfChoice the essayOfChoice to set
     */
    public void setEssayOfChoice(String essayOfChoice) {
        this.essayOfChoice = essayOfChoice;
    }

    /**
     * @return the universitiesOfChoice
     */
    public String getUniversitiesOfChoice() {
        return universitiesOfChoice;
    }

    /**
     * @param universitiesOfChoice the universitiesOfChoice to set
     */
    public void setUniversitiesOfChoice(String universitiesOfChoice) {
        this.universitiesOfChoice = universitiesOfChoice;
    }

    /**
     * @return the majorsOfChoice
     */
    public String getMajorsOfChoice() {
        return majorsOfChoice;
    }

    /**
     * @param majorsOfChoice the majorsOfChoice to set
     */
    public void setMajorsOfChoice(String majorsOfChoice) {
        this.majorsOfChoice = majorsOfChoice;
    }
   
}
