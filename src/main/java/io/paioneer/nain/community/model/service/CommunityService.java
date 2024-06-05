package io.paioneer.nain.community.model.service;

import io.paioneer.nain.community.jpa.entity.CommunityEntity;
import io.paioneer.nain.community.jpa.repository.community.CommunityRepository;
import io.paioneer.nain.community.jpa.repository.community.CommunityRepositoryImpl;
import io.paioneer.nain.community.model.dto.CommunityDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepositoryImpl communityRepositoryImpl;
    private final CommunityRepository communityRepository;

    public ArrayList<CommunityDto> selectList(Pageable pageable) {
        Page<CommunityEntity> entities = communityRepository.findAll(pageable);
        ArrayList<CommunityDto> list = new ArrayList<>();
        for (CommunityEntity entity : entities) {
            list.add(new CommunityDto(entity));
        }
        return list;
    }


    public CommunityDto selectOne(Long communityNo) {
        CommunityDto communityDto = new CommunityDto(communityRepository.findById(communityNo).get());
        return communityDto;
    }


}
