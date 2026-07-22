package ma.emsi.portailagence.controller;

import ma.emsi.portailagence.entity.Account;
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
    public Account createAccount(@PathVariable Long clientId,
                                 @RequestBody Account account) {

        return accountService.createAccount(clientId, account);
    }
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

}