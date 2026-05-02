import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ExpenseTrackerGUI extends JFrame {

    private TransactionService service = new TransactionService();
    private DefaultTableModel model;
    private JTable table;

    public ExpenseTrackerGUI() {

        setTitle("Expense Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        model = new DefaultTableModel(new String[]{"ID","Type","Amount","Category"},0);
        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);

        JTextField id = new JTextField();
        JTextField type = new JTextField();
        JTextField amount = new JTextField();
        JTextField category = new JTextField();

        JPanel form = new JPanel(new GridLayout(5,2));
        form.add(new JLabel("ID"));
        form.add(id);
        form.add(new JLabel("Type"));
        form.add(type);
        form.add(new JLabel("Amount"));
        form.add(amount);
        form.add(new JLabel("Category"));
        form.add(category);

        JButton add = new JButton("Add");
        JButton delete = new JButton("Delete");

        add.addActionListener(e -> {
            service.addTransaction(new Transaction(
                Integer.parseInt(id.getText()),
                type.getText(),
                Double.parseDouble(amount.getText()),
                category.getText()
            ));
            refresh();
        });

        delete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row >= 0) {
                int tid = Integer.parseInt(model.getValueAt(row,0).toString());
                service.deleteTransaction(tid);
                refresh();
            }
        });

        JPanel btn = new JPanel();
        btn.add(add);
        btn.add(delete);

        setLayout(new BorderLayout());
        add(form,BorderLayout.NORTH);
        add(pane,BorderLayout.CENTER);
        add(btn,BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refresh() {
        model.setRowCount(0);
        List<Transaction> list = service.getAllTransactions();
        for(Transaction t : list) {
            model.addRow(new Object[]{
                t.getId(), t.getType(), t.getAmount(), t.getCategory()
            });
        }
    }

    public static void main(String[] args) {
        new ExpenseTrackerGUI();
    }
}