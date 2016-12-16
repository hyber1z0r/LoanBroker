import dk.jakobgaard.LoanBroker;
import dk.jakobgaard.LoanBrokerService;

import javax.swing.*;

public class ClientForm extends JFrame {
    private JPanel rootPanel;
    private JTextField textFieldSSN;
    private JTextField textFieldAmount;
    private JTextField textFieldDuration;
    private JButton buttonSubmit;
    private LoanBroker service;

    public ClientForm() {
        super("Loan requester");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            this.service = new LoanBrokerService().getLoanBrokerPort();
            setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPanel, "Error connecting to RabbitMQ");
            System.exit(1);
        }

        buttonSubmit.addActionListener(e -> {
            System.out.println("btn");
            String response = service.fileLoanRequest(textFieldSSN.getText(),
                    Double.valueOf(textFieldAmount.getText()),
                    Long.valueOf(textFieldDuration.getText()));
            JOptionPane.showMessageDialog(rootPanel, response);
        });
    }
}
