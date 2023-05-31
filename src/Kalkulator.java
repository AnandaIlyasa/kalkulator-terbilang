import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Kalkulator extends JFrame {

    private static final long serialVersionUID = 1L; // untuk serializable exception
    JTextField input1;
    JLabel hasil;
    JLabel hasilTerbilang;
    JPanel PanelTombol;
    JButton sum;
    JButton Cls;
    MultiOperation operasikan;

    public Kalkulator() { 
        initUI();

        Cls.addActionListener(new ActionListener(){ //abstract class
            public void actionPerformed(ActionEvent ae){  
                input1.setText("");
                hasil.setText("");
                hasilTerbilang.setText("");
            }
        });
        sum.addActionListener(new ActionListener(){ //abstract class
            public void actionPerformed(ActionEvent ae){  
                double summary = operasikan.calculate(input1.getText());
                hasil.setText("HASIL = " + summary);
                KataBilangan terbilang = new KataBilangan(summary);
                String teks = terbilang.getTerbilang();
                hasilTerbilang.setText("<html>"+"( " + teks + ")"+"</html>");
            }
        });


    }
    private void initUI(){
        operasikan = new MultiOperation();
        sum = new JButton("=");
        input1 = new JTextField("",SwingConstants.CENTER);
        Cls = new JButton("C");
        hasil = new JLabel("",SwingConstants.CENTER);
        hasilTerbilang = new JLabel("",SwingConstants.CENTER);
        PanelTombol = new JPanel();
        PanelTombol.setBackground(Color.DARK_GRAY);
        input1.setBackground(Color.LIGHT_GRAY);

        add(input1);
        add(hasil);
        add(hasilTerbilang);
        PanelTombol.add(Cls);
        PanelTombol.add(sum);
        add(PanelTombol);

        setTitle("Kalkulator Terbilang");
        setResizable(false);
        setLayout(new GridLayout(4, 1, 50, 5));
        setLocation(450, 150);
        setSize(400, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}