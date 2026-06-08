import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cadastro {

    public static void main(String[] args) {

        JFrame janela = new JFrame("Criar Conta");
        janela.setSize(500, 750);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(Color.BLACK);

        // TÍTULO
        JLabel titulo = new JLabel("Criar Conta");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // EMAIL
        JLabel emailLabel = new JLabel("Digite o email");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField emailCampo = new JTextField();
        emailCampo.setMaximumSize(new Dimension(350, 35));

        // TELEFONE
        JLabel telefoneLabel = new JLabel("Digite o telefone");
        telefoneLabel.setForeground(Color.WHITE);
        telefoneLabel.setFont(new Font("Arial", Font.BOLD, 18));
        telefoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField telefoneCampo = new JTextField();
        telefoneCampo.setMaximumSize(new Dimension(350, 35));

        // NOME
        JLabel nomeLabel = new JLabel("Digite o nome");
        nomeLabel.setForeground(Color.WHITE);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nomeCampo = new JTextField();
        nomeCampo.setMaximumSize(new Dimension(350, 35));

        // SENHA
        JLabel senhaLabel = new JLabel("Digite uma senha");
        senhaLabel.setForeground(Color.WHITE);
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        senhaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField senhaCampo = new JPasswordField();
        senhaCampo.setMaximumSize(new Dimension(350, 35));

        // CONTATO
        JLabel contatoLabel = new JLabel("Contato");
        contatoLabel.setForeground(Color.WHITE);
        contatoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contatoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JToggleButton tipoContato = new JToggleButton("Pessoal");
        tipoContato.setMaximumSize(new Dimension(180, 40));
        tipoContato.setAlignmentX(Component.CENTER_ALIGNMENT);

        tipoContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tipoContato.isSelected()) {
                    tipoContato.setText("Profissional");
                } else {
                    tipoContato.setText("Pessoal");
                }

            }
        });

        // CHECKBOXES
        JLabel permitirLabel = new JLabel("Permitir:");
        permitirLabel.setForeground(Color.WHITE);
        permitirLabel.setFont(new Font("Arial", Font.BOLD, 18));
        permitirLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JCheckBox ligacao = new JCheckBox("Ligação");
        JCheckBox mensagem = new JCheckBox("Mensagem");
        JCheckBox emailCheck = new JCheckBox("Email");

        ligacao.setBackground(Color.BLACK);
        mensagem.setBackground(Color.BLACK);
        emailCheck.setBackground(Color.BLACK);

        ligacao.setForeground(Color.WHITE);
        mensagem.setForeground(Color.WHITE);
        emailCheck.setForeground(Color.WHITE);

        ligacao.setAlignmentX(Component.CENTER_ALIGNMENT);
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailCheck.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BOTÃO
        JButton criarConta = new JButton("Criar Conta");
        criarConta.setFont(new Font("Arial", Font.BOLD, 18));
        criarConta.setPreferredSize(new Dimension(200, 45));

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(Color.BLACK);
        painelBotao.add(criarConta);

        // AÇÃO DO BOTÃO
        criarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailCampo.getText().trim();
                String telefone = telefoneCampo.getText().trim();
                String nome = nomeCampo.getText().trim();
                String senha = new String(senhaCampo.getPassword()).trim();

                // EMAIL OU TELEFONE
                if (email.isEmpty() && telefone.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "Preencha Email ou Telefone.");

                    return;
                }

                // NOME
                if (nome.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "O nome é obrigatório.");

                    return;
                }

                // SENHA
                if (senha.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "A senha é obrigatória.");

                    return;
                }

                // CHECKBOX
                if (!ligacao.isSelected()
                        && !mensagem.isSelected()
                        && !emailCheck.isSelected()) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "Selecione pelo menos uma forma de contato.");

                    return;
                }

                // CADASTRO JÁ EXISTENTE
                if (email.equalsIgnoreCase("admin@gmail.com")
                        || telefone.equals("999991120")) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "Já existe conta criada com email/telefone.");

                    return;
                }

                JOptionPane.showMessageDialog(
                        janela,
                        "Conta criada com sucesso, faça o login para iniciar sessão.");
            }
        });

        // ADICIONAR COMPONENTES

        painel.add(Box.createVerticalStrut(30));

        painel.add(titulo);

        painel.add(Box.createVerticalStrut(30));

        painel.add(emailLabel);
        painel.add(emailCampo);

        painel.add(Box.createVerticalStrut(15));

        painel.add(telefoneLabel);
        painel.add(telefoneCampo);

        painel.add(Box.createVerticalStrut(15));

        painel.add(nomeLabel);
        painel.add(nomeCampo);

        painel.add(Box.createVerticalStrut(15));

        painel.add(senhaLabel);
        painel.add(senhaCampo);

        painel.add(Box.createVerticalStrut(20));

        painel.add(contatoLabel);

        painel.add(Box.createVerticalStrut(10));

        painel.add(tipoContato);

        painel.add(Box.createVerticalStrut(20));

        painel.add(permitirLabel);

        painel.add(ligacao);
        painel.add(mensagem);
        painel.add(emailCheck);

        painel.add(Box.createVerticalStrut(25));

        painel.add(painelBotao);

        janela.add(painel);
        janela.setVisible(true);
    }
}
