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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public abstract class TestDiacriticUtil
{

	private IDiacriticUtil util;

	public TestDiacriticUtil()
	{
		util = createUtil();
	}

	protected abstract IDiacriticUtil createUtil();

	@Test
	public void testNull()
	{
		assertNull(util.simplify(null));
	}

	@Test
	public void testPlain()
	{
		testPlain("asdf");
		testPlain("ASDF");
		testPlain("1234567890");
	}

	private void testPlain(String string)
	{
		assertEquals(string, util.simplify(string));
	}

	@Test
	public void testUmlaut()
	{
		assertEquals("OoAaUu", util.simplify("ÖöÄäÜü"));
	}

	@Test
	public void testEszett()
	{
		assertEquals("ß", util.simplify("ß"));
	}

	@Test
	public void testGerman()
	{
		assertEquals("Aa", util.simplify("Ää"));
		assertEquals("Oo", util.simplify("Öö"));
		assertEquals("Uu", util.simplify("Üü"));
		assertEquals("ß", util.simplify("ß"));
	}

	@Test
	public void testPolish()
	{
		assertEquals("Ll", util.simplify("Łł"));
		assertEquals("Cc", util.simplify("Ćć"));
		assertEquals("Ee", util.simplify("Ęę"));
		assertEquals("Nn", util.simplify("Ńń"));
		assertEquals("Oo", util.simplify("Óó"));
		assertEquals("Ss", util.simplify("Śś"));
		assertEquals("Zz", util.simplify("Źź"));
		assertEquals("Zz", util.simplify("Żż"));
	}

	@Test
	public void testFrench()
	{
		assertEquals("Aa", util.simplify("Àà"));
		assertEquals("Aa", util.simplify("Ââ"));
		assertEquals("Cc", util.simplify("Çç"));
		assertEquals("Ee", util.simplify("Éé"));
		assertEquals("Ee", util.simplify("Èè"));
		assertEquals("Ee", util.simplify("Êê"));
		assertEquals("Ee", util.simplify("Ëë"));
		assertEquals("Ii", util.simplify("Îî"));
		assertEquals("Ii", util.simplify("Ïï"));
		assertEquals("Oo", util.simplify("Ôô"));
		assertEquals("Uu", util.simplify("Ùù"));
		assertEquals("Uu", util.simplify("Ûû"));
		assertEquals("Uu", util.simplify("Üü"));
		assertEquals("Yy", util.simplify("Ÿÿ"));
		assertEquals("Ææ", util.simplify("Ææ"));
		assertEquals("Œœ", util.simplify("Œœ"));
	}

}
