package org.adligo.tests4j_4gwt.client.model.example;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.MetaTrial;

public class ExampleMetaTrial extends MetaTrial {

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata pMetadata)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterMetadataCalculated(pMetadata);
	}

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results)
			throws Exception {
		
		assertGreaterThanOrEquals(1000, results.getAsserts());
	}

}
