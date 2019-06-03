package com.miracle.config;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.miracle.database.bean.Filter;
import com.miracle.database.bean.Organization;
import com.miracle.database.bean.Release;
import com.miracle.database.bean.Resource;
import com.miracle.database.bean.Scrum;
import com.miracle.database.bean.Sprint;
import com.miracle.database.bean.Status;
import com.miracle.database.bean.Team;
import com.miracle.utility.DataUtility;
import com.miracle.utility.DatabaseService;

@Component
@SuppressWarnings("unchecked")
public class DataConfig implements InitializingBean {

	@Autowired
	@Qualifier("filterServiceImpl")
	private DatabaseService filterServiceImpl;
	@Autowired
	@Qualifier("organizationServiceImpl")
	private DatabaseService organizationServiceImpl;
	@Autowired
	@Qualifier("releaseServiceImpl")
	private DatabaseService releaseServiceImpl;
	@Autowired
	@Qualifier("resourceServiceImpl")
	private DatabaseService resourceServiceImpl;
	@Autowired
	@Qualifier("scrumServiceImpl")
	private DatabaseService scrumServiceImpl;
	@Autowired
	@Qualifier("sprintServiceImpl")
	private DatabaseService sprintServiceImpl;
	@Autowired
	@Qualifier("statusServiceImpl")
	private DatabaseService statusServiceImpl;
	@Autowired
	@Qualifier("teamServiceImpl")
	private DatabaseService teamServiceImpl;
	@Autowired
	private DataUtility commonUtility;

	@Override
	public void afterPropertiesSet() throws Exception {
		init();
		commonUtility.setFilterList((List<Filter>) filterServiceImpl.loadAll());
		commonUtility.setOrganizationList((List<Organization>) organizationServiceImpl.loadAll());
		commonUtility.setResourceList((List<Resource>) resourceServiceImpl.loadAll());
		commonUtility.setReleaseList((List<Release>) releaseServiceImpl.loadAll());
		commonUtility.setScrumList((List<Scrum>) scrumServiceImpl.loadAll());
		commonUtility.setSprintList((List<Sprint>) sprintServiceImpl.loadAll());
		commonUtility.setStatusList((List<Status>) statusServiceImpl.loadAll());
		commonUtility.setTeamList((List<Team>) teamServiceImpl.loadAll());
	}

	private void init() {
		filterServiceImpl.init();
		organizationServiceImpl.init();
		releaseServiceImpl.init();
		resourceServiceImpl.init();
		scrumServiceImpl.init();
		sprintServiceImpl.init();
		statusServiceImpl.init();
		teamServiceImpl.init();
	}
}
