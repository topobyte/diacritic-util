// Copyright 2021 Sebastian Kuerten
//
// This file is part of diacritic-utils.
//
// diacritic-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// diacritic-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with diacritic-utils. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.diacritic;

import com.slimjars.dist.gnu.trove.map.TCharObjectMap;
import com.slimjars.dist.gnu.trove.map.hash.TCharObjectHashMap;

/**
 * An implementation of IDiacriticUtil that builds on a simple table of
 * replacements for individual characters.
 */
public class TableDiacriticUtil implements IDiacriticUtil
{

	private static TCharObjectMap<String> mapping = new TCharObjectHashMap<>();
	static {
		mapping.put('\u0141', "L");
		mapping.put('\u0142', "l");
		put("ÄäÖöÜüËëÏïŸÿ", "AaOoUuEeIiYy");
		put("ĆćŃńÓóŹźŚśÉé", "CcNnOoZzSsEe");
		put("ÀàÈèÙù", "AaEeUu");
		put("ÂâÊêÎîÔôÛû", "AaEeIiOoUu");
		put("ÇçĘę", "CcEe");
		put("Żż", "Zz");
	}

	private static void put(String chars, String replacements)
	{
		for (int i = 0; i < chars.length(); i++) {
			char c = chars.charAt(i);
			char r = replacements.charAt(i);
			mapping.put(c, Character.toString(r));
		}
	}

	@Override
	public String simplify(String input)
	{
		if (input == null) {
			return null;
		}

		StringBuilder strb = new StringBuilder();
		int n = input.length();
		for (int i = 0; i < n; i++) {
			char c = input.charAt(i);
			String replacement = mapping.get(c);
			if (replacement == null) {
				strb.append(c);
			} else {
				strb.append(replacement);
			}
		}
		return strb.toString();
	}

}
