import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MaterialEquivalentFrame extends JFrame {

    private JList<String> euMaterialList;
    private JList<String> naMaterialList;

    private JPanel euMaterialListPanel;
    private JPanel naMaterialListPanel;
    private JTextField manualMaterialInputArea;
    private final HashMap<String,String> mapa = new HashMap<>();

    private ArrayList<Steel> steellist;
    private JTextArea result;

    MaterialEquivalentFrame(){;
         steellist = new MaterialDataFromFileReader().dataReader();
         createFrame();

    }

    public void createFrame() {
        this.setTitle("Material Equivalent:");
        manualMaterialInputArea = new JTextField((10));
        manualMaterialInputArea.addActionListener((e)-> checkEquivalent(manualMaterialInputArea.getText()));

        JLabel labelMainDescription = new JLabel("Please type material or select from one of the list below:");

        JPanel displayResultPanel = new JPanel();
        JPanel manualInputAndHeadlinePanel = new JPanel();
        result = new JTextArea();
        result.setSize(800,400);



        // Panel wit EU material list with description
        euMaterialListPanel = new JPanel();
        euMaterialListPanel.setLayout(new BoxLayout(euMaterialListPanel,BoxLayout.Y_AXIS));
        JLabel euListLabel = new JLabel("EU materials:");
        euMaterialListPanel.add(euListLabel);

        //Panel with NA material list with description
        naMaterialListPanel = new JPanel();
        naMaterialListPanel.setLayout(new BoxLayout(naMaterialListPanel,BoxLayout.Y_AXIS));
        JLabel naListLabel = new JLabel("American materials:");
        naMaterialListPanel.add(naListLabel);


        JPanel euAndNaMaterialListPanel = new JPanel();

        createUeAndNAMaterialList();

        euAndNaMaterialListPanel.add(euMaterialListPanel);
        euAndNaMaterialListPanel.add(naMaterialListPanel);

        manualInputAndHeadlinePanel.add(labelMainDescription);
        manualInputAndHeadlinePanel.add(manualMaterialInputArea);
        displayResultPanel.add(result);


        this.getContentPane().add(BorderLayout.NORTH,manualInputAndHeadlinePanel);
        this.getContentPane().add(BorderLayout.CENTER,euAndNaMaterialListPanel);
        this.getContentPane().add(BorderLayout.SOUTH,displayResultPanel);



        this.setSize(800,450);
        this.setVisible(true);
        this.setResizable(false);



    }

    public void createUeAndNAMaterialList(){

        for (Steel e:steellist) {
            mapa.put(e.geteuName(),e.getaName());
        }

        euMaterialList = new JList<>(mapa.keySet().toArray(new String[mapa.size()]));
        naMaterialList = new JList<>(mapa.values().toArray(new String[mapa.size()]));

        euMaterialList.setFixedCellWidth(200);
        naMaterialList.setFixedCellWidth(200);
        euMaterialList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        naMaterialList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        euMaterialList.addListSelectionListener(
                (e) -> {if(!e.getValueIsAdjusting()) {
                        checkEquivalent(euMaterialList.getSelectedValue());}
                        });
        naMaterialList.addListSelectionListener(
                (e) -> {if(!e.getValueIsAdjusting()) {
                        checkEquivalent(naMaterialList.getSelectedValue());}
                        });

        JScrollPane euMaterialListScrollPane = new JScrollPane(euMaterialList);
        euMaterialListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        euMaterialListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollPane naMaterialListScrollPane = new JScrollPane(naMaterialList);
        naMaterialListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        naMaterialListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        euMaterialListPanel.add(euMaterialListScrollPane);
        naMaterialListPanel.add(naMaterialListScrollPane);

    }

    String showSteelDetails(Steel steel){
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



    private void checkEquivalent(String s){
        result.setText(null);
        if(mapa.containsKey(s)){
            for (Steel o: steellist){
                if(s.equals(o.geteuName())){
                    System.out.println(showSteelDetails(o));
                    result.append(showSteelDetails(o));
                }
            }
        }
        if(mapa.containsValue(s)){
            for (Steel o: steellist){
                if(s.equals(o.getaName())) {
                    System.out.println(showSteelDetails(o));
                    result.append(showSteelDetails(o));
                }
            }
        }
    }




}
