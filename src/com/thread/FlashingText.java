package com.thread;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class FlashingText extends JApplet implements Runnable {

	/**
	 * TODO 变量名称
	 */
	private static final long serialVersionUID = -2268405080135359891L;

	private JLabel jLabelText = new JLabel("Welcome", JLabel.CENTER);

	@Override
	public void init() {
		add(jLabelText);
		new Thread(this).start();
		System.gc();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			while (true) {
				if (jLabelText.getText() == null) {
					jLabelText.setText("Welcome");
				} else {
					jLabelText.setText(null);
				}
			}
		} catch (InterruptedException e) {
		}
	}

}
