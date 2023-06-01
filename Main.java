import java.util.Scanner;

public class Main {
    public static void main (String[]args) {

        CaixaEletronico caixa = new CaixaEletronico();
        Scanner scanner = new Scanner(System.in);
        int resp = exibirMenuUm();

        while (resp > 0) {
            switch (resp) {
                case 1:
                    System.out.println("Digite um email:");
                    String email = scanner.next();
                    System.out.println("Digite uma senha:");
                    String pwd = scanner.next();

                    String retorno = caixa.criarConta(email, pwd);
                    System.out.println(retorno);

                    break;
                case 2:

                    System.out.println("Digite um email:");
                    String emailAccount = scanner.next();
                    System.out.println("Digite uma senha:");
                    String pwdAccount = scanner.next();

                    ControleConta account = caixa.logar(emailAccount, pwdAccount);
                    if(account == null) {
                        System.out.println("Login inválido. Tente novamente.");
                    } else {
                        int response = exibirMenuDois();
                        while (response > 0) {
                            switch(response) {
                                case 1:
                                    System.out.println("Qual o valor que deseja sacar?: ");
                                    double valor = scanner.nextDouble();
                                    System.out.println(caixa.sacar(account, valor));
                                    break;
                                case 2:
                                    System.out.println("Qual valor você deseja depositar?: ");
                                    valor = scanner.nextDouble();
                                    System.out.println(caixa.depositar(account, valor));
                                    break;
                                case 3:
                                    System.out.println("Seu saldo é " + caixa.verSaldo(account));
                                    break;
                                case 4:
                                    System.out.println("Informe o destinatário: ");
                                    String destinatario = scanner.next();
                                    System.out.println("Informe o valor do PIX: ");
                                    valor = scanner.nextDouble();
                                    System.out.println(caixa.envioPix(account, destinatario, valor));
                                    break;
                            }

                            response = exibirMenuDois();
                        }
                    }

                    break;
            }

            resp = exibirMenuUm();
        }


    }

    public static int exibirMenuUm () {
        Scanner sc = new Scanner(System.in);

        System.out.println("####     CAIXA ELETRONICO     ####");
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1. Criar conta \n2. Login \n0. Sair");
        int retorno = sc.nextInt();

        if(retorno > 2 || retorno < 0) {
            return -1;
        }
    
        return retorno;
    }

    public static int exibirMenuDois () {
        Scanner sc = new Scanner(System.in);

        System.out.println("####    CAIXA ELETRONICO     ####");
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1. Sacar \n2. Depositar \n3. Ver saldo \n4. PIX \n0. Sair");
        int retorno = sc.nextInt();

        if(retorno > 4 || retorno < 0) {
            return -1;
        }
    
        return retorno;
    }
}
