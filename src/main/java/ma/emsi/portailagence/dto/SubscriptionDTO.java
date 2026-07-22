package ma.emsi.portailagence.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SubscriptionDTO {

    private Long id;

    private Long clientId;

    private Long productId;

    private Long accountId;

    private LocalDate subscriptionDate;

    private String status;

    private String comment;
}
