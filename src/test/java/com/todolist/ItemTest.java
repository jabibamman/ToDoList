package com.todolist;

import com.todolist.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item item = new Item("name",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et mollis arcu. Quisque mauris risus, " +
                    "pellentesque eget porttitor sit amet, consequat quis lacus. Curabitur lacinia consectetur commodo. " +
                    "Morbi venenatis tincidunt justo. Donec sem arcu, posuere quis lectus et, egestas facilisis felis. " +
                    "Mauris gravida tempor felis, ut faucibus tellus dignissim vitae. Sed malesuada egestas sapien " +
                    "egestas condimentum. Sed aliquam in nulla nec commodo. Mauris id odio at erat posuere placerat " +
                    "volutpat vitae nunc. Nunc sapien massa, pellentesque a tristique vel, imperdiet eget augue. Fusce " +
                    "vestibulum mauris et mi efficitur, ut sollicitudin lectus luctus. Ut venenatis magna sit amet dui " +
                    "hendrerit, vitae sagittis mi euismod. Vestibulum vel consectetur diam. Maecenas quis volutpat neque, " +
                    "ac volutpat purus. Vestibulum sit amet varius urna. Integer purus massa, dignissim ac suscipit ut, " +
                    "auctor eget ipsum. Vestibulum scelerisque aliquet ipsum, a varius sem. Integer mi arcu, tempus at " +
                    "est eget erat curae");

    @Test
    public void isContentNotValidTest() {
        item.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et mollis arcu. Quisque mauris risus, " +
                "pellentesque eget porttitor sit amet, consequat quis lacus. Curabitur lacinia consectetur commodo. " +
                "Morbi venenatis tincidunt justo. Donec sem arcu, posuere quis lectus et, egestas facilisis felis. " +
                "Mauris gravida tempor felis, ut faucibus tellus dignissim vitae. Sed malesuada egestas sapien " +
                "egestas condimentum. Sed aliquam in nulla nec commodo. Mauris id odio at erat posuere placerat " +
                "volutpat vitae nunc. Nunc sapien massa, pellentesque a tristique vel, imperdiet eget augue. Fusce " +
                "vestibulum mauris et mi efficitur, ut sollicitudin lectus luctus. Ut venenatis magna sit amet dui " +
                "hendrerit, vitae sagittis mi euismod. Vestibulum vel consectetur diam. Maecenas quis volutpat neque, " +
                "ac volutpat purus. Vestibulum sit amet varius urna. Integer purus massa, dignissim ac suscipit ut, " +
                "auctor eget ipsum. Vestibulum scelerisque aliquet ipsum, a varius sem. Integer mi arcu, tempus at " +
                "est eget erat curae. ");
        assertFalse(item.isContentValid());
    }

    @Test
    public void isItemValid() {
        assertTrue(item.isContentValid());
    }
}
