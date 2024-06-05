package io.paioneer.nain.statistical.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticalDto {
    private int YearPayment;
    private int MonthPayment;
    private int WeekSubscribeCount;
    private int WeekVisitCount;
    private int WeekNewMemberCount;
    private int WeekWithdrawalCount;
}
