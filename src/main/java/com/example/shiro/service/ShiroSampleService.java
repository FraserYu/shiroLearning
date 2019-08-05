package com.example.shiro.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


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
