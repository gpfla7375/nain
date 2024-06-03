package io.paioneer.nain.security.model.service;

import io.paioneer.nain.security.jpa.entity.RefreshToken;
import io.paioneer.nain.security.jpa.repository.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class RefreshTokenService {

    //final 사용 => 의존성 주입
    private final RefreshTokenRepository refreshTokenRepository;
    //반드시 매개변수 있는 생성자
    public RefreshTokenService (RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        
    }

    public void save(RefreshToken refreshToken) {
        refreshTokenRepository.save(refreshToken); //insert 실행 처리
    }
    public Optional<RefreshToken> findByTokenValue(String tokenValue) {
        return refreshTokenRepository.findByTokenValue(tokenValue);
    }

    public Boolean existsByTokenValue(String tokenValue) {
        //토큰존재여부
        return refreshTokenRepository.existsByTokenValue(tokenValue);
    }

    public void deleteByTokenValue(String tokenValue) {
        refreshTokenRepository.deleteByTokenValue(tokenValue);
    }

    public Optional<RefreshToken> findByUserId(UUID ID) {
        return refreshTokenRepository.findByUserId(String.valueOf(ID.toString()));
    }
}
