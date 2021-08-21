package com.otienosamwel.springbootdemo.domain.service;

import com.otienosamwel.springbootdemo.application.model.LoanRequest;
import com.otienosamwel.springbootdemo.domain.exception.UserNotFoundException;
import com.otienosamwel.springbootdemo.domain.model.LoanApplication;
import com.otienosamwel.springbootdemo.domain.model.User;
import com.otienosamwel.springbootdemo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoanApplicationAdapter {

    @Autowired
    public LoanApplicationAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public LoanApplication transform(LoanRequest loanRequest) {
        Optional<User> userOptional = userRepository.findById((long) loanRequest.getBorrowerId());
        if (userOptional.isPresent()) {
            return new LoanApplication(
                    loanRequest.getAmount(),
                    userOptional.get(),
                    loanRequest.getDaysToRepay(),
                    loanRequest.getInterestRate());
        } else {
            throw new UserNotFoundException(loanRequest.getBorrowerId());
        }

    }
}
