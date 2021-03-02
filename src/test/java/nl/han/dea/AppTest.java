package nl.han.dea;


import nl.han.dea.services.ItemService;
import nl.han.dea.services.dto.ItemDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Mock
    private ItemService itemServiceMock;

    private ItemResource sut = new ItemResource();

    @BeforeEach
    void setUp() {
        sut = new ItemResource();
        sut.itemService = itemServiceMock;
    }
    @Test
    void addItemResourceToService(){
        //arange
        ItemDTO expectedItem = new ItemDTO(10,"testitem",new String[]{"Breakfast, Lunch"}, "Delicous!");
        when(itemServiceMock.getItem(10)).thenReturn(expectedItem);
        //act
        var actualResult = sut.getItemById(10).getEntity();
        //assert
        Assertions.assertEquals(expectedItem, actualResult);
    }
}
