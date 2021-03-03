package com.rukon.mokito.mokitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessTest {
@Test
    public void testFindGData() {
    DataServiceStub dataServiceStub = new DataServiceStub();
    SomeBusiness someBusiness = new SomeBusiness(dataServiceStub);
    int result = someBusiness.findGAllData();

    assertEquals(24, result);
}
}

class DataServiceStub implements DataService{

    @Override
    public int[] retriveAllData() {
        return new int[]{24, 6, 15};
    }
}