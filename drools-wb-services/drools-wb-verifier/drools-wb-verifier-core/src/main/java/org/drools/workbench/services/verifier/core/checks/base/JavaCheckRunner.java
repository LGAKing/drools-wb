/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.workbench.services.verifier.core.checks.base;

import java.util.Set;

import com.google.gwt.user.client.Command;
import org.drools.workbench.services.verifier.api.client.StatusUpdate;

/**
 * Just a start for server side runner at the moment. Used by JUnit tests.
 */
public class JavaCheckRunner
        implements CheckRunner {

    @Override
    public void run( final Set<Check> rechecks,
                     final StatusUpdate onStatus,
                     final Command onCompletion ) {
        ChecksRepeatingCommand command = new ChecksRepeatingCommand( rechecks,
                                                                     onStatus,
                                                                     onCompletion );
        while ( command.execute() ) {

        }
    }

    @Override
    public void cancelExistingAnalysis() {
        // All or nothing
    }
}
