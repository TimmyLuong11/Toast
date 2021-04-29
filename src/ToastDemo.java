import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ToastDemo extends JFrame implements ChangeListener
{
	private JButton b1;
	private JButton b2;
	private JTextArea text;
	private JSlider slider;
	private Font f32 = new Font("SansSarif", Font.BOLD, 32);
	private JList list;
	
	public ToastDemo()
	{
		initFrame();
		setButtons();
		setSlider();
		setText();
		setList();
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.WEST);
		add(text, BorderLayout.CENTER);
		add(list, BorderLayout.EAST);
		add(slider, BorderLayout.SOUTH);
		//setVisible(true);
	}

	private void setList() 
	{
		DefaultListModel model = new DefaultListModel();
		String[] strs = {"Norman", "OklahomaCity", "Edmond", "Yukon", "El Reno"};
		for(String str: strs)
		{
			model.addElement(str);
		}
		list = new JList<String>(model);
		list.setFont(f32);
		list.addListSelectionListener(new ListSelectionListener()
		{	
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				String s = (String) list.getSelectedValue();
				text.setText(s);
				
			}
		});
		
	}

	private void setText() 
	{
		text = new JTextArea("This could be a toast:");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setFont(f32);
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	private void setSlider() 
	{
		slider = new JSlider(0, 20, 40, 20);	
	}

	private void setButtons()
	{
		b1 = new JButton("b1");
		b1.setFont(f32);
		b2 = new JButton("b2");
		b2.setFont(f32);
		b1.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int rel = JOptionPane.showConfirmDialog(ToastDemo.this, "Do you want to check it?", "Yes, I do", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				text.setText("Option: "+ rel);
			}
		});
		
		b2.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Color color = JColorChooser.showDialog(ToastDemo.this, "Choose Background Color", b2.getBackground());
				b2.setBackground(color);
			}
		});
	}
	
	private void initFrame()
	{
		setSize(700, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		ToastDemo demo = new ToastDemo();
		demo.revalidate();
	}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		
		
	} 
}
