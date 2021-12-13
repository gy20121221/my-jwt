package com.example.myjwt.untils;

import com.example.myjwt.model.JwtRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author zhangpeng
 * @version 1.0
 * @description:
 * @date 2021/12/13 17:24
 */
@Component
public class UserDetails {

    public  final ArrayList<JwtRequest> USER = new ArrayList<>();

}
