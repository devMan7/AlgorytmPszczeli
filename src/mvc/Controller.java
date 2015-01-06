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
	
	public void runModel(String fromX, String toX){
		view.showResult(model.getResult(fromX, toX));
	}
	

}
