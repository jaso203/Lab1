package final_count;

import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.CoreMatchers.*;   
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import org.junit.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;


public class Counter_test3 {

	private static counter mytest = new counter();
	private static String test = "";
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void test1() {
		test="";
		mytest.SetValidInf(test);
		mytest.CreateDirectedGraph();
		String result = " ";
		assertEquals(result,mytest.randomWalk());
	}
	@Test
	public void test2() {
		test="A A";
		mytest.SetValidInf(test);
		mytest.CreateDirectedGraph();
		String result1 = "a a a ";
		assertThat(mytest.randomWalk(),anyOf(equalTo(result1)));
	}
	@Test
	public void test3() {
		//ail("Not yet implemented");
		test="A";
		mytest.SetValidInf(test);
		mytest.CreateDirectedGraph();
		String result = "a ";
		assertEquals(result,mytest.randomWalk());
	}
	@Test
	public void test4() {
		test="A B";
		mytest.SetValidInf(test);
		mytest.CreateDirectedGraph();
		String result1 = "a b ";
		String result2 = "b ";
		assertThat(mytest.randomWalk(),anyOf(equalTo(result1),equalTo(result2)));
	}
	
	@Test
	public void test5() {
		test="A B A";
		mytest.SetValidInf(test);
		mytest.CreateDirectedGraph();
		String result1 = "a b a b ";
		String result2 = "b a b a ";
		assertThat(mytest.randomWalk(),anyOf(equalTo(result1),equalTo(result2)));
	}
	@Test
	public void test6() {
		test="A B C D";
		mytest.SetValidInf(test);
		mytest.CreateDirectedGraph();
		String result1 = "a b c d ";
		String result2 = "b c d ";
		String result3 = "c d ";
		String result4 = "d ";
		assertThat(mytest.randomWalk(),anyOf(equalTo(result1),equalTo(result2),equalTo(result3),equalTo(result4)));
	}
	@Test
	public void test7() {
		test="A B C D A";
		mytest.SetValidInf(test);
		mytest.CreateDirectedGraph();
		String result1 = "a b c d a b ";
		String result2 = "b c d a b c ";
		String result3 = "c d a b c d ";
		String result4 = "d a b c d a ";
		assertThat(mytest.randomWalk(),anyOf(equalTo(result1),equalTo(result2),equalTo(result3),equalTo(result4)));
	}
	
}
