package PROJ5.pedestrianControl;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Lane {
	public static void main(String[] args) {
		
		//--------------------------------------------------------------------
		//-------------------------------Lane1--------------------------------
		//--------------------------------------------------------------------
		
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Main Petri";
		pn.NetworkPort = 1080;
		
		DataCar p1 = new DataCar();
		p1.SetName("P_a1");
		pn.PlaceList.add(p1);

		DataCarQueue p2 = new DataCarQueue();
		p2.Value.Size = 3;
		p2.SetName("P_x1");
		pn.PlaceList.add(p2);

		DataString p3 = new DataString();
		p3.SetName("P_TL1");
		pn.PlaceList.add(p3);

		DataCar p4 = new DataCar();
		p4.SetName("P_b1");
		pn.PlaceList.add(p4);

		DataString UserReq = new DataString();
		UserReq.SetName("UserReq");
		pn.PlaceList.add(UserReq);

		DataString P_PTL = new DataString();
		P_PTL.SetName("P_PTL");
		pn.PlaceList.add(P_PTL);

		DataTransfer OPReq = new DataTransfer();
		OPReq.SetName("OPReq");
		OPReq.Value = new TransferOperation("localhost", "1081" , "UserReq");
		pn.PlaceList.add(OPReq);

		DataString full = new DataString();
		full.SetName("full");
		full.SetValue("full");
		pn.ConstantPlaceList.add(full);
		
		DataString green= new DataString();
		green.SetName("green");
		green.SetValue("green");
		green.Printable= false;
		pn.ConstantPlaceList.add(green);
		
		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "T_u1";
		t1.InputPlaceName.add("P_a1");
		t1.InputPlaceName.add("P_x1");

		Condition T1Ct1 = new Condition(t1, "P_a1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "P_x1", TransitionCondition.CanAddCars);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition= T1Ct1;
		grdT1.Activations.add(new Activation(t1, "P_a1", TransitionOperation.AddElement, "P_x1"));
		t1.GuardMappingList.add(grdT1);
		
		t1.Delay = 0;
		pn.Transitions.add(t1);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "T_e1";
		t2.InputPlaceName.add("P_x1");
		t2.InputPlaceName.add("P_TL1");
		t2.InputPlaceName.add("UserReq");
		t2.InputPlaceName.add("P_PTL");

		
		Condition T2Ct1 = new Condition(t2, "P_TL1", TransitionCondition.Equal,"green");
		Condition T2Ct2 = new Condition(t2, "P_x1", TransitionCondition.HaveCar);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition= T2Ct1;
		grdT2.Activations.add(new Activation(t2, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
		grdT2.Activations.add(new Activation(t2, "P_TL1", TransitionOperation.Move, "P_TL1"));
		grdT2.Activations.add(new Activation(t2, "P_PTL", TransitionOperation.Move, "P_PTL"));

		t2.GuardMappingList.add(grdT2);

		Condition T2Ct3 = new Condition(t2, "UserReq", TransitionCondition.NotNull);

		GuardMapping grd2T2 = new GuardMapping();
		grd2T2.condition = T2Ct3;

		grd2T2.Activations.add(new Activation(t2, "P_TL1", TransitionOperation.Move, "P_TL1"));
		grd2T2.Activations.add(new Activation(t2, "P_PTL", TransitionOperation.Move, "P_PTL"));
		grd2T2.Activations.add(new Activation(t2, "UserReq", TransitionOperation.SendOverNetwork, "OPReq"));

		t2.GuardMappingList.add(grd2T2);

		t2.Delay = 1;
		pn.Transitions.add(t2);
		
		
		
		//-------------------------------------------------------------------------------------
		//----------------------------PN Start-------------------------------------------------
		//-------------------------------------------------------------------------------------

		System.out.println("Lane started \n ------------------------------");
		pn.Delay = 2000;
		//pn.Start();
		
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}
}
