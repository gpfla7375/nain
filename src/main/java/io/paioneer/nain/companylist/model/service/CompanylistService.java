package io.paioneer.nain.companylist.model.service;

import io.paioneer.nain.companylist.jpa.repository.CompanylistRepository;
import io.paioneer.nain.companylist.jpa.repository.CompanylistRepositoryCustom;
import io.paioneer.nain.companylist.jpa.repository.CompanylistRepositoryCustomImpl;
import io.paioneer.nain.companylist.model.dto.CompanylistDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CompanylistService {

    private final CompanylistRepository companylistRepository;

    public List<CompanylistDto> selectCompanyList(String sorting) {
        return null;
        //return companylistRepository.selectCompanyList(sorting);
    }
}
