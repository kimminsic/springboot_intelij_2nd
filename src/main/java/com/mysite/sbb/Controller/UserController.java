package com.mysite.sbb.Controller;

import com.mysite.sbb.domain.User;
import com.mysite.sbb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
@Autowired
    private UserRepository userRepository;

@RequestMapping("/usr/member/list")
    @ResponseBody
    public List<User> userlist (){
    return userRepository.findAll();

}
}
