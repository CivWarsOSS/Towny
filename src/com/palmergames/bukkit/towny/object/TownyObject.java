package com.palmergames.bukkit.towny.object;

import com.palmergames.bukkit.towny.TownyFormatter;
import com.palmergames.bukkit.towny.object.metadata.CustomDataField;
import com.palmergames.bukkit.towny.object.metadata.Metadatable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class TownyObject implements Nameable, Metadatable {
	private String name;
	
	@Deprecated
	private HashSet<CustomDataField> _metadata = null;
	
	private HashMap<String, CustomDataField<?>> metadata = null;
	
	protected TownyObject(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	public List<String> getTreeString(int depth) {

		return new ArrayList<>();
	}

	public String getTreeDepth(int depth) {

		char[] fill = new char[depth * 4];
		Arrays.fill(fill, ' ');
		if (depth > 0) {
			fill[0] = '|';
			int offset = (depth - 1) * 4;
			fill[offset] = '+';
			fill[offset + 1] = '-';
			fill[offset + 2] = '-';
		}
		return new String(fill);
	}

	@Override
	public String toString() {

		return getName();
	}

	public String getFormattedName() {

		return TownyFormatter.getFormattedName(this);
	}
	
	@Override
	public void addMetaData(CustomDataField<?> md) {
		if (get_metadata() == null)
			_metadata = new HashSet<>();

		get_metadata().add(md);
	}

	@Override
	public void removeMetaData(CustomDataField<?> md) {
		if (!hasMeta())
			return;

		get_metadata().remove(md);

		if (get_metadata().size() == 0)
			this._metadata = null;
	}

	@Deprecated
	public HashSet<CustomDataField> get_metadata() {
		return _metadata;
	}

	public boolean hasMeta() {
		return get_metadata() != null;
	}

	public void setMetadata(String str) {

		if (_metadata == null)
			_metadata = new HashSet<>();

		String[] objects = str.split(";");
		for (String object : objects) {
			_metadata.add(CustomDataField.load(object));
		}
	}

	@Override
	public Map<String, CustomDataField<?>> getMetaData() {
		return metadata;
	}
}
