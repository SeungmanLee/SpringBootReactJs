package org.smlee.model;

/**
 * Created by smlee on 2017-01-29.
 */
public class LottoryVo {

    private final String no;
    private final Integer[] numbers;

    public LottoryVo(String no, Integer[] numbers ) {
        this.no = no;
        this.numbers = numbers;
    }

    public String getNo() {
        return no;
    }

    public Integer[] getNumbers() {
        return numbers;
    }
}
