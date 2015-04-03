/**
 * Copyright (C) 2013, 2014 Johannes Taelman
 *
 * This file is part of Axoloti.
 *
 * Axoloti is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Axoloti is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Axoloti. If not, see <http://www.gnu.org/licenses/>.
 */
package axoloti.realunits;

import axoloti.datatypes.Value;

/**
 *
 * @author Johannes Taelman
 */
public class SquareDB implements NativeToReal {

    final double maxGain;

    public SquareDB(double maxGain) {
        this.maxGain = maxGain;
    }

    @Override
    public String ToReal(Value v) {
        if (v.getDouble() != 0) {
            return (String.format("%.1fdB", maxGain + 40 * Math.log10(Math.abs(v.getDouble() / 64.0))));
        } else {
            return "-infdB";
        }
    }
}