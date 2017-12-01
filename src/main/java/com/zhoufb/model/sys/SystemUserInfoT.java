package com.zhoufb.model.sys;


import java.io.Serializable;
import java.util.Date;

public class SystemUserInfoT implements Serializable{
    private String account;

    private String employeename;

    private Integer departmentId;

    private String userName;

    private String password;

    private String sex;

    private String position;

    private String address;

    private String telphone;

    private Integer valid;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String memo;

    private Integer deleteFlag;

    private Date createTime;

    private Date updateTime;

    private Integer corpId;

    private Integer deptId;

    private String operpassword;

    private String strmd5;

    private String eMail;

    private Integer failureNum;

    private Date lastFailureTime;

    private Date pwUpdateTime;

    private String idCard;

    private String nick;

    private String accFrom;

    private String name;

    private Integer employeeId;

    private Integer userId;

    private Integer employeeid;

    private String enterprisecode;

    private Integer enterpriseid;

    private String photo;

    private String subEnterpriseCodeStr;//所有下级企业code，以逗号分隔开
    private String subEnterpriseIdStr;//所有下级企业Id，以逗号分隔开
    private String remark1;//预留字段父企业CODE。
    private String remark2;//预留字段父企业ID。
    private String remark3;//预留字段企业级别
    private String remark4;//预留字段用户类型-对应用户中心B用户和C用户。
    private String remark5;//预留字段


    public String getSubEnterpriseIdStr() {
        return subEnterpriseIdStr;
    }

    public void setSubEnterpriseIdStr(String subEnterpriseIdStr) {
        this.subEnterpriseIdStr = subEnterpriseIdStr;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getSubEnterpriseCodeStr() {
        return subEnterpriseCodeStr;
    }

    public void setSubEnterpriseCodeStr(String subEnterpriseCodeStr) {
        this.subEnterpriseCodeStr = subEnterpriseCodeStr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getOperpassword() {
        return operpassword;
    }

    public void setOperpassword(String operpassword) {
        this.operpassword = operpassword == null ? null : operpassword.trim();
    }

    public String getStrmd5() {
        return strmd5;
    }

    public void setStrmd5(String strmd5) {
        this.strmd5 = strmd5 == null ? null : strmd5.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public Integer getFailureNum() {
        return failureNum;
    }

    public void setFailureNum(Integer failureNum) {
        this.failureNum = failureNum;
    }

    public Date getLastFailureTime() {
        return lastFailureTime;
    }

    public void setLastFailureTime(Date lastFailureTime) {
        this.lastFailureTime = lastFailureTime;
    }

    public Date getPwUpdateTime() {
        return pwUpdateTime;
    }

    public void setPwUpdateTime(Date pwUpdateTime) {
        this.pwUpdateTime = pwUpdateTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getAccFrom() {
        return accFrom;
    }

    public void setAccFrom(String accFrom) {
        this.accFrom = accFrom == null ? null : accFrom.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getEnterprisecode() {
        return enterprisecode;
    }

    public void setEnterprisecode(String enterprisecode) {
        this.enterprisecode = enterprisecode == null ? null : enterprisecode.trim();
    }

    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }
}