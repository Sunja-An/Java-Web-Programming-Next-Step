package com.study.nextprogamming.ch2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private StringCalculator tester;

    @BeforeEach
    void setUp() {
        System.out.println("One Test Cycle start");
        tester = new StringCalculator();
    }

    @Test
    void case1(){
        final int result = tester.add("");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void case2(){
        final int result = tester.add("1,2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void case3(){
        final int result = tester.add("1,2:6");
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    void case4() {
        final int result = tester.add("//;\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void case5() {
        Assertions.assertThatThrownBy(()-> {
                    tester.add("-1");
                })
                .isInstanceOf(RuntimeException.class);
    }

    @AfterEach
    void tearDown() {
        System.out.println("1 Test Cycle Over");
    }
}