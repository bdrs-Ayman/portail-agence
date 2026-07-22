package ma.emsi.portailagence.service;

import ma.emsi.portailagence.dto.AccountDTO;
import ma.emsi.portailagence.entity.Account;
import ma.emsi.portailagence.entity.Client;
import ma.emsi.portailagence.mapper.AccountMapper;
import ma.emsi.portailagence.repository.AccountRepository;
import ma.emsi.portailagence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountService(AccountRepository accountRepository,
                          ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public AccountDTO createAccount(Long clientId, AccountDTO dto) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Account account = AccountMapper.toEntity(dto);

        account.setClient(client);
        account.setNumeroCompte("ACC" + System.currentTimeMillis());
        account.setDateOuverture(LocalDate.now());

        return AccountMapper.toDTO(accountRepository.save(account));
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(Long id) {
        return AccountMapper.toDTO(
                accountRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Account not found"))
        );
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}