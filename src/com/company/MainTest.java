package com.company;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 24.03.2017.
 */
class MainTest {
    @org.junit.jupiter.api.Test
    void isUrlValid() {
        assertTrue( Main.isUrlValid( "http://google.com" ) );
        assertFalse( Main.isUrlValid( "http://zzzgoogle.com" ) );
        assertFalse( Main.isUrlValid( "#$%^" ) );

    }
}