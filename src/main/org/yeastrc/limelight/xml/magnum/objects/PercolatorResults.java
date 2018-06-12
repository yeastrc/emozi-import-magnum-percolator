/*
 * Original author: Michael Riffle <mriffle .at. uw.edu>
 *                  
 * Copyright 2018 University of Washington - Seattle, WA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.yeastrc.limelight.xml.magnum.objects;

import java.util.Map;

public class PercolatorResults {

	/**
	 * @return the percolatorVersion
	 */
	public String getPercolatorVersion() {
		return percolatorVersion;
	}
	/**
	 * @param percolatorVersion the percolatorVersion to set
	 */
	public void setPercolatorVersion(String percolatorVersion) {
		this.percolatorVersion = percolatorVersion;
	}
	/**
	 * @return the reportedPeptidePSMMap
	 */
	public Map<PercolatorPeptide, Map<Integer, PercolatorPSM>> getReportedPeptidePSMMap() {
		return reportedPeptidePSMMap;
	}
	/**
	 * @param reportedPeptidePSMMap the reportedPeptidePSMMap to set
	 */
	public void setReportedPeptidePSMMap(Map<PercolatorPeptide, Map<Integer, PercolatorPSM>> reportedPeptidePSMMap) {
		this.reportedPeptidePSMMap = reportedPeptidePSMMap;
	}
	
	private String percolatorVersion;
	
	// map of reported peptide to scan numbers to psm (a reported peptde + scan number is unique)
	private Map<PercolatorPeptide, Map<Integer, PercolatorPSM>> reportedPeptidePSMMap;	
	
}