package cothe.indi;

import cothe.domain.ElementType;
import cothe.messaging.bind.MessageBinder;
import cothe.messaging.bind.SimpleMapEntryValueConcator;
import cothe.messaging.model.DataElement;
import cothe.messaging.model.MessageMetadata;
import cothe.messaging.model.StructureElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class ConvertTest {
    StructureElement structureElement = new StructureElement();
    StructureElement structureElementG1 = new StructureElement();
    StructureElement structureElementG2 = new StructureElement();

    MessageMetadata messageMetadata = new MessageMetadata();
    Map<String, Object> dataSource = new HashMap<>();
    ApplicationContext applicationContext;

    @Before
    public void init() {
        structureElementG1.addElement(new DataElement("rmtlNo", "원재료번호",ElementType.STRING,9,0,null));
        structureElementG1.addElement(new DataElement("smtlRmtlNo", "공급업체원재료번호",ElementType.STRING,9,0,null));
        structureElementG1.setId("rmtlNoList");
        structureElementG1.setName("원재료리스트");
        structureElementG1.setLength(10);

        structureElementG2.addElement(new DataElement("lotNo", "Lot번호",ElementType.STRING,9,0,null));
        structureElementG2.addElement(new DataElement("subLotNo", "서브Lot번호",ElementType.STRING,9,0,null));
        structureElementG2.setId("lotList");
        structureElementG2.setName("Lot리스트");
        structureElementG2.setLength(5);

        structureElement.addElement(new DataElement("cryMchNo", "운반기기번호", ElementType.STRING, 6, 0, null));
        structureElement.addElement(new DataElement("cryMchTp", "운반기기구분", ElementType.STRING, 1, 0, null));
        structureElement.addElement(new DataElement("wkKndDtlTp", "작업종류", ElementType.STRING, 2, 0, null));
        structureElement.addElement(new DataElement("coilId", "COIL ID", ElementType.STRING, 7, 0, null));
        structureElement.addElement(new DataElement("carNo", "차량번호", ElementType.STRING, 5, 0, null));
        structureElement.addElement(new DataElement("lodLoc", "적재위치", ElementType.STRING, 9, 0, null));
        structureElement.addElement(new DataElement("hoiUpDwnTp", "권상권하구분", ElementType.STRING, 1, 0, null));
        structureElement.addElement(new DataElement("bfLodLoc", "전적재위치", ElementType.STRING, 9, 0, null));
        structureElement.addElement(new DataElement("coilCnt", "코일수", ElementType.NUMBER, 3, 0, null));
        structureElement.addElement(new DataElement("wkDh", "작업일시", ElementType.DATETIME, 14, 0, null));
        structureElement.addElement(new DataElement("wkPsdDd", "작업전기일", ElementType.DATETIME, 8, 0, null));
        structureElement.addElement(new DataElement("schDd", "스케줄일", ElementType.DATETIME, 8, 0, null));
        structureElement.addElement(new DataElement("finSchDh", "종료스케줄일시", ElementType.DATETIME, 12, 0, null));
        structureElement.addElement(new DataElement("cmpYn", "완료여부", ElementType.BOOLEAN, 1, 0, null));
        structureElement.addElement(new DataElement("wkCost", "작업비용", ElementType.CURRENCY, 10, 0, "KRW"));
        structureElement.addElement(new DataElement("wkCostAvg", "평균비용", ElementType.CURRENCY, 10, 0, "KRW"));
        structureElement.addElement(new DataElement("coilWgt", "코일중량", ElementType.NUMBER, 5, 0, "kg"));
        structureElement.addElement(new DataElement("coilThk", "코일두께", ElementType.NUMBER, 5, 3, "mm"));
        structureElement.addElement(new DataElement("coilWidth", "코일폭", ElementType.NUMBER, 7, 1, "mm"));
        structureElement.addElement(new DataElement("xOffset", "x축옵셋", ElementType.NUMBER, 10, 1, "mm"));
        structureElement.addElement(new DataElement("yOffset", "y축옵셋", ElementType.NUMBER, 10, 1, "mm"));

        structureElement.addElement(structureElementG1);
        structureElement.addElement(structureElementG2);

        messageMetadata.setDestinationSystemId("LGS");
        messageMetadata.setSourceSystemId("MES");
        messageMetadata.setMessageId("MSG00001");
        messageMetadata.setStructureElement(structureElement);

        dataSource.put("cryMchNo", "CH001");
        dataSource.put("cryMchTp", "C");
        dataSource.put("wkKndDtlTp", "M1");
        dataSource.put("coilId", "COIL001");
        dataSource.put("carNo", "12233");
        dataSource.put("lodLoc", "BBB1222");
        dataSource.put("hoiUpDwnTp", "U");
        dataSource.put("bfLodLoc", "BBB1223");
        dataSource.put("coilCnt", "10");
        dataSource.put("wkDh", new GregorianCalendar(2016 + 1900, 3, 12, 24, 3, 11));
        dataSource.put("wkPsdDd", new GregorianCalendar(2016 + 1900, 3, 12));
        dataSource.put("schDd", "20130305");
        dataSource.put("finSchDh", "2013-03-05 12:34");
        dataSource.put("cmpYn", true);
        dataSource.put("wkCost", 34433);
        dataSource.put("coilWgt", 99320);
        dataSource.put("wkCostAvg", 3393.23);
        dataSource.put("coilThk", 1.233);
        dataSource.put("coilWidth", "1032.3");
        dataSource.put("xOffset", "-10.1");
        dataSource.put("yOffset", -13.1);

        dataSource.put("rmtlNoList_rmtlNo_0", "rmtlno0");
        dataSource.put("rmtlNoList_rmtlNo_1", "rmtlno1");
        dataSource.put("rmtlNoList_rmtlNo_2", "rmtlno2");
        dataSource.put("rmtlNoList_rmtlNo_3", "rmtlno3");
        dataSource.put("rmtlNoList_smtlRmtlNo_2", "smtlrmtlno2");
        dataSource.put("lotList_lotNo_2", "lotNo2");

        this.applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }

   /* @Test
    public void getBeanTest() {
        ElementDataConverterSelector elementDataConverterSelector = applicationContext.getBean("elementDataSelector", ElementDataSelector.)
    }

*/    @Test
    public void bind() {

        MessageBinder<String, Map.Entry<String, String>> messageBinder = applicationContext.getBean("messageBinder", MessageBinder.class);
        Message<String> message = messageBinder.bind(messageMetadata, dataSource, "|");
        System.out.println(message.getPayload());


    }
}
