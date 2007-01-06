/*
 * The Log4FIX Software License
 * Copyright (c) 2006 opentradingsolutions.org  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. Neither the name of the product (Log4FIX), nor opentradingsolutions.org,
 *    nor the names of its contributors may be used to endorse or promote
 *    products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL OPENTRADINGSOLUTIONS.ORG OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

package org.opentradingsolutions.log4fix.ui.messages;

import junit.framework.TestCase;
import org.opentradingsolutions.log4fix.core.GlazedListsMemoryLogModel;
import org.opentradingsolutions.log4fix.core.MemoryLogModel;

import javax.swing.*;

/**
 * @author Brian M. Coyner
 */
public class ViewBuilderTest extends TestCase {

    public void testTabPaneTitleForNullSessionId() {
        MemoryLogModel model = new GlazedListsMemoryLogModel();
        model.setSessionId(null);

        JTabbedPane view = getView(model);

        assertEquals("Tab Pane Label", ViewBuilder.NO_SESSION_ID,
                view.getTitleAt(0));
    }

    private JTabbedPane getView(MemoryLogModel model) {
        ViewBuilder builder = new ViewBuilder();
        JComponent view = builder.createView(model);
        assertNotNull("View is null.", view);

        assertTrue("View should be a JTabbedPane", view instanceof JTabbedPane);
        JTabbedPane pane = (JTabbedPane) view;
        assertEquals(1, pane.getTabCount());
        return pane;
    }
}