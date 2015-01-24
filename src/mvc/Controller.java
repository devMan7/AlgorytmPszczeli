package mvc;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		view.setController(this);
	}
	
	public void runModel(double fromX, double toX, String function, int iloscIteracji){
		view.showResult(model.getResult(fromX, toX, function, iloscIteracji));
	}
	

}
