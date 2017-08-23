package cothe.model;

import lombok.Data;

public @Data class MessageMetadata {
    private String messageId;

    private String sourceOrganizationId;
    private String sourceSystemId;
    private String sourceServiceId;

    private String destinationOrganizationId;
    private String destinationSystemId;
    private String destinationServiceId;

    private MessageStructure messageStructure;

}
