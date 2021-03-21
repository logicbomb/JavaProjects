package com.rukon.mokito.mokitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessMockTest {
@Test
    public void testFindGData() {
    DataService dataServiceMock = mock(DataService.class);
    //dataServiceMock.retriveAllData() -> new int[]{24, 15, 3};
    when(dataServiceMock.retriveAllData()).thenReturn( new int[]{24, 15, 3});

    DataServiceStub dataServiceStub = new DataServiceStub();
    SomeBusiness someBusiness = new SomeBusiness(dataServiceMock);
    int result = someBusiness.findGAllData();

    assertEquals(24, result);
}


}

