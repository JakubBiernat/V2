import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class FrameA extends JFrame {

    private JLabel labelMain;
    private JPanel panelA;
    private JPanel panelB;
    private JLabel paneleuList;
    private JLabel panelnaList;
    private JList euList;
    private JList naList;

    private JPanel euListPanel;
    private JPanel naListPanel;
    private JTextField area;
    private String s = null;
    private HashMap<String,String> mapa = new HashMap();
    private HashMap<String,String> mapaTurnout = new HashMap();

    private ArrayList<Steel> steellist;
    private JTextArea result;

    FrameA(ArrayList<Steel> steellist){
        this.steellist=steellist;
         doIt();}

    public void doIt() {
        this.setTitle("Material Equivalent:");

        // text area to type material
        area = new JTextField((10));
        area.addActionListener(new AreaActionListener());

        //Top label
        labelMain = new JLabel("Please type material or select from one of the list below:");

        panelA = new JPanel();
        panelB = new JPanel();
        result = new JTextArea();
        result.setSize(800,400);


        // Panel wit EU material list with description
        euListPanel = new JPanel();
        euListPanel.setLayout(new BoxLayout(euListPanel,BoxLayout.Y_AXIS));
        JLabel euListLabel = new JLabel("EU materials:");
        euListPanel.add(euListLabel);

        //Panel with NA material list with description
        naListPanel = new JPanel();
        naListPanel.setLayout(new BoxLayout(naListPanel,BoxLayout.Y_AXIS));
        JLabel naListLabel = new JLabel("American materials:");
        naListPanel.add(naListLabel);


        JPanel MainContent = new JPanel();

        createList();

        MainContent.add(euListPanel);
        MainContent.add(naListPanel);

        panelB.add(labelMain);
        panelB.add(area);;
        panelA.add(result);


        this.getContentPane().add(BorderLayout.NORTH,panelB);
        this.getContentPane().add(BorderLayout.SOUTH,panelA);
        this.getContentPane().add(BorderLayout.CENTER,MainContent);


        this.setSize(800,450);
        this.setVisible(true);
        this.setResizable(false);



    }

    public void createList(){


        for (Steel e:steellist) {
            mapa.put(e.geteuName(),e.getaName());
            mapaTurnout.put(e.getaName(),e.geteuName());
            showinfo(e);
        }

        euList = new JList(mapa.keySet().toArray(new String[mapa.size()]));
        naList = new JList(mapa.values().toArray(new String[mapa.size()]));

        euList.setFixedCellWidth(200);
        naList.setFixedCellWidth(200);
        euList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        naList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        euList.addListSelectionListener(new euListListener());
        naList.addListSelectionListener(new naListListener());

        JScrollPane moveeuList = new JScrollPane(euList);
        moveeuList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        moveeuList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollPane movenaList = new JScrollPane(naList);
        movenaList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        movenaList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        euListPanel.add(moveeuList);
        naListPanel.add(movenaList);

    }

    String showinfo(Steel steel){


        StringBuilder sb = new StringBuilder();
        sb.append("Material equivalent for "+s+ " is " +mapa.get(s)+ "\n"+"\n");
        sb.append("Details:"+"\n");
        sb.append(steel.getDescription()+"\n"+"\n");
        sb.append("Steel name according to EU norm " + steel.geteuName() + "\n");
        sb.append("Steel name according to NA norm " + steel.getaName() + "\n");
        sb.append("Steel name according to PL norm " + steel.getplName() + "\n");
        sb.append("Steel name according to DIN norm " + steel.getdinName() + "\n");
        return (sb.toString());

    }

    class AreaActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            s= area.getText();
            check();
        }
    }

    class euListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!e.getValueIsAdjusting()) {
                s= (String)euList.getSelectedValue();
                check();
            }
        }
    }

    class naListListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!e.getValueIsAdjusting()) {
                s= (String)naList.getSelectedValue();
                check();
            }
        }
    }

    private void check(){
        result.setText(null);
        if(mapa.containsKey(s)){

            for (Steel o: steellist){
                if(s == o.geteuName()){
                    System.out.println(showinfo(o));
                    result.replaceSelection(showinfo(o));
                }
            }
        }

        if(mapaTurnout.containsKey(s)){
            for (Steel o: steellist){
                if(s == o.getaName()) {
                    System.out.println(showinfo(o));
                    result.replaceSelection(showinfo(o));
                }
                }
        }

        panelA.repaint();
        panelB.repaint();

    }
}
