package io.xream.demo.bean;

import io.xream.sqli.annotation.X;

import java.math.BigDecimal;

/**
 * @Author Sim
 * TDengine
 * 1. create table if not exists t_heat_supply (id TIMESTAMP,value FLOAT,sn NCHAR(20)) tags(city NCHAR(20),zone NCHAR(20));
 */
 public class HeatSupply {

    @X.Key
    private Long id; //System.currentTimeMillis()
    private BigDecimal value;
    @X.Tag
    private String city;
    @X.Tag
    private String zone;
    @X.TagTarget // 标注sn作为子表名后缀
    private String sn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HeatSupply{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zone='" + zone + '\'' +
                ", sn='" + sn + '\'' +
                ", value=" + value +
                '}';
    }
}
