import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame{
    public Janela(){
        setTitle("Login");
        setSize(300, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel endereco_login = new JLabel("Digite seu email/telefone:");
        endereco_login.setBounds(75, 50, 150, 15);
        JTextField login = new JTextField();
        login.setBounds(75, 75, 150, 15);

        JLabel senha_login = new JLabel("Digite sua senha:");
        senha_login.setBounds(75, 100, 150, 15);
        JTextField senha = new JTextField();
        senha.setBounds(75, 125, 150, 15);

        JButton entrar = new JButton("Entrar");
        entrar.setBounds(45, 300, 200, 50);

        JButton criar_conta = new JButton("Criar conta");
        criar_conta.setBounds(100, 400, 100, 50);

        entrar.addActionListener(e->{
           janela.getContentPane().removeAll();
        });
        
        setLayout(null);
        //add-> coloca os componentes dentro da Janela
        add(endereco_login);
        add(login);
        add(senha_login);
        add(senha);
        add(entrar);
        add(criar_conta);
        setVisible(true);
    }
    public static void main(String[] args){
        new Janela();
    }
}

