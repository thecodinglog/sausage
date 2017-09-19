package cothe.messaging.parser;

import cothe.messaging.SerializedMessage;
import cothe.messaging.converter.ElementDataConverterSelector;
import cothe.messaging.model.DataElement;
import cothe.messaging.model.MessageMetadata;
import cothe.messaging.model.StructureElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static cothe.messaging.model.ElementType.STRING;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class SerializedMessageParserImplTest {
    @Autowired
    ElementDataConverterSelector elementDataConverterSelector;

    @Test
    public void parse() throws Exception {

        MessageMetadata messageMetadata = new MessageMetadata();

        String dataSource = "기계01CMV";
        StructureElement structureElement = new StructureElement();
        structureElement.addElement(new DataElement("cryMchNo", "운반기기번호", STRING, 6, 0, null));
        structureElement.addElement(new DataElement("cryMchTp", "운반기기구분", STRING, 1, 0, null));
        structureElement.addElement(new DataElement("wkKndDtlTp", "작업종류", STRING, 2, 0, null));

        messageMetadata.setDestinationSystemId("MES");
        messageMetadata.setSourceSystemId("LGS");
        messageMetadata.setMessageId("MSG00001");
        messageMetadata.setStructureElement(structureElement);

        SerializedMessageParserImpl smp = new SerializedMessageParserImpl(elementDataConverterSelector);

        Map<String, Object> result = smp.parse(messageMetadata, new SerializedMessage(dataSource, null));


        result.forEach((s, o) -> System.out.println(s + ":" + o.toString()));
        // Assert.assertEquals(3, compartmental.getCompartmentSize());
    }

}