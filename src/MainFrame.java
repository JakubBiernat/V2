import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JButton materialSearchButton, gdtInstructionButton, overlapCalcButton;

    MainFrame() {
        createFrame();
    }

    private void createFrame() {
        createButtons();
        JPanel mainPanel =createPanels();
        this.setTitle("Useful tool");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1050,500);
        this.setVisible(true);
        this.getContentPane().add(BorderLayout.CENTER, mainPanel);
        this.setBackground(new Color(150,150,150));
        this.setResizable(false);
    }

    private void createButtons() {
        //Some pictures for buttons
        ImageIcon metalIcon = new ImageIcon("austenit.png");
        ImageIcon partIcon = new ImageIcon("partsicon.png");
        ImageIcon calcIcon = new ImageIcon("calcicon.png");

        //Steel choice button
        materialSearchButton = new JButton();
        materialSearchButton.setText("Metal equivalent");
        materialSearchButton.setIcon(metalIcon);
        materialSearchButton.setBounds(100, 10, 200, 250);
        materialSearchButton.addActionListener(
                (e)->{new MaterialEquivalentFrame();
                      System.out.println("button "+ materialSearchButton.getText()+" selected");} );
        materialSearchButton.setFocusable(false);
        materialSearchButton.setHorizontalTextPosition(JButton.CENTER);
        materialSearchButton.setVerticalTextPosition(JButton.BOTTOM);
        materialSearchButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        materialSearchButton.setIconTextGap(20);
        materialSearchButton.setBackground(Color.lightGray);
        materialSearchButton.setBorder(BorderFactory.createEtchedBorder());

        //GD&T button
        gdtInstructionButton = new JButton();
        gdtInstructionButton.setText("GD&T- GRD norm");
        gdtInstructionButton.setIcon(partIcon);
        gdtInstructionButton.setBounds(400, 10, 200, 250);
        gdtInstructionButton.addActionListener((e)-> System.out.println("button"+ gdtInstructionButton.getName()+"selected"));
        gdtInstructionButton.setFocusable(false);
        gdtInstructionButton.setHorizontalTextPosition(JButton.CENTER);
        gdtInstructionButton.setVerticalTextPosition(JButton.BOTTOM);
        gdtInstructionButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        gdtInstructionButton.setIconTextGap(20);
        gdtInstructionButton.setBackground(Color.lightGray);
        gdtInstructionButton.setBorder(BorderFactory.createEtchedBorder());
        gdtInstructionButton.setEnabled(false); /* to be defined later*/

        // Overlapping calculator button
        overlapCalcButton = new JButton();
        overlapCalcButton.setText("HS overlapping calculator");
        overlapCalcButton.setIcon(calcIcon);
        overlapCalcButton.setBounds(700, 10, 200, 250);
        overlapCalcButton.addActionListener((e)-> System.out.println("button"+ overlapCalcButton.getName()+"selected"));
        overlapCalcButton.setFocusable(false);
        overlapCalcButton.setHorizontalTextPosition(JButton.CENTER);
        overlapCalcButton.setVerticalTextPosition(JButton.BOTTOM);
        overlapCalcButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        overlapCalcButton.setIconTextGap(20);
        overlapCalcButton.setBackground(Color.lightGray);
        overlapCalcButton.setBorder(BorderFactory.createEtchedBorder());
        overlapCalcButton.setEnabled(false);/*to be defined later*/
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
     }
    */

    private JPanel createPanels(){

        JPanel panelInner =new JPanel();
        JPanel panelInnerHeadline =new JPanel();
        panelInnerHeadline.setBackground(Color.gray);

        JLabel headline = new JLabel();
        headline.setText("Please select button:");
        headline.setFont(new Font("Comic Sans",Font.BOLD,20));
        headline.setBounds(100,30,800,60);
        headline.setHorizontalTextPosition(JLabel.CENTER);

        panelInnerHeadline.setLayout(null);
        panelInnerHeadline.add(headline);
        panelInnerHeadline.setPreferredSize(new Dimension(500,10));

        panelInner.setLayout(null);
        panelInner.add(materialSearchButton);
        panelInner.add(gdtInstructionButton);
        panelInner.add(overlapCalcButton);
        panelInner.setPreferredSize(new Dimension(500,280));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        mainPanel.add(panelInnerHeadline);
        mainPanel.add(panelInner);

        return mainPanel;
    }
}
