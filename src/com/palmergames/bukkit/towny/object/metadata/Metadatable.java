package com.palmergames.bukkit.towny.object.metadata;

import java.util.Map;

/**
 * Interface used to identify conformance with metadata.
 */
public interface Metadatable {
	/**
	 * Gets the associated metadata from the class.
	 * 
	 * @return The associated meta data in the form of a <code>Map</code>
	 */
	Map<String, CustomDataField<?>> getMetaData();

	/**
	 * Adds a metadata object to the store Map.
	 * 
	 * @param md The metadata object to store.
	 */
	void addMetaData(CustomDataField<?> md);

	/**
	 * Removes a metadata object from the store Map.
	 * 
	 * @param md The metadata object to remove.
	 */
	void removeMetaData(CustomDataField<?> md);
}
