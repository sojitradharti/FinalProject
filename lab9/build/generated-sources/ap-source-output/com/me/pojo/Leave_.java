package com.me.pojo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Leave.class)
public abstract class Leave_ {

	public static volatile SingularAttribute<Leave, String> Status;
	public static volatile SingularAttribute<Leave, String> reason;
	public static volatile SingularAttribute<Leave, String> leavetype;
	public static volatile SingularAttribute<Leave, Date> enddate;
	public static volatile SingularAttribute<Leave, Integer> days;
	public static volatile SingularAttribute<Leave, Integer> id;
	public static volatile SingularAttribute<Leave, Date> startdate;
	public static volatile SingularAttribute<Leave, Employee> employee;

	public static final String STATUS = "Status";
	public static final String REASON = "reason";
	public static final String LEAVETYPE = "leavetype";
	public static final String ENDDATE = "enddate";
	public static final String DAYS = "days";
	public static final String ID = "id";
	public static final String STARTDATE = "startdate";
	public static final String EMPLOYEE = "employee";

}

