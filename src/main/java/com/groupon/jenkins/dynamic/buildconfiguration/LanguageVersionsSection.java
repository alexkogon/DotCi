/*
The MIT License (MIT)

Copyright (c) 2014, Groupon, Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package com.groupon.jenkins.dynamic.buildconfiguration;

import hudson.matrix.Combination;

import java.util.List;

import com.groupon.jenkins.dynamic.build.execution.BuildType;
import com.groupon.jenkins.dynamic.buildconfiguration.configvalue.ListOrSingleValue;

public class LanguageVersionsSection extends ConfigSection<ListOrSingleValue<String>> {

	public static final String NAME = "language_versions";

	protected LanguageVersionsSection(ListOrSingleValue<String> configValue) {
		super(NAME, configValue, MergeStrategy.REPLACE);
	}

	@Override
	protected void merge(ConfigSection<ListOrSingleValue<String>> otherConfigSection) {
		super.merge(otherConfigSection);
	}

	@Override
	public ShellCommands toScript(Combination combination, BuildType buildType) {
		return ShellCommands.NOOP;
	}

	public boolean isMultiLanguageVersions() {
		return getConfigValue().size() > 1;
	}

	public List<String> getLanguageVersions() {
		return getConfigValue().getValues();
	}

}
