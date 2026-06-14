import javax.swing.*;
import java.awt.*;

public class RascunhoEmail extends JFrame {
    public RascunhoEmail() {
        setTitle("Novo Rascunho"); // título da janela
        setSize(300, 500); // largura e altura
        setLocationRelativeTo(null); // centraliza na tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa janela, não o programa todo
        setResizable(false); // não é redimensionável
        setLayout(new BorderLayout()); // layout principal

        // Painel principal
        JPanel painelRascunho = new JPanel(new BorderLayout());

        // Botão voltar
        JButton voltar = new JButton("voltar");
        voltar.setPreferredSize(new Dimension(80, 30));
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelTopo.add(voltar);
        painelRascunho.add(painelTopo, BorderLayout.NORTH);

        // Ação do botão voltar volta para o Historico
        voltar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                Historico historico = new Historico();
                historico.setVisible(true);
            });
            dispose();
        });

        // Painel do formulário do email 
        JPanel panel_do_email = new JPanel();
        panel_do_email.setLayout(new BoxLayout(panel_do_email, BoxLayout.Y_AXIS));
        panel_do_email.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Campo Para
        JLabel lblPara = new JLabel("Para:");
        lblPara.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField campoPara = new JTextField();
        campoPara.setMaximumSize(new Dimension(260, 30));
        campoPara.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(4, 6, 4, 6)
        ));
        panel_do_email.add(lblPara);
        panel_do_email.add(Box.createVerticalStrut(3));
        panel_do_email.add(campoPara);
        panel_do_email.add(Box.createVerticalStrut(10));

        // Campo Assunto
        JLabel lblAssunto = new JLabel("Assunto:");
        lblAssunto.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField campoAssunto = new JTextField();
        campoAssunto.setMaximumSize(new Dimension(260, 30));
        campoAssunto.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(4, 6, 4, 6)
        ));
        panel_do_email.add(lblAssunto);
        panel_do_email.add(Box.createVerticalStrut(3));
        panel_do_email.add(campoAssunto);
        panel_do_email.add(Box.createVerticalStrut(10));

        // Corpo do email (JTextArea editável, diferente do EmailRecebido)
        JLabel lblCorpo = new JLabel("Mensagem:");
        lblCorpo.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea corpoEmail = new JTextArea();
        corpoEmail.setLineWrap(true);
        corpoEmail.setWrapStyleWord(true);
        corpoEmail.setMaximumSize(new Dimension(260, Integer.MAX_VALUE));
        corpoEmail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        JScrollPane scrollCorpo = new JScrollPane(corpoEmail);
        scrollCorpo.setMaximumSize(new Dimension(260, Integer.MAX_VALUE));
        scrollCorpo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel_do_email.add(lblCorpo);
        panel_do_email.add(Box.createVerticalStrut(3));
        panel_do_email.add(scrollCorpo);

        // Scroll geral do formulário
        JScrollPane scroll = new JScrollPane(panel_do_email);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        painelRascunho.add(scroll, BorderLayout.CENTER);

        add(painelRascunho, BorderLayout.CENTER);

        // Rodapé com botões de ação (Salvar rascunho e Enviar)
        JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelRodape.setPreferredSize(new Dimension(300, 60));

        JButton btnSalvar = new JButton("salvar rascunho");
        btnSalvar.setPreferredSize(new Dimension(120, 35));

        JButton btnEnviar = new JButton("enviar");
        btnEnviar.setPreferredSize(new Dimension(100, 35));

        // Ação do botão Enviar
        btnEnviar.addActionListener(e -> {
            String para = campoPara.getText().trim();
            String assunto = campoAssunto.getText().trim();
            String mensagem = corpoEmail.getText().trim();

            // Validação 
            if (para.isEmpty() || assunto.isEmpty() || mensagem.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Preencha todos os campos antes de enviar!",
                        "Campos vazios",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Email enviado para " + para + "!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        // Ação do botão Salvar rascunho
        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Rascunho salvo com sucesso!",
                    "Salvo",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        painelRodape.add(btnSalvar);
        painelRodape.add(btnEnviar);
        add(painelRodape, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RascunhoEmail();
    }
}