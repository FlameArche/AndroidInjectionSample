/*
 * Copyright 2017 Kazuki Kanda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.flamearche.androidinjectionsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import jp.flamearche.androidinjectionsample.databinding.ActivitySubBinding;
import jp.flamearche.androidinjectionsample.viewModel.SubActivityViewModel;

public class SubActivity extends AppCompatActivity {

    public static final String EXTRA_NAME_USER_NAME = "UserName";

    @Inject
    SubActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivitySubBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sub);
        binding.setViewModel(viewModel);
    }
}
