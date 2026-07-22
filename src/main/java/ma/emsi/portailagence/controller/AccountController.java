package ma.emsi.portailagence.controller;

import ma.emsi.portailagence.dto.AccountDTO;
import ma.emsi.portailagence.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/client/{clientId}")
    public AccountDTO createAccount(@PathVariable Long clientId,
                                    @RequestBody AccountDTO account) {

        return accountService.createAccount(clientId, account);
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountDTO getAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}