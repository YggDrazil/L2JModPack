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

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;

import com.l2jserver.gameserver.datatables.SkillTable;
import com.l2jserver.gameserver.model.L2Skill;

import YANModPack.YANBuffer.src.YANBufferData.BuffType;
import YANModPack.src.model.entity.YANModProduct;

/**
 * @author HorridoJoho
 */
public class BuffSkill extends YANModProduct
{
	@XmlAttribute(name = "skill_id", required = true)
	public final int skillId;
	@XmlAttribute(name = "skill_level", required = true)
	public final int skillLevel;
	@XmlAttribute(name = "type", required = true)
	public final BuffType type;
	
	public BuffSkill()
	{
		skillId = 0;
		skillLevel = 0;
		type = BuffType.BUFF;
	}
	
	@Override
	public void afterUnmarshal(Unmarshaller unmarshaller, Object parent)
	{
		super.afterUnmarshal(unmarshaller, parent);
		
		final L2Skill skill = getSkill();
		placeholder.addChild("skill_id", String.valueOf(skill.getId())).addChild("skill_name", skill.getName()).addChild("skill_icon", _getClientSkillIconSource(skill.getId())).addChild("type", type.toString());
	}
	
	public L2Skill getSkill()
	{
		return SkillTable.getInstance().getInfo(skillId, skillLevel);
	}
	
	private String _getClientSkillIconSource(int skillId)
	{
		String format = "";
		if (skillId < 100)
		{
			format = "00" + skillId;
		}
		else if ((skillId > 99) && (skillId < 1000))
		{
			format = "0" + skillId;
		}
		else if (skillId == 1517)
		{
			format = "1499";
		}
		else if (skillId == 1518)
		{
			format = "1502";
		}
		else
		{
			if ((skillId > 4698) && (skillId < 4701))
			{
				format = "1331";
			}
			else if ((skillId > 4701) && (skillId < 4704))
			{
				format = "1332";
			}
			else
			{
				format = Integer.toString(skillId);
			}
		}
		
		return "icon.skill" + format;
	}
}