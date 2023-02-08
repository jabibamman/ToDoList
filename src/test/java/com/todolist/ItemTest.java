package com.todolist;

import com.todolist.app.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    private final Item item = new Item("name",
            "a".repeat(1000));

    @Test
    void isContentNotValidTest() {
        item.setContent(item.getContent() + "a");
        assertFalse(item.isContentValid());
    }

    @Test
    void isItemValid() {
        assertTrue(item.isContentValid());
    }
}
