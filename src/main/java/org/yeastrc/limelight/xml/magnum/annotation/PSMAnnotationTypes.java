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

package org.yeastrc.limelight.xml.magnum.annotation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.yeastrc.limelight.limelight_import.api.xml_dto.FilterDirectionType;
import org.yeastrc.limelight.limelight_import.api.xml_dto.FilterablePsmAnnotationType;
import org.yeastrc.limelight.xml.magnum.constants.Constants;
import org.yeastrc.limelight.xml.magnum.objects.ConversionParameters;


public class PSMAnnotationTypes {

	// magnum scores
	public static final String MAGNUM_ANNOTATION_TYPE_EVALUE = "Evalue";
	public static final String MAGNUM_ANNOTATION_TYPE_MSCORE = "Mscore";
	public static final String MAGNUM_ANNOTATION_TYPE_DSCORE = "Dscore";
	public static final String MAGNUM_ANNOTATION_TYPE_PPMERROR = "PPM Error";
	public static final String MAGNUM_ANNOTATION_TYPE_MASSDIFF = "Mass Diff";


	// percolator scores
	public static final String PERCOLATOR_ANNOTATION_TYPE_QVALUE = "q-value";
	public static final String PERCOLATOR_ANNOTATION_TYPE_PVALUE = "p-value";
	public static final String PERCOLATOR_ANNOTATION_TYPE_PEP = "PEP";
	public static final String PERCOLATOR_ANNOTATION_TYPE_SVMSCORE = "SVM Score";

	
	
	public static List<FilterablePsmAnnotationType> getFilterablePsmAnnotationTypes(String programName, ConversionParameters conversionParameters) {
		List<FilterablePsmAnnotationType> types = new ArrayList<FilterablePsmAnnotationType>();

		if( programName.equals( Constants.PROGRAM_NAME_MAGNUM ) ) {

			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( MAGNUM_ANNOTATION_TYPE_EVALUE );
				type.setDescription( "Expect value" );
				type.setFilterDirection( FilterDirectionType.BELOW );
	
				types.add( type );
			}
			
			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( MAGNUM_ANNOTATION_TYPE_MSCORE );
				type.setDescription( "Magnum Score: Cross-correlation coefficient" );
				type.setFilterDirection( FilterDirectionType.ABOVE );
	
				types.add( type );
			}
			
			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( MAGNUM_ANNOTATION_TYPE_DSCORE );
				type.setDescription( "Difference between the XCorr of this PSM and the next best PSM (with a dissimilar peptide)" );
				type.setFilterDirection( FilterDirectionType.ABOVE );
				
				types.add( type );
			}
			
			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( MAGNUM_ANNOTATION_TYPE_PPMERROR );
				type.setDescription( "PPM Error, as calculated by " + Constants.PROGRAM_NAME_MAGNUM );
				type.setFilterDirection( FilterDirectionType.ABOVE );
				
				types.add( type );
			}

			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( MAGNUM_ANNOTATION_TYPE_MASSDIFF );
				type.setDescription( "PPM Error, as calculated by " + Constants.PROGRAM_NAME_MAGNUM );
				type.setFilterDirection( FilterDirectionType.BELOW );

				types.add( type );
			}
			
		}

		else if( programName.equals( Constants.PROGRAM_NAME_PERCOLATOR ) ) {
			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( PERCOLATOR_ANNOTATION_TYPE_QVALUE );
				type.setDescription( "Q-value" );
				type.setFilterDirection( FilterDirectionType.BELOW );

				if(conversionParameters.getqValueOverride() == null)
					type.setDefaultFilterValue( BigDecimal.valueOf( 0.01 ) );
				else
					type.setDefaultFilterValue(conversionParameters.getqValueOverride());
	
				types.add( type );
			}
			
			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( PERCOLATOR_ANNOTATION_TYPE_PVALUE );
				type.setDescription( "P-value" );
				type.setFilterDirection( FilterDirectionType.BELOW );
	
				types.add( type );
			}
			
			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( PERCOLATOR_ANNOTATION_TYPE_PEP );
				type.setDescription( "Posterior error probability" );
				type.setFilterDirection( FilterDirectionType.BELOW );
	
				types.add( type );
			}
			
			{
				FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
				type.setName( PERCOLATOR_ANNOTATION_TYPE_SVMSCORE );
				type.setDescription( "SVN Score from kernel function" );
				type.setFilterDirection( FilterDirectionType.ABOVE );
	
				types.add( type );
			}
		}

		
		return types;
	}
	
	
}
