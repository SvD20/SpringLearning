package bankapp.web.controller;

import bankapp.model.Account;
import bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @ModelAttribute
    public Account account() {
        return new Account();
    }

    @GetMapping(value = "/open-account")
    public String openAccountForm (){
        return "accountForm";
    }

    @PostMapping(value = "/open-account")
    public String save (@Valid @ModelAttribute("account") Account account, Errors errors){
        if (errors.hasErrors()) {
            return "accountForm";
        }
        accountService.open(account);
        return "redirect:/accounts/"+account.getId();
    }

    @GetMapping(value = "/accounts/{accountId}")
    public String getAccountDetails (ModelMap model, @PathVariable Long accountId){
        Account account = accountService.findOne(accountId);
        model.put("account", account);
        return "accountDetails";
    }

    @GetMapping(value = "/all-accounts")
    public String all (ModelMap model){
        List<Account> accounts = accountService.findAllAccounts();
        model.put("accounts", accounts);
        return "accounts";
    }
}
