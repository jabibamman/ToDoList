import com.todolist.todolist.ToDoList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
public class ToDoListTest {

    @Test
    public void testAddItem() {

        ToDoList mockToDoList = mock(ToDoList.class);

        when(mockToDoList.lastTwoItems()).thenReturn(false); //N'envoie jamais le mail

        mockToDoList.initList();
        mockToDoList.addItem(5);

        verify(mockToDoList).initList();
        verify(mockToDoList).addItem(5);

    }
}
