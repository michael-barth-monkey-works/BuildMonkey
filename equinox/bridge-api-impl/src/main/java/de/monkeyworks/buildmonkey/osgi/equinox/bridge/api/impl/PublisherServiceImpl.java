/**
 * Copyright (c) 2015 the original author or authors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package de.monkeyworks.buildmonkey.osgi.equinox.bridge.api.impl;

import de.monkeyworks.buildmonkey.equinox.api.PublisherService;
import de.monkeyworks.buildmonkey.equinox.api.parameter.FeatureAndBundlePublishParameter;
import org.eclipse.equinox.p2.publisher.eclipse.FeaturesAndBundlesPublisherApplication;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {

    @Override
    public void publishFeaturesAndBundles(FeatureAndBundlePublishParameter parameter) {
        List<String> arguments = parameter.getArgumentList();

        arguments.add("-nosplash");

        try {
            new FeaturesAndBundlesPublisherApplication().run(arguments.toArray(new String[arguments.size()]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
