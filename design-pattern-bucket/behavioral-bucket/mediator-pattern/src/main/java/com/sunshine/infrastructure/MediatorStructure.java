package com.sunshine.infrastructure;

import com.sunshine.infrastructure.support.HouseOwner;
import com.sunshine.infrastructure.support.Tenant;

/**
 * @author Mokairui
 * @description
 * @since 2023/12/3
 */
public class MediatorStructure extends Mediator {

    //聚合房主和租房者对象
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    
    @Override
    public void constact(String message, Person person) {
        if(person == houseOwner) {
            tenant.getMessage(message);
        } else {
            houseOwner.getMessage(message);
        }
    }
}
