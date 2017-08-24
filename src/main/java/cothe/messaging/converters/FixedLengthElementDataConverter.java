package cothe.messaging.converters;

import cothe.domain.ElementType;
import cothe.messaging.converters.policies.ConvertingPolicy;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class FixedLengthElementDataConverter implements ElementDataConverter {
    @Setter
    HashMap<ElementType, ConvertingPolicy> policies;

    @Override
    public String convert(@NonNull ElementType elementType, Object data) {
        if(data == null){
            return null;
        }
        
        if(policies == null){
            return data.toString();
        }


        ConvertingPolicy convertingPolicy = policies.get(elementType);
        if (convertingPolicy == null) {
            return data.toString();
        } else {
            return convertingPolicy.convert(data);
        }
    }
}
