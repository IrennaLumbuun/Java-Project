package group5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GUI class
 *
 * @author group5
 * @version 12/2/2018
 */
public class LibraryGui extends JFrame {

    //need to add buttons that work 
    //checkOut does not do anything
    //ChecckIn crashes
    //fields
    Library collection = new Library();
    JButton btnCheckIn;
    JButton btnUpdate;
    JButton btnCheckOut;
    JComboBox<Book> cmbTitle;
    JTextField txtTitle;
    JTextField txtType;
    JLabel lblResult;
    JLabel lblWarning;

    /**
     * Constructor.
     *
     * @param title the frame title
     */
    public LibraryGui(String title) {
        super(title);
        addComponents();
        addEventHandlers();
        initializeDisplay();

    }
    
    /**
     * Private method used to add components to the frame.
     */
    private void addComponents() {
        //Create control at buttons
        btnCheckIn = new JButton("Check In");
        btnCheckOut = new JButton("Check Out");
        btnUpdate = new JButton("Update");
        JPanel pnlButtons = new JPanel();
        pnlButtons.add(btnCheckIn);
        pnlButtons.add(btnCheckOut);
        pnlButtons.add(btnUpdate);
        add(BorderLayout.SOUTH, pnlButtons);

        //ComboBox
        Book[] arr = collection.getSortedArray();
        cmbTitle = new JComboBox<>(arr);
        add(BorderLayout.NORTH, cmbTitle);

        //Center
        JLabel lblTitle = new JLabel("Title: ");
        JLabel lblType = new JLabel("Type: ");
        txtTitle = new JTextField(50);
        txtType = new JTextField(50);
        JPanel pnlResult = new JPanel();
        JPanel pnlTitle = new JPanel();
        JPanel pnlWarning = new JPanel();
        lblResult = new JLabel(collection.countBooks());
        lblWarning= new JLabel("You can not check out all the books in the library.");
        pnlResult.add(lblResult);
        pnlWarning.add(lblWarning);
        pnlTitle.add(lblTitle);
        pnlTitle.add(txtTitle);
        JPanel pnlType = new JPanel();
        pnlType.add(lblType);
        pnlType.add(txtType);
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(0, 1));
        pnlCenter.add(pnlTitle);
        pnlCenter.add(pnlType);
        pnlCenter.add(pnlResult);
        pnlCenter.add(pnlWarning);
        add(BorderLayout.CENTER, pnlCenter);

    }

    /**
     * Private method used to set up the event handlers.
     */
    public void addEventHandlers() {

        //check in method
        btnCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTitle.getText().isEmpty()) {
                    Book b = new Book(txtType.getText(), txtTitle.getText());
                    collection.checkIn(b);
                    cmbTitle.setModel(new DefaultComboBoxModel(collection.getSortedArray()));
                    collection.countBooks();
                    updateCountBooks();
                }
            }
        });
        //check out method
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book b = (Book) cmbTitle.getSelectedItem();
                collection.checkOut(b);
                cmbTitle.removeItemAt(cmbTitle.getSelectedIndex());
                collection.countBooks();
                updateCountBooks();
            }
        });       
        //combo box event handler
        cmbTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbTitle.getItemCount() > 0) {
                    Book b = (Book) cmbTitle.getSelectedItem();
                    txtTitle.setText(b.getTitle());
                    txtType.setText(b.getType());

                }
            }
        });
        //new button event handler
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTitle.getText().isEmpty()) {
                    Book b = (Book) cmbTitle.getSelectedItem();
                    b.setTitle(txtTitle.getText());
                    b.setType(txtType.getText());
                    collection.update();
                    cmbTitle.updateUI();
                    updateCountBooks();
                }
            }
        });

    }

    private void initializeDisplay() {
            cmbTitle.setSelectedIndex(0);
            collection.countBooks();

    }
    private void updateCountBooks() {
        lblResult.setText(collection.countBooks());
    }
}
