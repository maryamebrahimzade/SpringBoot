package com.example.user.services;

import com.example.user.models.User;
import com.example.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserRepository, User> {
}
