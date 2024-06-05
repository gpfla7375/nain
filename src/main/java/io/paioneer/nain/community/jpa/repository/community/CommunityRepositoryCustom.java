package io.paioneer.nain.community.jpa.repository.community;

import io.paioneer.nain.community.jpa.entity.CommunityEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommunityRepositoryCustom{
    CommunityEntity selectCommunityOne(Long communityNo);
    List<CommunityEntity> selectCommunityList(Pageable pageable);
}