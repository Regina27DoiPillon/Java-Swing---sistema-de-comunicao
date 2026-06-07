import javax.swing.*;
import java.awt.*;

public class EmailRecebido extends JFrame {

    public EmailRecebido() {
        setTitle("Email Recebido");
        setSize(300, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel painelEmail =new JPanel(new BorderLayout());

        // Botão voltar
        JButton voltar=new JButton("voltar");
        voltar.setPreferredSize(new Dimension(80, 30));
        JPanel painelTopo=new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelTopo.add(voltar);
        painelEmail.add(painelTopo, BorderLayout.NORTH); // botão de volta adicionado em cima de tudo

        // 
        JPanel panel_do_email = new JPanel();
        panel_do_email.setLayout(new BoxLayout(panel_do_email, BoxLayout.Y_AXIS));

        //  
        JTextArea email_enviado = new JTextArea();
        email_enviado.setText("Donec sagittis, nibh sed egestas placerat, sem mi fermentum neque, sit amet ornare tortor orci ac erat. Sed justo elit, aliquet ac ultricies non, volutpat non lectus. Donec convallis eget turpis tristique volutpat. Nam vehicula aliquet leo, at mollis est. Pellentesque a convallis nibh, eu ullamcorper enim. Pellentesque vestibulum ligula eu ipsum bibendum, id tincidunt felis congue. In semper luctus euismod. Cras iaculis nulla non accumsan ullamcorper. \n\nQuisque rutrum, dolor et congue ultricies, nulla orci vulputate mi, eget rutrum quam nibh ut massa. Aliquam convallis semper neque. In vehicula arcu sed sapien fermentum, vel fermentum odio viverra. In nec nisl libero. Etiam sit amet tincidunt libero, quis finibus mi. Fusce iaculis vel felis eget feugiat. Morbi quis feugiat justo, quis porttitor lectus. In aliquet pellentesque diam a ornare. Morbi lacinia nulla sit amet convallis blandit. In varius sed enim in sodales. Ut varius erat eu fermentum congue. Nullam lobortis dolor at placerat dictum. Quisque felis metus, pharetra id sollicitudin in, molestie vel dolor. Donec venenatis consequat ornare. Mauris imperdiet fringilla metus eu accumsan.");
        email_enviado.setEditable(false);
        email_enviado.setLineWrap(true);
        email_enviado.setWrapStyleWord(true);
        email_enviado.setMaximumSize(new Dimension(260, Integer.MAX_VALUE));
        email_enviado.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        panel_do_email.add(email_enviado); // 



        // ScrollPane do histórico
        JScrollPane scroll =new JScrollPane(panel_do_email);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        painelEmail.add(scroll, BorderLayout.CENTER);

        add(painelEmail, BorderLayout.CENTER);






        // campo de resposta + botão enviar
        JPanel painelRodapeEmail =new JPanel(new BorderLayout());
        painelRodapeEmail.setPreferredSize(new Dimension(300, 60));


        JTextArea escreverMensg = new JTextArea();
        escreverMensg.setText("Responder...");
        escreverMensg.setLineWrap(true);
        escreverMensg.setWrapStyleWord(true);
        JScrollPane scrollDigitar = new JScrollPane(escreverMensg);
        scrollDigitar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton enviarMesg = new JButton(">");
        enviarMesg.setPreferredSize(new Dimension(60, 60));

        painelRodapeEmail.add(scrollDigitar, BorderLayout.CENTER);
        painelRodapeEmail.add(enviarMesg, BorderLayout.EAST);
        add(painelRodapeEmail, BorderLayout.SOUTH);
        //
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmailRecebido(); // 
    }
}