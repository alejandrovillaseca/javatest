package com.aledev.javatest;

import static org.junit.Assert.*;
import com.aledev.javatest.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavatestApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void repeat_string_once(){		
		String result = StringUtil.repeat("hola", 3);
		assertEquals("holaholahola", result);
	}
	@Test
	public void repeat_string_zero_times(){
		String result = StringUtil.repeat("", 0);
		assertEquals("", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void repeat_string_negative_times(){
		StringUtil.repeat("hola", -1);
	}
	
	@Test
	public void is_not_empty(){
		assertFalse(StringUtil.isEmpty("hola"));
	}
	@Test
	public void is_empty(){
		assertTrue(StringUtil.isEmpty(""));
	}

	@Test
	public void null_is_empty(){
		assertTrue(StringUtil.isEmpty(null));
	}
}
