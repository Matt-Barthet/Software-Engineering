package com.uom.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;
import junit.framework.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	App app;
	@Before
	public void setUp() throws Exception{
		app = new App(7,10);
	}
	@Test
	public void testAdd(){
		Assert.assertEquals(17,app.add());
	}	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp(){
        assertTrue( true );
    }
	
	*/
}
