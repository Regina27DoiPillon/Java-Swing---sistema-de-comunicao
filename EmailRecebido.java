import javax.swing.*;
import java.awt.*;

public class EmailRecebido extends JFrame { //criou a classe JFrame
    public EmailRecebido() {  //abre um comando. Tipo uma função
        setTitle("Email Recebido"); //define o título do JFrame
        setSize(300, 500); //define a largura e altura do JFrame
        setLocationRelativeTo(null); // coloca o JFrame no centro do espaço disponível
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quando o JFrame for fechado, ele para de rodar
        setResizable(false); // não é redimensionável
        setLayout(new BorderLayout()); // define o layout dele como 

        // Painel principal
        JPanel painelEmail =new JPanel(new BorderLayout()); // cria uma 'div'

        // Botão voltar
        JButton voltar=new JButton("voltar"); //cria o botão de voltar
        voltar.setPreferredSize(new Dimension(80, 30)); //tamanho do botão
        JPanel painelTopo=new JPanel(new FlowLayout(FlowLayout.LEFT)); //cria uma 'div'
        painelTopo.add(voltar); //adiciona o botão na div
        painelEmail.add(painelTopo, BorderLayout.NORTH); // botão de voltar adicionado em cima de tudo da div principal

        // 
        JPanel panel_do_email = new JPanel(); //cria uma nova div. Ela é para os emails
        panel_do_email.setLayout(new BoxLayout(panel_do_email, BoxLayout.Y_AXIS)); //define o layout do jpnale como boxlayout, organizado na linha vertical

        //  
        JTextArea email_enviado = new JTextArea(); //cria a mensagem do email
        email_enviado.setText("Donec sagittis, nibh sed egestas placerat, sem mi fermentum neque, sit amet ornare tortor orci ac erat. Sed justo elit, aliquet ac ultricies non, volutpat non lectus. Donec convallis eget turpis tristique volutpat. Nam vehicula aliquet leo, at mollis est. Pellentesque a convallis nibh, eu ullamcorper enim. Pellentesque vestibulum ligula eu ipsum bibendum, id tincidunt felis congue. In semper luctus euismod. Cras iaculis nulla non accumsan ullamcorper. \n\nQuisque rutrum, dolor et congue ultricies, nulla orci vulputate mi, eget rutrum quam nibh ut massa. Aliquam convallis semper neque. In vehicula arcu sed sapien fermentum, vel fermentum odio viverra. In nec nisl libero. Etiam sit amet tincidunt libero, quis finibus mi. Fusce iaculis vel felis eget feugiat. Morbi quis feugiat justo, quis porttitor lectus. In aliquet pellentesque diam a ornare. Morbi lacinia nulla sit amet convallis blandit. In varius sed enim in sodales. Ut varius erat eu fermentum congue. Nullam lobortis dolor at placerat dictum. Quisque felis metus, pharetra id sollicitudin in, molestie vel dolor. Donec venenatis consequat ornare. Mauris imperdiet fringilla metus eu accumsan.");
        email_enviado.setEditable(false); //não é editável o JTextArea
        email_enviado.setLineWrap(true); // quebra o texto ao chegar na borda
        email_enviado.setWrapStyleWord(true); // o caracter não é quebrado. Quem quebra é a palavra
        email_enviado.setMaximumSize(new Dimension(260, Integer.MAX_VALUE)); // define uma largura fixa para não extrapolar o tamanho. A altura pode ser bemmmmmm grande
        email_enviado.setBorder( // cria e define as características da borda dessa mensagem
            BorderFactory.createCompoundBorder( // "define" uma borda
                BorderFactory.createLineBorder(Color.GRAY, 1), // cria a linha
                BorderFactory.createEmptyBorder(6, 8, 6, 8) // dá um padding dentro da borda
        ));
        panel_do_email.add(email_enviado); // coloca o email recebido no paneldoemail



        // ScrollPane do histórico
        JScrollPane scroll =new JScrollPane(panel_do_email); //coloca o panel do email num scroll para q todo o conteúdo seja acessado
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // define como scroll para baixo
        painelEmail.add(scroll, BorderLayout.CENTER); // adiciona o scroll no painel

        add(painelEmail, BorderLayout.CENTER); //adiciona o panel no JFrame






        // campo de resposta + botão enviar
        JPanel painelRodapeEmail =new JPanel(new BorderLayout()); //cria uma div
        painelRodapeEmail.setPreferredSize(new Dimension(300, 60)); //define o tamanho


        JTextArea escreverMensg = new JTextArea(); //cria um jtext a
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