package com.novawind.test;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.dto.AdminAccessDto;
import com.novawind.mourn.repository.AdminRepository;
import com.novawind.mourn.util.JsonUtil;
import com.novawind.mourn.util.SpringAppContextUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;

import java.util.UUID;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-25 15:19
 */
public class TestAdmin extends JunitTestConfig{
    @Autowired
    private AdminRepository adminRepository;

    public static void main (String[] args) {
        String s = Constants.getSeries(3L);
        System.out.println(s);
        //String enc = Base64Utils.encodeToString(s.getBytes());
        //System.out.println(enc);
        System.out.println(new String(Base64Utils.decodeFromString(s)));
    }
    @Test
    public void test(){
        //System.out.println(adminRepository.findByName("admin"));
        System.out.println(SpringAppContextUtil.getBean(AdminRepository.class).findByName("admin"));
    }

}
