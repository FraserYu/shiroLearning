package com.example.shiro.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Create by fraser on 2018/8/30 1:50 PM
 */
//@Service
public class ShiroSampleService{



        @RequiresPermissions("user.delete")
        public String read() {
            return "reading...";
        }

        @RequiresPermissions("write")
        public String write() {
            return "writting...";
        }
}
