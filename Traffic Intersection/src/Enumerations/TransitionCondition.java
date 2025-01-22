package Enumerations;

import java.io.Serializable;

public enum TransitionCondition implements Serializable{
	Undefined,
	Equal,
	NotEqual,
	MoreThan,
	MoreThanOrEqual,
	LessThan,
	LessThanOrEqual,
	Contains,
	NotContains,
	IsNull,
	NotNull,
	HaveCarForMe,
	HaveBusForMe,
	HaveTramForMe,
	HavePriorityCarForMe,
	CanAddCars,
	CanNotAddCars,
	HaveCar,
	DontHaveCar,
	DontHaveBus,
	DontHaveTram,
	HaveREL,
	SubPetriStopped,

	Equal_FloatFloat,            //the transition conditions for floatfloat
	MoreThan_FloatFloat,         //the transition conditions for floatfloat
	MoreThanOrEqual_FloatFloat,  //the transition conditions for floatfloat
	LessThan_FloatFloat,         //the transition conditions for floatfloat
	LessThanOrEqual_FloatFloat,  //the transition conditions for floatfloat
	FLRS,
	//added
	IsTaxi,
	IsBus,
	IsPriorityCar,
	IsTram,
	HavePriorityCar,
	HaveBus,
	HaveTaxi,
	HaveTram

}
