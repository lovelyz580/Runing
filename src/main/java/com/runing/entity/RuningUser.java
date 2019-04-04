package com.runing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class RuningUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_id
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_name
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_sex
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    private Integer userSex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_header
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    private String userHeader;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_birthday
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date userBirthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_isdel
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    private Integer userIsdel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_createtime
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date userCreatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column runing_user.user_updatetime
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date userUpdatetime;
    // 版本信息
    /**
     * 版本号
     */
    private String version;

    // 分页数据
    /**
     * 当前页数(如果不进行分页，该条数据默认为-1)
     */
    private Integer pagenumber;

    /**
     * 每页的数据量
     */
    private Integer pagesize;

    // 操作数据

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public List<String> getUuidlist() {
        return uuidlist;
    }

    public void setUuidlist(List<String> uuidlist) {
        this.uuidlist = uuidlist;
    }

    /**
     * 根据uuidlist删除信息时使用
     */
    private List<String> uuidlist;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_id
     *
     * @return the value of runing_user.user_id
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_id
     *
     * @param userId the value for runing_user.user_id
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_name
     *
     * @return the value of runing_user.user_name
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_name
     *
     * @param userName the value for runing_user.user_name
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_sex
     *
     * @return the value of runing_user.user_sex
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_sex
     *
     * @param userSex the value for runing_user.user_sex
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_header
     *
     * @return the value of runing_user.user_header
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public String getUserHeader() {
        return userHeader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_header
     *
     * @param userHeader the value for runing_user.user_header
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserHeader(String userHeader) {
        this.userHeader = userHeader == null ? null : userHeader.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_birthday
     *
     * @return the value of runing_user.user_birthday
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_birthday
     *
     * @param userBirthday the value for runing_user.user_birthday
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_isdel
     *
     * @return the value of runing_user.user_isdel
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public Integer getUserIsdel() {
        return userIsdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_isdel
     *
     * @param userIsdel the value for runing_user.user_isdel
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserIsdel(Integer userIsdel) {
        this.userIsdel = userIsdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_createtime
     *
     * @return the value of runing_user.user_createtime
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public Date getUserCreatetime() {
        return userCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_createtime
     *
     * @param userCreatetime the value for runing_user.user_createtime
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserCreatetime(Date userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column runing_user.user_updatetime
     *
     * @return the value of runing_user.user_updatetime
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public Date getUserUpdatetime() {
        return userUpdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column runing_user.user_updatetime
     *
     * @param userUpdatetime the value for runing_user.user_updatetime
     *
     * @mbg.generated Mon Apr 01 14:34:08 CST 2019
     */
    public void setUserUpdatetime(Date userUpdatetime) {
        this.userUpdatetime = userUpdatetime;
    }
}