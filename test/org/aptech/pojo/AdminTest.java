package org.aptech.pojo;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {
    Admin admin = new Admin();

    @Test
    public void test(){
        admin.setAName("yuanyiming");
        System.out.println(admin.getAName());
    }
}