public class CaixaEletronico {
    private ControleConta[] contas;

    public CaixaEletronico() {
       
    }

    public ControleConta[] getContas() {
        return contas;
    }

    public void setContas(ControleConta[] contas) {
        this.contas = contas;
    }

    public ControleConta logar (String validEmail, String validPassword) {

        ControleConta conta = new ControleConta();

        if (contas.length == 0) {
            return null;
        }
        
        for (int i = 0; i < contas.length; i++) {
            if(validEmail.equals(contas[i].getEmail())) {
                if(validPassword.equals(contas[i].getSenha())) {
                    conta = contas[i];
                    return conta;
                }
            }
        }

        return null;
    }

    public String criarConta (String email, String password) {

        ControleConta existingAccount = validateAccountExistence(email);

        if(existingAccount != null) {
            return "Email já utilizado. Tente criar uma conta com outro email.";
        }

        ControleConta newAccount = new ControleConta(email, password);
        addAcountToList(newAccount);

        return "Conta criada com sucesso!";
    }

    public String sacar (ControleConta validAccount, double value) {

        if(value < 0) {
            return "Não é possível sacar um valor negativo";
        }

        double amount = validAccount.getSaldo();

        if(amount == 0) {
            return "Não há saldo para sacar";
        }

        if (value > amount) {
            return "Você não pode sacar um valor maior que seu saldo";
        }

        validAccount.setSaldo(amount - value);

        return "Seu saque de " + value + " foi realizado com sucesso!";
    }

    public String depositar (ControleConta validAccount, double value) {

        if(value < 0) {
            return "Não é possível depositar um valor negativo";
        }

        double amount = validAccount.getSaldo();

        validAccount.setSaldo(amount + value);

        return "Seu depósito de " + value + " foi realizado com sucesso!";
    }

    public double verSaldo (ControleConta validAccount) {
        return validAccount.getSaldo();
    }

    public String envioPix (ControleConta validAccount, String email, double value) {

        if(value < 0) {
            return "Não se pode enviar um valor negativo";
        }

        if(validAccount.getEmail().equals(email)) {
            return "Você não pode enviar PIX para si mesmo";
        }

        ControleConta account = validateAccountExistence(email);

        if(account == null) {
            return "O envio do PIX não foi realizado pois o email é inexistente.";
        }

        double amount = validAccount.getSaldo();

        if(amount == 0 || amount < value) {
            return "Você não possui saldo para efetuar essa operação.";
        }

        validAccount.setSaldo(amount - value);
        account.setSaldo(account.getSaldo() + value);

        return "Seu PIX de " + value + " para o destinatário " + email + "foi concluída com sucesso!";
    }

    private ControleConta validateAccountExistence (String accountEmail) {

        if(contas == null ) {
            return null;
        }

        ControleConta conta = new ControleConta();

        for (int i = 0; i < contas.length; i++) {
            if(accountEmail.equals(contas[i].getEmail())) {
                conta = contas[i];
                return conta;
            }
        }

        return null;
    }

    private void addAcountToList (ControleConta newAccount) {

        ControleConta[] allAccounts;

        if(contas == null) {
            allAccounts = new ControleConta[1];
            allAccounts[0] = newAccount;
        } else {
            allAccounts =  new ControleConta[contas.length+1];
            for (int i = 0; i < contas.length; i++ ) {
                allAccounts[i] = contas[i];
            }
            allAccounts[contas.length] = newAccount;
        }

        contas = allAccounts;


    }
    
}
