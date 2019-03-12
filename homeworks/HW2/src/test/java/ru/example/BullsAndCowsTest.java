package ru.example;

import org.junit.Test;
import org.junit.Ignore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class BullsAndCowsTest {
    @Test
    public void TestBullsAndCows1(){
        App.wordChars=new StringBuilder("aasty");
        App.typedWordChars = new StringBuilder("aatsy");

        assertThat(App.calculateBulls(), is(equalTo(3)));
        assertThat(App.calculateCows(), is(equalTo(2)));
    }

    @Test
    public void TestBullsAndCows2(){
        App.wordChars=new StringBuilder("aasty");
        App.typedWordChars = new StringBuilder("puio");

        assertThat(App.calculateBulls(), is(equalTo(0)));
        assertThat(App.calculateCows(), is(equalTo(0)));
    }

    @Test
    public void TestBullsAndCows3(){
        App.wordChars=new StringBuilder("aasty");
        App.typedWordChars = new StringBuilder("aasty");

        assertThat(App.calculateBulls(), is(equalTo(5)));
        assertThat(App.calculateCows(), is(equalTo(0)));
    }
}
