/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.command.editor.page;

import com.google.gwt.user.client.ui.IsWidget;

import org.eclipse.che.ide.api.command.CommandImpl;
import org.eclipse.che.ide.command.editor.CommandEditor;

/**
 * Defines the requirements for the page for {@link CommandEditor}.
 *
 * @author Artem Zatsarynnyi
 * @see CommandEditor
 */
public interface CommandEditorPage {

    /** Returns page's title. */
    String getTitle();

    /** Returns page's view. */
    IsWidget getView();

    /**
     * This method is called every time when command is opening in the editor.
     * Typically, implementor should hold the given {@code command}
     * instance for subsequent modifying it directly and do pages's initial setup.
     */
    void edit(CommandImpl command);

    /**
     * Whether the page has been modified or not?
     *
     * @return {@code true} if page is modified, and {@code false} - otherwise
     */
    boolean isDirty();

    /** Sets {@link DirtyStateListener}. */
    void setDirtyStateListener(DirtyStateListener listener);

    /**
     * Listener that should be called by page every time when
     * any command modifications on the page have been performed.
     */
    interface DirtyStateListener {
        void onDirtyStateChanged();
    }
}
