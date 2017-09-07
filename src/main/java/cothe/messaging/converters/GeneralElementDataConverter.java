package cothe.messaging.converters;

import cothe.domain.ElementType;
import cothe.messaging.converters.policies.ConvertingPolicy;
import cothe.messaging.model.DataElement;
import lombok.NonNull;
import lombok.Setter;

import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class GeneralElementDataConverter implements ElementDataConverter {
    @Setter
    private Map<ElementType, ConvertingPolicy> policies;

    @Override
    public String convert(@NonNull DataElement element, Object data) {
/*
        if(data == null){
            return null;
        }
        
        if(policies == null){
            return data.toString();
        }
*/


        ConvertingPolicy convertingPolicy = policies.get(element.getElementType());
        if (convertingPolicy == null) {
            if(data == null){
                return null;
            }
            return data.toString();
        } else {
            return convertingPolicy.convert(data,element);
        }
    }
}
