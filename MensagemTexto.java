import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MensagemTexto extends JFrame {

    public MensagemTexto() {
        setTitle("Mensagem");
        setSize(300, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout()); 

        // painel principal
        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(new BorderLayout());

        //  voltar
        JButton voltar = new JButton("voltar");
        voltar.setPreferredSize(new Dimension(80, 30));

        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelTopo.add(voltar);
        painelLogin.add(painelTopo, BorderLayout.NORTH);

        // histórico - 
        JPanel panel_do_historico = new JPanel();
        panel_do_historico.setLayout(new BoxLayout(panel_do_historico, BoxLayout.Y_AXIS)); //cria já o BoxLayout e empilha verticalmente

        // lista de mensagens pré-definidas
        List<String> historicoMensg = new ArrayList<>();
        historicoMensg.add("Vestibulum tempus sagittis nibh et mattis. Mauris et quam non nunc tincidunt porta. Pellentesque mattis aliquet ante. Pellentesque in arcu vitae metus venenatis mattis sed ut ligula. ");
        historicoMensg.add("Tudo sim! E você?");
        historicoMensg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor, lorem sed convallis scelerisque, turpis arcu tempus lectus, vel vehicula dolor quam quis quam. Vestibulum quis egestas purus, sit amet suscipit urna. Ut condimentum, ante et dapibus pellentesque, dui magna dictum lorem, sollicitudin accumsan diam erat et ante. Pellentesque gravida vestibulum sem. Nam nibh orci, porta eu ligula sed, rutrum suscipit dui.");
        historicoMensg.add("Entendido, obrigado!");

        for (String mensagem : historicoMensg) {
            JTextArea mensagem_hist = new JTextArea(mensagem);
            mensagem_hist.setEditable(false);
            mensagem_hist.setLineWrap(true);
            mensagem_hist.setWrapStyleWord(true); // a palavra quebra inteira, e não pela metade
            mensagem_hist.setMaximumSize(new Dimension(260, Integer.MAX_VALUE)); //largura máxima de 260px. A altura é livre.
            mensagem_hist.setBorder(BorderFactory.createCompoundBorder( //atribui bordas
                BorderFactory.createLineBorder(Color.GRAY, 1), //cria borda pro jtextarea
                BorderFactory.createEmptyBorder(6, 8, 6, 8) //padding
            ));
            panel_do_historico.add(mensagem_hist);
            panel_do_historico.add(Box.createRigidArea(new Dimension(0, 8))); //dá um espaço entre as mensagens. Não fica tudo grudado.
        }
        JPanel painelRodapeMsg = new JPanel(new BorderLayout());
        painelRodapeMsg.setPreferredSize(new Dimension(300, 50));

        JTextArea escreverMensg = new JTextArea();
        escreverMensg.setText("Escreva...");
        escreverMensg.setLineWrap(true);
        escreverMensg.setWrapStyleWord(true);
        JScrollPane scrolldigitarmensagem = new JScrollPane(escreverMensg);
        

        JButton enviarMesg = new JButton(">");
        enviarMesg.setPreferredSize(new Dimension(60, 30));

        voltar.addActionListener(e -> { // liga a pagina historico
            SwingUtilities.invokeLater(() -> {
                Historico historico = new Historico();
                historico.setVisible(true);
            });
            dispose();
        });

        painelRodapeMsg.add(scrolldigitarmensagem, BorderLayout.CENTER); // ocupa o espaço sobrante
        painelRodapeMsg.add(enviarMesg, BorderLayout.EAST);      // botão "enviar" na esquerda
        add(painelRodapeMsg, BorderLayout.SOUTH); //adiciona caixa de entrada da mensagem e botão de enviar


        // ScrollPane para rolar o histórico
        JScrollPane scroll = new JScrollPane(panel_do_historico);
        painelLogin.add(scroll, BorderLayout.CENTER);

        add(painelLogin, BorderLayout.CENTER); // adiciona tudo de uma vez
        setVisible(true);
    }

    public static void main(String[] args) {
        new MensagemTexto();
    }
}