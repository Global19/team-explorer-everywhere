// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

package com.microsoft.tfs.core.clients.build.internal.soapextensions;

import java.util.Map;

import com.microsoft.tfs.core.clients.build.IBuildDefinition;
import com.microsoft.tfs.core.clients.build.IBuildDefinitionQueryResult;
import com.microsoft.tfs.core.clients.build.IBuildServer;
import com.microsoft.tfs.core.clients.build.IFailure;
import com.microsoft.tfs.core.clients.build.internal.utils.BuildTypeConvertor;
import com.microsoft.tfs.core.clients.build.internal.utils.QueryResultHelper;
import com.microsoft.tfs.core.internal.wrappers.WebServiceObjectWrapper;
import com.microsoft.tfs.core.internal.wrappers.WrapperUtils;
import com.microsoft.tfs.util.Check;

import ms.tfs.build.buildservice._04._BuildAgent;
import ms.tfs.build.buildservice._04._BuildController;
import ms.tfs.build.buildservice._04._BuildDefinition;
import ms.tfs.build.buildservice._04._BuildDefinitionQueryResult;
import ms.tfs.build.buildservice._04._BuildServiceHost;

public class BuildDefinitionQueryResult extends WebServiceObjectWrapper implements IBuildDefinitionQueryResult {
    private final BuildDefinition[] definitions;
    private final BuildAgent[] agents;
    private final BuildController[] controllers;
    private final BuildServiceHost[] serviceHosts;

    public BuildDefinitionQueryResult(
        final IBuildServer buildServer,
        final _BuildDefinitionQueryResult webServiceObject) {
        super(webServiceObject);

        Check.notNull(buildServer, "buildServer"); //$NON-NLS-1$

        serviceHosts = BuildTypeConvertor.toBuildServiceHostArray(buildServer, getWebServiceObject().getServiceHosts());
        controllers = BuildTypeConvertor.toBuildControllersArray(buildServer, getWebServiceObject().getControllers());
        agents = BuildTypeConvertor.toBuildAgentArray(getWebServiceObject().getAgents());
        definitions = BuildTypeConvertor.toBuildDefinitionArray(buildServer, getWebServiceObject().getDefinitions());

        afterDeserialize(buildServer);
    }

    public BuildDefinitionQueryResult(
        final IBuildServer buildServer,
        final BuildAgent[] agents,
        final BuildController[] controllers,
        final BuildDefinition[] definitions,
        final BuildServiceHost[] serviceHosts) {
        super(new _BuildDefinitionQueryResult());

        Check.notNull(buildServer, "buildServer"); //$NON-NLS-1$
        Check.notNull(agents, "agents"); //$NON-NLS-1$
        Check.notNull(controllers, "controllers"); //$NON-NLS-1$
        Check.notNull(definitions, "definitions"); //$NON-NLS-1$
        Check.notNull(serviceHosts, "serviceHosts"); //$NON-NLS-1$

        this.agents = agents;
        this.controllers = controllers;
        this.definitions = definitions;
        this.serviceHosts = serviceHosts;

        final _BuildAgent[] _agents = (_BuildAgent[]) WrapperUtils.unwrap(_BuildAgent.class, agents);
        final _BuildController[] _controllers =
            (_BuildController[]) WrapperUtils.unwrap(_BuildController.class, controllers);
        final _BuildDefinition[] _definitions =
            (_BuildDefinition[]) WrapperUtils.unwrap(_BuildDefinition.class, definitions);
        final _BuildServiceHost[] _serviceHosts =
            (_BuildServiceHost[]) WrapperUtils.unwrap(_BuildServiceHost.class, serviceHosts);

        getWebServiceObject().setAgents(_agents);
        getWebServiceObject().setControllers(_controllers);
        getWebServiceObject().setDefinitions(_definitions);
        getWebServiceObject().setServiceHosts(_serviceHosts);

        afterDeserialize(buildServer);
    }

    public _BuildDefinitionQueryResult getWebServiceObject() {
        return (_BuildDefinitionQueryResult) this.webServiceObject;
    }

    @Override
    public IBuildDefinition[] getDefinitions() {
        return definitions;
    }

    @Override
    public IFailure[] getFailures() {
        return new IFailure[0];
    }

    private void afterDeserialize(final IBuildServer buildServer) {
        final Map<String, BuildController> controllerDict = QueryResultHelper.match(serviceHosts, controllers, agents);

        for (final BuildDefinition definition : definitions) {
            if (definition != null && definition.getBuildControllerURI() != null) {
                final BuildController controller = controllerDict.get(definition.getBuildControllerURI());
                if (controller != null) {
                    definition.setBuildController(controller);
                }
            }
        }
    }
}
