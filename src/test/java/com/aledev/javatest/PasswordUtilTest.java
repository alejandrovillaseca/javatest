package com.aledev.javatest;

import static org.junit.Assert.assertEquals;

import com.aledev.utils.PasswordUtil;

import org.junit.Test;

/**
 * PasswordUtilTest
 */
public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("1234567"));
    }
    @Test
    public void weak_when_has_only_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("asdfasdfasdf"));
    }
    @Test
    public void medium_when_has_letters_and_nums(){
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("asdfasd12334"));
    }
    @Test
    public void strong_when_has_letters_and_nums_and_symbols(){
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("asdfasd12334!"));
    }
}