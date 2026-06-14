import javax.swing.*; // Importa componentes gráficos do Swing
import java.awt.*; // Importa classes de interface gráfica (cores, fontes, dimensões)
import java.awt.event.*; // Importa eventos e ouvintes de eventos

public class Cadastro { // Classe principal do programa

    public static void main(String[] args) { // Método principal que inicia o programa

        JFrame janela = new JFrame("Criar Conta"); // Cria a janela com o título "Criar Conta"
        janela.setSize(500, 750); // Define largura e altura da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel painel = new JPanel(); // Cria um painel para organizar os componentes
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // Organiza componentes na vertical
        painel.setBackground(Color.BLACK); // Define fundo preto

        JLabel titulo = new JLabel("Criar Conta"); // Cria o título
        titulo.setFont(new Font("Arial", Font.BOLD, 36)); // Define fonte e tamanho
        titulo.setForeground(Color.WHITE); // Define cor branca
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o componente

        JLabel emailLabel = new JLabel("Digite o email"); // Texto do campo email
        emailLabel.setForeground(Color.WHITE); // Cor branca
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Fonte do texto
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza

        JTextField emailCampo = new JTextField(); // Campo para digitar email
        emailCampo.setMaximumSize(new Dimension(350, 35)); // Tamanho máximo do campo

        JLabel telefoneLabel = new JLabel("Digite o telefone"); // Texto do campo telefone
        telefoneLabel.setForeground(Color.WHITE); // Cor branca
        telefoneLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Fonte
        telefoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza

        JTextField telefoneCampo = new JTextField(); // Campo para telefone
        telefoneCampo.setMaximumSize(new Dimension(350, 35)); // Define tamanho

        JLabel nomeLabel = new JLabel("Digite o nome"); // Texto do campo nome
        nomeLabel.setForeground(Color.WHITE); // Cor branca
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Fonte
        nomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza

        JTextField nomeCampo = new JTextField(); // Campo para nome
        nomeCampo.setMaximumSize(new Dimension(350, 35)); // Define tamanho

        JLabel senhaLabel = new JLabel("Digite uma senha"); // Texto do campo senha
        senhaLabel.setForeground(Color.WHITE); // Cor branca
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Fonte
        senhaLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza

        JPasswordField senhaCampo = new JPasswordField(); // Campo de senha oculto
        senhaCampo.setMaximumSize(new Dimension(350, 35)); // Define tamanho

        JLabel contatoLabel = new JLabel("Contato"); // Texto da seção contato
        contatoLabel.setForeground(Color.WHITE); // Cor branca
        contatoLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Fonte
        contatoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza

        JToggleButton tipoContato = new JToggleButton("Pessoal"); // Botão alternável
        tipoContato.setMaximumSize(new Dimension(180, 40)); // Tamanho máximo
        tipoContato.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza

        tipoContato.addActionListener(new ActionListener() { // Adiciona ação ao botão
            @Override
            public void actionPerformed(ActionEvent e) { // Executa ao clicar

                if (tipoContato.isSelected()) { // Verifica se está selecionado
                    tipoContato.setText("Profissional"); // Troca texto para Profissional
                } else {
                    tipoContato.setText("Pessoal"); // Volta para Pessoal
                }
            }
        });

        JLabel permitirLabel = new JLabel("Permitir:"); // Título dos checkboxes
        permitirLabel.setForeground(Color.WHITE); // Cor branca
        permitirLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Fonte
        permitirLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza

        JCheckBox ligacao = new JCheckBox("Ligação"); // Caixa de seleção Ligação
        JCheckBox mensagem = new JCheckBox("Mensagem"); // Caixa de seleção Mensagem
        JCheckBox emailCheck = new JCheckBox("Email"); // Caixa de seleção Email

        ligacao.setBackground(Color.BLACK); // Fundo preto
        mensagem.setBackground(Color.BLACK);
        emailCheck.setBackground(Color.BLACK);

        ligacao.setForeground(Color.WHITE); // Texto branco
        mensagem.setForeground(Color.WHITE);
        emailCheck.setForeground(Color.WHITE);

        JButton criarConta = new JButton("Criar Conta"); // Cria botão
        criarConta.setFont(new Font("Arial", Font.BOLD, 18)); // Define fonte
        criarConta.setPreferredSize(new Dimension(200, 45)); // Define tamanho

        JPanel painelBotao = new JPanel(); // Painel para o botão
        painelBotao.setBackground(Color.BLACK); // Fundo preto
        painelBotao.add(criarConta); // Adiciona botão ao painel

        criarConta.addActionListener(new ActionListener() { // Evento do botão
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailCampo.getText().trim(); // Obtém email digitado
                String telefone = telefoneCampo.getText().trim(); // Obtém telefone
                String nome = nomeCampo.getText().trim(); // Obtém nome
                String senha = new String(senhaCampo.getPassword()).trim(); // Obtém senha

                if (email.isEmpty() && telefone.isEmpty()) { // Verifica email e telefone
                    JOptionPane.showMessageDialog(
                            janela,
                            "Preencha Email ou Telefone."); // Exibe mensagem
                    return; // Interrompe execução
                }

                if (nome.isEmpty()) { // Verifica nome
                    JOptionPane.showMessageDialog(
                            janela,
                            "O nome é obrigatório.");
                    return;
                }

                if (senha.isEmpty()) { // Verifica senha
                    JOptionPane.showMessageDialog(
                            janela,
                            "A senha é obrigatória.");
                    return;
                }

                if (!ligacao.isSelected()
                        && !mensagem.isSelected()
                        && !emailCheck.isSelected()) { // Verifica se marcou algum checkbox

                    JOptionPane.showMessageDialog(
                            janela,
                            "Selecione pelo menos uma forma de contato.");
                    return;
                }

                if (email.equalsIgnoreCase("admin@gmail.com")
                        || telefone.equals("999991120")) { // Simula cadastro existente

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

        painel.add(Box.createVerticalStrut(30)); // Espaço vertical de 30 pixels
        painel.add(titulo); // Adiciona título
        painel.add(emailLabel); // Adiciona texto email
        painel.add(emailCampo); // Adiciona campo email
        painel.add(telefoneLabel); // Adiciona texto telefone
        painel.add(telefoneCampo); // Adiciona campo telefone
        painel.add(nomeLabel); // Adiciona texto nome
        painel.add(nomeCampo); // Adiciona campo nome
        painel.add(senhaLabel); // Adiciona texto senha
        painel.add(senhaCampo); // Adiciona campo senha
        painel.add(contatoLabel); // Adiciona seção contato
        painel.add(tipoContato); // Adiciona botão alternável
        painel.add(permitirLabel); // Adiciona título dos checkboxes
        painel.add(ligacao); // Adiciona checkbox ligação
        painel.add(mensagem); // Adiciona checkbox mensagem
        painel.add(emailCheck); // Adiciona checkbox email
        painel.add(painelBotao); // Adiciona painel do botão

        janela.add(painel); // Adiciona painel à janela
        janela.setVisible(true); // Torna a janela visível
    }
}
