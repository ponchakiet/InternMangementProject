package org.example.internmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.internmanagement.dto.request.UserRequestDTO;
import org.example.internmanagement.dto.request.UserUpdateDTO;
import org.example.internmanagement.dto.response.UserResponseDTO;
import org.example.internmanagement.entity.User;
import org.example.internmanagement.exception.DuplicateResourceException;
import org.example.internmanagement.exception.ResourceNotFoundException;
import org.example.internmanagement.mapper.UserMapper;
import org.example.internmanagement.repository.UserRepository;
import org.example.internmanagement.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User getCurrentUser(UserDetails userDetails) {
        return userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Page<UserResponseDTO> getAllUsers(User.Role role, Pageable pageable) {
        Page<User> userPage;
        if (role != null) {
            userPage = userRepository.findByRole(role, pageable);
        } else {
            userPage = userRepository.findAll(pageable);
        }
        return userPage.map(userMapper::toDto);
    }

    @Override
    public UserResponseDTO getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new DuplicateResourceException("Username is already taken");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email is already in use");
        }

        User user = userMapper.toEntity(request);
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? User.Role.valueOf(request.getRole()) : User.Role.STUDENT);
        user.setIsActive(true);

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDTO updateUser(Integer userId, UserUpdateDTO request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        if (request.getUsername() != null && userRepository.findByUsername(request.getUsername()).isPresent()
                && !user.getUsername().equals(request.getUsername())) {
            throw new DuplicateResourceException("Username is already taken");
        }

        if (request.getEmail() != null && userRepository.findByEmail(request.getEmail()).isPresent()
                && !user.getEmail().equals(request.getEmail())) {
            throw new DuplicateResourceException("Email is already in use");
        }

        userMapper.updateEntityFromDto(request, user);
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        }
        if (request.getRole() != null) {
            user.setRole(User.Role.valueOf(request.getRole()));
        }

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDTO updateStatus(Integer userId, Boolean isActive) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        user.setIsActive(isActive);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDTO updateRole(Integer userId, User.Role role, User currentUser) {
        User targetUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        if (targetUser.getRole() == User.Role.ADMIN && !targetUser.getUserId().equals(currentUser.getUserId())) {
            throw new IllegalArgumentException("An ADMIN cannot change the role of another ADMIN");
        }

        targetUser.setRole(role);
        return userMapper.toDto(userRepository.save(targetUser));
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        userRepository.delete(user);
    }
}
