package com.phuc.english.english_exam_spring.domain.services.auth;

import com.phuc.english.english_exam_spring.domain.dtos.user.JWTResponse;
import com.phuc.english.english_exam_spring.domain.dtos.user.RegisterUserRequest;
import com.phuc.english.english_exam_spring.domain.dtos.user.UserLoginRequest;
import com.phuc.english.english_exam_spring.domain.dtos.user.UserResponse;
import com.phuc.english.english_exam_spring.infrastructure.datas.entites.UserEntity;
import com.phuc.english.english_exam_spring.infrastructure.datas.repository.auth.IAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private final JwtTokenService jwtTokenService;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final IAuthRepository authRepository;

    @Value("${security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    @Override
    public JWTResponse register(RegisterUserRequest registerUserRequest) {
        return null;
    }

    @Override
    public JWTResponse login(UserLoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                loginRequest.getPassword()));
        UserEntity user = authRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        String jwtToken = jwtTokenService.generateToken(user);
        String refreshToken = jwtTokenService.generateRefresh(user);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, (int) jwtExpiration);
        return JWTResponse
                .builder()
                .expiresIn(String.valueOf(calendar.getTime().getTime()))
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public UserResponse refreshToken(String refreshToken) {
        return null;
    }
}
