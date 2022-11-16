package dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AdminDaoTest {

    @Test
    Object login(String s, String s1) {
        assertNotNull(login("admin@gmail.com", "1234"));
        return null;
    }
}