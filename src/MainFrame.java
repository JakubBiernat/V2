import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JButton button1, button2, button3;
    private JPanel main;


    MainFrame() {
        createButtons();
        createPanels();


        //Frame definition
        this.setTitle("Useful tool");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1050,500);
        this.setVisible(true);
        this.getContentPane().add(BorderLayout.CENTER,main);
        this.setBackground(new Color(150,150,150));
        this.setResizable(false);
    }

    private void createButtons() {


        //Some pictures for buttons
        ImageIcon metalIcon = new ImageIcon("austenit.png");
        ImageIcon partIcon = new ImageIcon("partsicon.png");
        ImageIcon calcIcon = new ImageIcon("calcicon.png");

        //Metal choice button
        button1 = new JButton();
        button1.setText("Metal equivalent");
        button1.setIcon(metalIcon);
        button1.setBounds(100, 10, 200, 250);
        button1.addActionListener(
                (e)->{new MatSearch();
                      System.out.println("button "+button1.getText()+" selected");} );
        button1.setFocusable(false);
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setVerticalTextPosition(JButton.BOTTOM);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button1.setIconTextGap(20);
        button1.setBackground(Color.lightGray);
        button1.setBorder(BorderFactory.createEtchedBorder());


        //GD&T button
        button2 = new JButton();
        button2.setText("GD&T- GRD norm");
        button2.setIcon(partIcon);
        button2.setBounds(400, 10, 200, 250);
        button2.addActionListener((e)-> System.out.println("button"+button2.getName()+"selected"));
        button2.setFocusable(false);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button2.setIconTextGap(20);
        button2.setBackground(Color.lightGray);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setEnabled(false); /* to be defined later*/

        // Overlapping calculator button
        button3 = new JButton();
        button3.setText("HS overlapping calculator");
        button3.setIcon(calcIcon);
        button3.setBounds(700, 10, 200, 250);
        button3.addActionListener((e)-> System.out.println("button"+button3.getName()+"selected"));
        button3.setFocusable(false);
        button3.setHorizontalTextPosition(JButton.CENTER);
        button3.setVerticalTextPosition(JButton.BOTTOM);
        button3.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button3.setIconTextGap(20);
        button3.setBackground(Color.lightGray);
        button3.setBorder(BorderFactory.createEtchedBorder());
        button3.setEnabled(false);/*to be defined later*/
    }

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            new MatSearch();
            System.out.println("button "+button1.getText()+" selected");
        }
        if(e.getSource()==button2){
            System.out.println("button"+button2.getName()+"selected");
        }

        if(e.getSource()==button3){
            System.out.println("button"+button3.getName()+"selected");
        }
    }*/

    private void createPanels(){

        JPanel panelA =new JPanel();
        JPanel panelUpper =new JPanel();
        panelUpper.setBackground(Color.gray);

        JLabel head = new JLabel();
        head.setText("Please select button:");
        head.setFont(new Font("Comic Sans",Font.BOLD,20));
        head.setBounds(100,30,800,60);
        head.setHorizontalTextPosition(JLabel.CENTER);

        panelUpper.setLayout(null);
        panelUpper.add(head);
        panelUpper.setPreferredSize(new Dimension(500,10));

        panelA.setLayout(null);
        panelA.add(button1);
        panelA.add(button2);
        panelA.add(button3);
        panelA.setPreferredSize(new Dimension(500,280));

        main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));

        main.add(panelUpper);
       // main.add(head);
        main.add(panelA);

    }
}
