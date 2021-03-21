package com.rukon.mokito.mokitodemo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListMockTest {
    @Mock
    List<Integer> list;

@InjectMocks
List list1;

@Test
    public void testFindGData() {
  //  List<Integer> list = mock(List.class);
    when(list.size()).thenReturn(24);
    assertEquals(24, list1.size());
}


}

