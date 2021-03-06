package hu.bme.mit.yakindu.analysis.workhere;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.yakindu.base.types.Direction;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import hu.bme.mit.model2gml.Model2GML;
import hu.bme.mit.yakindu.analysis.modelmanager.ModelManager;

public class Main {
	@Test
	public void test() {
		main(new String[0]);
	}
	
	public static void main(String[] args) {
		//main_task2();
		BigModelMain.Main();
	}
	
	public static void main_task2() {
		ModelManager manager = new ModelManager();
		Model2GML model2gml = new Model2GML();
		
		// Loading model
		EObject root = manager.loadModel("model_input/example.sct");
		
		// Reading model
		Statechart s = (Statechart) root;
		TreeIterator<EObject> iterator = s.eAllContents();
		ArrayList<String> nodes = new ArrayList<>();
		int iter_number = 0;
		while (iterator.hasNext()) {
			EObject content = iterator.next();
			
			if(content instanceof State) {
				State state = (State) content;
				if(state.getName().equals("")) {
					state.setName(String.valueOf(iter_number));
					iter_number++;
				}
				if(state.getOutgoingTransitions().size()==0) {
					nodes.add(state.getName());
				}
				System.out.println(state.getName());
			}
			if(content instanceof Vertex) {
				Vertex transition = (Vertex) content;
				EList<Transition> out = transition.getOutgoingTransitions();
				
				for(int i=0;i<out.size();i++){
					System.out.println(out.get(i).getSource().getName() + " -> " + out.get(i).getTarget().getName());
				}
			}
			System.out.println();
		}
		
		if(nodes.size()>0) {
			for(int i = 0; i < nodes.size(); i++) {
				System.out.println(nodes.get(i));
			}
		}
		// Transforming the model into a graph representation
		String content = model2gml.transform(root);
		// and saving it
		manager.saveFile("model_output/graph.gml", content);
	}
}
