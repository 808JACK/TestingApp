package TestingApp;

import jdk.jfr.Name;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Slf4j
class TestingAppApplicationTests {
//
//	@BeforeEach
//	void setup() {
//
//		log.info("Setting up before each test");
//	}
//
//	@AfterAll
//	static void RunAfterALL(){
//		log.info("Afterr all");
//	}
//
//	@BeforeEach
//	void testNumberOne() {
//		log.info("test number one");
//	}
//
//	@Test
//	@Name("displayTestNameTwo")
//	void testNumberTwo(){
//		log.info("test two is run");
//	}
//
//	@Test
//	void addTwoNumber(){
//		int a = 2;
//		int b = 2;
//
//		int res = addTwoNumbers(a,b);
//
////		Assertions.assertEquals(4,res); this is from Junit
//		Assertions.assertThat(res).isEqualTo(4)
//				.isCloseTo(3, Offset.offset(1));// this is from Assert
//	}
//
//	@Test
//	void addTwoNumber_withExpCheck(){
//		int a = 2;
//		int b = 0;
//
//		assertThatThrownBy(()-> divideTwoNumbers(a,b))
//				.isInstanceOf(ArithmeticException.class)
//				.hasMessage("error hai bhay");
//
////		Assertions.assertEquals(4,res); this is from Junit
//
//	}
//	int addTwoNumbers(int a,int b){
//		return a+b;
//	}
//
////	@Test
////	void divideTwoNumbers(){
////
////		int a = 7;
////		int b = 0;
////
////		double ans = divideTwoNumbers(a,b);
////
////		System.out.println(ans);
////	}
//
//	double divideTwoNumbers(int a,int b){
//		try {
//			return a/b;
//		}
//		catch (ArithmeticException e){
//			log.error("error hai bhay" +e.getLocalizedMessage());
//			throw new ArithmeticException("error hai bhay");
//		}
//	}


}
