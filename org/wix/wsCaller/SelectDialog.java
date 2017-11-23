package org.wix.wsCaller;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import javax.swing.border.*;
import java.awt.event.*;

public class SelectDialog
	extends JDialog
{
	Frame parent = null;

	Vector candidates = null;
	String message = "MESSAGE";
	String result = null;

	JPanel panel1 = new JPanel();
	BorderLayout borderLayout1 = new BorderLayout();
	BorderLayout borderLayout2 = new BorderLayout();
	JLabel lblMessage = new JLabel();
	JPanel jPanel1 = new JPanel();
	FlowLayout flowLayout1 = new FlowLayout();
	Border border1;
	JButton btnCancel = new JButton();
	JButton btnOK = new JButton();
	JScrollPane jScrollPane1 = new JScrollPane();
	JList list = new JList();
	Border border2;

	private void centerDialog()
	{
		Point parentLocation;
		Dimension parentSize;
		if (parent == null)
		{
			parentLocation = new Point(0, 0);
			parentSize = Toolkit.getDefaultToolkit().getScreenSize();
		}
		else
		{
			parentLocation = getParent().getLocation();
			parentSize = getParent().getSize();
		}
		Dimension size = getSize();
		setLocation(parentLocation.x + parentSize.width / 2 -
					size.width / 2,
					parentLocation.y + parentSize.height / 2 -
					size.height / 2);
	}

	public SelectDialog(Frame parent, String title,
						Vector candidates, String message)
	{
		super(parent, title);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.parent = parent;
		this.candidates = candidates;
		this.message = message;
		try
		{
			jbInit();
			pack();
			centerDialog();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void jbInit() throws Exception
	{
		border1 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,
												  Color.white, Color.white,
												  new Color(115, 114, 105),
												  new Color(165, 163, 151));
		panel1.setLayout(borderLayout1);
		this.getContentPane().setLayout(borderLayout2);
		lblMessage.setText(message);
		jPanel1.setLayout(flowLayout1);
		borderLayout1.setHgap(5);
		borderLayout1.setVgap(5);
		panel1.setBorder(border1);
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		btnCancel.setText("Cancel");
		btnCancel.addActionListener(new SelectDialog_btnCancel_actionAdapter(this));
		btnOK.setText("OK");
		btnOK.addActionListener(new SelectDialog_btnOK_actionAdapter(this));
		list.setBorder(null);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setListData(candidates);
		this.setModal(true);
		this.setResizable(false);
		jScrollPane1.setBorder(border2);
		jPanel1.add(btnOK, null);
		panel1.add(lblMessage, BorderLayout.NORTH);
		panel1.add(jPanel1, BorderLayout.SOUTH);
		jPanel1.add(btnCancel, null);
		jScrollPane1.getViewport().add(list, null);
		panel1.add(jScrollPane1, BorderLayout.CENTER);
		getContentPane().add(panel1, BorderLayout.CENTER);
		setSize(400, 280);
	}

	protected void processWindowEvent(WindowEvent e)
	{
		if (e.getID() == WindowEvent.WINDOW_CLOSING)
		{
			result = null;
			dispose();
		}
		super.processWindowEvent(e);
	}

	void btnOK_actionPerformed(ActionEvent e)
	{
		result = (String) list.getSelectedValue();
		if (result == null)
		{
			JOptionPane.showMessageDialog(this, "No item selected.", "INFO",
										  JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			dispose();
		}
	}

	void btnCancel_actionPerformed(ActionEvent e)
	{
		result = null;
		dispose();
	}
}

class SelectDialog_btnOK_actionAdapter
	implements java.awt.event.ActionListener
{
	SelectDialog adaptee;

	SelectDialog_btnOK_actionAdapter(SelectDialog adaptee)
	{
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e)
	{
		adaptee.btnOK_actionPerformed(e);
	}
}

class SelectDialog_btnCancel_actionAdapter
	implements java.awt.event.ActionListener
{
	SelectDialog adaptee;

	SelectDialog_btnCancel_actionAdapter(SelectDialog adaptee)
	{
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e)
	{
		adaptee.btnCancel_actionPerformed(e);
	}
}