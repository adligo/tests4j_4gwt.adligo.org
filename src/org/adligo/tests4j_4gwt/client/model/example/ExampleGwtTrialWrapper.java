package org.adligo.tests4j_4gwt.client.model.example;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.shared.common.TrialType;
import org.adligo.tests4j_4gwt.client.model.run.GwtTrialDescription;
import org.adligo.tests4j_4gwt.client.model.run.I_GwtMethodWrapper;
import org.adligo.tests4j_4gwt.client.model.run.I_GwtTrialDescription;
import org.adligo.tests4j_4gwt.client.model.run.I_GwtTrialWrapper;

/**
 * this binding would be autogenerated
 * @author scott
 *
 */
public class ExampleGwtTrialWrapper implements I_GwtTrialWrapper {
	private ExampleGwtTrial trial = new ExampleGwtTrial();

	@Override
	public String getName() {
		return trial.getClass().getName();
	}

	@Override
	public I_GwtMethodWrapper getBeforeTrial() {
		return null;
	}

	@Override
	public I_GwtMethodWrapper getBeforeTests() {
		return new I_GwtMethodWrapper() {
			
			@Override
			public void run() {
				trial.beforeTests();
			}
			
			@Override
			public String getName() {
				return "beforeTests";
			}
		};
	}

	@Override
	public List<I_GwtMethodWrapper> getTests() {
		List<I_GwtMethodWrapper> tests = new ArrayList<I_GwtMethodWrapper>();
		tests.add(get_testGetPrimitive());
		tests.add(get_testIsClassOrArray());
		tests.add(get_testGetArrayType());
		tests.add(get_testToNames());
		tests.add(get_testIsClass());
		tests.add(get_testIsPrimitive());
		tests.add(get_testToResource());
		return tests;
	}

	private I_GwtMethodWrapper get_testGetArrayType() {
		return new I_GwtMethodWrapper() {

			@Override
			public String getName() {
				return "testGetArrayType";
			}

			@Override
			public void run() {
				trial.testGetArrayType();
			}
			
		};
	}
	
	private I_GwtMethodWrapper get_testGetPrimitive() {
		return new I_GwtMethodWrapper() {

			@Override
			public String getName() {
				return "testGetPrimitive";
			}

			@Override
			public void run() {
				trial.testGetPrimitive();
			}
			
		};
	}
	
	private I_GwtMethodWrapper get_testIsClass() {
		return new I_GwtMethodWrapper() {

			@Override
			public String getName() {
				return "testIsClass";
			}

			@Override
			public void run() {
				trial.testIsClass();
			}
			
		};
	}
	
	private I_GwtMethodWrapper get_testIsClassOrArray() {
		return new I_GwtMethodWrapper() {

			@Override
			public String getName() {
				return "testIsClassOrArray";
			}

			@Override
			public void run() {
				trial.testIsClassOrArray();
			}
			
		};
	}
	
	private I_GwtMethodWrapper get_testIsPrimitive() {
		return new I_GwtMethodWrapper() {

			@Override
			public String getName() {
				return "testIsPrimitive";
			}

			@Override
			public void run() {
				trial.testIsPrimitive();
			}
			
		};
	}
	
	private I_GwtMethodWrapper get_testToNames() {
		return new I_GwtMethodWrapper() {

			@Override
			public String getName() {
				return "testToNames";
			}

			@Override
			public void run() {
				trial.testToNames();
			}
			
		};
	}
	
	private I_GwtMethodWrapper get_testToResource() {
		return new I_GwtMethodWrapper() {

			@Override
			public String getName() {
				return "testToResource";
			}

			@Override
			public void run() {
				trial.testToResource();
			}
			
		};
	}
	@Override
	public I_GwtMethodWrapper getAfterTests() {
		return new I_GwtMethodWrapper() {
			
			@Override
			public void run() {
				trial.afterTests();
			}
			
			@Override
			public String getName() {
				return "afterTests";
			}
		};
	}

	@Override
	public I_GwtMethodWrapper getAfterTrial() {
		return null;
	}

	@Override
	public I_Trial getTrial() {
		return trial;
	}

	@Override
	public I_GwtTrialDescription getDescription() {
		GwtTrialDescription desc = new GwtTrialDescription();
		desc.setTrialName(trial.getClass().getName());
		desc.setType(TrialType.SourceFileTrial);
		return desc;
	}
	

}
