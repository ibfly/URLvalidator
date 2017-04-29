package com.company;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @org.junit.jupiter.api.Test
    void isUrlValid() {
        assertTrue( Main.isUrlValid( "http://google.com" ) );
        assertFalse( Main.isUrlValid( "http://zzzgoogle.com" ) );
        assertFalse( Main.isUrlValid( "#$%^" ) );

    }
}