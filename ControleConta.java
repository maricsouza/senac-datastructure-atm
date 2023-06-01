public class ControleConta {

    private String email;
    private String senha;
    private double saldo;

    public ControleConta() {

    }
    public ControleConta(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.saldo = 0;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
