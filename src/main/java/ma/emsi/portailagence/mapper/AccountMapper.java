package ma.emsi.portailagence.mapper;

import ma.emsi.portailagence.dto.AccountDTO;
import ma.emsi.portailagence.entity.Account;

public class AccountMapper {

    public static AccountDTO toDTO(Account account) {

        if (account == null) {
            return null;
        }

        AccountDTO dto = new AccountDTO();

        dto.setId(account.getId());
        dto.setNumeroCompte(account.getNumeroCompte());
        dto.setTypeCompte(account.getTypeCompte());
        dto.setDateOuverture(account.getDateOuverture());
        dto.setSolde(account.getSolde());
        dto.setStatut(account.getStatut());
        dto.setCreatedAt(account.getCreatedAt());
        dto.setUpdatedAt(account.getUpdatedAt());

        if (account.getClient() != null) {
            dto.setClientId(account.getClient().getId());
        }

        return dto;
    }

    public static Account toEntity(AccountDTO dto) {

        if (dto == null) {
            return null;
        }

        Account account = new Account();

        account.setTypeCompte(dto.getTypeCompte());
        account.setSolde(dto.getSolde());
        account.setStatut(dto.getStatut());

        return account;
    }
}