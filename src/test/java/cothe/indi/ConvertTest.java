package cothe.indi;

import cothe.domain.ElementType;
import cothe.messaging.bind.MessageBinder;
import cothe.messaging.bind.SerializedMessageBinderImpl;
import cothe.messaging.bind.SimpleMapEntryValueConcator;
import cothe.messaging.converters.ElementDataConverterSelectorImpl;
import cothe.messaging.model.Element;
import cothe.messaging.model.MessageMetadata;
import cothe.messaging.model.MessageStructure;
import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public class ConvertTest {
    MessageStructure messageStructure = new MessageStructure();
    MessageMetadata messageMetadata = new MessageMetadata();
    Map<String, Object> dataSource = new HashMap<>();

    @Before
    public void init() {
        messageStructure.addElement(new Element("cryMchNo", "운반기기번호", ElementType.STRING, 6, 0, null));
        messageStructure.addElement(new Element("cryMchTp", "운반기기구분", ElementType.STRING, 1, 0, null));
        messageStructure.addElement(new Element("wkKndDtlTp", "작업종류", ElementType.STRING, 2, 0, null));
        messageStructure.addElement(new Element("coilId", "COIL ID", ElementType.STRING, 7, 0, null));
        messageStructure.addElement(new Element("carNo", "차량번호", ElementType.STRING, 5, 0, null));
        messageStructure.addElement(new Element("lodLoc", "적재위치", ElementType.STRING, 9, 0, null));
        messageStructure.addElement(new Element("hoiUpDwnTp", "권상권하구분", ElementType.STRING, 1, 0, null));
        messageStructure.addElement(new Element("bfLodLoc", "전적재위치", ElementType.STRING, 9, 0, null));
        messageStructure.addElement(new Element("coilCnt", "코일수", ElementType.NUMBER, 3, 0, null));
        messageStructure.addElement(new Element("wkDh", "작업일시", ElementType.DATETIME, 14, 0, null));
        messageStructure.addElement(new Element("wkPsdDd", "작업전기일", ElementType.DATETIME, 8, 0, null));
        messageStructure.addElement(new Element("schDd", "스케줄일", ElementType.DATETIME, 8, 0, null));
        messageStructure.addElement(new Element("finSchDh", "종료스케줄일시", ElementType.DATETIME, 12, 0, null));
        messageStructure.addElement(new Element("cmpYn", "완료여부", ElementType.BOOLEAN, 1, 0, null));
        messageStructure.addElement(new Element("wkCost", "작업비용", ElementType.CURRENCY, 100, 0, "KRW"));
        messageStructure.addElement(new Element("wkCostAvg", "평균비용", ElementType.CURRENCY, 100, 0, "KRW"));
        messageStructure.addElement(new Element("coilWgt", "코일중량", ElementType.NUMBER, 5, 0, "kg"));
        messageStructure.addElement(new Element("coilThk", "코일두께", ElementType.NUMBER, 5, 3, "mm"));
        messageStructure.addElement(new Element("coilWidth", "코일폭", ElementType.NUMBER, 7, 1, "mm"));
        messageStructure.addElement(new Element("xOffset", "x축옵셋", ElementType.NUMBER, 10, 1, "mm"));
        messageStructure.addElement(new Element("yOffset", "y축옵셋", ElementType.NUMBER, 10, 1, "mm"));

        messageMetadata.setDestinationSystemId("LGS");
        messageMetadata.setSourceSystemId("MES");
        messageMetadata.setMessageId("MSG00001");
        messageMetadata.setMessageStructure(messageStructure);

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
    }

    @Test
    public void bind() {
        MessageBinder<String, Map.Entry<String, String>> messageBinder = new SerializedMessageBinderImpl(new ElementDataConverterSelectorImpl());
        Message<String> message = messageBinder.bind(messageMetadata, dataSource, new SimpleMapEntryValueConcator());
        System.out.println(message.getPayload());


    }
}
