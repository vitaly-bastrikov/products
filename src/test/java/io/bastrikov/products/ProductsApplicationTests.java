package io.bastrikov.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProductsApplicationTests {

	@Test
	public void whenCallMockito_thenMock() {
		List<String> mockList = Mockito.mock(ArrayList.class);
		mockList.add("one");
		mockList.add("one");
		Mockito.verify(mockList, Mockito.times(2)).add("one");
		Mockito.when(mockList.size()).thenReturn(2);

		Assertions.assertEquals(2, mockList.size());

//		Mockito.when(mockList.size()).thenReturn(0);
//		Assertions.assertEquals(mockList.size(), 0);
	}

	@Test
	public void whenListSize_thenReturnTrue() {
		List<String> spyList = Mockito.mock(ArrayList.class);

		spyList.add("one");
		spyList.add("two");

		Mockito.verify(spyList).add("one");
		Mockito.verify(spyList).add("two");

		Mockito.doReturn(100).when(spyList).size();
		Assertions.assertEquals(100, spyList.size());
	}

}
