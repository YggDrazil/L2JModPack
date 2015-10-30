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
package YANModPack.YANTeleporter.src;

import com.l2jserver.gameserver.handler.IItemHandler;
import com.l2jserver.gameserver.model.L2ItemInstance;
import com.l2jserver.gameserver.model.L2Object.InstanceType;
import com.l2jserver.gameserver.model.actor.L2Playable;
import com.l2jserver.gameserver.model.actor.instance.L2PcInstance;


/**
 * @author HorridoJoho
 */
public final class YANTeleporterItemHandler implements IItemHandler
{
	private static final class SingletonHolder
	{
		protected static final YANTeleporterItemHandler INSTANCE = new YANTeleporterItemHandler();
	}
	
	static YANTeleporterItemHandler getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
	
	YANTeleporterItemHandler()
	{
	}
	
	@Override
	public void useItem(L2Playable playable, L2ItemInstance item, boolean forceUse)
	{
		if (!playable.isInstanceType(InstanceType.L2PcInstance))
		{
			return;
		}
		
		YANTeleporter.getInstance().executeCommand((L2PcInstance) playable, null, null);
	}
}
