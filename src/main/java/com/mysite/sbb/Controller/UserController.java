package com.mysite.sbb.Controller;

import com.mysite.sbb.domain.User;
import com.mysite.sbb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usr/member")
public class UserController {
@Autowired
    private UserRepository userRepository;

@RequestMapping("")
    @ResponseBody
    public List<User> userlist (){
    return userRepository.findAll();

}

@RequestMapping("/detail/")
    @ResponseBody
    public Optional<User> userIndex(long id){
    return userRepository.findById(id);
}
}
