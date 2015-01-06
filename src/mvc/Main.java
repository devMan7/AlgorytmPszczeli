package mvc;

import javax.swing.JFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(model, view);

	}

}
