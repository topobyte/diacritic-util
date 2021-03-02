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

public class TestNormalizerDiacriticUtil extends TestDiacriticUtil
{

	@Override
	protected IDiacriticUtil createUtil()
	{
		return new NormalizerDiacriticUtil();
	}

}
