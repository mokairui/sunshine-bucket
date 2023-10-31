package com.sunshine.infrastructure.adapter;

import com.sunshine.infrastructure.IUserInfo;
import com.sunshine.infrastructure.outer.OuterUser;

import java.util.Map;

/**
 * @author Mokairui
 * @description 类适配器
 * @since 2023/10/31
 */
public class OuterUserInfoAdapter extends OuterUser implements IUserInfo {

    private Map<String, String> baseInfo = super.getUserBaseInfo(); //员工的基本信息
    private Map<String, String> homeInfo = super.getUserHomeInfo(); //员工的家庭 信息
    private Map<String, String> officeInfo = super.getUserOfficeInfo(); //工作信息
    
    @Override
    public String getUserName() {
        String userName = this.baseInfo.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = this.homeInfo.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        String mobileNumber = this.baseInfo.get("mobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = this.officeInfo.get("officeTelNumber");
        System.out.println(officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPosition() {
        String jobPosition = this.officeInfo.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = this.homeInfo.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
}
