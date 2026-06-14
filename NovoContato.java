import javax.swing.*;
import java.awt.*;

public class NovoContato extends JFrame {
    public NovoContato() {
        setTitle("Novo Contato"); // título da janela
        setSize(300, 500); // largura e altura
        setLocationRelativeTo(null); // centraliza na tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa janela
        setResizable(false); // não é redimensionável
        setLayout(new BorderLayout()); // layout principal

        // Painel principal
        JPanel painelContato = new JPanel(new BorderLayout());

        // Botão voltar
        JButton voltar = new JButton("voltar");
        voltar.setPreferredSize(new Dimension(80, 30));
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelTopo.add(voltar);
        painelContato.add(painelTopo, BorderLayout.NORTH);

        // Ação do botão voltar volta para o Historico
        voltar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                Historico historico = new Historico();
                historico.setVisible(true);
            });
            dispose();
        });

        // Painel do formulário do contato
        JPanel panel_do_contato = new JPanel();
        panel_do_contato.setLayout(new BoxLayout(panel_do_contato, BoxLayout.Y_AXIS));
        panel_do_contato.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Campo Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField campoNome = new JTextField();
        campoNome.setMaximumSize(new Dimension(260, 30));
        campoNome.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(4, 6, 4, 6)
        ));
        panel_do_contato.add(lblNome);
        panel_do_contato.add(Box.createVerticalStrut(3));
        panel_do_contato.add(campoNome);
        panel_do_contato.add(Box.createVerticalStrut(10));

        // Campo Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField campoTelefone = new JTextField();
        campoTelefone.setMaximumSize(new Dimension(260, 30));
        campoTelefone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(4, 6, 4, 6)
        ));
        panel_do_contato.add(lblTelefone);
        panel_do_contato.add(Box.createVerticalStrut(3));
        panel_do_contato.add(campoTelefone);
        panel_do_contato.add(Box.createVerticalStrut(10));

        // Campo Observações
        JLabel lblObs = new JLabel("Observações:");
        lblObs.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea campoObs = new JTextArea();
        campoObs.setLineWrap(true);
        campoObs.setWrapStyleWord(true);
        campoObs.setMaximumSize(new Dimension(260, Integer.MAX_VALUE));
        campoObs.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        JScrollPane scrollObs = new JScrollPane(campoObs);
        scrollObs.setMaximumSize(new Dimension(260, Integer.MAX_VALUE));
        scrollObs.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel_do_contato.add(lblObs);
        panel_do_contato.add(Box.createVerticalStrut(3));
        panel_do_contato.add(scrollObs);
        panel_do_contato.add(Box.createVerticalStrut(10));

        // Scroll geral do formulário
        JScrollPane scroll = new JScrollPane(panel_do_contato);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        painelContato.add(scroll, BorderLayout.CENTER);

        add(painelContato, BorderLayout.CENTER);

        // Rodapé com botões de ação
        JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelRodape.setPreferredSize(new Dimension(300, 60));

        JButton btnCancelar = new JButton("cancelar");
        btnCancelar.setPreferredSize(new Dimension(100, 35));

        JButton btnSalvar = new JButton("salvar");
        btnSalvar.setPreferredSize(new Dimension(100, 35));

        // Ação do botão Cancelar
        btnCancelar.addActionListener(e -> {
            dispose();
        });

        // Ação do botão Salvar
        btnSalvar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            String telefone = campoTelefone.getText().trim();

            // Validação
            if (nome.isEmpty() || telefone.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Nome e telefone são obrigatórios!",
                        "Campos vazios",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Contato " + nome + " salvo com sucesso",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        painelRodape.add(btnCancelar);
        painelRodape.add(btnSalvar);
        add(painelRodape, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new NovoContato();
    }
}