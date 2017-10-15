import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    private Container cp;
    private JButton btnEx = new JButton("範本");
    private JButton btnDc = new JButton("加密");
    private JButton btnClear = new JButton("清除");
    private JButton btnDe = new JButton("解密");
    private JButton btnExit = new JButton("Exit");
    private JLabel lab = new JLabel("Key");
    private JTextArea taL = new JTextArea();
    private JTextArea taR = new JTextArea();
    private JScrollPane spL = new JScrollPane(taL);
    private JScrollPane spR = new JScrollPane(taR);
    private JPanel pan = new JPanel();
    private JTextField tfd = new JTextField("csie");

    public MainFrame(){
        initComp();
    }
    public void initComp(){
        this.setBounds(100,100,500,450);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setTitle("加密到你媽都認不出來");
        this.setTitle("加密得休");
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        taL.setPreferredSize(new Dimension(200,500));
        taR.setPreferredSize(new Dimension(200,500));
        taL.setLineWrap(true);
        taR.setLineWrap(true);
        pan.setLayout(new GridLayout(7,1,3,3));
        pan.add(btnEx);
        pan.add(btnDc);
        pan.add(lab);
        pan.add(tfd);
        pan.add(btnDe);
        pan.add(btnClear);
        pan.add(btnExit);
        cp.add(pan,BorderLayout.CENTER);
        cp.add(spL,BorderLayout.WEST);
        cp.add(spR,BorderLayout.EAST);

        btnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnEx.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taL.setText("Later that day, when the Princess was sitting at the table" +
                        ", something was heard coming up the marble stairs. Splish, splosh," +
                        " splish splosh! The sound came nearer and nearer, and a voice cried, " +
                        "Let me in, youngest daughter of the King.");
            }
        });

        btnDc.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = taL.getText().toCharArray();
                int len = data.length ;
                String key = tfd.getText();
                char keyList[] = key.toCharArray();
                for(int i = 0; i < len; i++){
                    data[i] = (char)((int)data[i] ^ (int)keyList[i%(keyList.length)]);
                }
                taR.setText(new String(data));
            }
        });

        btnDe.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taL.setText(taR.getText());
                char data[] = taL.getText().toCharArray();
                int len = data.length ;
                String key = tfd.getText();
                char keyList[] = key.toCharArray();
                for(int i = 0; i < len; i++){
                    data[i] = (char)((int)data[i] ^ (int)keyList[i%(keyList.length)]);
                }
                taR.setText(new String(data));
            }
        });

        btnClear.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taL.setText("");
                taR.setText("");
            }
        });
    }
}
