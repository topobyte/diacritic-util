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

import java.text.Normalizer;
import java.util.regex.Pattern;

import com.slimjars.dist.gnu.trove.map.TCharObjectMap;
import com.slimjars.dist.gnu.trove.map.hash.TCharObjectHashMap;

/**
 * An implementation of IDiacriticUtil that builds on Normalizer and extends it
 * with special handling of a few extra cases.
 */
public class NormalizerDiacriticUtil implements IDiacriticUtil
{

	private static Pattern pattern = Pattern
			.compile("\\p{InCombiningDiacriticalMarks}+");

	private static TCharObjectMap<String> special = new TCharObjectHashMap<>();
	static {
		special.put('\u0141', "L");
		special.put('\u0142', "l");
	}

	@Override
	public String simplify(String input)
	{
		if (input == null) {
			return null;
		}

		// First use normalizer
		String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
		input = pattern.matcher(temp).replaceAll("");

		// Then use manual mapping for some special cases
		StringBuilder strb = new StringBuilder();
		int n = input.length();
		for (int i = 0; i < n; i++) {
			char c = input.charAt(i);
			String replacement = special.get(c);
			if (replacement == null) {
				strb.append(c);
			} else {
				strb.append(replacement);
			}
		}
		return strb.toString();
	}

}
