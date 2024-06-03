package io.paioneer.nain.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Paging {

    private int startRow;    //페이지에 출력할 시작행
    private int endRow;   //페이지에 출력할 끝행
    private long listCount;   //총 목록 갯수
    private int limit;      //한 페이지에 출력할 목록 갯수
    private int currentPage;   //출력할 현재 페이지
    private int maxPage;   //총 페이지 수(마지막 페이지)
    private int startPage;   //페이지 그룹의 시작값
    private int endPage;   //페이지 그룹의 끝값
    private String urlMapping;  //페이지 숫자 클릭시 요청할 url 저장용

    public Paging(long listCount, int currentPage, int limit) {
        this.listCount = listCount;      // 페이지 수
        this.currentPage = currentPage;   // 현재 페이지
        this.limit = limit;      // 단위
    }

    public void calculate() {
        this.maxPage = (int)((double)listCount / limit + 0.9);
        this.startPage = (int)(((double)currentPage / limit + 0.9) - 1) * limit + 1;
        this.endPage = startPage + limit - 1;

        if(maxPage < endPage) {
            endPage = maxPage;
        }

        this.startRow = (currentPage - 1) * limit + 1;
        this.endRow = startRow + limit - 1;
    }



}

