package com.thread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class ProgressBarDemo extends JApplet {

	/**
	 * TODO 变量名称
	 */
	private static final long serialVersionUID = -7566613194915466486L;

	private JProgressBar jpb = new JProgressBar();
	private JTextArea jtaResult = new JTextArea();
	private JTextField jtfPrimeCount = new JTextField(8);
	private JButton jbtDisplayPrime = new JButton("Dispaly Prime");

	public ProgressBarDemo() {
		jpb.setStringPainted(true);
		jpb.setValue(0);
		jpb.setMaximum(100);

		jtaResult.setWrapStyleWord(true);
		jtaResult.setLineWrap(true);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter the prime number count"));
		panel.add(jtfPrimeCount);
		panel.add(jbtDisplayPrime);

		add(jpb, BorderLayout.NORTH);
		add(new JScrollPane(jtaResult), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		jbtDisplayPrime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ComputerPrime task = new ComputerPrime(Integer.parseInt(jtfPrimeCount.getText()), jtaResult);
				
				task.addPropertyChangeListener(new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if ("progress".equals(evt.getPropertyName())) {
							jpb.setValue((Integer)evt.getNewValue());
						}
					}
				});
				
				task.execute();
			}
		});
	}

	static class ComputerPrime extends SwingWorker<Integer, Integer> {
		private int count;
		private JTextArea result;

		public ComputerPrime(int count, JTextArea result) {
			super();
			this.count = count;
			this.result = result;
		}

		@Override
		protected Integer doInBackground() throws Exception {
			publishPrimeNumbers(count);
			return 0;
		}

		@Override
		protected void process(List<Integer> chunks) {
			for (int i = 0; i < chunks.size(); i++) {
				result.append(chunks.get(i) + " ");
			}
		}

		private void publishPrimeNumbers(int n) {
			int count = 0;
			int number = 2;
			while (count <= n) {
				if (isPrime(number)) {
					count++;
					setProgress(100 * count / n);
					publish(number);
				}
				number++;
			}
		}

		private boolean isPrime(int number) {
			for (int divsor = 2; divsor <= number / 2; divsor++) {
				if (number % divsor == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
