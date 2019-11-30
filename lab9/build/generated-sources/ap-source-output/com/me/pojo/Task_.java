package com.me.pojo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ {

	public static volatile SingularAttribute<Task, Date> enddate;
	public static volatile SingularAttribute<Task, Date> actual_startdate;
	public static volatile SingularAttribute<Task, String> description;
	public static volatile SingularAttribute<Task, Integer> task_id;
	public static volatile SingularAttribute<Task, String> taskName;
	public static volatile SingularAttribute<Task, Employee> employee;
	public static volatile SingularAttribute<Task, Date> startdate;
	public static volatile SingularAttribute<Task, Date> actual_enddate;
	public static volatile SingularAttribute<Task, String> status;

	public static final String ENDDATE = "enddate";
	public static final String ACTUAL_STARTDATE = "actual_startdate";
	public static final String DESCRIPTION = "description";
	public static final String TASK_ID = "task_id";
	public static final String TASK_NAME = "taskName";
	public static final String EMPLOYEE = "employee";
	public static final String STARTDATE = "startdate";
	public static final String ACTUAL_ENDDATE = "actual_enddate";
	public static final String STATUS = "status";

}

