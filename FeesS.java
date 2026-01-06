import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class FeesS extends JFrame {
    private JPanel contentPane;
    private JTextField name;
    private JTextField fname;
    private JTextField timing;
    private JTextField fmobile;
    private JTextField fees;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FeesS frame = new FeesS();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FeesS() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Fees Receipt System");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitle.setBounds(80, 0, 328, 58);
        contentPane.add(lblTitle);

        JLabel lblName = new JLabel("Enter Student Name:");
        lblName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblName.setBounds(10, 69, 140, 30);
        contentPane.add(lblName);

        JLabel lblFname = new JLabel("Enter Father Name:");
        lblFname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblFname.setBounds(10, 97, 140, 30);
        contentPane.add(lblFname);

        JLabel lblTiming = new JLabel("Enter Batch Time:");
        lblTiming.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblTiming.setBounds(10, 122, 140, 30);
        contentPane.add(lblTiming);
        
        JLabel lblFmobile = new JLabel("Enter Father Mobile:");
        lblFmobile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblFmobile.setBounds(10, 151, 140, 30);
        contentPane.add(lblFmobile);

        JLabel lblFees = new JLabel("Enter Fees Amount:");
        lblFees.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblFees.setBounds(10, 179, 140, 30);
        contentPane.add(lblFees);

        name = new JTextField();
        name.setBounds(143, 75, 103, 20);
        contentPane.add(name);

        fname = new JTextField();
        fname.setBounds(143, 103, 103, 20);
        contentPane.add(fname);

        timing = new JTextField();
        timing.setBounds(143, 128, 103, 20);
        contentPane.add(timing);

        fmobile = new JTextField();
        fmobile.setBounds(143, 157, 103, 20);
        contentPane.add(fmobile);

        fees = new JTextField();
        fees.setBounds(143, 185, 103, 20);
        contentPane.add(fees);

        JTextArea area = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(500, 69, 350, 280);
        contentPane.add(scrollPane);

        JButton btnGenerate = new JButton("Generate Receipt");
        btnGenerate.addActionListener(e -> {
            // Validation checks
            if (validateInputs()) {
                area.setText("**********************************************************************\n");
                area.append("\t*Fees Receipt System *\n");
                area.append("**********************************************************************\n");
                area.append("  Student Name: " + name.getText() + "\n");
                area.append("  Father Name: " + fname.getText() + "\n");
                area.append("  Batch Timing: " + timing.getText() + "\n");
                area.append("  Father Mobile: " + fmobile.getText() + "\n");
                area.append("  Fees Amount: " + fees.getText() + "\n");
                area.append("  Signature\n");
            }
        });
        btnGenerate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnGenerate.setBounds(0, 220, 140, 30);
        contentPane.add(btnGenerate);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(e -> {
            area.setText("");
            name.setText("");
            fname.setText("");
            timing.setText("");
            fmobile.setText("");
            fees.setText("");
        });
        btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnReset.setBounds(143, 220, 140, 30);
        contentPane.add(btnReset);

        JButton btnPrintReceipt = new JButton("Print Receipt");
        btnPrintReceipt.addActionListener(e -> {
            try {
                area.print();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(contentPane, "Error printing: " + ex.getMessage());
            }
        });
        btnPrintReceipt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnPrintReceipt.setBounds(290, 220, 140, 30);
        contentPane.add(btnPrintReceipt);
    }

    private boolean validateInputs() {
    // Batch timing: example format like "09:00 - 11:00" (24-hour format)
    String batchTime = timing.getText();
    if (!batchTime.matches("\\d{2}:\\d{2} - \\d{2}:\\d{2}")) {
        JOptionPane.showMessageDialog(contentPane, "Invalid batch timing format. Use 24-hour format: 'HH:MM - HH:MM'.");
        return false;
    }

    // Mobile number: must be exactly 10 digits
    String mobile = fmobile.getText();
    if (!mobile.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(contentPane, "Father's mobile number must be a 10-digit number.");
        return false;
    }

    // Fees amount: must be an integer
    try {
        Integer.parseInt(fees.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(contentPane, "Fees amount must be an integer.");
        return false;
    }

    return true;
}

}
