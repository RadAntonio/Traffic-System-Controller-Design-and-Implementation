package PROJECT_FINAL;

import Components.PetriNet;
import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Lanes_Intersection_Bucharest {

    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Lanes Intersection Bucharest";
        pn.NetworkPort = 1080;

        // -------------------------------------------------------------------
        // --------------------CALEA FERENTARI SECTION 1----------------------
        // -------------------------------------------------------------------

        DataString red = new DataString();
        //red.Printable = false;
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        //green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        //yellow.Printable = false;
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);

        DataString full = new DataString();
        full.Printable = false;
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);

        //------------------VEST--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_S1 = new DataCar();
        P_LaneIn_S1.SetName("P_LaneIn_S1");
        pn.PlaceList.add(P_LaneIn_S1);

        DataCarQueue P_Lane_DunuvatIn_V_S1 = new DataCarQueue();
        P_Lane_DunuvatIn_V_S1.Value.Size = 2;
        P_Lane_DunuvatIn_V_S1.SetName("P_Lane_DunuvatIn_V_S1");
        pn.PlaceList.add(P_Lane_DunuvatIn_V_S1);

        //----------------------------T0_In_V_S1---------------------------------------- //T0
        PetriTransition T0_In_V_S1 = new PetriTransition(pn);
        T0_In_V_S1.TransitionName = "T0_In_V_S1";
        T0_In_V_S1.InputPlaceName.add("P_LaneIn_S1");
        T0_In_V_S1.InputPlaceName.add("P_Lane_DunuvatIn_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T0_In_V_S1_Ct11 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.NotNull);
        Condition T0_In_V_S1_Ct12 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.DontHaveCar);
        Condition T0_In_V_S1_Ct13 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct13);
        T0_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct12);
        GuardMapping grd1T0_In_V_S1 = new GuardMapping();
        grd1T0_In_V_S1.condition = T0_In_V_S1_Ct11;
        grd1T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_LaneIn_S1", TransitionOperation.AddElement, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd1T0_In_V_S1);

        // --------------guard 2-------------------------------------------------------
        Condition T0_In_V_S1_Ct21 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.IsNull);
        Condition T0_In_V_S1_Ct22 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.HaveCar);
        Condition T0_In_V_S1_Ct23 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct23);
        T0_In_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct22);
        GuardMapping grd2T0_In_V_S1 = new GuardMapping();
        grd2T0_In_V_S1.condition = T0_In_V_S1_Ct21;
        grd2T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd2T0_In_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T0_In_V_S1_Ct31 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.NotNull);
        Condition T0_In_V_S1_Ct32 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.HavePriorityCar);
        Condition T0_In_V_S1_Ct33 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct33);
        T0_In_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct32);
        GuardMapping grd3T0_In_V_S1 = new GuardMapping();
        grd3T0_In_V_S1.condition = T0_In_V_S1_Ct31;
        grd3T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S1"));
        grd3T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_LaneIn_S1", TransitionOperation.AddElement, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd3T0_In_V_S1);

        // --------------guard 4-------------------------------------------------------
        Condition T0_In_V_S1_Ct41 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.NotNull);
        Condition T0_In_V_S1_Ct42 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.HaveCar);
        Condition T0_In_V_S1_Ct43 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct43);
        T0_In_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct42);
        GuardMapping grd4T0_In_V_S1 = new GuardMapping();
        grd4T0_In_V_S1.condition = T0_In_V_S1_Ct41;
        grd4T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_LaneIn_S1", TransitionOperation.AddElement, "P_LaneIn_int1_V_S1"));
        grd4T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd4T0_In_V_S1);


        T0_In_V_S1.Delay = 1;
        pn.Transitions.add(T0_In_V_S1);
        //---------------------------- END T0_In_V_S1---------------------------------------- //T0


        DataCarQueue P_LaneIn_int1_V_S1 = new DataCarQueue();
        P_LaneIn_int1_V_S1.Value.Size = 3;
        P_LaneIn_int1_V_S1.SetName("P_LaneIn_int1_V_S1");
        pn.PlaceList.add(P_LaneIn_int1_V_S1);

        //----------------------------T2_In_V_S1---------------------------------------- //T4
        PetriTransition T2_In_V_S1 = new PetriTransition(pn);
        T2_In_V_S1.TransitionName = "T2_In_V_S1";
        T2_In_V_S1.InputPlaceName.add("P_LaneIn_int1_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T2_In_V_S1_Ct11 = new Condition(T2_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.HaveCarForMe);
        Condition T2_In_V_S1_Ct12 = new Condition(T2_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.CanAddCars);
        T2_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_V_S1_Ct12);
        GuardMapping grd1T2_In_V_S1 = new GuardMapping();
        grd1T2_In_V_S1.condition = T2_In_V_S1_Ct11;
        grd1T2_In_V_S1.Activations.add(new Activation(T2_In_V_S1, "P_LaneIn_int1_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int2_V_S1"));
        T2_In_V_S1.GuardMappingList.add(grd1T2_In_V_S1);

        T2_In_V_S1.Delay = 1;
        pn.Transitions.add(T2_In_V_S1);
        //---------------------------- END T2_In_V_S1---------------------------------------- //T4

        DataCarQueue P_LaneIn_int2_V_S1 = new DataCarQueue();
        P_LaneIn_int2_V_S1.SetName("P_LaneIn_int2_V_S1");
        P_LaneIn_int2_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneIn_int2_V_S1);

        DataCar P_Lane_TelitaOut_V_S1 = new DataCar();
        P_Lane_TelitaOut_V_S1.SetName("P_Lane_TelitaOut_V_S1");
        pn.PlaceList.add(P_Lane_TelitaOut_V_S1);

        //----------------------------T6_In_V_S1---------------------------------------- //T112
        PetriTransition T6_In_V_S1 = new PetriTransition(pn);
        T6_In_V_S1.TransitionName = "T6_In_V_S1";
        T6_In_V_S1.InputPlaceName.add("P_LaneIn_int1_V_S1");
        // --------------guard 1-------------------------------------------------------
        Condition T6_In_V_S1_Ct11 = new Condition(T6_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T6_In_V_S1 = new GuardMapping();
        grd1T6_In_V_S1.condition= T6_In_V_S1_Ct11;
        grd1T6_In_V_S1.Activations.add(new Activation(T6_In_V_S1, "P_LaneIn_int1_V_S1", TransitionOperation.PopElementWithTarget, "P_Lane_TelitaOut_V_S1"));
        T6_In_V_S1.GuardMappingList.add(grd1T6_In_V_S1);
        T6_In_V_S1.Delay = 1;
        pn.Transitions.add(T6_In_V_S1);

        //----------------------------END T6_In_V_S1----------------------------------------

        DataCar P_Lane_TelitaIn_V_S1 = new DataCar();
        P_Lane_TelitaIn_V_S1.SetName("P_Lane_TelitaIn_V_S1");
        pn.PlaceList.add(P_Lane_TelitaIn_V_S1);

        //----------------------------T8_In_V_S1---------------------------------------- //T5
        PetriTransition T8_In_V_S1 = new PetriTransition(pn);
        T8_In_V_S1.TransitionName = "T8_In_V_S1";
        T8_In_V_S1.InputPlaceName.add("P_LaneIn_int2_V_S1");
        T8_In_V_S1.InputPlaceName.add("P_Lane_TelitaIn_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T8_In_V_S1_Ct11 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.HaveCar);
        Condition T8_In_V_S1_Ct12 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.IsNull);
        Condition T8_In_V_S1_Ct13 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct13);
        T8_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct12);
        GuardMapping grd1T8_In_V_S1 = new GuardMapping();
        grd1T8_In_V_S1.condition = T8_In_V_S1_Ct11;
        grd1T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd1T8_In_V_S1);

        // --------------guard 2-------------------------------------------------------
        Condition T8_In_V_S1_Ct21 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.DontHaveCar);
        Condition T8_In_V_S1_Ct22 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.NotNull);
        Condition T8_In_V_S1_Ct23 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct23);
        T8_In_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct22);
        GuardMapping grd2T8_In_V_S1 = new GuardMapping();
        grd2T8_In_V_S1.condition = T8_In_V_S1_Ct21;
        grd2T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd2T8_In_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T8_In_V_S1_Ct31 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.HaveCar);
        Condition T8_In_V_S1_Ct32 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.IsPriorityCar);
        Condition T8_In_V_S1_Ct33 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct33);
        T8_In_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct32);
        GuardMapping grd3T8_In_V_S1 = new GuardMapping();
        grd3T8_In_V_S1.condition = T8_In_V_S1_Ct31;
        grd3T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        grd3T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd3T8_In_V_S1);

        // --------------guard 4-------------------------------------------------------
        Condition T8_In_V_S1_Ct41 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.HaveCar);
        Condition T8_In_V_S1_Ct42 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.NotNull);
        Condition T8_In_V_S1_Ct43 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct43);
        T8_In_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct42);
        GuardMapping grd4T8_In_V_S1 = new GuardMapping();
        grd4T8_In_V_S1.condition = T8_In_V_S1_Ct41;
        grd4T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S1"));
        grd4T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd4T8_In_V_S1);


        T8_In_V_S1.Delay = 1;
        pn.Transitions.add(T8_In_V_S1);
        //----------------------------END T8_In_V_S1----------------------------------------

        DataCarQueue P_LaneIn_int3_V_S1 = new DataCarQueue();
        P_LaneIn_int3_V_S1.Value.Size = 3;
        P_LaneIn_int3_V_S1.SetName("P_LaneIn_int3_V_S1");
        pn.PlaceList.add(P_LaneIn_int3_V_S1);

        //----------------------------T10_In_V_S1---------------------------------------- //T8
        PetriTransition T10_In_V_S1 = new PetriTransition(pn);
        T10_In_V_S1.TransitionName = "T10_In_V_S1";
        T10_In_V_S1.InputPlaceName.add("P_LaneIn_int3_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T10_In_V_S1_Ct11 = new Condition(T10_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.HaveCar);
        Condition T10_In_V_S1_Ct12 = new Condition(T10_In_V_S1, "P_LaneIn_int4_V_S1", TransitionCondition.CanAddCars);
        T10_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T10_In_V_S1_Ct12);
        GuardMapping grd1T10_In_V_S1 = new GuardMapping();
        grd1T10_In_V_S1.condition = T10_In_V_S1_Ct11;
        grd1T10_In_V_S1.Activations.add(new Activation(T10_In_V_S1, "P_LaneIn_int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int4_V_S1"));
        T10_In_V_S1.GuardMappingList.add(grd1T10_In_V_S1);

        T10_In_V_S1.Delay = 1;
        pn.Transitions.add(T10_In_V_S1);
        //---------------------------- END T10_In_V_S1----------------------------------------

        DataCarQueue P_LaneIn_int4_V_S1 = new DataCarQueue();
        P_LaneIn_int4_V_S1.Value.Size = 3;
        P_LaneIn_int4_V_S1.SetName("P_LaneIn_int4_V_S1");
        pn.PlaceList.add(P_LaneIn_int4_V_S1);

        DataCar P_LaneInOut_V_S1 = new DataCar();
        P_LaneInOut_V_S1.SetName("P_LaneInOut_V_S1");
        pn.PlaceList.add(P_LaneInOut_V_S1);

        //----------------------------T12_In_V_S1---------------------------------------- //T9
        PetriTransition T12_In_V_S1 = new PetriTransition(pn);
        T12_In_V_S1.TransitionName = "T12_In_V_S1";
        T12_In_V_S1.InputPlaceName.add("P_LaneIn_int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T12_In_V_S1_Ct11 = new Condition(T12_In_V_S1, "P_LaneIn_int4_V_S1", TransitionCondition.HaveCarForMe);
        Condition T12_In_V_S1_Ct12 = new Condition(T12_In_V_S1, "P_LaneIn_int5_V_S1", TransitionCondition.CanAddCars);
        T12_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T12_In_V_S1_Ct12);
        GuardMapping grd1T12_In_V_S1 = new GuardMapping();
        grd1T12_In_V_S1.condition = T12_In_V_S1_Ct11;
        grd1T12_In_V_S1.Activations.add(new Activation(T12_In_V_S1, "P_LaneIn_int4_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int5_V_S1"));
        T12_In_V_S1.GuardMappingList.add(grd1T12_In_V_S1);

        T12_In_V_S1.Delay = 1;
        pn.Transitions.add(T12_In_V_S1);
        //---------------------------- END T12_In_V_S1----------------------------------------

        //----------------------------T14_In_V_S1---------------------------------------- //T113
        PetriTransition T14_In_V_S1 = new PetriTransition(pn);
        T14_In_V_S1.TransitionName = "T14_In_V_S1";
        T14_In_V_S1.InputPlaceName.add("P_LaneIn_int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T14_In_V_S1_Ct11 = new Condition(T14_In_V_S1, "P_LaneIn_int4_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T14_In_V_S1 = new GuardMapping();
        grd1T14_In_V_S1.condition = T14_In_V_S1_Ct11;
        grd1T14_In_V_S1.Activations.add(new Activation(T14_In_V_S1, "P_LaneIn_int4_V_S1", TransitionOperation.PopElementWithTarget, "P_LaneInOut_V_S1"));
        T14_In_V_S1.GuardMappingList.add(grd1T14_In_V_S1);

        T14_In_V_S1.Delay = 1;
        pn.Transitions.add(T14_In_V_S1);
        //---------------------------- END T14_In_V_S1----------------------------------------

        DataCarQueue P_LaneIn_int5_V_S1 = new DataCarQueue();
        P_LaneIn_int5_V_S1.Value.Size = 4;
        P_LaneIn_int5_V_S1.SetName("P_LaneIn_int5_V_S1");
        pn.PlaceList.add(P_LaneIn_int5_V_S1);

        //------------------------------T16_In_V_S1-------------------------------------------- //T_u_LaneIn_V_S1
        PetriTransition T16_In_V_S1 = new PetriTransition(pn);
        T16_In_V_S1.TransitionName = "T16_In_V_S1";
        T16_In_V_S1.InputPlaceName.add("P_LaneIn_int5_V_S1");
        T16_In_V_S1.InputPlaceName.add("P_x_Lane_V_S1");

        Condition T16_In_V_S1_Ct11 = new Condition(T16_In_V_S1, "P_LaneIn_int5_V_S1", TransitionCondition.HaveCar);
        Condition T16_In_V_S1_Ct12 = new Condition(T16_In_V_S1, "P_x_Lane_V_S1", TransitionCondition.CanAddCars);
        T16_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T16_In_V_S1_Ct12);

        GuardMapping grd1T16_In_V_S1 = new GuardMapping();
        grd1T16_In_V_S1.condition = T16_In_V_S1_Ct11;
        grd1T16_In_V_S1.Activations.add(new Activation(T16_In_V_S1, "P_LaneIn_int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Lane_V_S1"));
        T16_In_V_S1.GuardMappingList.add(grd1T16_In_V_S1);

        T16_In_V_S1.Delay = 1;
        pn.Transitions.add(T16_In_V_S1);
        //---------------------------- END T16_In_V_S1----------------------------------------

        DataCarQueue P_x_Lane_V_S1 = new DataCarQueue();
        P_x_Lane_V_S1.Value.Size = 4;
        P_x_Lane_V_S1.SetName("P_x_Lane_V_S1");
        pn.PlaceList.add(P_x_Lane_V_S1);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_V_S1 = new DataTransfer();
        OP_V_S1.SetName("OP_V_S1");
        OP_V_S1.Value = new TransferOperation("localhost", "1081", "in2");
        pn.PlaceList.add(OP_V_S1);
        //----------------------------T22_In_V_S1----------------------------------------------//T_Out_V_S1
        PetriTransition T22_In_V_S1 = new PetriTransition(pn);
        T22_In_V_S1.TransitionName = "T22_In_V_S1";
        T22_In_V_S1.InputPlaceName.add("P_LaneIn_int5_V_S1");
        T22_In_V_S1.InputPlaceName.add("P_x_Lane_V_S1");
        //T22_In_V_S1.IsAsync = true;

        Condition T22_In_V_S1_Ct1 = new Condition(T22_In_V_S1, "P_LaneIn_int5_V_S1", TransitionCondition.HaveCar);
        Condition T22_In_V_S1_Ct2 = new Condition(T22_In_V_S1, "P_x_Lane_V_S1", TransitionCondition.CanNotAddCars);
        T22_In_V_S1_Ct1.SetNextCondition(LogicConnector.AND, T22_In_V_S1_Ct2);

        GuardMapping grdT22_In_V_S1 = new GuardMapping();
        grdT22_In_V_S1.condition = T22_In_V_S1_Ct1;
        grdT22_In_V_S1.Activations.add(new Activation(T22_In_V_S1, "full", TransitionOperation.SendOverNetwork, "OP_V_S1"));
        T22_In_V_S1.GuardMappingList.add(grdT22_In_V_S1);

        pn.Transitions.add(T22_In_V_S1);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //------------------------------T18_In_V_S1-------------------------------------------- //T_e_LaneIn_V_S1
        PetriTransition T18_In_V_S1 = new PetriTransition(pn);
        T18_In_V_S1.TransitionName = "T18_In_V_S1";
        T18_In_V_S1.InputPlaceName.add("P_x_Lane_V_S1");
        T18_In_V_S1.InputPlaceName.add("P_TL_V_S1");

        //-----------------------guard3---------------------------------------------------
        Condition T18_In_V_S1_C31 = new Condition(T18_In_V_S1, "P_x_Lane_V_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T18_In_V_S1 = new GuardMapping();
        grd3T18_In_V_S1.condition= T18_In_V_S1_C31;
        grd3T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_x_Lane_V_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_V_S1"));
        grd3T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_TL_V_S1", TransitionOperation.Move, "P_TL_V_S1"));
        T18_In_V_S1.GuardMappingList.add(grd3T18_In_V_S1);

        //-----------------------guard1---------------------------------------------------
        Condition T18_In_V_S1_Ct11 = new Condition(T18_In_V_S1, "P_TL_V_S1", TransitionCondition.Equal,"green");
        Condition T18_In_V_S1_Ct12 = new Condition(T18_In_V_S1, "P_x_Lane_V_S1", TransitionCondition.HaveCar);
        T18_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T18_In_V_S1_Ct12);

        GuardMapping grd1T18_In_V_S1 = new GuardMapping();
        grd1T18_In_V_S1.condition= T18_In_V_S1_Ct11;
        grd1T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_x_Lane_V_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_V_S1"));
        grd1T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_TL_V_S1", TransitionOperation.Move, "P_TL_V_S1"));


        T18_In_V_S1.GuardMappingList.add(grd1T18_In_V_S1);
        T18_In_V_S1.Delay = 1;
        pn.Transitions.add(T18_In_V_S1);
        //---------------------------- END T18_In_V_S1----------------------------------------

        DataCar P_b_Lane_V_S1 = new DataCar();
        P_b_Lane_V_S1.SetName("P_b_Lane_V_S1");
        pn.PlaceList.add(P_b_Lane_V_S1);

        //-----------------------------T20_In_V_S1-------------------------------------------//T_I_Car1_V
        PetriTransition T20_In_V_S1 = new PetriTransition(pn);
        T20_In_V_S1.TransitionName = "T20_In_V_S1";
        T20_In_V_S1.InputPlaceName.add("P_b_Lane_V_S1");
        T20_In_V_S1.InputPlaceName.add("P_I_S1");

        Condition T20_In_V_S1_Ct11 = new Condition(T20_In_V_S1, "P_b_Lane_V_S1", TransitionCondition.NotNull);
        Condition T20_In_V_S1_Ct12 = new Condition(T20_In_V_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T20_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T20_In_V_S1_Ct12);

        GuardMapping grd1T20_In_V_S1 = new GuardMapping();
        grd1T20_In_V_S1.condition = T20_In_V_S1_Ct11;
        grd1T20_In_V_S1.Activations.add(new Activation(T20_In_V_S1, "P_b_Lane_V_S1", TransitionOperation.AddElement, "P_I_S1"));
        T20_In_V_S1.GuardMappingList.add(grd1T20_In_V_S1);

        T20_In_V_S1.Delay = 1;
        pn.Transitions.add(T20_In_V_S1);
        //---------------------------- END T20_In_V_S1----------------------------------------


        //-------------------OUT---------------------------
        DataCar P_LaneOut_V_S1 = new DataCar();
        P_LaneOut_V_S1.SetName("P_LaneOut_V_S1");
        pn.PlaceList.add(P_LaneOut_V_S1);

        DataCarQueue P_LaneOut_Int1_V_S1 = new DataCarQueue();
        P_LaneOut_Int1_V_S1.SetName("P_LaneOut_Int1_V_S1");
        P_LaneOut_Int1_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int1_V_S1);

        DataCar P_LaneDonici_V_In_S1 = new DataCar();
        P_LaneDonici_V_In_S1.SetName("P_LaneDonici_V_In_S1");
        pn.PlaceList.add(P_LaneDonici_V_In_S1);

        //----------------------------T1_Out_V_S1---------------------------------------- T3

        PetriTransition T1_Out_V_S1 = new PetriTransition(pn);
        T1_Out_V_S1.TransitionName = "T1_Out_V_S1";
        T1_Out_V_S1.InputPlaceName.add("P_LaneOut_Int1_V_S1");
        T1_Out_V_S1.InputPlaceName.add("P_LaneDonici_V_In_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_V_S1_Ct11 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.HaveCar);
        Condition T1_Out_V_S1_Ct12 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.IsNull);
        T1_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct12);
        GuardMapping grd1T1_Out_V_S1 = new GuardMapping();
        grd1T1_Out_V_S1.condition = T1_Out_V_S1_Ct11;
        grd1T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd1T1_Out_V_S1);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T1_Out_V_S1_Ct21 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.DontHaveCar);
        Condition T1_Out_V_S1_Ct22 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.NotNull);
        T1_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct22);
        GuardMapping grd2T1_Out_V_S1 = new GuardMapping();
        grd2T1_Out_V_S1.condition = T1_Out_V_S1_Ct21;
        grd2T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionOperation.Move, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd2T1_Out_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T1_Out_V_S1_Ct31 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.HaveCar);
        Condition T1_Out_V_S1_Ct32 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.IsPriorityCar);
        T1_Out_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct32);
        GuardMapping grd3T1_Out_V_S1 = new GuardMapping();
        grd3T1_Out_V_S1.condition = T1_Out_V_S1_Ct31;
        grd3T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionOperation.Move, "P_LaneOut_V_S1"));
        grd3T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd3T1_Out_V_S1);


        // --------------guard 4-------------------------------------------------------
        Condition T1_Out_V_S1_Ct41 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.HaveCar);
        Condition T1_Out_V_S1_Ct42 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.NotNull);
        T1_Out_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct42);
        GuardMapping grd4T1_Out_V_S1 = new GuardMapping();
        grd4T1_Out_V_S1.condition = T1_Out_V_S1_Ct41;
        grd4T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneOut_V_S1"));
        grd4T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionOperation.Move, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd4T1_Out_V_S1);

        T1_Out_V_S1.Delay = 1;
        pn.Transitions.add(T1_Out_V_S1);

        //----------------------------END T1_Out_V_S1----------------------------------------

        DataCar P_LaneDonici_V_Out_S1 = new DataCar();
        P_LaneDonici_V_Out_S1.SetName("P_LaneDonici_V_Out_S1");
        pn.PlaceList.add(P_LaneDonici_V_Out_S1);

        DataCarQueue P_LaneOut_Int2_V_S1 = new DataCarQueue();
        P_LaneOut_Int2_V_S1.SetName("P_LaneOut_Int2_V_S1");
        P_LaneOut_Int2_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int2_V_S1);

        //----------------------------T3_Out_V_S1---------------------------------------- T109

        PetriTransition T3_Out_V_S1 = new PetriTransition(pn);
        T3_Out_V_S1.TransitionName = "T3_Out_V_S1";
        T3_Out_V_S1.InputPlaceName.add("P_LaneOut_Int2_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T3_Out_V_S1_Ct11 = new Condition(T3_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_V_S1_Ct12 = new Condition(T3_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.CanAddCars);
        GuardMapping grd1T3_Out_V_S1 = new GuardMapping();
        T3_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_V_S1_Ct12);
        grd1T3_Out_V_S1.condition= T3_Out_V_S1_Ct11;
        grd1T3_Out_V_S1.Activations.add(new Activation(T3_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int1_V_S1"));
        T3_Out_V_S1.GuardMappingList.add(grd1T3_Out_V_S1);
        T3_Out_V_S1.Delay = 1;
        pn.Transitions.add(T3_Out_V_S1);

        //----------------------------END T3_Out_V_S1----------------------------------------

        //----------------------------T5_V_S1---------------------------------------- T2

        PetriTransition T5_Out_V_S1 = new PetriTransition(pn);
        T5_Out_V_S1.TransitionName = "T5_Out_V_S1";
        T5_Out_V_S1.InputPlaceName.add("P_LaneOut_Int2_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T5_Out_V_S1_Ct11 = new Condition(T5_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T5_Out_V_S1 = new GuardMapping();
        grd1T5_Out_V_S1.condition= T5_Out_V_S1_Ct11;
        grd1T5_Out_V_S1.Activations.add(new Activation(T5_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionOperation.PopElementWithTarget, "P_LaneDonici_V_Out_S1"));
        T5_Out_V_S1.GuardMappingList.add(grd1T5_Out_V_S1);
        T5_Out_V_S1.Delay = 1;
        pn.Transitions.add(T5_Out_V_S1);

        //----------------------------END T5_Out_V_S1----------------------------------------

        DataCarQueue P_LaneOut_Int3_V_S1 = new DataCarQueue();
        P_LaneOut_Int3_V_S1.SetName("P_LaneOut_Int3_V_S1");
        P_LaneOut_Int3_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int3_V_S1);

        DataCar P_LaneGhDonici_V_In_S1 = new DataCar();
        P_LaneGhDonici_V_In_S1.SetName("P_LaneGhDonici_V_In_S1");
        pn.PlaceList.add(P_LaneGhDonici_V_In_S1);

        //----------------------------T7_Out_V_S1---------------------------------------- T6

        PetriTransition T7_Out_V_S1 = new PetriTransition(pn);
        T7_Out_V_S1.TransitionName = "T7_Out_V_S1";
        T7_Out_V_S1.InputPlaceName.add("P_LaneOut_Int3_V_S1");
        T7_Out_V_S1.InputPlaceName.add("P_LaneGhDonici_V_In_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T7_Out_V_S1_Ct11 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.HaveCar);
        Condition T7_Out_V_S1_Ct12 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.IsNull);
        Condition T7_Out_V_S1_Ct13 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct13);
        T7_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct12);
        GuardMapping grd1T7_Out_V_S1 = new GuardMapping();
        grd1T7_Out_V_S1.condition = T7_Out_V_S1_Ct11;
        grd1T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd1T7_Out_V_S1);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T7_Out_V_S1_Ct21 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.DontHaveCar);
        Condition T7_Out_V_S1_Ct22 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.NotNull);
        Condition T7_Out_V_S1_Ct23 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct23);
        T7_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct22);
        GuardMapping grd2T7_Out_V_S1 = new GuardMapping();
        grd2T7_Out_V_S1.condition = T7_Out_V_S1_Ct21;
        grd2T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionOperation.AddElement, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd2T7_Out_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T7_Out_V_S1_Ct31 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.HaveCar);
        Condition T7_Out_V_S1_Ct32 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.IsPriorityCar);
        Condition T7_Out_V_S1_Ct33 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct33);
        T7_Out_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct32);
        GuardMapping grd3T7_Out_V_S1 = new GuardMapping();
        grd3T7_Out_V_S1.condition = T7_Out_V_S1_Ct31;
        grd3T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionOperation.AddElement, "P_LaneOut_Int2_V_S1"));
        grd3T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd3T7_Out_V_S1);


        // --------------guard 4-------------------------------------------------------
        Condition T7_Out_V_S1_Ct41 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.HaveCar);
        Condition T7_Out_V_S1_Ct42 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.NotNull);
        Condition T7_Out_V_S1_Ct43 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct43);
        T7_Out_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct42);
        GuardMapping grd4T7_Out_V_S1 = new GuardMapping();
        grd4T7_Out_V_S1.condition = T7_Out_V_S1_Ct41;
        grd4T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int2_V_S1"));
        grd4T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionOperation.AddElement, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd4T7_Out_V_S1);

        T7_Out_V_S1.Delay = 1;
        pn.Transitions.add(T7_Out_V_S1);

        //----------------------------END T7_Out_V_S1----------------------------------------

        DataCar P_LaneGhDonici_V_Out_S1 = new DataCar();
        P_LaneGhDonici_V_Out_S1.SetName("P_LaneGhDonici_V_Out_S1");
        pn.PlaceList.add(P_LaneGhDonici_V_Out_S1);

        DataCarQueue P_LaneOut_Int4_V_S1 = new DataCarQueue();
        P_LaneOut_Int4_V_S1.SetName("P_LaneOut_Int4_V_S1");
        P_LaneOut_Int4_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int4_V_S1);

        //----------------------------T9_Out_V_S1---------------------------------------- T110

        PetriTransition T9_Out_V_S1 = new PetriTransition(pn);
        T9_Out_V_S1.TransitionName = "T9_Out_V_S1";
        T9_Out_V_S1.InputPlaceName.add("P_LaneOut_Int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T9_Out_V_S1_Ct11 = new Condition(T9_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.HaveCarForMe);
        Condition T9_Out_V_S1_Ct12 = new Condition(T9_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.CanAddCars);
        GuardMapping grd1T9_Out_V_S1 = new GuardMapping();
        T9_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T9_Out_V_S1_Ct12);
        grd1T9_Out_V_S1.condition= T9_Out_V_S1_Ct11;
        grd1T9_Out_V_S1.Activations.add(new Activation(T9_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int3_V_S1"));
        T9_Out_V_S1.GuardMappingList.add(grd1T9_Out_V_S1);
        T9_Out_V_S1.Delay = 1;
        pn.Transitions.add(T9_Out_V_S1);

        //----------------------------END T9_Out_V_S1----------------------------------------

        //----------------------------T11_Out_V_S1---------------------------------------- T7

        PetriTransition T11_Out_V_S1 = new PetriTransition(pn);
        T11_Out_V_S1.TransitionName = "T11_Out_V_S1";
        T11_Out_V_S1.InputPlaceName.add("P_LaneOut_Int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T11_Out_V_S1_Ct11 = new Condition(T11_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T11_Out_V_S1 = new GuardMapping();
        grd1T11_Out_V_S1.condition= T11_Out_V_S1_Ct11;
        grd1T11_Out_V_S1.Activations.add(new Activation(T11_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionOperation.PopElementWithTarget, "P_LaneGhDonici_V_Out_S1"));
        T11_Out_V_S1.GuardMappingList.add(grd1T11_Out_V_S1);
        T11_Out_V_S1.Delay = 1;
        pn.Transitions.add(T11_Out_V_S1);

        //----------------------------END T11_Out_V_S1----------------------------------------

        DataCarQueue P_LaneOut_Int5_V_S1 = new DataCarQueue();
        P_LaneOut_Int5_V_S1.SetName("P_LaneOut_Int5_V_S1");
        P_LaneOut_Int5_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int5_V_S1);

        DataCarQueue P_BusStation_Sebastian_V_Out_S1 = new DataCarQueue();
        P_BusStation_Sebastian_V_Out_S1.SetName("P_BusStation_Sebastian_V_Out_S1");
        P_BusStation_Sebastian_V_Out_S1.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Sebastian_V_Out_S1);

        //----------------------------T13_Out_V_S1---------------------------------------- T85

        PetriTransition T13_Out_V_S1 = new PetriTransition(pn);
        T13_Out_V_S1.TransitionName = "T13_Out_V_S1";
        T13_Out_V_S1.InputPlaceName.add("P_LaneOut_Int5_V_S1");
        T13_Out_V_S1.InputPlaceName.add("P_BusStation_Sebastian_V_Out_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T13_Out_V_S1_Ct11 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.HaveCar);
        Condition T13_Out_V_S1_Ct12 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.DontHaveBus);
        Condition T13_Out_V_S1_Ct13 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct13);
        T13_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct12);
        GuardMapping grd1T13_Out_V_S1 = new GuardMapping();
        grd1T13_Out_V_S1.condition = T13_Out_V_S1_Ct11;
        grd1T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd1T13_Out_V_S1);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T13_Out_V_S1_Ct21 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.DontHaveCar);
        Condition T13_Out_V_S1_Ct22 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.HaveBus);
        Condition T13_Out_V_S1_Ct23 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct23);
        T13_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct22);
        GuardMapping grd2T13_Out_V_S1 = new GuardMapping();
        grd2T13_Out_V_S1.condition = T13_Out_V_S1_Ct21;
        grd2T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd2T13_Out_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T13_Out_V_S1_Ct31 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.HavePriorityCar);
        Condition T13_Out_V_S1_Ct32 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.HaveBus);
        Condition T13_Out_V_S1_Ct33 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct33);
        T13_Out_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct32);
        GuardMapping grd3T13_Out_V_S1 = new GuardMapping();
        grd3T13_Out_V_S1.condition = T13_Out_V_S1_Ct31;
        grd3T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        grd3T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd3T13_Out_V_S1);


        // --------------guard 4-------------------------------------------------------
        Condition T13_Out_V_S1_Ct41 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.HaveCar);
        Condition T13_Out_V_S1_Ct42 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.HaveBus);
        Condition T13_Out_V_S1_Ct43 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct43);
        T13_Out_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct42);
        GuardMapping grd4T13_Out_V_S1 = new GuardMapping();
        grd4T13_Out_V_S1.condition = T13_Out_V_S1_Ct41;
        grd4T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        grd4T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd4T13_Out_V_S1);

        T13_Out_V_S1.Delay = 1;
        pn.Transitions.add(T13_Out_V_S1);

        //----------------------------END T13_Out_V_S1----------------------------------------

        DataCarQueue P_BusStation_Sebastian_V_S1 = new DataCarQueue();
        P_BusStation_Sebastian_V_S1.SetName("P_BusStation_Sebastian_V_S1");
        P_BusStation_Sebastian_V_S1.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Sebastian_V_S1);

        //----------------------------T15_Out_V_S1----------------------------------------

        PetriTransition T15_Out_V_S1 = new PetriTransition(pn);
        T15_Out_V_S1.TransitionName = "T15_Out_V_S1";
        T15_Out_V_S1.InputPlaceName.add("P_BusStation_Sebastian_V_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T15_Out_V_S1_Ct11 = new Condition(T15_Out_V_S1, "P_BusStation_Sebastian_V_S1", TransitionCondition.HaveBus);
        Condition T15_Out_V_S1_Ct12 = new Condition(T15_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.CanAddCars);
        T15_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T15_Out_V_S1_Ct12);
        GuardMapping grd1T15_Out_V_S1 = new GuardMapping();
        grd1T15_Out_V_S1.condition = T15_Out_V_S1_Ct11;
        grd1T15_Out_V_S1.Activations.add(new Activation(T15_Out_V_S1, "P_BusStation_Sebastian_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_BusStation_Sebastian_V_Out_S1"));
        T15_Out_V_S1.GuardMappingList.add(grd1T15_Out_V_S1);

        T15_Out_V_S1.Delay = 10;
        pn.Transitions.add(T15_Out_V_S1);

        //----------------------------END T15_Out_V_S1----------------------------------------

        DataCarQueue P_O_Lane_V_S1 = new DataCarQueue();
        P_O_Lane_V_S1.Value.Size = 3;
        P_O_Lane_V_S1.SetName("P_O_Lane_V_S1");
        pn.PlaceList.add(P_O_Lane_V_S1);

        //----------------------------T17_Out_V_S1----------------------------------------//T_ge_Out_V_S1

        PetriTransition T17_Out_V_S1 = new PetriTransition(pn);
        T17_Out_V_S1.TransitionName = "T17_Out_V_S1";
        T17_Out_V_S1.InputPlaceName.add("P_O_Lane_V_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T17_Out_V_S1_Ct11 = new Condition(T17_Out_V_S1, "P_O_Lane_V_S1", TransitionCondition.HaveBusForMe);
        Condition T17_Out_V_S1_Ct12 = new Condition(T17_Out_V_S1, "P_BusStation_Sebastian_V_S1", TransitionCondition.CanAddCars);
        T17_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T17_Out_V_S1_Ct12);
        GuardMapping grd1T17_Out_V_S1 = new GuardMapping();
        grd1T17_Out_V_S1.condition = T17_Out_V_S1_Ct11;
        grd1T17_Out_V_S1.Activations.add(new Activation(T17_Out_V_S1, "P_O_Lane_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_BusStation_Sebastian_V_S1"));
        T17_Out_V_S1.GuardMappingList.add(grd1T17_Out_V_S1);

        T17_Out_V_S1.Delay = 1;
        pn.Transitions.add(T17_Out_V_S1);

        //----------------------------END T17_Out_V_S1----------------------------------------

        //----------------------------T19_Out_V_S1---------------------------------------- //T_ge_LaneOut_V_S1

        PetriTransition T19_Out_V_S1 = new PetriTransition(pn);
        T19_Out_V_S1.TransitionName = "T19_Out_V_S1";
        T19_Out_V_S1.InputPlaceName.add("P_O_Lane_V_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T19_Out_V_S1_Ct11 = new Condition(T19_Out_V_S1, "P_O_Lane_V_S1", TransitionCondition.HaveCarForMe);
        Condition T19_Out_V_S1_Ct12 = new Condition(T19_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.CanAddCars);
        T19_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T19_Out_V_S1_Ct12);
        GuardMapping grd1T19_Out_V_S1 = new GuardMapping();
        grd1T19_Out_V_S1.condition = T19_Out_V_S1_Ct11;
        grd1T19_Out_V_S1.Activations.add(new Activation(T19_Out_V_S1, "P_O_Lane_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int5_V_S1"));
        T19_Out_V_S1.GuardMappingList.add(grd1T19_Out_V_S1);

        T19_Out_V_S1.Delay = 1;
        pn.Transitions.add(T19_Out_V_S1);

        //----------------------------END T19_Out_V_S1----------------------------------------

        //----------------------------T21_Out_V_S1---------------------------------------- T_g_CarLane1_V

        PetriTransition T21_Out_V_S1 = new PetriTransition(pn);
        T21_Out_V_S1.TransitionName = "T21_Out_V_S1";
        T21_Out_V_S1.InputPlaceName.add("P_I_S1");
        T21_Out_V_S1.InputPlaceName.add("P_O_Lane_V_S1");

        // --------------guard 2-------------------------------------------------------OK
        Condition T21_Out_V_S1_Ct21 = new Condition(T21_Out_V_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T21_Out_V_S1_Ct22 = new Condition(T21_Out_V_S1, "P_O_Lane_V_S1", TransitionCondition.CanAddCars);
        T21_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T21_Out_V_S1_Ct22);
        GuardMapping grd2T21_Out_V_S1 = new GuardMapping();
        grd2T21_Out_V_S1.condition = T21_Out_V_S1_Ct21;
        grd2T21_Out_V_S1.Activations.add(new Activation(T21_Out_V_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_V_S1"));
        T21_Out_V_S1.GuardMappingList.add(grd2T21_Out_V_S1);

        T21_Out_V_S1.Delay = 1;
        pn.Transitions.add(T21_Out_V_S1);

        //----------------------------END T21_Out_V_S1----------------------------------------

        //------------------NORTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_N_S1   = new DataCar();
        P_LaneIn_N_S1.SetName("P_LaneIn_N_S1");
        pn.PlaceList.add(P_LaneIn_N_S1);

        DataCarQueue P_x_Lane_N_S1 = new DataCarQueue();
        P_x_Lane_N_S1.Value.Size = 3;
        P_x_Lane_N_S1.SetName("P_x_Lane_N_S1");
        pn.PlaceList.add(P_x_Lane_N_S1);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_N_S1 = new DataTransfer();
        OP_N_S1.SetName("OP_N_S1");
        OP_N_S1.Value = new TransferOperation("localhost", "1081", "in1");
        pn.PlaceList.add(OP_N_S1);
        //----------------------------T6_In_N_S1----------------------------------------------//T_Out_V_S1
        PetriTransition T6_In_N_S1 = new PetriTransition(pn);
        T6_In_N_S1.TransitionName = "T6_In_N_S1";
        T6_In_N_S1.InputPlaceName.add("P_LaneIn_N_S1");
        T6_In_N_S1.InputPlaceName.add("P_x_Lane_N_S1");
        //T6_In_N_S1.IsAsync = true;

        Condition T6_In_N_S1_Ct1 = new Condition(T6_In_N_S1, "P_LaneIn_N_S1", TransitionCondition.NotNull);
        Condition T6_In_N_S1_Ct2 = new Condition(T6_In_N_S1, "P_x_Lane_N_S1", TransitionCondition.CanNotAddCars);
        T6_In_N_S1_Ct1.SetNextCondition(LogicConnector.AND, T6_In_N_S1_Ct2);

        GuardMapping grdT6_In_N_S1 = new GuardMapping();
        grdT6_In_N_S1.condition = T6_In_N_S1_Ct1;
        grdT6_In_N_S1.Activations.add(new Activation(T6_In_N_S1, "full", TransitionOperation.SendOverNetwork, "OP_N_S1"));
        T6_In_N_S1.GuardMappingList.add(grdT6_In_N_S1);

        T6_In_N_S1.Delay = 1;
        pn.Transitions.add(T6_In_N_S1);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //------------------------------T0_In_N_S1-------------------------------------------- //T_u_In_N_S1
        PetriTransition T0_In_N_S1 = new PetriTransition(pn);
        T0_In_N_S1.TransitionName = "T0_In_N_S1";
        T0_In_N_S1.InputPlaceName.add("P_LaneIn_N_S1");
        T0_In_N_S1.InputPlaceName.add("P_x_Lane_N_S1");

        Condition T0_In_N_S1_Ct11 = new Condition(T0_In_N_S1, "P_LaneIn_N_S1", TransitionCondition.NotNull);
        Condition T0_In_N_S1_Ct12 = new Condition(T0_In_N_S1, "P_x_Lane_N_S1", TransitionCondition.CanAddCars);
        T0_In_N_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_N_S1_Ct12);

        GuardMapping grd1T0_In_N_S1 = new GuardMapping();
        grd1T0_In_N_S1.condition = T0_In_N_S1_Ct11;
        grd1T0_In_N_S1.Activations.add(new Activation(T0_In_N_S1, "P_LaneIn_N_S1", TransitionOperation.AddElement, "P_x_Lane_N_S1"));
        T0_In_N_S1.GuardMappingList.add(grd1T0_In_N_S1);

        T0_In_N_S1.Delay = 1;
        pn.Transitions.add(T0_In_N_S1);
        //---------------------------- END T0_In_N_S1----------------------------------------

        DataCar P_b_Lane_N_S1 = new DataCar();
        P_b_Lane_N_S1.SetName("P_b_Lane_N_S1");
        pn.PlaceList.add(P_b_Lane_N_S1);

        //------------------------------T2_InN_S1-------------------------------------------- //T_e_In_N_S1
        PetriTransition T2_In_N_S1 = new PetriTransition(pn);
        T2_In_N_S1.TransitionName = "T2_In_N_S1";
        T2_In_N_S1.InputPlaceName.add("P_x_Lane_N_S1");
        T2_In_N_S1.InputPlaceName.add("P_TL_N_S1");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_N_S1_C31 = new Condition(T2_In_N_S1, "P_x_Lane_N_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_N_S1 = new GuardMapping();
        grd3T2_In_N_S1.condition= T2_In_N_S1_C31;
        grd3T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_x_Lane_N_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_N_S1"));
        grd3T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_TL_N_S1", TransitionOperation.Move, "P_TL_N_S1"));
        T2_In_N_S1.GuardMappingList.add(grd3T2_In_N_S1);

        //-----------------------guard1---------------------------------------------------
        Condition T2_In_N_S1_Ct11 = new Condition(T2_In_N_S1, "P_TL_N_S1", TransitionCondition.Equal,"green");
        Condition T2_In_N_S1_Ct12 = new Condition(T2_In_N_S1, "P_x_Lane_N_S1", TransitionCondition.HaveCar);
        T2_In_N_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_N_S1_Ct12);
        GuardMapping grd1T2_In_N_S1 = new GuardMapping();
        grd1T2_In_N_S1.condition= T2_In_N_S1_Ct11;
        grd1T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_x_Lane_N_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_N_S1"));
        grd1T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_TL_N_S1", TransitionOperation.Move, "P_TL_N_S1"));
        T2_In_N_S1.GuardMappingList.add(grd1T2_In_N_S1);

        T2_In_N_S1.Delay = 1;
        pn.Transitions.add(T2_In_N_S1);
        //---------------------------- END T2_InN_S1----------------------------------------

        //-----------------------------T4_In_N_S1-------------------------------------------//T_I_In_N_S1
        PetriTransition T4_In_N_S1 = new PetriTransition(pn);
        T4_In_N_S1.TransitionName = "T4_In_N_S1";
        T4_In_N_S1.InputPlaceName.add("P_b_Lane_N_S1");
        T4_In_N_S1.InputPlaceName.add("P_I_S1");

        Condition T4_In_N_S1_Ct11 = new Condition(T4_In_N_S1, "P_b_Lane_N_S1", TransitionCondition.NotNull);
        Condition T4_In_N_S1_Ct12 = new Condition(T4_In_N_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T4_In_N_S1_Ct11.SetNextCondition(LogicConnector.AND, T4_In_N_S1_Ct12);

        GuardMapping grd1T4_In_N_S1 = new GuardMapping();
        grd1T4_In_N_S1.condition = T4_In_N_S1_Ct11;
        grd1T4_In_N_S1.Activations.add(new Activation(T4_In_N_S1, "P_b_Lane_N_S1", TransitionOperation.AddElement, "P_I_S1"));
        T4_In_N_S1.GuardMappingList.add(grd1T4_In_N_S1);

        T4_In_N_S1.Delay = 1;
        pn.Transitions.add(T4_In_N_S1);
        //---------------------------- END T4_In_N_S1----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_N_S1 = new DataCarQueue();
        P_O_Lane_N_S1.Value.Size = 3;
        P_O_Lane_N_S1.SetName("P_O_Lane_N_S1");
        pn.PlaceList.add(P_O_Lane_N_S1);

        DataCar P_Oe_Lane_N_S1 = new DataCar();
        P_Oe_Lane_N_S1.SetName("P_Oe_Lane_N_S1");
        pn.PlaceList.add(P_Oe_Lane_N_S1);

        //----------------------------T1_Out_N_S1---------------------------------------- T_ge_Out_N_S1

        PetriTransition T1_Out_N_S1 = new PetriTransition(pn);
        T1_Out_N_S1.TransitionName = "T1_Out_N_S1";
        T1_Out_N_S1.InputPlaceName.add("P_O_Lane_N_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_N_S1_Ct11 = new Condition(T1_Out_N_S1, "P_O_Lane_N_S1", TransitionCondition.HaveCar);
        GuardMapping grd1T1_Out_N_S1 = new GuardMapping();
        grd1T1_Out_N_S1.condition = T1_Out_N_S1_Ct11;
        grd1T1_Out_N_S1.Activations.add(new Activation(T1_Out_N_S1, "P_O_Lane_N_S1", TransitionOperation.PopElementWithoutTarget, "P_Oe_Lane_N_S1"));
        T1_Out_N_S1.GuardMappingList.add(grd1T1_Out_N_S1);

        T1_Out_N_S1.Delay = 1;
        pn.Transitions.add(T1_Out_N_S1);

        //----------------------------END T1_Out_N_S1----------------------------------------

        //----------------------------T3_Out_N_S1---------------------------------------- T_g_Out_N_S1

        PetriTransition T3_Out_N_S1 = new PetriTransition(pn);
        T3_Out_N_S1.TransitionName = "T3_Out_N_S1";
        T3_Out_N_S1.InputPlaceName.add("P_I_S1");
        T3_Out_N_S1.InputPlaceName.add("P_O_Lane_N_S1");

        // --------------guard 2-------------------------------------------------------OK
        Condition T3_Out_N_S1_Ct21 = new Condition(T3_Out_N_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_N_S1_Ct22 = new Condition(T3_Out_N_S1, "P_O_Lane_N_S1", TransitionCondition.CanAddCars);

        T3_Out_N_S1_Ct21.SetNextCondition(LogicConnector.AND, T3_Out_N_S1_Ct22);
        GuardMapping grd2T3_Out_N_S1 = new GuardMapping();
        grd2T3_Out_N_S1.condition = T3_Out_N_S1_Ct21;
        grd2T3_Out_N_S1.Activations.add(new Activation(T3_Out_N_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_N_S1"));
        T3_Out_N_S1.GuardMappingList.add(grd2T3_Out_N_S1);

        T3_Out_N_S1.Delay = 1;
        pn.Transitions.add(T3_Out_N_S1);

        //----------------------------END T3_Out_N_S1----------------------------------------

        //------------------SOUTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_int1_S_S1 = new DataCar();
        P_LaneIn_int1_S_S1.SetName("P_LaneIn_int1_S_S1");
        pn.PlaceList.add(P_LaneIn_int1_S_S1);

        DataCarQueue P_x_Lane_S_S1 = new DataCarQueue();
        P_x_Lane_S_S1.Value.Size = 6;
        P_x_Lane_S_S1.SetName("P_x_Lane_S_S1");
        pn.PlaceList.add(P_x_Lane_S_S1);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_S_S1 = new DataTransfer();
        OP_S_S1.SetName("OP_S_S1");
        OP_S_S1.Value = new TransferOperation("localhost", "1081", "in3");
        pn.PlaceList.add(OP_S_S1);
        //----------------------------T6_In_S_S1----------------------------------------------//T_Out_S_S1
        PetriTransition T6_In_S_S1 = new PetriTransition(pn);
        T6_In_S_S1.TransitionName = "T6_In_N_S1";
        T6_In_S_S1.InputPlaceName.add("P_LaneIn_int1_S_S1");
        T6_In_S_S1.InputPlaceName.add("P_x_Lane_S_S1");
        //T6_In_S_S1.IsAsync = true;

        Condition T6_In_S_S1_Ct1 = new Condition(T6_In_S_S1, "P_LaneIn_int1_S_S1", TransitionCondition.NotNull);
        Condition T6_In_S_S1_Ct2 = new Condition(T6_In_S_S1, "P_x_Lane_S_S1", TransitionCondition.CanNotAddCars);
        T6_In_S_S1_Ct1.SetNextCondition(LogicConnector.AND, T6_In_S_S1_Ct2);

        GuardMapping grdT6_In_S_S1 = new GuardMapping();
        grdT6_In_S_S1.condition = T6_In_S_S1_Ct1;
        grdT6_In_S_S1.Activations.add(new Activation(T6_In_S_S1, "full", TransitionOperation.SendOverNetwork, "OP_S_S1"));
        T6_In_S_S1.GuardMappingList.add(grdT6_In_S_S1);

        T6_In_S_S1.Delay = 1;
        pn.Transitions.add(T6_In_S_S1);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //------------------------------T0_In_S_S1-------------------------------------------- //T_u_In_S_S1
        PetriTransition T0_In_S_S1 = new PetriTransition(pn);
        T0_In_S_S1.TransitionName = "T0_In_S_S1";
        T0_In_S_S1.InputPlaceName.add("P_LaneIn_int1_S_S1");
        T0_In_S_S1.InputPlaceName.add("P_x_Lane_S_S1");

        Condition T0_In_S_S1_Ct11 = new Condition(T0_In_S_S1, "P_LaneIn_int1_S_S1", TransitionCondition.NotNull);
        Condition T0_In_S_S1_Ct12 = new Condition(T0_In_S_S1, "P_x_Lane_S_S1", TransitionCondition.CanAddCars);
        T0_In_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_S_S1_Ct12);

        GuardMapping grd1T0_In_S_S1 = new GuardMapping();
        grd1T0_In_S_S1.condition = T0_In_S_S1_Ct11;
        grd1T0_In_S_S1.Activations.add(new Activation(T0_In_S_S1, "P_LaneIn_int1_S_S1", TransitionOperation.AddElement, "P_x_Lane_S_S1"));
        T0_In_S_S1.GuardMappingList.add(grd1T0_In_S_S1);

        T0_In_S_S1.Delay = 1;
        pn.Transitions.add(T0_In_S_S1);
        //---------------------------- END T0_In_S_S1----------------------------------------

        //------------------------------T2_In_S_S1-------------------------------------------- //T_e_car1_S
        PetriTransition T2_In_S_S1 = new PetriTransition(pn);
        T2_In_S_S1.TransitionName = "T2_In_S_S1";
        T2_In_S_S1.InputPlaceName.add("P_x_Lane_S_S1");
        T2_In_S_S1.InputPlaceName.add("P_TL_S_S1");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_S_S1_C31 = new Condition(T2_In_S_S1, "P_x_Lane_S_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_S_S1 = new GuardMapping();
        grd3T2_In_S_S1.condition= T2_In_S_S1_C31;
        grd3T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_x_Lane_S_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_S_S1"));
        grd3T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_TL_S_S1", TransitionOperation.Move, "P_TL_S_S1"));


        T2_In_S_S1.GuardMappingList.add(grd3T2_In_S_S1);

        //------------------------guard 1-------------------------------------------------------

        Condition T2_In_S_S1_Ct11 = new Condition(T2_In_S_S1, "P_TL_S_S1", TransitionCondition.Equal,"green");
        Condition T2_In_S_S1_Ct12 = new Condition(T2_In_S_S1, "P_x_Lane_S_S1", TransitionCondition.HaveCar);
        T2_In_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_S_S1_Ct12);

        GuardMapping grd1T2_In_S_S1 = new GuardMapping();
        grd1T2_In_S_S1.condition= T2_In_S_S1_Ct11;
        grd1T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_x_Lane_S_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_S_S1"));
        grd1T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_TL_S_S1", TransitionOperation.Move, "P_TL_S_S1"));
        T2_In_S_S1.GuardMappingList.add(grd1T2_In_S_S1);

        T2_In_S_S1.Delay = 1;
        pn.Transitions.add(T2_In_S_S1);
        //---------------------------- END T2_S_S1----------------------------------------

        DataCar P_b_Lane_S_S1 = new DataCar();
        P_b_Lane_S_S1.SetName("P_b_Lane_S_S1");
        pn.PlaceList.add(P_b_Lane_S_S1);

        //------------------------------T4_In_S_S1-------------------------------------------- //T_I_car1_S
        PetriTransition T4_In_S_S1 = new PetriTransition(pn);
        T4_In_S_S1.TransitionName = "T4_In_S_S1";
        T4_In_S_S1.InputPlaceName.add("P_b_Lane_S_S1");
        T4_In_S_S1.InputPlaceName.add("P_I_S1");

        Condition T4_In_S_S1_Ct11 = new Condition(T4_In_S_S1, "P_b_Lane_S_S1", TransitionCondition.NotNull);
        Condition T4_In_S_S1_Ct12 = new Condition(T4_In_S_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T4_In_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T4_In_S_S1_Ct12);

        GuardMapping grd1T4_In_S_S1 = new GuardMapping();
        grd1T4_In_S_S1.condition = T4_In_S_S1_Ct11;
        grd1T4_In_S_S1.Activations.add(new Activation(T4_In_S_S1, "P_b_Lane_S_S1", TransitionOperation.AddElement, "P_I_S1"));
        T4_In_S_S1.GuardMappingList.add(grd1T4_In_S_S1);

        T4_In_S_S1.Delay = 1;
        pn.Transitions.add(T4_In_S_S1);
        //---------------------------- END T4_In_S_S1----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_S_S1 = new DataCarQueue();
        P_O_Lane_S_S1.Value.Size = 4;
        P_O_Lane_S_S1.SetName("P_O_Lane_S_S1");
        pn.PlaceList.add(P_O_Lane_S_S1);

        DataCar P_Oe_Lane_S_S1 = new DataCar();
        P_Oe_Lane_S_S1.SetName("P_Oe_Lane_S_S1");
        pn.PlaceList.add(P_Oe_Lane_S_S1);

        //----------------------------T1_Out_S_S1---------------------------------------- T_ge_Out_S_S1

        PetriTransition T1_Out_S_S1 = new PetriTransition(pn);
        T1_Out_S_S1.TransitionName = "T1_Out_S_S1";
        T1_Out_S_S1.InputPlaceName.add("P_O_Lane_S_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_S_S1_Ct11 = new Condition(T1_Out_S_S1, "P_O_Lane_S_S1", TransitionCondition.HaveCar);
        GuardMapping grd1T1_Out_S_S1 = new GuardMapping();
        grd1T1_Out_S_S1.condition = T1_Out_S_S1_Ct11;
        grd1T1_Out_S_S1.Activations.add(new Activation(T1_Out_S_S1, "P_O_Lane_S_S1", TransitionOperation.PopElementWithoutTarget, "P_Oe_Lane_S_S1"));
        T1_Out_S_S1.GuardMappingList.add(grd1T1_Out_S_S1);

        T1_Out_S_S1.Delay = 1;
        pn.Transitions.add(T1_Out_S_S1);

        //----------------------------END T1_Out_S_S1----------------------------------------

        //----------------------------T3_Out_S_S1---------------------------------------- T_g_Out_S_S1

        PetriTransition T3_Out_S_S1 = new PetriTransition(pn);
        T3_Out_S_S1.TransitionName = "T3_Out_S_S1";
        T3_Out_S_S1.InputPlaceName.add("P_I_S1");
        T3_Out_S_S1.InputPlaceName.add("P_O_Lane_S_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T3_Out_S_S1_Ct11 = new Condition(T3_Out_S_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_S_S1_Ct12 = new Condition(T3_Out_S_S1, "P_O_Lane_S_S1", TransitionCondition.CanAddCars);

        T3_Out_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_S_S1_Ct12);
        GuardMapping grd1T3_Out_S_S1 = new GuardMapping();
        grd1T3_Out_S_S1.condition = T3_Out_S_S1_Ct11;
        grd1T3_Out_S_S1.Activations.add(new Activation(T3_Out_S_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_S_S1"));
        T3_Out_S_S1.GuardMappingList.add(grd1T3_Out_S_S1);

        T3_Out_S_S1.Delay = 1;
        pn.Transitions.add(T3_Out_S_S1);

        //----------------------------END T3_Out_S_S1----------------------------------------

        //------------------EAST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_x_Lane_E_S1 = new DataCarQueue();
        P_x_Lane_E_S1.Value.Size = 3;
        P_x_Lane_E_S1.SetName("P_x_Lane_E_S1");
        pn.PlaceList.add(P_x_Lane_E_S1);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_E_S1 = new DataTransfer();
        OP_E_S1.SetName("OP_E_S1");
        OP_E_S1.Value = new TransferOperation("localhost", "1081", "in4");
        pn.PlaceList.add(OP_E_S1);
        //----------------------------T6_In_E_S1----------------------------------------------//T_Out_E_S1
        PetriTransition T6_In_E_S1 = new PetriTransition(pn);
        T6_In_E_S1.TransitionName = "T6_In_E_S1";
        T6_In_E_S1.InputPlaceName.add("P_LaneOut_Int1_V_S2");
        T6_In_E_S1.InputPlaceName.add("P_x_Lane_E_S1");
        //T6_In_E_S1.IsAsync = true;

        Condition T6_In_E_S1_Ct1 = new Condition(T6_In_E_S1, "P_LaneOut_Int1_V_S2", TransitionCondition.HaveCar);
        Condition T6_In_E_S1_Ct2 = new Condition(T6_In_E_S1, "P_x_Lane_S_S1", TransitionCondition.CanNotAddCars);
        T6_In_E_S1_Ct1.SetNextCondition(LogicConnector.AND, T6_In_E_S1_Ct2);

        GuardMapping grdT6_In_E_S1 = new GuardMapping();
        grdT6_In_E_S1.condition = T6_In_E_S1_Ct1;
        grdT6_In_E_S1.Activations.add(new Activation(T6_In_E_S1, "full", TransitionOperation.SendOverNetwork, "OP_E_S1"));
        T6_In_E_S1.GuardMappingList.add(grdT6_In_E_S1);

        T6_In_E_S1.Delay = 1;
        pn.Transitions.add(T6_In_E_S1);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //------------------------------T0_In_E_S1-------------------------------------------- //T_u_Car1_E
        PetriTransition T0_In_E_S1 = new PetriTransition(pn);
        T0_In_E_S1.TransitionName = "T0_In_E_S1";
        T0_In_E_S1.InputPlaceName.add("P_LaneOut_Int1_V_S2");
        T0_In_E_S1.InputPlaceName.add("P_x_Lane_E_S1");

        Condition T0_In_E_S1_Ct11 = new Condition(T0_In_E_S1, "P_LaneOut_Int1_V_S2", TransitionCondition.HaveCar);
        Condition T0_In_E_S1_Ct12 = new Condition(T0_In_E_S1, "P_x_Lane_E_S1", TransitionCondition.CanAddCars);
        T0_In_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_E_S1_Ct12);

        GuardMapping grd1T0_In_E_S1 = new GuardMapping();
        grd1T0_In_E_S1.condition = T0_In_E_S1_Ct11;
        grd1T0_In_E_S1.Activations.add(new Activation(T0_In_E_S1, "P_LaneOut_Int1_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Lane_E_S1"));
        T0_In_E_S1.GuardMappingList.add(grd1T0_In_E_S1);

        T0_In_E_S1.Delay = 1;
        pn.Transitions.add(T0_In_E_S1);
        //---------------------------- END T0_In_E_S1----------------------------------------

        DataCar P_b_Lane_E_S1 = new DataCar();
        P_b_Lane_E_S1.SetName("P_b_Lane_E_S1");
        pn.PlaceList.add(P_b_Lane_E_S1);

        //------------------------------T2_In_E_S1-------------------------------------------- //T_e_In_E_S1
        PetriTransition T2_In_E_S1 = new PetriTransition(pn);
        T2_In_E_S1.TransitionName = "T2_In_E_S1";
        T2_In_E_S1.InputPlaceName.add("P_x_Lane_E_S1");
        T2_In_E_S1.InputPlaceName.add("P_TL_E_S1");


        //------------------------guard 3------------------------------------------------------
        Condition T2_In_E_S1_C31 = new Condition(T2_In_E_S1, "P_x_Lane_E_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_E_S1 = new GuardMapping();
        grd3T2_In_E_S1.condition= T2_In_E_S1_C31;
        grd3T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_x_Lane_E_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_E_S1"));
        grd3T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_TL_E_S1", TransitionOperation.Move, "P_TL_E_S1"));
        T2_In_E_S1.GuardMappingList.add(grd3T2_In_E_S1);

        //-----------------------guard1---------------------------------------------------
        Condition T2_In_E_S1_Ct11 = new Condition(T2_In_E_S1, "P_TL_E_S1", TransitionCondition.Equal,"green");
        Condition T2_In_E_S1_Ct12 = new Condition(T2_In_E_S1, "P_x_Lane_E_S1", TransitionCondition.HaveCar);
        T2_In_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_E_S1_Ct12);

        GuardMapping grd1T2_In_E_S1 = new GuardMapping();
        grd1T2_In_E_S1.condition= T2_In_E_S1_Ct11;
        grd1T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_x_Lane_E_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_E_S1"));
        grd1T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_TL_E_S1", TransitionOperation.Move, "P_TL_E_S1"));

        T2_In_E_S1.GuardMappingList.add(grd1T2_In_E_S1);

        T2_In_E_S1.Delay = 1;
        pn.Transitions.add(T2_In_E_S1);
        //---------------------------- END T2_In_E_S1----------------------------------------

        //-----------------------------T4_In_E_S1-------------------------------------------//T_I_In_E_S1
        PetriTransition T4_In_E_S1 = new PetriTransition(pn);
        T4_In_E_S1.TransitionName = "T4_In_E_S1";
        T4_In_E_S1.InputPlaceName.add("P_b_Lane_E_S1");
        T4_In_E_S1.InputPlaceName.add("P_I_S1");

        Condition T4_In_E_S1_Ct11 = new Condition(T4_In_E_S1, "P_b_Lane_E_S1", TransitionCondition.NotNull);
        Condition T4_In_E_S1_Ct12 = new Condition(T4_In_E_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T4_In_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T4_In_E_S1_Ct12);

        GuardMapping grd1T4_In_E_S1 = new GuardMapping();
        grd1T4_In_E_S1.condition = T4_In_E_S1_Ct11;
        grd1T4_In_E_S1.Activations.add(new Activation(T4_In_E_S1, "P_b_Lane_E_S1", TransitionOperation.AddElement, "P_I_S1"));
        T4_In_E_S1.GuardMappingList.add(grd1T4_In_E_S1);

        T4_In_E_S1.Delay = 1;
        pn.Transitions.add(T4_In_E_S1);
        //---------------------------- END T4_In_N_S1----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_E_S1 = new DataCarQueue();
        P_O_Lane_E_S1.Value.Size = 3;
        P_O_Lane_E_S1.SetName("P_O_Lane_E_S1");
        pn.PlaceList.add(P_O_Lane_E_S1);

        //----------------------------T3_E_S1---------------------------------------- T_g_Out_E_S1

        PetriTransition T3_Out_E_S1 = new PetriTransition(pn);
        T3_Out_E_S1.TransitionName = "T3_Out_E_S1";
        T3_Out_E_S1.InputPlaceName.add("P_I_S1");
        T3_Out_E_S1.InputPlaceName.add("P_O_Lane_E_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T3_Out_E_S1_Ct11 = new Condition(T3_Out_E_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_E_S1_Ct12 = new Condition(T3_Out_E_S1, "P_O_Lane_E_S1", TransitionCondition.CanAddCars);


        T3_Out_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_E_S1_Ct12);
        GuardMapping grd1T3_Out_E_S1 = new GuardMapping();
        grd1T3_Out_E_S1.condition = T3_Out_E_S1_Ct11;
        grd1T3_Out_E_S1.Activations.add(new Activation(T3_Out_E_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_E_S1"));
        T3_Out_E_S1.GuardMappingList.add(grd1T3_Out_E_S1);

        T3_Out_E_S1.Delay = 1;
        pn.Transitions.add(T3_Out_E_S1);

        //----------------------------END T3_Out_E_S1----------------------------------------

        //----------------------------T1_Out_E_S1---------------------------------------- T_ge_CarLane1_E

        PetriTransition T1_Out_E_S1 = new PetriTransition(pn);
        T1_Out_E_S1.TransitionName = "T1_Out_E_S1";
        T1_Out_E_S1.InputPlaceName.add("P_O_Lane_E_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_E_S1_Ct11 = new Condition(T1_Out_E_S1, "P_O_Lane_E_S1", TransitionCondition.HaveCar);
        Condition T1_Out_E_S1_Ct12 = new Condition(T1_Out_E_S1, "P_LaneIn_int1_V_S2", TransitionCondition.CanAddCars);
        T1_Out_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T1_Out_E_S1_Ct12);
        GuardMapping grd1T1_Out_E_S1 = new GuardMapping();
        grd1T1_Out_E_S1.condition = T1_Out_E_S1_Ct11;
        grd1T1_Out_E_S1.Activations.add(new Activation(T1_Out_E_S1, "P_O_Lane_E_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S2"));
        T1_Out_E_S1.GuardMappingList.add(grd1T1_Out_E_S1);

        T1_Out_E_S1.Delay = 1;
        pn.Transitions.add(T1_Out_E_S1);

        //----------------------------END T1_E_S1----------------------------------------

        //-------------------INTERSECTION---------------------------
        DataCarQueue P_I_S1 = new DataCarQueue();
        P_I_S1.Value.Size = 3;
        P_I_S1.SetName("P_I_S1");
        pn.PlaceList.add(P_I_S1);

        //-------------------SEMAPHORES---------------------------
        //-------------------VEST---------------------------
        DataString P_TL_V_S1 = new DataString();
        P_TL_V_S1.SetName("P_TL_V_S1");
        pn.PlaceList.add(P_TL_V_S1);
        //-------------------NORTH---------------------------
        DataString P_TL_N_S1 = new DataString();
        P_TL_N_S1.SetName("P_TL_N_S1");
        pn.PlaceList.add(P_TL_N_S1);
        //-------------------SOUTH---------------------------
        DataString P_TL_S_S1 = new DataString();
        P_TL_S_S1.SetName("P_TL_S_S1");
        pn.PlaceList.add(P_TL_S_S1);
        //-------------------EAST---------------------------
        DataString P_TL_E_S1 = new DataString();
        P_TL_E_S1.SetName("P_TL_E_S1");
        pn.PlaceList.add(P_TL_E_S1);
        // -------------------------------------------------------------------
        // ----------------END CALEA FERENTARI SECTION 1----------------------
        // -------------------------------------------------------------------

        // -------------------------------------------------------------------
        // --------------------CALEA FERENTARI SECTION 2----------------------
        // -------------------------------------------------------------------

        //------------------VEST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_LaneIn_int1_V_S2 = new DataCarQueue();
        P_LaneIn_int1_V_S2.Value.Size = 3;
        P_LaneIn_int1_V_S2.SetName("P_LaneIn_int1_V_S2");
        pn.PlaceList.add(P_LaneIn_int1_V_S2);

        //----------------------------T0_In_V_S2------------------------------- //T140
        PetriTransition T0_In_V_S2 = new PetriTransition(pn);
        T0_In_V_S2.TransitionName = "T0_In_V_S2";
        T0_In_V_S2.InputPlaceName.add("P_LaneIn_int1_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T0_In_V_S2_Ct11 = new Condition(T0_In_V_S2, "P_LaneIn_int1_V_S2", TransitionCondition.HaveTramForMe);
        Condition T0_In_V_S2_Ct12 = new Condition(T0_In_V_S2, "P_TramStationIn_CaleaFerentari_V_S2", TransitionCondition.CanAddCars);
        T0_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T0_In_V_S2_Ct12);
        GuardMapping grd1T0_In_V_S2 = new GuardMapping();
        grd1T0_In_V_S2.condition = T0_In_V_S2_Ct11;
        grd1T0_In_V_S2.Activations.add(new Activation(T0_In_V_S2, "P_LaneIn_int1_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_TramStationIn_CaleaFerentari_V_S2"));
        T0_In_V_S2.GuardMappingList.add(grd1T0_In_V_S2);

        T0_In_V_S2.Delay = 1;
        pn.Transitions.add(T0_In_V_S2);

        //----------------------------END T0_In_V_S2----------------------------------------

        //----------------------------T2_In_V_S1---------------------------------------- T106

        PetriTransition T2_In_V_S2 = new PetriTransition(pn);
        T2_In_V_S2.TransitionName = "T2_In_V_S2";
        T2_In_V_S2.InputPlaceName.add("P_TramStationIn_CaleaFerentari_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T2_In_V_S2_Ct11 = new Condition(T2_In_V_S2, "P_TramStationIn_CaleaFerentari_V_S2", TransitionCondition.HaveTram);
        Condition T2_In_V_S2_Ct12 = new Condition(T2_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.CanAddCars);
        T2_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T2_In_V_S2_Ct12);
        GuardMapping grd1T2_In_V_S2 = new GuardMapping();
        grd1T2_In_V_S2.condition = T2_In_V_S2_Ct11;
        grd1T2_In_V_S2.Activations.add(new Activation(T2_In_V_S2, "P_TramStationIn_CaleaFerentari_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_TramStationIn_CaleaFerentariOut_V_S2"));
        T2_In_V_S2.GuardMappingList.add(grd1T2_In_V_S2);

        T2_In_V_S2.Delay = 10;
        pn.Transitions.add(T2_In_V_S2);

        //----------------------------END T2_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int2_V_S2 = new DataCarQueue();
        P_LaneIn_int2_V_S2.Value.Size = 2;
        P_LaneIn_int2_V_S2.SetName("P_LaneIn_int2_V_S2");
        pn.PlaceList.add(P_LaneIn_int2_V_S2);

        DataCar P_Lane_LocusteanuOut_V_S2 = new DataCar();
        P_Lane_LocusteanuOut_V_S2.SetName("P_Lane_LocusteanuOut_V_S2");
        pn.PlaceList.add(P_Lane_LocusteanuOut_V_S2);

        //----------------------------T4_In_V_S2---------------------------------------- //T141
        PetriTransition T4_In_V_S2 = new PetriTransition(pn);
        T4_In_V_S2.TransitionName = "T4_In_V_S2";
        T4_In_V_S2.InputPlaceName.add("P_LaneIn_int1_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T4_In_V_S2_Ct11 = new Condition(T4_In_V_S2, "P_LaneIn_int1_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T4_In_V_S2 = new GuardMapping();
        grd1T4_In_V_S2.condition = T4_In_V_S2_Ct11;
        grd1T4_In_V_S2.Activations.add(new Activation(T4_In_V_S2, "P_LaneIn_int1_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_LocusteanuOut_V_S2"));
        T4_In_V_S2.GuardMappingList.add(grd1T4_In_V_S2);

        T4_In_V_S2.Delay = 1;
        pn.Transitions.add(T4_In_V_S2);
        //---------------------------- END T4_In_V_S2----------------------------------------

        //----------------------------T6_In_V_S2---------------------------------------- //T99
        PetriTransition T6_In_V_S2 = new PetriTransition(pn);
        T6_In_V_S2.TransitionName = "T6_In_V_S2";
        T6_In_V_S2.InputPlaceName.add("P_LaneIn_int1_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T6_In_V_S2_Ct11 = new Condition(T6_In_V_S2, "P_LaneIn_int1_V_S2", TransitionCondition.HaveCarForMe);
        Condition T6_In_V_S2_Ct12 = new Condition(T6_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.CanAddCars);
        T6_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T6_In_V_S2_Ct12);
        GuardMapping grd1T6_In_V_S2 = new GuardMapping();
        grd1T6_In_V_S2.condition = T6_In_V_S2_Ct11;
        grd1T6_In_V_S2.Activations.add(new Activation(T6_In_V_S2, "P_LaneIn_int1_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int2_V_S2"));
        T6_In_V_S2.GuardMappingList.add(grd1T6_In_V_S2);

        T6_In_V_S2.Delay = 1;
        pn.Transitions.add(T6_In_V_S2);
        //---------------------------- END T6_In_V_S1----------------------------------------

        DataCar P_Lane_LocusteanuIn_V_S2 = new DataCar();
        P_Lane_LocusteanuIn_V_S2.SetName("P_Lane_LocusteanuIn_V_S2");
        pn.PlaceList.add(P_Lane_LocusteanuIn_V_S2);

        DataCarQueue P_TramStationIn_CaleaFerentari_V_S2 = new DataCarQueue();
        P_TramStationIn_CaleaFerentari_V_S2.Value.Size = 1;
        P_TramStationIn_CaleaFerentari_V_S2.SetName("P_TramStationIn_CaleaFerentari_V_S2");
        pn.PlaceList.add(P_TramStationIn_CaleaFerentari_V_S2);

        DataCarQueue P_TramStationIn_CaleaFerentariOut_V_S2 = new DataCarQueue();
        P_TramStationIn_CaleaFerentariOut_V_S2.Value.Size = 1;
        P_TramStationIn_CaleaFerentariOut_V_S2.SetName("P_TramStationIn_CaleaFerentariOut_V_S2");
        pn.PlaceList.add(P_TramStationIn_CaleaFerentariOut_V_S2);

        //----------------------------T8_In_V_S1---------------------------------------- //T100
        PetriTransition T8_In_V_S2 = new PetriTransition(pn);
        T8_In_V_S2.TransitionName = "T8_In_V_S2";
        T8_In_V_S2.InputPlaceName.add("P_LaneIn_int2_V_S2");
        T8_In_V_S2.InputPlaceName.add("P_Lane_LocusteanuIn_V_S2");
        T8_In_V_S2.InputPlaceName.add("P_TramStationIn_CaleaFerentariOut_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T8_In_V_S2_Ct11 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.HaveCar);
        Condition T8_In_V_S2_Ct12 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.IsNull);
        Condition T8_In_V_S2_Ct13 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct14 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.DontHaveTram);
        T8_In_V_S2_Ct13.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct14);
        T8_In_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct13);
        T8_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct12);
        GuardMapping grd1T8_In_V_S2 = new GuardMapping();
        grd1T8_In_V_S2.condition = T8_In_V_S2_Ct11;
        grd1T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        T8_In_V_S2.GuardMappingList.add(grd1T8_In_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T8_In_V_S2_Ct21 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.DontHaveCar);
        Condition T8_In_V_S2_Ct22 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.NotNull);
        Condition T8_In_V_S2_Ct23 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct24 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.DontHaveTram);
        T8_In_V_S2_Ct23.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct24);
        T8_In_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct23);
        T8_In_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct22);
        GuardMapping grd2T8_In_V_S2 = new GuardMapping();
        grd2T8_In_V_S2.condition = T8_In_V_S2_Ct21;
        grd2T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        T8_In_V_S2.GuardMappingList.add(grd2T8_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T8_In_V_S2_Ct31 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.HaveCar);
        Condition T8_In_V_S2_Ct32 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T8_In_V_S2_Ct33 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct34 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.DontHaveTram);
        T8_In_V_S2_Ct33.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct34);
        T8_In_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct33);
        T8_In_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct32);
        GuardMapping grd3T8_In_V_S2 = new GuardMapping();
        grd3T8_In_V_S2.condition = T8_In_V_S2_Ct31;
        grd3T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int3_V_S2"));
        grd3T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        T8_In_V_S2.GuardMappingList.add(grd3T8_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T8_In_V_S2_Ct41 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.HaveCar);
        Condition T8_In_V_S2_Ct42 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.NotNull);
        Condition T8_In_V_S2_Ct43 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct44 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.DontHaveTram);
        T8_In_V_S2_Ct43.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct44);
        T8_In_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct43);
        T8_In_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct42);
        GuardMapping grd4T8_In_V_S2 = new GuardMapping();
        grd4T8_In_V_S2.condition = T8_In_V_S2_Ct41;
        grd4T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        grd4T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int3_V_S2"));
        T8_In_V_S2.GuardMappingList.add(grd4T8_In_V_S2);

        // --------------guard 5-------------------------------------------------------
        Condition T8_In_V_S2_Ct51 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.HaveCar);
        Condition T8_In_V_S2_Ct52 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.IsNull);
        Condition T8_In_V_S2_Ct53 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct54 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.HaveTram);
        T8_In_V_S2_Ct53.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct54);
        T8_In_V_S2_Ct52.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct53);
        T8_In_V_S2_Ct51.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct52);
        GuardMapping grd5T8_In_V_S2 = new GuardMapping();
        grd5T8_In_V_S2.condition = T8_In_V_S2_Ct51;
        grd5T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        grd5T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        T8_In_V_S2.GuardMappingList.add(grd5T8_In_V_S2);

        // --------------guard 6-------------------------------------------------------
        Condition T8_In_V_S2_Ct61 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.DontHaveCar);
        Condition T8_In_V_S2_Ct62 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.NotNull);
        Condition T8_In_V_S2_Ct63 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct64 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.HaveTram);
        T8_In_V_S2_Ct63.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct64);
        T8_In_V_S2_Ct62.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct63);
        T8_In_V_S2_Ct61.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct62);
        GuardMapping grd6T8_In_V_S2 = new GuardMapping();
        grd6T8_In_V_S2.condition = T8_In_V_S2_Ct61;
        grd6T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S1"));
        grd6T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        T8_In_V_S2.GuardMappingList.add(grd6T8_In_V_S2);

        // --------------guard 7-------------------------------------------------------
        Condition T8_In_V_S2_Ct71 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.HaveCar);
        Condition T8_In_V_S2_Ct72 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T8_In_V_S2_Ct73 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct74 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.HaveTram);
        T8_In_V_S2_Ct73.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct74);
        T8_In_V_S2_Ct72.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct73);
        T8_In_V_S2_Ct71.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct72);
        GuardMapping grd7T8_In_V_S2 = new GuardMapping();
        grd7T8_In_V_S2.condition = T8_In_V_S2_Ct71;
        grd7T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int3_V_S2"));
        grd7T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        grd7T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        T8_In_V_S2.GuardMappingList.add(grd7T8_In_V_S2);

        // --------------guard 8-------------------------------------------------------
        Condition T8_In_V_S2_Ct81 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.HaveCar);
        Condition T8_In_V_S2_Ct82 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.NotNull);
        Condition T8_In_V_S2_Ct83 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct84 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.HaveTram);
        T8_In_V_S2_Ct83.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct84);
        T8_In_V_S2_Ct82.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct83);
        T8_In_V_S2_Ct81.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct82);
        GuardMapping grd8T8_In_V_S2 = new GuardMapping();
        grd8T8_In_V_S2.condition = T8_In_V_S2_Ct81;
        grd8T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        grd8T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        grd8T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int3_V_S2"));
        T8_In_V_S2.GuardMappingList.add(grd8T8_In_V_S2);

        // --------------guard 9-------------------------------------------------------
        Condition T8_In_V_S2_Ct91 = new Condition(T8_In_V_S2, "P_LaneIn_int2_V_S2", TransitionCondition.DontHaveCar);
        Condition T8_In_V_S2_Ct92 = new Condition(T8_In_V_S2, "P_Lane_LocusteanuIn_V_S2", TransitionCondition.IsNull);
        Condition T8_In_V_S2_Ct93 = new Condition(T8_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.CanAddCars);
        Condition T8_In_V_S2_Ct94 = new Condition(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionCondition.HaveTram);
        T8_In_V_S2_Ct93.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct94);
        T8_In_V_S2_Ct92.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct93);
        T8_In_V_S2_Ct91.SetNextCondition(LogicConnector.AND, T8_In_V_S2_Ct92);
        GuardMapping grd9T8_In_V_S2 = new GuardMapping();
        grd9T8_In_V_S2.condition = T8_In_V_S2_Ct91;
        grd9T8_In_V_S2.Activations.add(new Activation(T8_In_V_S2, "P_TramStationIn_CaleaFerentariOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        T8_In_V_S2.GuardMappingList.add(grd9T8_In_V_S2);

        T8_In_V_S2.Delay = 1;
        pn.Transitions.add(T8_In_V_S2);
        //----------------------END T8_In_V_S2-------------------------------------

        DataCarQueue P_LaneIn_int3_V_S2 = new DataCarQueue();
        P_LaneIn_int3_V_S2.Value.Size = 3;
        P_LaneIn_int3_V_S2.SetName("P_LaneIn_int3_V_S2");
        pn.PlaceList.add(P_LaneIn_int3_V_S2);

        //----------------------------T10_In_V_S2---------------------------------------- //T101
        PetriTransition T10_In_V_S2 = new PetriTransition(pn);
        T10_In_V_S2.TransitionName = "T10_In_V_S2";
        T10_In_V_S2.InputPlaceName.add("P_LaneIn_int3_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T10_In_V_S2_Ct11 = new Condition(T10_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.HaveCarForMe);
        Condition T10_In_V_S2_Ct12 = new Condition(T10_In_V_S2, "P_LaneIn_int4_V_S2", TransitionCondition.CanAddCars);
        T10_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T10_In_V_S2_Ct12);
        GuardMapping grd1T10_In_V_S2 = new GuardMapping();
        grd1T10_In_V_S2.condition = T10_In_V_S2_Ct11;
        grd1T10_In_V_S2.Activations.add(new Activation(T10_In_V_S2, "P_LaneIn_int3_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int4_V_S2"));
        T10_In_V_S2.GuardMappingList.add(grd1T10_In_V_S2);

        T10_In_V_S2.Delay = 1;
        pn.Transitions.add(T10_In_V_S2);
        //---------------------------- END T10_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int4_V_S2 = new DataCarQueue();
        P_LaneIn_int4_V_S2.Value.Size = 3;
        P_LaneIn_int4_V_S2.SetName("P_LaneIn_int4_V_S2");
        pn.PlaceList.add(P_LaneIn_int4_V_S2);

        //----------------------------T12_In_V_S2---------------------------------------- T142

        PetriTransition T12_In_V_S2 = new PetriTransition(pn);
        T12_In_V_S2.TransitionName = "T12_In_V_S2";
        T12_In_V_S2.InputPlaceName.add("P_LaneIn_int3_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T12_In_V_S2_Ct11 = new Condition(T12_In_V_S2, "P_LaneIn_int3_V_S2", TransitionCondition.HaveBusForMe);
        Condition T12_In_V_S2_Ct12 = new Condition(T12_In_V_S2, "P_BusStation_CaleaRahovei_V_S2", TransitionCondition.CanAddCars);
        T12_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T12_In_V_S2_Ct12);
        GuardMapping grd1T12_In_V_S2 = new GuardMapping();
        grd1T12_In_V_S2.condition = T12_In_V_S2_Ct11;
        grd1T12_In_V_S2.Activations.add(new Activation(T12_In_V_S2, "P_LaneIn_int3_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_BusStation_CaleaRahovei_V_S2"));
        T12_In_V_S2.GuardMappingList.add(grd1T12_In_V_S2);

        T12_In_V_S2.Delay = 1;
        pn.Transitions.add(T12_In_V_S2);

        //----------------------------END T12_In_V_S2----------------------------------------


        DataCarQueue P_BusStation_CaleaRahovei_V_S2 = new DataCarQueue();
        P_BusStation_CaleaRahovei_V_S2.Value.Size = 2;
        P_BusStation_CaleaRahovei_V_S2.SetName("P_BusStation_CaleaRahovei_V_S2");
        pn.PlaceList.add(P_BusStation_CaleaRahovei_V_S2);

        //----------------------------T14_In_V_S2---------------------------------------- T88
        PetriTransition T14_In_V_S2 = new PetriTransition(pn);
        T14_In_V_S2.TransitionName = "T14_In_V_S2";
        T14_In_V_S2.InputPlaceName.add("P_BusStation_CaleaRahovei_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T14_In_V_S2_Ct11 = new Condition(T14_In_V_S2, "P_BusStation_CaleaRahovei_V_S2", TransitionCondition.HaveBus);
        Condition T14_In_V_S2_Ct12 = new Condition(T14_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionCondition.CanAddCars);
        T14_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T14_In_V_S2_Ct12);
        GuardMapping grd1T14_In_V_S2 = new GuardMapping();
        grd1T14_In_V_S2.condition = T14_In_V_S2_Ct11;
        grd1T14_In_V_S2.Activations.add(new Activation(T14_In_V_S2, "P_BusStation_CaleaRahovei_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_BusStation_CaleaRahoveiOut_V_S2"));
        T14_In_V_S2.GuardMappingList.add(grd1T14_In_V_S2);

        T14_In_V_S2.Delay = 10;
        pn.Transitions.add(T14_In_V_S2);
        //----------------------------END T14_In_V_S2----------------------------------------

        DataCarQueue P_BusStation_CaleaRahoveiOut_V_S2 = new DataCarQueue();
        P_BusStation_CaleaRahoveiOut_V_S2.Value.Size = 2;
        P_BusStation_CaleaRahoveiOut_V_S2.SetName("P_BusStation_CaleaRahoveiOut_V_S2");
        pn.PlaceList.add(P_BusStation_CaleaRahoveiOut_V_S2);

        //----------------------------T16_In_V_S2---------------------------------------- T102
        PetriTransition T16_In_V_S2 = new PetriTransition(pn);
        T16_In_V_S2.TransitionName = "T16_In_V_S2";
        T16_In_V_S2.InputPlaceName.add("P_LaneIn_int4_V_S2");
        T16_In_V_S2.InputPlaceName.add("P_BusStation_CaleaRahoveiOut_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T16_In_V_S2_Ct11 = new Condition(T16_In_V_S2, "P_LaneIn_int4_V_S2", TransitionCondition.HaveCar);
        Condition T16_In_V_S2_Ct12 = new Condition(T16_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionCondition.DontHaveBus);
        Condition T16_In_V_S2_Ct13 = new Condition(T16_In_V_S2, "P_LaneIn_int5_V_S2", TransitionCondition.CanAddCars);
        T16_In_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct13);
        T16_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct12);
        GuardMapping grd1T16_In_V_S2 = new GuardMapping();
        grd1T16_In_V_S2.condition = T16_In_V_S2_Ct11;
        grd1T16_In_V_S2.Activations.add(new Activation(T16_In_V_S2, "P_LaneIn_int4_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S2"));
        T16_In_V_S2.GuardMappingList.add(grd1T16_In_V_S2);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T16_In_V_S2_Ct21 = new Condition(T16_In_V_S2, "P_LaneIn_int4_V_S2", TransitionCondition.DontHaveCar);
        Condition T16_In_V_S2_Ct22 = new Condition(T16_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionCondition.HaveBus);
        Condition T16_In_V_S2_Ct23 = new Condition(T16_In_V_S2, "P_LaneIn_int5_V_S2", TransitionCondition.CanAddCars);
        T16_In_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct23);
        T16_In_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct22);
        GuardMapping grd2T16_In_V_S2 = new GuardMapping();
        grd2T16_In_V_S2.condition = T16_In_V_S2_Ct21;
        grd2T16_In_V_S2.Activations.add(new Activation(T16_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S2"));
        T16_In_V_S2.GuardMappingList.add(grd2T16_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T16_In_V_S2_Ct31 = new Condition(T16_In_V_S2, "P_LaneIn_int4_V_S2", TransitionCondition.HavePriorityCar);
        Condition T16_In_V_S2_Ct32 = new Condition(T16_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionCondition.HaveBus);
        Condition T16_In_V_S2_Ct33 = new Condition(T16_In_V_S2, "P_LaneIn_int5_V_S2", TransitionCondition.CanAddCars);
        T16_In_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct33);
        T16_In_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct32);
        GuardMapping grd3T16_In_V_S2 = new GuardMapping();
        grd3T16_In_V_S2.condition = T16_In_V_S2_Ct31;
        grd3T16_In_V_S2.Activations.add(new Activation(T16_In_V_S2, "P_LaneIn_int4_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S2"));
        grd3T16_In_V_S2.Activations.add(new Activation(T16_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S2"));
        T16_In_V_S2.GuardMappingList.add(grd3T16_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T16_In_V_S2_Ct41 = new Condition(T16_In_V_S2, "P_LaneIn_int4_V_S2", TransitionCondition.HaveCar);
        Condition T16_In_V_S2_Ct42 = new Condition(T16_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionCondition.HaveBus);
        Condition T16_In_V_S2_Ct43 = new Condition(T16_In_V_S2, "P_LaneIn_int5_V_S2", TransitionCondition.CanAddCars);
        T16_In_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct43);
        T16_In_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T16_In_V_S2_Ct42);
        GuardMapping grd4T16_In_V_S2 = new GuardMapping();
        grd4T16_In_V_S2.condition = T16_In_V_S2_Ct41;
        grd4T16_In_V_S2.Activations.add(new Activation(T16_In_V_S2, "P_BusStation_CaleaRahoveiOut_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S2"));
        grd4T16_In_V_S2.Activations.add(new Activation(T16_In_V_S2, "P_LaneIn_int4_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S2"));
        T16_In_V_S2.GuardMappingList.add(grd4T16_In_V_S2);

        T16_In_V_S2.Delay = 1;
        pn.Transitions.add(T16_In_V_S2);

        //----------------------------END T16_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int5_V_S2 = new DataCarQueue();
        P_LaneIn_int5_V_S2.Value.Size = 3;
        P_LaneIn_int5_V_S2.SetName("P_LaneIn_int5_V_S2");
        pn.PlaceList.add(P_LaneIn_int5_V_S2);

        //----------------------------T18_In_V_S2---------------------------------------- //T104
        PetriTransition T18_In_V_S2 = new PetriTransition(pn);
        T18_In_V_S2.TransitionName = "T18_In_V_S2";
        T18_In_V_S2.InputPlaceName.add("P_LaneIn_int5_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T18_In_V_S2_Ct11 = new Condition(T18_In_V_S2, "P_LaneIn_int5_V_S2", TransitionCondition.HaveCarForMe);
        Condition T18_In_V_S2_Ct12 = new Condition(T18_In_V_S2, "P_LaneIn_int6_V_S2", TransitionCondition.CanAddCars);
        T18_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T18_In_V_S2_Ct12);
        GuardMapping grd1T18_In_V_S2 = new GuardMapping();
        grd1T18_In_V_S2.condition = T18_In_V_S2_Ct11;
        grd1T18_In_V_S2.Activations.add(new Activation(T18_In_V_S2, "P_LaneIn_int5_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int6_V_S2"));
        T18_In_V_S2.GuardMappingList.add(grd1T18_In_V_S2);

        T18_In_V_S2.Delay = 1;
        pn.Transitions.add(T18_In_V_S2);
        //---------------------------- END T18_In_V_S2----------------------------------------

        DataCar P_Lane_OlaruOut_V_S2 = new DataCar();
        P_Lane_OlaruOut_V_S2.SetName("P_Lane_OlaruOut_V_S2");
        pn.PlaceList.add(P_Lane_OlaruOut_V_S2);

        DataCar P_Lane_OlaruIn_V_S2 = new DataCar();
        P_Lane_OlaruIn_V_S2.SetName("P_Lane_OlaruIn_V_S2");
        pn.PlaceList.add(P_Lane_OlaruIn_V_S2);

        //----------------------------T20_In_V_S2---------------------------------------- //T114
        PetriTransition T20_In_V_S2 = new PetriTransition(pn);
        T20_In_V_S2.TransitionName = "T20_In_V_S2";
        T20_In_V_S2.InputPlaceName.add("P_LaneIn_int5_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T20_In_V_S2_Ct11 = new Condition(T20_In_V_S2, "P_LaneIn_int5_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T20_In_V_S2 = new GuardMapping();
        grd1T20_In_V_S2.condition = T20_In_V_S2_Ct11;
        grd1T20_In_V_S2.Activations.add(new Activation(T20_In_V_S2, "P_LaneIn_int5_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_OlaruOut_V_S2"));
        T20_In_V_S2.GuardMappingList.add(grd1T20_In_V_S2);

        T20_In_V_S2.Delay = 1;
        pn.Transitions.add(T20_In_V_S2);
        //---------------------------- END T20_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int6_V_S2 = new DataCarQueue();
        P_LaneIn_int6_V_S2.Value.Size = 3;
        P_LaneIn_int6_V_S2.SetName("P_LaneIn_int6_V_S2");
        pn.PlaceList.add(P_LaneIn_int6_V_S2);

        //----------------------------T22_In_V_S2---------------------------------------- //T105
        PetriTransition T22_In_V_S2 = new PetriTransition(pn);
        T22_In_V_S2.TransitionName = "T22_In_V_S2";
        T22_In_V_S2.InputPlaceName.add("P_LaneIn_int6_V_S2");
        T22_In_V_S2.InputPlaceName.add("P_Lane_OlaruIn_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T22_In_V_S2_Ct11 = new Condition(T22_In_V_S2, "P_LaneIn_int6_V_S2", TransitionCondition.HaveCar);
        Condition T22_In_V_S2_Ct12 = new Condition(T22_In_V_S2, "P_Lane_OlaruIn_V_S2", TransitionCondition.IsNull);
        Condition T22_In_V_S2_Ct13 = new Condition(T22_In_V_S2, "P_LaneIn_int7_V_S2", TransitionCondition.CanAddCars);
        T22_In_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct13);
        T22_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct12);
        GuardMapping grd1T22_In_V_S2 = new GuardMapping();
        grd1T22_In_V_S2.condition = T22_In_V_S2_Ct11;
        grd1T22_In_V_S2.Activations.add(new Activation(T22_In_V_S2, "P_LaneIn_int6_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int7_V_S2"));
        T22_In_V_S2.GuardMappingList.add(grd1T22_In_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T22_In_V_S2_Ct21 = new Condition(T22_In_V_S2, "P_LaneIn_int6_V_S2", TransitionCondition.DontHaveCar);
        Condition T22_In_V_S2_Ct22 = new Condition(T22_In_V_S2, "P_Lane_OlaruIn_V_S2", TransitionCondition.NotNull);
        Condition T22_In_V_S2_Ct23 = new Condition(T22_In_V_S2, "P_LaneIn_int7_V_S2", TransitionCondition.CanAddCars);
        T22_In_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct23);
        T22_In_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct22);
        GuardMapping grd2T22_In_V_S2 = new GuardMapping();
        grd2T22_In_V_S2.condition = T22_In_V_S2_Ct21;
        grd2T22_In_V_S2.Activations.add(new Activation(T22_In_V_S2, "P_Lane_OlaruIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int7_V_S2"));
        T22_In_V_S2.GuardMappingList.add(grd2T22_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T22_In_V_S2_Ct31 = new Condition(T22_In_V_S2, "P_LaneIn_int6_V_S2", TransitionCondition.HaveCar);
        Condition T22_In_V_S2_Ct32 = new Condition(T22_In_V_S2, "P_Lane_OlaruIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T22_In_V_S2_Ct33 = new Condition(T22_In_V_S2, "P_LaneIn_int7_V_S2", TransitionCondition.CanAddCars);
        T22_In_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct33);
        T22_In_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct32);
        GuardMapping grd3T22_In_V_S2 = new GuardMapping();
        grd3T22_In_V_S2.condition = T22_In_V_S2_Ct31;
        grd3T22_In_V_S2.Activations.add(new Activation(T22_In_V_S2, "P_Lane_OlaruIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int7_V_S2"));
        grd3T22_In_V_S2.Activations.add(new Activation(T22_In_V_S2, "P_LaneIn_int6_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int7_V_S2"));
        T22_In_V_S2.GuardMappingList.add(grd3T22_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T22_In_V_S2_Ct41 = new Condition(T22_In_V_S2, "P_LaneIn_int6_V_S2", TransitionCondition.HaveCar);
        Condition T22_In_V_S2_Ct42 = new Condition(T22_In_V_S2, "P_Lane_OlaruIn_V_S2", TransitionCondition.NotNull);
        Condition T22_In_V_S2_Ct43 = new Condition(T22_In_V_S2, "P_LaneIn_int7_V_S2", TransitionCondition.CanAddCars);
        T22_In_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct43);
        T22_In_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T22_In_V_S2_Ct42);
        GuardMapping grd4T22_In_V_S2 = new GuardMapping();
        grd4T22_In_V_S2.condition = T22_In_V_S2_Ct41;
        grd4T22_In_V_S2.Activations.add(new Activation(T22_In_V_S2, "P_LaneIn_int6_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int7_V_S2"));
        grd4T22_In_V_S2.Activations.add(new Activation(T22_In_V_S2, "P_Lane_OlaruIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int7_V_S2"));
        T22_In_V_S2.GuardMappingList.add(grd4T22_In_V_S2);

        T22_In_V_S2.Delay = 1;
        pn.Transitions.add(T22_In_V_S2);
        //----------------------------END T22_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int7_V_S2 = new DataCarQueue();
        P_LaneIn_int7_V_S2.Value.Size = 3;
        P_LaneIn_int7_V_S2.SetName("P_LaneIn_int7_V_S2");
        pn.PlaceList.add(P_LaneIn_int7_V_S2);

        //-------------------OUT--------------------------
        DataCarQueue P_LaneOut_Int1_V_S2 = new DataCarQueue();
        P_LaneOut_Int1_V_S2.SetName("P_LaneOut_Int1_V_S2");
        P_LaneOut_Int1_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int1_V_S2);

        DataCar P_Lane_TocilescuIn_V_S2 = new DataCar();
        P_Lane_TocilescuIn_V_S2.SetName("P_Lane_TocilescuIn_V_S2");
        pn.PlaceList.add(P_Lane_TocilescuIn_V_S2);

        DataCarQueue P_LaneOut_Int2_V_S2 = new DataCarQueue();
        P_LaneOut_Int2_V_S2.Value.Size = 2;
        P_LaneOut_Int2_V_S2.SetName("P_LaneOut_Int2_V_S2");
        pn.PlaceList.add(P_LaneOut_Int2_V_S2);

        DataCarQueue P_TramStationOut_CaleaFerentari_V_Out_S2 = new DataCarQueue();
        P_TramStationOut_CaleaFerentari_V_Out_S2.SetName("P_TramStationOut_CaleaFerentari_V_Out_S2");
        P_TramStationOut_CaleaFerentari_V_Out_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStationOut_CaleaFerentari_V_Out_S2);

        //----------------------------T1_Out_V_S2---------------------------------------- //T90
        PetriTransition T1_Out_V_S2 = new PetriTransition(pn);
        T1_Out_V_S2.TransitionName = "T1_Out_V_S2";
        T1_Out_V_S2.InputPlaceName.add("P_LaneOut_Int2_V_S2");
        T1_Out_V_S2.InputPlaceName.add("P_Lane_TocilescuIn_V_S2");
        T1_Out_V_S2.InputPlaceName.add("P_TramStationOut_CaleaFerentari_V_Out_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T1_Out_V_S2_Ct11 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.HaveCar);
        Condition T1_Out_V_S2_Ct12 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.IsNull);
        Condition T1_Out_V_S2_Ct13 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct14 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.DontHaveTram);
        T1_Out_V_S2_Ct13.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct14);
        T1_Out_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct13);
        T1_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct12);
        GuardMapping grd1T1_Out_V_S2 = new GuardMapping();
        grd1T1_Out_V_S2.condition = T1_Out_V_S2_Ct11;
        grd1T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd1T1_Out_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T1_Out_V_S2_Ct21 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.DontHaveCar);
        Condition T1_Out_V_S2_Ct22 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.NotNull);
        Condition T1_Out_V_S2_Ct23 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct24 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.DontHaveTram);
        T1_Out_V_S2_Ct23.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct24);
        T1_Out_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct23);
        T1_Out_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct22);
        GuardMapping grd2T1_Out_V_S2 = new GuardMapping();
        grd2T1_Out_V_S2.condition = T1_Out_V_S2_Ct21;
        grd2T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd2T1_Out_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T1_Out_V_S2_Ct31 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.HaveCar);
        Condition T1_Out_V_S2_Ct32 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T1_Out_V_S2_Ct33 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct34 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.DontHaveTram);
        T1_Out_V_S2_Ct33.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct34);
        T1_Out_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct33);
        T1_Out_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct32);
        GuardMapping grd3T1_Out_V_S2 = new GuardMapping();
        grd3T1_Out_V_S2.condition = T1_Out_V_S2_Ct31;
        grd3T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S2"));
        grd3T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd3T1_Out_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T1_Out_V_S2_Ct41 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.HaveCar);
        Condition T1_Out_V_S2_Ct42 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.NotNull);
        Condition T1_Out_V_S2_Ct43 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct44 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.DontHaveTram);
        T1_Out_V_S2_Ct43.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct44);
        T1_Out_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct43);
        T1_Out_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct42);
        GuardMapping grd4T1_Out_V_S2 = new GuardMapping();
        grd4T1_Out_V_S2.condition = T1_Out_V_S2_Ct41;
        grd4T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        grd4T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd4T1_Out_V_S2);

        // --------------guard 5-------------------------------------------------------
        Condition T1_Out_V_S2_Ct51 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.HaveCar);
        Condition T1_Out_V_S2_Ct52 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.IsNull);
        Condition T1_Out_V_S2_Ct53 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct54 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.HaveTram);
        T1_Out_V_S2_Ct53.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct54);
        T1_Out_V_S2_Ct52.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct53);
        T1_Out_V_S2_Ct51.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct52);
        GuardMapping grd5T1_Out_V_S2 = new GuardMapping();
        grd5T1_Out_V_S2.condition = T1_Out_V_S2_Ct51;
        grd5T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        grd5T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd5T1_Out_V_S2);

        // --------------guard 6-------------------------------------------------------
        Condition T1_Out_V_S2_Ct61 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.DontHaveCar);
        Condition T1_Out_V_S2_Ct62 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.NotNull);
        Condition T1_Out_V_S2_Ct63 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct64 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.HaveTram);
        T1_Out_V_S2_Ct63.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct64);
        T1_Out_V_S2_Ct62.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct63);
        T1_Out_V_S2_Ct61.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct62);
        GuardMapping grd6T1_Out_V_S2 = new GuardMapping();
        grd6T1_Out_V_S2.condition = T1_Out_V_S2_Ct61;
        grd6T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        grd6T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd6T1_Out_V_S2);

        // --------------guard 7-------------------------------------------------------
        Condition T1_Out_V_S2_Ct71 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.HaveCar);
        Condition T1_Out_V_S2_Ct72 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T1_Out_V_S2_Ct73 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct74 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.HaveTram);
        T1_Out_V_S2_Ct73.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct74);
        T1_Out_V_S2_Ct72.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct73);
        T1_Out_V_S2_Ct71.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct72);
        GuardMapping grd7T1_Out_V_S2 = new GuardMapping();
        grd7T1_Out_V_S2.condition = T1_Out_V_S2_Ct71;
        grd7T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S2"));
        grd7T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        grd7T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd7T1_Out_V_S2);

        // --------------guard 8-------------------------------------------------------
        Condition T1_Out_V_S2_Ct81 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.HaveCar);
        Condition T1_Out_V_S2_Ct82 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.NotNull);
        Condition T1_Out_V_S2_Ct83 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct84 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.HaveTram);
        T1_Out_V_S2_Ct83.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct84);
        T1_Out_V_S2_Ct82.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct83);
        T1_Out_V_S2_Ct81.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct82);
        GuardMapping grd8T1_Out_V_S2 = new GuardMapping();
        grd8T1_Out_V_S2.condition = T1_Out_V_S2_Ct81;
        grd8T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        grd8T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        grd8T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd8T1_Out_V_S2);

        // --------------guard 9-------------------------------------------------------
        Condition T1_Out_V_S2_Ct91 = new Condition(T1_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.DontHaveCar);
        Condition T1_Out_V_S2_Ct92 = new Condition(T1_Out_V_S2, "P_Lane_TocilescuIn_V_S2", TransitionCondition.IsNull);
        Condition T1_Out_V_S2_Ct93 = new Condition(T1_Out_V_S2, "P_LaneOut_Int1_V_S2", TransitionCondition.CanAddCars);
        Condition T1_Out_V_S2_Ct94 = new Condition(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.HaveTram);
        T1_Out_V_S2_Ct93.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct94);
        T1_Out_V_S2_Ct92.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct93);
        T1_Out_V_S2_Ct91.SetNextCondition(LogicConnector.AND, T1_Out_V_S2_Ct92);
        GuardMapping grd9T1_Out_V_S2 = new GuardMapping();
        grd9T1_Out_V_S2.condition = T1_Out_V_S2_Ct91;
        grd9T1_Out_V_S2.Activations.add(new Activation(T1_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S2"));
        T1_Out_V_S2.GuardMappingList.add(grd9T1_Out_V_S2);

        T1_Out_V_S2.Delay = 1;
        pn.Transitions.add(T1_Out_V_S2);
        //----------------------END T1_Out_V_S2-------------------------------------

        DataCar P_Lane_TocilescuOut_V_S2 = new DataCar();
        P_Lane_TocilescuOut_V_S2.SetName("P_Lane_TocilescuOut_V_S2");
        pn.PlaceList.add(P_Lane_TocilescuOut_V_S2);

        DataCarQueue P_TramStationOut_CaleaFerentari_V_S2 = new DataCarQueue();
        P_TramStationOut_CaleaFerentari_V_S2.SetName("P_TramStationOut_CaleaFerentari_V_S2");
        P_TramStationOut_CaleaFerentari_V_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStationOut_CaleaFerentari_V_S2);

        DataCarQueue P_LaneOut_Int3_V_S2 = new DataCarQueue();
        P_LaneOut_Int3_V_S2.SetName("P_LaneOut_Int3_V_S2");
        P_LaneOut_Int3_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int3_V_S2);

        //----------------------------T3_Out_V_S2---------------------------------------- T139

        PetriTransition T3_Out_V_S2 = new PetriTransition(pn);
        T3_Out_V_S2.TransitionName = "T3_Out_V_S2";
        T3_Out_V_S2.InputPlaceName.add("P_LaneOut_Int3_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T3_Out_V_S2_Ct11 = new Condition(T3_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T3_Out_V_S2 = new GuardMapping();
        grd1T3_Out_V_S2.condition= T3_Out_V_S2_Ct11;
        grd1T3_Out_V_S2.Activations.add(new Activation(T3_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_TocilescuOut_V_S2"));
        T3_Out_V_S2.GuardMappingList.add(grd1T3_Out_V_S2);
        T3_Out_V_S2.Delay = 1;
        pn.Transitions.add(T3_Out_V_S2);

        //----------------------------END T3_Out_V_S2----------------------------------------

        //----------------------------T5_Out_V_S2----------------------------------------

        PetriTransition T5_Out_V_S2 = new PetriTransition(pn);
        T5_Out_V_S2.TransitionName = "T5_Out_V_S2";
        T5_Out_V_S2.InputPlaceName.add("P_LaneOut_Int3_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T5_Out_V_S2_Ct11 = new Condition(T5_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionCondition.HaveCarForMe);
        Condition T5_Out_V_S2_Ct12 = new Condition(T5_Out_V_S2, "P_LaneOut_Int2_V_S2", TransitionCondition.CanAddCars);
        GuardMapping grd1T5_Out_V_S2 = new GuardMapping();
        T5_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T5_Out_V_S2_Ct12);
        grd1T5_Out_V_S2.condition= T5_Out_V_S2_Ct11;
        grd1T5_Out_V_S2.Activations.add(new Activation(T5_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int2_V_S2"));
        T5_Out_V_S2.GuardMappingList.add(grd1T5_Out_V_S2);
        T5_Out_V_S2.Delay = 1;
        pn.Transitions.add(T5_Out_V_S2);

        //----------------------------END T5_Out_V_S2----------------------------------------

        //----------------------------T7_Out_V_S2-------------------------------
        PetriTransition T7_Out_V_S2 = new PetriTransition(pn);
        T7_Out_V_S2.TransitionName = "T7_Out_V_S2";
        T7_Out_V_S2.InputPlaceName.add("P_LaneOut_Int3_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T7_Out_V_S2_Ct11 = new Condition(T7_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionCondition.HaveTramForMe);
        Condition T7_Out_V_S2_Ct12 = new Condition(T7_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_S2", TransitionCondition.CanAddCars);
        T7_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T7_Out_V_S2_Ct12);
        GuardMapping grd1T7_Out_V_S2 = new GuardMapping();
        grd1T7_Out_V_S2.condition = T7_Out_V_S2_Ct11;
        grd1T7_Out_V_S2.Activations.add(new Activation(T7_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_TramStationOut_CaleaFerentari_V_S2"));
        T7_Out_V_S2.GuardMappingList.add(grd1T7_Out_V_S2);

        T7_Out_V_S2.Delay = 1;
        pn.Transitions.add(T7_Out_V_S2);

        //----------------------------END T7_Out_V_S2----------------------------------------

        //----------------------------T9_Out_V_S2----------------------------------------

        PetriTransition T9_Out_V_S2 = new PetriTransition(pn);
        T9_Out_V_S2.TransitionName = "T9_Out_V_S2";
        T9_Out_V_S2.InputPlaceName.add("P_TramStationOut_CaleaFerentari_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T9_Out_V_S2_Ct11 = new Condition(T9_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_S2", TransitionCondition.HaveTram);
        Condition T9_Out_V_S2_Ct12 = new Condition(T9_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_Out_S2", TransitionCondition.CanAddCars);
        T9_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T9_Out_V_S2_Ct12);
        GuardMapping grd1T9_Out_V_S2 = new GuardMapping();
        grd1T9_Out_V_S2.condition = T9_Out_V_S2_Ct11;
        grd1T9_Out_V_S2.Activations.add(new Activation(T9_Out_V_S2, "P_TramStationOut_CaleaFerentari_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_TramStationOut_CaleaFerentari_V_Out_S2"));
        T9_Out_V_S2.GuardMappingList.add(grd1T9_Out_V_S2);

        T9_Out_V_S2.Delay = 10;
        pn.Transitions.add(T9_Out_V_S2);

        //----------------------------END T9_Out_V_S2----------------------------------------

        DataCarQueue P_Lane_PoenaruIn_V_S2 = new DataCarQueue();
        P_Lane_PoenaruIn_V_S2.SetName("P_Lane_PoenaruIn_V_S2");
        P_Lane_PoenaruIn_V_S2.Value.Size = 2;
        pn.PlaceList.add(P_Lane_PoenaruIn_V_S2);

        DataCarQueue P_LaneOut_Int4_V_S2 = new DataCarQueue();
        P_LaneOut_Int4_V_S2.SetName("P_LaneOut_Int4_V_S2");
        P_LaneOut_Int4_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int4_V_S2);

        //----------------------------T11_Out_V_S2----------------------------------------

        PetriTransition T11_Out_V_S2 = new PetriTransition(pn);
        T11_Out_V_S2.TransitionName = "T11_Out_V_S2";
        T11_Out_V_S2.InputPlaceName.add("P_LaneOut_Int4_V_S2");
        T11_Out_V_S2.InputPlaceName.add("P_Lane_PoenaruIn_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T11_Out_V_S2_Ct11 = new Condition(T11_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.HaveCar);
        Condition T11_Out_V_S2_Ct12 = new Condition(T11_Out_V_S2, "P_Lane_PoenaruIn_V_S2", TransitionCondition.DontHaveCar);
        Condition T11_Out_V_S2_Ct13 = new Condition(T11_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionCondition.CanAddCars);
        T11_Out_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct13);
        T11_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct12);
        GuardMapping grd1T11_Out_V_S2 = new GuardMapping();
        grd1T11_Out_V_S2.condition = T11_Out_V_S2_Ct11;
        grd1T11_Out_V_S2.Activations.add(new Activation(T11_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int3_V_S2"));
        T11_Out_V_S2.GuardMappingList.add(grd1T11_Out_V_S2);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T11_Out_V_S2_Ct21 = new Condition(T11_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.DontHaveCar);
        Condition T11_Out_V_S2_Ct22 = new Condition(T11_Out_V_S2, "P_Lane_PoenaruIn_V_S2", TransitionCondition.HaveCar);
        Condition T11_Out_V_S2_Ct23 = new Condition(T11_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionCondition.CanAddCars);
        T11_Out_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct23);
        T11_Out_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct22);
        GuardMapping grd2T11_Out_V_S2 = new GuardMapping();
        grd2T11_Out_V_S2.condition = T11_Out_V_S2_Ct21;
        grd2T11_Out_V_S2.Activations.add(new Activation(T11_Out_V_S2, "P_Lane_PoenaruIn_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int3_V_S2"));
        T11_Out_V_S2.GuardMappingList.add(grd2T11_Out_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T11_Out_V_S2_Ct31 = new Condition(T11_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.HaveCar);
        Condition T11_Out_V_S2_Ct32 = new Condition(T11_Out_V_S2, "P_Lane_PoenaruIn_V_S2", TransitionCondition.HavePriorityCar);
        Condition T11_Out_V_S2_Ct33 = new Condition(T11_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionCondition.CanAddCars);
        T11_Out_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct33);
        T11_Out_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct32);
        GuardMapping grd3T11_Out_V_S2 = new GuardMapping();
        grd3T11_Out_V_S2.condition = T11_Out_V_S2_Ct31;
        grd3T11_Out_V_S2.Activations.add(new Activation(T11_Out_V_S2, "P_Lane_PoenaruIn_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int3_V_S2"));
        grd3T11_Out_V_S2.Activations.add(new Activation(T11_Out_V_S2, "P_LaneOut_Int4_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int3_V_S2"));
        T11_Out_V_S2.GuardMappingList.add(grd3T11_Out_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T11_Out_V_S2_Ct41 = new Condition(T11_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.HaveCar);
        Condition T11_Out_V_S2_Ct42 = new Condition(T11_Out_V_S2, "P_Lane_PoenaruIn_V_S2", TransitionCondition.HaveCar);
        Condition T11_Out_V_S2_Ct43 = new Condition(T11_Out_V_S2, "P_LaneOut_Int3_V_S2", TransitionCondition.CanAddCars);
        T11_Out_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct43);
        T11_Out_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T11_Out_V_S2_Ct42);
        GuardMapping grd4T11_Out_V_S2 = new GuardMapping();
        grd4T11_Out_V_S2.condition = T11_Out_V_S2_Ct41;
        grd4T11_Out_V_S2.Activations.add(new Activation(T11_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int3_V_S2"));
        grd4T11_Out_V_S2.Activations.add(new Activation(T11_Out_V_S2, "P_Lane_PoenaruIn_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int3_V_S2"));
        T11_Out_V_S2.GuardMappingList.add(grd4T11_Out_V_S2);

        T11_Out_V_S2.Delay = 1;
        pn.Transitions.add(T11_Out_V_S2);

        //----------------------------END T11_Out_V_S2----------------------------------------

        DataCar P_Lane_LidlIn_V_S2 = new DataCar();
        P_Lane_LidlIn_V_S2.SetName("P_Lane_LidlIn_V_S2");
        pn.PlaceList.add(P_Lane_LidlIn_V_S2);

        DataCarQueue P_LaneOut_Int5_V_S2 = new DataCarQueue();
        P_LaneOut_Int5_V_S2.SetName("P_LaneOut_Int5_V_S2");
        P_LaneOut_Int5_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int5_V_S2);

        //----------------------------T13_Out_V_S2----------------------------------------

        PetriTransition T13_Out_V_S2 = new PetriTransition(pn);
        T13_Out_V_S2.TransitionName = "T13_Out_V_S2";
        T13_Out_V_S2.InputPlaceName.add("P_LaneOut_Int5_V_S2");
        T13_Out_V_S2.InputPlaceName.add("P_Lane_LidlIn_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T13_Out_V_S2_Ct11 = new Condition(T13_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionCondition.HaveCar);
        Condition T13_Out_V_S2_Ct12 = new Condition(T13_Out_V_S2, "P_Lane_LidlIn_V_S2", TransitionCondition.IsNull);
        Condition T13_Out_V_S2_Ct13 = new Condition(T13_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.CanAddCars);
        T13_Out_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct13);
        T13_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct12);
        GuardMapping grd1T13_Out_V_S2 = new GuardMapping();
        grd1T13_Out_V_S2.condition = T13_Out_V_S2_Ct11;
        grd1T13_Out_V_S2.Activations.add(new Activation(T13_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S2"));
        T13_Out_V_S2.GuardMappingList.add(grd1T13_Out_V_S2);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T13_Out_V_S2_Ct21 = new Condition(T13_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionCondition.DontHaveCar);
        Condition T13_Out_V_S2_Ct22 = new Condition(T13_Out_V_S2, "P_Lane_LidlIn_V_S2", TransitionCondition.NotNull);
        Condition T13_Out_V_S2_Ct23 = new Condition(T13_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.CanAddCars);
        T13_Out_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct23);
        T13_Out_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct22);
        GuardMapping grd2T13_Out_V_S2 = new GuardMapping();
        grd2T13_Out_V_S2.condition = T13_Out_V_S2_Ct21;
        grd2T13_Out_V_S2.Activations.add(new Activation(T13_Out_V_S2, "P_Lane_LidlIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int4_V_S2"));
        T13_Out_V_S2.GuardMappingList.add(grd2T13_Out_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T13_Out_V_S2_Ct31 = new Condition(T13_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionCondition.HaveCar);
        Condition T13_Out_V_S2_Ct32 = new Condition(T13_Out_V_S2, "P_Lane_LidlIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T13_Out_V_S2_Ct33 = new Condition(T13_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.CanAddCars);
        T13_Out_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct33);
        T13_Out_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct32);
        GuardMapping grd3T13_Out_V_S2 = new GuardMapping();
        grd3T13_Out_V_S2.condition = T13_Out_V_S2_Ct31;
        grd3T13_Out_V_S2.Activations.add(new Activation(T13_Out_V_S2, "P_Lane_LidlIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int4_V_S2"));
        grd3T13_Out_V_S2.Activations.add(new Activation(T13_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S2"));
        T13_Out_V_S2.GuardMappingList.add(grd3T13_Out_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T13_Out_V_S2_Ct41 = new Condition(T13_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionCondition.HaveCar);
        Condition T13_Out_V_S2_Ct42 = new Condition(T13_Out_V_S2, "P_Lane_LidlIn_V_S2", TransitionCondition.NotNull);
        Condition T13_Out_V_S2_Ct43 = new Condition(T13_Out_V_S2, "P_LaneOut_Int4_V_S2", TransitionCondition.CanAddCars);
        T13_Out_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct43);
        T13_Out_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T13_Out_V_S2_Ct42);
        GuardMapping grd4T13_Out_V_S2 = new GuardMapping();
        grd4T13_Out_V_S2.condition = T13_Out_V_S2_Ct41;
        grd4T13_Out_V_S2.Activations.add(new Activation(T13_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S2"));
        grd4T13_Out_V_S2.Activations.add(new Activation(T13_Out_V_S2, "P_Lane_LidlIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int4_V_S2"));
        T13_Out_V_S2.GuardMappingList.add(grd4T13_Out_V_S2);

        T13_Out_V_S2.Delay = 1;
        pn.Transitions.add(T13_Out_V_S2);

        //----------------------------END T13_Out_V_S2----------------------------------------

        DataCar P_Lane_LidlOut_V_S2 = new DataCar();
        P_Lane_LidlOut_V_S2.SetName("P_Lane_LidlOut_V_S2");
        pn.PlaceList.add(P_Lane_LidlOut_V_S2);

        DataCarQueue P_LaneOut_Int6_V_S2 = new DataCarQueue();
        P_LaneOut_Int6_V_S2.SetName("P_LaneOut_Int6_V_S2");
        P_LaneOut_Int6_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int6_V_S2);

        //----------------------------T15_Out_V_S2----------------------------------------

        PetriTransition T15_Out_V_S2 = new PetriTransition(pn);
        T15_Out_V_S2.TransitionName = "T15_Out_V_S2";
        T15_Out_V_S2.InputPlaceName.add("P_LaneOut_Int6_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T15_Out_V_S2_Ct11 = new Condition(T15_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T15_Out_V_S2 = new GuardMapping();
        grd1T15_Out_V_S2.condition= T15_Out_V_S2_Ct11;
        grd1T15_Out_V_S2.Activations.add(new Activation(T15_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_LidlOut_V_S2"));
        T15_Out_V_S2.GuardMappingList.add(grd1T15_Out_V_S2);
        T15_Out_V_S2.Delay = 1;
        pn.Transitions.add(T15_Out_V_S2);

        //----------------------------END T15_Out_V_S2----------------------------------------

        //----------------------------T17_Out_V_S2----------------------------------------

        PetriTransition T17_Out_V_S2 = new PetriTransition(pn);
        T17_Out_V_S2.TransitionName = "T17_Out_V_S2";
        T17_Out_V_S2.InputPlaceName.add("P_LaneOut_Int6_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T17_Out_V_S2_Ct11 = new Condition(T17_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionCondition.HaveCarForMe);
        Condition T17_Out_V_S2_Ct12 = new Condition(T17_Out_V_S2, "P_LaneOut_Int5_V_S2", TransitionCondition.CanAddCars);
        GuardMapping grd1T17_Out_V_S2 = new GuardMapping();
        T17_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T17_Out_V_S2_Ct12);
        grd1T17_Out_V_S2.condition= T17_Out_V_S2_Ct11;
        grd1T17_Out_V_S2.Activations.add(new Activation(T17_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int5_V_S2"));
        T17_Out_V_S2.GuardMappingList.add(grd1T17_Out_V_S2);
        T17_Out_V_S2.Delay = 1;
        pn.Transitions.add(T17_Out_V_S2);

        //----------------------------END T17_Out_V_S2----------------------------------------

        DataCar P_Lane_BenzinarieIn_V_S2 = new DataCar();
        P_Lane_BenzinarieIn_V_S2.SetName("P_Lane_BenzinarieIn_V_S2");
        pn.PlaceList.add(P_Lane_BenzinarieIn_V_S2);

        DataCarQueue P_LaneOut_Int7_V_S2 = new DataCarQueue();
        P_LaneOut_Int7_V_S2.SetName("P_LaneOut_Int7_V_S2");
        P_LaneOut_Int7_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int7_V_S2);

        //----------------------------T19_Out_V_S2----------------------------------------

        PetriTransition T19_Out_V_S2 = new PetriTransition(pn);
        T19_Out_V_S2.TransitionName = "T19_Out_V_S2";
        T19_Out_V_S2.InputPlaceName.add("P_LaneOut_Int7_V_S2");
        T19_Out_V_S2.InputPlaceName.add("P_Lane_BenzinarieIn_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T19_Out_V_S2_Ct11 = new Condition(T19_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionCondition.HaveCar);
        Condition T19_Out_V_S2_Ct12 = new Condition(T19_Out_V_S2, "P_Lane_BenzinarieIn_V_S2", TransitionCondition.IsNull);
        Condition T19_Out_V_S2_Ct13 = new Condition(T19_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionCondition.CanAddCars);
        T19_Out_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct13);
        T19_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct12);
        GuardMapping grd1T19_Out_V_S2 = new GuardMapping();
        grd1T19_Out_V_S2.condition = T19_Out_V_S2_Ct11;
        grd1T19_Out_V_S2.Activations.add(new Activation(T19_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S2"));
        T19_Out_V_S2.GuardMappingList.add(grd1T19_Out_V_S2);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T19_Out_V_S2_Ct21 = new Condition(T19_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionCondition.DontHaveCar);
        Condition T19_Out_V_S2_Ct22 = new Condition(T19_Out_V_S2, "P_Lane_BenzinarieIn_V_S2", TransitionCondition.NotNull);
        Condition T19_Out_V_S2_Ct23 = new Condition(T19_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionCondition.CanAddCars);
        T19_Out_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct23);
        T19_Out_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct22);
        GuardMapping grd2T19_Out_V_S2 = new GuardMapping();
        grd2T19_Out_V_S2.condition = T19_Out_V_S2_Ct21;
        grd2T19_Out_V_S2.Activations.add(new Activation(T19_Out_V_S2, "P_Lane_BenzinarieIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int6_V_S2"));
        T19_Out_V_S2.GuardMappingList.add(grd2T19_Out_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T19_Out_V_S2_Ct31 = new Condition(T19_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionCondition.HaveCar);
        Condition T19_Out_V_S2_Ct32 = new Condition(T19_Out_V_S2, "P_Lane_BenzinarieIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T19_Out_V_S2_Ct33 = new Condition(T19_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionCondition.CanAddCars);
        T19_Out_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct33);
        T19_Out_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct32);
        GuardMapping grd3T19_Out_V_S2 = new GuardMapping();
        grd3T19_Out_V_S2.condition = T19_Out_V_S2_Ct31;
        grd3T19_Out_V_S2.Activations.add(new Activation(T19_Out_V_S2, "P_Lane_BenzinarieIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int6_V_S2"));
        grd3T19_Out_V_S2.Activations.add(new Activation(T19_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S2"));
        T19_Out_V_S2.GuardMappingList.add(grd3T19_Out_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T19_Out_V_S2_Ct41 = new Condition(T19_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionCondition.HaveCar);
        Condition T19_Out_V_S2_Ct42 = new Condition(T19_Out_V_S2, "P_Lane_BenzinarieIn_V_S2", TransitionCondition.NotNull);
        Condition T19_Out_V_S2_Ct43 = new Condition(T19_Out_V_S2, "P_LaneOut_Int6_V_S2", TransitionCondition.CanAddCars);
        T19_Out_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct43);
        T19_Out_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T19_Out_V_S2_Ct42);
        GuardMapping grd4T19_Out_V_S2 = new GuardMapping();
        grd4T19_Out_V_S2.condition = T19_Out_V_S2_Ct41;
        grd4T19_Out_V_S2.Activations.add(new Activation(T19_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S2"));
        grd4T19_Out_V_S2.Activations.add(new Activation(T19_Out_V_S2, "P_Lane_BenzinarieIn_V_S2", TransitionOperation.AddElement, "P_LaneOut_Int6_V_S2"));
        T19_Out_V_S2.GuardMappingList.add(grd4T19_Out_V_S2);

        T19_Out_V_S2.Delay = 1;
        pn.Transitions.add(T19_Out_V_S2);

        //----------------------------END T19_V_S2----------------------------------------

        DataCar P_Lane_BenzinarieOut_V_S2 = new DataCar();
        P_Lane_BenzinarieOut_V_S2.SetName("P_Lane_BenzinarieOut_V_S2");
        pn.PlaceList.add(P_Lane_BenzinarieOut_V_S2);

        DataCarQueue P_LaneOut_Int8_V_S2 = new DataCarQueue();
        P_LaneOut_Int8_V_S2.SetName("P_LaneOut_Int8_V_S2");
        P_LaneOut_Int8_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int8_V_S2);

        //----------------------------T21_Out_V_S2----------------------------------------

        PetriTransition T21_Out_V_S2 = new PetriTransition(pn);
        T21_Out_V_S2.TransitionName = "T21_Out_V_S2";
        T21_Out_V_S2.InputPlaceName.add("P_LaneOut_Int8_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T21_Out_V_S2_Ct11 = new Condition(T21_Out_V_S2, "P_LaneOut_Int8_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T21_Out_V_S2 = new GuardMapping();
        grd1T21_Out_V_S2.condition= T21_Out_V_S2_Ct11;
        grd1T21_Out_V_S2.Activations.add(new Activation(T21_Out_V_S2, "P_LaneOut_Int8_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_BenzinarieOut_V_S2"));
        T21_Out_V_S2.GuardMappingList.add(grd1T21_Out_V_S2);
        T21_Out_V_S2.Delay = 1;
        pn.Transitions.add(T21_Out_V_S2);

        //----------------------------END T21_Out_V_S2----------------------------------------

        //----------------------------T23_Out_V_S2----------------------------------------

        PetriTransition T23_Out_V_S2 = new PetriTransition(pn);
        T23_Out_V_S2.TransitionName = "T23_Out_V_S2";
        T23_Out_V_S2.InputPlaceName.add("P_LaneOut_Int8_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T23_Out_V_S2_Ct11 = new Condition(T23_Out_V_S2, "P_LaneOut_Int8_V_S2", TransitionCondition.HaveCarForMe);
        Condition T23_Out_V_S2_Ct12= new Condition(T23_Out_V_S2, "P_LaneOut_Int7_V_S2", TransitionCondition.CanAddCars);
        GuardMapping grd1T23_Out_V_S2 = new GuardMapping();
        T23_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T23_Out_V_S2_Ct12);
        grd1T23_Out_V_S2.condition= T23_Out_V_S2_Ct11;
        grd1T23_Out_V_S2.Activations.add(new Activation(T23_Out_V_S2, "P_LaneOut_Int8_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int7_V_S2"));
        T23_Out_V_S2.GuardMappingList.add(grd1T23_Out_V_S2);
        T23_Out_V_S2.Delay = 1;
        pn.Transitions.add(T23_Out_V_S2);

        //----------------------------END T23_Out_V_S2----------------------------------------

        //-------------------CROSSING----------------------------------------
        DataCarQueue P_x_Cross_Lane_V_Out_S2 = new DataCarQueue();
        P_x_Cross_Lane_V_Out_S2.Value.Size = 3;
        P_x_Cross_Lane_V_Out_S2.SetName("P_x_Cross_Lane_V_Out_S2");
        pn.PlaceList.add(P_x_Cross_Lane_V_Out_S2);

        //------------------------------T27_Out_V_S2------------------------------------------ //T_u_Out_Crossing_S2
        PetriTransition T27_Out_V_S2 = new PetriTransition(pn);
        T27_Out_V_S2.TransitionName = "T27_Out_V_S2";
        T27_Out_V_S2.InputPlaceName.add("P_LaneOut_Int9_V_S2");
        T27_Out_V_S2.InputPlaceName.add("P_x_Cross_Lane_V_Out_S2");

        Condition T27_Out_V_S2_Ct11 = new Condition(T27_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.HaveCar);
        Condition T27_Out_V_S2_Ct12 = new Condition(T27_Out_V_S2, "P_x_Cross_Lane_V_Out_S2", TransitionCondition.CanAddCars);
        T27_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T27_Out_V_S2_Ct12);

        GuardMapping grd1T27_Out_V_S2 = new GuardMapping();
        grd1T27_Out_V_S2.condition = T27_Out_V_S2_Ct11;
        grd1T27_Out_V_S2.Activations.add(new Activation(T27_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Cross_Lane_V_Out_S2"));
        T27_Out_V_S2.GuardMappingList.add(grd1T27_Out_V_S2);

        T27_Out_V_S2.Delay = 1;
        pn.Transitions.add(T27_Out_V_S2);
        //---------------------------- END T27_Out_V_S2----------------------------------------

        //------------------------------T25_Out_V_S1-------------------------------------------- //T_e_Out_Crossing_S2
        PetriTransition T25_Out_V_S2 = new PetriTransition(pn);
        T25_Out_V_S2.TransitionName = "T25_Out_V_S2";
        T25_Out_V_S2.InputPlaceName.add("P_x_Cross_Lane_V_Out_S2");
        T25_Out_V_S2.InputPlaceName.add("P_Cross_TL_V_S2");
        T25_Out_V_S2.InputPlaceName.add("UserReq_Cross_V_S2");
        T25_Out_V_S2.InputPlaceName.add("P_Cross_PTL_V_S2");

        //-----------------------guard3---------------------------------------------------

        Condition T25_Out_V_S2_C31 = new Condition(T25_Out_V_S2, "P_x_Cross_Lane_V_Out_S2", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T25_In_V_S2 = new GuardMapping();
        grd3T25_In_V_S2.condition= T25_Out_V_S2_C31;
        grd3T25_In_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_x_Cross_Lane_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int8_V_S2"));
        grd3T25_In_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_Cross_TL_V_S2", TransitionOperation.Move, "P_Cross_TL_V_S2"));
        grd3T25_In_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_Cross_PTL_V_S2", TransitionOperation.Move, "P_Cross_PTL_V_S2"));

        T25_Out_V_S2.GuardMappingList.add(grd3T25_In_V_S2);

        //-----------------------guard1---------------------------------------------------

        Condition T25_Out_V_S2_Ct11 = new Condition(T25_Out_V_S2, "P_Cross_TL_V_S2", TransitionCondition.Equal,"green");
        Condition T25_Out_V_S2_Ct12 = new Condition(T25_Out_V_S2, "P_x_Cross_Lane_V_Out_S2", TransitionCondition.HaveCar);
        T25_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T25_Out_V_S2_Ct12);

        GuardMapping grd1T25_Out_V_S2 = new GuardMapping();
        grd1T25_Out_V_S2.condition= T25_Out_V_S2_Ct11;
        grd1T25_Out_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_x_Cross_Lane_V_In_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int8_V_S2"));
        grd1T25_Out_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_Cross_TL_V_S2", TransitionOperation.Move, "P_Cross_TL_V_S2"));
        grd1T25_Out_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_Cross_PTL_V_S2", TransitionOperation.Move, "P_Cross_PTL_V_S2"));

        T25_Out_V_S2.GuardMappingList.add(grd1T25_Out_V_S2);
        //-----------------------guard2---------------------------------------------------
        Condition T25_Out_V_S2_Ct13 = new Condition(T25_Out_V_S2, "UserReq_Cross_V_S2", TransitionCondition.NotNull);

        GuardMapping grd2T25_Out_V_S2 = new GuardMapping();
        grd2T25_Out_V_S2.condition = T25_Out_V_S2_Ct13;

        grd2T25_Out_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_Cross_TL_V_S2", TransitionOperation.Move, "P_Cross_TL_V_S2"));
        grd2T25_Out_V_S2.Activations.add(new Activation(T25_Out_V_S2, "P_Cross_PTL_V_S2", TransitionOperation.Move, "P_Cross_PTL_V_S2"));
        grd2T25_Out_V_S2.Activations.add(new Activation(T25_Out_V_S2, "UserReq_Cross_V_S2", TransitionOperation.SendOverNetwork, "OP_Req_Cross_V_S2"));

        T25_Out_V_S2.GuardMappingList.add(grd2T25_Out_V_S2);

        T25_Out_V_S2.Delay = 1;
        pn.Transitions.add(T25_Out_V_S2);
        //---------------------------- END T25_Out_V_S1----------------------------------------

        DataCarQueue P_x_Cross_Lane_V_In_S2 = new DataCarQueue();
        P_x_Cross_Lane_V_In_S2.Value.Size = 3;
        P_x_Cross_Lane_V_In_S2.SetName("P_x_Cross_Lane_V_In_S2");
        pn.PlaceList.add(P_x_Cross_Lane_V_In_S2);

        //------------------------------T24_V_S2------------------------------------------ //T_u_In_V_S2_Crossing
        PetriTransition T24_In_V_S2 = new PetriTransition(pn);
        T24_In_V_S2.TransitionName = "T24_In_V_S2";
        T24_In_V_S2.InputPlaceName.add("P_LaneIn_int7_V_S2");
        T24_In_V_S2.InputPlaceName.add("P_x_Cross_Lane_V_In_S2");

        Condition T24_In_V_S2_Ct11 = new Condition(T24_In_V_S2, "P_LaneIn_int7_V_S2", TransitionCondition.HaveCar);
        Condition T24_In_V_S2_Ct12 = new Condition(T24_In_V_S2, "P_x_Cross_Lane_V_In_S2", TransitionCondition.CanAddCars);
        T24_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T24_In_V_S2_Ct12);

        GuardMapping grd1T24_In_V_S2 = new GuardMapping();
        grd1T24_In_V_S2.condition = T24_In_V_S2_Ct11;
        grd1T24_In_V_S2.Activations.add(new Activation(T24_In_V_S2, "P_LaneIn_int7_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Cross_Lane_V_In_S2"));
        T24_In_V_S2.GuardMappingList.add(grd1T24_In_V_S2);

        T24_In_V_S2.Delay = 1;
        pn.Transitions.add(T24_In_V_S2);
        //---------------------------- END T24_Out_V_S1----------------------------------------

        //------------------------------T26_Out_V_S1-------------------------------------------- //T_e_In_V_S2_Crossing
        PetriTransition T26_In_V_S2 = new PetriTransition(pn);
        T26_In_V_S2.TransitionName = "T26_In_V_S2";
        T26_In_V_S2.InputPlaceName.add("P_x_Cross_Lane_V_In_S2");
        T26_In_V_S2.InputPlaceName.add("P_Cross_TL_V_S2");
        T26_In_V_S2.InputPlaceName.add("UserReq_Cross_V_S2");
        T26_In_V_S2.InputPlaceName.add("P_Cross_PTL_V_S2");

        //-----------------------guard3---------------------------------------------------

        Condition T26_In_V_S2_C31 = new Condition(T26_In_V_S2, "P_x_Cross_Lane_V_In_S2", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T26_In_V_S2 = new GuardMapping();
        grd3T26_In_V_S2.condition= T26_In_V_S2_C31;
        grd3T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_x_Cross_Lane_V_In_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int8_V_S2"));
        grd3T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_Cross_TL_V_S2", TransitionOperation.Move, "P_Cross_TL_V_S2"));
        grd3T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_Cross_PTL_V_S2", TransitionOperation.Move, "P_Cross_PTL_V_S2"));

        T26_In_V_S2.GuardMappingList.add(grd3T26_In_V_S2);

        //-----------------------guard1---------------------------------------------------

        Condition T26_In_V_S2_Ct11 = new Condition(T26_In_V_S2, "P_Cross_TL_V_S2", TransitionCondition.Equal,"green");
        Condition T26_In_V_S2_Ct12 = new Condition(T26_In_V_S2, "P_x_Cross_Lane_V_In_S2", TransitionCondition.HaveCar);
        T26_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T26_In_V_S2_Ct12);

        GuardMapping grd1T26_In_V_S2 = new GuardMapping();
        grd1T26_In_V_S2.condition= T26_In_V_S2_Ct11;
        grd1T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_x_Cross_Lane_V_In_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int8_V_S2"));
        grd1T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_Cross_TL_V_S2", TransitionOperation.Move, "P_Cross_TL_V_S2"));
        grd1T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_Cross_PTL_V_S2", TransitionOperation.Move, "P_Cross_PTL_V_S2"));

        T26_In_V_S2.GuardMappingList.add(grd1T26_In_V_S2);
        //-----------------------guard2---------------------------------------------------
        Condition T26_In_V_S2_Ct13 = new Condition(T26_In_V_S2, "UserReq_Cross_V_S2", TransitionCondition.NotNull);

        GuardMapping grd2T26_In_V_S2 = new GuardMapping();
        grd2T26_In_V_S2.condition = T26_In_V_S2_Ct13;

        grd2T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_Cross_TL_V_S2", TransitionOperation.Move, "P_Cross_TL_V_S2"));
        grd2T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "P_Cross_PTL_V_S2", TransitionOperation.Move, "P_Cross_PTL_V_S2"));
        grd2T26_In_V_S2.Activations.add(new Activation(T26_In_V_S2, "UserReq_Cross_V_S2", TransitionOperation.SendOverNetwork, "OP_Req_Cross_V_S2"));

        T26_In_V_S2.GuardMappingList.add(grd2T26_In_V_S2);

        T26_In_V_S2.Delay = 1;
        pn.Transitions.add(T26_In_V_S2);
        //---------------------------- END T26_V_S1----------------------------------------

        DataString P_Cross_TL_V_S2 = new DataString();
        P_Cross_TL_V_S2.SetName("P_Cross_TL_V_S2");
        pn.PlaceList.add(P_Cross_TL_V_S2);

        DataString P_Cross_PTL_V_S2 = new DataString();
        P_Cross_PTL_V_S2.SetName("P_Cross_PTL_V_S2");
        pn.PlaceList.add(P_Cross_PTL_V_S2);

        DataString UserReq_Cross_V_S2 = new DataString();
        UserReq_Cross_V_S2.SetName("UserReq_Cross_V_S2");
        pn.PlaceList.add(UserReq_Cross_V_S2);

        DataTransfer OP_Req_Cross_V_S2 = new DataTransfer();
        OP_Req_Cross_V_S2.SetName("OP_Req_Cross_V_S2");
        OP_Req_Cross_V_S2.Value = new TransferOperation("localhost", "1083" , "UserReq_Cross_V");
        pn.PlaceList.add(OP_Req_Cross_V_S2);

        //-------------------END CROSSING----------------------------------------

        //-------------------IN---------------------------
        DataCarQueue P_LaneIn_int8_V_S2 = new DataCarQueue();
        P_LaneIn_int8_V_S2.Value.Size = 3;
        P_LaneIn_int8_V_S2.SetName("P_LaneIn_int8_V_S2");
        pn.PlaceList.add(P_LaneIn_int8_V_S2);

        //----------------------------T28_In_V_S2---------------------------------------- //T118
        PetriTransition T28_In_V_S2 = new PetriTransition(pn);
        T28_In_V_S2.TransitionName = "T28_In_V_S2";
        T28_In_V_S2.InputPlaceName.add("P_LaneIn_int8_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T28_In_V_S2_Ct11 = new Condition(T28_In_V_S2, "P_LaneIn_int8_V_S2", TransitionCondition.HaveCarForMe);
        Condition T28_In_V_S2_Ct12 = new Condition(T28_In_V_S2, "P_LaneIn_int9_V_S2", TransitionCondition.CanAddCars);
        T28_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T28_In_V_S2_Ct12);
        GuardMapping grd1T28_In_V_S2 = new GuardMapping();
        grd1T28_In_V_S2.condition = T28_In_V_S2_Ct11;
        grd1T28_In_V_S2.Activations.add(new Activation(T28_In_V_S2, "P_LaneIn_int8_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int9_V_S2"));
        T28_In_V_S2.GuardMappingList.add(grd1T28_In_V_S2);

        T28_In_V_S2.Delay = 1;
        pn.Transitions.add(T28_In_V_S2);
        //---------------------------- END T28_In_V_S2----------------------------------------

        //----------------------------T30_In_V_S2---------------------------------------- //T115
        PetriTransition T30_In_V_S2 = new PetriTransition(pn);
        T30_In_V_S2.TransitionName = "T30_In_V_S2";
        T30_In_V_S2.InputPlaceName.add("P_LaneIn_int8_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T30_In_V_S2_Ct11 = new Condition(T30_In_V_S2, "P_LaneIn_int8_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T30_In_V_S2 = new GuardMapping();
        grd1T30_In_V_S2.condition = T30_In_V_S2_Ct11;
        grd1T30_In_V_S2.Activations.add(new Activation(T30_In_V_S2, "P_LaneIn_int8_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_NiculaescuOut_V_S2"));
        T30_In_V_S2.GuardMappingList.add(grd1T30_In_V_S2);

        T30_In_V_S2.Delay = 1;
        pn.Transitions.add(T30_In_V_S2);
        //---------------------------- END T30_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int9_V_S2 = new DataCarQueue();
        P_LaneIn_int9_V_S2.Value.Size = 3;
        P_LaneIn_int9_V_S2.SetName("P_LaneIn_int9_V_S2");
        pn.PlaceList.add(P_LaneIn_int9_V_S2);

        DataCar P_Lane_NiculaescuOut_V_S2 = new DataCar();
        P_Lane_NiculaescuOut_V_S2.SetName("P_Lane_NiculaescuOut_V_S2");
        pn.PlaceList.add(P_Lane_NiculaescuOut_V_S2);

        DataCar P_Lane_NiculaescuIn_V_S2 = new DataCar();
        P_Lane_NiculaescuIn_V_S2.SetName("P_Lane_NiculaescuIn_V_S2");
        pn.PlaceList.add(P_Lane_NiculaescuIn_V_S2);

        //----------------------------T32_In_V_S2---------------------------------------- //T119
        PetriTransition T32_In_V_S2 = new PetriTransition(pn);
        T32_In_V_S2.TransitionName = "T32_In_V_S2";
        T32_In_V_S2.InputPlaceName.add("P_LaneIn_int9_V_S2");
        T32_In_V_S2.InputPlaceName.add("P_Lane_NiculaescuIn_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T32_In_V_S2_Ct11 = new Condition(T32_In_V_S2, "P_LaneIn_int9_V_S2", TransitionCondition.HaveCar);
        Condition T32_In_V_S2_Ct12 = new Condition(T32_In_V_S2, "P_Lane_NiculaescuIn_V_S2", TransitionCondition.IsNull);
        Condition T32_In_V_S2_Ct13 = new Condition(T32_In_V_S2, "P_LaneIn_int10_V_S2", TransitionCondition.CanAddCars);
        T32_In_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct13);
        T32_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct12);
        GuardMapping grd1T32_In_V_S2 = new GuardMapping();
        grd1T32_In_V_S2.condition = T32_In_V_S2_Ct11;
        grd1T32_In_V_S2.Activations.add(new Activation(T32_In_V_S2, "P_LaneIn_int9_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int10_V_S2"));
        T32_In_V_S2.GuardMappingList.add(grd1T32_In_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T32_In_V_S2_Ct21 = new Condition(T32_In_V_S2, "P_LaneIn_int9_V_S2", TransitionCondition.DontHaveCar);
        Condition T32_In_V_S2_Ct22 = new Condition(T32_In_V_S2, "P_Lane_NiculaescuIn_V_S2", TransitionCondition.NotNull);
        Condition T32_In_V_S2_Ct23 = new Condition(T32_In_V_S2, "P_LaneIn_int10_V_S2", TransitionCondition.CanAddCars);
        T32_In_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct23);
        T32_In_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct22);
        GuardMapping grd2T32_In_V_S2 = new GuardMapping();
        grd2T32_In_V_S2.condition = T32_In_V_S2_Ct21;
        grd2T32_In_V_S2.Activations.add(new Activation(T32_In_V_S2, "P_Lane_NiculaescuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int10_V_S2"));
        T32_In_V_S2.GuardMappingList.add(grd2T32_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T32_In_V_S2_Ct31 = new Condition(T32_In_V_S2, "P_LaneIn_int9_V_S2", TransitionCondition.HaveCar);
        Condition T32_In_V_S2_Ct32 = new Condition(T32_In_V_S2, "P_Lane_NiculaescuIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T32_In_V_S2_Ct33 = new Condition(T32_In_V_S2, "P_LaneIn_int10_V_S2", TransitionCondition.CanAddCars);
        T32_In_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct33);
        T32_In_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct32);
        GuardMapping grd3T32_In_V_S2 = new GuardMapping();
        grd3T32_In_V_S2.condition = T32_In_V_S2_Ct31;
        grd3T32_In_V_S2.Activations.add(new Activation(T32_In_V_S2, "P_Lane_NiculaescuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int10_V_S2"));
        grd3T32_In_V_S2.Activations.add(new Activation(T32_In_V_S2, "P_LaneIn_int9_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int10_V_S2"));
        T32_In_V_S2.GuardMappingList.add(grd3T32_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T32_In_V_S2_Ct41 = new Condition(T32_In_V_S2, "P_LaneIn_int9_V_S2", TransitionCondition.HaveCar);
        Condition T32_In_V_S2_Ct42 = new Condition(T32_In_V_S2, "P_Lane_NiculaescuIn_V_S2", TransitionCondition.NotNull);
        Condition T32_In_V_S2_Ct43 = new Condition(T32_In_V_S2, "P_LaneIn_int10_V_S2", TransitionCondition.CanAddCars);
        T32_In_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct43);
        T32_In_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T32_In_V_S2_Ct42);
        GuardMapping grd4T32_In_V_S2 = new GuardMapping();
        grd4T32_In_V_S2.condition = T32_In_V_S2_Ct41;
        grd4T32_In_V_S2.Activations.add(new Activation(T32_In_V_S2, "P_LaneIn_int9_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int10_V_S2"));
        grd4T32_In_V_S2.Activations.add(new Activation(T32_In_V_S2, "P_Lane_NiculaescuIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int10_V_S2"));
        T32_In_V_S2.GuardMappingList.add(grd4T32_In_V_S2);


        T32_In_V_S2.Delay = 1;
        pn.Transitions.add(T32_In_V_S2);
        //----------------------------END T32_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int10_V_S2 = new DataCarQueue();
        P_LaneIn_int10_V_S2.Value.Size = 3;
        P_LaneIn_int10_V_S2.SetName("P_LaneIn_int10_V_S2");
        pn.PlaceList.add(P_LaneIn_int10_V_S2);

        //----------------------------T34_In_V_S2---------------------------------------- //T120
        PetriTransition T34_In_V_S2 = new PetriTransition(pn);
        T34_In_V_S2.TransitionName = "T34_In_V_S2";
        T34_In_V_S2.InputPlaceName.add("P_LaneIn_int10_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T34_In_V_S2_Ct11 = new Condition(T34_In_V_S2, "P_LaneIn_int10_V_S2", TransitionCondition.HaveCarForMe);
        Condition T34_In_V_S2_Ct12 = new Condition(T34_In_V_S2, "P_LaneIn_int11_V_S2", TransitionCondition.CanAddCars);
        T34_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T34_In_V_S2_Ct12);
        GuardMapping grd1T34_In_V_S2 = new GuardMapping();
        grd1T34_In_V_S2.condition = T34_In_V_S2_Ct11;
        grd1T34_In_V_S2.Activations.add(new Activation(T34_In_V_S2, "P_LaneIn_int10_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int11_V_S2"));
        T34_In_V_S2.GuardMappingList.add(grd1T34_In_V_S2);

        T34_In_V_S2.Delay = 1;
        pn.Transitions.add(T34_In_V_S2);
        //---------------------------- END T34_In_V_S2----------------------------------------

        //----------------------------T36_In_V_S2---------------------------------------- //T116
        PetriTransition T36_In_V_S2 = new PetriTransition(pn);
        T36_In_V_S2.TransitionName = "T36_In_V_S2";
        T36_In_V_S2.InputPlaceName.add("P_LaneIn_int10_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T36_In_V_S2_Ct11 = new Condition(T36_In_V_S2, "P_LaneIn_int10_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T36_In_V_S2 = new GuardMapping();
        grd1T36_In_V_S2.condition = T36_In_V_S2_Ct11;
        grd1T36_In_V_S2.Activations.add(new Activation(T36_In_V_S2, "P_LaneIn_int10_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_BarleaOut_V_S2"));
        T36_In_V_S2.GuardMappingList.add(grd1T36_In_V_S2);

        T36_In_V_S2.Delay = 1;
        pn.Transitions.add(T36_In_V_S2);
        //---------------------------- END T36_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int11_V_S2 = new DataCarQueue();
        P_LaneIn_int11_V_S2.Value.Size = 3;
        P_LaneIn_int11_V_S2.SetName("P_LaneIn_int11_V_S2");
        pn.PlaceList.add(P_LaneIn_int11_V_S2);

        //----------------------------T38_In_V_S2---------------------------------------- //T121
        PetriTransition T38_In_V_S2 = new PetriTransition(pn);
        T38_In_V_S2.TransitionName = "T38_In_V_S2";
        T38_In_V_S2.InputPlaceName.add("P_LaneIn_int11_V_S2");
        T38_In_V_S2.InputPlaceName.add("P_Lane_BarleaIn_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T38_In_V_S2_Ct11 = new Condition(T38_In_V_S2, "P_LaneIn_int11_V_S2", TransitionCondition.HaveCar);
        Condition T38_In_V_S2_Ct12 = new Condition(T38_In_V_S2, "P_Lane_BarleaIn_V_S2", TransitionCondition.IsNull);
        Condition T38_In_V_S2_Ct13 = new Condition(T38_In_V_S2, "P_LaneIn_int12_V_S2", TransitionCondition.CanAddCars);
        T38_In_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct13);
        T38_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct12);
        GuardMapping grd1T38_In_V_S2 = new GuardMapping();
        grd1T38_In_V_S2.condition = T38_In_V_S2_Ct11;
        grd1T38_In_V_S2.Activations.add(new Activation(T38_In_V_S2, "P_LaneIn_int11_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int12_V_S2"));
        T38_In_V_S2.GuardMappingList.add(grd1T38_In_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T38_In_V_S2_Ct21 = new Condition(T38_In_V_S2, "P_LaneIn_int11_V_S2", TransitionCondition.DontHaveCar);
        Condition T38_In_V_S2_Ct22 = new Condition(T38_In_V_S2, "P_Lane_BarleaIn_V_S2", TransitionCondition.NotNull);
        Condition T38_In_V_S2_Ct23 = new Condition(T38_In_V_S2, "P_LaneIn_int12_V_S2", TransitionCondition.CanAddCars);
        T38_In_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct23);
        T38_In_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct22);
        GuardMapping grd2T38_In_V_S2 = new GuardMapping();
        grd2T38_In_V_S2.condition = T38_In_V_S2_Ct21;
        grd2T38_In_V_S2.Activations.add(new Activation(T38_In_V_S2, "P_Lane_BarleaIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int12_V_S2"));
        T38_In_V_S2.GuardMappingList.add(grd2T38_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T38_In_V_S2_Ct31 = new Condition(T38_In_V_S2, "P_LaneIn_int11_V_S2", TransitionCondition.HaveCar);
        Condition T38_In_V_S2_Ct32 = new Condition(T38_In_V_S2, "P_Lane_BarleaIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T38_In_V_S2_Ct33 = new Condition(T38_In_V_S2, "P_LaneIn_int12_V_S2", TransitionCondition.CanAddCars);
        T38_In_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct33);
        T38_In_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct32);
        GuardMapping grd3T38_In_V_S2 = new GuardMapping();
        grd3T38_In_V_S2.condition = T38_In_V_S2_Ct31;
        grd3T38_In_V_S2.Activations.add(new Activation(T38_In_V_S2, "P_Lane_BarleaIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int12_V_S2"));
        grd3T38_In_V_S2.Activations.add(new Activation(T38_In_V_S2, "P_LaneIn_int11_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int12_V_S2"));
        T38_In_V_S2.GuardMappingList.add(grd3T38_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T38_In_V_S2_Ct41 = new Condition(T38_In_V_S2, "P_LaneIn_int11_V_S2", TransitionCondition.HaveCar);
        Condition T38_In_V_S2_Ct42 = new Condition(T38_In_V_S2, "P_Lane_BarleaIn_V_S2", TransitionCondition.NotNull);
        Condition T38_In_V_S2_Ct43 = new Condition(T38_In_V_S2, "P_LaneIn_int12_V_S2", TransitionCondition.CanAddCars);
        T38_In_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct43);
        T38_In_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T38_In_V_S2_Ct42);
        GuardMapping grd4T38_In_V_S2 = new GuardMapping();
        grd4T38_In_V_S2.condition = T38_In_V_S2_Ct41;
        grd4T38_In_V_S2.Activations.add(new Activation(T38_In_V_S2, "P_LaneIn_int11_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int12_V_S2"));
        grd4T38_In_V_S2.Activations.add(new Activation(T38_In_V_S2, "P_Lane_BarleaIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int12_V_S2"));
        T38_In_V_S2.GuardMappingList.add(grd4T38_In_V_S2);


        T38_In_V_S2.Delay = 1;
        pn.Transitions.add(T38_In_V_S2);
        //----------------------------END T38_In_V_S2----------------------------------------

        DataCar P_Lane_BarleaOut_V_S2 = new DataCar();
        P_Lane_BarleaOut_V_S2.SetName("P_Lane_BarleaOut_V_S2");
        pn.PlaceList.add(P_Lane_BarleaOut_V_S2);

        DataCar P_Lane_BarleaIn_V_S2 = new DataCar();
        P_Lane_BarleaIn_V_S2.SetName("P_Lane_BarleaIn_V_S2");
        pn.PlaceList.add(P_Lane_BarleaIn_V_S2);

        DataCarQueue P_LaneIn_int12_V_S2 = new DataCarQueue();
        P_LaneIn_int12_V_S2.Value.Size = 3;
        P_LaneIn_int12_V_S2.SetName("P_LaneIn_int12_V_S2");
        pn.PlaceList.add(P_LaneIn_int12_V_S2);


        //----------------------------T40_In_V_S2---------------------------------------- //T117
        PetriTransition T40_In_V_S2 = new PetriTransition(pn);
        T40_In_V_S2.TransitionName = "T40_In_V_S2";
        T40_In_V_S2.InputPlaceName.add("P_LaneIn_int12_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T40_In_V_S2_Ct11 = new Condition(T40_In_V_S2, "P_LaneIn_int12_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T40_In_V_S2 = new GuardMapping();
        grd1T40_In_V_S2.condition = T40_In_V_S2_Ct11;
        grd1T40_In_V_S2.Activations.add(new Activation(T40_In_V_S2, "P_LaneIn_int12_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_CarcalechiOut_V_S2"));
        T40_In_V_S2.GuardMappingList.add(grd1T40_In_V_S2);

        T40_In_V_S2.Delay = 1;
        pn.Transitions.add(T40_In_V_S2);
        //---------------------------- END T40_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int13_V_S2 = new DataCarQueue();
        P_LaneIn_int13_V_S2.Value.Size = 3;
        P_LaneIn_int13_V_S2.SetName("P_LaneIn_int13_V_S2");
        pn.PlaceList.add(P_LaneIn_int13_V_S2);

        DataCar P_Lane_CarcalechiOut_V_S2 = new DataCar();
        P_Lane_CarcalechiOut_V_S2.SetName("P_Lane_CarcalechiOut_V_S2");
        pn.PlaceList.add(P_Lane_CarcalechiOut_V_S2);

        //----------------------------T42_In_V_S2---------------------------------------- //T122
        PetriTransition T42_In_V_S2 = new PetriTransition(pn);
        T42_In_V_S2.TransitionName = "T42_In_V_S2";
        T42_In_V_S2.InputPlaceName.add("P_LaneIn_int12_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T42_In_V_S2_Ct11 = new Condition(T42_In_V_S2, "P_LaneIn_int12_V_S2", TransitionCondition.HaveCarForMe);
        Condition T42_In_V_S2_Ct12 = new Condition(T42_In_V_S2, "P_LaneIn_int13_V_S2", TransitionCondition.CanAddCars);
        T42_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T42_In_V_S2_Ct12);
        GuardMapping grd1T42_In_V_S2 = new GuardMapping();
        grd1T42_In_V_S2.condition = T42_In_V_S2_Ct11;
        grd1T42_In_V_S2.Activations.add(new Activation(T42_In_V_S2, "P_LaneIn_int12_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int13_V_S2"));
        T42_In_V_S2.GuardMappingList.add(grd1T42_In_V_S2);

        T42_In_V_S2.Delay = 1;
        pn.Transitions.add(T42_In_V_S2);
        //---------------------------- END T42_In_V_S2----------------------------------------

        DataCar P_Lane_CarcalechiIn_V_S2 = new DataCar();
        P_Lane_CarcalechiIn_V_S2.SetName("P_Lane_CarcalechiIn_V_S2");
        pn.PlaceList.add(P_Lane_CarcalechiIn_V_S2);

        //----------------------------T44_In_V_S2---------------------------------------- //T123
        PetriTransition T44_In_V_S2 = new PetriTransition(pn);
        T44_In_V_S2.TransitionName = "T44_In_V_S2";
        T44_In_V_S2.InputPlaceName.add("P_LaneIn_int13_V_S2");
        T44_In_V_S2.InputPlaceName.add("P_Lane_CarcalechiIn_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T44_In_V_S2_Ct11 = new Condition(T44_In_V_S2, "P_LaneIn_int13_V_S2", TransitionCondition.HaveCar);
        Condition T44_In_V_S2_Ct12 = new Condition(T44_In_V_S2, "P_Lane_CarcalechiIn_V_S2", TransitionCondition.IsNull);
        Condition T44_In_V_S2_Ct13 = new Condition(T44_In_V_S2, "P_LaneIn_int14_V_S2", TransitionCondition.CanAddCars);
        T44_In_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct13);
        T44_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct12);
        GuardMapping grd1T44_In_V_S2 = new GuardMapping();
        grd1T44_In_V_S2.condition = T44_In_V_S2_Ct11;
        grd1T44_In_V_S2.Activations.add(new Activation(T44_In_V_S2, "P_LaneIn_int13_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int14_V_S2"));
        T44_In_V_S2.GuardMappingList.add(grd1T44_In_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T44_In_V_S2_Ct21 = new Condition(T44_In_V_S2, "P_LaneIn_int13_V_S2", TransitionCondition.DontHaveCar);
        Condition T44_In_V_S2_Ct22 = new Condition(T44_In_V_S2, "P_Lane_CarcalechiIn_V_S2", TransitionCondition.NotNull);
        Condition T44_In_V_S2_Ct23 = new Condition(T44_In_V_S2, "P_LaneIn_int14_V_S2", TransitionCondition.CanAddCars);
        T44_In_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct23);
        T44_In_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct22);
        GuardMapping grd2T44_In_V_S2 = new GuardMapping();
        grd2T44_In_V_S2.condition = T44_In_V_S2_Ct21;
        grd2T44_In_V_S2.Activations.add(new Activation(T44_In_V_S2, "P_Lane_CarcalechiIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int14_V_S2"));
        T44_In_V_S2.GuardMappingList.add(grd2T44_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T44_In_V_S2_Ct31 = new Condition(T44_In_V_S2, "P_LaneIn_int13_V_S2", TransitionCondition.HaveCar);
        Condition T44_In_V_S2_Ct32 = new Condition(T44_In_V_S2, "P_Lane_CarcalechiIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T44_In_V_S2_Ct33 = new Condition(T44_In_V_S2, "P_LaneIn_int14_V_S2", TransitionCondition.CanAddCars);
        T44_In_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct33);
        T44_In_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct32);
        GuardMapping grd3T44_In_V_S2 = new GuardMapping();
        grd3T44_In_V_S2.condition = T44_In_V_S2_Ct31;
        grd3T44_In_V_S2.Activations.add(new Activation(T44_In_V_S2, "P_Lane_CarcalechiIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int14_V_S2"));
        grd3T44_In_V_S2.Activations.add(new Activation(T44_In_V_S2, "P_LaneIn_int13_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int14_V_S2"));
        T44_In_V_S2.GuardMappingList.add(grd3T44_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T44_In_V_S2_Ct41 = new Condition(T44_In_V_S2, "P_LaneIn_int13_V_S2", TransitionCondition.HaveCar);
        Condition T44_In_V_S2_Ct42 = new Condition(T44_In_V_S2, "P_Lane_CarcalechiIn_V_S2", TransitionCondition.NotNull);
        Condition T44_In_V_S2_Ct43 = new Condition(T44_In_V_S2, "P_LaneIn_int14_V_S2", TransitionCondition.CanAddCars);
        T44_In_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct43);
        T44_In_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T44_In_V_S2_Ct42);
        GuardMapping grd4T44_In_V_S2 = new GuardMapping();
        grd4T44_In_V_S2.condition = T44_In_V_S2_Ct41;
        grd4T44_In_V_S2.Activations.add(new Activation(T44_In_V_S2, "P_LaneIn_int13_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int14_V_S2"));
        grd4T44_In_V_S2.Activations.add(new Activation(T44_In_V_S2, "P_Lane_CarcalechiIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int14_V_S2"));
        T44_In_V_S2.GuardMappingList.add(grd4T44_In_V_S2);


        T44_In_V_S2.Delay = 1;
        pn.Transitions.add(T44_In_V_S2);
        //----------------------------END T44_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int14_V_S2 = new DataCarQueue();
        P_LaneIn_int14_V_S2.Value.Size = 3;
        P_LaneIn_int14_V_S2.SetName("P_LaneIn_int14_V_S2");
        pn.PlaceList.add(P_LaneIn_int14_V_S2);

        //----------------------------T46_In_V_S2---------------------------------------- //T126
        PetriTransition T46_In_V_S2 = new PetriTransition(pn);
        T46_In_V_S2.TransitionName = "T46_In_V_S2";
        T46_In_V_S2.InputPlaceName.add("P_LaneIn_int14_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T46_In_V_S2_Ct11 = new Condition(T46_In_V_S2, "P_LaneIn_int14_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T46_In_V_S2 = new GuardMapping();
        grd1T46_In_V_S2.condition = T46_In_V_S2_Ct11;
        grd1T46_In_V_S2.Activations.add(new Activation(T46_In_V_S2, "P_LaneIn_int14_V_S2", TransitionOperation.PopElementWithTarget, "P_Lane_McDonaldsOut_V_S2"));
        T46_In_V_S2.GuardMappingList.add(grd1T46_In_V_S2);

        T46_In_V_S2.Delay = 1;
        pn.Transitions.add(T46_In_V_S2);
        //---------------------------- END T46_In_V_S2----------------------------------------

        //----------------------------T48_V_S2---------------------------------------- //T124
        PetriTransition T48_In_V_S2 = new PetriTransition(pn);
        T48_In_V_S2.TransitionName = "T48_In_V_S2";
        T48_In_V_S2.InputPlaceName.add("P_LaneIn_int14_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T48_In_V_S2_Ct11 = new Condition(T48_In_V_S2, "P_LaneIn_int14_V_S2", TransitionCondition.HaveCarForMe);
        Condition T48_In_V_S2_Ct12 = new Condition(T48_In_V_S2, "P_LaneIn_int15_V_S2", TransitionCondition.CanAddCars);
        T48_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T48_In_V_S2_Ct12);
        GuardMapping grd1T48_In_V_S2 = new GuardMapping();
        grd1T48_In_V_S2.condition = T48_In_V_S2_Ct11;
        grd1T48_In_V_S2.Activations.add(new Activation(T48_In_V_S2, "P_LaneIn_int14_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int15_V_S2"));
        T48_In_V_S2.GuardMappingList.add(grd1T48_In_V_S2);

        T48_In_V_S2.Delay = 1;
        pn.Transitions.add(T48_In_V_S2);
        //---------------------------- END T48_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int15_V_S2 = new DataCarQueue();
        P_LaneIn_int15_V_S2.Value.Size = 3;
        P_LaneIn_int15_V_S2.SetName("P_LaneIn_int15_V_S2");
        pn.PlaceList.add(P_LaneIn_int15_V_S2);

        DataCar P_Lane_McDonaldsOut_V_S2 = new DataCar();
        P_Lane_McDonaldsOut_V_S2.SetName("P_Lane_McDonaldsOut_V_S2");
        pn.PlaceList.add(P_Lane_McDonaldsOut_V_S2);

        DataCar P_Lane_McDonaldsIn_V_S2 = new DataCar();
        P_Lane_McDonaldsIn_V_S2.SetName("P_Lane_McDonaldsIn_V_S2");
        pn.PlaceList.add(P_Lane_McDonaldsIn_V_S2);

        //----------------------------T50_In_V_S2---------------------------------------- //T125
        PetriTransition T50_In_V_S2 = new PetriTransition(pn);
        T50_In_V_S2.TransitionName = "T50_In_V_S2";
        T50_In_V_S2.InputPlaceName.add("P_LaneIn_int15_V_S2");
        T50_In_V_S2.InputPlaceName.add("P_Lane_McDonaldsIn_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T50_In_V_S2_Ct11 = new Condition(T50_In_V_S2, "P_LaneIn_int15_V_S2", TransitionCondition.HaveCar);
        Condition T50_In_V_S2_Ct12 = new Condition(T50_In_V_S2, "P_Lane_McDonaldsIn_V_S2", TransitionCondition.IsNull);
        Condition T50_In_V_S2_Ct13 = new Condition(T50_In_V_S2, "P_LaneIn_int16_V_S2", TransitionCondition.CanAddCars);
        T50_In_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct13);
        T50_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct12);
        GuardMapping grd1T50_In_V_S2 = new GuardMapping();
        grd1T50_In_V_S2.condition = T50_In_V_S2_Ct11;
        grd1T50_In_V_S2.Activations.add(new Activation(T50_In_V_S2, "P_LaneIn_int15_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int16_V_S2"));
        T50_In_V_S2.GuardMappingList.add(grd1T50_In_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T50_In_V_S2_Ct21 = new Condition(T50_In_V_S2, "P_LaneIn_int15_V_S2", TransitionCondition.DontHaveCar);
        Condition T50_In_V_S2_Ct22 = new Condition(T50_In_V_S2, "P_Lane_McDonaldsIn_V_S2", TransitionCondition.NotNull);
        Condition T50_In_V_S2_Ct23 = new Condition(T50_In_V_S2, "P_LaneIn_int16_V_S2", TransitionCondition.CanAddCars);
        T50_In_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct23);
        T50_In_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct22);
        GuardMapping grd2T50_In_V_S2 = new GuardMapping();
        grd2T50_In_V_S2.condition = T50_In_V_S2_Ct21;
        grd2T50_In_V_S2.Activations.add(new Activation(T50_In_V_S2, "P_Lane_McDonaldsIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int16_V_S2"));
        T50_In_V_S2.GuardMappingList.add(grd2T50_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T50_In_V_S2_Ct31 = new Condition(T50_In_V_S2, "P_LaneIn_int15_V_S2", TransitionCondition.HaveCar);
        Condition T50_In_V_S2_Ct32 = new Condition(T50_In_V_S2, "P_Lane_McDonaldsIn_V_S2", TransitionCondition.IsPriorityCar);
        Condition T50_In_V_S2_Ct33 = new Condition(T50_In_V_S2, "P_LaneIn_int16_V_S2", TransitionCondition.CanAddCars);
        T50_In_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct33);
        T50_In_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct32);
        GuardMapping grd3T50_In_V_S2 = new GuardMapping();
        grd3T50_In_V_S2.condition = T50_In_V_S2_Ct31;
        grd3T50_In_V_S2.Activations.add(new Activation(T50_In_V_S2, "P_Lane_McDonaldsIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int16_V_S2"));
        grd3T50_In_V_S2.Activations.add(new Activation(T50_In_V_S2, "P_LaneIn_int15_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int16_V_S2"));
        T50_In_V_S2.GuardMappingList.add(grd3T50_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T50_In_V_S2_Ct41 = new Condition(T50_In_V_S2, "P_LaneIn_int15_V_S2", TransitionCondition.HaveCar);
        Condition T50_In_V_S2_Ct42 = new Condition(T50_In_V_S2, "P_Lane_McDonaldsIn_V_S2", TransitionCondition.NotNull);
        Condition T50_In_V_S2_Ct43 = new Condition(T50_In_V_S2, "P_LaneIn_int16_V_S2", TransitionCondition.CanAddCars);
        T50_In_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct43);
        T50_In_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T50_In_V_S2_Ct42);
        GuardMapping grd4T50_In_V_S2 = new GuardMapping();
        grd4T50_In_V_S2.condition = T50_In_V_S2_Ct41;
        grd4T50_In_V_S2.Activations.add(new Activation(T50_In_V_S2, "P_LaneIn_int15_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int16_V_S2"));
        grd4T50_In_V_S2.Activations.add(new Activation(T50_In_V_S2, "P_Lane_McDonaldsIn_V_S2", TransitionOperation.AddElement, "P_LaneIn_int16_V_S2"));
        T50_In_V_S2.GuardMappingList.add(grd4T50_In_V_S2);

        T50_In_V_S2.Delay = 1;
        pn.Transitions.add(T50_In_V_S2);
        //----------------------------END T50_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int16_V_S2 = new DataCarQueue();
        P_LaneIn_int16_V_S2.Value.Size = 4;
        P_LaneIn_int16_V_S2.SetName("P_LaneIn_int16_V_S2");
        pn.PlaceList.add(P_LaneIn_int16_V_S2);

        //------------------------------T52_In_V_S2-------------------------------------------- //T_u_In_V_S2
        PetriTransition T52_In_V_S2 = new PetriTransition(pn);
        T52_In_V_S2.TransitionName = "T52_In_V_S2";
        T52_In_V_S2.InputPlaceName.add("P_LaneIn_int16_V_S2");
        T52_In_V_S2.InputPlaceName.add("P_x_Lane_V_S2");

        Condition T52_In_V_S2_Ct11 = new Condition(T52_In_V_S2, "P_LaneIn_int16_V_S2", TransitionCondition.HaveCar);
        Condition T52_In_V_S2_Ct12 = new Condition(T52_In_V_S2, "P_x_Lane_V_S2", TransitionCondition.CanAddCars);
        T52_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T52_In_V_S2_Ct12);

        GuardMapping grd1T52_In_V_S2 = new GuardMapping();
        grd1T52_In_V_S2.condition = T52_In_V_S2_Ct11;
        grd1T52_In_V_S2.Activations.add(new Activation(T52_In_V_S2, "P_LaneIn_int16_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Lane_V_S2"));
        T52_In_V_S2.GuardMappingList.add(grd1T52_In_V_S2);

        T52_In_V_S2.Delay = 1;
        pn.Transitions.add(T52_In_V_S2);
        //---------------------------- END T52_V_S2----------------------------------------


        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_V_S2 = new DataTransfer();
        OP_V_S2.SetName("OP_V_S2");
        OP_V_S2.Value = new TransferOperation("localhost", "1082", "in2");
        pn.PlaceList.add(OP_V_S2);
        //----------------------------T58_In_V_S2----------------------------------------------//T_Out_E_S1
        PetriTransition T58_In_V_S2 = new PetriTransition(pn);
        T58_In_V_S2.TransitionName = "T58_In_V_S2";
        T58_In_V_S2.InputPlaceName.add("P_LaneIn_int16_V_S2");
        T58_In_V_S2.InputPlaceName.add("P_x_Lane_V_S2");
        //T58_In_V_S2.IsAsync = true;

        Condition T58_In_V_S2_Ct1 = new Condition(T58_In_V_S2, "P_LaneIn_int16_V_S2", TransitionCondition.HaveCar);
        Condition T58_In_V_S2_Ct2 = new Condition(T58_In_V_S2, "P_x_Lane_V_S2", TransitionCondition.CanNotAddCars);
        T58_In_V_S2_Ct1.SetNextCondition(LogicConnector.AND, T58_In_V_S2_Ct2);

        GuardMapping grdT58_In_V_S2 = new GuardMapping();
        grdT58_In_V_S2.condition = T58_In_V_S2_Ct1;
        grdT58_In_V_S2.Activations.add(new Activation(T58_In_V_S2, "full", TransitionOperation.SendOverNetwork, "OP_V_S2"));
        T58_In_V_S2.GuardMappingList.add(grdT58_In_V_S2);

        T58_In_V_S2.Delay = 1;
        pn.Transitions.add(T58_In_V_S2);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        DataCarQueue P_x_Lane_V_S2 = new DataCarQueue();
        P_x_Lane_V_S2.Value.Size = 4;
        P_x_Lane_V_S2.SetName("P_x_Lane_V_S2");
        pn.PlaceList.add(P_x_Lane_V_S2);

        //------------------------------T54_In_V_S1-------------------------------------------- //T_e_car1_V_S2
        PetriTransition T54_In_V_S2 = new PetriTransition(pn);
        T54_In_V_S2.TransitionName = "T54_In_V_S2";
        T54_In_V_S2.InputPlaceName.add("P_x_Lane_V_S2");
        T54_In_V_S2.InputPlaceName.add("P_TL_V_S2");

        //-----------------------guard3---------------------------------------------------

        Condition T54_In_V_S2_C31 = new Condition(T54_In_V_S2, "P_x_Lane_V_S2", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T54_In_V_S2 = new GuardMapping();
        grd3T54_In_V_S2.condition= T54_In_V_S2_C31;
        grd3T54_In_V_S2.Activations.add(new Activation(T54_In_V_S2, "P_x_Lane_V_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_V_S2"));
        grd3T54_In_V_S2.Activations.add(new Activation(T54_In_V_S2, "P_TL_V_S2", TransitionOperation.Move, "P_TL_V_S2"));

        T54_In_V_S2.GuardMappingList.add(grd3T54_In_V_S2);

        //-----------------------guard1---------------------------------------------------

        Condition T54_In_V_S2_Ct11 = new Condition(T54_In_V_S2, "P_TL_V_S2", TransitionCondition.Equal,"green");
        Condition T54_In_V_S2_Ct12 = new Condition(T54_In_V_S2, "P_x_Lane_V_S2", TransitionCondition.HaveCar);
        T54_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T54_In_V_S2_Ct12);

        GuardMapping grd1T54_In_V_S2 = new GuardMapping();
        grd1T54_In_V_S2.condition= T54_In_V_S2_Ct11;
        grd1T54_In_V_S2.Activations.add(new Activation(T54_In_V_S2, "P_x_Lane_V_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_V_S2"));
        grd1T54_In_V_S2.Activations.add(new Activation(T54_In_V_S2, "P_TL_V_S2", TransitionOperation.Move, "P_TL_V_S2"));
        T54_In_V_S2.GuardMappingList.add(grd1T54_In_V_S2);

        T54_In_V_S2.Delay = 1;
        pn.Transitions.add(T54_In_V_S2);
        //---------------------------- END T54_In_V_S1----------------------------------------

        DataCar P_b_Lane_V_S2 = new DataCar();
        P_b_Lane_V_S2.SetName("P_b_Lane_V_S2");
        pn.PlaceList.add(P_b_Lane_V_S2);

        //-----------------------------T56_In_V_S2-------------------------------------------//T_I_Car1_V
        PetriTransition T56_In_V_S2 = new PetriTransition(pn);
        T56_In_V_S2.TransitionName = "T55_In_V_S2";
        T56_In_V_S2.InputPlaceName.add("P_b_Lane_V_S2");
        T56_In_V_S2.InputPlaceName.add("P_I_S2");

        Condition T56_In_V_S2_Ct11 = new Condition(T56_In_V_S2, "P_b_Lane_V_S2", TransitionCondition.NotNull);
        Condition T56_In_V_S2_Ct12 = new Condition(T56_In_V_S2, "P_I_S2", TransitionCondition.CanAddCars);
        T56_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T56_In_V_S2_Ct12);
        GuardMapping grd1T56_In_V_S2 = new GuardMapping();
        grd1T56_In_V_S2.condition = T56_In_V_S2_Ct11;
        grd1T56_In_V_S2.Activations.add(new Activation(T56_In_V_S2, "P_b_Lane_V_S2", TransitionOperation.AddElement, "P_I_S2"));
        T56_In_V_S2.GuardMappingList.add(grd1T56_In_V_S2);

        T56_In_V_S2.Delay = 1;
        pn.Transitions.add(T56_In_V_S2);
        //---------------------------- END T56_In_V_S2----------------------------------------

        //-------------------OUT--------------------------
        DataCarQueue P_LaneOut_Int9_V_S2 = new DataCarQueue();
        P_LaneOut_Int9_V_S2.SetName("P_LaneOut_Int9_V_S2");
        P_LaneOut_Int9_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int9_V_S2);

        DataCarQueue P_LaneOut_Int10_V_S2 = new DataCarQueue();
        P_LaneOut_Int10_V_S2.SetName("P_LaneOut_Int10_V_S2");
        P_LaneOut_Int10_V_S2.Value.Size = 2;
        pn.PlaceList.add(P_LaneOut_Int10_V_S2);

        DataCarQueue P_BusStation_SoseauaProgresului_V_Out_S2 = new DataCarQueue();
        P_BusStation_SoseauaProgresului_V_Out_S2.SetName("P_BusStation_SoseauaProgresului_V_Out_S2");
        P_BusStation_SoseauaProgresului_V_Out_S2.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_SoseauaProgresului_V_Out_S2);

        DataCarQueue P_TramStation_SoseauaProgresului_V_Out_S2 = new DataCarQueue();
        P_TramStation_SoseauaProgresului_V_Out_S2.SetName("P_TramStation_SoseauaProgresului_V_Out_S2");
        P_TramStation_SoseauaProgresului_V_Out_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStation_SoseauaProgresului_V_Out_S2);

        //----------------------------T29_Out_V_S2----------------------------------------
        PetriTransition T29_Out_V_S2 = new PetriTransition(pn);
        T29_Out_V_S2.TransitionName = "T29_Out_V_S2";
        T29_Out_V_S2.InputPlaceName.add("P_LaneOut_Int10_V_S2");
        T29_Out_V_S2.InputPlaceName.add("P_BusStation_SoseauaProgresului_V_Out_S2");
        T29_Out_V_S2.InputPlaceName.add("P_TramStation_SoseauaProgresului_V_Out_S2");

        // --------------guard 8-------------------------------------------------------
        Condition T29_Out_V_S2_Ct81 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.HavePriorityCar);
        Condition T29_Out_V_S2_Ct82 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveBus);
        Condition T29_Out_V_S2_Ct83 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct84 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveTram);
        T29_Out_V_S2_Ct83.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct84);
        T29_Out_V_S2_Ct82.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct83);
        T29_Out_V_S2_Ct81.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct82);
        GuardMapping grd8T29_Out_V_S2 = new GuardMapping();
        grd8T29_Out_V_S2.condition = T29_Out_V_S2_Ct81;
        grd8T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        grd8T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        grd8T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd8T29_Out_V_S2);

        // --------------guard 1-------------------------------------------------------
        Condition T29_Out_V_S2_Ct11 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.HaveCar);
        Condition T29_Out_V_S2_Ct12 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.DontHaveBus);
        Condition T29_Out_V_S2_Ct13 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct14 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.DontHaveTram);
        T29_Out_V_S2_Ct13.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct14);
        T29_Out_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct13);
        T29_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct12);
        GuardMapping grd1T29_Out_V_S2 = new GuardMapping();
        grd1T29_Out_V_S2.condition = T29_Out_V_S2_Ct11;
        grd1T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd1T29_Out_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T29_Out_V_S2_Ct21 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.DontHaveCar);
        Condition T29_Out_V_S2_Ct22 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveBus);
        Condition T29_Out_V_S2_Ct23 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct24 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.DontHaveTram);
        T29_Out_V_S2_Ct23.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct24);
        T29_Out_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct23);
        T29_Out_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct22);
        GuardMapping grd2T29_Out_V_S2 = new GuardMapping();
        grd2T29_Out_V_S2.condition = T29_Out_V_S2_Ct21;
        grd2T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd2T29_Out_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T29_Out_V_S2_Ct31 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.HaveCar);
        Condition T29_Out_V_S2_Ct32 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveBus);
        Condition T29_Out_V_S2_Ct33 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct34 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.DontHaveTram);
        T29_Out_V_S2_Ct33.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct34);
        T29_Out_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct33);
        T29_Out_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct32);
        GuardMapping grd3T29_Out_V_S2 = new GuardMapping();
        grd3T29_Out_V_S2.condition = T29_Out_V_S2_Ct31;
        grd3T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        grd3T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd3T29_Out_V_S2);

        // --------------guard 5-------------------------------------------------------
        Condition T29_Out_V_S2_Ct51 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.HaveCar);
        Condition T29_Out_V_S2_Ct52 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.DontHaveBus);
        Condition T29_Out_V_S2_Ct53 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct54 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveTram);
        T29_Out_V_S2_Ct53.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct54);
        T29_Out_V_S2_Ct52.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct53);
        T29_Out_V_S2_Ct51.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct52);
        GuardMapping grd5T29_Out_V_S2 = new GuardMapping();
        grd5T29_Out_V_S2.condition = T29_Out_V_S2_Ct51;
        grd5T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        grd5T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd5T29_Out_V_S2);

        // --------------guard 6-------------------------------------------------------
        Condition T29_Out_V_S2_Ct61 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.DontHaveCar);
        Condition T29_Out_V_S2_Ct62 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveBus);
        Condition T29_Out_V_S2_Ct63 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct64 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveTram);
        T29_Out_V_S2_Ct63.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct64);
        T29_Out_V_S2_Ct62.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct63);
        T29_Out_V_S2_Ct61.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct62);
        GuardMapping grd6T29_Out_V_S2 = new GuardMapping();
        grd6T29_Out_V_S2.condition = T29_Out_V_S2_Ct61;
        grd6T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        grd6T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd6T29_Out_V_S2);

        // --------------guard 7-------------------------------------------------------
        Condition T29_Out_V_S2_Ct71 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.HaveCar);
        Condition T29_Out_V_S2_Ct72 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveBus);
        Condition T29_Out_V_S2_Ct73 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct74 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveTram);
        T29_Out_V_S2_Ct73.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct74);
        T29_Out_V_S2_Ct72.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct73);
        T29_Out_V_S2_Ct71.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct72);
        GuardMapping grd7T29_Out_V_S2 = new GuardMapping();
        grd7T29_Out_V_S2.condition = T29_Out_V_S2_Ct71;
        grd7T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        grd7T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        grd7T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd7T29_Out_V_S2);

        //--------------guard 9-------------------------------------------------------
        Condition T29_Out_V_S2_Ct91 = new Condition(T29_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.DontHaveCar);
        Condition T29_Out_V_S2_Ct92 = new Condition(T29_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.DontHaveBus);
        Condition T29_Out_V_S2_Ct93 = new Condition(T29_Out_V_S2, "P_LaneOut_Int9_V_S2", TransitionCondition.CanAddCars);
        Condition T29_Out_V_S2_Ct94 = new Condition(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.HaveTram);
        T29_Out_V_S2_Ct93.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct94);
        T29_Out_V_S2_Ct92.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct93);
        T29_Out_V_S2_Ct91.SetNextCondition(LogicConnector.AND, T29_Out_V_S2_Ct92);
        GuardMapping grd9T29_Out_V_S2 = new GuardMapping();
        grd9T29_Out_V_S2.condition = T29_Out_V_S2_Ct91;
        grd9T29_Out_V_S2.Activations.add(new Activation(T29_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int9_V_S2"));
        T29_Out_V_S2.GuardMappingList.add(grd9T29_Out_V_S2);

        T29_Out_V_S2.Delay = 1;
        pn.Transitions.add(T29_Out_V_S2);

        //-------------------------------END T29_Out_V_S2-------------------------------------------------

        DataCarQueue P_LaneOut_Int11_V_S2 = new DataCarQueue();
        P_LaneOut_Int11_V_S2.SetName("P_LaneOut_Int11_V_S2");
        P_LaneOut_Int11_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int11_V_S2);

        DataCarQueue P_TramStation_SoseauaProgresului_V_S2 = new DataCarQueue();
        P_TramStation_SoseauaProgresului_V_S2.SetName("P_TramStation_SoseauaProgresului_V_S2");
        P_TramStation_SoseauaProgresului_V_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStation_SoseauaProgresului_V_S2);

        DataCarQueue P_BusStation_SoseauaProgresului_V_S2 = new DataCarQueue();
        P_BusStation_SoseauaProgresului_V_S2.SetName("P_BusStation_SoseauaProgresului_V_S2");
        P_BusStation_SoseauaProgresului_V_S2.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_SoseauaProgresului_V_S2);

        //----------------------------T31_Out_V_S2----------------------------------------

        PetriTransition T31_Out_V_S2 = new PetriTransition(pn);
        T31_Out_V_S2.TransitionName = "T31_Out_V_S2";
        T31_Out_V_S2.InputPlaceName.add("P_LaneOut_Int11_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T31_Out_V_S2_Ct11 = new Condition(T31_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionCondition.HaveBusForMe);
        Condition T31_Out_V_S2_Ct12 = new Condition(T31_Out_V_S2, "P_BusStation_SoseauaProgresului_V_S2", TransitionCondition.CanAddCars);
        T31_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T31_Out_V_S2_Ct12);
        GuardMapping grd1T31_Out_V_S2 = new GuardMapping();
        grd1T31_Out_V_S2.condition= T31_Out_V_S2_Ct11;
        grd1T31_Out_V_S2.Activations.add(new Activation(T31_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_BusStation_SoseauaProgresului_V_S2"));
        T31_Out_V_S2.GuardMappingList.add(grd1T31_Out_V_S2);
        T31_Out_V_S2.Delay = 1;
        pn.Transitions.add(T31_Out_V_S2);

        //----------------------------END T31_Out_V_S2----------------------------------------

        //----------------------------T33_Out_V_S2----------------------------------------

        PetriTransition T33_Out_V_S2 = new PetriTransition(pn);
        T33_Out_V_S2.TransitionName = "T33_Out_V_S2";
        T33_Out_V_S2.InputPlaceName.add("P_LaneOut_Int11_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T33_Out_V_S2_Ct11 = new Condition(T33_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionCondition.HaveCarForMe);
        Condition T33_Out_V_S2_Ct12 = new Condition(T33_Out_V_S2, "P_LaneOut_Int10_V_S2", TransitionCondition.CanAddCars);
        GuardMapping grd1T33_Out_V_S2 = new GuardMapping();
        T33_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T33_Out_V_S2_Ct12);
        grd1T33_Out_V_S2.condition= T33_Out_V_S2_Ct11;
        grd1T33_Out_V_S2.Activations.add(new Activation(T33_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int10_V_S2"));
        T33_Out_V_S2.GuardMappingList.add(grd1T33_Out_V_S2);
        T33_Out_V_S2.Delay = 1;
        pn.Transitions.add(T33_Out_V_S2);

        //----------------------------END T33_Out_V_S2----------------------------------------

        //----------------------------T35_Out_V_S2-------------------------------
        PetriTransition T35_Out_V_S2 = new PetriTransition(pn);
        T35_Out_V_S2.TransitionName = "T35_Out_V_S2";
        T35_Out_V_S2.InputPlaceName.add("P_LaneOut_Int11_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T35_Out_V_S2_Ct11 = new Condition(T35_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionCondition.HaveTramForMe);
        Condition T35_Out_V_S2_Ct12 = new Condition(T35_Out_V_S2, "P_TramStation_SoseauaProgresului_V_S2", TransitionCondition.CanAddCars);
        T35_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T35_Out_V_S2_Ct12);
        GuardMapping grd1T35_Out_V_S2 = new GuardMapping();
        grd1T35_Out_V_S2.condition = T35_Out_V_S2_Ct11;
        grd1T35_Out_V_S2.Activations.add(new Activation(T35_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_TramStation_SoseauaProgresului_V_S2"));
        T35_Out_V_S2.GuardMappingList.add(grd1T35_Out_V_S2);

        T35_Out_V_S2.Delay = 1;
        pn.Transitions.add(T35_Out_V_S2);

        //----------------------------END T35_Out_V_S2----------------------------------------

        //----------------------------T37_V_S2----------------------------------------

        PetriTransition T37_Out_V_S2 = new PetriTransition(pn);
        T37_Out_V_S2.TransitionName = "T37_Out_V_S2";
        T37_Out_V_S2.InputPlaceName.add("P_TramStation_SoseauaProgresului_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T37_Out_V_S2_Ct11 = new Condition(T37_Out_V_S2, "P_TramStation_SoseauaProgresului_V_S2", TransitionCondition.HaveTram);
        Condition T37_Out_V_S2_Ct12 = new Condition(T37_Out_V_S2, "P_TramStation_SoseauaProgresului_V_Out_S2", TransitionCondition.CanAddCars);
        T37_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T37_Out_V_S2_Ct12);
        GuardMapping grd1T37_Out_V_S2 = new GuardMapping();
        grd1T37_Out_V_S2.condition = T37_Out_V_S2_Ct11;
        grd1T37_Out_V_S2.Activations.add(new Activation(T37_Out_V_S2, "P_TramStation_SoseauaProgresului_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_TramStation_SoseauaProgresului_V_Out_S2"));
        T37_Out_V_S2.GuardMappingList.add(grd1T37_Out_V_S2);

        T37_Out_V_S2.Delay = 10;
        pn.Transitions.add(T37_Out_V_S2);

        //----------------------------END T37_V_S2----------------------------------------

        //----------------------------T39_V_S2----------------------------------------

        PetriTransition T39_Out_V_S2 = new PetriTransition(pn);
        T39_Out_V_S2.TransitionName = "T39_Out_V_S2";
        T39_Out_V_S2.InputPlaceName.add("P_BusStation_SoseauaProgresului_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T39_Out_V_S2_Ct11 = new Condition(T39_Out_V_S2, "P_BusStation_SoseauaProgresului_V_S2", TransitionCondition.HaveBus);
        Condition T39_Out_V_S2_Ct12 = new Condition(T39_Out_V_S2, "P_BusStation_SoseauaProgresului_V_Out_S2", TransitionCondition.CanAddCars);
        T39_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T39_Out_V_S2_Ct12);
        GuardMapping grd1T39_Out_V_S2 = new GuardMapping();
        grd1T39_Out_V_S2.condition = T39_Out_V_S2_Ct11;
        grd1T39_Out_V_S2.Activations.add(new Activation(T39_Out_V_S2, "P_BusStation_SoseauaProgresului_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_BusStation_SoseauaProgresului_V_Out_S2"));
        T39_Out_V_S2.GuardMappingList.add(grd1T39_Out_V_S2);

        T39_Out_V_S2.Delay = 10;
        pn.Transitions.add(T39_Out_V_S2);

        //----------------------------END T39_Out_V_S2----------------------------------------

        DataCar P_LaneMarket_V_In_S2 = new DataCar();
        P_LaneMarket_V_In_S2.SetName("P_LaneMarket_V_In_S2");
        pn.PlaceList.add(P_LaneMarket_V_In_S2);

        DataCarQueue P_LaneOut_Int12_V_S2 = new DataCarQueue();
        P_LaneOut_Int12_V_S2.SetName("P_LaneOut_Int12_V_S2");
        P_LaneOut_Int12_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int12_V_S2);

        //----------------------------T41_Out_V_S2----------------------------------------
        PetriTransition T41_Out_V_S2 = new PetriTransition(pn);
        T41_Out_V_S2.TransitionName = "T41_Out_V_S2";
        T41_Out_V_S2.InputPlaceName.add("P_LaneOut_Int12_V_S2");
        T41_Out_V_S2.InputPlaceName.add("P_LaneMarket_V_In_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T41_Out_V_S2_Ct11 = new Condition(T41_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionCondition.HaveCar);
        Condition T41_Out_V_S2_Ct12 = new Condition(T41_Out_V_S2, "P_LaneMarket_V_In_S2", TransitionCondition.IsNull);
        Condition T41_Out_V_S2_Ct13 = new Condition(T41_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionCondition.CanAddCars);
        T41_Out_V_S2_Ct12.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct13);
        T41_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct12);
        GuardMapping grd1T41_In_V_S2 = new GuardMapping();
        grd1T41_In_V_S2.condition = T41_Out_V_S2_Ct11;
        grd1T41_In_V_S2.Activations.add(new Activation(T41_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int11_V_S2"));
        T41_Out_V_S2.GuardMappingList.add(grd1T41_In_V_S2);

        // --------------guard 2-------------------------------------------------------
        Condition T41_Out_V_S2_Ct21 = new Condition(T41_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionCondition.DontHaveCar);
        Condition T41_Out_V_S2_Ct22 = new Condition(T41_Out_V_S2, "P_LaneMarket_V_In_S2", TransitionCondition.NotNull);
        Condition T41_Out_V_S2_Ct23 = new Condition(T41_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionCondition.CanAddCars);
        T41_Out_V_S2_Ct22.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct23);
        T41_Out_V_S2_Ct21.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct22);
        GuardMapping grd2T41_In_V_S2 = new GuardMapping();
        grd2T41_In_V_S2.condition = T41_Out_V_S2_Ct21;
        grd2T41_In_V_S2.Activations.add(new Activation(T41_Out_V_S2, "P_LaneMarket_V_In_S2", TransitionOperation.AddElement, "P_LaneOut_Int11_V_S2"));
        T41_Out_V_S2.GuardMappingList.add(grd2T41_In_V_S2);

        // --------------guard 3-------------------------------------------------------
        Condition T41_Out_V_S2_Ct31 = new Condition(T41_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionCondition.HaveCar);
        Condition T41_Out_V_S2_Ct32 = new Condition(T41_Out_V_S2, "P_LaneMarket_V_In_S2", TransitionCondition.IsPriorityCar);
        Condition T41_Out_V_S2_Ct33 = new Condition(T41_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionCondition.CanAddCars);
        T41_Out_V_S2_Ct32.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct33);
        T41_Out_V_S2_Ct31.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct32);
        GuardMapping grd3T41_In_V_S2 = new GuardMapping();
        grd3T41_In_V_S2.condition = T41_Out_V_S2_Ct31;
        grd3T41_In_V_S2.Activations.add(new Activation(T41_Out_V_S2, "P_LaneMarket_V_In_S2", TransitionOperation.AddElement, "P_LaneOut_Int11_V_S2"));
        grd3T41_In_V_S2.Activations.add(new Activation(T41_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int11_V_S2"));
        T41_Out_V_S2.GuardMappingList.add(grd3T41_In_V_S2);

        // --------------guard 4-------------------------------------------------------
        Condition T41_Out_V_S2_Ct41 = new Condition(T41_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionCondition.HaveCar);
        Condition T41_Out_V_S2_Ct42 = new Condition(T41_Out_V_S2, "P_LaneMarket_V_In_S2", TransitionCondition.NotNull);
        Condition T41_Out_V_S2_Ct43 = new Condition(T41_Out_V_S2, "P_LaneOut_Int11_V_S2", TransitionCondition.CanAddCars);
        T41_Out_V_S2_Ct42.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct43);
        T41_Out_V_S2_Ct41.SetNextCondition(LogicConnector.AND, T41_Out_V_S2_Ct42);
        GuardMapping grd4T41_In_V_S2 = new GuardMapping();
        grd4T41_In_V_S2.condition = T41_Out_V_S2_Ct41;
        grd4T41_In_V_S2.Activations.add(new Activation(T41_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int11_V_S2"));
        grd4T41_In_V_S2.Activations.add(new Activation(T41_Out_V_S2, "P_LaneMarket_V_In_S2", TransitionOperation.AddElement, "P_LaneOut_Int11_V_S2"));
        T41_Out_V_S2.GuardMappingList.add(grd4T41_In_V_S2);


        T41_Out_V_S2.Delay = 1;
        pn.Transitions.add(T41_Out_V_S2);
        //----------------------------END T41_Out_V_S2----------------------------------------

        DataCar P_LaneMarket_V_Out_S2 = new DataCar();
        P_LaneMarket_V_Out_S2.SetName("P_LaneMarket_V_Out_S2");
        pn.PlaceList.add(P_LaneMarket_V_Out_S2);

        DataCarQueue P_LaneOut_Int13_V_S2 = new DataCarQueue();
        P_LaneOut_Int13_V_S2.SetName("P_LaneOut_Int13_V_S2");
        P_LaneOut_Int13_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int13_V_S2);

        //----------------------------T43_Out_V_S2----------------------------------------

        PetriTransition T43_Out_V_S2 = new PetriTransition(pn);
        T43_Out_V_S2.TransitionName = "T43_Out_V_S2";
        T43_Out_V_S2.InputPlaceName.add("P_LaneOut_Int13_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T43_Out_V_S2_Ct11 = new Condition(T43_Out_V_S2, "P_LaneOut_Int13_V_S2", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T43_Out_V_S2 = new GuardMapping();
        grd1T43_Out_V_S2.condition= T43_Out_V_S2_Ct11;
        grd1T43_Out_V_S2.Activations.add(new Activation(T43_Out_V_S2, "P_LaneOut_Int13_V_S2", TransitionOperation.PopElementWithTarget, "P_LaneMarket_V_Out_S2"));
        T43_Out_V_S2.GuardMappingList.add(grd1T43_Out_V_S2);
        T43_Out_V_S2.Delay = 1;
        pn.Transitions.add(T43_Out_V_S2);

        //----------------------------END T43_Out_V_S2----------------------------------------

        //----------------------------T45_Out_V_S2----------------------------------------

        PetriTransition T45_Out_V_S2 = new PetriTransition(pn);
        T45_Out_V_S2.TransitionName = "T45_Out_V_S2";
        T45_Out_V_S2.InputPlaceName.add("P_LaneOut_Int13_V_S2");

        // --------------guard 1-------------------------------------------------------
        Condition T45_Out_V_S2_Ct11 = new Condition(T45_Out_V_S2, "P_LaneOut_Int13_V_S2", TransitionCondition.HaveCarForMe);
        Condition T45_Out_V_S2_Ct12= new Condition(T45_Out_V_S2, "P_LaneOut_Int12_V_S2", TransitionCondition.CanAddCars);
        GuardMapping grd1T45_Out_V_S2 = new GuardMapping();
        T45_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T45_Out_V_S2_Ct12);
        grd1T45_Out_V_S2.condition= T45_Out_V_S2_Ct11;
        grd1T45_Out_V_S2.Activations.add(new Activation(T45_Out_V_S2, "P_LaneOut_Int13_V_S2", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int12_V_S2"));
        T45_Out_V_S2.GuardMappingList.add(grd1T45_Out_V_S2);
        T45_Out_V_S2.Delay = 1;
        pn.Transitions.add(T45_Out_V_S2);

        //----------------------------END T45_Out_V_S2----------------------------------------

        DataCarQueue P_O_Lane_V_S2 = new DataCarQueue();
        P_O_Lane_V_S2.Value.Size = 3;
        P_O_Lane_V_S2.SetName("P_O_Lane_V_S2");
        pn.PlaceList.add(P_O_Lane_V_S2);

        //----------------------------T49_Out_V_S2---------------------------------------- //T_g_V_S2

        PetriTransition T49_Out_V_S2 = new PetriTransition(pn);
        T49_Out_V_S2.TransitionName = "T49_Out_V_S2";
        T49_Out_V_S2.InputPlaceName.add("P_I_S2");
        T49_Out_V_S2.InputPlaceName.add("P_O_Lane_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T49_Out_V_S2_Ct11 = new Condition(T49_Out_V_S2, "P_I_S2", TransitionCondition.HaveCarForMe);
        Condition T49_Out_V_S2_Ct12 = new Condition(T49_Out_V_S2, "P_O_Lane_V_S2", TransitionCondition.CanAddCars);
        T49_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T49_Out_V_S2_Ct12);
        GuardMapping grd1T49_Out_V_S2 = new GuardMapping();
        grd1T49_Out_V_S2.condition = T49_Out_V_S2_Ct11;
        grd1T49_Out_V_S2.Activations.add(new Activation(T49_Out_V_S2, "P_I_S2", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_V_S2"));
        T49_Out_V_S2.GuardMappingList.add(grd1T49_Out_V_S2);

        T49_Out_V_S2.Delay = 1;
        pn.Transitions.add(T49_Out_V_S2);

        //----------------------------END T49_Out_V_S2----------------------------------------

        //----------------------------T51_Out_V_S2----------------------------------------

        PetriTransition T51_Out_V_S2 = new PetriTransition(pn);
        T51_Out_V_S2.TransitionName = "T51_Out_V_S2";
        T51_Out_V_S2.InputPlaceName.add("P_O_Lane_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T51_Out_V_S2_Ct11 = new Condition(T51_Out_V_S2, "P_O_Lane_V_S2", TransitionCondition.HaveCar);
        Condition T51_Out_V_S2_Ct12 = new Condition(T51_Out_V_S2, "P_LaneOut_Int13_V_S2", TransitionCondition.CanAddCars);
        T51_Out_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T51_Out_V_S2_Ct12);
        GuardMapping grd1T51_Out_V_S2 = new GuardMapping();
        grd1T51_Out_V_S2.condition = T51_Out_V_S2_Ct11;
        grd1T51_Out_V_S2.Activations.add(new Activation(T51_Out_V_S2, "P_O_Lane_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int13_V_S2"));
        T51_Out_V_S2.GuardMappingList.add(grd1T51_Out_V_S2);

        T51_Out_V_S2.Delay = 1;
        pn.Transitions.add(T51_Out_V_S2);

        //----------------------------END T51_Out_V_S2----------------------------------------

        //------------------NORTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_N_S2 = new DataCar();
        P_LaneIn_N_S2.SetName("P_LaneIn_N_S2");
        pn.PlaceList.add(P_LaneIn_N_S2);

        DataCarQueue P_x_Lane_N_S2 = new DataCarQueue();
        P_x_Lane_N_S2.Value.Size = 3;
        P_x_Lane_N_S2.SetName("P_x_Lane_N_S2");
        pn.PlaceList.add(P_x_Lane_N_S2);

        DataCar P_b_Lane_N_S2 = new DataCar();
        P_b_Lane_N_S2.SetName("P_b_Lane_N_S2");
        pn.PlaceList.add(P_b_Lane_N_S2);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_N_S2 = new DataTransfer();
        OP_N_S2.SetName("OP_V_S2");
        OP_N_S2.Value = new TransferOperation("localhost", "1082", "in1");
        pn.PlaceList.add(OP_N_S2);
        //----------------------------T6_In_N_S2----------------------------------------------//T_Out_E_S1
        PetriTransition T6_In_N_S2 = new PetriTransition(pn);
        T6_In_N_S2.TransitionName = "T6_In_N_S2";
        T6_In_N_S2.InputPlaceName.add("P_LaneIn_int16_V_S2");
        T6_In_N_S2.InputPlaceName.add("P_x_Lane_V_S2");
        //T6_In_N_S2.IsAsync = true;

        Condition T6_In_N_S2_Ct1 = new Condition(T6_In_N_S2, "P_LaneIn_N_S2", TransitionCondition.NotNull);
        Condition T6_In_N_S2_Ct2 = new Condition(T6_In_N_S2, "P_x_Lane_N_S2", TransitionCondition.CanNotAddCars);
        T6_In_N_S2_Ct1.SetNextCondition(LogicConnector.AND, T6_In_N_S2_Ct2);

        GuardMapping grdT6_In_N_S2 = new GuardMapping();
        grdT6_In_N_S2.condition = T6_In_N_S2_Ct1;
        grdT6_In_N_S2.Activations.add(new Activation(T6_In_N_S2, "full", TransitionOperation.SendOverNetwork, "OP_N_S2"));
        T6_In_N_S2.GuardMappingList.add(grdT6_In_N_S2);

        T6_In_N_S2.Delay = 1;
        pn.Transitions.add(T6_In_N_S2);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //------------------------------T0_N_S2-------------------------------------------- //T_u_Car1_N
        PetriTransition T0_In_N_S2 = new PetriTransition(pn);
        T0_In_N_S2.TransitionName = "T0_In_N_S2";
        T0_In_N_S2.InputPlaceName.add("P_LaneIn_N_S2");
        T0_In_N_S2.InputPlaceName.add("P_x_Lane_N_S2");

        Condition T0_In_N_S2_Ct11 = new Condition(T0_In_N_S2, "P_LaneIn_N_S2", TransitionCondition.NotNull);
        Condition T0_In_N_S2_Ct12 = new Condition(T0_In_N_S2, "P_x_Lane_N_S2", TransitionCondition.CanAddCars);
        T0_In_N_S2_Ct11.SetNextCondition(LogicConnector.AND, T0_In_N_S2_Ct12);

        GuardMapping grd1T0_In_N_S2 = new GuardMapping();
        grd1T0_In_N_S2.condition = T0_In_N_S2_Ct11;
        grd1T0_In_N_S2.Activations.add(new Activation(T0_In_N_S2, "P_LaneIn_N_S1", TransitionOperation.AddElement, "P_x_Lane_N_S1"));
        T0_In_N_S2.GuardMappingList.add(grd1T0_In_N_S2);

        T0_In_N_S2.Delay = 1;
        pn.Transitions.add(T0_In_N_S2);
        //---------------------------- END T0_N_S2----------------------------------------

        //------------------------------T2_N_S2-------------------------------------------- //T_e_Car1_N
        PetriTransition T2_In_N_S2 = new PetriTransition(pn);
        T2_In_N_S2.TransitionName = "T2_In_N_S2";
        T2_In_N_S2.InputPlaceName.add("P_x_Lane_N_S2");
        T2_In_N_S2.InputPlaceName.add("P_TL_N_S2");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_N_S2_C31 = new Condition(T2_In_N_S2, "P_x_Lane_N_S2", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_N_S2 = new GuardMapping();
        grd3T2_In_N_S2.condition= T2_In_N_S2_C31;
        grd3T2_In_N_S2.Activations.add(new Activation(T2_In_N_S2, "P_x_Lane_N_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_N_S2"));
        grd3T2_In_N_S2.Activations.add(new Activation(T2_In_N_S2, "P_TL_N_S2", TransitionOperation.Move, "P_TL_N_S2"));

        T2_In_N_S2.GuardMappingList.add(grd3T2_In_N_S2);

        //-----------------------guard1---------------------------------------------------

        Condition T2_In_N_S2_Ct11 = new Condition(T2_In_N_S2, "P_TL_N_S2", TransitionCondition.Equal,"green");
        Condition T2_In_N_S2_Ct12 = new Condition(T2_In_N_S2, "P_x_Lane_N_S2", TransitionCondition.HaveCar);
        T2_In_N_S2_Ct11.SetNextCondition(LogicConnector.AND, T2_In_N_S2_Ct12);

        GuardMapping grd1T2_In_N_S2 = new GuardMapping();
        grd1T2_In_N_S2.condition= T2_In_N_S2_Ct11;
        grd1T2_In_N_S2.Activations.add(new Activation(T2_In_N_S2, "P_x_Lane_N_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_N_S2"));
        grd1T2_In_N_S2.Activations.add(new Activation(T2_In_N_S2, "P_TL_N_S2", TransitionOperation.Move, "P_TL_N_S2"));
        T2_In_N_S2.GuardMappingList.add(grd1T2_In_N_S2);


        //-----------------------------T4_N_S1-------------------------------------------//T_I_Car1_N
        PetriTransition T4_In_N_S2 = new PetriTransition(pn);
        T4_In_N_S2.TransitionName = "T4_In_N_S2";
        T4_In_N_S2.InputPlaceName.add("P_b_Lane_N_S2");
        T4_In_N_S2.InputPlaceName.add("P_I_S2");

        Condition T4_In_N_S2_Ct11 = new Condition(T4_In_N_S2, "P_b_Lane_N_S2", TransitionCondition.NotNull);
        Condition T4_In_N_S2_Ct12 = new Condition(T4_In_N_S2, "P_I_S2", TransitionCondition.CanAddCars);
        T4_In_N_S2_Ct11.SetNextCondition(LogicConnector.AND, T4_In_N_S2_Ct12);

        GuardMapping grd1T4_In_N_S2 = new GuardMapping();
        grd1T4_In_N_S2.condition = T4_In_N_S2_Ct11;
        grd1T4_In_N_S2.Activations.add(new Activation(T4_In_N_S2, "P_b_Lane_N_S2", TransitionOperation.AddElement, "P_I_S2"));
        T4_In_N_S2.GuardMappingList.add(grd1T4_In_N_S2);

        T4_In_N_S2.Delay = 1;
        pn.Transitions.add(T4_In_N_S2);
        //---------------------------- END T4_In_N_S1----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_N_S2 = new DataCarQueue();
        P_O_Lane_N_S2.Value.Size = 3;
        P_O_Lane_N_S2.SetName("P_O_Lane_N_S2");
        pn.PlaceList.add(P_O_Lane_N_S2);

        DataCar P_Oe_Lane_N_S2 = new DataCar();
        P_Oe_Lane_N_S2.SetName("P_Oe_Lane_N_S2");
        pn.PlaceList.add(P_Oe_Lane_N_S2);

        //----------------------------T1_N_S1---------------------------------------- T_ge_CarLane1_N_S2

        PetriTransition T1_Out_N_S2 = new PetriTransition(pn);
        T1_Out_N_S2.TransitionName = "T1_Out_N_S2";
        T1_Out_N_S2.InputPlaceName.add("P_O_Lane_N_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_N_S2_Ct11 = new Condition(T1_Out_N_S2, "P_O_Lane_N_S2", TransitionCondition.HaveCar);
        GuardMapping grd1T1_Out_N_S2 = new GuardMapping();
        grd1T1_Out_N_S2.condition = T1_Out_N_S2_Ct11;
        grd1T1_Out_N_S2.Activations.add(new Activation(T1_Out_N_S2, "P_O_Lane_N_S2", TransitionOperation.PopElementWithoutTarget, "P_Oe_Lane_N_S2"));
        T1_Out_N_S2.GuardMappingList.add(grd1T1_Out_N_S2);

        T1_Out_N_S2.Delay = 1;
        pn.Transitions.add(T1_Out_N_S2);

        //----------------------------END T1_N_S1----------------------------------------

        //----------------------------T3_N_S1---------------------------------------- T_g_CarLane1_N_S2

        PetriTransition T3_Out_N_S2 = new PetriTransition(pn);
        T3_Out_N_S2.TransitionName = "T3_Out_N_S2";
        T3_Out_N_S2.InputPlaceName.add("P_I_S2");
        T3_Out_N_S2.InputPlaceName.add("P_O_Lane_N_S2");

        // --------------guard 2-------------------------------------------------------OK
        Condition T3_Out_N_S2_Ct21 = new Condition(T3_Out_N_S2, "P_I_S2", TransitionCondition.HaveCarForMe);
        Condition T3_Out_N_S2_Ct22 = new Condition(T3_Out_N_S2, "P_O_Lane_N_S2", TransitionCondition.CanAddCars);

        T3_Out_N_S2_Ct21.SetNextCondition(LogicConnector.AND, T3_Out_N_S2_Ct22);
        GuardMapping grd2T3_Out_N_S2 = new GuardMapping();
        grd2T3_Out_N_S2.condition = T3_Out_N_S2_Ct21;
        grd2T3_Out_N_S2.Activations.add(new Activation(T3_Out_N_S2, "P_I_S2", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_N_S2"));
        T3_Out_N_S2.GuardMappingList.add(grd2T3_Out_N_S2);

        T3_Out_N_S2.Delay = 1;
        pn.Transitions.add(T3_Out_N_S2);

        //----------------------------END T3_Out_N_S1----------------------------------------

        //------------------SOUTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_int1_S_S2 = new DataCar();
        P_LaneIn_int1_S_S2.SetName("P_LaneIn_int1_S_S2");
        pn.PlaceList.add(P_LaneIn_int1_S_S2);

        DataCarQueue P_x_Lane_S_S2 = new DataCarQueue();
        P_x_Lane_S_S2.Value.Size = 3;
        P_x_Lane_S_S2.SetName("P_x_Lane_S_S2");
        pn.PlaceList.add(P_x_Lane_S_S2);

        DataCar P_b_Lane_S_S2 = new DataCar();
        P_b_Lane_S_S2.SetName("P_b_Lane_S_S2");
        pn.PlaceList.add(P_b_Lane_S_S2);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_S_S2 = new DataTransfer();
        OP_S_S2.SetName("OP_S_S2");
        OP_S_S2.Value = new TransferOperation("localhost", "1082", "in3");
        pn.PlaceList.add(OP_S_S2);
        //----------------------------T6_In_S_S2----------------------------------------------//T_Out_E_S1
        PetriTransition T6_In_S_S2 = new PetriTransition(pn);
        T6_In_S_S2.TransitionName = "T6_In_S_S2";
        T6_In_S_S2.InputPlaceName.add("P_LaneIn_int16_V_S2");
        T6_In_S_S2.InputPlaceName.add("P_x_Lane_V_S2");
        //T6_In_S_S2.IsAsync = true;

        Condition T6_In_S_S2_Ct1 = new Condition(T6_In_S_S2, "P_LaneIn_int1_S_S2", TransitionCondition.NotNull);
        Condition T6_In_S_S2_Ct2 = new Condition(T6_In_S_S2, "P_x_Lane_S_S2", TransitionCondition.CanNotAddCars);
        T6_In_S_S2_Ct1.SetNextCondition(LogicConnector.AND, T6_In_S_S2_Ct2);

        GuardMapping grdT6_In_S_S2 = new GuardMapping();
        grdT6_In_S_S2.condition = T6_In_S_S2_Ct1;
        grdT6_In_S_S2.Activations.add(new Activation(T6_In_S_S2, "full", TransitionOperation.SendOverNetwork, "OP_S_S2"));
        T6_In_S_S2.GuardMappingList.add(grdT6_In_S_S2);

        T6_In_S_S2.Delay = 1;
        pn.Transitions.add(T6_In_S_S2);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //------------------------------T0_In_S_S2-------------------------------------------- //T_u_In_S_S2
        PetriTransition T0_In_S_S2 = new PetriTransition(pn);
        T0_In_S_S2.TransitionName = "T0_In_S_S2";
        T0_In_S_S2.InputPlaceName.add("P_LaneIn_int1_S_S2");
        T0_In_S_S2.InputPlaceName.add("P_x_Lane_S_S2");

        Condition T0_In_S_S2_Ct11 = new Condition(T0_In_S_S2, "P_LaneIn_int1_S_S2", TransitionCondition.NotNull);
        Condition T0_In_S_S2_Ct12 = new Condition(T0_In_S_S2, "P_x_Lane_S_S2", TransitionCondition.CanAddCars);
        T0_In_S_S2_Ct11.SetNextCondition(LogicConnector.AND, T0_In_S_S2_Ct12);

        GuardMapping grd1T0_In_S_S2 = new GuardMapping();
        grd1T0_In_S_S2.condition = T0_In_S_S2_Ct11;
        grd1T0_In_S_S2.Activations.add(new Activation(T0_In_S_S2, "P_LaneIn_int1_S_S2", TransitionOperation.AddElement, "P_x_Lane_S_S2"));
        T0_In_S_S2.GuardMappingList.add(grd1T0_In_S_S2);

        T0_In_S_S2.Delay = 1;
        pn.Transitions.add(T0_In_S_S2);
        //---------------------------- END T0_In_S_S2----------------------------------------

        //------------------------------T2_In_S_S2-------------------------------------------- //T_e_In_S_S2
        PetriTransition T2_In_S_S2 = new PetriTransition(pn);
        T2_In_S_S2.TransitionName = "T2_In_S_S2";
        T2_In_S_S2.InputPlaceName.add("P_x_Lane_S_S2");
        T2_In_S_S2.InputPlaceName.add("P_TL_S_S2");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_S_S2_C31 = new Condition(T2_In_S_S2, "P_x_Lane_S_S2", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_S_S2 = new GuardMapping();
        grd3T2_In_S_S2.condition= T2_In_S_S2_C31;
        grd3T2_In_S_S2.Activations.add(new Activation(T2_In_S_S2, "P_x_Lane_S_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_S_S2"));
        grd3T2_In_S_S2.Activations.add(new Activation(T2_In_S_S2, "P_TL_S_S2", TransitionOperation.Move, "P_TL_S_S2"));

        T2_In_S_S2.GuardMappingList.add(grd3T2_In_S_S2);

        //------------------------guard 1-------------------------------------------------------

        Condition T2_In_S_S2_Ct11 = new Condition(T2_In_S_S2, "P_TL_S_S2", TransitionCondition.Equal,"green");
        Condition T2_In_S_S2_Ct12 = new Condition(T2_In_S_S2, "P_x_Lane_S_S2", TransitionCondition.HaveCar);
        T2_In_S_S2_Ct11.SetNextCondition(LogicConnector.AND, T2_In_S_S2_Ct12);

        GuardMapping grd1T2_In_S_S2 = new GuardMapping();
        grd1T2_In_S_S2.condition= T2_In_S_S2_Ct11;
        grd1T2_In_S_S2.Activations.add(new Activation(T2_In_S_S2, "P_x_Lane_S_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_S_S2"));
        grd1T2_In_S_S2.Activations.add(new Activation(T2_In_S_S2, "P_TL_S_S2", TransitionOperation.Move, "P_TL_S_S2"));

        T2_In_S_S2.GuardMappingList.add(grd1T2_In_S_S2);

        T2_In_S_S2.Delay = 1;
        pn.Transitions.add(T2_In_S_S2);
        //---------------------------- END T2_In_S_S1----------------------------------------

        //------------------------------T4_In_S_S2-------------------------------------------- //T_I_In_S_S2
        PetriTransition T4_In_S_S2 = new PetriTransition(pn);
        T4_In_S_S2.TransitionName = "T4_In_S_S2";
        T4_In_S_S2.InputPlaceName.add("P_b_Lane_S_S2");
        T4_In_S_S2.InputPlaceName.add("P_I_S2");

        Condition T4_In_S_S2_Ct11 = new Condition(T4_In_S_S2, "P_b_Lane_S_S2", TransitionCondition.NotNull);
        Condition T4_In_S_S2_Ct12 = new Condition(T4_In_S_S2, "P_I_S2", TransitionCondition.CanAddCars);
        T4_In_S_S2_Ct11.SetNextCondition(LogicConnector.AND, T4_In_S_S2_Ct12);

        GuardMapping grd1T4_In_S_S2 = new GuardMapping();
        grd1T4_In_S_S2.condition = T4_In_S_S2_Ct11;
        grd1T4_In_S_S2.Activations.add(new Activation(T4_In_S_S2, "P_b_Lane_S_S2", TransitionOperation.AddElement, "P_I_S2"));
        T4_In_S_S2.GuardMappingList.add(grd1T4_In_S_S2);

        T4_In_S_S2.Delay = 1;
        pn.Transitions.add(T4_In_S_S2);
        //---------------------------- END T4_S_S2----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_S_S2 = new DataCarQueue();
        P_O_Lane_S_S2.Value.Size = 3;
        P_O_Lane_S_S2.SetName("P_O_Lane_S_S2");
        pn.PlaceList.add(P_O_Lane_S_S2);

        DataCar P_Oe_Lane_S_S2 = new DataCar();
        P_Oe_Lane_S_S2.SetName("P_Oe_Lane_S_S2");
        pn.PlaceList.add(P_Oe_Lane_S_S2);

        //----------------------------T1_Out_S_S2---------------------------------------- T_ge_Out_S_S2

        PetriTransition T1_Out_S_S2 = new PetriTransition(pn);
        T1_Out_S_S2.TransitionName = "T1_Out_S_S2";
        T1_Out_S_S2.InputPlaceName.add("P_O_Lane_S_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_S_S2_Ct11 = new Condition(T1_Out_S_S2, "P_O_Lane_S_S2", TransitionCondition.HaveCar);
        GuardMapping grd1T1_Out_S_S2 = new GuardMapping();
        grd1T1_Out_S_S2.condition = T1_Out_S_S2_Ct11;
        grd1T1_Out_S_S2.Activations.add(new Activation(T1_Out_S_S2, "P_O_Lane_S_S2", TransitionOperation.PopElementWithoutTarget, "P_Oe_Lane_S_S2"));
        T1_Out_S_S2.GuardMappingList.add(grd1T1_Out_S_S2);

        T1_Out_S_S2.Delay = 1;
        pn.Transitions.add(T1_Out_S_S2);

        //----------------------------END T1_Out_S_S2----------------------------------------

        //----------------------------T3_S_S2---------------------------------------- T_g_CarLane1_S_S2

        PetriTransition T3_Out_S_S2 = new PetriTransition(pn);
        T3_Out_S_S2.TransitionName = "T3_Out_S_S2";
        T3_Out_S_S2.InputPlaceName.add("P_I_2");
        T3_Out_S_S2.InputPlaceName.add("P_O_Lane_S_S2");


        // --------------guard 1-------------------------------------------------------OK
        Condition T3_Out_S_S2_Ct11 = new Condition(T3_Out_S_S2, "P_I_S2", TransitionCondition.HaveCarForMe);
        Condition T3_Out_S_S2_Ct12 = new Condition(T3_Out_S_S2, "P_O_Lane_S_S2", TransitionCondition.CanAddCars);
        T3_Out_S_S2_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_S_S2_Ct12);
        GuardMapping grd1T3_Out_S_S2 = new GuardMapping();
        grd1T3_Out_S_S2.condition = T3_Out_S_S2_Ct11;
        grd1T3_Out_S_S2.Activations.add(new Activation(T3_Out_S_S2, "P_I_S2", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_S_S2"));
        T3_Out_S_S2.GuardMappingList.add(grd1T3_Out_S_S2);

        T3_Out_S_S2.Delay = 1;
        pn.Transitions.add(T3_Out_S_S2);

        //----------------------------END T3_S_S2----------------------------------------


        //------------------EAST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_x_Lane_E_S2 = new DataCarQueue();
        P_x_Lane_E_S2.Value.Size = 3;
        P_x_Lane_E_S2.SetName("P_x_Lane_E_S2");
        pn.PlaceList.add(P_x_Lane_E_S2);

        DataCar P_b_Lane_E_S2 = new DataCar();
        P_b_Lane_E_S2.SetName("P_b_Lane_E_S2");
        pn.PlaceList.add(P_b_Lane_E_S2);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        DataTransfer OP_E_S2 = new DataTransfer();
        OP_E_S2.SetName("OP_E_S2");
        OP_E_S2.Value = new TransferOperation("localhost", "1082", "in4");
        pn.PlaceList.add(OP_E_S2);
        //----------------------------T6_In_E_S2----------------------------------------------//T_Out_E_S1
        PetriTransition T6_In_E_S2 = new PetriTransition(pn);
        T6_In_E_S2.TransitionName = "T6_In_E_S2";
        T6_In_E_S2.InputPlaceName.add("P_LaneOut_Int1_V_S3");
        T6_In_E_S2.InputPlaceName.add("P_x_Lane_E_S2");
        //T6_In_E_S2.IsAsync = true;

        Condition T6_In_E_S2_Ct1 = new Condition(T6_In_E_S2, "P_LaneOut_Int1_V_S3", TransitionCondition.HaveCar);
        Condition T6_In_E_S2_Ct2 = new Condition(T6_In_E_S2, "P_x_Lane_S_S2", TransitionCondition.CanNotAddCars);
        T6_In_E_S2_Ct1.SetNextCondition(LogicConnector.AND, T6_In_E_S2_Ct2);

        GuardMapping grdT6_In_E_S2 = new GuardMapping();
        grdT6_In_E_S2.condition = T6_In_S_S2_Ct1;
        grdT6_In_E_S2.Activations.add(new Activation(T6_In_E_S2, "full", TransitionOperation.SendOverNetwork, "OP_E_S2"));
        T6_In_S_S2.GuardMappingList.add(grdT6_In_E_S2);

        T6_In_E_S2.Delay = 1;
        pn.Transitions.add(T6_In_E_S2);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //------------------------------T0_In_E_S2-------------------------------------------- //T_u_In_E_S2
        PetriTransition T0_In_E_S2 = new PetriTransition(pn);
        T0_In_E_S2.TransitionName = "T0_In_E_S2";
        T0_In_E_S2.InputPlaceName.add("P_LaneOut_Int1_V_S3");
        T0_In_E_S2.InputPlaceName.add("P_x_Lane_E_S2");

        Condition T0_In_E_S2_Ct11 = new Condition(T0_In_E_S2, "P_LaneOut_Int1_V_S3", TransitionCondition.HaveCar);
        Condition T0_In_E_S2_Ct12 = new Condition(T0_In_E_S2, "P_x_Lane_E_S2", TransitionCondition.CanAddCars);
        T0_In_E_S2_Ct11.SetNextCondition(LogicConnector.AND, T0_In_E_S2_Ct12);

        GuardMapping grd1T0_In_E_S2 = new GuardMapping();
        grd1T0_In_E_S2.condition = T0_In_E_S2_Ct11;
        grd1T0_In_E_S2.Activations.add(new Activation(T0_In_E_S2, "P_LaneOut_Int1_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Lane_E_S2"));
        T0_In_E_S2.GuardMappingList.add(grd1T0_In_E_S2);

        T0_In_E_S2.Delay = 1;
        pn.Transitions.add(T0_In_E_S2);
        //---------------------------- END T0_In_E_S2----------------------------------------

        //------------------------------T2_In_E_S2-------------------------------------------- //T_e_In_E_S2
        PetriTransition T2_In_E_S2 = new PetriTransition(pn);
        T2_In_E_S2.TransitionName = "T2_In_E_S2";
        T2_In_E_S2.InputPlaceName.add("P_x_Lane_E_S2");
        T2_In_E_S2.InputPlaceName.add("P_TL_E_S2");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_E_S2_C31 = new Condition(T2_In_E_S2, "P_x_Lane_E_S2", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_E_S2 = new GuardMapping();
        grd3T2_In_E_S2.condition= T2_In_E_S2_C31;
        grd3T2_In_E_S2.Activations.add(new Activation(T2_In_E_S2, "P_x_Lane_E_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_E_S2"));
        grd3T2_In_E_S2.Activations.add(new Activation(T2_In_E_S2, "P_TL_E_S2", TransitionOperation.Move, "P_TL_E_S2"));

        T2_In_E_S2.GuardMappingList.add(grd3T2_In_E_S2);


        //-----------------------guard1---------------------------------------------------

        Condition T2_In_E_S2_Ct11 = new Condition(T2_In_E_S2, "P_TL_E_S2", TransitionCondition.Equal,"green");
        Condition T2_In_E_S2_Ct12 = new Condition(T2_In_E_S2, "P_x_Lane_E_S2", TransitionCondition.HaveCar);
        T2_In_E_S2_Ct11.SetNextCondition(LogicConnector.AND, T2_In_E_S2_Ct12);

        GuardMapping grd1T2_In_E_S2 = new GuardMapping();
        grd1T2_In_E_S2.condition= T2_In_E_S2_Ct11;
        grd1T2_In_E_S2.Activations.add(new Activation(T2_In_E_S2, "P_x_Lane_E_S2", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_E_S2"));
        grd1T2_In_E_S2.Activations.add(new Activation(T2_In_E_S2, "P_TL_E_S2", TransitionOperation.Move, "P_TL_E_S2"));
        T2_In_E_S2.GuardMappingList.add(grd1T2_In_E_S2);

        T2_In_E_S2.Delay = 1;
        pn.Transitions.add(T2_In_E_S2);
        //---------------------------- END T2_In_E_S1----------------------------------------

        //-----------------------------T4_In_E_S2-------------------------------------------//T_I_In_E_S2
        PetriTransition T4_In_E_S2 = new PetriTransition(pn);
        T4_In_E_S2.TransitionName = "T4_In_E_S2";
        T4_In_E_S2.InputPlaceName.add("P_b_Lane_E_S2");
        T4_In_E_S2.InputPlaceName.add("P_I_S2");

        Condition T4_In_E_S2_Ct11 = new Condition(T4_In_E_S2, "P_b_Lane_E_S2", TransitionCondition.NotNull);
        Condition T4_In_E_S2_Ct12 = new Condition(T4_In_E_S2, "P_I_S2", TransitionCondition.CanAddCars);
        T4_In_E_S2_Ct11.SetNextCondition(LogicConnector.AND, T4_In_E_S2_Ct12);

        GuardMapping grd1T4_In_E_S2 = new GuardMapping();
        grd1T4_In_E_S2.condition = T4_In_E_S2_Ct11;
        grd1T4_In_E_S2.Activations.add(new Activation(T4_In_E_S2, "P_b_Lane_E_S2", TransitionOperation.AddElement, "P_I_S2"));
        T4_In_E_S2.GuardMappingList.add(grd1T4_In_E_S2);

        T4_In_E_S2.Delay = 1;
        pn.Transitions.add(T4_In_E_S2);
        //---------------------------- END T4_In_E_S2---------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_E_S2 = new DataCarQueue();
        P_O_Lane_E_S2.Value.Size = 3;
        P_O_Lane_E_S2.SetName("P_O_Lane_E_S2");
        pn.PlaceList.add(P_O_Lane_E_S2);

        //----------------------------T3_Out_E_S1---------------------------------------- T_g_CarLane1_E

        PetriTransition T3_Out_E_S2 = new PetriTransition(pn);
        T3_Out_E_S2.TransitionName = "T3_Out_E_S2";
        T3_Out_E_S2.InputPlaceName.add("P_I_S2");
        T3_Out_E_S2.InputPlaceName.add("P_O_Lane_E_S2");


        // --------------guard 1-------------------------------------------------------OK
        Condition T3_Out_E_S2_Ct11 = new Condition(T3_Out_E_S2, "P_I_S2", TransitionCondition.HaveCarForMe);
        Condition T3_Out_E_S2_Ct12 = new Condition(T3_Out_E_S2, "P_O_Lane_E_S2", TransitionCondition.CanAddCars);
        T3_Out_E_S2_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_E_S2_Ct12);
        GuardMapping grd1T3_Out_E_S2 = new GuardMapping();
        grd1T3_Out_E_S2.condition = T3_Out_E_S2_Ct11;
        grd1T3_Out_E_S2.Activations.add(new Activation(T3_Out_E_S2, "P_I_S2", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_E_S2"));
        T3_Out_E_S2.GuardMappingList.add(grd1T3_Out_E_S2);

        T3_Out_E_S2.Delay = 1;
        pn.Transitions.add(T3_Out_E_S2);

        //----------------------------END T3_E_S1----------------------------------------

        //----------------------------T1_Out_E_S1---------------------------------------- T_ge_CarLane1_E

        PetriTransition T1_Out_E_S2 = new PetriTransition(pn);
        T1_Out_E_S2.TransitionName = "T1_Out_E_S2";
        T1_Out_E_S2.InputPlaceName.add("P_O_Lane_E_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_E_S2_Ct11 = new Condition(T1_Out_E_S2, "P_O_Lane_E_S2", TransitionCondition.HaveCar);
        Condition T1_Out_E_S2_Ct12 = new Condition(T1_Out_E_S2, "P_LaneIn_int1_V_S3", TransitionCondition.CanAddCars);
        T1_Out_E_S2_Ct11.SetNextCondition(LogicConnector.AND, T1_Out_E_S2_Ct12);
        GuardMapping grd1T1_Out_E_S2 = new GuardMapping();
        grd1T1_Out_E_S2.condition = T1_Out_E_S2_Ct11;
        grd1T1_Out_E_S2.Activations.add(new Activation(T1_Out_E_S2, "P_O_Lane_E_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S3"));
        T1_Out_E_S2.GuardMappingList.add(grd1T1_Out_E_S2);

        T1_Out_E_S2.Delay = 1;
        pn.Transitions.add(T1_Out_E_S2);

        //----------------------------END T1_Out_E_S1----------------------------------------

        //-------------------INTERSECTION---------------------------
        DataCarQueue P_I_S2 = new DataCarQueue();
        P_I_S2.Value.Size = 3;
        P_I_S2.SetName("P_I_S2");
        pn.PlaceList.add(P_I_S2);

        //-------------------SEMAPHORES---------------------------
        //-------------------VEST---------------------------
        DataString P_TL_V_S2 = new DataString();
        P_TL_V_S2.SetName("P_TL_V_S2");
        pn.PlaceList.add(P_TL_V_S2);



        //-------------------NORTH---------------------------
        DataString P_TL_N_S2 = new DataString();
        P_TL_N_S2.SetName("P_TL_N_S2");
        pn.PlaceList.add(P_TL_N_S2);



        //-------------------SOUTH---------------------------
        DataString P_TL_S_S2 = new DataString();
        P_TL_S_S2.SetName("P_TL_S_S2");
        pn.PlaceList.add(P_TL_S_S2);



        //-------------------EAST---------------------------
        DataString P_TL_E_S2 = new DataString();
        P_TL_E_S2.SetName("P_TL_E_S2");
        pn.PlaceList.add(P_TL_E_S2);



        // -------------------------------------------------------------------
        // ----------------END CALEA FERENTARI SECTION 2----------------------
        // -------------------------------------------------------------------

        // -------------------------------------------------------------------
        // --------------------CALEA FERENTARI SECTION 3----------------------
        // -------------------------------------------------------------------

        //------------------VEST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_LaneIn_int1_V_S3 = new DataCarQueue();
        P_LaneIn_int1_V_S3.Value.Size = 3;
        P_LaneIn_int1_V_S3.SetName("P_LaneIn_int1_V_S3");
        pn.PlaceList.add(P_LaneIn_int1_V_S3);

        //----------------------------T0_In_V_S3---------------------------------------- T118

        PetriTransition T0_In_V_S3 = new PetriTransition(pn);
        T0_In_V_S3.TransitionName = "T0_In_V_S3";
        T0_In_V_S3.InputPlaceName.add("P_LaneIn_int1_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T0_In_V_S3_Ct11 = new Condition(T0_In_V_S3, "P_LaneIn_int1_V_S3", TransitionCondition.HaveBusForMe);
        Condition T0_In_V_S3_Ct12 = new Condition(T0_In_V_S3, "P_LaneIn_BusStationProgresului_V_S3", TransitionCondition.CanAddCars);
        T0_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T0_In_V_S3_Ct12);
        GuardMapping grd1T0_In_V_S3 = new GuardMapping();
        grd1T0_In_V_S3.condition = T0_In_V_S3_Ct11;
        grd1T0_In_V_S3.Activations.add(new Activation(T0_In_V_S3, "P_LaneIn_int1_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_BusStationProgresului_V_S3"));
        T0_In_V_S3.GuardMappingList.add(grd1T0_In_V_S3);

        T0_In_V_S3.Delay = 1;
        pn.Transitions.add(T0_In_V_S3);

        //----------------------------END T0_In_V_S3----------------------------------------

        //----------------------------T2_In_V_S3---------------------------------------- //T197
        PetriTransition T2_In_V_S3 = new PetriTransition(pn);
        T2_In_V_S3.TransitionName = "T2_In_V_S3";
        T2_In_V_S3.InputPlaceName.add("P_LaneIn_int1_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T2_In_V_S3_Ct11 = new Condition(T2_In_V_S3, "P_LaneIn_int1_V_S3", TransitionCondition.HaveCarForMe);
        Condition T2_In_V_S3_Ct12 = new Condition(T2_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.CanAddCars);
        T2_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T2_In_V_S3_Ct12);
        GuardMapping grd1T2_In_V_S3 = new GuardMapping();
        grd1T2_In_V_S3.condition = T2_In_V_S3_Ct11;
        grd1T2_In_V_S3.Activations.add(new Activation(T2_In_V_S3, "P_LaneIn_int1_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int2_V_S3"));
        T2_In_V_S3.GuardMappingList.add(grd1T2_In_V_S3);

        T2_In_V_S3.Delay = 1;
        pn.Transitions.add(T2_In_V_S3);
        //---------------------------- END T2_In_V_S3----------------------------------------

        DataCarQueue P_LaneIn_int2_V_S3 = new DataCarQueue();
        P_LaneIn_int2_V_S3.Value.Size = 3;
        P_LaneIn_int2_V_S3.SetName("P_LaneIn_int2_V_S3");
        pn.PlaceList.add(P_LaneIn_int2_V_S3);

        DataCarQueue P_LaneIn_BusStationProgresului_V_S3 = new DataCarQueue();
        P_LaneIn_BusStationProgresului_V_S3.Value.Size = 2;
        P_LaneIn_BusStationProgresului_V_S3.SetName("P_LaneIn_BusStationProgresului_V_S3");
        pn.PlaceList.add(P_LaneIn_BusStationProgresului_V_S3);

        //----------------------------T4_In_V_S3---------------------------------------- T198

        PetriTransition T4_In_V_S3 = new PetriTransition(pn);
        T4_In_V_S3.TransitionName = "T4_In_V_S3";
        T4_In_V_S3.InputPlaceName.add("P_LaneIn_BusStationProgresului_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T4_In_V_S3_Ct11 = new Condition(T4_In_V_S3, "P_LaneIn_BusStationProgresului_V_S3", TransitionCondition.HaveBus);
        Condition T4_In_V_S3_Ct12 = new Condition(T4_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.CanAddCars);
        T4_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T4_In_V_S3_Ct12);
        GuardMapping grd1T4_In_V_S3 = new GuardMapping();
        grd1T4_In_V_S3.condition = T4_In_V_S3_Ct11;
        grd1T4_In_V_S3.Activations.add(new Activation(T4_In_V_S3, "P_LaneIn_BusStationProgresului_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_BusStationProgresuluiOut_V_S3"));
        T4_In_V_S3.GuardMappingList.add(grd1T4_In_V_S3);

        T4_In_V_S3.Delay = 10;
        pn.Transitions.add(T4_In_V_S3);

        //----------------------------END T4_In_V_S3----------------------------------------

        DataCarQueue P_LaneIn_BusStationProgresuluiOut_V_S3 = new DataCarQueue();
        P_LaneIn_BusStationProgresuluiOut_V_S3.Value.Size = 2;
        P_LaneIn_BusStationProgresuluiOut_V_S3.SetName("P_LaneIn_BusStationProgresuluiOut_V_S3");
        pn.PlaceList.add(P_LaneIn_BusStationProgresuluiOut_V_S3);

        DataCarQueue P_LaneIn_TramStationProgresului_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationProgresului_V_S3.Value.Size = 1;
        P_LaneIn_TramStationProgresului_V_S3.SetName("P_LaneIn_TramStationProgresului_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationProgresului_V_S3);

        DataCarQueue P_LaneIn_TramStationProgresuluiOut_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationProgresuluiOut_V_S3.Value.Size = 1;
        P_LaneIn_TramStationProgresuluiOut_V_S3.SetName("P_LaneIn_TramStationProgresuluiOut_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationProgresuluiOut_V_S3);

        //----------------------------T8_In_V_S3---------------------------------------- T119

        PetriTransition T8_In_V_S3 = new PetriTransition(pn);
        T8_In_V_S3.TransitionName = "T8_In_V_S3";
        T8_In_V_S3.InputPlaceName.add("P_LaneIn_int1_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T8_In_V_S3_Ct11 = new Condition(T8_In_V_S3, "P_LaneIn_int1_V_S3", TransitionCondition.HaveTramForMe);
        Condition T8_In_V_S3_Ct12 = new Condition(T8_In_V_S3, "P_LaneIn_TramStationProgresului_V_S3", TransitionCondition.CanAddCars);
        T8_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T8_In_V_S3_Ct12);
        GuardMapping grd1T8_In_V_S3 = new GuardMapping();
        grd1T8_In_V_S3.condition = T8_In_V_S3_Ct11;
        grd1T8_In_V_S3.Activations.add(new Activation(T8_In_V_S3, "P_LaneIn_int1_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_TramStationProgresului_V_S3"));
        T8_In_V_S3.GuardMappingList.add(grd1T8_In_V_S3);

        T8_In_V_S3.Delay = 1;
        pn.Transitions.add(T8_In_V_S3);

        //----------------------------END T8_In_V_S3----------------------------------------

        //----------------------------T10_V_S3---------------------------------------- T106

        PetriTransition T10_In_V_S3 = new PetriTransition(pn);
        T10_In_V_S3.TransitionName = "T10_In_V_S3";
        T10_In_V_S3.InputPlaceName.add("P_LaneIn_TramStationProgresului_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T10_In_V_S3_Ct11 = new Condition(T10_In_V_S3, "P_LaneIn_TramStationProgresului_V_S3", TransitionCondition.HaveTram);
        Condition T10_In_V_S3_Ct12 = new Condition(T10_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.CanAddCars);
        T10_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T10_In_V_S3_Ct12);
        GuardMapping grd1T10_In_V_S3 = new GuardMapping();
        grd1T10_In_V_S3.condition = T10_In_V_S3_Ct11;
        grd1T10_In_V_S3.Activations.add(new Activation(T10_In_V_S3, "P_LaneIn_TramStationProgresului_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_TramStationProgresuluiOut_V_S3"));
        T10_In_V_S3.GuardMappingList.add(grd1T10_In_V_S3);

        T10_In_V_S3.Delay = 10;
        pn.Transitions.add(T10_In_V_S3);

        //----------------------------END T10_V_S3----------------------------------------

        //----------------------------T6_In_V_S1---------------------------------------- //T199
        PetriTransition T6_In_V_S3 = new PetriTransition(pn);
        T6_In_V_S3.TransitionName = "T6_In_V_S3";
        T6_In_V_S3.InputPlaceName.add("P_LaneIn_int2_V_S3");
        T6_In_V_S3.InputPlaceName.add("P_LaneIn_BusStationProgresuluiOut_V_S3");
        T6_In_V_S3.InputPlaceName.add("P_LaneIn_TramStationProgresuluiOut_V_S3");

        // --------------guard 8-------------------------------------------------------
        Condition T6_In_V_S3_Ct81 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.HavePriorityCar);
        Condition T6_In_V_S3_Ct82 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.HaveBus);
        Condition T6_In_V_S3_Ct83 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct84 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.HaveTram);
        T6_In_V_S3_Ct83.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct84);
        T6_In_V_S3_Ct82.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct83);
        T6_In_V_S3_Ct81.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct82);
        GuardMapping grd8T6_In_V_S3 = new GuardMapping();
        grd8T6_In_V_S3.condition = T6_In_V_S3_Ct81;
        grd8T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        grd8T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        grd8T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        T6_In_V_S3.GuardMappingList.add(grd8T6_In_V_S3);

        // --------------guard 1-------------------------------------------------------
        Condition T6_In_V_S3_Ct11 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.HaveCar);
        Condition T6_In_V_S3_Ct12 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.DontHaveBus);
        Condition T6_In_V_S3_Ct13 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct14 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.DontHaveTram);
        T6_In_V_S3_Ct13.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct14);
        T6_In_V_S3_Ct12.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct13);
        T6_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct12);
        GuardMapping grd1T6_In_V_S3 = new GuardMapping();
        grd1T6_In_V_S3.condition = T6_In_V_S3_Ct11;
        grd1T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        T6_In_V_S3.GuardMappingList.add(grd1T6_In_V_S3);

        // --------------guard 2-------------------------------------------------------
        Condition T6_In_V_S3_Ct21 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.DontHaveCar);
        Condition T6_In_V_S3_Ct22 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.HaveBus);
        Condition T6_In_V_S3_Ct23 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct24 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.DontHaveTram);
        T6_In_V_S3_Ct23.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct24);
        T6_In_V_S3_Ct22.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct23);
        T6_In_V_S3_Ct21.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct22);
        GuardMapping grd2T6_In_V_S3 = new GuardMapping();
        grd2T6_In_V_S3.condition = T6_In_V_S3_Ct21;
        grd2T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        T6_In_V_S3.GuardMappingList.add(grd2T6_In_V_S3);

        // --------------guard 3-------------------------------------------------------
        Condition T6_In_V_S3_Ct31 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.HaveCar);
        Condition T6_In_V_S3_Ct32 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.HaveBus);
        Condition T6_In_V_S3_Ct33 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct34 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.DontHaveTram);
        T6_In_V_S3_Ct33.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct34);
        T6_In_V_S3_Ct32.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct33);
        T6_In_V_S3_Ct31.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct32);
        GuardMapping grd3T6_In_V_S3 = new GuardMapping();
        grd3T6_In_V_S3.condition = T6_In_V_S3_Ct31;
        grd3T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        grd3T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        T6_In_V_S3.GuardMappingList.add(grd3T6_In_V_S3);

        // --------------guard 5-------------------------------------------------------
        Condition T6_In_V_S3_Ct51 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.HaveCar);
        Condition T6_In_V_S3_Ct52 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.DontHaveBus);
        Condition T6_In_V_S3_Ct53 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct54 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.HaveTram);
        T6_In_V_S3_Ct53.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct54);
        T6_In_V_S3_Ct52.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct53);
        T6_In_V_S3_Ct51.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct52);
        GuardMapping grd5T6_In_V_S3 = new GuardMapping();
        grd5T6_In_V_S3.condition = T6_In_V_S3_Ct51;
        grd5T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        grd5T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        T6_In_V_S3.GuardMappingList.add(grd5T6_In_V_S3);

        // --------------guard 6-------------------------------------------------------
        Condition T6_In_V_S3_Ct61 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.DontHaveCar);
        Condition T6_In_V_S3_Ct62 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.HaveBus);
        Condition T6_In_V_S3_Ct63 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct64 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.HaveTram);
        T6_In_V_S3_Ct63.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct64);
        T6_In_V_S3_Ct62.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct63);
        T6_In_V_S3_Ct61.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct62);
        GuardMapping grd6T6_In_V_S3 = new GuardMapping();
        grd6T6_In_V_S3.condition = T6_In_V_S3_Ct61;
        grd6T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        grd6T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        T6_In_V_S3.GuardMappingList.add(grd6T6_In_V_S3);

        // --------------guard 7-------------------------------------------------------
        Condition T6_In_V_S3_Ct71 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.HaveCar);
        Condition T6_In_V_S3_Ct72 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.HaveBus);
        Condition T6_In_V_S3_Ct73 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct74 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.HaveTram);
        T6_In_V_S3_Ct73.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct74);
        T6_In_V_S3_Ct72.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct73);
        T6_In_V_S3_Ct71.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct72);
        GuardMapping grd7T6_In_V_S3 = new GuardMapping();
        grd7T6_In_V_S3.condition = T6_In_V_S3_Ct71;
        grd7T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        grd7T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        grd7T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S2"));
        T6_In_V_S3.GuardMappingList.add(grd7T6_In_V_S3);

        //--------------guard 9-------------------------------------------------------
        Condition T6_In_V_S3_Ct91 = new Condition(T6_In_V_S3, "P_LaneIn_int2_V_S3", TransitionCondition.DontHaveCar);
        Condition T6_In_V_S3_Ct92 = new Condition(T6_In_V_S3, "P_LaneIn_BusStationProgresuluiOut_V_S3", TransitionCondition.DontHaveBus);
        Condition T6_In_V_S3_Ct93 = new Condition(T6_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.CanAddCars);
        Condition T6_In_V_S3_Ct94 = new Condition(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionCondition.HaveTram);
        T6_In_V_S3_Ct93.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct94);
        T6_In_V_S3_Ct92.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct93);
        T6_In_V_S3_Ct91.SetNextCondition(LogicConnector.AND, T6_In_V_S3_Ct92);
        GuardMapping grd9T6_In_V_S3 = new GuardMapping();
        grd9T6_In_V_S3.condition = T6_In_V_S3_Ct91;
        grd9T6_In_V_S3.Activations.add(new Activation(T6_In_V_S3, "P_LaneIn_TramStationProgresuluiOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S3"));
        T6_In_V_S3.GuardMappingList.add(grd9T6_In_V_S3);

        T6_In_V_S3.Delay = 1;
        pn.Transitions.add(T6_In_V_S3);

        //-------------------------------END T6_In_V_S1-------------------------------------------------

        DataCarQueue P_LaneIn_int3_V_S3 = new DataCarQueue();
        P_LaneIn_int3_V_S3.Value.Size = 3;
        P_LaneIn_int3_V_S3.SetName("P_LaneIn_int3_V_S3");
        pn.PlaceList.add(P_LaneIn_int3_V_S3);

        //----------------------------T12_In_V_S3---------------------------------------- //T127
        PetriTransition T12_In_V_S3 = new PetriTransition(pn);
        T12_In_V_S3.TransitionName = "T12_In_V_S3";
        T12_In_V_S3.InputPlaceName.add("P_LaneIn_int3_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T12_In_V_S3_Ct11 = new Condition(T12_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T12_In_V_S3 = new GuardMapping();
        grd1T12_In_V_S3.condition = T12_In_V_S3_Ct11;
        grd1T12_In_V_S3.Activations.add(new Activation(T12_In_V_S3, "P_LaneIn_int3_V_S3", TransitionOperation.PopElementWithTarget, "P_Lane_BarbatescuVechiOut_V_S3"));
        T12_In_V_S3.GuardMappingList.add(grd1T12_In_V_S3);

        T12_In_V_S3.Delay = 1;
        pn.Transitions.add(T12_In_V_S3);
        //---------------------------- END T12_In_V_S3----------------------------------------

        //----------------------------T14_In_V_S3---------------------------------------- //T200
        PetriTransition T14_In_V_S3 = new PetriTransition(pn);
        T14_In_V_S3.TransitionName = "T14_In_V_S3";
        T14_In_V_S3.InputPlaceName.add("P_LaneIn_int3_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T14_In_V_S3_Ct11 = new Condition(T14_In_V_S3, "P_LaneIn_int3_V_S3", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T14_In_V_S3 = new GuardMapping();
        grd1T14_In_V_S3.condition = T14_In_V_S3_Ct11;
        grd1T14_In_V_S3.Activations.add(new Activation(T14_In_V_S3, "P_LaneIn_int3_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int4_V_S3"));
        T14_In_V_S3.GuardMappingList.add(grd1T14_In_V_S3);

        T14_In_V_S3.Delay = 1;
        pn.Transitions.add(T14_In_V_S3);
        //---------------------------- END T14_In_V_S3----------------------------------------

        DataCarQueue P_LaneIn_int4_V_S3 = new DataCarQueue();
        P_LaneIn_int4_V_S3.Value.Size = 3;
        P_LaneIn_int4_V_S3.SetName("P_LaneIn_int4_V_S3");
        pn.PlaceList.add(P_LaneIn_int4_V_S3);

        DataCar P_Lane_BarbatescuVechiOut_V_S2 = new DataCar();
        P_Lane_BarbatescuVechiOut_V_S2.SetName("P_Lane_BarbatescuVechiOut_V_S3");
        pn.PlaceList.add(P_Lane_BarbatescuVechiOut_V_S2);

        DataCar P_Lane_BarbatescuVechiIn_V_S2 = new DataCar();
        P_Lane_BarbatescuVechiIn_V_S2.SetName("P_Lane_BarbatescuVechiIn_V_S3");
        pn.PlaceList.add(P_Lane_BarbatescuVechiIn_V_S2);

        //----------------------------T16_V_S3---------------------------------------- //T201
        PetriTransition T16_In_V_S3 = new PetriTransition(pn);
        T16_In_V_S3.TransitionName = "T16_In_V_S3";
        T16_In_V_S3.InputPlaceName.add("P_LaneIn_int4_V_S3");
        T16_In_V_S3.InputPlaceName.add("P_Lane_BarbatescuVechiIn_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T16_In_V_S3_Ct11 = new Condition(T16_In_V_S3, "P_LaneIn_int4_V_S3", TransitionCondition.HaveCar);
        Condition T16_In_V_S3_Ct12 = new Condition(T16_In_V_S3, "P_Lane_BarbatescuVechiIn_V_S3", TransitionCondition.IsNull);
        Condition T16_In_V_S3_Ct13 = new Condition(T16_In_V_S3, "P_LaneIn_int5_V_S3", TransitionCondition.CanAddCars);
        T16_In_V_S3_Ct12.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct13);
        T16_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct12);
        GuardMapping grd1T16_In_V_S3 = new GuardMapping();
        grd1T16_In_V_S3.condition = T16_In_V_S3_Ct11;
        grd1T16_In_V_S3.Activations.add(new Activation(T16_In_V_S3, "P_LaneIn_int4_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S3"));
        T16_In_V_S3.GuardMappingList.add(grd1T16_In_V_S3);

        // --------------guard 2-------------------------------------------------------
        Condition T16_In_V_S3_Ct21 = new Condition(T16_In_V_S3, "P_LaneIn_int4_V_S3", TransitionCondition.DontHaveCar);
        Condition T16_In_V_S3_Ct22 = new Condition(T16_In_V_S3, "P_Lane_BarbatescuVechiIn_V_S3", TransitionCondition.NotNull);
        Condition T16_In_V_S3_Ct23 = new Condition(T16_In_V_S3, "P_LaneIn_int5_V_S3", TransitionCondition.CanAddCars);
        T16_In_V_S3_Ct22.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct23);
        T16_In_V_S3_Ct21.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct22);
        GuardMapping grd2T16_In_V_S3 = new GuardMapping();
        grd2T16_In_V_S3.condition = T16_In_V_S3_Ct21;
        grd2T16_In_V_S3.Activations.add(new Activation(T16_In_V_S3, "P_Lane_BarbatescuVechiIn_V_S3", TransitionOperation.AddElement, "P_LaneIn_int5_V_S3"));
        T16_In_V_S3.GuardMappingList.add(grd2T16_In_V_S3);

        // --------------guard 3-------------------------------------------------------
        Condition T16_In_V_S3_Ct31 = new Condition(T16_In_V_S3, "P_LaneIn_int4_V_S3", TransitionCondition.HaveCar);
        Condition T16_In_V_S3_Ct32 = new Condition(T16_In_V_S3, "P_Lane_BarbatescuVechiIn_V_S3", TransitionCondition.IsPriorityCar);
        Condition T16_In_V_S3_Ct33 = new Condition(T16_In_V_S3, "P_LaneIn_int5_V_S3", TransitionCondition.CanAddCars);
        T16_In_V_S3_Ct32.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct33);
        T16_In_V_S3_Ct31.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct32);
        GuardMapping grd3T16_In_V_S3 = new GuardMapping();
        grd3T16_In_V_S3.condition = T16_In_V_S3_Ct31;
        grd3T16_In_V_S3.Activations.add(new Activation(T16_In_V_S3, "P_Lane_BarbatescuVechiIn_V_S3", TransitionOperation.AddElement, "P_LaneIn_int5_V_S3"));
        grd3T16_In_V_S3.Activations.add(new Activation(T16_In_V_S3, "P_LaneIn_int4_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S3"));
        T16_In_V_S3.GuardMappingList.add(grd3T16_In_V_S3);

        // --------------guard 4-------------------------------------------------------
        Condition T16_In_V_S3_Ct41 = new Condition(T16_In_V_S3, "P_LaneIn_int4_V_S3", TransitionCondition.HaveCar);
        Condition T16_In_V_S3_Ct42 = new Condition(T16_In_V_S3, "P_Lane_BarbatescuVechiIn_V_S3", TransitionCondition.NotNull);
        Condition T16_In_V_S3_Ct43 = new Condition(T16_In_V_S3, "P_LaneIn_int5_V_S3", TransitionCondition.CanAddCars);
        T16_In_V_S3_Ct42.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct43);
        T16_In_V_S3_Ct41.SetNextCondition(LogicConnector.AND, T16_In_V_S3_Ct42);
        GuardMapping grd4T16_In_V_S3 = new GuardMapping();
        grd4T16_In_V_S3.condition = T16_In_V_S3_Ct41;
        grd4T16_In_V_S3.Activations.add(new Activation(T16_In_V_S3, "P_LaneIn_int4_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S3"));
        grd4T16_In_V_S3.Activations.add(new Activation(T16_In_V_S3, "P_Lane_BarbatescuVechiIn_V_S3", TransitionOperation.AddElement, "P_LaneIn_int5_V_S3"));
        T16_In_V_S3.GuardMappingList.add(grd4T16_In_V_S3);


        T16_In_V_S3.Delay = 1;
        pn.Transitions.add(T16_In_V_S3);
        //----------------------------END T16_In_V_S2----------------------------------------

        DataCarQueue P_LaneIn_int5_V_S3 = new DataCarQueue();
        P_LaneIn_int5_V_S3.Value.Size = 3;
        P_LaneIn_int5_V_S3.SetName("P_LaneIn_int5_V_S3");
        pn.PlaceList.add(P_LaneIn_int5_V_S3);

        DataCarQueue P_LaneIn_TramStationChirigiu_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationChirigiu_V_S3.Value.Size = 3;
        P_LaneIn_TramStationChirigiu_V_S3.SetName("P_LaneIn_TramStationChirigiu_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationChirigiu_V_S3);

        //----------------------------T18_In_V_S3---------------------------------------- T128

        PetriTransition T18_In_V_S3 = new PetriTransition(pn);
        T18_In_V_S3.TransitionName = "T18_In_V_S3";
        T18_In_V_S3.InputPlaceName.add("P_LaneIn_int5_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T18_In_V_S3_Ct11 = new Condition(T18_In_V_S3, "P_LaneIn_int5_V_S3", TransitionCondition.HaveTramForMe);
        Condition T18_In_V_S3_Ct12 = new Condition(T18_In_V_S3, "P_LaneIn_TramStationChirigiu_V_S3", TransitionCondition.CanAddCars);
        T18_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T18_In_V_S3_Ct12);
        GuardMapping grd1T18_In_V_S3 = new GuardMapping();
        grd1T18_In_V_S3.condition = T18_In_V_S3_Ct11;
        grd1T18_In_V_S3.Activations.add(new Activation(T18_In_V_S3, "P_LaneIn_int5_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_TramStationProgresului_V_S3"));
        T18_In_V_S3.GuardMappingList.add(grd1T18_In_V_S3);

        T18_In_V_S3.Delay = 1;
        pn.Transitions.add(T18_In_V_S3);

        //----------------------------END T18_In_V_S3----------------------------------------

        //----------------------------T20_In_V_S3---------------------------------------- T107

        PetriTransition T20_In_V_S3 = new PetriTransition(pn);
        T20_In_V_S3.TransitionName = "T20_In_V_S3";
        T20_In_V_S3.InputPlaceName.add("P_LaneIn_TramStationChirigiu_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T20_In_V_S3_Ct11 = new Condition(T20_In_V_S3, "P_LaneIn_TramStationChirigiu_V_S3", TransitionCondition.HaveTram);
        Condition T20_In_V_S3_Ct12 = new Condition(T20_In_V_S3, "P_LaneIn_TramStationChirigiuOut_V_S3", TransitionCondition.CanAddCars);
        T20_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T20_In_V_S3_Ct12);
        GuardMapping grd1T20_In_V_S3 = new GuardMapping();
        grd1T20_In_V_S3.condition = T20_In_V_S3_Ct11;
        grd1T20_In_V_S3.Activations.add(new Activation(T20_In_V_S3, "P_LaneIn_TramStationChirigiu_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_TramStationChirigiuOut_V_S3"));
        T20_In_V_S3.GuardMappingList.add(grd1T20_In_V_S3);

        T20_In_V_S3.Delay = 10;
        pn.Transitions.add(T20_In_V_S3);

        //----------------------------END T20_In_V_S3----------------------------------------

        //----------------------------T22_In_V_S3---------------------------------------- //T202
        PetriTransition T22_In_V_S3 = new PetriTransition(pn);
        T22_In_V_S3.TransitionName = "T22_In_V_S3";
        T22_In_V_S3.InputPlaceName.add("P_LaneIn_int5_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T22_In_V_S3_Ct11 = new Condition(T22_In_V_S3, "P_LaneIn_int5_V_S3", TransitionCondition.HaveCarForMe);
        Condition T22_In_V_S3_Ct12 = new Condition(T22_In_V_S3, "P_LaneIn_int6_V_S3", TransitionCondition.CanAddCars);
        T22_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T22_In_V_S3_Ct12);
        GuardMapping grd1T22_In_V_S3 = new GuardMapping();
        grd1T22_In_V_S3.condition = T22_In_V_S3_Ct11;
        grd1T22_In_V_S3.Activations.add(new Activation(T22_In_V_S3, "P_LaneIn_int5_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneIn_int6_V_S3"));
        T22_In_V_S3.GuardMappingList.add(grd1T22_In_V_S3);

        T22_In_V_S3.Delay = 1;
        pn.Transitions.add(T22_In_V_S3);
        //---------------------------- END T22_In_V_S3----------------------------------------

        DataCarQueue P_LaneIn_TramStationChirigiuOut_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationChirigiuOut_V_S3.Value.Size = 3;
        P_LaneIn_TramStationChirigiuOut_V_S3.SetName("P_LaneIn_TramStationChirigiuOut_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationChirigiuOut_V_S3);

        DataCarQueue P_LaneIn_int6_V_S3 = new DataCarQueue();
        P_LaneIn_int6_V_S3.Value.Size = 3;
        P_LaneIn_int6_V_S3.SetName("P_LaneIn_int6_V_S3");
        pn.PlaceList.add(P_LaneIn_int6_V_S3);

        //----------------------------T24_V_S3---------------------------------------- T203
        PetriTransition T24_In_V_S3 = new PetriTransition(pn);
        T24_In_V_S3.TransitionName = "T24_In_V_S3";
        T24_In_V_S3.InputPlaceName.add("P_LaneIn_int6_V_S3");
        T24_In_V_S3.InputPlaceName.add("P_LaneIn_TramStationChirigiuOut_V_S3");

        //----------------------guard 3-------------------------------------------------
        Condition T24_In_V_S3_Ct31 = new Condition(T24_In_V_S3, "P_LaneIn_TramStationChirigiuOut_V_S3", TransitionCondition.HaveTram);
        Condition T24_In_V_S3_Ct32 = new Condition(T24_In_V_S3, "P_LaneIn_int6_V_S3", TransitionCondition.HaveCar);
        Condition T24_In_V_S3_Ct33 = new Condition(T24_In_V_S3, "P_LaneIn_int7_V_S3", TransitionCondition.CanAddCars);
        T24_In_V_S3_Ct32.SetNextCondition(LogicConnector.AND, T24_In_V_S3_Ct33);
        T24_In_V_S3_Ct31.SetNextCondition(LogicConnector.AND, T24_In_V_S3_Ct32);
        GuardMapping grd3T24_In_V_S3 = new GuardMapping();
        grd3T24_In_V_S3.condition = T24_In_V_S3_Ct31;
        grd3T24_In_V_S3.Activations.add(new Activation(T24_In_V_S3, "P_LaneIn_int6_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int7_V_S3"));
        grd3T24_In_V_S3.Activations.add(new Activation(T24_In_V_S3, "P_LaneIn_TramStationChirigiuOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int7_V_S3"));
        T24_In_V_S3.GuardMappingList.add(grd3T24_In_V_S3);

        // --------------guard 1-------------------------------------------------------OK
        Condition T24_In_V_S3_Ct11 = new Condition(T24_In_V_S3, "P_LaneIn_int6_V_S3", TransitionCondition.HaveCar);
        Condition T24_In_V_S3_Ct12 = new Condition(T24_In_V_S3, "P_LaneIn_int7_V_S3", TransitionCondition.CanAddCars);
        T24_In_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T24_In_V_S3_Ct12);
        GuardMapping grd1T24_In_V_S3 = new GuardMapping();
        grd1T24_In_V_S3.condition = T24_In_V_S3_Ct11;
        grd1T24_In_V_S3.Activations.add(new Activation(T24_In_V_S3, "P_LaneIn_int6_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int7_V_S3"));
        T24_In_V_S3.GuardMappingList.add(grd1T24_In_V_S3);
        //-----------------------guard 2--------------------------------------------
        Condition T24_In_V_S3_Ct21 = new Condition(T24_In_V_S3, "P_LaneIn_TramStationChirigiuOut_V_S3", TransitionCondition.HaveTram);
        Condition T24_In_V_S3_Ct22 = new Condition(T24_In_V_S3, "P_LaneIn_int7_V_S3", TransitionCondition.CanAddCars);
        T24_In_V_S3_Ct21.SetNextCondition(LogicConnector.AND, T24_In_V_S3_Ct22);
        GuardMapping grd2T24_In_V_S3 = new GuardMapping();
        grd2T24_In_V_S3.condition = T24_In_V_S3_Ct21;
        grd2T24_In_V_S3.Activations.add(new Activation(T24_In_V_S3, "P_LaneIn_TramStationChirigiuOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int7_V_S3"));
        T24_In_V_S3.GuardMappingList.add(grd2T24_In_V_S3);

        T24_In_V_S3.Delay = 1;
        pn.Transitions.add(T24_In_V_S3);

        //----------------------------END T24_In_V_S3----------------------------------------

        DataCarQueue P_LaneIn_int7_V_S3 = new DataCarQueue();
        P_LaneIn_int7_V_S3.Value.Size = 3;
        P_LaneIn_int7_V_S3.SetName("P_LaneIn_int7_V_S3");
        pn.PlaceList.add(P_LaneIn_int7_V_S3);

        //-------------------OUT--------------------------
        DataCarQueue P_LaneOut_Int1_V_S3 = new DataCarQueue();
        P_LaneOut_Int1_V_S3.SetName("P_LaneOut_Int1_V_S3");
        P_LaneOut_Int1_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int1_V_S3);

        DataCar P_LaneDinca_V_In_S3 = new DataCar();
        P_LaneDinca_V_In_S3.SetName("P_LaneDinca_V_In_S3");
        pn.PlaceList.add(P_LaneDinca_V_In_S3);

        DataCarQueue P_LaneOut_Int2_V_S3 = new DataCarQueue();
        P_LaneOut_Int2_V_S3.SetName("P_LaneOut_Int2_V_S3");
        P_LaneOut_Int2_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int2_V_S3);

        //----------------------------T1_Out_V_S3---------------------------------------- //T201
        PetriTransition T1_Out_V_S3 = new PetriTransition(pn);
        T1_Out_V_S3.TransitionName = "T1_Out_V_S3";
        T1_Out_V_S3.InputPlaceName.add("P_LaneOut_Int2_V_S3");
        T1_Out_V_S3.InputPlaceName.add("P_LaneDinca_V_In_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T1_Out_V_S3_Ct11 = new Condition(T1_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionCondition.HaveCar);
        Condition T1_Out_V_S3_Ct12 = new Condition(T1_Out_V_S3, "P_LaneDinca_V_In_S3", TransitionCondition.IsNull);
        Condition T1_Out_V_S3_Ct13 = new Condition(T1_Out_V_S3, "P_LaneOut_Int1_V_S3", TransitionCondition.CanAddCars);
        T1_Out_V_S3_Ct12.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct13);
        T1_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct12);
        GuardMapping grd1T1_Out_V_S3 = new GuardMapping();
        grd1T1_Out_V_S3.condition = T1_Out_V_S3_Ct11;
        grd1T1_Out_V_S3.Activations.add(new Activation(T1_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S3"));
        T1_Out_V_S3.GuardMappingList.add(grd1T1_Out_V_S3);

        // --------------guard 2-------------------------------------------------------
        Condition T1_Out_V_S3_Ct21 = new Condition(T1_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionCondition.DontHaveCar);
        Condition T1_Out_V_S3_Ct22 = new Condition(T1_Out_V_S3, "P_LaneDinca_V_In_S3", TransitionCondition.NotNull);
        Condition T1_Out_V_S3_Ct23 = new Condition(T1_Out_V_S3, "P_LaneOut_Int1_V_S3", TransitionCondition.CanAddCars);
        T1_Out_V_S3_Ct22.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct23);
        T1_Out_V_S3_Ct21.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct22);
        GuardMapping grd2T1_Out_V_S3 = new GuardMapping();
        grd2T1_Out_V_S3.condition = T1_Out_V_S3_Ct21;
        grd2T1_Out_V_S3.Activations.add(new Activation(T1_Out_V_S3, "P_LaneDinca_V_In_S3", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S3"));
        T1_Out_V_S3.GuardMappingList.add(grd2T1_Out_V_S3);

        // --------------guard 3-------------------------------------------------------
        Condition T1_Out_V_S3_Ct31 = new Condition(T1_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionCondition.HaveCar);
        Condition T1_Out_V_S3_Ct32 = new Condition(T1_Out_V_S3, "P_LaneDinca_V_In_S3", TransitionCondition.IsPriorityCar);
        Condition T1_Out_V_S3_Ct33 = new Condition(T1_Out_V_S3, "P_LaneOut_Int1_V_S3", TransitionCondition.CanAddCars);
        T1_Out_V_S3_Ct32.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct33);
        T1_Out_V_S3_Ct31.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct32);
        GuardMapping grd3T1_Out_V_S3 = new GuardMapping();
        grd3T1_Out_V_S3.condition = T1_Out_V_S3_Ct31;
        grd3T1_Out_V_S3.Activations.add(new Activation(T1_Out_V_S3, "P_LaneDinca_V_In_S3", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S3"));
        grd3T1_Out_V_S3.Activations.add(new Activation(T1_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S3"));
        T1_Out_V_S3.GuardMappingList.add(grd3T1_Out_V_S3);

        // --------------guard 4-------------------------------------------------------
        Condition T1_Out_V_S3_Ct41 = new Condition(T1_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionCondition.HaveCar);
        Condition T1_Out_V_S3_Ct42 = new Condition(T1_Out_V_S3, "P_LaneDinca_V_In_S3", TransitionCondition.NotNull);
        Condition T1_Out_V_S3_Ct43 = new Condition(T1_Out_V_S3, "P_LaneOut_Int1_V_S3", TransitionCondition.CanAddCars);
        T1_Out_V_S3_Ct42.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct43);
        T1_Out_V_S3_Ct41.SetNextCondition(LogicConnector.AND, T1_Out_V_S3_Ct42);
        GuardMapping grd4T1_Out_V_S3 = new GuardMapping();
        grd4T1_Out_V_S3.condition = T1_Out_V_S3_Ct41;
        grd4T1_Out_V_S3.Activations.add(new Activation(T1_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int1_V_S3"));
        grd4T1_Out_V_S3.Activations.add(new Activation(T1_Out_V_S3, "P_LaneDinca_V_In_S3", TransitionOperation.AddElement, "P_LaneOut_Int1_V_S3"));
        T1_Out_V_S3.GuardMappingList.add(grd4T1_Out_V_S3);


        T1_Out_V_S3.Delay = 1;
        pn.Transitions.add(T1_Out_V_S3);
        //----------------------------END T1_V_S3----------------------------------------

        DataCar P_LaneDinca_V_Out_S3 = new DataCar();
        P_LaneDinca_V_Out_S3.SetName("P_LaneDinca_V_Out_S3");
        pn.PlaceList.add(P_LaneDinca_V_Out_S3);

        DataCarQueue P_LaneOut_Int3_V_S3 = new DataCarQueue();
        P_LaneOut_Int3_V_S3.SetName("P_LaneOut_Int3_V_S3");
        P_LaneOut_Int3_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int3_V_S3);

        //----------------------------T3_Out_V_S3----------------------------------------

        PetriTransition T3_Out_V_S3 = new PetriTransition(pn);
        T3_Out_V_S3.TransitionName = "T3_Out_V_S3";
        T3_Out_V_S3.InputPlaceName.add("P_LaneOut_Int3_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T3_Out_V_S3_Ct11 = new Condition(T3_Out_V_S3, "P_LaneOut_Int3_V_S3", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T3_Out_V_S3 = new GuardMapping();
        grd1T3_Out_V_S3.condition= T3_Out_V_S3_Ct11;
        grd1T3_Out_V_S3.Activations.add(new Activation(T3_Out_V_S3, "P_LaneOut_Int3_V_S3", TransitionOperation.PopElementWithTarget, "P_LaneDinca_V_Out_S3"));
        T3_Out_V_S3.GuardMappingList.add(grd1T3_Out_V_S3);
        T3_Out_V_S3.Delay = 1;
        pn.Transitions.add(T3_Out_V_S3);

        //----------------------------END T3_Out_V_S3----------------------------------------

        //----------------------------T5_Out_V_S3---------------------------------------

        PetriTransition T5_Out_V_S3 = new PetriTransition(pn);
        T5_Out_V_S3.TransitionName = "T5_Out_V_S3";
        T5_Out_V_S3.InputPlaceName.add("P_LaneOut_Int3_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T5_Out_V_S3_Ct11 = new Condition(T5_Out_V_S3, "P_LaneOut_Int3_V_S3", TransitionCondition.HaveCarForMe);
        Condition T5_Out_V_S3_Ct12= new Condition(T5_Out_V_S3, "P_LaneOut_Int2_V_S3", TransitionCondition.CanAddCars);
        GuardMapping grd1T5_Out_V_S3 = new GuardMapping();
        T5_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T5_Out_V_S3_Ct12);
        grd1T5_Out_V_S3.condition= T5_Out_V_S3_Ct11;
        grd1T5_Out_V_S3.Activations.add(new Activation(T5_Out_V_S3, "P_LaneOut_Int3_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int2_V_S3"));
        T5_Out_V_S3.GuardMappingList.add(grd1T5_Out_V_S3);
        T5_Out_V_S3.Delay = 1;
        pn.Transitions.add(T5_Out_V_S3);

        //----------------------------END T5_Out_V_S3----------------------------------------

        DataCar P_LaneRaditei_V_Out_S3 = new DataCar();
        P_LaneRaditei_V_Out_S3.SetName("P_LaneRaditei_V_Out_S3");
        pn.PlaceList.add(P_LaneRaditei_V_Out_S3);

        DataCarQueue P_LaneOut_Int4_V_S3 = new DataCarQueue();
        P_LaneOut_Int4_V_S3.SetName("P_LaneOut_Int4_V_S3");
        P_LaneOut_Int4_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int4_V_S3);

        //----------------------------T7_Out_V_S3----------------------------------------

        PetriTransition T7_Out_V_S3 = new PetriTransition(pn);
        T7_Out_V_S3.TransitionName = "T7_Out_V_S3";
        T7_Out_V_S3.InputPlaceName.add("P_LaneOut_Int4_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T7_Out_V_S3_Ct11 = new Condition(T7_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T7_Out_V_S3 = new GuardMapping();
        grd1T7_Out_V_S3.condition= T7_Out_V_S3_Ct11;
        grd1T7_Out_V_S3.Activations.add(new Activation(T7_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionOperation.PopElementWithTarget, "P_LaneRaditei_V_Out_S3"));
        T7_Out_V_S3.GuardMappingList.add(grd1T7_Out_V_S3);
        T7_Out_V_S3.Delay = 1;
        pn.Transitions.add(T7_Out_V_S3);

        //----------------------------END T7_Out_V_S3----------------------------------------

        //----------------------------T9_Out_V_S3---------------------------------------

        PetriTransition T9_Out_V_S3 = new PetriTransition(pn);
        T9_Out_V_S3.TransitionName = "T9_Out_V_S3";
        T9_Out_V_S3.InputPlaceName.add("P_LaneOut_Int4_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T9_Out_V_S3_Ct11 = new Condition(T9_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionCondition.HaveCarForMe);
        Condition T9_Out_V_S3_Ct12= new Condition(T9_Out_V_S3, "P_LaneOut_Int3_V_S3", TransitionCondition.CanAddCars);
        GuardMapping grd1T9_Out_V_S3 = new GuardMapping();
        T9_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T9_Out_V_S3_Ct12);
        grd1T9_Out_V_S3.condition= T9_Out_V_S3_Ct11;
        grd1T9_Out_V_S3.Activations.add(new Activation(T9_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int3_V_S3"));
        T9_Out_V_S3.GuardMappingList.add(grd1T9_Out_V_S3);
        T9_Out_V_S3.Delay = 1;
        pn.Transitions.add(T9_Out_V_S3);

        //----------------------------END T9_Out_V_S3----------------------------------------

        DataCarQueue P_LaneOut_Int5_V_S3 = new DataCarQueue();
        P_LaneOut_Int5_V_S3.SetName("P_LaneOut_Int5_V_S3");
        P_LaneOut_Int5_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int5_V_S3);

        DataCarQueue P_BusStation_Chirigiu_V_Out_S3 = new DataCarQueue();
        P_BusStation_Chirigiu_V_Out_S3.SetName("P_BusStation_Chirigiu_V_Out_S3");
        P_BusStation_Chirigiu_V_Out_S3.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Chirigiu_V_Out_S3);

        //----------------------------T11_Out_V_S3----------------------------------------

        PetriTransition T11_Out_V_S3 = new PetriTransition(pn);
        T11_Out_V_S3.TransitionName = "T11_Out_V_S3";
        T11_Out_V_S3.InputPlaceName.add("P_LaneOut_Int5_V_S3");
        T11_Out_V_S3.InputPlaceName.add("P_BusStation_Chirigiu_V_Out_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T11_Out_V_S3_Ct11 = new Condition(T11_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionCondition.HaveCar);
        Condition T11_Out_V_S3_Ct12 = new Condition(T11_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionCondition.DontHaveBus);
        Condition T11_Out_V_S3_Ct13 = new Condition(T11_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionCondition.CanAddCars);
        T11_Out_V_S3_Ct12.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct13);
        T11_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct12);
        GuardMapping grd1T11_Out_V_S3 = new GuardMapping();
        grd1T11_Out_V_S3.condition = T11_Out_V_S3_Ct11;
        grd1T11_Out_V_S3.Activations.add(new Activation(T11_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S3"));
        T11_Out_V_S3.GuardMappingList.add(grd1T11_Out_V_S3);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T11_Out_V_S3_Ct21 = new Condition(T11_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionCondition.DontHaveCar);
        Condition T11_Out_V_S3_Ct22 = new Condition(T11_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionCondition.HaveBus);
        Condition T11_Out_V_S3_Ct23 = new Condition(T11_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionCondition.CanAddCars);
        T11_Out_V_S3_Ct22.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct23);
        T11_Out_V_S3_Ct21.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct22);
        GuardMapping grd2T11_Out_V_S3 = new GuardMapping();
        grd2T11_Out_V_S3.condition = T11_Out_V_S3_Ct21;
        grd2T11_Out_V_S3.Activations.add(new Activation(T11_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S3"));
        T11_Out_V_S3.GuardMappingList.add(grd2T11_Out_V_S3);

        // --------------guard 3-------------------------------------------------------
        Condition T11_Out_V_S3_Ct31 = new Condition(T11_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionCondition.HavePriorityCar);
        Condition T11_Out_V_S3_Ct32 = new Condition(T11_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionCondition.HaveBus);
        Condition T11_Out_V_S3_Ct33 = new Condition(T11_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionCondition.CanAddCars);
        T11_Out_V_S3_Ct32.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct33);
        T11_Out_V_S3_Ct31.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct32);
        GuardMapping grd3T11_Out_V_S3 = new GuardMapping();
        grd3T11_Out_V_S3.condition = T11_Out_V_S3_Ct31;
        grd3T11_Out_V_S3.Activations.add(new Activation(T11_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S3"));
        grd3T11_Out_V_S3.Activations.add(new Activation(T11_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S3"));
        T11_Out_V_S3.GuardMappingList.add(grd3T11_Out_V_S3);


        // --------------guard 4-------------------------------------------------------
        Condition T11_Out_V_S3_Ct41 = new Condition(T11_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionCondition.HaveCar);
        Condition T11_Out_V_S3_Ct42 = new Condition(T11_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionCondition.HaveBus);
        Condition T11_Out_V_S3_Ct43 = new Condition(T11_Out_V_S3, "P_LaneOut_Int4_V_S3", TransitionCondition.CanAddCars);
        T11_Out_V_S3_Ct42.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct43);
        T11_Out_V_S3_Ct41.SetNextCondition(LogicConnector.AND, T11_Out_V_S3_Ct42);
        GuardMapping grd4T11_Out_V_S3 = new GuardMapping();
        grd4T11_Out_V_S3.condition = T11_Out_V_S3_Ct41;
        grd4T11_Out_V_S3.Activations.add(new Activation(T11_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S3"));
        grd4T11_Out_V_S3.Activations.add(new Activation(T11_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S3"));
        T11_Out_V_S3.GuardMappingList.add(grd4T11_Out_V_S3);

        T11_Out_V_S3.Delay = 1;
        pn.Transitions.add(T11_Out_V_S3);

        //----------------------------END T11_Out_V_S3----------------------------------------

        DataCarQueue P_BusStation_Chirigiu_V_S3 = new DataCarQueue();
        P_BusStation_Chirigiu_V_S3.SetName("P_BusStation_Chirigiu_V_S3");
        P_BusStation_Chirigiu_V_S3.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Chirigiu_V_S3);

        DataCarQueue P_LaneOut_Int6_V_S3 = new DataCarQueue();
        P_LaneOut_Int6_V_S3.Value.Size = 3;
        P_LaneOut_Int6_V_S3.SetName("P_LaneOut_Int6_V_S3");
        pn.PlaceList.add(P_LaneOut_Int6_V_S3);

        //----------------------------T13_Out_V_S3----------------------------------------

        PetriTransition T13_Out_V_S3 = new PetriTransition(pn);
        T13_Out_V_S3.TransitionName = "T13_Out_V_S3";
        T13_Out_V_S3.InputPlaceName.add("P_LaneOut_Int6_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T13_Out_V_S3_Ct11 = new Condition(T13_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionCondition.HaveBusForMe);
        Condition T13_Out_V_S3_Ct12 = new Condition(T13_Out_V_S3, "P_BusStation_Chirigiu_V_S3", TransitionCondition.CanAddCars);
        T13_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T13_Out_V_S3_Ct12);
        GuardMapping grd1T13_Out_V_S3 = new GuardMapping();
        grd1T13_Out_V_S3.condition= T13_Out_V_S3_Ct11;
        grd1T13_Out_V_S3.Activations.add(new Activation(T13_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_BusStation_Chirigiu_V_S3"));
        T13_Out_V_S3.GuardMappingList.add(grd1T13_Out_V_S3);
        T13_Out_V_S3.Delay = 1;
        pn.Transitions.add(T13_Out_V_S3);

        //----------------------------END T13_Out_V_S3----------------------------------------

        //----------------------------T15_Out_V_S3----------------------------------------

        PetriTransition T15_Out_V_S3 = new PetriTransition(pn);
        T15_Out_V_S3.TransitionName = "T15_Out_V_S3";
        T15_Out_V_S3.InputPlaceName.add("P_LaneOut_Int6_V_S3");

        // --------------guard 1-------------------------------------------------------
        Condition T15_Out_V_S3_Ct11 = new Condition(T15_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionCondition.HaveCarForMe);
        Condition T15_Out_V_S3_Ct12 = new Condition(T15_Out_V_S3, "P_LaneOut_Int5_V_S3", TransitionCondition.CanAddCars);
        GuardMapping grd1T15_Out_V_S3 = new GuardMapping();
        T15_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T15_Out_V_S3_Ct12);
        grd1T15_Out_V_S3.condition= T15_Out_V_S3_Ct11;
        grd1T15_Out_V_S3.Activations.add(new Activation(T15_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int5_V_S3"));
        T15_Out_V_S3.GuardMappingList.add(grd1T15_Out_V_S3);
        T15_Out_V_S3.Delay = 1;
        pn.Transitions.add(T15_Out_V_S3);

        //----------------------------END T15_Out_V_S3----------------------------------------

        DataCarQueue P_LaneOut_Int7_V_S3 = new DataCarQueue();
        P_LaneOut_Int7_V_S3.SetName("P_LaneOut_Int7_V_S3");
        P_LaneOut_Int7_V_S3.Value.Size = 2;
        pn.PlaceList.add(P_LaneOut_Int7_V_S3);

        DataCarQueue P_LaneOut_Int8_V_S3 = new DataCarQueue();
        P_LaneOut_Int8_V_S3.SetName("P_LaneOut_Int8_V_S3");
        P_LaneOut_Int8_V_S3.Value.Size = 1;
        pn.PlaceList.add(P_LaneOut_Int8_V_S3);

        //----------------------------T17_OutV_S3---------------------------------------- //t211

        PetriTransition T17_Out_V_S3 = new PetriTransition(pn);
        T17_Out_V_S3.TransitionName = "T17_Out_V_S3";
        T17_Out_V_S3.InputPlaceName.add("P_LaneOut_Int7_V_S3");
        T17_Out_V_S3.InputPlaceName.add("P_LaneOut_TramStationChirigiuOut_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T17_Out_V_S3_Ct11 = new Condition(T17_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionCondition.HaveCar);
        Condition T17_Out_V_S3_Ct12 = new Condition(T17_Out_V_S3, "P_LaneOut_TramStationChirigiuOut_V_S3", TransitionCondition.DontHaveTram);
        Condition T17_Out_V_S3_Ct13 = new Condition(T17_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionCondition.CanAddCars);
        T17_Out_V_S3_Ct12.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct13);
        T17_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct12);
        GuardMapping grd1T17_Out_V_S3 = new GuardMapping();
        grd1T17_Out_V_S3.condition = T17_Out_V_S3_Ct11;
        grd1T17_Out_V_S3.Activations.add(new Activation(T17_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S3"));
        T17_Out_V_S3.GuardMappingList.add(grd1T17_Out_V_S3);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T17_Out_V_S3_Ct21 = new Condition(T17_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionCondition.DontHaveCar);
        Condition T17_Out_V_S3_Ct22 = new Condition(T17_Out_V_S3, "P_LaneOut_TramStationChirigiuOut_V_S3", TransitionCondition.HaveTram);
        Condition T17_Out_V_S3_Ct23 = new Condition(T17_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionCondition.CanAddCars);
        T17_Out_V_S3_Ct22.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct23);
        T17_Out_V_S3_Ct21.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct22);
        GuardMapping grd2T17_Out_V_S3 = new GuardMapping();
        grd2T17_Out_V_S3.condition = T17_Out_V_S3_Ct21;
        grd2T17_Out_V_S3.Activations.add(new Activation(T17_Out_V_S3, "P_LaneOut_TramStationChirigiuOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S3"));
        T17_Out_V_S3.GuardMappingList.add(grd2T17_Out_V_S3);

        // --------------guard 3-------------------------------------------------------
        Condition T17_Out_V_S3_Ct31 = new Condition(T17_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionCondition.HavePriorityCar);
        Condition T17_Out_V_S3_Ct32 = new Condition(T17_Out_V_S3, "P_LaneOut_TramStationChirigiuOut_V_S3", TransitionCondition.HaveTram);
        Condition T17_Out_V_S3_Ct33 = new Condition(T17_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionCondition.CanAddCars);
        T17_Out_V_S3_Ct32.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct33);
        T17_Out_V_S3_Ct31.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct32);
        GuardMapping grd3T17_Out_V_S3 = new GuardMapping();
        grd3T17_Out_V_S3.condition = T17_Out_V_S3_Ct31;
        grd3T17_Out_V_S3.Activations.add(new Activation(T17_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S3"));
        grd3T11_Out_V_S3.Activations.add(new Activation(T17_Out_V_S3, "P_LaneOut_TramStationChirigiuOut_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S3"));
        T17_Out_V_S3.GuardMappingList.add(grd3T17_Out_V_S3);


        // --------------guard 4-------------------------------------------------------
        Condition T17_Out_V_S3_Ct41 = new Condition(T17_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionCondition.HaveCar);
        Condition T17_Out_V_S3_Ct42 = new Condition(T17_Out_V_S3, "P_LaneOut_TramStationChirigiuOut_V_S3", TransitionCondition.HaveTram);
        Condition T17_Out_V_S3_Ct43 = new Condition(T17_Out_V_S3, "P_LaneOut_Int6_V_S3", TransitionCondition.CanAddCars);
        T17_Out_V_S3_Ct42.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct43);
        T17_Out_V_S3_Ct41.SetNextCondition(LogicConnector.AND, T17_Out_V_S3_Ct42);
        GuardMapping grd4T17_Out_V_S3 = new GuardMapping();
        grd4T17_Out_V_S3.condition = T17_Out_V_S3_Ct41;
        grd4T17_Out_V_S3.Activations.add(new Activation(T17_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S3"));
        grd4T17_Out_V_S3.Activations.add(new Activation(T17_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int6_V_S3"));
        T17_Out_V_S3.GuardMappingList.add(grd4T17_Out_V_S3);

        T17_Out_V_S3.Delay = 1;
        pn.Transitions.add(T17_Out_V_S3);

        //----------------------------END T17_Out_V_S3----------------------------------------


        //----------------------------T19_Out_V_S3---------------------------------------- T129

        PetriTransition T19_Out_V_S3 = new PetriTransition(pn);
        T19_Out_V_S3.TransitionName = "T19_Out_V_S3";
        T19_Out_V_S3.InputPlaceName.add("P_LaneOut_Int8_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T19_Out_V_S3_Ct11 = new Condition(T19_Out_V_S3, "P_LaneOut_Int8_V_S3", TransitionCondition.HaveCarForMe);
        Condition T19_Out_V_S3_Ct12 = new Condition(T19_Out_V_S3, "P_LaneOut_Int7_V_S3", TransitionCondition.CanAddCars);
        T19_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T19_Out_V_S3_Ct12);
        GuardMapping grd1T19_Out_V_S3 = new GuardMapping();
        grd1T19_Out_V_S3.condition = T19_Out_V_S3_Ct11;
        grd1T19_Out_V_S3.Activations.add(new Activation(T19_Out_V_S3, "P_LaneOut_Int8_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int7_V_S3"));
        T19_Out_V_S3.GuardMappingList.add(grd1T19_Out_V_S3);

        T19_Out_V_S3.Delay = 1;
        pn.Transitions.add(T19_Out_V_S3);

        //----------------------------END T19_Out_V_S3----------------------------------------

        //----------------------------T21_Out_V_S3---------------------------------------- T129

        PetriTransition T21_Out_V_S3 = new PetriTransition(pn);
        T21_Out_V_S3.TransitionName = "T21_Out_V_S3";
        T21_Out_V_S3.InputPlaceName.add("P_LaneOut_Int8_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T21_Out_V_S3_Ct11 = new Condition(T21_Out_V_S3, "P_LaneOut_Int8_V_S3", TransitionCondition.HaveTramForMe);
        Condition T21_Out_V_S3_Ct12 = new Condition(T21_Out_V_S3, "P_LaneOut_TramStationChirigiu_V_S3", TransitionCondition.CanAddCars);
        T21_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T21_Out_V_S3_Ct12);
        GuardMapping grd1T21_Out_V_S3 = new GuardMapping();
        grd1T21_Out_V_S3.condition = T21_Out_V_S3_Ct11;
        grd1T21_Out_V_S3.Activations.add(new Activation(T21_Out_V_S3, "P_LaneOut_Int8_V_S3", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_TramStationChirigiu_V_S3"));
        T21_Out_V_S3.GuardMappingList.add(grd1T21_Out_V_S3);

        T21_Out_V_S3.Delay = 1;
        pn.Transitions.add(T21_Out_V_S3);

        //----------------------------END T21_Out_V_S3----------------------------------------


        DataCarQueue P_LaneOut_TramStationChirigiu_V_S3 = new DataCarQueue();
        P_LaneOut_TramStationChirigiu_V_S3.SetName("P_LaneOut_TramStationChirigiu_V_S3");
        P_LaneOut_TramStationChirigiu_V_S3.Value.Size = 1;
        pn.PlaceList.add(P_LaneOut_TramStationChirigiu_V_S3);

        //----------------------------T23_Out_V_S3---------------------------------------- T104

        PetriTransition T23_Out_V_S3 = new PetriTransition(pn);
        T23_Out_V_S3.TransitionName = "T23_Out_V_S3";
        T23_Out_V_S3.InputPlaceName.add("P_LaneOut_TramStationChirigiu_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T23_Out_V_S3_Ct11 = new Condition(T23_Out_V_S3, "P_LaneOut_TramStationChirigiu_V_S3", TransitionCondition.HaveTram);
        Condition T23_Out_V_S3_Ct12 = new Condition(T23_Out_V_S3, "P_LaneOut_TramStationChirigiuOut_V_S3", TransitionCondition.CanAddCars);
        T23_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T23_Out_V_S3_Ct12);
        GuardMapping grd1T23_Out_V_S3 = new GuardMapping();
        grd1T23_Out_V_S3.condition = T23_Out_V_S3_Ct11;
        grd1T23_Out_V_S3.Activations.add(new Activation(T23_Out_V_S3, "P_LaneIn_TramStationChirigiu_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_TramStationChirigiuOut_V_S3"));
        T23_Out_V_S3.GuardMappingList.add(grd1T23_Out_V_S3);

        T23_Out_V_S3.Delay = 10;
        pn.Transitions.add(T23_Out_V_S3);

        //----------------------------END T23_V_S3----------------------------------------

        //----------------------------T25_Out_V_S3---------------------------------------- T104

        PetriTransition T25_Out_V_S3 = new PetriTransition(pn);
        T25_Out_V_S3.TransitionName = "T25_Out_V_S3";
        T25_Out_V_S3.InputPlaceName.add("P_BusStation_Chirigiu_V_S3");

        // --------------guard 1-------------------------------------------------------OK
        Condition T25_Out_V_S3_Ct11 = new Condition(T25_Out_V_S3, "P_BusStation_Chirigiu_V_S3", TransitionCondition.HaveTram);
        Condition T25_Out_V_S3_Ct12 = new Condition(T25_Out_V_S3, "P_BusStation_Chirigiu_V_Out_S3", TransitionCondition.CanAddCars);
        T25_Out_V_S3_Ct11.SetNextCondition(LogicConnector.AND, T25_Out_V_S3_Ct12);
        GuardMapping grd1T25_Out_V_S3 = new GuardMapping();
        grd1T25_Out_V_S3.condition = T25_Out_V_S3_Ct11;
        grd1T25_Out_V_S3.Activations.add(new Activation(T25_Out_V_S3, "P_BusStation_Chirigiu_V_S3", TransitionOperation.PopElementWithoutTargetToQueue, "P_BusStation_Chirigiu_V_Out_S3"));
        T25_Out_V_S3.GuardMappingList.add(grd1T25_Out_V_S3);

        T25_Out_V_S3.Delay = 10;
        pn.Transitions.add(T25_Out_V_S3);

        //----------------------------END T25_V_S3----------------------------------------


        DataCarQueue P_LaneOut_TramStationChirigiuOut_V_S3 = new DataCarQueue();
        P_LaneOut_TramStationChirigiuOut_V_S3.SetName("P_LaneOut_TramStationChirigiuOut_V_S3");
        P_LaneOut_TramStationChirigiuOut_V_S3.Value.Size = 1;
        pn.PlaceList.add(P_LaneOut_TramStationChirigiuOut_V_S3);

        // -------------------------------------------------------------------
        // ----------------END CALEA FERENTARI SECTION 3----------------------
        // -------------------------------------------------------------------


        System.out.println("Lanes_Intersection_Bucharest started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

        //test commit
    }
}
