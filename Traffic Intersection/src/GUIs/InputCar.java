package GUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataOnly.Car;
import DataOnly.CarQueue;
import Utilities.DataOverNetwork;

import javax.swing.JTextPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

public class InputCar extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputCar frame = new InputCar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder("INPUT CAR"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtNumber = new JTextPane();
		txtNumber.setText("number");
		txtNumber.setToolTipText("");
		txtNumber.setBounds(10, 92, 285, 20);
		contentPane.add(txtNumber);

		JTextPane petriname = new JTextPane();
		petriname.setText("1080");
		petriname.setBounds(10, 159, 285, 20);
		contentPane.add(petriname);

		JTextPane txtModel = new JTextPane();
		txtModel.setText("model");
		txtModel.setBounds(10, 61, 285, 20);
		contentPane.add(txtModel);

		JTextPane txtTarget = new JTextPane();
		txtTarget.setToolTipText("");
		txtTarget.setText("target");
		txtTarget.setBounds(10, 123, 450, 20);
		contentPane.add(txtTarget);

		JTextPane txtPlace = new JTextPane();
		txtPlace.setText("P");
		txtPlace.setBounds(10, 21, 285, 20);
		contentPane.add(txtPlace);
		JCheckBox priority = new JCheckBox("Priority");
		priority.setBounds(10, 186, 97, 23);
		contentPane.add(priority);
		JCheckBox bus = new JCheckBox("Bus");
		bus.setBounds(10, 212, 97, 23);
		contentPane.add(bus);
		JCheckBox taxi = new JCheckBox("Taxi");
		taxi.setBounds(10, 238, 97, 23);
		contentPane.add(taxi);
		JCheckBox tram = new JCheckBox("Tram");
		tram.setBounds(10, 269, 97, 23);
		contentPane.add(tram);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socket s;
				try {
					s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(petriname.getText()));
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					DataOverNetwork DataToSend = new DataOverNetwork();

//					DataCarQueue tempQueue = new DataCarQueue();
					DataCar temp = new DataCar();
					Car c = new Car(txtModel.getText(), txtNumber.getText(), txtTarget.getText().split(","), taxi.isSelected(), bus.isSelected(), priority.isSelected(), tram.isSelected());
					temp.SetValue(c);
					temp.SetName(txtPlace.getText());

//					tempQueue.AddElement(temp);
//					tempQueue.SetName(txtPlace.getText());

					DataToSend.petriObject = temp;

					DataToSend.NetWorkPort = Integer.parseInt(petriname.getText());
					oos.writeObject(DataToSend);
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(10, 298, 285, 44);
		contentPane.add(btnSend);



	}
}