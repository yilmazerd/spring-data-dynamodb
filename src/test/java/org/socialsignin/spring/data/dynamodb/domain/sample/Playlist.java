/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.spring.data.dynamodb.domain.sample;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Test")
public class Playlist {

	@Id
	private PlaylistId playlistId;

	public Playlist() {
	}

	public Playlist(PlaylistId playlistId) {
		this.playlistId = playlistId;
	}

	private String displayName;

	@DynamoDBAttribute(attributeName="DisplayName")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@DynamoDBHashKey(attributeName = "id")
	public String getUserName() {
		return playlistId != null ? playlistId.getUserName() : null;
	}
	
	
	public void setUserName(String userName) {
		if (playlistId == null) {
			playlistId = new PlaylistId();
		}
		playlistId.setUserName(userName);
	}

	@DynamoDBRangeKey(attributeName = "range")
	public String getPlaylistName() {
		return playlistId != null ? playlistId.getPlaylistName() : null;
	}

	public void setPlaylistName(String playlistName) {
		if (playlistId == null) {
			playlistId = new PlaylistId();
		}
		playlistId.setPlaylistName(playlistName);
	}
}
