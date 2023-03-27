import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class FrameA extends JFrame {

    private JList<String> euList;
    private JList<String> naList;

    private JPanel euListPanel;
    private JPanel naListPanel;
    private JTextField area;
    private final HashMap<String,String> mapa = new HashMap<>();

    private final ArrayList<Steel> steellist;
    private JTextArea result;

    FrameA(ArrayList<Steel> steellist){
        this.steellist=steellist;
         doIt();}

    public void doIt() {
        this.setTitle("Material Equivalent:");

        // text area to type material
        area = new JTextField((10));
        area.addActionListener((e)-> check(area.getText()));

        //Top label
        JLabel labelMain = new JLabel("Please type material or select from one of the list below:");

        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();
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
        panelB.add(area);
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
        }

        euList = new JList<>(mapa.keySet().toArray(new String[mapa.size()]));
        naList = new JList<>(mapa.values().toArray(new String[mapa.size()]));

        euList.setFixedCellWidth(200);
        naList.setFixedCellWidth(200);
        euList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        naList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        euList.addListSelectionListener(
                (e) -> {if(!e.getValueIsAdjusting()) {
                        check(euList.getSelectedValue());}
                        });
        naList.addListSelectionListener(
                (e) -> {if(!e.getValueIsAdjusting()) {
                        check(naList.getSelectedValue());}
                        });

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
        sb.append("Material equivalent for ").append(steel.geteuName()).append(" is ").append(steel.getaName()).append("\n").append("\n");
        sb.append("Details:"+"\n");
        sb.append(steel.getDescription()).append("\n").append("\n");
        sb.append("Steel name according to EU norm ").append(steel.geteuName()).append("\n");
        sb.append("Steel name according to NA norm ").append(steel.getaName()).append("\n");
        sb.append("Steel name according to PL norm ").append(steel.getplName()).append("\n");
        sb.append("Steel name according to DIN norm ").append(steel.getdinName()).append("\n");
        return (sb.toString());
    }



    private void check(String s){
        result.setText(null);
        if(mapa.containsKey(s)){
            for (Steel o: steellist){
                if(s.equals(o.geteuName())){
                    System.out.println(showinfo(o));
                    result.append(showinfo(o));
                }
            }
        }
        if(mapa.containsValue(s)){
            for (Steel o: steellist){
                if(s.equals(o.getaName())) {
                    System.out.println(showinfo(o));
                    result.append(showinfo(o));
                }
            }
        }
    }




}
