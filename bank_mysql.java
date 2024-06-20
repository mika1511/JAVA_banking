// ***********************************************************	
// importing packages
// ***********************************************************	

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

// ***********************************************************	
// class bank_mysqlextends from JFrame Class and implements ActionListener
// ***********************************************************	
public class bank_mysql extends JFrame implements ActionListener {
    // Variable Declaration;
    JTabbedPane tabbedpane;
    JPanel welcomePanel, loginPanel, createNewAccountPanel, accountTransactionPanel, controlPanel, displayDetailsPanel, aboutPanel, logoutPanel;
    int accountnumber;
    java.util.Date date;
    Calendar calendar;
    JTable table;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    String userID, userPWD;

    // ***********************************************************
    // Variable Declaration
    // ***********************************************************
    // JLabel
    JLabel lblAccountNumber, lblTransactionAccountNumber, lblPersonalDetails, lblApplicantName, lblApplicantDOB, lblApplicantGender, lblApplicantProfession, lblApplicantAddress, lblAccountDetails, lblAccountMode, lblGuaranterDetails, lblGuaranterName, lblGuaranterAccountNumber, lblGuaranterAddress, lblAccountHoldersName, lblAccountBalance, lblTransactionDate, lblTransactionType, lblTransactionAmount, lblCurrentBalance, lblTransactionMode, lblNewId, lblNewPassword, lblDelLoginId, lblExitApps, lblID, lblPWD, lblLogin, lblWelcome1, lblWelcome2, lblWelcome3, lblWelcome4, lblWelcome5, lblWelcome6;
    // JTextField
    JTextField txtAccountNumber, txtAccountNumberDet, txtApplicantName, txtApplicantDOB, txtApplicantProfession, txtGuaranterName, txtGuaranterAccountNumber, txtTransactionDate, txtTransactionAmount, txtTransactionAccountNumber, txtAccountHoldersName, txtCurrentBalance, txtNewId, txtDelLoginId, txtID;
    // JPasswordField
    JPasswordField txtNewPassword, txtPWD;
    // JTextArea
    JTextArea txtApplicantAddress, txtGuaranterAddress;
    // JComboBox
    JComboBox<String> cmbApplicantGender, cmbAccountMode, cmbTransactionType, cmbTransactionMode;
    // JButton
    JButton btncreateAccount, btnReset1, btnSubmit, btnReset2, btnGetDetails, btnSearch, btnReset3, btnReset4, btnCreateNewLogin, btnDeleteUser, btnExitApps, btnLogin, btnReset, btnExit, btnLtoC, btnQuit;
    // JRadioButton
    JRadioButton rCreateUser, rDeleteUser;

    // ***********************************************************
    //	 contructor to initialize
    // ***********************************************************
    public bank_mysql() {
        // Displaying Message At Start-up
        JOptionPane.showMessageDialog(null, "Loading Java Bank Application....");

        // Initializing tabbedpane and the panels
        tabbedpane = new JTabbedPane();
        welcomePanel = new JPanel();
        welcome();
        loginPanel = new JPanel();
        login();
        createNewAccountPanel = new JPanel();
        createNewAccount();
        autoAccountNumber();
        accountTransactionPanel = new JPanel();
        accountTransation();
        controlPanel = new JPanel();
        controlPanel();
        displayDetailsPanel = new JPanel();
        accountDetails();
        logoutPanel = new JPanel();
        logoutPanel();

        // Adding panels to the tabbedpane

        tabbedpane.addTab("Welcome", null, welcomePanel, "Welcome Panel");
        tabbedpane.addTab("Login", null, loginPanel, "Bank Authentication Panel");
        tabbedpane.addTab("New Account", null, createNewAccountPanel, "Application Form for creating new account");
        tabbedpane.addTab("Account Transaction", null, accountTransactionPanel, "Pane for withdrawl/deposits transactions");
        tabbedpane.addTab("Control Panel", null, controlPanel, "for adding/removing users");
        tabbedpane.addTab("Account Details", null, displayDetailsPanel, "Displays Account Details");
        tabbedpane.addTab("LogOut", null, logoutPanel, "LogOut Bank Application");

        // Adding tabbedpane to the container

        getContentPane().add(tabbedpane);

        // Disabling the panels

        tabbedpane.setEnabledAt(1, false);
        tabbedpane.setEnabledAt(2, false);
        tabbedpane.setEnabledAt(3, false);
        tabbedpane.setEnabledAt(4, false);
        tabbedpane.setEnabledAt(5, false);
        tabbedpane.setEnabledAt(6, false);

        // Disabling controls

        btnSubmit.setEnabled(false);

        txtAccountHoldersName.setEnabled(false);
        txtCurrentBalance.setEnabled(false);
        txtTransactionDate.setEnabled(false);
        cmbTransactionMode.setEnabled(false);
        cmbTransactionType.setEnabled(false);

        txtAccountNumber.setEnabled(false);

        txtDelLoginId.setEnabled(false);
        btnDeleteUser.setEnabled(false);
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    // ***********************************************************
    // initialize and add  controls to specific panel
    //************************************************************
    // welcome() Function
    public void welcome() {
        //showStatus("Welcome To Java bank Application....");
        lblWelcome1 = new JLabel("**** Welcome To Java Bank ****");
        lblWelcome2 = new JLabel("*** Please Login To Continue ***");

        btnLtoC = new JButton("** Click Here To Login **");
        btnQuit = new JButton("Quit Application");

        welcomeLayout();

        welcomePanel.add(lblWelcome1);
        welcomePanel.add(lblWelcome2);
        welcomePanel.add(btnLtoC);
        welcomePanel.add(btnQuit);

        btnLtoC.addActionListener(this);
        btnQuit.addActionListener(this);
    }  // welcome Function ends

    // login Function
    public void login() {
        lblLogin = new JLabel("Login : ");
        lblID = new JLabel("Enter User Id : ");
        lblPWD = new JLabel("Enter Password : ");
        txtID = new JTextField(10);
        txtPWD = new JPasswordField(10);
        btnLogin = new JButton("Login");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");

        loginLayout();

        loginPanel.add(lblLogin);
        loginPanel.add(lblID);
        loginPanel.add(txtID);
        loginPanel.add(lblPWD);
        loginPanel.add(txtPWD);
        loginPanel.add(btnLogin);
        loginPanel.add(btnReset);
        loginPanel.add(btnExit);

        btnLogin.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
    } // login() Function ends

    // createNewAccount() Function
    public void createNewAccount() {
        autoAccountNumber();

        // initializing JLabel

        lblAccountNumber = new JLabel("Applicant Account Number : ");
        lblPersonalDetails = new JLabel("Applicants Personal Details : ");
        lblApplicantName = new JLabel("Name : ");
        lblApplicantDOB = new JLabel("Date Of Birth : ");
        lblApplicantGender = new JLabel("Gender : ");
        lblApplicantProfession = new JLabel("Profession : ");
        lblApplicantAddress = new JLabel("Address : ");
        lblAccountDetails = new JLabel("Account Details : ");
        lblAccountMode = new JLabel("Account Mode : ");
        lblGuaranterDetails = new JLabel("Guaranter Details : ");
        lblGuaranterName = new JLabel("Guaranter Name : ");
        lblGuaranterAccountNumber = new JLabel("Guaranter Account Number : ");
        lblGuaranterAddress = new JLabel("Guaranter Address : ");

        // initializing JTextField

        txtAccountNumber = new JTextField(10);
        txtApplicantName = new JTextField(10);
        txtApplicantDOB = new JTextField(10);
        txtApplicantProfession = new JTextField(10);
        txtGuaranterName = new JTextField(10);
        txtGuaranterAccountNumber = new JTextField(10);

        // initializing JTextArea

        txtApplicantAddress = new JTextArea(2, 10);
        txtGuaranterAddress = new JTextArea(2, 10);

        // initializing JComboBox

        String gender[] = {"Male", "Female"};
        cmbApplicantGender = new JComboBox<String>(gender);

        String accountmode[] = {"Saving", "Current"};
        cmbAccountMode = new JComboBox<String>(accountmode);

        // initializing JButton

        btncreateAccount = new JButton("Create Account");
        btnReset1 = new JButton("Reset");

        NewAccountLayout(); // organize controls in New Account Panel

        // adding controls to panel

        createNewAccountPanel.add(lblAccountNumber);
        createNewAccountPanel.add(txtAccountNumber);
        createNewAccountPanel.add(lblPersonalDetails);
        createNewAccountPanel.add(lblApplicantName);
        createNewAccountPanel.add(txtApplicantName);
        createNewAccountPanel.add(lblApplicantDOB);
        createNewAccountPanel.add(txtApplicantDOB);
        createNewAccountPanel.add(lblApplicantGender);
        createNewAccountPanel.add(cmbApplicantGender);
        createNewAccountPanel.add(lblApplicantProfession);
        createNewAccountPanel.add(txtApplicantProfession);
        createNewAccountPanel.add(lblApplicantAddress);
        createNewAccountPanel.add(txtApplicantAddress);
        createNewAccountPanel.add(lblAccountDetails);
        createNewAccountPanel.add(lblAccountMode);
        createNewAccountPanel.add(cmbAccountMode);
        createNewAccountPanel.add(lblGuaranterDetails);
        createNewAccountPanel.add(lblGuaranterName);
        createNewAccountPanel.add(txtGuaranterName);
        createNewAccountPanel.add(lblGuaranterAccountNumber);
        createNewAccountPanel.add(txtGuaranterAccountNumber);
        createNewAccountPanel.add(lblGuaranterAddress);
        createNewAccountPanel.add(txtGuaranterAddress);
        createNewAccountPanel.add(btncreateAccount);
        createNewAccountPanel.add(btnReset1);

        btncreateAccount.addActionListener(this);
        btnReset1.addActionListener(this);
    }
    // createNewAccount() Function ends

    // accountTransaction() Function
    public void accountTransation() {
        // initializing Jlabel

        date = new java.util.Date();
        lblTransactionAccountNumber = new JLabel("Applicant Account Number : ");
        lblAccountHoldersName = new JLabel("Account Holder's Name : ");
        lblCurrentBalance = new JLabel("Current Balance : ");
        lblTransactionType = new JLabel("Transaction Type : ");
        lblTransactionAmount = new JLabel("Transaction Amount : ");
        lblTransactionDate = new JLabel("Transaction Date : ");
        lblTransactionMode = new JLabel("Transaction Mode : ");

        // initializing TextFields

        txtTransactionAccountNumber = new JTextField(10);
        txtAccountHoldersName = new JTextField(10);
        txtTransactionDate = new JTextField(15);
        txtTransactionAmount = new JTextField(10);
        txtCurrentBalance = new JTextField(10);

        txtTransactionDate.setText(date.toString());

        // initializing JComboBox

        String transactiontype[] = {"Deposit", "Withdrawl"};
        cmbTransactionType = new JComboBox<String>(transactiontype);

        String transactionmode[] = {"Cash", "Cheque", "Draft"};
        cmbTransactionMode = new JComboBox<String>(transactionmode);

        // initializing JButton

        btnGetDetails = new JButton("Get Details");
        btnSubmit = new JButton("Submit");
        btnReset2 = new JButton("Reset");

        btnGetDetails.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnReset2.addActionListener(this);

        TransactionLayout(); // organize controls in Transaction panel

        // adding controls to Panel

        accountTransactionPanel.add(lblTransactionAccountNumber);
        accountTransactionPanel.add(txtTransactionAccountNumber);
        accountTransactionPanel.add(btnGetDetails);
        accountTransactionPanel.add(lblAccountHoldersName);
        accountTransactionPanel.add(txtAccountHoldersName);
        accountTransactionPanel.add(lblCurrentBalance);
        accountTransactionPanel.add(txtCurrentBalance);
        accountTransactionPanel.add(lblTransactionDate);
        accountTransactionPanel.add(txtTransactionDate);
        accountTransactionPanel.add(lblTransactionType);
        accountTransactionPanel.add(cmbTransactionType);
        accountTransactionPanel.add(lblTransactionMode);
        accountTransactionPanel.add(cmbTransactionMode);
        accountTransactionPanel.add(lblTransactionAmount);
        accountTransactionPanel.add(txtTransactionAmount);
        accountTransactionPanel.add(btnSubmit);
        accountTransactionPanel.add(btnReset2);
    }
    // accountTransaction() Function ends

    // controlPanel() Function
    public void controlPanel() {
        //initializing RadioButtons
        rCreateUser = new JRadioButton("Create New Login : ", true);
        rDeleteUser = new JRadioButton("Delete User Login : ", false);

        // initializing JLabel
        lblNewId = new JLabel("Enter User Id : ");
        lblNewPassword = new JLabel("Enter User Password : ");
        lblDelLoginId = new JLabel("Enter User Id To Delete : ");

        // initializing JTextField
        txtNewId = new JTextField(10);
        txtNewPassword = new JPasswordField(10);
        txtDelLoginId = new JTextField(10);

        // initializing JButton
        btnCreateNewLogin = new JButton("Create New User");
        btnReset4 = new JButton("Reset");
        btnDeleteUser = new JButton("Delete User Login");

        // registering controls with ActionListener
        btnCreateNewLogin.addActionListener(this);
        btnReset4.addActionListener(this);
        btnDeleteUser.addActionListener(this);
        rCreateUser.addActionListener(this);
        rDeleteUser.addActionListener(this);

        controlPanelLayout(); // organize controls in controlPanel panel

        // adding controls to the panel
        controlPanel.add(rCreateUser);
        controlPanel.add(lblNewId);
        controlPanel.add(txtNewId);
        controlPanel.add(lblNewPassword);
        controlPanel.add(txtNewPassword);
        controlPanel.add(btnCreateNewLogin);
        controlPanel.add(btnReset4);
        controlPanel.add(rDeleteUser);
        controlPanel.add(lblDelLoginId);
        controlPanel.add(txtDelLoginId);
        controlPanel.add(btnDeleteUser);

    }
    // controlPanel()  Function ends

    // accountDetails() Function
    public void accountDetails() {
        // initializing JLabel
        lblAccountNumber = new JLabel("Enter Account Number : ");
        lblTransactionDate = new JLabel("");
        lblTransactionType = new JLabel("");
        lblTransactionAmount = new JLabel("");
        lblTransactionMode = new JLabel("");
        lblAccountBalance = new JLabel("");

        // initializing JTextField
        txtAccountNumberDet = new JTextField(10);

        // initializing JButton
        btnSearch = new JButton("Display Account Details");
        btnReset3 = new JButton("Reset");

        accountDetailsLayout(); // organize controls in accountDetails panel

        // adding controls to the accountDetails panel
        displayDetailsPanel.add(lblAccountNumber);
        displayDetailsPanel.add(txtAccountNumberDet);
        displayDetailsPanel.add(btnSearch);
        displayDetailsPanel.add(btnReset3);

        // registering the controls with the Actionlistener
        btnSearch.addActionListener(this);
        btnReset3.addActionListener(this);
    }
    // accountTransaction() Function ends

    // logoutPanel() Function
    public void logoutPanel() {
        // initializing JLabel
        lblExitApps = new JLabel("Click To LogOut Application : ");

        // initializing JButton
        btnExitApps = new JButton("LogOut Application");

        logoutPanelLayout(); // UDF to organize controls in the logoutPanel

        // adding controls to the logoutPanel
        logoutPanel.add(lblExitApps);
        logoutPanel.add(btnExitApps);

        // registering control with the Actionlistener
        btnExitApps.addActionListener(this);

    }
    // logoutPanel() Function ends

    Connection connection; // declaring connection variable

    //************************************************************
    //Event Handling....
    //************************************************************
    public void actionPerformed(ActionEvent et) {

        // Event handling for login panel
        userID = null;
        userPWD = null;
        if (et.getSource() == btnLogin) {
            userID = txtID.getText();
            userPWD = new String(txtPWD.getPassword());
            Connection connection;

            if (userID.length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Login Id...");
                return;
            } else if (userPWD.length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Login Password...");
                return;
            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");    // to load the driver
                    String url = "jdbc:mysql://localhost:3306/bankdb";            // to connect to the database
                    connection = DriverManager.getConnection(url, "root", "");

                    PreparedStatement preparedstatement = connection.prepareStatement("select * from usertbl where userid=? and userpassword=?");
                    preparedstatement.setString(1, userID);
                    preparedstatement.setString(2, userPWD);
                    ResultSet resultset = preparedstatement.executeQuery();

                    if (resultset.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful ...");
                        txtID.setText("");
                        txtPWD.setText("");

                        tabbedpane.setEnabledAt(1, false);
                        tabbedpane.setEnabledAt(2, true);
                        tabbedpane.setEnabledAt(3, true);
                        tabbedpane.setEnabledAt(4, true);
                        tabbedpane.setEnabledAt(5, true);
                        tabbedpane.setEnabledAt(6, true);

                        tabbedpane.setSelectedIndex(3);
                    } else {
                        JOptionPane.showMessageDialog(null, "Authentication Failed ...");
                        txtID.setText("");
                        txtPWD.setText("");
                    }
                } catch (Exception psexception) {
                    JOptionPane.showMessageDialog(null, "Login Error ...");
                }
            }
        }
        if (et.getSource() == btnReset) {
            txtID.setText("");
            txtPWD.setText("");
        }

        if (et.getSource() == btnExit) {
            JOptionPane.showMessageDialog(null, "Thanks ...");
            tabbedpane.setSelectedIndex(0);
            tabbedpane.setEnabledAt(0, true);
            tabbedpane.setEnabledAt(1, false);
            //showStatus("Welcome To Java Bank Application ...");

        }
        //Event handling for login panel ends

        // Event handling for New Account

        if (et.getSource() == btncreateAccount) {

            if (txtApplicantName.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Applicant's Name.");
                return;
            } else if (txtApplicantDOB.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Applicant's Date Of Birth.");
                return;
            } else if (txtApplicantProfession.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Applicant's Profession.");
                return;
            } else if (txtApplicantAddress.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Applicant's Address.");
                return;
            } else if (txtGuaranterName.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Guaranter's Name.");
                return;
            } else if (txtGuaranterAccountNumber.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Guaranter's Account Number.");
                return;
            } else if (txtGuaranterAddress.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Guaranter's Address.");
                return;
            } else if (checkNumbers(txtApplicantName.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Applicant Name can not contain Numbers.");
                return;
            } else if (checkNumbers(txtApplicantProfession.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Applicant Profession can not contain Numbers.");
                return;
            } else if (checkNumbers(txtGuaranterName.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Guaranter Name can not contain Numbers.");
                return;
            } else if (checkCharacters(txtGuaranterAccountNumber.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Guaranter Account Number only contain Numbers.");
                return;
            } else {

                connectDB();
                try {
                    PreparedStatement preparedstatement = connection.prepareStatement("insert into accounttbl values(?,?,?,?,?,?,?,?,?,?)");

                    preparedstatement.setInt(1, Integer.parseInt(txtAccountNumber.getText()));
                    preparedstatement.setString(2, txtApplicantName.getText());
                    preparedstatement.setString(3, txtApplicantDOB.getText());
                    preparedstatement.setString(4, String.valueOf(cmbApplicantGender.getSelectedItem()));
                    preparedstatement.setString(5, txtApplicantProfession.getText());
                    preparedstatement.setString(6, txtApplicantAddress.getText());
                    preparedstatement.setString(7, String.valueOf(cmbAccountMode.getSelectedItem()));
                    preparedstatement.setString(8, txtGuaranterName.getText());
                    preparedstatement.setInt(9, Integer.parseInt(txtGuaranterAccountNumber.getText()));
                    preparedstatement.setString(10, txtGuaranterAddress.getText());

                    preparedstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ...");
                    preparedstatement.close();

                    date = new java.util.Date();
                    preparedstatement = connection.prepareStatement("insert into transactiontbl values(?,?,?,?,?,?)");
                    preparedstatement.setInt(1, Integer.parseInt(txtAccountNumber.getText()));
                    preparedstatement.setString(2, date.toString());
                    preparedstatement.setString(3, "Deposit");
                    preparedstatement.setInt(4, 500);
                    preparedstatement.setString(5, "Cash");
                    preparedstatement.setInt(6, 500);
                    preparedstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Transaction Table Updated ...");

                    // Clearing field values....

                    txtAccountNumber.setText("");
                    txtApplicantName.setText("");
                    txtApplicantDOB.setText("");
                    txtApplicantProfession.setText("");
                    txtApplicantAddress.setText("");
                    txtGuaranterName.setText("");
                    txtGuaranterAccountNumber.setText("");
                    txtGuaranterAddress.setText("");
                    accountnumber = accountnumber + 1;
                    txtAccountNumber.setText(String.valueOf(accountnumber));

                } catch (Exception NewAccountErr) {
                    JOptionPane.showMessageDialog(null, "Error Creating New Account! Please Check Specified Field Values [i.e. Numerical Fields should not contain Characters and vice-versa ...]");
                }

            }
        }
        if (et.getSource() == btnReset1) {
            txtApplicantName.setText("");
            txtApplicantDOB.setText("");
            txtApplicantProfession.setText("");
            txtApplicantAddress.setText("");
            txtGuaranterName.setText("");
            txtGuaranterAccountNumber.setText("");
            txtGuaranterAddress.setText("");
        }

        //Event handling for New Account ends

        //Event handling for Transaction begins

        int totalamount = 0;
        int amountDep = 0;
        int amountWid = 0;

        if (et.getSource() == btnGetDetails) {
            if (txtTransactionAccountNumber.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Account Number.");
                return;
            } else if (checkCharacters(txtTransactionAccountNumber.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Account Number can not contain Characters.");
                return;
            } else {

                connectDB();
                ResultSet resultset = null;
                try {
                    PreparedStatement preparedstatement = connection.prepareStatement("select * from accounttbl where accnum=?");
                    preparedstatement.setInt(1, Integer.parseInt(txtTransactionAccountNumber.getText()));
                    resultset = preparedstatement.executeQuery();
                    if (resultset.next()) {
                        txtAccountHoldersName.setText(resultset.getString(2));
                        btnSubmit.setEnabled(true);
                        btnGetDetails.setEnabled(false);
                        txtTransactionAccountNumber.setEnabled(false);
                        cmbTransactionMode.setEnabled(true);
                        cmbTransactionType.setEnabled(true);
                        txtTransactionAmount.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Account Number.");
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Error Searching Account Details! Please enter Valid Account Number.");
                }

                try {
                    PreparedStatement preparedstatement1 = connection.prepareStatement("select * from transactiontbl where accnum=? and Type=?");
                    preparedstatement1.setInt(1, Integer.parseInt(txtTransactionAccountNumber.getText()));
                    preparedstatement1.setString(2, "Deposit");
                    ResultSet resultset1 = preparedstatement1.executeQuery();

                    PreparedStatement preparedstatement2 = connection.prepareStatement("select * from transactiontbl where accnum=? and Type=?");
                    preparedstatement2.setInt(1, Integer.parseInt(txtTransactionAccountNumber.getText()));
                    preparedstatement2.setString(2, "Withdrawl");
                    ResultSet resultset2 = preparedstatement2.executeQuery();

                    while (resultset1.next()) {
                        amountDep = amountDep + resultset1.getInt(4);
                        while (resultset2.next()) {

                            amountWid = amountWid + resultset2.getInt(4);
                        }
                    }
                    totalamount = amountDep - amountWid;
                    txtCurrentBalance.setText(String.valueOf(totalamount));
                } catch (Exception errr) {
                }
            }
        }
        if (et.getSource() == btnSubmit) {
            if (txtTransactionAmount.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Transaction Amount.");
                return;
            } else if (checkCharacters(txtTransactionAmount.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Transaction Amount can not contain Characters.");
                return;
            } else {

                connectDB();
                totalamount = 0;

                if (String.valueOf(cmbTransactionType.getSelectedItem()) == "Withdrawl") {
                    totalamount = Integer.parseInt(txtCurrentBalance.getText()) - Integer.parseInt(txtTransactionAmount.getText());

                } else {
                    totalamount = Integer.parseInt(txtCurrentBalance.getText()) + Integer.parseInt(txtTransactionAmount.getText());

                }
                try {

                    PreparedStatement preparedstatement = connection.prepareStatement("insert into transactiontbl values(?,?,?,?,?,?)");
                    preparedstatement.setInt(1, Integer.parseInt(txtTransactionAccountNumber.getText()));
                    preparedstatement.setString(2, date.toString());
                    preparedstatement.setString(3, String.valueOf(cmbTransactionType.getSelectedItem()));
                    preparedstatement.setInt(4, Integer.parseInt(txtTransactionAmount.getText()));
                    preparedstatement.setString(5, String.valueOf(cmbTransactionMode.getSelectedItem()));
                    preparedstatement.setInt(6, totalamount);
                    preparedstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Transaction Successful.");
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Error Updating Transaction Table.");
                    txtTransactionAccountNumber.setText("");
                    txtAccountHoldersName.setText("");
                    txtCurrentBalance.setText("");
                    txtTransactionAmount.setText("");
                    btnGetDetails.setEnabled(true);
                    txtTransactionAccountNumber.setEnabled(true);
                    cmbTransactionMode.setEnabled(false);
                    cmbTransactionType.setEnabled(false);
                }
                txtTransactionAmount.setEnabled(false);
                btnSubmit.setEnabled(false);
            }
        }
        if (et.getSource() == btnReset2) {
            txtTransactionAccountNumber.setText("");
            txtAccountHoldersName.setText("");
            txtCurrentBalance.setText("");
            txtTransactionAmount.setText("");
            btnGetDetails.setEnabled(true);
            txtTransactionAccountNumber.setEnabled(true);
            cmbTransactionMode.setEnabled(false);
            cmbTransactionType.setEnabled(false);
        }
        // Event handling for transaction ends

        // Event handling for display details begins
        if (et.getSource() == btnSearch) {
            if (txtAccountNumberDet.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Account Number.");
                return;
            } else if (checkCharacters(txtAccountNumberDet.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Invalid Data Entered : Account Number can not contain characters.");
                txtAccountNumberDet.setText("");
                return;
            } else {
                connectDB();
                try {
                    PreparedStatement preparedstatement = connection.prepareStatement("select * from transactiontbl where accnum=?");
                    preparedstatement.setInt(1, Integer.parseInt(txtAccountNumberDet.getText()));
                    ResultSet resultset = preparedstatement.executeQuery();

                    if (resultset.next()) {
                        ResultSetMetaData rsmd = resultset.getMetaData();

                        Vector rows, columnNames, newRow;

                        int numberOfColumns = rsmd.getColumnCount();
                        columnNames = new Vector();
                        for (int column = 0; column < numberOfColumns; column++) {
                            columnNames.addElement(rsmd.getColumnLabel(column + 1));
                        }
                        rows = new Vector();
                        rows.addElement(columnNames);
                        resultset.previous();
                        while (resultset.next()) {
                            newRow = new Vector();
                            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                                newRow.addElement(resultset.getObject(i));
                            }
                            rows.addElement(newRow);
                        }
                        table = new JTable(rows, columnNames);

                        JOptionPane.showMessageDialog(null, "Valid Account Number : Displaying Details.");

                        JFrame f = new JFrame();
						f.setTitle("Account Details");
                        f.setSize(800, 650);
                        f.setLocation(350, 100);
                        
						f.setLayout( null );
                        JPanel p = new JPanel();
						p.setLayout(new BorderLayout());
						p.add(table, BorderLayout.CENTER);
						p.setBounds(25, 25, 730, 550);
                        f.getContentPane().add(p);                        
						f.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Account Number.");
                        return;
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Error Executing Query or Invalid Account Number.");
                    txtAccountNumber.setText("");
                }
                btnSearch.setEnabled(false);
            }
        }
        if (et.getSource() == btnReset3) {
            txtAccountNumberDet.setText("");
            btnSearch.setEnabled(true);
        }
        //Event handling for displaydetails ends

        //Event handling for control panel begins
        if (et.getSource() == btnCreateNewLogin) {

            if (txtNewId.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify New Login Id.");
                return;
            } else if (new String(txtNewPassword.getPassword()).length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify New Login Password.");
                return;
            } else {
                connectDB();
                try {
                    PreparedStatement preparedstatement = connection.prepareStatement("insert into usertbl values(?,?)");
                    preparedstatement.setString(1, txtNewId.getText());
                    preparedstatement.setString(2, new String(txtNewPassword.getPassword()));
                    preparedstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New Login Created Successfully.");
                    txtNewId.setText("");
                    txtNewPassword.setText("");
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Id Already Exists, Please Choose Another Login Id.");
                }
            }
        }
        if (et.getSource() == btnReset4) {
            txtNewId.setText("");
            txtNewPassword.setText("");
        }
        if (et.getSource() == btnDeleteUser) {
            if (txtDelLoginId.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Specify Login Id To Delete.");
                return;
            } else {
                connectDB();
                try {
                    PreparedStatement preparedstatement = connection.prepareStatement("select * from usertbl where userid=?");
                    preparedstatement.setString(1, txtDelLoginId.getText());
                    ResultSet resultset = preparedstatement.executeQuery();

                    if (resultset.next()) {
                        PreparedStatement preparedstatement1 = connection.prepareStatement("delete from usertbl where userid=?");
                        preparedstatement1.setString(1, txtDelLoginId.getText());
                        preparedstatement1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Deletion Successful.");
                        txtDelLoginId.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Id Does Not Exists.");
                        txtDelLoginId.setText("");
                    }

                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Invalid User Login Id.");
                }

            }
        }
        // Event handling for control panel ends

        // Event handling for logout Panel
        if (et.getSource() == btnExitApps) {
            JOptionPane.showMessageDialog(null, "You Have Been Logged Out.");
            tabbedpane.setSelectedIndex(1);

            tabbedpane.setEnabledAt(1, true);
            tabbedpane.setEnabledAt(2, false);
            tabbedpane.setEnabledAt(3, false);
            tabbedpane.setEnabledAt(4, false);
            tabbedpane.setEnabledAt(5, false);
            tabbedpane.setEnabledAt(6, false);
        }
        // Event handling for logout Panel ends

        // Event handling for welcome panel
        if (et.getSource() == btnLtoC) {
            JOptionPane.showMessageDialog(null, "Welcome Guest : Continue ...");
            tabbedpane.setSelectedIndex(1);
            tabbedpane.setEnabledAt(0, false);
            tabbedpane.setEnabledAt(1, true);
        }
        if (et.getSource() == btnQuit) {
            JOptionPane.showMessageDialog(null, "Exiting Application.");
            System.exit(0);
        }
        // Event handling for welcome panel ends

        //Event handling for control panel
        if (et.getSource() == rCreateUser) {
            rDeleteUser.setSelected(false);
            txtDelLoginId.setEnabled(false);
            btnDeleteUser.setEnabled(false);

            txtNewId.setEnabled(true);
            txtNewPassword.setEnabled(true);
            btnCreateNewLogin.setEnabled(true);
            btnReset4.setEnabled(true);
        }
        if (et.getSource() == rDeleteUser) {
            rCreateUser.setSelected(false);
            txtNewId.setEnabled(false);
            txtNewPassword.setEnabled(false);
            btnCreateNewLogin.setEnabled(false);
            btnReset4.setEnabled(false);

            txtDelLoginId.setEnabled(true);
            btnDeleteUser.setEnabled(true);
        }
        //Event handling for control panel ends

    }
    // Event handling ends

    //************************************************************
    //		user defined functions
    //************************************************************
    // to connect to the database
    public void connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");                // to load the driver
            String url = "jdbc:mysql://localhost:3306/bankdb";        // to connect to the database
            connection = DriverManager.getConnection(url, "root", "");

        } catch (Exception connectErr) {
            //showStatus("Error Connectiong To database.."+connectErr);
        }
    }

    // increement the account number
    public void autoAccountNumber() {
        accountnumber = 0;
        connectDB();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from accounttbl");
            while (resultset.next()) {
                accountnumber = 0;
                accountnumber = resultset.getInt(1);
            }
            accountnumber = accountnumber + 1;
            txtAccountNumber.setText("");
            txtAccountNumber.setText(String.valueOf(accountnumber));
        } catch (Exception err) {
            //showStatus("");
            //showStatus("Increement Error..../Query Error...."+err);
        }
    } // function autoAccountNumber() ends

    public boolean checkNumbers(String s) {
        int len = s.length();
        int flag = 0;
        boolean set = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                flag = flag + 1;
            } else {
                flag = 0;
            }
        }
        if (flag > 0) {
            set = true;
            //JOptionPane.showMessageDialog(null,"Invalid Data Entered, Numbers Found in place of Characters.");
        }
        return set;
    }

    public boolean checkCharacters(String s) {
        int len = s.length();
        int flag = 0;
        boolean set = false;
        for (int i = 0; i < len; i++) {
            if ((s.charAt(i) >= 97 && s.charAt(i) <= 123) || (s.charAt(i) >= 65 && s.charAt(i) <= 91)) {
                flag = flag + 1;
            } else {
                flag = 0;
            }
        }
        if (flag > 0) {
            set = true;
            // JOptionPane.showMessageDialog(null,"Invalid Data Entered, Characters Found in place in Numerical Fields.");
        }
        return set;
    }

    //************************************************************
    // Organizing controls....
    //************************************************************
    // welcomeLayout()  Function
    public void welcomeLayout() {
        welcomePanel.setLayout(null);
        lblWelcome1.setBounds(250, 150, 200, 30);
        lblWelcome2.setBounds(250, 200, 200, 30);
        btnLtoC.setBounds(250, 250, 200, 30);
        btnQuit.setBounds(250, 300, 200, 30);
    } // welcome layout ends

    // loginLayout()  Function
    public void loginLayout() {
        loginPanel.setLayout(null);
        lblLogin.setBounds(330, 80, 200, 30);
        lblID.setBounds(200, 150, 150, 30);
        txtID.setBounds(360, 150, 160, 30);
        lblPWD.setBounds(200, 200, 150, 30);
        txtPWD.setBounds(360, 200, 160, 30);
        btnLogin.setBounds(200, 250, 100, 30);
        btnReset.setBounds(310, 250, 100, 30);
        btnExit.setBounds(420, 250, 100, 30);
    } // login layout ends

    // NewAccountLayout() Function
    public void NewAccountLayout() {
        createNewAccountPanel.setLayout(null);
        lblAccountNumber.setBounds(200, 50, 200, 30);
        txtAccountNumber.setBounds(400, 50, 200, 30);

        lblPersonalDetails.setBounds(100, 85, 300, 30);
        lblApplicantName.setBounds(200, 120, 200, 30);
        txtApplicantName.setBounds(400, 120, 200, 30);
        lblApplicantDOB.setBounds(200, 155, 200, 30);
        txtApplicantDOB.setBounds(400, 155, 200, 30);
        lblApplicantGender.setBounds(200, 190, 200, 30);
        cmbApplicantGender.setBounds(400, 190, 200, 30);
        lblApplicantProfession.setBounds(200, 225, 200, 30);
        txtApplicantProfession.setBounds(400, 225, 200, 30);
        lblApplicantAddress.setBounds(200, 260, 200, 30);
        txtApplicantAddress.setBounds(400, 260, 200, 30);

        lblAccountDetails.setBounds(100, 296, 300, 30);
        lblAccountMode.setBounds(200, 330, 200, 30);
        cmbAccountMode.setBounds(400, 330, 200, 30);
        lblGuaranterDetails.setBounds(100, 365, 300, 30);
        lblGuaranterName.setBounds(200, 390, 200, 30);
        txtGuaranterName.setBounds(400, 390, 200, 30);
        lblGuaranterAccountNumber.setBounds(200, 425, 200, 30);
        txtGuaranterAccountNumber.setBounds(400, 425, 200, 30);
        lblGuaranterAddress.setBounds(200, 460, 200, 30);
        txtGuaranterAddress.setBounds(400, 460, 200, 30);
        btncreateAccount.setBounds(200, 495, 190, 30);
        btnReset1.setBounds(410, 495, 190, 30);
    } // new account layout ends

    // TransactionLayout() Function
    public void TransactionLayout() {
        accountTransactionPanel.setLayout(null);
        lblTransactionAccountNumber.setBounds(200, 100, 200, 30);
        txtTransactionAccountNumber.setBounds(400, 100, 200, 30);
        btnGetDetails.setBounds(400, 135, 200, 30);

        lblAccountHoldersName.setBounds(200, 170, 200, 30);
        txtAccountHoldersName.setBounds(400, 170, 200, 30);
        lblCurrentBalance.setBounds(200, 205, 200, 30);
        txtCurrentBalance.setBounds(400, 205, 200, 30);
        lblTransactionDate.setBounds(200, 240, 200, 30);
        txtTransactionDate.setBounds(400, 240, 200, 30);
        lblTransactionType.setBounds(200, 275, 200, 30);
        cmbTransactionType.setBounds(400, 275, 200, 30);
        lblTransactionMode.setBounds(200, 310, 200, 30);
        cmbTransactionMode.setBounds(400, 310, 200, 30);

        lblTransactionAmount.setBounds(200, 345, 300, 30);
        txtTransactionAmount.setBounds(400, 345, 200, 30);
        btnSubmit.setBounds(200, 380, 190, 30);
        btnReset2.setBounds(410, 380, 190, 30);
    } // transaction layout ends

    // controlPanelLayout() Function
    public void controlPanelLayout() {
        controlPanel.setLayout(null);
        rCreateUser.setBounds(100, 100, 300, 30);
        lblNewId.setBounds(200, 135, 200, 30);
        txtNewId.setBounds(400, 135, 200, 30);
        lblNewPassword.setBounds(200, 170, 200, 30);
        txtNewPassword.setBounds(400, 170, 200, 30);
        btnCreateNewLogin.setBounds(200, 205, 190, 30);
        btnReset4.setBounds(400, 205, 200, 30);

        rDeleteUser.setBounds(100, 310, 300, 30);

        lblDelLoginId.setBounds(200, 345, 300, 30);
        txtDelLoginId.setBounds(400, 345, 200, 30);
        btnDeleteUser.setBounds(400, 380, 200, 30);
    } // control panel layout ends

    // accountDetailsLayout() Function
    public void accountDetailsLayout() {
        displayDetailsPanel.setLayout(null);
        lblAccountNumber.setBounds(200, 205, 200, 30);
        txtAccountNumberDet.setBounds(400, 205, 200, 30);
        btnSearch.setBounds(200, 240, 190, 30);
        btnReset3.setBounds(400, 240, 200, 30);
    } // account details layout ends

    // logoutPanelLayout() Function
    public void logoutPanelLayout() {
        logoutPanel.setLayout(null);
        lblExitApps.setBounds(200, 240, 200, 30);
        btnExitApps.setBounds(400, 240, 200, 30);
    } // exit panel layout ends

    public static void main(String args[]) {
        bank_mysql mybank = new bank_mysql();
    }
} // class bank_mysql ends

//************************************************************	
//					code ends
//************************************************************	
// 1. 	first create database (bankdb with table) in MySQL using bank_mysql.sql file.
//
// 2.	Command to Compile : 
//		>javac -cp ".;mysql.jar"  bank_mysql.java
// 3.	Command to Run : 
//		>java -cp ".;mysql.jar" bank_mysql

//************************************************************	
