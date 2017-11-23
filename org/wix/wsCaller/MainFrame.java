package org.wix.wsCaller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.event.*;

import org.apache.axis.wsdl.symbolTable.*;

public class MainFrame extends JFrame {
    DynamicInvoker invoker = null;
    String location = null;
    String serviceName = null;
    String portName = null;
    String operationName = null;
    Parameters parameters = null;
    JTextField[] txtParameterValues = null;

    JPanel contentPane;
    Border border1;
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel paneNorth = new JPanel();
    JPanel paneSouth = new JPanel();
    JButton btnExit = new JButton();
    JButton btnAbout = new JButton();
    JButton btnTest = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JTextField txtLocation = new JTextField();
    JButton btnFind = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    Border border2;
    JLabel jLabel4 = new JLabel();
    JComboBox comboService = new JComboBox();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JComboBox comboOperation = new JComboBox();
    JLabel jLabel7 = new JLabel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    GridLayout gridLayout1 = new GridLayout();
    Border border3;
    JPanel paneCenter = new JPanel();
    GridLayout gridLayoutCenter = new GridLayout();
    Border border4;
    JTextField txtTimes = new JTextField();

    //Construct the frame
    public MainFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Component initialization
    private void jbInit() throws Exception {
        contentPane = (JPanel) this.getContentPane();
        border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        border2 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        border3 = BorderFactory.createEmptyBorder(0, 3, 0, 5);
        border4 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        contentPane.setBorder(border2);
        contentPane.setMinimumSize(new Dimension(600, 450));
        contentPane.setPreferredSize(new Dimension(600, 450));
        contentPane.setLayout(borderLayout1);
        this.setContentPane(contentPane);
        this.setResizable(false);
        this.setSize(new Dimension(600, 450));
        this.setState(Frame.NORMAL);
        this.setTitle("wsCaller - A Simple Web Service Invoker/Tester");
        paneNorth.setLayout(gridBagLayout1);
        paneSouth.setLayout(gridLayout1);
        btnExit.setText("Exit");
        btnExit.addActionListener(new MainFrame_btnExit_actionAdapter(this));
        btnAbout.setText("About");
        btnAbout.addActionListener(new MainFrame_btnAbout_actionAdapter(this));
        btnTest.setText("Invoke");
        btnTest.addActionListener(new MainFrame_btnTest_actionAdapter(this));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("Invoke Times:");
        jLabel2.setRequestFocusEnabled(true);
        jLabel2.setToolTipText("");
        jLabel2.setText("");
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("WSDL Location:");
        txtLocation.setMinimumSize(new Dimension(350, 22));
        txtLocation.setPreferredSize(new Dimension(350, 22));
        txtLocation.setText("");
        btnFind.setText("Find");
        btnFind.addActionListener(new MainFrame_btnFind_actionAdapter(this));
        borderLayout1.setHgap(5);
        borderLayout1.setVgap(5);
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Service:");
        comboService.setMinimumSize(new Dimension(350, 22));
        comboService.setPreferredSize(new Dimension(350, 22));
        comboService.setEditable(false);
        comboService.addActionListener(new MainFrame_comboService_actionAdapter(this));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Operation:");
        comboOperation.setMinimumSize(new Dimension(350, 22));
        comboOperation.setPreferredSize(new Dimension(350, 22));
        comboOperation.setEditable(false);
        comboOperation.addActionListener(new
                MainFrame_comboOperation_actionAdapter(this));
        jLabel5.setText("");
        jLabel7.setText("");
        gridLayout1.setColumns(7);
        gridLayout1.setHgap(10);
        paneCenter.setLayout(gridLayoutCenter);
        gridLayoutCenter.setColumns(1);
        gridLayoutCenter.setHgap(3);
        gridLayoutCenter.setRows(1);
        gridLayoutCenter.setVgap(3);
        paneCenter.setBackground(Color.white);
        paneCenter.setBorder(border4);
        txtTimes.setText("1");
        txtTimes.setHorizontalAlignment(SwingConstants.RIGHT);
        paneSouth.add(btnAbout, null);
        paneSouth.add(jLabel1, null);
        paneSouth.add(txtTimes, null);
        paneSouth.add(btnTest, null);
        paneSouth.add(jLabel2, null);
        contentPane.add(paneNorth, BorderLayout.NORTH);
        contentPane.add(paneSouth, BorderLayout.SOUTH);
        contentPane.add(jScrollPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(paneCenter, null);
        paneNorth.add(jLabel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 3), 30, 9));
        paneNorth.add(txtLocation, new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 0), 400, 3));
        paneNorth.add(btnFind, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 5, 5, 5), 30, 0));
        paneNorth.add(jLabel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 30, 9));
        paneNorth.add(comboService, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 0), 400, 3));
        paneNorth.add(jLabel5, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 1), 50, 25));
        paneNorth.add(jLabel6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 30, 9));
        paneNorth.add(comboOperation,
                new GridBagConstraints(1, 2, 2, 1, 1.0, 0.0
                        , GridBagConstraints.WEST,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 400, 3));
        paneNorth.add(jLabel7, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 1), 50, 25));
        paneSouth.add(btnExit, null);
    }

    //Overridden so we can exit when window is closed
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    void btnExit_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    void btnAbout_actionPerformed(ActionEvent e) {
        MainFrame_AboutBox dlg = new MainFrame_AboutBox(this);
        dlg.show();
    }

    void btnFind_actionPerformed(ActionEvent e) {
        String location = txtLocation.getText();
        if (location == null || (location = location.trim()).length() == 0) {
            JOptionPane.showMessageDialog(this, "Location is empty.",
                    "WARNING",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            location = txtLocation.getText();
            invoker = new DynamicInvoker(location);
            Vector v = invoker.enumServiceNames();
            comboService.removeAllItems();
            comboOperation.removeAllItems();
            serviceName = portName = operationName = null;
            if (v.size() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No Service found at this location.",
                        "WARNING",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            Object[] ss = v.toArray();
            Arrays.sort(ss);
            int len = ss.length;
            for (int i = 0; i < len; i++) {
                comboService.addItem((String) ss[i]);
            }
            comboService.setSelectedIndex(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass().getName()
                            + ": " + ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String selectEntry(Vector v, String entryName) {
        if (v.size() == 0) {
            return null;
        } else if (v.size() > 1) {
            SelectDialog dlg = new SelectDialog(this,
                    entryName,
                    v,
                    "Select a " + entryName +
                            " from this list:");
            dlg.show();
            return dlg.result;
        } else {
            return (String) v.elementAt(0);
        }
    }

    void comboService_actionPerformed(ActionEvent e) {
        try {
            serviceName = (String) comboService.getSelectedItem();
            if (serviceName == null) {
                return;
            }
            Vector v = invoker.enumPortNames(serviceName);

            portName = selectEntry(v, "Port");
            if (portName == null) {
                JOptionPane.showMessageDialog(this,
                        "No port found in service " +
                                serviceName,
                        "WARNING",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            v = invoker.enumOperationNames(serviceName, portName);
            comboOperation.removeAllItems();
            Object[] ss = v.toArray();
            Arrays.sort(ss);
            int len = ss.length;
            for (int i = 0; i < len; i++) {
                comboOperation.addItem((String) ss[i]);
            }
            comboOperation.setSelectedIndex(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass().getName()
                            + ": " + ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    void comboOperation_actionPerformed(ActionEvent e) {
        try {
            operationName = (String) comboOperation.getSelectedItem();
            if (serviceName == null || operationName == null
                    || portName == null) {
                return;
            }
            parameters = invoker.enumParameters(serviceName, portName,
                    operationName);
            if (parameters == null) {
                return;
            }
            Vector v = parameters.list;
            int size = v.size();
            if (size == 0) {
                paneCenter.removeAll();
                gridLayoutCenter.setRows(10);
                paneCenter.add(new JLabel("This operation has no parameter."));
            } else {
                paneCenter.removeAll();
                gridLayoutCenter.setRows(Math.max(size, 10));
                txtParameterValues = new JTextField[size];
                for (int i = 0; i < size; i++) {
                    Parameter para = (Parameter) v.elementAt(i);
                    JPanel p = new JPanel();
                    p.setLayout(new FlowLayout(FlowLayout.LEFT));
                    p.setBorder(new EtchedBorder());
                    p.add(new JLabel("Parameter " + (i + 1) + ":"));
                    JTextField tf = new JTextField("", 10);
                    tf.setEditable(false);
                    tf.setText(para.getQName().getLocalPart());
                    p.add(tf);
                    p.add(new JLabel("Type:"));
                    tf = new JTextField("", 10);
                    tf.setEditable(false);

                    String wsdlType = para.getType().getQName().getLocalPart();
                    String mode = invoker.getParameterModeString(para);
                    tf.setText(mode + " " + wsdlType);
                    p.add(tf);
                    if (para.getMode() != Parameter.OUT) {
                        // for IN and INOUT parameters
                        p.add(new JLabel("Value:"));
                        txtParameterValues[i] = new JTextField("", 10);
                        p.add(txtParameterValues[i]);
                    } else {
                        txtParameterValues[i] = null;
                    }
                    paneCenter.add(p);
                }
            }
            validate();
            repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass().getName()
                            + ": " + ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    void btnTest_actionPerformed(ActionEvent e) {
        // Begin invoking or testing
        if (invoker == null || serviceName == null
                || portName == null || operationName == null
                || parameters == null) {
            JOptionPane.showMessageDialog(this,
                    "Please specify location/service/operation and " +
                            "assign values to all the parameters " +
                            "before invoking/testing.",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int times = 0;
        try {
            times = Integer.parseInt(txtTimes.getText());
        } catch (NumberFormatException ex1) {
            times = 0;
        }
        if (times <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Invoke times must be larger than zero.",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vector parameterValues = new Vector();
        Vector v = parameters.list;
        int paraNumbers = v.size();
        if (txtParameterValues != null) {
            for (int i = 0; i < paraNumbers; i++) {
                if (txtParameterValues[i] != null) {
                    String value = txtParameterValues[i].getText();
                    if (value == null || (value = value.trim()).length() == 0) {
                        JOptionPane.showMessageDialog(this,
                                "Please assign a value to paramter " + (i + 1),
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    parameterValues.addElement(value);
                }
            }
        }
        try {
            Map outputs = null;
            long begin = Calendar.getInstance().getTime().getTime();
            for (int i = 0; i < times; i++) {
                outputs = invoker.invoke(serviceName, portName,
                        operationName, parameterValues);
            }
            long end = Calendar.getInstance().getTime().getTime();
            long span = end - begin;
            ResultDialog dlg = new ResultDialog(this, "RESULT", outputs,
                    span, times);
            dlg.show();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass().getName()
                            + ": " + ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class MainFrame_btnExit_actionAdapter
        implements java.awt.event.ActionListener {
    MainFrame adaptee;

    MainFrame_btnExit_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnExit_actionPerformed(e);
    }
}

class MainFrame_btnAbout_actionAdapter
        implements java.awt.event.ActionListener {
    MainFrame adaptee;

    MainFrame_btnAbout_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnAbout_actionPerformed(e);
    }
}

class MainFrame_btnFind_actionAdapter
        implements java.awt.event.ActionListener {
    MainFrame adaptee;

    MainFrame_btnFind_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnFind_actionPerformed(e);
    }
}

class MainFrame_comboService_actionAdapter
        implements java.awt.event.ActionListener {
    MainFrame adaptee;

    MainFrame_comboService_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.comboService_actionPerformed(e);
    }
}

class MainFrame_comboOperation_actionAdapter
        implements java.awt.event.ActionListener {
    MainFrame adaptee;

    MainFrame_comboOperation_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.comboOperation_actionPerformed(e);
    }
}

class MainFrame_btnTest_actionAdapter
        implements java.awt.event.ActionListener {
    MainFrame adaptee;

    MainFrame_btnTest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnTest_actionPerformed(e);
    }
}
