package pl.kaqu.pg.engine.gamearea;

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

public class PGCoordinate {

    public final int x;
    public final int y;

    public PGCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PGCoordinate))
			return false;
		PGCoordinate other = (PGCoordinate) obj;
		return x == other.x && y == other.y;
	}
}
