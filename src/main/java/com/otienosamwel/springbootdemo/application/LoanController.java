package com.otienosamwel.springbootdemo.application;

import com.otienosamwel.springbootdemo.application.model.LoanRequest;
import com.otienosamwel.springbootdemo.domain.model.LoanApplication;
import com.otienosamwel.springbootdemo.domain.model.User;
import com.otienosamwel.springbootdemo.domain.repository.LoanApplicationRepository;
import com.otienosamwel.springbootdemo.domain.repository.UserRepository;
import com.otienosamwel.springbootdemo.domain.service.LoanApplicationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanApplicationAdapter loanApplicationAdapter;

    @Autowired
    public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanApplicationAdapter loanApplicationAdapter) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanApplicationAdapter = loanApplicationAdapter;
    }

    @PostMapping(value = "loan/request")
    public void requestLoan(@RequestBody final LoanRequest loanRequest) {
        LoanApplication loanApplication = loanApplicationAdapter.transform(loanRequest);
        loanApplicationRepository.save(loanApplication);
    }

    @GetMapping(value = "/users")
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/loan/requests")
    public List<LoanApplication> findApplications() {
        return loanApplicationRepository.findAll();
    }
}
