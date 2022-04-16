package com.learn.time.controllers;

import com.learn.time.model.User;
import com.learn.time.repositories.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.SQLException;

@Slf4j
@Controller
@Data
@ConfigurationProperties("dmytro")
public class UserController {
    private final UserRepository userRepository;

    private String name;
    private int age;
    private boolean realMan;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        log.info("name is - " + name);
//        model.addAttribute("users", Collections.singletonList(new User()));
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/index";
    }

    @GetMapping("/checkProcedure")
    @ResponseBody
    public String checkProcedure() throws SQLException {
//         Resource resource = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
//            .getResource("classpath:sql/V1__proc.sql");
//        ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
        userRepository.testProcedure2();
        return "success";
    }
    // additional CRUD methods


    @Autowired
    private DataSource dataSource;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private JdbcTemplate jdbcTemplate;
}