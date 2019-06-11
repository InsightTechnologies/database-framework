package com.miracle.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.miracle.database.bean.Filter;
import com.miracle.database.bean.Organization;
import com.miracle.database.bean.Release;
import com.miracle.database.bean.Resource;
import com.miracle.database.bean.Scrum;
import com.miracle.database.bean.Sprint;
import com.miracle.database.bean.Status;
import com.miracle.database.bean.Team;

@Service
public class DataUtility {

	private List<Filter> filterList;
	private List<Organization> organizationList;
	private List<Release> releaseList;
	private List<Resource> resourceList;
	private List<Scrum> scrumList;
	private List<Sprint> sprintList;
	private List<Status> statusList;
	private List<Team> teamList;

	/**
	 * @return the filterList
	 */
	public List<Filter> getFilterList() {
		return filterList;
	}

	/**
	 * @param filterList the filterList to set
	 */
	public void setFilterList(List<Filter> filterList) {
		this.filterList = filterList;
	}

	/**
	 * @return the organizationList
	 */
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * @param organizationList the organizationList to set
	 */
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	/**
	 * @return the releaseList
	 */
	public List<Release> getReleaseList() {
		return releaseList;
	}

	/**
	 * @param releaseList the releaseList to set
	 */
	public void setReleaseList(List<Release> releaseList) {
		this.releaseList = releaseList;
	}

	/**
	 * @return the resourceList
	 */
	public List<Resource> getResourceList() {
		return resourceList;
	}

	/**
	 * @param resourceList the resourceList to set
	 */
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	/**
	 * @return the scrumList
	 */
	public List<Scrum> getScrumList() {
		return scrumList;
	}

	/**
	 * @param scrumList the scrumList to set
	 */
	public void setScrumList(List<Scrum> scrumList) {
		this.scrumList = scrumList;
	}

	/**
	 * @return the sprintList
	 */
	public List<Sprint> getSprintList() {
		return sprintList;
	}

	/**
	 * @param sprintList the sprintList to set
	 */
	public void setSprintList(List<Sprint> sprintList) {
		this.sprintList = sprintList;
	}

	/**
	 * @return the statusList
	 */
	public List<Status> getStatusList() {
		return statusList;
	}

	/**
	 * @param statusList the statusList to set
	 */
	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

	/**
	 * @return the teamList
	 */
	public List<Team> getTeamList() {
		return teamList;
	}

	/**
	 * @param teamList the teamList to set
	 */
	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	public Filter loadFilter(String filterType) {
		for (Filter filter : getFilterList()) {
			if (filter.getFilterType().equalsIgnoreCase(filterType)) {
				return filter;
			}
		}
		return null;
	}

	public Filter loadFilterWithId(int key) {
		for (Filter filter : getFilterList()) {
			if (filter.get_id() == key) {
				return filter;
			}
		}
		return null;
	}

	public Organization loadOrgWithId(int key) {
		for (Organization org : getOrganizationList()) {
			if (org.get_id() == key) {
				return org;
			}
		}
		return null;
	}

	public Organization loadOrg(String orgName) {
		for (Organization org : getOrganizationList()) {
			if (org.getOrgName().equalsIgnoreCase(orgName)) {
				return org;
			}
		}
		return null;
	}

	public Release loadReleaseWithId(int key) {
		for (Release release : getReleaseList()) {
			if (release.get_id() == key) {
				return release;
			}
		}
		return null;
	}

	public Release loadRelease(double version) {
		for (Release release : getReleaseList()) {
			if (release.getVersion() == version) {
				return release;
			}
		}
		return null;
	}

	public Resource loadResourceWithId(int key) {
		for (Resource resource : getResourceList()) {
			if (resource.get_id() == key) {
				return resource;
			}
		}
		return null;
	}

	public Resource loadResource(String resourceName) {
		for (Resource resource : getResourceList()) {
			if (resource.getResourceName().equalsIgnoreCase(resourceName)) {
				return resource;
			}
		}
		return null;
	}

	public Scrum loadScrumWithId(int key) {
		for (Scrum scrum : getScrumList()) {
			if (scrum.get_id() == key) {
				return scrum;
			}
		}
		return null;
	}

	public Scrum loadScrum(String apiEndpoint) {
		for (Scrum scrum : getScrumList()) {
			if (scrum.getApiEndpoint().equalsIgnoreCase(apiEndpoint)) {
				return scrum;
			}
		}
		return null;
	}

	public Map<String, String> getScrumHeaderDetails() {
		List<Scrum> scrumDetails = getScrumList();
		Map<String, String> headerDetails = new HashMap<String, String>();

		for (Scrum scrum : scrumDetails) {
			String[] scrumMetadataDetails = scrum.getToken().split("\\=");
			if (scrumMetadataDetails.length == 2) {
				headerDetails.put(scrumMetadataDetails[0], scrumMetadataDetails[1]);
			}
		}

		return headerDetails;
	}

	public Sprint loadSprintWithId(int key) {
		for (Sprint sprint : getSprintList()) {
			if (sprint.get_id() == key) {
				return sprint;
			}
		}
		return null;
	}

	public Status loadStatusWithId(int key) {
		for (Status status : getStatusList()) {
			if (status.get_id() == key) {
				return status;
			}
		}
		return null;
	}

	public Status loadStatus(String object) {
		for (Status status : getStatusList()) {
			if (status.getObject().equalsIgnoreCase(object)) {
				return status;
			}
		}
		return null;
	}

	public Team loadTeamWithId(int key) {
		for (Team team : getTeamList()) {
			if (team.get_id() == key) {
				return team;
			}
		}
		return null;
	}

	public Team loadTeam(String teamName) {
		for (Team team : getTeamList()) {
			if (team.getTeamName().equalsIgnoreCase(teamName)) {
				return team;
			}
		}
		return null;
	}

	public String getIceScrumURLPrefix() {
		return getScrumList().get(0).getApiEndpoint();
	}
}
