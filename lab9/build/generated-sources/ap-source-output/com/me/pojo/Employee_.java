package com.me.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ extends com.me.pojo.User_ {

	public static volatile SetAttribute<Employee, Leave> leaves;
	public static volatile SetAttribute<Employee, Task> tasks;
	public static volatile SingularAttribute<Employee, TeamLeader> teamleader;

	public static final String LEAVES = "leaves";
	public static final String TASKS = "tasks";
	public static final String TEAMLEADER = "teamleader";

}

