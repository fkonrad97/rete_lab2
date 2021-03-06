package hu.bme.mit.yakindu.analysis.workhere;

import hu.bme.mit.yakindu.analysis.modelmanager.ModelManager;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Direction;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class BigModelMain {
	
	public static void Main() {
		ModelManager manager = new ModelManager();
		EObject root = manager.loadModel("model_input/example.sct");
		Statechart s = (Statechart) root;
		

		//print(s);
		events_variables(s);
		//new Task4_5().add().print();
	}
	
	public static void print(Statechart s) {
		TreeIterator<EObject> iterator = s.eAllContents();
		System.out.println("public static void print(IExampleStatemachine s) {");
		while (iterator.hasNext()) {
			EObject content = iterator.next();
			if(content instanceof VariableDefinition) {
				VariableDefinition b = (VariableDefinition) content;
				System.out.println("System.out.println(\""+b.getName().charAt(0)+" = \" + s.getSCInterface().get"+b.getName()+"());");
			}
		}
		System.out.println("}");
	}
	
	public static void events_variables(Statechart s) {
		TreeIterator<EObject> iter = s.eAllContents();
		while(iter.hasNext()) {
			EObject content = iter.next();
			if(content instanceof EventDefinition) {
				EventDefinition event = (EventDefinition) content;
				if(event.getDirection().equals(Direction.IN)) {
					System.out.println(event.getName());
				}else if(content instanceof VariableDefinition) {
					VariableDefinition var = (VariableDefinition) content;
					System.out.println(var.getName());
				}
			}
		}
	}
}
