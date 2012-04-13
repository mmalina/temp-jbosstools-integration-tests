 /*******************************************************************************
  * Copyright (c) 2007-2012 Red Hat, Inc.
  * Distributed under license by Red Hat, Inc. All rights reserved.
  * This program is made available under the terms of the
  * Eclipse Public License v1.0 which accompanies this distribution,
  * and is available at http://www.eclipse.org/legal/epl-v10.html
  *
  * Contributor:
  *     Red Hat, Inc. - initial API and implementation
  ******************************************************************************/

package org.jboss.tools.ui.bot.ext.helper;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.jboss.tools.ui.bot.ext.FormatUtils;
import org.jboss.tools.ui.bot.ext.SWTBotExt;
import org.jboss.tools.ui.bot.ext.SWTJBTExt;
import org.jboss.tools.ui.bot.ext.SWTTestExt;
import org.jboss.tools.ui.bot.ext.Timing;
import org.jboss.tools.ui.bot.ext.parts.ContentAssistBot;
import org.jboss.tools.ui.bot.ext.parts.SWTBotEditorExt;

/**
 * Helper for Content Assist functionality testing
 * @author Vladimir Pakan
 *
 */
public class ContentAssistHelper {
  protected static final Logger log = Logger.getLogger(ContentAssistHelper.class);
  /**
   * Checks Content Assist content on specified position within editor with editorTitle
   * and checks if expectedProposalList is equal to current Proposal List 
   * @param editorTitle
   * @param textToSelect
   * @param selectionOffset
   * @param selectionLength
   * @param textToSelectIndex
   * @param expectedProposalList
   */
  public static SWTBotEditor checkContentAssistContent(SWTBotExt bot,
      String editorTitle, String textToSelect, int selectionOffset,
      int selectionLength, int textToSelectIndex, List<String> expectedProposalList) {

    SWTJBTExt.selectTextInSourcePane(bot,
        editorTitle, textToSelect, selectionOffset, selectionLength,
        textToSelectIndex);

    bot.sleep(Timing.time1S());

    SWTBotEditorExt editor = SWTTestExt.bot.swtBotEditorExtByTitle(editorTitle);
    ContentAssistBot contentAssist = editor.contentAssist();
    List<String> currentProposalList = contentAssist.getProposalList();
    assertTrue("Code Assist menu has incorrect menu items.\n" +
        "Expected Proposal Menu Labels vs. Current Proposal Menu Labels :\n" + 
        FormatUtils.getListsDiffFormatted(expectedProposalList,currentProposalList),
      expectedProposalList.equals(currentProposalList));

    return editor;

  }
  
  /**
   * Checks Content Assist content on specified position within editor with editorTitle
   * and checks if expectedProposalList is equal to current Proposal List 
   * @param editorTitle
   * @param textToSelect
   * @param selectionOffset
   * @param selectionLength
   * @param textToSelectIndex
   * @param expectedProposalList
   */
  public static SWTBotEditor checkContentAssistContent(SWTBotExt bot,
      String editorTitle, String textToSelect, int selectionOffset,
      int selectionLength, List<String> expectedProposalList) {

    return ContentAssistHelper.checkContentAssistContent(bot, 
        editorTitle, 
        textToSelect, 
        selectionOffset, 
        selectionLength,
        0,
        expectedProposalList);

  }
  
} 
