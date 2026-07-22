package ma.emsi.portailagence.mapper;

import ma.emsi.portailagence.dto.SubscriptionDTO;
import ma.emsi.portailagence.entity.Subscription;

public class SubscriptionMapper {

    public static SubscriptionDTO toDTO(Subscription subscription) {

        if (subscription == null) {
            return null;
        }

        SubscriptionDTO dto = new SubscriptionDTO();

        dto.setId(subscription.getId());

        if (subscription.getClient() != null)
            dto.setClientId(subscription.getClient().getId());

        if (subscription.getProduct() != null)
            dto.setProductId(subscription.getProduct().getId());

        if (subscription.getAccount() != null)
            dto.setAccountId(subscription.getAccount().getId());

        dto.setSubscriptionDate(subscription.getSubscriptionDate());
        dto.setStatus(subscription.getStatus());
        dto.setComment(subscription.getComment());

        return dto;
    }

    public static Subscription toEntity(SubscriptionDTO dto) {

        if (dto == null) {
            return null;
        }

        Subscription subscription = new Subscription();

        subscription.setStatus(dto.getStatus());
        subscription.setComment(dto.getComment());
        subscription.setSubscriptionDate(dto.getSubscriptionDate());

        return subscription;
    }
}