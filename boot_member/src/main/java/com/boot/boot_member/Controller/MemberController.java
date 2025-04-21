package com.boot.boot_member.Controller;

import com.boot.boot_member.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@Slf4j
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login() {
        log.info("@# login()");

        return "login";
    }

    @RequestMapping("/login_ok")
    public String login_ok() {
        log.info("@# login_ok()");

        return "login_ok";
    }

    @RequestMapping("/register")
    public String register(@RequestParam HashMap<String, String> param) {
        memberService.write(param);

        return "login";
    }


}
