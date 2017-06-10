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

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jp.flamearche.androidinjectionsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ObservableField<String> userName = new ObservableField<>(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    public void onClickNext(View v) {
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra(SubActivity.EXTRA_NAME_USER_NAME, userName.get());
        startActivity(intent);
    }
}
