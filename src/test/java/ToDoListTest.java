import com.todolist.Item;
import com.todolist.ToDoList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
public class ToDoListTest {

    @Test
    public void testAddItemValid() {

        Item i1 = new Item("Ronan","Elève de l'ESGI");

        ToDoList mockToDoList = mock(ToDoList.class);

        when(mockToDoList.lastTwoItems()).thenReturn(false); //N'envoie jamais le mail
        mockToDoList.addItem(i1);
        verify(mockToDoList).addItem(i1);
    }

    @Test
    public void testAddItemsToQuickly() {

        Item i1 = new Item("Ronan","Elève de l'ESGI");
        Item i2 = new Item("Ronan","Elève de l'ESGI");

        ToDoList td_test = new ToDoList();
        td_test.addItem(i1);

        assertThrows(RuntimeException.class, () -> td_test.addItem(i2));
    }

    @Test
    public void testAddTooMuchItem() {

        Item i1 = new Item("Ronan", "Elève de l'ESGI");
        Item i2 = new Item("Ronan", "Elève de l'ESGI");
        Item i3 = new Item("Ronan", "Elève de l'ESGI");
        Item i4 = new Item("Ronan", "Elève de l'ESGI");
        Item i5 = new Item("Ronan", "Elève de l'ESGI");
        Item i6 = new Item("Ronan", "Elève de l'ESGI");
        Item i7 = new Item("Ronan", "Elève de l'ESGI");
        Item i8 = new Item("Ronan", "Elève de l'ESGI");
        Item i9 = new Item("Ronan", "Elève de l'ESGI");
        Item i10 = new Item("Ronan", "Elève de l'ESGI");
        Item i11 = new Item("Ronan", "Elève de l'ESGI");

        ArrayList<Item> it_list = new ArrayList<>(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10));

        ToDoList td_test = new ToDoList(it_list);

        assertThrows(RuntimeException.class, () -> td_test.addItem(i11));
    }
}
