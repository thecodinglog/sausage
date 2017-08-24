package cothe.messaging.converters;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class ElementDataConverterSelectorImpl implements ElementDataConverterSelector {

    @Override
    public ElementDataConverter getElementDataConverter() {
        return new FixedLengthElementDataConverter();
    }
}
