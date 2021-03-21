package com.rukon.mokito.mokitodemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class SomeBusinessMockAnnotationTest {

@Mock
DataService dataServiceMock;

@InjectMocks
SomeBusiness business;

@Test
    public void testFindGData() {

    when(dataServiceMock.retriveAllData()).thenReturn( new int[]{24, 15, 3});

    assertEquals(24, business.findGAllData());
}


}

