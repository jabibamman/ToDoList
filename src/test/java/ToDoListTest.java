import com.todolist.todolist.Item;
import com.todolist.todolist.ToDoList;
import com.todolist.todolist.ValidationException;
import org.junit.jupiter.api.Test;
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

        Item i1 = new Item("Ronan","Elève de l'ESGI");
        Item i2 = new Item("Ronan","Elève de l'ESGI");
        Item i3 = new Item("Ronan","Elève de l'ESGI");
        Item i4 = new Item("Ronan","Elève de l'ESGI");
        Item i5 = new Item("Ronan","Elève de l'ESGI");
        Item i6 = new Item("Ronan","Elève de l'ESGI");
        Item i7 = new Item("Ronan","Elève de l'ESGI");
        Item i8 = new Item("Ronan","Elève de l'ESGI");
        Item i9 = new Item("Ronan","Elève de l'ESGI");
        Item i10 = new Item("Ronan","Elève de l'ESGI");
        Item i11 = new Item("Ronan","Elève de l'ESGI");

        ToDoList mockToDoList = mock(ToDoList.class);

        when(mockToDoList.lastTwoItems()).thenReturn(false); //N'envoie jamais le mail

        when(mockToDoList.timerValid()).thenReturn(true); //pas de problèmes de temps
        
        mockToDoList.addItem(i1);
        mockToDoList.addItem(i2);
        mockToDoList.addItem(i3);
        mockToDoList.addItem(i4);
        mockToDoList.addItem(i5);
        mockToDoList.addItem(i6);
        mockToDoList.addItem(i7);
        mockToDoList.addItem(i8);
        mockToDoList.addItem(i9);
        mockToDoList.addItem(i10);

        doThrow(new RuntimeException("Impossible d'ajouter un item dans la ToDoList"))
                .when(mockToDoList)
                .addItem(i11);
        try {
            mockToDoList.addItem(i11);
        } catch (RuntimeException e) {
            verify(mockToDoList).addItem(i11);
        }

    }


}
