package com.fan.model;

import org.springframework.util.Assert;

/**
 * Created by fqc on 12/4/16.
 */

public class VehicleIdentificationNumber {
    private String vin;

    public VehicleIdentificationNumber(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        Assert.notNull(vin,"VIN must not be null");
        Assert.isTrue(vin.length() == 17, "VIN must be exactly 17 characters");
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "VehicleIdentificationNumber{" +
                "vin='" + vin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleIdentificationNumber that = (VehicleIdentificationNumber) o;

        return vin != null ? vin.equals(that.vin) : that.vin == null;

    }

    @Override
    public int hashCode() {
        return vin != null ? vin.hashCode() : 0;
    }
}
