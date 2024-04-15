package com.lucete.comprehensive.common.paging;

import java.util.HashMap;
import java.util.Map;

public class Pagenation {

    public static SelectCriteria getSelectCriteria(int page, int totalCount, int limit, int buttonAmount, Map<String, String> searchMap) {

        int maxPage = (int) Math.ceil((double) totalCount / limit);

        int startPage = (int) (Math.ceil((double) page / buttonAmount) -1) * buttonAmount +1;

        int endPage = startPage + buttonAmount -1;

        if(maxPage < endPage) endPage = maxPage;

        if(maxPage == 0 && endPage == 0) {
            maxPage = startPage;
            endPage = startPage;
        }

        int offSet = (page -1) * limit;

        return new SelectCriteria(page, totalCount, limit, buttonAmount, maxPage, startPage,endPage,
                offSet, searchMap.get("searchCondition"), searchMap.get("searchValue"));

    }

    public static SelectCriteria getSelectCriteria(int page, int totalCount, int limit, int buttonAmount) {
        return getSelectCriteria(page, totalCount, limit, buttonAmount, new HashMap<>());
    }
}
