/*
 * This file is part of YANModPack: https://github.com/HorridoJoho/YANModPack
 * Copyright (C) 2015  Christian Buck
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package YANModPack.YANBuffer.src.model.adapter.direct;

import java.util.Map;

import YANModPack.YANBuffer.src.model.entity.BuffCategoryDef;
import YANModPack.YANBuffer.src.model.wrapper.BuffCategoryListWrapper;
import YANModPack.src.model.adapter.AbstractDefListToMapAdapter;

/**
 * @author HorridoJoho
 */
public final class BuffCategoryDefListToMapAdapter extends AbstractDefListToMapAdapter<String, BuffCategoryDef, BuffCategoryListWrapper>
{
	@Override
	protected String getKey(BuffCategoryDef v)
	{
		return v.id;
	}
	
	@Override
	public BuffCategoryListWrapper marshal(Map<String, BuffCategoryDef> v)
	{
		return new BuffCategoryListWrapper(v.values().toArray(new BuffCategoryDef[0]));
	}
}
