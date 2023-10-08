package vn.com.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.com.webbanhang.entity.Account;
import vn.com.webbanhang.exception.UsernameAlreadyExistException;
import vn.com.webbanhang.exception.UsernameNotFoundException;
import vn.com.webbanhang.repository.UserRepository;
import vn.com.webbanhang.request.LoginRequest;
import vn.com.webbanhang.request.SignupRequest;
import vn.com.webbanhang.service.AccountService;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean signUp(SignupRequest signupRequest) {
        Optional<Account> existingAccount = userRepository.findByUsername(signupRequest.getUsername());
        if (existingAccount.isPresent()){
           throw new UsernameAlreadyExistException("Username already exists");
        }else{
            Account account = new Account();
            account.setUsername(signupRequest.getUsername());
            account.setHashPass(passwordEncoder.encode(signupRequest.getHashPass()));
            userRepository.save(account);
        }
        return true;
    }

    @Override
    public boolean logIn(LoginRequest loginRequest) {
        Optional<Account> accountOptional = userRepository.findByUsername(loginRequest.getUsername());
        if (accountOptional.isPresent()) {
            return passwordEncoder.matches(loginRequest.getHashPass(), accountOptional.get().getHashPass());
        }else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

}
