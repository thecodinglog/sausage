package cothe.messaging.parser;

import cothe.messaging.exceptions.DecodingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 11.
 */
public class CompartmentalByteLengthStringTest {
    Compartmental<String> compartmental;
    String dataSource;
    Iterable<Integer> roomList;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getCompartmentSize() throws Exception {
        dataSource = "abcd45한글 ";
        roomList = Arrays.asList(4, 2, 5);
        compartmental = new CompartmentalByteLengthString(dataSource, roomList, null, Charset.forName("euc-kr"));
        Assert.assertEquals(3, compartmental.getCompartmentSize());

    }

    @Test
    public void getByteLengthWithDelimiter() throws Exception {
        dataSource = "abcd|45|한글";
        Iterable<Integer> roomList = Arrays.asList(4, 2, 5);
        compartmental = new CompartmentalByteLengthString(dataSource, roomList, "|", Charset.forName("euc-kr"));
        Assert.assertEquals(12, compartmental.getByteLength(Charset.forName("euc-kr"), false));
        Assert.assertEquals(10, compartmental.getByteLength(Charset.forName("euc-kr"), true));
    }

    @Test
    public void getByteLengthWithFixedLength() throws Exception {
        dataSource = "abcd45한글 ";
        Iterable<Integer> roomList = Arrays.asList(4, 2, 5);
        compartmental = new CompartmentalByteLengthString(dataSource, roomList, null, Charset.forName("euc-kr"));
        Assert.assertEquals(11, compartmental.getByteLength(Charset.forName("euc-kr"), false));

        roomList = Arrays.asList(4, 2, 6);
        compartmental = new CompartmentalByteLengthString(dataSource, roomList, null, Charset.forName("utf-8"));
        Assert.assertEquals(13, compartmental.getByteLength(Charset.forName("utf-8"), false));
    }

    @Test(expected = DecodingException.class)
    public void iterator() throws Exception {
        dataSource = "abcd45한글 ";
        Iterable<Integer> roomList = Arrays.asList(2, 4, 3, 1);
        compartmental = new CompartmentalByteLengthString(dataSource, roomList, null, Charset.forName("euc-kr"));
        compartmental.forEach(s -> System.out.println(s));

    }

}