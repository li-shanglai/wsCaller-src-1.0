package org.wix.wsCaller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame_AboutBox
	extends JDialog
	implements ActionListener
{
	Frame parent = null;

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel insetsPanel1 = new JPanel();
	JPanel insetsPanel2 = new JPanel();
	JPanel insetsPanel3 = new JPanel();
	JButton button1 = new JButton();
	JLabel imageLabel = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	ImageIcon image1 = new ImageIcon();
	BorderLayout borderLayout1 = new BorderLayout();
	FlowLayout flowLayout1 = new FlowLayout();
	GridLayout gridLayout1 = new GridLayout();
	FlowLayout flowLayout2 = new FlowLayout();
	public MainFrame_AboutBox(Frame parent)
	{
		super(parent);
		this.parent = parent;
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try
		{
			jbInit();
			pack();
			centerDialog();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

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

	//Component initialization
	private void jbInit() throws Exception
	{
		image1 = new ImageIcon(org.wix.wsCaller.MainFrame.class.getResource(
			"about.png"));
		imageLabel.setIcon(image1);

		this.setModal(true);
		this.setTitle("About");
		panel1.setLayout(borderLayout1);
		panel2.setLayout(flowLayout2);
		insetsPanel1.setLayout(flowLayout1);
		insetsPanel2.setLayout(flowLayout1);
		insetsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		gridLayout1.setRows(2);
		gridLayout1.setVgap(5);
		gridLayout1.setColumns(1);
		gridLayout1.setHgap(5);
		label2.setMaximumSize(new Dimension(120, 16));
		label2.setMinimumSize(new Dimension(120, 16));
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setHorizontalTextPosition(SwingConstants.LEFT);
		label2.setText("wsCaller 1.0");
		label3.setMaximumSize(new Dimension(120, 16));
		label3.setMinimumSize(new Dimension(120, 16));
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		label3.setHorizontalTextPosition(SwingConstants.LEFT);
		label3.setText("(C) 2003 Wang Yong Gang");
		insetsPanel3.setLayout(gridLayout1);
		insetsPanel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		insetsPanel3.setMinimumSize(new Dimension(200, 60));
		insetsPanel3.setPreferredSize(new Dimension(200, 60));
		insetsPanel3.setRequestFocusEnabled(true);
		button1.setText("Ok");
		button1.addActionListener(this);
		panel2.setMinimumSize(new Dimension(300, 72));
		panel2.setPreferredSize(new Dimension(300, 72));
		panel2.add(insetsPanel2, null);
		insetsPanel2.add(imageLabel, null);
		panel1.setMinimumSize(new Dimension(300, 140));
		panel1.setPreferredSize(new Dimension(300, 140));
		insetsPanel3.add(label2, null);
		insetsPanel3.add(label3, null);
		panel2.add(insetsPanel3, null);
		insetsPanel1.add(button1, null);
		panel1.add(insetsPanel1, BorderLayout.SOUTH);
		panel1.add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel1, null);
		this.setSize(300, 140);
		setResizable(false);
	}

	//Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e)
	{
		if (e.getID() == WindowEvent.WINDOW_CLOSING)
		{
			cancel();
		}
		super.processWindowEvent(e);
	}

	//Close the dialog
	void cancel()
	{
		dispose();
	}

	//Close the dialog on a button event
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == button1)
		{
			cancel();
		}
	}
}