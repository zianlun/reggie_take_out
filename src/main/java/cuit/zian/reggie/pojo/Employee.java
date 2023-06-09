package cuit.zian.reggie.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.ToString;

import java.util.Date;

@ToString
public class Employee {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.id
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.name
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.username
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.password
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.phone
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.sex
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.id_number
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private String idNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.status
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.create_time
     *
            * @mbggenerated Sun Apr 23 11:39:14 CST 2023
            */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.update_time
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.create_user
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private Long createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.update_user
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    private Long updateUser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.id
     *
     * @return the value of employee.id
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.id
     *
     * @param id the value for employee.id
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.name
     *
     * @return the value of employee.name
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.name
     *
     * @param name the value for employee.name
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.username
     *
     * @return the value of employee.username
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.username
     *
     * @param username the value for employee.username
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.password
     *
     * @return the value of employee.password
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.password
     *
     * @param password the value for employee.password
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.phone
     *
     * @return the value of employee.phone
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.phone
     *
     * @param phone the value for employee.phone
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.sex
     *
     * @return the value of employee.sex
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.sex
     *
     * @param sex the value for employee.sex
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.id_number
     *
     * @return the value of employee.id_number
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.id_number
     *
     * @param idNumber the value for employee.id_number
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.status
     *
     * @return the value of employee.status
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.status
     *
     * @param status the value for employee.status
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.create_time
     *
     * @return the value of employee.create_time
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.create_time
     *
     * @param createTime the value for employee.create_time
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.update_time
     *
     * @return the value of employee.update_time
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.update_time
     *
     * @param updateTime the value for employee.update_time
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.create_user
     *
     * @return the value of employee.create_user
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.create_user
     *
     * @param createUser the value for employee.create_user
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.update_user
     *
     * @return the value of employee.update_user
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.update_user
     *
     * @param updateUser the value for employee.update_user
     *
     * @mbggenerated Sun Apr 23 11:39:14 CST 2023
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}