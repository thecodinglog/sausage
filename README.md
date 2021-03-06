메시지 생성 및 파싱
-

메시지 구조 정보와 실 데이터를 매핑하며 타 시스템과 연계하기 위한 메시지를
생성하고, 그 역을 수행한다


샘플 ApplicationContext.xml
-

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd"
>
    <bean id="booleanPolicy" class="cothe.messaging.converter.policies.booleanPolicies.YNBooleanPolicy"/>
    <bean id="currencyPolicy" class="cothe.messaging.converter.policies.currencyPolicies.DefaultCurrencyPolicy"/>
    <bean id="datetimePolicy" class="cothe.messaging.converter.policies.datetimePolicies.DefaultDateTimePolicy">
    </bean>

    <bean id="numberPolicy" class="cothe.messaging.converter.policies.numberPolicies.PlainNumberPolicy"/>
    <bean id="stringPolicy" class="cothe.messaging.converter.policies.stringPolicies.PlainStringPolicy"/>

    <bean id="fixedLengthBooleanPolicy" class="cothe.messaging.converter.policies.booleanPolicies.FixedLengthRightPaddingYNBooleanPolicy"/>
    <bean id="fixedLengthCurrencyPolicy" class="cothe.messaging.converter.policies.currencyPolicies.FixedLengthLeftPaddingCurrencyPolicy"/>
    <bean id="fixedLengthDatetimePolicy" class="cothe.messaging.converter.policies.datetimePolicies.FixedLengthRightPaddingDateTimePolicy">
     <property name="outputDatetimeFormat" value="yyyy-MM-dd HH:mm:ss.SSS"/>
    </bean>

    <bean id="fixedLengthNumberPolicy" class="cothe.messaging.converter.policies.numberPolicies.FixedLengthLeftPaddingNumberPolicy"/>
    <bean id="fixedLengthStringPolicy" class="cothe.messaging.converter.policies.stringPolicies.FixedByteLengthRightPaddingStringPolicy"/>

    <bean id="elementDataConverter" class="cothe.messaging.converter.policies.stringPolicies.PlainStringPolicy"/>

    <bean id="fixedLengthElementDataConverter" class="cothe.messaging.converter.GeneralElementDataConverter">
        <constructor-arg name="delimiter" value=""/>
        <constructor-arg name="charset" value="euc-kr"/>
        <constructor-arg name="locale" value="ko_KR"/>
        <property name="policies" >
            <map key-type="cothe.messaging.model.ElementType" value-type="cothe.messaging.converter.policies.ConvertingPolicy">
                <entry key="BOOLEAN" value-ref="fixedLengthBooleanPolicy"/>
                <entry key="CURRENCY" value-ref="fixedLengthCurrencyPolicy"/>
                <entry key="DATETIME" value-ref="fixedLengthDatetimePolicy"/>
                <entry key="NUMBER" value-ref="fixedLengthNumberPolicy"/>
                <entry key="STRING" value-ref="fixedLengthStringPolicy"/>
            </map>
        </property>
    </bean>
    <bean id="delimiterElementDataConverter" class="cothe.messaging.converter.GeneralElementDataConverter">
        <constructor-arg name="delimiter" value="|"/>
        <constructor-arg name="charset" value="utf-8"/>
        <constructor-arg name="locale" value="ko_KR"/>
        <property name="policies" >
            <map key-type="cothe.messaging.model.ElementType" value-type="cothe.messaging.converter.policies.ConvertingPolicy">
                <entry key="BOOLEAN" value-ref="booleanPolicy"/>
                <entry key="CURRENCY" value-ref="currencyPolicy"/>
                <entry key="DATETIME" value-ref="datetimePolicy"/>
                <entry key="NUMBER" value-ref="numberPolicy"/>
                <entry key="STRING" value-ref="stringPolicy"/>
            </map>
        </property>
    </bean>


    <bean id="elementDataConverterSelector" class="cothe.messaging.converter.ElementDataConverterSelectorImpl">
        <property name="converterMapper">
            <map key-type="java.lang.String" value-type="cothe.messaging.converter.ElementDataConverter">
                <entry key="MES|LGS" value-ref="fixedLengthElementDataConverter"/>
                <entry key="LGS|MES" value-ref="fixedLengthElementDataConverter"/>
                <entry key="MES|MES" value-ref="delimiterElementDataConverter"/>
                <entry key="MES|MES" value-ref="delimiterElementDataConverter"/>

            </map>
        </property>
    </bean>


    <bean id="messageBinder" class="cothe.messaging.binder.SerializedMessageBinderImpl">
        <constructor-arg name="elementDataConverterSelector" ref="elementDataConverterSelector"/>
    </bean>

    <bean id="messageParser" class="cothe.messaging.parser.SerializedMessageParserImpl">
        <constructor-arg name="elementDataConverterSelector" ref="elementDataConverterSelector"/>
    </bean>

</beans>
```