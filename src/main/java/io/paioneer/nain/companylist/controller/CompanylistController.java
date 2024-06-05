package io.paioneer.nain.companylist.controller;

import io.paioneer.nain.companylist.model.dto.CompanylistDto;
import io.paioneer.nain.companylist.model.service.CompanylistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/companylist")
public class CompanylistController {
    private final CompanylistService companylistService;

    public ResponseEntity<List<CompanylistDto>> selectCompanyList(String sorting) {

        List<CompanylistDto> companylistDto = companylistService.selectCompanyList(sorting);

        return new ResponseEntity<>(companylistDto, HttpStatus.OK);

    }
}
