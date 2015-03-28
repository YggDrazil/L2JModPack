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
package YANModPack.YANBuffer.src.model.entity;

import javax.xml.bind.annotation.XmlAttribute;

import YANModPack.YANBuffer.src.YANBufferNpcBypassHandler;

import com.l2jserver.gameserver.data.xml.impl.NpcData;
import com.l2jserver.gameserver.model.actor.templates.L2NpcTemplate;

/**
 * @author HorridoJoho
 */
public final class NpcBuffer extends AbstractBuffer
{
	@XmlAttribute(name = "npc_id")
	public final int npcId;
	
	public NpcBuffer()
	{
		super(YANBufferNpcBypassHandler.BYPASS);
		npcId = 0;
	}
	
	public L2NpcTemplate getNpc()
	{
		return NpcData.getInstance().getTemplate(npcId);
	}
	
	@Override
	protected String getName()
	{
		return getNpc().getName();
	}
}