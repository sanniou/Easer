/*
 * Copyright (c) 2016 - 2019 Rui Zhao <renyuneyun@gmail.com>
 *
 * This file is part of Easer.
 *
 * Easer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Easer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Easer.  If not, see <http://www.gnu.org/licenses/>.
 */

package ryey.easer.skills.usource.wifi_enabled;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ryey.easer.R;
import ryey.easer.commons.local_skill.InvalidDataInputException;
import ryey.easer.commons.local_skill.ValidData;
import ryey.easer.skills.SkillViewFragment;

public class WifiEnabledSkillViewFragment extends SkillViewFragment<WifiEnabledUSourceData> {

    RadioButton radioButton_enabled, radioButton_disabled;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill_usource_wifi_enabled, container, false);

        radioButton_enabled = view.findViewById(R.id.radioButton_yes);
        radioButton_disabled = view.findViewById(R.id.radioButton_no);

        return view;
    }

    @Override
    protected void _fill(@ValidData @NonNull WifiEnabledUSourceData data) {
        if (data.enabled) {
            radioButton_enabled.setChecked(true);
        } else {
            radioButton_disabled.setChecked(true);
        }
    }

    @ValidData
    @NonNull
    @Override
    public WifiEnabledUSourceData getData() throws InvalidDataInputException {
        boolean enabled = radioButton_enabled.isChecked();
        return new WifiEnabledUSourceData(enabled);
    }
}
