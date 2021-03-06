/*******************************************************************************
 * Copyright 2011 Netflix
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.netflix.astyanax.impl;

import com.netflix.astyanax.AuthenticationStrategy;


public class NoAuthenticationStrategyImpl implements AuthenticationStrategy<Object> {

	@Override
	public void authenticate(Object client) {
		// no operations as this is the strategy when no authentication is necessary
	}

	@Override
	public AuthenticationStrategy<Object> setUsername(String username) {
		// no operation
		return this;
	}

	@Override
	public AuthenticationStrategy<Object> setPassword(String password) {
		// no operation
		return this;
	}

}
