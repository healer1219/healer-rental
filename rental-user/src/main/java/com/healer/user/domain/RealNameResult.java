package com.healer.user.domain;


public class RealNameResult {

    private String name;
    private String mobile;
    private String idcard;
    private String res;
    private String description;
    private String sex;
    private String birthday;

    @Override
    public String toString() {
        return "RealNameResult{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idcard='" + idcard + '\'' +
                ", res='" + res + '\'' +
                ", description='" + description + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private String address;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setMobile(String mobile) {
         this.mobile = mobile;
     }
     public String getMobile() {
         return mobile;
     }

    public void setIdcard(String idcard) {
         this.idcard = idcard;
     }
     public String getIdcard() {
         return idcard;
     }

    public void setRes(String res) {
         this.res = res;
     }
     public String getRes() {
         return res;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setSex(String sex) {
         this.sex = sex;
     }
     public String getSex() {
         return sex;
     }

    public void setBirthday(String birthday) {
         this.birthday = birthday;
     }
     public String getBirthday() {
         return birthday;
     }

    public void setAddress(String address) {
         this.address = address;
     }
     public String getAddress() {
         return address;
     }

}