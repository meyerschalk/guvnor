/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.explorer.navigation.processes;

import com.google.gwt.place.shared.PlaceController;
import org.drools.guvnor.client.explorer.places.RuntimePlace;
import org.junit.Before;
import org.junit.Test;

import static org.drools.guvnor.client.explorer.navigation.RuntimeTestMethods.*;
import static org.mockito.Mockito.*;

public class ProcessesTreeTest {

    private ProcessesTree processesTree;
    private ProcessesTreeView view;
    private ProcessesTreeView.Presenter presenter;
    private PlaceController placeController;

    @Before
    public void setUp() throws Exception {
        view = mock(ProcessesTreeView.class);
        placeController = mock(PlaceController.class);
        processesTree = new ProcessesTree(view, placeController);
        presenter = processesTree;
    }

    @Test
    public void testPresenterIsSet() throws Exception {
        verify(view).setPresenter(presenter);
    }

    @Test
    public void testReturnsViewsWidgetWithAsWidget() throws Exception {
        processesTree.asWidget();
        verify(view).asWidget();
    }

    @Test
    public void testGoToExecutionHistory() throws Exception {
        presenter.onExecutionHistorySelected();
        assertGoesTo(placeController, RuntimePlace.Location.EXECUTION_HISTORY);
    }

    @Test
    public void testGoToProcessOverview() throws Exception {
        presenter.onProcessOverViewSelected();
        assertGoesTo(placeController, RuntimePlace.Location.PROCESS_OVERVIEW);
    }
}
