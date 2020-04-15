package shop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Shop extends JFrame{
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel itemLabel;
    private JCheckBox item1CheckBox;
    private JCheckBox item2CheckBox;
    private JCheckBox item3CheckBox;
    private JCheckBox item4CheckBox;
    private JCheckBox item5CheckBox;
    private JLabel messageLabel;
    private JPanel panel;
    private JButton checkButton;
    private final int WINDOW_WIDTH = 290; 
    private final int WINDOW_HEIGHT = 250;
    public Shop() {

        setTitle("Shop");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);


        nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(11);
        itemLabel = new JLabel("What do you like?");
        messageLabel = new JLabel("");

        item1CheckBox = new JCheckBox("Oil change - 26$");
        item2CheckBox = new JCheckBox("Radiator flush - 30$");
        item3CheckBox = new JCheckBox("Transmission flush - 80$");
        item4CheckBox = new JCheckBox("Inspection 15$");
        item5CheckBox = new JCheckBox("Tire rotation 20$");


        checkButton = new JButton("Apply changes");

        ButtonGroup bG = new ButtonGroup();

        add(checkButton);
        add(item1CheckBox);
        add(item2CheckBox);
        add(item3CheckBox);
        add(item4CheckBox);
        add(item5CheckBox); 
        
        checkButton.addActionListener(new CheckBoxListener());
        panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(itemLabel);
        panel.add(item1CheckBox);
        panel.add(item2CheckBox);
        panel.add(item3CheckBox);
        panel.add(item4CheckBox);
        panel.add(item5CheckBox);
        panel.add(checkButton);
        panel.add(messageLabel);
        add(panel);
        setVisible(true);	
    }

    private class CheckBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int num = 0;
            String total = "";
            if (nameField.getText().isEmpty()) {
                messageLabel.setText("");
            }else{
            if (e.getSource() == checkButton){
                if (item1CheckBox.isSelected()){
                    num += 26;
                }
                if (item2CheckBox.isSelected()){
                    num += 30;
                }
                if (item3CheckBox.isSelected()){
                    num += 80;
                }
                if (item4CheckBox.isSelected()){
                    num += 15;
                }
                if (item5CheckBox.isSelected()){
                    num += 20;
                }
            }
            total = Integer.toString(num);
            String msg = "Hello " + nameField.getText()+
                         "\n your Total account: " + total +"$";
            messageLabel.setText(msg);
            
            }
            
        }   
    }
    public static void main(String[] args) {
        new Shop();
    }
}
