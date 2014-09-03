package org.adligo.tests4j_4gwt.client.model.example;

import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.models.shared.trials.I_MetaTrial;
import org.adligo.tests4j.models.shared.trials.TrialTypeAnnotation;

@TrialTypeAnnotation (type=TrialType.META_TRIAL_TYPE)
public class ExampleMetaTrial  extends AbstractTrial implements I_MetaTrial {

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata pMetadata)
			throws Exception {
		assertGreaterThanOrEquals(2, pMetadata.getAllTrialsCount());
		assertGreaterThanOrEquals(9, pMetadata.getAllTestsCount());
	}

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results)
			throws Exception {
		
		assertGreaterThanOrEquals(54, results.getAsserts());
	}

}
