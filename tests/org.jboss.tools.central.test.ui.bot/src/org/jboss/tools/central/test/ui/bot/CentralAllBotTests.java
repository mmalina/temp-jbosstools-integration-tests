package org.jboss.tools.central.test.ui.bot;

import org.jboss.tools.ui.bot.ext.RequirementAwareSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(RequirementAwareSuite.class)
@SuiteClasses({
	BaseFunctionalityTest.class,
	CreateProjectsWithServerTest.class,
	DocumentationSectionTest.class
//	InstallTest.class
	})
public class CentralAllBotTests {

}
	