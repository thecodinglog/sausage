package cothe.learningTests.stream;

import cothe.messaging.model.DataElement;
import cothe.messaging.model.MessageMetadata;
import cothe.messaging.model.StructureElement;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cothe.messaging.model.ElementType.*;
import static cothe.messaging.model.ElementType.CURRENCY;
import static cothe.messaging.model.ElementType.NUMBER;
import static java.util.stream.Collectors.toList;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 9.
 */
public class StreamTest {
    private final StructureElement structureElement = new StructureElement();
    private final StructureElement structureElementG1 = new StructureElement();
    private final StructureElement structureElementG2 = new StructureElement();

    @Before
    public void init() {
        structureElementG2.addElement(new DataElement("lotNo", "Lot번호", STRING, 9, 0, null));
        structureElementG2.addElement(new DataElement("subLotNo", "서브Lot번호", STRING, 9, 0, null));
        structureElementG2.setId("lotList");
        structureElementG2.setName("Lot리스트");
        structureElementG2.setLength(5);

        structureElementG1.addElement(new DataElement("rmtlNo", "원재료번호", STRING, 9, 0, null));
        structureElementG1.addElement(new DataElement("smtlRmtlNo", "공급업체원재료번호", STRING, 9, 0, null));
        structureElementG1.addElement(structureElementG2);
        structureElementG1.setId("rmtlNoList");
        structureElementG1.setName("원재료리스트");
        structureElementG1.setLength(10);


        structureElement.addElement(new DataElement("cryMchNo", "운반기기번호", STRING, 6, 0, null));
        structureElement.addElement(new DataElement("cryMchTp", "운반기기구분", STRING, 1, 0, null));
        structureElement.addElement(new DataElement("wkKndDtlTp", "작업종류", STRING, 2, 0, null));
        structureElement.addElement(new DataElement("coilId", "COIL ID", STRING, 7, 0, null));
        structureElement.addElement(new DataElement("carNo", "차량번호", STRING, 5, 0, null));
        structureElement.addElement(new DataElement("lodLoc", "적재위치", STRING, 9, 0, null));
        structureElement.addElement(new DataElement("hoiUpDwnTp", "권상권하구분", STRING, 1, 0, null));
        structureElement.addElement(new DataElement("bfLodLoc", "전적재위치", STRING, 9, 0, null));
        structureElement.addElement(new DataElement("coilCnt", "코일수", NUMBER, 3, 0, null));
        structureElement.addElement(new DataElement("wkDh", "작업일시", DATETIME, 14, 0, null));
        structureElement.addElement(new DataElement("wkPsdDd", "작업전기일", DATETIME, 8, 0, null));
        structureElement.addElement(new DataElement("schDd", "스케줄일", DATETIME, 8, 0, null));
        structureElement.addElement(new DataElement("finSchDh", "종료스케줄일시", DATETIME, 14, 0, null));
        structureElement.addElement(new DataElement("cmpYn", "완료여부", BOOLEAN, 1, 0, null));
        structureElement.addElement(new DataElement("wkCost", "작업비용", CURRENCY, 10, 0, "KRW"));
        structureElement.addElement(new DataElement("wkCostAvg", "평균비용", CURRENCY, 10, 0, "KRW"));

        structureElement.addElement(structureElementG1);

        structureElement.addElement(new DataElement("coilWgt", "코일중량", NUMBER, 5, 0, "kg"));
        structureElement.addElement(new DataElement("coilThk", "코일두께", NUMBER, 5, 3, "mm"));
        structureElement.addElement(new DataElement("coilWidth", "코일폭", NUMBER, 7, 1, "mm"));
        structureElement.addElement(new DataElement("xOffset", "x축옵셋", NUMBER, 10, 1, "mm"));
        structureElement.addElement(new DataElement("yOffset", "y축옵셋", NUMBER, 10, 1, "mm"));

    }
    @Test
    public void stream(){
        List<Integer> sizes = structureElement.getElements().stream().map(element -> element.getLength()).collect(toList());
        for (Integer size : sizes) {

            System.out.println(size);

        }
    }
}
