/*******************************************************************************
 * Copyright (c) 2010-2011 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package org.jboss.tools.ws.ui.bot.test.rest.completion;

import java.util.Arrays;
import java.util.List;

import org.jboss.tools.ui.bot.ext.helper.ContentAssistHelper;
import org.jboss.tools.ws.ui.bot.test.rest.RESTfulTestBase;
import org.jboss.tools.ws.ui.bot.test.rest.explorer.RESTfulExplorerTest;
import org.junit.Test;

/**
 * Test operates on JAX-RS completion
 * @author jjankovi
 *
 */
public class RESTfulCompletionTest extends RESTfulTestBase{

	private final String GET_METHOD_PATH = "/{userId}";
	
	private final String EMPTY_PATH_PARAM = "";
	
	private final String CORRECT_PATH_PARAM = "userId";
	
	private final String INCORRECT_PATH_PARAM = "someId";
	
	private final String PATH_PARAM_NAVIGATION = "@PathParam(";
	
	private final List<String> EXP_NON_EMPTY_COMPLETION_RESULT = Arrays.asList("userId - JAX-RS Mapping");
	
	private final List<String> EXP_EMPTY_COMPLETION_RESULT = Arrays.asList("No Default Proposals");
	
	protected String getWsProjectName() {
		return "RestServicesCompletion";
	}
	
	protected String getWsPackage() {
		return "org.rest.services.completion.test";
	}

	protected String getWsName() {
		return "RestService";
	}
	
	@Test
	public void testWithEmptyPrefix() {
		
		resourceHelper.copyResourceToClass(bot.editorByTitle(getWsName() + ".java"), 
				   RESTfulExplorerTest.class.getResourceAsStream(SIMPLE_REST_WS_RESOURCE), 
				   false, getWsPackage(), getWsName(), GET_METHOD_PATH, EMPTY_PATH_PARAM);
		
		ContentAssistHelper.checkContentAssistContent(bot, 
				getWsName() + ".java", PATH_PARAM_NAVIGATION, PATH_PARAM_NAVIGATION.length() + 1, 
				0, EXP_NON_EMPTY_COMPLETION_RESULT);
		
	}
	
	@Test
	public void testWithValidPrefixAtTheEnd() {
		
		resourceHelper.copyResourceToClass(bot.editorByTitle(getWsName() + ".java"), 
				   RESTfulExplorerTest.class.getResourceAsStream(SIMPLE_REST_WS_RESOURCE), 
				   false, getWsPackage(), getWsName(), GET_METHOD_PATH, CORRECT_PATH_PARAM);
		
		ContentAssistHelper.checkContentAssistContent(bot, 
				getWsName() + ".java", PATH_PARAM_NAVIGATION, PATH_PARAM_NAVIGATION.length() + 
				CORRECT_PATH_PARAM.length() + 1, 
				0, EXP_NON_EMPTY_COMPLETION_RESULT);
		
	}
	
	@Test
	public void testWithValidPrefixInTheBeginning() {
	
		resourceHelper.copyResourceToClass(bot.editorByTitle(getWsName() + ".java"), 
				   RESTfulExplorerTest.class.getResourceAsStream(SIMPLE_REST_WS_RESOURCE), 
				   false, getWsPackage(), getWsName(), GET_METHOD_PATH, CORRECT_PATH_PARAM);
		
		ContentAssistHelper.checkContentAssistContent(bot, 
				getWsName() + ".java", PATH_PARAM_NAVIGATION, PATH_PARAM_NAVIGATION.length() + 1, 
				0, EXP_NON_EMPTY_COMPLETION_RESULT);
		
	}
	
	@Test
	public void testWithInvalidPrefixAtTheEnd() {
		
		resourceHelper.copyResourceToClass(bot.editorByTitle(getWsName() + ".java"), 
				   RESTfulExplorerTest.class.getResourceAsStream(SIMPLE_REST_WS_RESOURCE), 
				   false, getWsPackage(), getWsName(), GET_METHOD_PATH, INCORRECT_PATH_PARAM);
		
		ContentAssistHelper.checkContentAssistContent(bot, 
				getWsName() + ".java", PATH_PARAM_NAVIGATION, PATH_PARAM_NAVIGATION.length() + 
				INCORRECT_PATH_PARAM.length() + 1, 
				0, EXP_EMPTY_COMPLETION_RESULT);
		
	}

	@Test
	public void testWithInvalidPrefixInTheBeginning() {
	
		resourceHelper.copyResourceToClass(bot.editorByTitle(getWsName() + ".java"), 
				   RESTfulExplorerTest.class.getResourceAsStream(SIMPLE_REST_WS_RESOURCE), 
				   false, getWsPackage(), getWsName(), GET_METHOD_PATH, INCORRECT_PATH_PARAM);
		
		ContentAssistHelper.checkContentAssistContent(bot, 
				getWsName() + ".java", PATH_PARAM_NAVIGATION, PATH_PARAM_NAVIGATION.length() + 1, 
				0, EXP_NON_EMPTY_COMPLETION_RESULT);
		
	}
	
	@Test
	public void testWithAllInvalidParamSelection() {
		
		resourceHelper.copyResourceToClass(bot.editorByTitle(getWsName() + ".java"), 
				   RESTfulExplorerTest.class.getResourceAsStream(SIMPLE_REST_WS_RESOURCE), 
				   false, getWsPackage(), getWsName(), GET_METHOD_PATH, INCORRECT_PATH_PARAM);
		
		ContentAssistHelper.checkContentAssistContent(bot, 
				getWsName() + ".java", PATH_PARAM_NAVIGATION, PATH_PARAM_NAVIGATION.length() + 1, 
				INCORRECT_PATH_PARAM.length(), EXP_NON_EMPTY_COMPLETION_RESULT);
		
	}
	
}
