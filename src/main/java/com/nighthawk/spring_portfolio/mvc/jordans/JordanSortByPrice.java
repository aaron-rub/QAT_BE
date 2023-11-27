package com.nighthawk.spring_portfolio.mvc.jordans;

import java.util.Arrays;

public class JordanSortByPrice extends Jordan {
    private Jordan[] jordans;

    public JordanSortByPrice(Jordan[] jordans) {
        super(null, null, 0); // Call to 'super' must be first statement in constructor
        this.jordans = jordans;
    }

    @Override
    public void sortJordan() {
        Arrays.sort(jordans, (Jordan j1, Jordan j2) -> Double.compare(j1.getPrice(), j2.getPrice()));
    }
}
