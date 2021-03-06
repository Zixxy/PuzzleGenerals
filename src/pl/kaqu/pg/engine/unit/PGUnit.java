package pl.kaqu.pg.engine.unit;

/*
    PuzzleGenerals
    Copyright (C) 2016 kaqu kaqukal@gmail.com

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.NotNull;

import pl.kaqu.pg.engine.gamearea.behaviour.PGUnitContainerObserver;
import pl.kaqu.pg.engine.player.PGPlayer;
import pl.kaqu.pg.engine.unit.action.PGUnitAction;
import pl.kaqu.pg.engine.unit.effect.PGUnitEffect;
import pl.kaqu.pg.engine.unit.effect.PGUnitState;

public abstract class PGUnit implements Serializable, PGUnitContainerObserver {

    public final long unitID;
    protected PGPlayer owner;
    protected PGUnitGroup group;
    protected PGUnitState state;
    protected List<PGUnitEffect> currentEffects;

    protected PGUnit(long unitID, @NotNull PGPlayer owner, @NotNull PGUnitGroup group, @NotNull PGUnitState state){
        this.unitID = unitID;
        this.owner = owner != null ? owner : PGPlayer.NO_PLAYER;
        this.group = group != null ? group : PGUnitGroup.NONE;
        this.state = state;
        this.currentEffects = new ArrayList<>();
    }

    @NotNull public PGPlayer getOwner() {
        return owner;
    }
    public void setState(PGUnitState state) {
        this.state = state;
    }
    @NotNull public PGUnitGroup getGroup() {
        return this.group;
    }
    abstract public int getPriority();
    abstract @NotNull public String getName();
    abstract @NotNull public String getDescription();
    abstract public PGUnitRank getRank();
    abstract public void applyEffect(PGUnitEffect effect);
    abstract public void removeEffect(PGUnitEffect effect);
    @NotNull public List<PGUnitEffect> getCurrentEffects() {
        return currentEffects;
    }
    abstract @NotNull public PGUnitAction getUnitAction();
}
