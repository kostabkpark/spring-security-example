package org.example.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class SimpleController {
    @GetMapping("/simple")
    public String simple(Model model, Principal principal) {// 인증된 사용자가 있다면 사용자의 정보를 principal에 담아옴
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        Principal principal1 = (Principal)authentication.getPrincipal();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if(principal != null) {// 인증된 사용자가 있다면 사용자의 이름을 model 에 담옴
            model.addAttribute("username", principal.getName());
        } else {// 인증된 사용자가 없다면 문자열을 model 에 담옴
            model.addAttribute("username", "hello security");
        }
        return "basic/simple";
    }

    @GetMapping("/info") // 로그인 하지 않아도 전부 접근할 수 있는 페이지
    public String info(Model model) {
       // 문자열을 model 에 담옴
        model.addAttribute("info", "this is a information for everybody");
        return "basic/info";
    }

    @GetMapping("/") // 로그인하지 않아도 전부 접근할 수 있는 페이지
    public String home(Model model) {
        // 문자열을 model 에 담옴
        model.addAttribute("info", "this is a information for everybody");
        return "basic/info";
    }

    @GetMapping("/enter") // 반드시 로그인 해야만 접근할 수 있는 페이지
    public String enter(Model model, Principal principal) {
        if(principal != null) {// 인증된 사용자가 있다면 사용자의 이름을 model 에 담옴
            model.addAttribute("username", principal.getName());
        }
        return "basic/enter";
    }

    @GetMapping("/admin") // admin 권한이 있는 사용자가 로그인 한 경우에만 접근할 수 있는 페이지
    public String admin(Model model, Principal principal) {
        if(principal != null) {// 인증된 사용자가 있다면 사용자의 이름을 model 에 담옴
            model.addAttribute("username", principal.getName());
        }
        return "basic/enter";
    }
}
