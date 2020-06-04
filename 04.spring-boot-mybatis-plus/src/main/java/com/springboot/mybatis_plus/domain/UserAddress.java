package com.springboot.mybatis_plus.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@TableName("user_address")
public class UserAddress extends Model<UserAddress> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_address_id", type = IdType.AUTO)
    private Integer userAddressId;
    private String country;
    private String province;
    private String city;
    private String town;
    @TableField("address_code")
    private Integer addressCode;
    @TableField("post_code")
    private Integer postCode;
    private Double lat;
    private Double lng;
    private String place;


    public Integer getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(Integer userAddressId) {
        this.userAddressId = userAddressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(Integer addressCode) {
        this.addressCode = addressCode;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    protected Serializable pkVal() {
        return this.userAddressId;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
        ", userAddressId=" + userAddressId +
        ", country=" + country +
        ", province=" + province +
        ", city=" + city +
        ", town=" + town +
        ", addressCode=" + addressCode +
        ", postCode=" + postCode +
        ", lat=" + lat +
        ", lng=" + lng +
        ", place=" + place +
        "}";
    }
}
