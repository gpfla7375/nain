package io.paioneer.nain.statistical.controller;

import io.paioneer.nain.statistical.model.service.StatisticalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/Staticstical")
@Slf4j
public class StatisticalController {
    private final StatisticalService statisticalService;

    public StatisticalController(StatisticalService statisticalService) {
        this.statisticalService = statisticalService;
    }

    @GetMapping("/")
    public ResponseEntity<Integer> yearpaymentCount(@RequestParam("year") String year){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date;
        try {
            date = sdf.parse(year);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        int result = statisticalService.selectYearpaymentCount((java.sql.Date) date);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
