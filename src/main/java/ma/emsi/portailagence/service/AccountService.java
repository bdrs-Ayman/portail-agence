package ma.emsi.portailagence.service;

import ma.emsi.portailagence.entity.Account;
import ma.emsi.portailagence.entity.Client;
import ma.emsi.portailagence.repository.AccountRepository;
import ma.emsi.portailagence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountService(AccountRepository accountRepository,
                          ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public Account createAccount(Long clientId, Account account) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        account.setClient(client);

        account.setNumeroCompte("ACC" + System.currentTimeMillis());

        account.setDateOuverture(LocalDate.now());

        return accountRepository.save(account);
    }
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}