package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("user/{id}/profile")
    public String userProfile(@PathVariable int id, Model model) {
        Account account = accountRepository.findById(id).get();
        List<Task> foundTasks = new LinkedList<>(); //taskRepository.findAllById({5});

        model.addAttribute("account", account);
        model.addAttribute("tasks", foundTasks);

        return "profile";
    }

    @GetMapping("/users/all")
    public String listAccounts(Model model) {
        ArrayList<Account> allAccount = new ArrayList<>();
        accountRepository.findAll().forEach(allAccount::add);
        model.addAttribute("accounts", allAccount);
        return "accounts";
    }

    @GetMapping("/all/create")
    public String createAll(Model model) {
        for (int i = 0; i < 10; ++i) {
            Account account = new Account("user-" + i);
            accountRepository.save(account);

            for (int j = 0; j < 10; ++j) {
                Task task = new Task("task-" + j);
                taskRepository.save(task);
            }
        }

        Account account = accountRepository.findById(5).get();
        List<Task> foundTasks = new LinkedList<>(); //taskRepository.findAllById({5});

        model.addAttribute("account", account);
        model.addAttribute("tasks", foundTasks);

        return "profile";
    }
}
